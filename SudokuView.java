import java.awt.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.IOException;

public class SudokuView extends JPanel implements Border {
	public JTextField[][] index = new JTextField[9][9];
	
	private ImageIcon clearImage = new ImageIcon("V:\\An2sem1\\JAVA\\MyProject\\src\\clear.png");
	private ImageIcon checkImage = new ImageIcon("V:\\An2sem1\\JAVA\\MyProject\\src\\check.png");
	private ImageIcon solveImage = new ImageIcon("V:\\An2sem1\\JAVA\\MyProject\\src\\solve.png");
	private ImageIcon newgameImage = new ImageIcon("V:\\An2sem1\\JAVA\\MyProject\\src\\newgame.png");

	private JButton checkBtn = new JButton("Check", checkImage);
	private JButton clearBtn = new JButton("Clear", clearImage);
	private JButton new_gameBtn = new JButton("New Game", newgameImage);
	private JButton solveBtn = new JButton("Solve", solveImage);
	public JPanel board;
	public int[][] exemplu = new int[][] { { 0, 2, 6, 0, 0, 0, 8, 1, 0 }, { 3, 0, 0, 7, 0, 8, 0, 0, 6 },
			{ 4, 0, 0, 0, 5, 0, 0, 0, 7 }, { 0, 5, 0, 1, 0, 7, 0, 9, 0 }, { 0, 0, 3, 9, 0, 5, 1, 0, 0 },
			{ 0, 4, 0, 3, 0, 2, 0, 5, 0 }, { 1, 0, 0, 0, 3, 0, 0, 0, 2 }, { 5, 0, 0, 2, 0, 4, 0, 0, 9 },
			{ 0, 3, 8, 0, 0, 0, 4, 6, 0 } };

	public int[][] exemplu1 = new int[][] { { 0, 9, 6, 0, 4, 0, 0, 3, 0 }, { 0, 5, 7, 8, 2, 0, 0, 0, 0 },
			{ 1, 0, 0, 9, 0, 0, 5, 0, 0 }, { 0, 0, 9, 0, 1, 0, 0, 0, 8 }, { 5, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 4, 0, 0, 0, 9, 0, 6, 0, 0 }, { 0, 0, 4, 0, 0, 3, 0, 0, 1 }, { 0, 0, 0, 0, 7, 9, 2, 6, 0 },
			{ 0, 2, 0, 0, 5, 0, 9, 8, 0 } };

	public int[][] exemplu2 = new int[][] { { 5, 0, 3, 0, 0, 0, 0, 0, 0 }, { 2, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 4, 0, 7, 1, 0, 2, 0, 3 }, { 0, 0, 5, 4, 0, 0, 0, 7, 1 }, { 0, 0, 4, 2, 0, 1, 8, 0, 0 },
			{ 6, 8, 0, 0, 0, 7, 5, 0, 0 }, { 1, 0, 7, 0, 6, 9, 0, 3, 0 }, { 0, 0, 0, 0, 0, 4, 0, 0, 6 },
			{ 0, 0, 0, 0, 0, 0, 9, 0, 5 } };

	public int[][] exemplu3 = new int[][] { { 0, 0, 2, 0, 6, 1, 0, 0, 9 }, { 8, 0, 5, 4, 0, 0, 0, 7, 6 },
			{ 6, 0, 4, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 0, 5, 2, 0, 0, 0 }, { 0, 0, 0, 8, 0, 7, 0, 0, 0 },
			{ 0, 0, 0, 9, 3, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 2 }, { 3, 6, 0, 0, 0, 8, 4, 0, 7 },
			{ 2, 0, 0, 1, 4, 0, 9, 0, 0 } };

	public int[][] exemplu4 = new int[][] { { 1, 0, 8, 0, 0, 6, 4, 0, 0 }, { 0, 0, 6, 0, 9, 0, 8, 0, 7 },
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 }, { 2, 6, 9, 5, 0, 0, 0, 8, 0 }, { 0, 0, 0, 4, 0, 9, 0, 0, 0 },
			{ 0, 8, 0, 0, 0, 2, 7, 9, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 5 }, { 6, 0, 4, 0, 7, 0, 2, 0, 0 },
			{ 0, 0, 1, 2, 0, 0, 9, 0, 3 } };

	public int[][] exemplu5 = new int[][] { { 0, 0, 0, 2, 4, 0, 6, 0, 0 }, { 9, 0, 0, 0, 0, 0, 0, 0, 3 },
			{ 1, 0, 0, 0, 0, 3, 0, 4, 5 }, { 5, 6, 0, 0, 7, 0, 1, 0, 0 }, { 0, 0, 4, 8, 0, 5, 9, 0, 0 },
			{ 0, 0, 1, 0, 6, 0, 0, 5, 2 }, { 6, 9, 0, 5, 0, 0, 0, 0, 1 }, { 4, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 0, 0, 8, 0, 9, 6, 0, 0, 0 } };

	public int[][] exemplu6 = new int[][] { { 0, 1, 2, 0, 0, 0, 0, 0, 0 }, { 0, 0, 6, 2, 0, 0, 5, 0, 0 },
			{ 3, 0, 0, 0, 0, 4, 7, 2, 0 }, { 0, 8, 0, 0, 6, 0, 2, 0, 9 }, { 2, 0, 0, 8, 0, 9, 0, 0, 4 },
			{ 6, 0, 1, 0, 4, 0, 0, 8, 0 }, { 0, 4, 8, 1, 0, 0, 0, 0, 6 }, { 0, 0, 3, 0, 0, 5, 4, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 8, 1, 0 } };

	public int[][] exemplu7 = new int[][] { { 0, 0, 0, 0, 0, 0, 8, 0, 6 }, { 4, 0, 5, 6, 9, 0, 0, 1, 0 },
			{ 0, 0, 9, 0, 0, 2, 4, 0, 0 }, { 5, 0, 0, 0, 0, 3, 0, 8, 0 }, { 0, 0, 7, 8, 0, 9, 6, 0, 0 },
			{ 0, 9, 0, 2, 0, 0, 0, 0, 3 }, { 0, 0, 4, 7, 0, 0, 1, 0, 0 }, { 0, 6, 0, 0, 4, 1, 7, 0, 8 },
			{ 7, 0, 3, 0, 0, 0, 0, 0, 0 } };

	public int[][] exemplu8 = new int[][] { { 0, 4, 3, 1, 0, 0, 0, 0, 0 }, { 7, 0, 9, 4, 6, 0, 0, 0, 0 },
			{ 8, 0, 6, 0, 0, 3, 0, 1, 0 }, { 9, 0, 2, 0, 0, 7, 0, 0, 0 }, { 0, 6, 0, 0, 0, 0, 0, 4, 0 },
			{ 0, 0, 0, 3, 0, 0, 9, 0, 7 }, { 0, 7, 0, 6, 0, 0, 2, 0, 5 }, { 0, 0, 0, 0, 2, 4, 6, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 4, 3, 0 } };

	public int[][] exemplu9 = new int[][] { { 0, 6, 0, 4, 0, 0, 0, 8, 0 }, { 0, 0, 1, 0, 8, 6, 0, 0, 2 },
			{ 8, 0, 0, 0, 9, 0, 1, 0, 6 }, { 0, 8, 2, 0, 4, 5, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 3, 0, 8, 4, 0 }, { 1, 0, 6, 0, 5, 0, 0, 0, 8 }, { 4, 0, 0, 6, 2, 0, 5, 0, 0 },
			{ 0, 9, 0, 0, 0, 7, 0, 2, 0 } };

	private SudokuModel m_model;

	/** Constructor */
	SudokuView(SudokuModel model) {
		// ... Set up the logic
		m_model = model;

		// ... Layout the components.
		JFrame frame = new JFrame("My Sudoku");
		frame.setSize(600, 600);

	/*	  try {
	        Image img = ImageIO.read(getClass().getResource("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\Downloads\\clear.png"));
	        clearBtn.setIcon(new ImageIcon(img));
	      } catch (IOException ex) {
	    	  System.out.println("nu s-a gasit imaginea");
	      }
*/		JPanel butoane = new JPanel();
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(checkBtn);
		butoane.add(clearBtn);
		butoane.add(new_gameBtn);
		butoane.add(solveBtn);

		board = new JPanel();
		board.setLayout(new GridLayout(9, 9));

		configure(exemplu);
		// ... finalize layout
		frame.getContentPane().add(board);
		frame.getContentPane().add(butoane, "East");
		frame.setVisible(true);
		frame.add(this);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void addClearListener(ActionListener cal) {
		clearBtn.addActionListener(cal);
	}

	void addSolveListener(ActionListener mal) {
		solveBtn.addActionListener(mal);
	}

	void addCheckListener(ActionListener nal) {
		checkBtn.addActionListener(nal);
	}

	void addNewGameListener(ActionListener nal) {
		new_gameBtn.addActionListener(nal);
	}

	void configure(int[][] a) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				index[i][j] = new JTextField(1);
				index[i][j].setHorizontalAlignment(JTextField.CENTER);
				index[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				if(i % 3 == 0) {
					index[i][j].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 1, Color.black));
				}
				if(j % 3 == 0) {
					index[i][j].setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.black));
				}
				if(i % 3 == 0 && j % 3 == 0) {
					index[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 1, 1, Color.black));
				}
				if (a[i][j] != 0) {
					index[i][j].setText(" " + a[i][j]);
					index[i][j].setEditable(false);
				}

				board.add(index[i][j]);
			}
		}

		}

	void newGame(int a[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (a[i][j] != 0) {
					index[i][j].setText(" " + a[i][j]);
					index[i][j].setEditable(false);
					index[i][j].setBackground(Color.lightGray);
				} else {
					index[i][j].setEditable(true);
				}
			}
		}
	}

	void reset() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (exemplu[i][j] == 0) {
					index[i][j].setText("");
					index[i][j].setBackground(Color.white);

				} else
					index[i][j].setEditable(false);
			}
		}

	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public Insets getBorderInsets(Component c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return false;
	}
}
