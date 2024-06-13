import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {

  public static String getAnswerForPuzzleNumber(int puzzleNumber) {
    try {
      Scanner scanner = new Scanner(new File("answers.txt"));

      for (int i = 0; i < puzzleNumber; i++) {
        scanner.next();
      }

      /* Return the very next word */ 
      return scanner.next();

    } catch (Exception e) {
      /* Handle exception */
      System.out.println("Input/File not found!");
    }
    return null;
  }

public static boolean checkInDictionary(String proposed) {
    try {
        /* File scanner to read dictionary.txt */
        Scanner scanner = new Scanner(new File("dictionary.txt"));

        while (scanner.hasNextLine()) { //while the file as a next line, it will repeat the loop.
            String line = scanner.nextLine().trim(); //Saves the file line to variable line.
            if (proposed.equals(line)) { //if the user proposal is in the dictionary.txt, it will return true.
                return true;
            }
        }
    } catch (FileNotFoundException e) {
        /* Handle file not found exception */
        System.out.println("Dictionary file not found!");
    }
    return false; //else itll return false.
  }
}
