import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FirstWindow implements ActionListener {

	JPanel upper,lower;

	JButton play, difficulty, scores, exit, easy, medium, hard;

	JLabel imageLabel = new JLabel();

	JFrame window = new JFrame("Snake");
	JFrame diff;

	Difficulty d = new Difficulty();

	public FirstWindow(){

		upper = new JPanel();
		lower = new JPanel();

		play = new JButton("PLAY");
		difficulty = new JButton("DIFFICULTY");
		scores = new JButton("SCORES");
		exit = new JButton("EXIT");

		ImageIcon icon = new ImageIcon("Image//Background.jpg");

		imageLabel = new JLabel();
		imageLabel.setIcon(icon);
	}

	public void initUpperPanel(){

		upper.add(imageLabel);			

	}

	public void initLowerPanel(){

		GridLayout lowerLayout = new GridLayout(2,2,10,10);
		lower.setLayout(lowerLayout);

		lower.add(play);
		lower.add(difficulty);
		lower.add(scores);
		lower.add(exit);

		play.setBackground(Color.red);
		play.setForeground(Color.white);

		difficulty.setBackground(Color.red);
		difficulty.setForeground(Color.white);

		scores.setBackground(Color.red);
		scores.setForeground(Color.white);

		exit.setBackground(Color.red);
		exit.setForeground(Color.white);

		play.addActionListener(this);
		difficulty.addActionListener(this);
		scores.addActionListener(this);
		exit.addActionListener(this);

	}



	public void showWindow(){

		initUpperPanel();
		initLowerPanel();

		window = new JFrame();

		window.setLayout(null);
		window.setSize(800, 700);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);


		upper.setBounds(0, 0, 800, 500);
		lower.setBounds(0,500, 800, 150);

		window.add(upper);
		window.add(lower);

		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}


	public void actionPerformed(ActionEvent e){

		if(e.getSource() == play){
			window.dispose();
			Snake.snake = new Snake();		
		}
		else if(e.getSource() == difficulty){
			window.dispose();
			d.gameDifficulty();
		}
		else if(e.getSource() == scores){
			window.dispose();
			ScoreDisplay.scoreRead("Score//Score.txt");
		}
		else if(e.getSource() == exit){
			window.dispose();
		}


	}


}
