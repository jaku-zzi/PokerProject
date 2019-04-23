/*
 * Gamelogic and things based on rules for the game.
 * evaluateHand() will assess the value of a given hand
 * through an integer value return.
 */

import java.util.*;

public class Gamelogic {
    private Player[] players;
    private Deck deck;
    //constructor initializes the deck and cards
    public Gamelogic() {
	deck = new Deck();
	players = new Player[2];
	players[0] = new Player();
	players[1] = new Player();
	deck.shuffle();
    }

    public void dealCards() {
	int count = 0;
	for (int i = 0; i < players[0].getCards().length; i++) {
	    for (int j = 0; j < players.length; j++) {
		players[j].setCardAtIndex(deck.getCard(count++), i);
	    }
	}
    }
    //simulates the game and shows the result
    public void showCards() {
	for (int i = 0; i < players.length; i++) {
	    System.out.println(" ");
	    System.out.print("Player " + (i + 1) + ": ");
	    System.out.println(" ");
	    for (int j = 0; j < players[0].getCards().length; j++) {
		System.out.println("{" + players[i].getCardAtIndex(j).toString()+"} ");

	    }
	}
    }
    //exhanges selectedCards for new one's from the deck, gets rid of selectedcards, updates
    //hand, and prints whether cards have been exchanged or not.
    public void exchangeCards(int playerIndex) {
	int x = playerIndex;
	int count = 0;
	boolean exchange = false;
	
	for (int index=0; index < Player.MAX_CARD; index++) {
	    if (players[x].getSelectedCards(index) != null)
	    {
		players[x].setCardAtIndex(deck.getCard(count++), index);	
		players[x].deselectCard(index);
		exchange = true;
	    }
	}//end scan loop
	if (exchange == false)
	    System.out.println("No cards were selected for exhange!");
	else if (exchange == true) 
	    System.out.println("Cards were exchanged!");
    }

    //evaluates hands of a player based on common Poker hands 
    public int evaluateHand(int x) {
	int playerIndex = x;
	int playerNumber = playerIndex +1;

	//for handtype evaluations - a score from 0 to 900 with 900 being a royal flush
	int handType = 0;
	//for highcard evaluations - appended to handType to resolve high card disputes
	int highCard = 0;


	// arrays for pair analysis for pairs, three of a kind, flushes, etc.
	// faceArray     <- array handles 13 types of card faces, with 2 at index zero
	// suitArray     <- array inputs suits with 'Clubs' at index zero and 'Spades', 'Hearts', and 
	//			'Clubs' respectively followed.
	int[] faceArray = new int[13];
	int[] suitArray = new int[4];

	System.out.println(" ");
	System.out.println("EvaluateHands() Player " + playerNumber + " testing: ");
	System.out.println(" ");

	//parses cards and throws into analysisArray
	for (int j = 0; j < players[0].getCards().length; j++) {
	    String face = players[playerIndex].getCardAtIndex(j).getFace();
	    String suit = players[playerIndex].getCardAtIndex(j).getSuit();
	    switch (face)
	    {
		case "2":
		    ++faceArray[0];
		    break;
		case "3":
		    ++faceArray[1];
		    break;
		case "4":
		    ++faceArray[2];
		    break;
		case "5":
		    ++faceArray[3];
		    break;
		case "6":
		    ++faceArray[4];
		    break;
		case "7":
		    ++faceArray[5];
		    break;
		case "8":
		    ++faceArray[6];
		    break;
		case "9":
		    ++faceArray[7];
		    break;
		case "10":
		    ++faceArray[8];
		    break;
		case "Jack":
		    ++faceArray[9];
		    break;
		case "Queen":
		    ++faceArray[10];
		    break;
		case "King":
		    ++faceArray[11];
		    break;
		case "Ace":
		    ++faceArray[12];
		    break;
	    }

	    switch (suit)
	    {
		case "Clubs":
		    ++suitArray[0];
		    break;
		case "Spades":
		    ++suitArray[1];
		    break;
		case "Hearts":
		    ++suitArray[2];
		    break;
		case "Diamonds":
		    ++suitArray[3];
		    break;
	    }

	}

	// analyze the facearray
	for (int i=0; i<=12; i++)
	{
	    // handle for four of a kind
	    if (faceArray[i] == 4) {
		handType = 700;
		highCard = i;

		//testing
		System.out.println("Four of a Kind!");

		break;
	    }

	    // handle for three of a kind or pairs and scan for additional pair or three of a kind
	    // for handling a 'full house'
	    else if (faceArray[i] == 3 || faceArray[i] == 2) {

		//sets for highcard value regardless of pair or three of a kind 

		highCard = i;

		//searches for other pairs or three of a kind
		for (int j=i+1; j<12; j++) {
		    int scan;

		    if (faceArray[j] == 2 || faceArray[j] == 3) { 

			//sets new highcard if not three of a kind
			if (faceArray[i] != 3) highCard = j;

			//sets new scan values
			scan =  faceArray[i] + faceArray[j];

			if (scan == 5) {
			    //testing
			    System.out.println("Full house");
			    handType = 600;
			}
			if (scan == 4) {
			    //testing
			    System.out.println("Two Pairs");
			    handType = 200;
			}
		    }
		}
		    //check scan value to set handType
		if (handType == 0 && faceArray[i] == 3) {
			//testing
			System.out.println("Three of a Kind");
			handType = 300;
			break;
		    }
		else if (handType ==0 && faceArray[i] == 2) {
			//testing
			System.out.println("Pair");
			handType = 100;
			break;
		    }
	    }
	    else if (i <=8 && faceArray[i] == 1 && faceArray[i+1] == 1 && faceArray[i+2] == 1  && faceArray[i+3] == 1 && faceArray[i+4] == 1) {
		highCard = i+4;
		handType = 400;
		System.out.println("Straight");
		break;
	    }
	    else if (faceArray[i] == 1) {
		highCard = i;
	    }
	}
	//analyze the suitArray
	for (int y=0; y<=3; y++){
	    if (suitArray[y] == 5 && handType == 400){
		handType = 900;
		//testing
		System.out.println("Royal Flush");
	    }
	    if (suitArray[y] == 5){
		handType = 500;
		System.out.println("Flush");
	    }
	} 

	    //total handValue
	    int handValue = handType + highCard;
	    //testing
	    System.out.println(Arrays.toString(faceArray));
	    System.out.println(Arrays.toString(suitArray));
	    System.out.println("Hand value: " + handValue);
	    return handValue; 
	}

    }//end of class
