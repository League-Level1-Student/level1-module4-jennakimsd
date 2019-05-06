import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JLabel label = new JLabel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		new TypingTutor().cool();
	}

	public void cool() {
		// 1. Create a frame for your typing game.
		frame.setVisible(true);
		frame.setTitle("Type or die");
		frame.add(label);
		frame.add(panel);
		panel.add(label);
		// 2. Create a member variable and initialize it as shown below:
		currentLetter = generateRandomLetter();
		// 3.Use a JLabel to show the value of currentLetter on the screen.
		// Make sure it changes every time you start the game.
		label.setText(currentLetter + "");

		// 4. Format the letter so that it is nice and big. Here are some hints….
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(label.CENTER);

		// 5. Add a key listener to the frame.
		frame.addKeyListener(this);
		frame.pack();
	}

	private static char generateRandomLetter() {
		Random randy = new Random();
		return (char) (randy.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char Pressed = e.getKeyChar();
		// 8. If they typed the currentLetter, print “correct”.
		// 9. If they typed the correct letter, set the frame background to green.
		// Otherwise set it to red.
		if (Pressed == currentLetter) {
			System.out.println("correct");
			panel.setBackground(Color.green);
		} else {
			panel.setBackground(Color.red);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 7. In the keyPressed method, print out the character that the user typed.
		char keyPressed = e.getKeyChar();
		System.out.println("you typed: " + keyPressed);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 6. Make the letter change every time a key is pressed.
		// To do that, in the keyReleased method:
		// i) Reset currentLetter.
		// ii) Update your JLabel.
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");

	}
}
