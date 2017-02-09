
/**
 * Description: This program will make a random number and you a limit amount
 * of tries to guess the number.
 * @Creater Dekart Kosa
 * @date 2/5/2017
 */
import java.util.Scanner;
import java.util.Random;
public class GuessingGame {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 205;
	private static final int QUIT_VALUE = -1;
	private static final int LOSE_VALUE = -2;
	private static final int MAX_GAMES = 2;
	private static final int MAX_GUESSES = 10;
	private static final int HINT_THRESHOLD = 5;
	private static final int BACKDOOR_VALUE = -314;

	private static final String NOPE_MSG = "nope...";
	private static final String NOPE_NOPE_MSG =
		"you've already guessed that wrong guess...";
	private static final String INVALID_INPUT_BEGIN =
		"*** invalid input -- ";
	private static final String INVALID_INPUT_LESS_MIN_MSG =
		INVALID_INPUT_BEGIN + "must be greater than " + (MIN_NUMBER - 1);
	private static final String INVALID_INPUT_GREATER_MAX_MSG =
		INVALID_INPUT_BEGIN + "must be less than " + (MAX_NUMBER + 1);
	private static final String INVALID_INPUT_YN_MSG =
		INVALID_INPUT_BEGIN + "must be n or y";
	private static final String WINNER_MSG =
		"you're a winner... # of guesses: ";
	private static final String LOSER_MSG =
		"too many guesses entered... the number was ";
	private static final String QUITTER_MSG =
		"you're a quitter... the number was ";
	private static final String MAX_GAMES_PLAYED_MSG =
		"you've played the maximum number (" + MAX_GAMES + ") of games";
	private static final String ENTER_GUESS_PROMPT =
		"enter a guess between " + MIN_NUMBER + " and " + MAX_NUMBER +
		" (" + QUIT_VALUE + " to quit): ";
	private static final String PLAY_AGAIN_PROMPT =
		"Do you want to play again (n or y)? ";

	private static final String BOLD_BEGIN = "*** ";
	private static final String BOLD_END = " ***";
	private static final String PLAY_MSG = " playing the CSC" + MAX_NUMBER +
		" guessing game." + BOLD_END;
	private static final String WELCOME_MSG =
		BOLD_BEGIN + "Hello! Have fun" + PLAY_MSG;
	private static final String THANKS_MSG =
		BOLD_BEGIN + "Thanks for" + PLAY_MSG;

	static Random rng = new Random(System.currentTimeMillis());
	static Scanner stdin = new Scanner(System.in);
	static Scanner scan = new Scanner(System.in);

	static int guess;
	static int numberOfGames = 0;
	static int numberOfWins = 0;
	static int numberOfLoses = 0;
	static boolean endStart = true; // Check if this boolean is used

	public static void main(String[] args) {

		PlayGame();
		PostGame();
		EndGame();
	}

	public static boolean check(int item, int[] chkarray){

		for (int i = 0; i < chkarray.length - 1; i++){
				if (chkarray[i] == item)
					return true;
			
		}

		return false;
	}
		
 public static void PlayGame() {

		int guessCounter = 0;
		int n = MIN_NUMBER + rng.nextInt(MAX_NUMBER);
		int[] history = new int[10];
		boolean found = false;
		
		System.out.println(WELCOME_MSG);
		boolean test = true;
		do{
			found = false;
			System.out.println();
			System.out.print(ENTER_GUESS_PROMPT);
			guess = stdin.nextInt();

			if (check(guess, history)){
				found = true;
	  	}

			history[guessCounter] = guess;
			guessCounter = guessCounter + 1;

			if(guess < MIN_NUMBER && guess != BACKDOOR_VALUE &&
					guess != QUIT_VALUE){
				if (found) {
					System.out.print(NOPE_NOPE_MSG + "\n");
					guessCounter--;
				} else { 
					System.out.println(INVALID_INPUT_LESS_MIN_MSG + "\n");
				}
			}

			if(guess > MAX_NUMBER){
				if (found) {
					System.out.print(NOPE_NOPE_MSG + "\n");
					guessCounter--;
				} else {
				System.out.println(INVALID_INPUT_GREATER_MAX_MSG + "\n");
				}
			}

			// Giving the user the answer
			if(guess == BACKDOOR_VALUE){
				System.out.println(n);
			}

			// Quiting the round and giving the chance to end the game
			if(guess == QUIT_VALUE){
				System.out.println((QUITTER_MSG + n) + "\n" +
						PLAY_AGAIN_PROMPT);
				numberOfLoses++;
				String val = scan.next();
				if(val.equalsIgnoreCase("y")){
					numberOfGames++;
					PlayGame();
				}

				if(val.equalsIgnoreCase("n")){
					System.out.println(THANKS_MSG);
					test = false;
					PostGame();
					break;
				}


			}

			// Correct guess on the last try
			if(guessCounter == MAX_GUESSES || guess == n){
				numberOfGames++;
				System.out.println(WINNER_MSG + guessCounter);
				numberOfWins++;
				System.out.println(PLAY_AGAIN_PROMPT);
				String val = scan.next();
				if(val.equalsIgnoreCase("y"))
					PlayGame();
				if(val.equalsIgnoreCase("n")){
					System.out.println(THANKS_MSG);
					test = false;
					PostGame();
					break;
				}
			}

			// Max games
			if(numberOfGames == MAX_GAMES){
				System.out.println(MAX_GAMES_PLAYED_MSG);
				test = false;
				PostGame();
				break;
			}

			// Max guesses
			if(guessCounter == MAX_GUESSES){
				numberOfGames++;
				System.out.println(LOSER_MSG+ n + "\n" +PLAY_AGAIN_PROMPT);
				numberOfLoses++;
				String val = scan.next();
				if(val.equalsIgnoreCase("y"))
					PlayGame();
				if(val.equalsIgnoreCase("n")){
					System.out.println(THANKS_MSG);
					test = false;
					PostGame();
					break;
				}
			}

			// Guessing in the range of the bonds
			if(guess > MIN_NUMBER || guess < MAX_NUMBER){
				if(guess != n){
					if (found) {
						System.out.print(NOPE_NOPE_MSG + "\n");	
						guessCounter -= 1;
					} else {
						System.out.print(NOPE_MSG);
					}
				}
				if(guess == n){
					numberOfGames++;
					System.out.println(WINNER_MSG + guessCounter);
					numberOfWins++;
					System.out.println(PLAY_AGAIN_PROMPT);
					String val = scan.next();
					if(val.equalsIgnoreCase("y"))
						PlayGame();
					if(val.equalsIgnoreCase("n")){
						System.out.println(THANKS_MSG);
						test = false;
						PostGame();
						break;
					}
				}
			}

			// Giving hints after 5 tries until the max # of guesses
			if(guessCounter == HINT_THRESHOLD ||
					guessCounter == (HINT_THRESHOLD + 1) ||
					guessCounter == (HINT_THRESHOLD + 2) ||
					guessCounter == (HINT_THRESHOLD + 3) ||
					guessCounter == (HINT_THRESHOLD + 4) ||
					guessCounter == (HINT_THRESHOLD + 5)){
				if(guess != n && guess > n){
					System.out.println(" lower");
				}
				if(guess != n && guess < n){
					System.out.println(" higher");
				}
			}

		}
		while(guess > MIN_NUMBER || guess < MAX_NUMBER);
	}

	// Post game information
	public static void PostGame() {
		int winningPct = 0;
		System.out.print("Played: " + numberOfGames + ";" +
				" Won: " +  numberOfWins + ";" +
				" Lost: " + numberOfLoses + ";");
		if(numberOfGames != 0){
			System.out.println(" winningPct: " +
					(winningPct = numberOfWins/numberOfGames));
		}
		else{
			winningPct =0;}
		EndGame();
	}

	// Ending the game
	public static void EndGame(){

	}

}
