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
        cardtrick.userCard(magicHand);
        
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
    
    void userCard(Card[] magicHand){
        //prompting the user
        System.out.println("Pick a card: ");
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a number between 1 to 13: ");
        int card = sc.nextInt();
        System.out.println("Pick a number:\n\"1: Hearts\"\n\"2: Diamonds\"\n\"3: Spades\"\n\"4: Clubs\"");
        sc.nextLine();
        int cardSuit = sc.nextInt();
        sc.close();     
        //creating a card for user
        Card chosenUserCard = new Card();
        chosenUserCard.setValue(card);
        chosenUserCard.setSuit(Card.SUITS[cardSuit - 1]);
        //displaying the user's card
        System.out.println("Your card:\n" + chosenUserCard.toString() + "\n\nLet's see if your card is in the magic hand . . .");
        // and search magicHand here
        boolean itsThere = false;
        for(int i = 0; i < magicHand.length;){
            //testing
            magicHand[i].equals(chosenUserCard);
            
            if(magicHand[i].equals(chosenUserCard) == true ){ 
                itsThere = true;
                break;
            }
            else{
                i++;
            }
        }   //end of loop   
        if(itsThere){
            System.out.println("Your card is there.\n" );
        } 
        else{
                System.out.println("Sorry not your lucky day.\n");
        }
    }   //end of userCard
    
}   //end of class
