import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Difficulty implements ActionListener{
	JFrame diff;
	JButton easy;
	JButton medium;
	JButton hard;
	public void gameDifficulty(){
		easy = new JButton("EASY");
		medium = new JButton("MEDIUM");
		hard = new JButton("HARD");

		diff = new JFrame("DIFFICULTY");

		GridLayout gld = new GridLayout(3,1,10,10);

		diff.setSize(400,300);
		diff.setLocationRelativeTo(null);
		diff.setDefaultCloseOperation(diff.EXIT_ON_CLOSE);
		diff.setResizable(false);
		diff.setLayout(gld);

		easy.setBackground(Color.green);
		easy.setForeground(Color.black);

		medium.setBackground(Color.yellow);
		medium.setForeground(Color.black);

		hard.setBackground(Color.red);
		hard.setForeground(Color.black);

		diff.add(easy);
		diff.add(medium);
		diff.add(hard);

		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);

		diff.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == easy){
			Snake.choice = 30;
			diff.dispose();
			FirstWindow f = new FirstWindow();
			f.showWindow();
		}
		else if(e.getSource() == medium){

			Snake.choice = 20;
			diff.dispose();
			FirstWindow f = new FirstWindow();
			f.showWindow();
		}
		else if(e.getSource() == hard){
			Snake.choice = 10;
			diff.dispose();
			FirstWindow f = new FirstWindow();
			f.showWindow();
		}
	}

}
