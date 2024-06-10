import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SudokuLayout extends JFrame{
	
	private JPanel contentPane;										// define contentPane as a JPanel for main content pane
	private JButton btnValidation;									// define btnValidation as a JButton to run method when is clicked
	private JButton btnLoad;										// define btnLoad as a JButton to run method when is clicked
	private JButton btnSave;										// define btnSave as a JButton to run method when is clicked
	private JComboBox comboBox;										// define comboBox as a JComboBox for user to select loading file

	private String selectFile;										// define selectFile as a String to store file's name
	private DefaultListModel<String> loadData;						// define loadData as DefaultListModel<String> to store loaded data from the file
	private SudokuTextField[] inputs;								// define inputs as SudokuTextField[] array to store SudokuTextField objects
	
	private JPanel panelNote, panelRed, panelGreen, panelYellow;	// define panelNote, panelRed, panelGreen, panelYellow as JPanel
	private JLabel lblNote, lblRed, lblGreen, lblYellow;			// define lblNote, lblRed, lblGreen, lblYellow as JLabel
	
	private JPanel panelVerticalLine1, panelVerticalLine2,			// panelVerticalLine1, panelVerticalLine2,panelHorizonLine1, panelHorizonLine2 as JPanel
				   panelHorizonLine1, panelHorizonLine2; 			// to create lines to separate blocks
													
	private static final byte CELL_SIZE = 81;						// define and instantiate constant CELL_SIZE = 81
	
	public SudokuLayout() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	SudokuLayout class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	SudokuLayout
		*
		* Synopsis				:	Constructor of the class SudokuLayout. Creates an instance of the SudokuLayout window frame. 
		* 								This class initializes and runs JFrame, JTextField, contentPane, buttons, labels, 
		* 								 ,create SudokuLayout window and methods to run this window.
		* 
		* References			:   Oracle. (2023). Class JFrame. Retrieved September 17, 2023,  
		*								from https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
		*
		*							Oracle. (2023). Class JComboBox<E>. Retrieved September 17, 2023,  
		*								from https://docs.oracle.com/javase/8/docs/api/javax/swing/JComboBox.html
		*
		*							AsciiTable. (2023). ASCII Table. Retrieved September 24, 2023,  
		*								from https://www.asciitable.com/
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
		*							2023-09-24		W. Poomarin				Refine minor details
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// close frame when click on Exit button
		setBounds(100, 100, 640, 480);								// set frame position and size
		contentPane = new JPanel();									// create contentPane as JPanel object to contain the contents
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));			
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Control Buttons Section
		btnValidation = new JButton("Validate");					// instantiate btnValidation as JButton labeled "Validate"
		btnValidation.setBounds(240, 300, 86, 23);					// set it's position and size
		btnValidation.addActionListener(new ActionListener() { 		// call validation() when it is clicked
			public void actionPerformed(ActionEvent e) {			
				validation();											
			}
		});
		contentPane.add(btnValidation);								// add it to the contentPane
		
		btnLoad = new JButton("Load");								// instantiate btnLoad as JButton labeled "Load"
		btnLoad.setBounds(130, 300, 86, 24);						// set it's position and size
		btnLoad.addActionListener(new ActionListener() { 			// call loadFile() when it is clicked
			public void actionPerformed(ActionEvent e) {			
				loadFile();											
			}
		});
		contentPane.add(btnLoad);									// add it to the contentPane
		
		comboBox = new JComboBox();									// instantiate comboBox as a JComboBox object to store the files' name
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"file1", "file2", "file3"}));	//set options to "file1", "file2", "file3"
		comboBox.setSelectedIndex(0);								// default selection to the first element
		comboBox.setBounds(24, 300, 86, 24);						// set it's position and size
		contentPane.add(comboBox);									// add it to the contentPane
		
		
		btnSave = new JButton("Save");								// instantiate btnSave as JButton labeled "Save"
		btnSave.setBounds(350, 300, 86, 24);						// set it's position and size
		btnSave.addActionListener(new ActionListener() { 			// call saveBoard() when it is clicked
			public void actionPerformed(ActionEvent e) {
				saveBoard();											
			}
		});
		contentPane.add(btnSave);									// add it to the contentPane
		// End Control Buttons Section
		
		// Note Panel Section
		panelNote = new JPanel();									// instantiate panelNote as JPanel object to store 'Information Note"
		panelNote.setBackground(new Color(220, 220, 220));			// set Background color
		panelNote.setBounds(327, 24, 265, 160);						// set position and size
		contentPane.add(panelNote);									// add to contentPane
		panelNote.setLayout(null);									// absolute layout
		
		lblNote = new JLabel("Note: ");								// instantiate lblNote as JLabel to display text "Note: "
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 12));			// set font
		lblNote.setBounds(10, 11, 46, 14);							// set position and size
		panelNote.add(lblNote);										// add to panelNotev
		
		panelGreen = new JPanel();									// instantiate panelGreen as JPanel object to display color
		panelGreen.setBackground(new Color(0, 255, 0));				// set Background color to GREEN
		panelGreen.setBounds(10, 36, 25, 25);						// set position and size
		panelNote.add(panelGreen);									// add to panelNotev
		
		lblGreen = new JLabel("Valid Input");						// instantiate lblGreen as JLabel to display text "Valid Input"
		lblGreen.setBounds(45, 48, 110, 14);						// set position and size					
		panelNote.add(lblGreen);									// add to panelNotev
		
		panelRed = new JPanel();									// instantiate panelRed as JPanel object to display color
		panelRed.setBackground(new Color(255, 0, 0));				// set Background color to RED
		panelRed.setBounds(10, 73, 25, 25);							// set position and size
		panelNote.add(panelRed);									// add to panelNotev
		
		lblRed = new JLabel("Invalid Input");						// instantiate lblRed as JLabel to display text "Invalid Input"
		lblRed.setBounds(45, 85, 110, 14);							// set position and size
		panelNote.add(lblRed);										// add to panelNotev
		
		panelYellow = new JPanel();									// instantiate panelYellow as JPanel object to display color
		panelYellow.setBackground(new Color(255, 255, 0));			// set Background color to YRLLOW
		panelYellow.setBounds(10, 110, 25, 25);						// set position and size
		panelNote.add(panelYellow);									// add to panelNotev
		
		lblYellow = new JLabel("Input must be Number 1 to 9");		// instantiate lblYellow as JLabel to display text "Input must be Number 1 to 9"
		lblYellow.setBounds(45, 122, 172, 14);						// set position and size
		panelNote.add(lblYellow);									// add to panelNotev
		// End Note Panel Section
		
		// Create Lines Section 
		panelVerticalLine1 = new JPanel();							// instantiate panelVerticalLine1 as JPanel to display line
		panelVerticalLine1.setBackground(Color.GRAY);				// set color
		panelVerticalLine1.setBounds(110, 24, 2, 264);				// set position and size
		contentPane.add(panelVerticalLine1);						// add to contentPane
		
		panelVerticalLine2 = new JPanel();							// instantiate panelVerticalLine2 as JPanel to display line
		panelVerticalLine2.setBackground(Color.GRAY);				// set color
		panelVerticalLine2.setBounds(200, 24, 2, 264);				// set position and size
		contentPane.add(panelVerticalLine2);						// add to contentPane
		
		panelHorizonLine1 = new JPanel();							// instantiate panelHorizonLine1 as JPanel to display line
		panelHorizonLine1.setBackground(Color.GRAY);				// set color
		panelHorizonLine1.setBounds(24, 110, 264, 2);				// set position and size
		contentPane.add(panelHorizonLine1);							// add to contentPane
		
		panelHorizonLine2 = new JPanel();							// instantiate panelHorizonLine2 as JPanel to display line
		panelHorizonLine2.setBackground(Color.GRAY);				// set color
		panelHorizonLine2.setBounds(24, 200, 264, 2);				// set position and size
		contentPane.add(panelHorizonLine2);							// add to contentPane
		// End Lines Section 
		
		// Input Text Field Section
		inputs = new SudokuTextField[CELL_SIZE];					// create inputs as SudokuTextField array for 81 elements
		for (byte i = 0; i < CELL_SIZE; i++) {						// assign every element as SudokuTextField object (9x9 elements)
			inputs[i] = new SudokuTextField(i);
			inputs[i].setInput( (byte) (0));						// set input value = 0
			contentPane.add(inputs[i]);								// add them to the contentPane
		}
		// End Input Text Field Section
		
	}

	public void validation() {										
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void validation
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method calls methods from Validator class to check the validation every numbers in the Sudoku board by
		* 								1. get user's input numbers
		* 								2. load numbers to the board in Validator class
		* 								3. check validation in row, column and block
		* 								4. set display colors
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		resetColor();												// reset inputs' background color

		for (byte i = 0; i < CELL_SIZE ; i++) {						// get all inputs' values SudokuTextField Array 'inputs[i]' 
			inputs[i].getInput();
		}
		
		Validator.loadBoard(inputs);								// call loadBoard(inputs) method to send all input data to Validator class
		Validator.checkAll();										// call checkAll() from Validator to check the validation by Row, Column and Box
		colorBoard();												// call colorBoard() to change board color
	}
	
	public void loadFile() {

		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void loadFile
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method loads data from Save/ directory and store in loadData 
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

		String temp_string;																// create temp_string as a String
		String loadString = "0";														// create loadString as a String and set it to "0"
		loadData = new DefaultListModel<String>();										// instantiate loadData as DefaultListModel<String>
		selectFile = "Save/" + comboBox.getSelectedItem() + ".txt";						// set selectFile to "Save/" + comboBox.getSelectedItem() + ".txt" from comboBox
		
		Validator.resetValidBorad();													// reset validBorad in Validator class
		Validator.resetMainBorad();														// reset mainBorad in Validator class
		
		try {
			FileReader inputFile = new FileReader(selectFile);							// create and instantiate inputFile as a FileReader at path targetFile
			BufferedReader bufferInputFile = new BufferedReader(inputFile);				// create and instantiate bufferInputFile as a BufferedReader 
			
			while ( (temp_string = bufferInputFile.readLine()) != null) {				// when file is read
				loadData.addElement(temp_string);										// add data to loadData array (load data is array)
			}
			
			loadString = loadData.get(0);												// set loadString = first element of loadData
			
			bufferInputFile.close();													// close bufferInputFile
			inputFile.close();															// close file
			
			for (byte i = 0; i < CELL_SIZE ; i++) {										// for every elements in inputs
				inputs[i].setInput((byte) (loadString.charAt(i)-'0'));					// call inputs textField to set data to byte (loadString.charAt(i)-'0') 
																						// because charAt is ASCII character 
				inputs[i].getInput();													// call getInput set getInput.number = input number
			}
		} catch (Exception err) {														// show this JOptionPane 
			JOptionPane.showMessageDialog(null, "File is not loaded");					// when can't load the file
		}

		Validator.loadBoard(inputs);													// set Validator.mainBoard to inputs' data
		resetColor();																	// reset inputs' background color

	}
	
	protected void saveBoard() {

		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void saveBoard
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method saves data from Save/ directory
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

		selectFile = "Save/" + comboBox.getSelectedItem() + ".txt";						// set selectFile = "Save/" + comboBox.getSelectedItem() + ".txt"

		for (byte i = 0; i < CELL_SIZE; i++) {											// get all inputs' values SudokuTextField Array 'inputs[i]'
			inputs[i].getInput();
		}
		
		try {																			// try

			FileWriter outputFile = new FileWriter(selectFile);							// create and instantiate outputFile as a FileWriter at path selectFile
			BufferedWriter bufferedOutputFile = new BufferedWriter(outputFile);			// create and instantiate bufferedOutputFile as a BufferedWriter
			
			for (byte i = 0; i < 81; i++) {												// for write every number in inputs array to file
				bufferedOutputFile.write(Integer.toString(inputs[i].getNumber()));		// call getNumber() to get inputs[i].number
			}
			bufferedOutputFile.newLine();

			bufferedOutputFile.close();													// close bufferedOutputFile
			outputFile.close();															// close outputFile

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Can't save the file");					// show "Can't save the file" on JOptionPane 
		}
		JOptionPane.showMessageDialog(null, "Saved!! to " + selectFile);				// show "Saved!! to " + selectFile
	
	}
	
	public void colorBoard() {

		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void colorBoard
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method set the SudokuTextField objects' background color as if they are
		* 								"valid number" to GREEN, "invalid number" to RED, or "invalid input" to YELLOW
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		byte row,column;																// define row and column 
		for(row = 0; row < 9; row++) {													// for row = 0 to 8
			for(column = 0; column < 9; column++) {										// for column = 0 to 8
				if (Validator.getValidBoardAt(row,column) == false) {					// if Validator.validBoard[row][column] == 0
					inputs[row*9+column].setBackground(Color.RED);						// set Background color to RED
				} else {																// else 
					inputs[row*9+column].setBackground(Color.GREEN);					// set Background color to GREEN
				}
				if (inputs[row*9+column].getNumber() == 0) {							// if inputs[row*9+column].number == 0
					inputs[row*9+column].setBackground(Color.YELLOW);					// set Background color to YELLOW
				}
			}
		}
	}
	
	public void resetColor() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void resetColor
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method set the SudokuTextField objects' background color WHITE
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		byte row,column;																// define row and column 
		for(row = 0; row < 9; row++) {													// for row = 0 to 8
			for(column = 0; column < 9; column++) {										// for column = 0 to 8
				inputs[row*9+column].setBackground(Color.WHITE);						// set Background color to WHITE
			}
		}
	}
}
