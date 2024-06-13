
public class WordleGame {
  /* allGuesses represents the wordle game */
  private WordleLetter[][] allGuesses = new WordleLetter[6][5];

  int numGuesses = 0; //sets initial number of guesses to 0.

  String answer; //answer does not need an initial value because it will be changed a lot.
  String userGuess = ""; 

  public WordleGame(){ //default WordleGame constructor

  }

  public WordleGame(int puzzleNumber){
    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber); //Takes the answer based on the user selection (puzzleNumber) and saves the answer to attribute answer for this WordleGame
  }

  public String getAnswer(){
    return this.answer; //This method returns the answer of this WordleGame's attribute.
  }

  public void setGuess(String guessIn){
    this.userGuess = guessIn; //Sets the Guess of the user into the attribute userGuess.
  }

  public String getGuess(){
    return this.userGuess; //Gets the Guess of the user from the attribute userGuess.
  }

  public void guessWord(String guessWord){
    String colors = ""; // gives colors an initial value.
    for (int i = 0; i < 5; i++) { //for loop iterates through the the guessWord, and his a condition of less than 5 because the index of a word with 5 letters starts at 0, thus 5 is the length of a 5 letter word.
        char guessChar = guessWord.charAt(i); //Saves the character at i from guessWord into guessChar, and repeats this until it reaches the condition.
        char answerChar = answer.charAt(i); //Saves the character at i from this WordleGames answer and saves it to answerChar, and repeats this untill it reaches the condition.
        if (guessChar == answerChar) { //if guessChar equals to answerChar, then that means the letter is in the right placec at iteration i, and saves it to String variable colors.
            colors = "green";
        } else if (answer.contains(String.valueOf(guessChar))) { //else if the full answer contains the String value of guessChar, this means that the letter in guessChar from the user guess exists somewhere in the answer, but is not in the correct position. Thus saves the color as "yellow"
            colors = "yellow";
        } else { //else, if guessChar does not equal answerChar, or does not exist in the full answer at all, then that means the letter doesn't exist in the answer, thus color is set to "red"
            colors = "red";
        }
        allGuesses[numGuesses][i] = new WordleLetter(guessChar); //creates a new object WordleLetter with the char letter from guessChar and saves it at numGuesses, which determines which row it is at, based off which guess the user is in. It also saves it at the each iteration of i in that row.
        allGuesses[numGuesses][i].setColor(colors); //sets the color attribute of this WordleLetter to whatever String variable colors is saved as from the method in WordleLetter.
    }
    numGuesses++; //after iterating through the guessWord, increments numGuesses by 1, indicating the next guess attempt the user is at.
  }

  public int getNumberGuessesSoFar() {       
    return numGuesses; //returns the number of guesses so far.
    }

  public WordleLetter[] getGuess(int guessNumber) {
    return allGuesses[guessNumber]; //returns the WorldeLetter array based of the guessNumber.
    }

  public boolean isGameOver(){
    return numGuesses == 6 || isGameWin(); //checks if the game is won if numGuesses is exactly 6, or if the method isGameWin() is true.
  }

  public boolean isGameWin(){
    
    return this.userGuess.equals(this.answer); //returns a boolean value based off the result if the userGuess equals the correct answer.
  }





  public String toString() {
    /* result will be used to build the full answer String */ 
    String result = ""; 
       /* for each word guessed so far */ 
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
         /* get each letter of each word */
      for (int j = 0; j < 5; j++) {
           /* concatenate it to the result */ 
           /* WordleLetter's toString() is automatically invoked here. */
        result += getGuess(i)[j];
      }
         /* new line separator between each word */ 
      result += "\n";
    }
    return result;
  }
}
