/* The player object class. Player class houses the bets.
 * Player will have a set of cards in hands.
 * Player class has methods for card selection and card discard functions.
 * Player will be able to bet and will have a count of money availible to bet.
 *
 */

public class Player {
    public final static int MAX_CARD = 5;
    private Card cards[];
    private Card selectedCards[];
    private int bettings = 100;
    //constructor initializes 5 cards in each hand
    public Player() {
        cards = new Card[MAX_CARD];
	selectedCards = new Card[MAX_CARD]; 
    }
    //returns all the cards in hand
    public Card[] getCards() {
        return cards;
    }
    //get the cards at a particular position
    public Card getCardAtIndex(int index) {
        if (index >= 0 && index < MAX_CARD)
            return cards[index];
        else
            return null;
    }
   //sets the card at particular position
    public void setCardAtIndex(Card c, int index) {
        if(index >= 0 && index < MAX_CARD)
            cards[index] = c;
    }
    //get the selected card from selectedCards array
    public Card getSelectedCards(int index)
    {
        if(index >= 0 && index < MAX_CARD)
	    return selectedCards[index];
        else
            return null;
    }
    //selects cards and sets them in player's selectedCards array
    public Card selectCard(int index)
    {
	if (index>= 0 && index< MAX_CARD) {
	    selectedCards[index] = getCardAtIndex(index);
	    System.out.println(selectedCards[index].toString() + " has been selected.");
	    return selectedCards[index]; 
	}
	else
	    return null;
    }
    //deselects card from player's selectCards array
    public void deselectCard(int index)
    {
	if (index>= 0 && index< MAX_CARD) {
	    System.out.println(selectedCards[index].toString() + " has been deselected.");
	    selectedCards[index] = null;
	}
    }
} //end Player class
