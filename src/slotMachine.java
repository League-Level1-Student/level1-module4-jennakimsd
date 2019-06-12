import java.net.MalformedURLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Each "reel" of the slot machine will randomly display one of 3 images you have chosen 
//(you can add more images later if there is time).
//Put a "SPIN" button onto the frame that causes each of the 3 "reels" to 
//randomly change the image they are showing.
//If all 3 reels have the same image showing (like in the picture above),
//the player wins. Display a "YOU WIN" message, optionally add a sound of success. 
public class slotMachine {
	JFrame frame=  new JFrame();
	JPanel panel= new JPanel();
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JButton button= new JButton();
	
	public static void main(String[] args) {
		new slotMachine().createUI();
	}
	private void createUI() {
		frame.add(panel);
		panel.add(button);
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
}
