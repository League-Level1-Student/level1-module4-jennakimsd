import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor {
public static void main(String[] args) {
	//1. Create a frame for your typing game.
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setTitle("Type or die");
	//2. Create a member variable and initialize it as shown below:
		char currentLetter;
		currentLetter = generateRandomLetter();
	//3.Use a JLabel to show the value of currentLetter on the screen. 
	//Make sure it changes every time you start the game.
		JLabel label= new JLabel();
	//4. Format the letter so that it is nice and big. Here are some hints….
		//jLabel.setFont(jLabel.getFont().deriveFont(28.0f));
		//jLabel.setHorizontalAlignment(JLabel.CENTER);
		
	//5. Add a key listener to the frame.

	//6. Make the letter change every time a key is pressed.
		//To do that, in the keyReleased method:
			//i) Reset currentLetter.
			//ii) Update your JLabel.
		
	//7. In the keyPressed method, print out the character that the user typed.
		
	//8. If they typed the currentLetter, print “correct”.

	//9. If they typed the correct letter, set the frame background to green. Otherwise set it to red.

}

private static char generateRandomLetter() {
		Random randy = new Random();
		return (char) (randy.nextInt(26) + 'a');
	}
}

