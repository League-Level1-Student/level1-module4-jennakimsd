import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nastySurprise implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trick = new JButton();
	JButton treat = new JButton();

	public static void main(String[] args) {
		new nastySurprise().createUI();
	}

	private void createUI() {
		frame.add(panel);
		frame.setVisible(true);
		trick.setText("trick");
		treat.setText("treat");
		trick.addActionListener(this);
		treat.addActionListener(this);
		panel.add(trick);
		panel.add(treat);
		frame.pack();
		frame.setTitle("Nasty Surprise");
	}

	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == trick) {
			showPictureFromTheInternet(
					"https://www.cheatsheet.com/wp-content/uploads/2017/10/corgi-dog-puppies.jpg");
		}

		if (buttonPressed == treat) {
			showPictureFromTheInternet("https://images-na.ssl-images-amazon.com/images/I/61Ih1NRqt5L._SX425_.jpg");
		}
	}
}
