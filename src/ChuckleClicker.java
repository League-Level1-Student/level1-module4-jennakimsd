import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JPanel panel= new JPanel();
	JButton joke= new JButton();
	JButton punchline= new JButton();
	JFrame frame= new JFrame();
	//1. Make a ChuckleClicker class with a main method and a makeButtons() method. 
	//Open a pop-up that shows the message "Make Buttons" 
	//in the makeButtons method, to prove that it is working.
	//(You will need to instantiate your class before you can call the method). 
public static void main(String[] args) {
	ChuckleClicker cool= new ChuckleClicker();
	cool.makeButtons();
}

public void makeButtons(){
	//2. Now change the makeButtons() method, 
	//to make a JFrame and get it to show. 
	frame.setVisible(true);
	//3. Add a JPanel and two JButtons to the frame
	panel.add(joke);
	panel.add(punchline);
	frame.add(panel);
	//4. Make a pop-up that says “hi” when either of the buttons are pressed. 
	//You will need to add listeners to the buttons for this to work. 
	joke.addActionListener(this);
	punchline.addActionListener(this);
	joke.setText("joke");
	punchline.setText("punchline");
	frame.pack();
}

@Override
public void actionPerformed(ActionEvent e) {
	JButton buttonPressed = (JButton) e.getSource();
	if(buttonPressed== joke) {
		JOptionPane.showMessageDialog(null, "why do we tell actors to 'break a leg'");
	}
	else {
		JOptionPane.showMessageDialog(null, "becuase every play has a cast");
	}
	
}
}
