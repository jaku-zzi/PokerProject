/*
 * Gamelogic and rules for the game.
 *
 *
 *
 */

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

    //deals the card to each player
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
            System.out.print("Player " + (i + 1) + ": ");
            System.out.println("");
            for (int j = 0; j < players[0].getCards().length; j++) {
                System.out.print("{" + players[i].getCardAtIndex(j).toString()+"} ");
                
            }
        }
    }
}//end of class
