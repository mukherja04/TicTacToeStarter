package ticTacToeProblem;

/**
 * 
 * @author 
 *
 */

public class TicTacToe {
	
	    private String[][] board;
	    private int turn;
	    
	    /**
	     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
	     * with all dashes or other place holders.
	     * 
	     * initializes number of turns taken to equal 0
	     */
	    
	    public TicTacToe() {
	    	board = new String[3][3];
	    	
	    	for (int r = 0; r < board.length; r++) {
	    		for (int c = 0; c < board[0].length; c++) {
	    			board[r][c] = "-";
	    		}
	    	}
	    	
	    	turn = 0;
	    }
	    
	    
	   
	    /**
	     * Getter method for current turn number
	     * @return number of turns taken
	     */
	    
	    public int getTurn() {
	    	return turn;
	    }
	    
	    
	    
	   
	   /**
	    * This method prints out the board array on to the console
	    */
	    
	   public void printBoard()
	   {
	       for (String[] row : board) {
	    	   for (String box : row) {
	    		   System.out.print(box);
	    	   }
	    	   System.out.println();
	       }
	       
	   }
	   
	   /**
	    * 
	    * This method determines if space row, col is an available space to choose
	    * @return: true if the board[row][col] is available, false otherwise
	    * 
	    */
	   
	   public boolean pickLocation(int row, int col)
	   {
	        if (board[row][col].equals("-")) {
	        	return true;
	        }
	        return false;
	   }
	   
	   /**
	    * 
	    * This method places an X or O at board[row][col] based on the int turn
	    */
	   
	   public void takeTurn(int row, int col)
	   {
		   if (turn%2 == 0) {
			   board[row][col] = "X";
		   }
		   else {
			   board[row][col] = "O";
		   }
	   }
	   
	   /**
	    * 
	    * This method checks if any row has all X's or all Os
	    * @return: true if there is a row with all the same value, false otherwise. 
	    */
	   
	   
	   public boolean checkRow()
	   {
		   for (String[] row : board) {
			   String checker = row[0];
			   int count = 0;
			   for (String box : row) {
				   if (box.equals(checker)) {
					   count++;
				   }
			   }
			   if (count == 3) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if any col has all X's or all Os
	    * @return: true if there is a col with all the same value, false otherwise. 
	    */
	   
	   public boolean checkCol()
	   {
		   for (int c = 0; c < board[0].length; c++) {
			   String checker = board[0][c];
			   int count = 0;
			   for (int r = 0; r < board.length; r++) {
				   if (board[r][c].equals(checker)) {
					   count++;
				   }
			   }
			   if (count == 3) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if either diagonal has all X's or all Os
	    * @return: true if either diagonal with all the same value, false otherwise. 
	    */
	   
	   public boolean checkDiag()
	   {
		   int count = 0;
		   String checker = board[0][0];
		   for (int x = 0; x < board.length; x++) {
			   if (board[x][x].equals(checker)) {
				   count++;
			   }
		   }
		   if (count == 3) {
			   return true;
		   }
		   
		   count = 0;
		   
		   String checker = board[0][board[0].length-1];
		   for (int x = 0; x < board.length; x++) {
			   if (board[x][board[0].length-1-x].equals(checker)) {
				   count++;
			   }
		   }
		   if (count == 3) {
			   return true;
		   }
		   return false;
	   }
	   
	   /**
	    * 
	    * This method checks if a player has won the game via a row, col, or diagonal
	    * @return: true if the game is won, false otherwise
	    */
	   public boolean checkWin()
	   {
	       if (checkRow() || checkCol() || checkDiag()) {
	    	   return true;
	       }
	       return false;
	   }

}
