/* The player object class. Player class houses the bets.
 * Player will have a set of cards in hand.
 * Player class has methods for card selection and card discard functions.
 * Player will be able to bet and will have a count of money availible to bet.
 *
 */

public class Player {
    public final static int MAX_CARD = 5;
    private Card cards[];
    private int bettings = 100;
    //constructor initializes 5 cards in each hand
    public Player() {
        cards = new Card[MAX_CARD];
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
} //end Player class
