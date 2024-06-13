public class WordleLetter {
	private char letter;
	private String color;

	public WordleLetter(char letterIn){
		this.letter = letterIn;
	}

	public WordleLetter(String colorIn){
		this.color = colorIn;
	}

	public void setColor(String colorIn){
		this.color = colorIn;
	}

	public boolean isColorSet(){
		
		return color != null; //checks if the color is set, whether it is null or not.
	}

	public boolean isGreen(){
		if(this.color.equals("green")){ //if the attribute color is "green", it will return true, else it will return false.
			return true;
		}

		return false;
	}

	public char getLetter() {
        return this.letter; //gets the attribute letter to be called with this getter.
    }

	public String toString() {
		/*	Determine the special characters to add at the beginning of the String
			to change the text color to the right color. */
		String colorCode;
		if(color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if(color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}
	
		/*	These are the special character to add 
			to the end of the String 
			to signify the end of the color change. */
		String resetCode = "\u001B[0m";

		/*  Surround the letter with space characters and with 
			the above color changing special characters. */ 
		return String.format(
			"%s %s %s",
			colorCode, letter, resetCode);
	}
}
