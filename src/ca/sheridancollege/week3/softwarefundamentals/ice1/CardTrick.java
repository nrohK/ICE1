/*
 * Khorn Eleptico
 * 991598215
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author dancye
 */
public class CardTrick {
    
    public static void main(String[] args){
        Card[] magicHand = new Card[7];
        CardTrick cardtrick = new CardTrick();   
       
        //dealing random card and its suit, then putting the card in magicHand array
        cardtrick.dealing(magicHand);

        //insert code to ask the user for Card value and suit, create their card
        //cardtrick.userCard(magicHand);
        //replacing this to myLuckyCard;
        cardtrick.myLuckyCard(magicHand);
        
        //revealing the cards in the magicHand array
        cardtrick.result(magicHand); 
    }   //end of main
    
    void dealing(Card[] magicHand){
        for(int i = 0; i < magicHand.length; i++){
            Card c = new Card();
            magicHand[i] = c;
            
            //c.setValue(insert call to random number generator here
            c.setValue(cardGenerator());
            
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            c.setSuit(Card.SUITS[cardSuitGenerator()]);
        }   //end of loop
    }   //end of dealing
    
    int cardGenerator(){
        Random randomNumbers = new Random ();
        int unfoldedCards = randomNumbers.nextInt(13) + 1;
        return unfoldedCards;
    }   //end of randomNumberGenerator
    
    int cardSuitGenerator(){
       int unfoldedCardsSuit = (int)Math.round(Math.random()*3 );
        return unfoldedCardsSuit;
    }   //end of cardSuitGenerator
    
    void result(Card[] magicHand){
        System.out.println("Revealing cards in the magic hand . . .");
        for (int i=0; i<magicHand.length; i++){
            //unfolding cards and reveals
            System.out.println(magicHand [i]);
        }   //end of for loop
    }   //end of result
    
    void myLuckyCard(Card[] magicHand){
        //creating custom Card object called luckyCard
        Card luckyCard = new Card();
        
        //the luckyCard
        luckyCard.setValue(2);
        luckyCard.setSuit(Card.SUITS[3]);
        String theLuckyCard = luckyCard.toString();
        
        //introducing "The Lucky Card"
        System.out.println("The Lucky Card: ");
        System.out.println(theLuckyCard + "\n");
   
        // and search magicHand here
        boolean itsThere = false;
        for(int i = 0; i < magicHand.length;){
            magicHand[i].equals(luckyCard);
            if(magicHand[i].equals(luckyCard) == true ){ 
                itsThere = true;
                break;
            }
            else{
                i++;
            }
        }   //end of loop   
        if(itsThere){
            System.out.println("Lucky! Your card is there.\n" );
        } 
        else{
            System.out.println("Sorry not your lucky day.\n");
        }
    }   //end of userCard
    
}   //end of class
