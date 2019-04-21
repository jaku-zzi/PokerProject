/* The main game code. 
 *
 *
 *
 *
 */

public class Game {

    private Player[] players;
    private Deck deck;

/*
 *   BEGIN MAIN GAME CODE
 *
 */
    public void main (String[] args){

	deck = new Deck();
	players = new Player[2];
	players[0] = new Player();
	players[1] = new Player();
	deck.shuffle();
    }


    //simulates the game and shows the result


}//end of Game class
