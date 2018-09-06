import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class ScoreDisplay implements ActionListener{
	JFrame window = new JFrame("Score");

	JLabel name, score, empty;	
	JButton done;
	JTextField nameT, scoreT;
	GridLayout gl = new GridLayout(3,2,10,10);
	int s;
	static ArrayList previousScores;
	
	public ScoreDisplay(int s){
		this.s = s;
		previousScores = new ArrayList();
	}

	public void showWindow(){
		name = new JLabel("NAME");
		score = new JLabel("SCORE");
		empty = new JLabel();
		
		done = new JButton("DONE");
		
		nameT = new JTextField();
		scoreT = new JTextField();
		scoreT.setText(s + "");
		window.setSize(300,150);
		window.setLayout(gl);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);

		window.add(name);
		window.add(nameT);
		window.add(score);
		window.add(scoreT);
		window.add(empty);
		window.add(done);

		done.addActionListener(this);
		window.setVisible(true);
	}
	public void showMecessage(){
		JOptionPane.showMessageDialog(null, "If you want to play again, press space");
	}

	public static void scoreWrite(String data){

		File file = new File("Score//Score.txt");

		try{
			FileWriter fw = new FileWriter(file,true);
			fw.write(data);
			fw.close();

		}
		catch(Exception e){

			System.out.println(e.getMessage());
		}


	}
public static void scoreRead(String path){
		
		
		
		try{
			File file = new File(path);	
			Scanner input = new Scanner(file);
			
			while(input.hasNextLine()){
				String n = input.nextLine();
				String sc = input.nextLine();
				Score temp = new Score(n, Integer.parseInt(sc));
				previousScores.add(temp);
				JOptionPane.showMessageDialog(null,temp);
				System.out.println(temp);
			}
			
			
			input.close();
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == done){
			scoreWrite(nameT.getText()+"\n"+scoreT.getText()+"\n");
			window.dispose();
			showMecessage();
		}
	}
}
