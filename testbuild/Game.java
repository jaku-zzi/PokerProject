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
    public static void main (String[] args){
	System.out.println("------------------------");
	Gamelogic game = new Gamelogic();
//testing hands of cards
	game.dealCards();
	game.showCards();
	game.evaluateHand(0);
	game.evaluateHand(1);
	System.out.println("------------------------");
    }


    //simulates the game and shows the result


}//end of Game class
