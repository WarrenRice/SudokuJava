import java.awt.Color;

import javax.swing.JTextField;

public class SudokuTextField extends JTextField{

	private byte row, column;								// define row and column as byte
	private byte number;									// define number as byte
	private int positionX;									// define positionX as an integer
	private int positionY;									// define positionY as an integer
	
	public SudokuTextField(byte index) {						
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	SudokuTextField class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	SudokuTextField
		*
		* Synopsis				:	Constructor of the class SudokuTextField. This method creates an instance of the textField
		* 								with methods and some data member to setup it's size, location and number value.
		* 
		* References			:   Oracle. (2023). Class JTextField. Retrieved September 17, 2023, 
		*								from https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextField.html
		*
		*							Oracle. (2023). Class Byte. Retrieved September 24, 2023, 
		*								from https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Byte.html
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-09-11		W. Poomarin				Finish Load and Save Files
		*							2023-09-12		W. Poomarin				Build UI layout
		*							2023-09-13		W. Poomarin				Finish validation mechanic
		*							2023-09-15		W. Poomarin				Add Comments
		*							2023-09-17		W. Poomarin				Optimize data types
		*							2023-09-17		W. Poomarin				Add References
		*							2023-09-20		W. Poomarin				Clean up code
		*							2023-09-24		W. Poomarin				Refine minor details
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		this.row = (byte) (index/9);						// instantiate row = index/9
		this.column = (byte) (index%9);						// instantiate column = index%9
		this.positionX = (int) (24 + this.column*30);		// instantiate positionX = 24 + this.column*30
		this.positionY = (int) (24 + this.row*30);			// instantiate positionY = 24 + this.row*30
		this.setBounds(positionX, positionY, 24, 24);		// call setBounds() to set SudokuTextField to positionX, positionY
		this.setHorizontalAlignment(JTextField.CENTER);		// set text at the center
	}
	
	
	public void getInput() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getInput
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method gets and checks if user's input is more than 0 and less than 10.
		* 								Then, assigns the number to data member "number".
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
		
		byte inputNumber;									// define inputNumber as byte
		String input = "";									// define and instantiate input as an String = ""
		input = this.getText();								// set input = getText() from textField
		
		try {												// try
			inputNumber = Byte.parseByte(input);			// convert input to Byte and assign to inputNumber
			if (inputNumber > 0 && inputNumber < 10) {		// if 0 < inputNumber < 10
				this.number = inputNumber;					// set data member number = inputNumber
			} else {										// else
				this.number = 0;							// set data member number = 0
			}
		} catch (Exception e) {								// catch error
			this.number = 0;								// set data member number = 0
		}
	}
	
	
	public void setInput(byte inputText) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getInput
		*
		* Method parameters		:	inputText - the method permits a byte parameters to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method sets textField display to inputText
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
		
		this.setText(Integer.toString(inputText));			// set and display textField to inputText
	}
	
	public byte getNumber() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getNumber
		*
		* Method parameters		:	none
		*
		* Method return			:	byte 
		*
		* Synopsis				:	This method returns data member: number
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
		
		return this.number;									// return number
	}
	
	public void setNumber(byte inputNumber) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setNumber
		*
		* Method parameters		:	inputNumber - the method permits a byte parameters to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method sets data member: number and call setText method to display
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
		
		this.number = inputNumber;							// set data member number = inputNumber
		this.setText(Integer.toString(this.number));		// set and display textField to data member number 
	}
}
