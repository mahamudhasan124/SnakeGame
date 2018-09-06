
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class Snake implements ActionListener, KeyListener
{

	public static Snake snake;
	public static int score = 0, choice = 40;
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
	public int ticks = 0, direction = DOWN,  tailLength = 10, time;
	public boolean over = false, paused;
	public JFrame jframe;
	public SnakePanel snakePanel;
	public Timer timer = new Timer(choice, this);
	public ArrayList<Point> snakeParts = new ArrayList<Point>();
	public Point head, food;
	public Random random;
	public Dimension dim;
	public Snake()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.add(snakePanel = new SnakePanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}

	public void startGame()
	{
		over = false;
		paused = false;
		time = 0;
		score = 0;
		tailLength = 4;
		ticks = 0;
		direction = DOWN;
		head = new Point(0, -1);
		random = new Random();
		snakeParts.clear();
		food = new Point(random.nextInt(79), random.nextInt(66));
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		snakePanel.repaint();
		ticks++;

		if (ticks % 2 == 0 && head != null && !over && !paused)
		{
			time++;

			snakeParts.add(new Point(head.x, head.y));

			if (direction == UP)
			{
				if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1))
				{
					head = new Point(head.x, head.y - 1);
				}
				else
				{
					over = true;
					Sound.gameOver();
					ScoreDisplay s = new ScoreDisplay(Snake.score);				
					s.showWindow();
				}
			}

			if (direction == DOWN)
			{
				if (head.y + 1 < 67 && noTailAt(head.x, head.y + 1))
				{
					head = new Point(head.x, head.y + 1);
				}
				else
				{
					over = true;
					Sound.gameOver();
					ScoreDisplay s = new ScoreDisplay(Snake.score);
					s.showWindow();
				}
			}

			if (direction == LEFT)
			{
				if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y))
				{
					head = new Point(head.x - 1, head.y);
				}
				else
				{
					over = true;
					Sound.gameOver();
					ScoreDisplay s = new ScoreDisplay(Snake.score);
					s.showWindow();
				}
			}

			if (direction == RIGHT)
			{
				if (head.x + 1 < 80 && noTailAt(head.x + 1, head.y))
				{
					head = new Point(head.x + 1, head.y);
				}
				else
				{
					over = true;
					Sound.gameOver();
					ScoreDisplay s = new ScoreDisplay(Snake.score);
					s.showWindow();
				}
			}

			if (snakeParts.size() > tailLength)
			{
				snakeParts.remove(0);

			}
			if (food != null)
			{
				if (head.equals(food))
				{
					Sound.eatSound();
					score += 10;
					tailLength++;
					food.setLocation(random.nextInt(79), random.nextInt(66));
				}
			}
		}
	}

	public boolean noTailAt(int x, int y)
	{
		for (Point point : snakeParts)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}


	@Override
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT)
		{
			direction = LEFT;
		}
		if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT)
		{
			direction = RIGHT;
		}
		if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN)
		{
			direction = UP;
		}
		if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP)
		{
			direction = DOWN;
		}
		if (i == KeyEvent.VK_SPACE)
		{
			if (over)
			{
				startGame();
			}
			else
			{
				paused = !paused;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}