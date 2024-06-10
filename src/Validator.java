import java.awt.Color;

public class Validator {
	
	/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	* Method				:	class Validator
	*
	* Method parameters		:	none
	*
	* Method return			:	void 
	*
	* Synopsis				:	This method create Validator class which has data members and methods to validate
	* 								the Sudoku board
	*
	* Modifications			:
	*							Date			Developer				Notes
	*							----			---------				-----
	*							2023-09-11		W. Poomarin				Finish Load and Save Files
	*							2023-09-12		W. Poomarin				Build UI layout
	*							2023-09-13		W. Poomarin				Finish validation mechanic
	*							2023-09-15		W. Poomarin				Add Comments
	*							2023-09-17		W. Poomarin				Optimize data types
	*							2023-09-20		W. Poomarin				Clean up code
	*							2023-09-24		W. Poomarin				Refine minor details
	*
	** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
	
	private static final byte GRID_SIZE = 9;				// define and instantiate constant GRID_SIZE = 9
	
	private static byte[][] mainBoard = {					// define and instantiate mainBoard 
			{0, 0, 0, 0, 0, 0, 0, 0, 0},					// as 2-dimensional byte array
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	
	private static boolean[][] validBoard = {							// create and instantiate validBoard
			{true, true, true, true, true, true, true, true, true},		// as 2-dimensional boolean array
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true}
	};
	
	public static void resetMainBorad() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void resetMainBorad
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method create and instantiate mainBoard as new byte[][] and set every element to 0
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
		
		mainBoard = new byte[][] {							// instantiate mainBoard
				{0, 0, 0, 0, 0, 0, 0, 0, 0},				// as byte 2-dimensional array
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	}
	
	public static void resetValidBorad() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void resetValidBorad
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method create and instantiate validBoard as new boolean[][] and set every element to true
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
		
		validBoard = new boolean[][] {										// instantiate validBoard
				{true, true, true, true, true, true, true, true, true},		// as boolean 2-dimensional array
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true}
		};
	}
	
	
	public static boolean getValidBoardAt(byte r, byte c) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void getValidBoardAt
		*
		* Method parameters		:	r - the method permits a byte parameters to be entered
		* 							c - the method permits a byte parameters to be entered
		*
		* Method return			:	boolean 
		*
		* Synopsis				:	This method gets boolean value of validBoard at row 'r' and column 'c'
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
		
		return validBoard[r][c];							// return validBoard[r][c]
	}
	
	public static void setValidBoardAt(byte r, byte c, boolean inputValue) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void setValidBoardAt
		*
		* Method parameters		:	r - the method permits a byte parameters to be entered
		* 							c - the method permits a byte parameters to be entered
		* 							inputValue - the method permits a boolean parameters to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method sets boolean value of validBoard at row 'r' and column 'c'
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
		
		validBoard[r][c] = inputValue;						// set validBoard[r][c] = inputValue
	}
	
	public static void loadBoard(SudokuTextField[] inputArray) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void loadBoard
		*
		* Method parameters		:	inputArray - the method permits a SudokuTextField object array parameters to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method copy the number from the SudokuTextField and set them to data member: mainBoard
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
		
		byte row, column;										// define row and column as byte
		for(row = 0; row < GRID_SIZE; row++) {					// for row = 0 to 8
			for(column = 0; column < GRID_SIZE; column++) {		// for column = 0 to 8
				mainBoard[row][column] = inputArray[row*GRID_SIZE+column].getNumber();	
			}													// set mainBoard[row][column] = value of inputArray[row*GRID_SIZE+column].number
		}
	}	
	
	public static void checkRow() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void checkRow
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method check validation in the row
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
		
		int row, column, subColumn;										// define row, column, and subColumn as integer
		for (row = 0; row < GRID_SIZE; row++) {							// for row = 0 to 8
			for (column = 0; column < GRID_SIZE; column++) {			// for column = 0 to 8
				
				for (subColumn = column+1; subColumn < GRID_SIZE; subColumn++) {	// for subColumn = column+1 to 8
					if (mainBoard[row][column] == mainBoard[row][subColumn]) {		// if currentNumber == mainBoard[row][subColumn]
						validBoard[row][column] = false;							// then set validBoard[row][column] = 0
						validBoard[row][subColumn] = false;							// set validBoard[row][subColumn] = 0
					}
				}
			}
		}
	}
	
	public static void checkColumn() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void checkColumn
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method check validation in the column
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
		
		int row, column, subRow;										// define row, column, and subRow as integer
		for (column = 0; column < GRID_SIZE; column++) {				// for column = 0 to 8
			for (row = 0; row < GRID_SIZE; row++) {						// for row = 0 to 8
				
				for (subRow = row+1; subRow < GRID_SIZE; subRow++) {	// for subRow = row+1 to 8
					if (mainBoard[row][column] == mainBoard[subRow][column]) {	// if currentNumber == mainBoard[subRow][column]
						validBoard[row][column] = false;						// then validBoard[row][column] = 0
						validBoard[subRow][column] = false;						// validBoard[subRow][column] = 0
					}
				}
			}
		}
	}
	
	public static void checkBlock() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void checkBlock
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method check validation in the 3x3 blocks
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
		
		byte block;													// define box as a byte
		int startRow, startColumn;									// define startRow, startColumn integer
		int innerBox, subInnerBox;									// define innerBox, subInnerBox integer
		int row, column, subRow, subColumn;							// define row, column, subRow, subColumn integer
		
		for (block = 0; block < 9; block++) {								// for box = 0 to 8 
			startRow = block/3*3;										// set startRow = box/3*3
			startColumn = block%3*3;									// set startColumn = box%3*3
			
			for (innerBox = 0; innerBox < 9; innerBox++) {			// for innerBox = 0 to 8 (3x3 number elements in box)
				row = startRow + innerBox/3;						// set row = startRow + innerBox/3
				column = startColumn + innerBox%3;					// set column = startColumn + innerBox%3
				
				for (subInnerBox = innerBox+1; subInnerBox < 9; subInnerBox++) {	// subInnerBox = innerBox+1 to 8 
					subRow = startRow + subInnerBox/3;								// set subRow = startRow + subInnerBox/3
					subColumn = startColumn + subInnerBox%3;						// set subColumn = startColumn + subInnerBox%3
					
					if (mainBoard[row][column] == mainBoard[subRow][subColumn]) {		// if mainBoard[row][column] == mainBoard[subRow][subColumn]
						validBoard[row][column] = false;								// then validBoard[row][column] = 0
						validBoard[subRow][subColumn] = false;							// validBoard[subRow][subColumn] = 0
					}
				}
			}
		}
	}
	
	public static void checkAll() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	static void checkAll
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method call resetValidBorad(), checkRow(), checkColumn(), and checkBox()
		* 								to reset the validBorad and check validation
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
		
		resetValidBorad();								// call resetValidBorad to clear precious values
		checkRow();										// call checkRow() to check Row validation
		checkColumn();									// call checkColumn() to check Column validation
		checkBlock();									// call checkBox() to check Box validation
	}
}
