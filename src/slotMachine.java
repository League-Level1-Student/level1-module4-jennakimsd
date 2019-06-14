import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Each "reel" of the slot machine will randomly display one of 3 images you have chosen 
//(you can add more images later if there is time).
//Put a "SPIN" button onto the frame that causes each of the 3 "reels" to 
//randomly change the image they are showing.
//If all 3 reels have the same image showing (like in the picture above),
//the player wins. Display a "YOU WIN" message, optionally add a sound of success. 
public class slotMachine implements ActionListener {
	JFrame frame=  new JFrame();
	JPanel panel= new JPanel();
	JButton button= new JButton();
	
	public static void main(String[] args) {
		new slotMachine().createUI();
	}
	private void createUI() {
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
		button.setText("SPIN TO WIN!!");
		try {
			panel.add(createLabelImage("cherry.jpg"));
			panel.add(createLabelImage("orange.jpg"));
			panel.add(createLabelImage("grape.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
		frame.setTitle("slot machine");
		frame.pack();
	}
	
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        java.net.URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		Random randy= new Random();
		frame.remove(panel);
		panel= new JPanel();
		frame.add(panel);
		panel.add(button);
		int cherry= 0;
		int orange= 0;
		int grape= 0;
		for (int i = 0; i < 3; i++) {
			int slot= randy.nextInt(3);
			if (i==0) {
				cherry=slot;
			}
			if (i==1) {
				orange=slot;
			}
			if (i==2) {
				grape=slot;
			}
			if (slot==0) {
				try {
					panel.add(createLabelImage("cherry.jpg"));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(slot==1) {
			try {
				panel.add(createLabelImage("orange.jpg"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			else {
			try {
				panel.add(createLabelImage("grape.jpg"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		} 
		frame.pack();
		if (cherry==orange && orange==grape) {
			JOptionPane.showMessageDialog(null, "YOU WIN!");
		}
	}
}
