import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton moleButton= new JButton("mole!");
	int moleWacked = 0;
	Date timeAtStart = new Date();
	
	public static void main(String[] args) {
		new WackAMole().createUI();
	}

	private void createUI() {
		Random random = new Random();
		int moleLocation = random.nextInt(24);
		for(int i= 0; i<23; i++) {
			if(i==moleLocation) {
				moleButton.addActionListener(this);
				panel.add(moleButton);	
			}
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
			}	
		frame.add(panel);
		frame.setVisible(true);
		frame.setTitle("Wack A Mole!!");
		frame.setSize(new Dimension (300,300));
	}
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed==moleButton) {
			frame.dispose();
			createUI();
			moleWacked++;
			if(moleWacked==10) {
				endGame(timeAtStart,10);
			}
		}
		else {
			speak("STUPID THAT IS THE WRONG BUTTON!");
		}
	}
	
}
