import java.util.Scanner;

//Wordle Game

public class Main {

    public static WordleGame startGame(Scanner scanner)  {
       System.out.println("Enter an integer for a word to guess in this Wordle Game (0-2315");
       int puzzleNumber = scanner.nextInt(); //waits for user input int from scanner and saves it to variable puzzleNumber
       WordleGame game = new WordleGame(puzzleNumber); //creates a new WordleGame based off the puzzleNumber the user chooses.
       return game; //returns object game

    }

    public static void playGame(Scanner scanner, WordleGame game)  {
    boolean validWord = false; //sets boolen validWord as false for an initial value.
    boolean gameOver = false; //sets boolen gameOver as false for an initial value.
    while(!game.isGameOver()){ //acceses and checks if the game created from the startGame method is over, and if true, will exit the loop, while if false will repeat the loop.
        System.out.println("Enter a 5 letter word: ");
        String userGuess = scanner.next(); 
        validWord = WordBank.checkInDictionary(userGuess); //checks if the input taken from scanner in userGuess is a valid word from the dictionary through the WordBank class.
        if (!validWord) {
            System.out.println("Word not found in dictionary"); //if it isn't a valid word, it will print this out, and ask the user for another valid word.
        } else {
            game.guessWord(userGuess); // Add the guessed word to the game
            game.setGuess(userGuess); //sets the guess attribute to the game
            System.out.println(game.toString()); //prints out the word entered through the toString method in the WordleGame class, with colors.
            if(game.getGuess().equals(game.getAnswer())){ //checks if the guess equals the answer, in which case the correct word is guessed and it will break from the loop.
                break;
            }
        }
        
       
        }
        
    }

    public static void reportGameOutcome(WordleGame game) {
        if(game.isGameWin()){
            System.out.println("Congratulations! You guessed the correct word!"); //checks if the game is won by correctly guessing the word, and prints this out. It checks this first to ensure that if the user guessed correctly, it will print this first.
        }else if(game.isGameOver()){
            System.out.println("You have used all your guesses. Here is the correct answer: " + game.getAnswer()); //if the correct word is not guessed, this means that the user has used up all their guesses, and it prints this out as well as the correct answer from the WordleGame.
        }
    }

    /* main method body. */ 
    public static void main(String[] args) {
        /* Only use this Scanner for user input, do not create new ones via new Scanner(System.in).*/ 
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
