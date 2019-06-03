import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JTextField textfield = new JTextField(10);

	public static void main(String[] args) {
		new GetLatestTweet().createUI();
	}

	//1. Make a UI (User Interface) with a button and a text field for the search term (see below).

	private void createUI() {
		frame.add(panel);
		frame.setVisible(true);
		button.setText("Search the Twitterverse");
		button.addActionListener(this);
		panel.add(textfield);
		panel.add(button);
		frame.setTitle("Get Latest Tweet");
		frame.pack();
	}

		
	//2. When the "Search" button is clicked, print "Tweet, Tweet".
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("tweet, tweet");
		System.out.println(getLatestTweet(textfield.getText()));
	}

	//3.Download 2 jars, add them to your project, then add them to your project’s build path.

	//4. Use this method to get the latest tweet when the user clicks the button. Print the tweet to the console.
	//Make sure you import from twitter4j
	

	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}


	//5. Now display the contents of the latest tweet on the User Interface.
	
	}
