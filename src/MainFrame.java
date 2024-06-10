import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends JFrame {
	public MainFrame() {
	}
	
	/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	* Method				:	void main(String[] args)
	*
	* Method parameters		:	args - the method permits String command line parameters to be entered
	*
	* Method return			:	void
	*
	* Synopsis				:	The method runs the application.
	*
	* Modifications			:
	*							Date			Developer				Notes
	*							----			---------				-----
	*							2023-09-11		W. Poomarin				Finish Load and Save Files
	*							2023-09-12		W. Poomarin				Build UI layout
	*							2023-09-13		W. Poomarin				Finish validation mechanic
	*							2023-09-15		W. Poomarin				Add Comments
	*							2023-09-17		W. Poomarin				Optimize data types
	*							2023-09-19		W. Poomarin				Decorate layout
	*							2023-09-20		W. Poomarin				Clean up code
	*
	** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuLayout frame = new SudokuLayout();		// create frame as a SudokuLayout object
					frame.setTitle("Sudoku Validator");				// set title 
					frame.setVisible(true);							// display frame
					frame.setResizable(false);						// fixed window size
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
