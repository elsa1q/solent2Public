/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.ood.creditcardchecker.client.test.manual;

import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.ood.creditcardchecker.client.CardCheckerClient;
import org.solent.ood.creditcardchecker.model.dto.CreditCard;
import solent.ac.uk.ood.examples.cardcheck.CardValidationResult;

/**
 *
 * @author cgallen
 */
public class CardCheckerClientTest {

    @Test
    public void testGetClient() {

        CardCheckerClient cardCheckerClient = new CardCheckerClient("http://localhost:8080/creditcardchecker-web");

        boolean isValid = cardCheckerClient.getCheckCard("4444444444444448");
        assertTrue(isValid);

        isValid = cardCheckerClient.getCheckCard("4444444444444449");
        assertFalse(isValid);

    }

    @Test
    public void testPostClient() {

        CardCheckerClient cardCheckerClient = new CardCheckerClient("http://localhost:8080/creditcardchecker-web");
        CreditCard creditCard = new CreditCard();
        creditCard.setCardnumber("5133880000000012");
        creditCard.setCvv("123");
        creditCard.setEndDate("11/21");
        creditCard.setIssueNumber("01");
        creditCard.setName("test user1");
        
        CardValidationResult cardvalidationResult = cardCheckerClient.postCheckCard(creditCard); 
        boolean isValid = cardvalidationResult.isValid();
        assertTrue(isValid);
        
        
        
        
       
        
         
        
        
        //payload { "name" : "test user1", "endDate" : "11/21", "cardnumber" :  "5133880000000012", "cvv" : "123", "issueNumber" : "01" }
        
        
       //  public boolean isValid() {
        // return valid;

        // TODO WRITE A TEST TO CHECK THE POST CLIENT
        // creditCard.getCardnumber());

    }

}
