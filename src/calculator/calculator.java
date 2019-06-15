package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator implements ActionListener {
	JFrame frame= new JFrame();
	JPanel panel= new JPanel();
	JTextField textfield = new JTextField(5);
	JTextField textfield2 = new JTextField(5);
	JButton add = new JButton();
	JButton subtract= new JButton();
	JButton multiply = new JButton();
	JButton divide= new JButton();
	public void run() {
		frame.add(panel);
		panel.add(textfield);
		panel.add(textfield2);
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		add.setText("add");
		subtract.setText("subtract");
		multiply.setText("multiply");
		divide.setText("divide");
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void add(int num, int num2) {
		JOptionPane.showMessageDialog(null, num + num2);
	}
	public void subtract(int num, int num2) {
		JOptionPane.showMessageDialog(null, num - num2);
	}
	public void multiply(int num, int num2) {
		JOptionPane.showMessageDialog(null, num*num2);
	}
	public void divide(int num, int num2) {
		JOptionPane.showMessageDialog(null, num/num2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text1 = textfield.getText();
		int number1= Integer.parseInt(text1);
		String text2 = textfield2.getText();
		int number2= Integer.parseInt(text2);
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed==add) {
			add(number1, number2);
		}
		if(buttonPressed==subtract) {
			subtract(number1, number2);
		}
		if(buttonPressed==multiply) {
			multiply(number1, number2);
		}
		if(buttonPressed== divide) {
			divide(number1, number2);
		}
	}
}
