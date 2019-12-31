import java.awt.Color;
import java.util.Random;

import javax.swing.JTextField;

import java.awt.event.*;

public class SudokuController {
	// ... The Controller needs to interact with both the Model and View.
	private SudokuModel m_model;
	private SudokuModel m_model1;
	private SudokuView m_view;
	private SudokuView m_view1;
	private boolean activat = false;
	private String[][] arr = new String[9][9];
	private int[][] aux = new int[9][9];

	// =====================================================constructor
	/** Constructor */
	SudokuController(SudokuModel model, SudokuView view) {
		m_model = model;
		m_view = view;

		// ... Add listeners to the view.
		view.addCheckListener(new CheckListener());
		view.addClearListener(new ClearListener());
		view.addSolveListener(new SolveListener());
		view.addNewGameListener(new NewGameListener());
	}

	/* adaugam functionalitate butonului de Solve */
	class SolveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			activat = true;
			m_model.solveSudoku(m_view.exemplu, m_view.exemplu.length);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {

					if (m_view.exemplu[i][j] != 0) {
						m_view.index[i][j].setText(" " + m_view.exemplu[i][j]);
					}
					m_view.board.add(m_view.index[i][j]);
				}
			}

		}
	}
//adaugam functionalitate butonului de Check

	class CheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (activat) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if(m_view.index[i][j].isEditable())
						m_view.index[i][j].setBackground(Color.green);
					}
				}
				return;
			}

			m_model1 = m_model;
			m_view1 = m_view;
			m_model1.solveSudoku(m_view1.exemplu, m_view1.exemplu.length);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (m_view.index[i][j].isEditable()) {
						if (m_view.index[i][j].getText().isEmpty()) {
							m_view.index[i][j].setBackground(Color.red);
						} else {
							int aux = Integer.parseInt(m_view.index[i][j].getText());
							int aux1 = m_view1.exemplu[i][j];
							if (aux == aux1) {
								m_view.index[i][j].setBackground(Color.green);
							} else
								m_view.index[i][j].setBackground(Color.red);
						}
					}
				}
			}

		}
	}

	// adaugam functionalitate pentru butonul de Clear
	/**
	 * 1. Reset model. 2. Reset View.
	 */

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {

					if (m_view.index[i][j].isEditable()) {
						m_view.exemplu[i][j] = 0;
					}
				}
			}
			m_view.reset();
		}
	}

	// adaugam functionalitate pentru butonul New Game
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			int random = rand.nextInt(10);
			// int random = 8;

			switch (random) {
			case 0:
				break;
			case 1:
				m_view.exemplu = m_view.exemplu1;
				break;
			case 2:
				m_view.exemplu = m_view.exemplu2;
				break;
			case 3:
				m_view.exemplu = m_view.exemplu3;
				break;
			case 4:
				m_view.exemplu = m_view.exemplu4;
				break;
			case 5:
				m_view.exemplu = m_view.exemplu5;
				break;
			case 6:
				m_view.exemplu = m_view.exemplu6;
				break;
			case 7:
				m_view.exemplu = m_view.exemplu7;
				break;
			case 8:
				m_view.exemplu = m_view.exemplu8;
				break;
			case 9:
				m_view.exemplu = m_view.exemplu9;
				break;
			}
			m_view.reset();
			m_view.newGame(m_view.exemplu);
		}

	}

}