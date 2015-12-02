// Jackson Nabors
// Board class for conniption


public class Board {
	
	int moves;  // number of moves, could be moved to driver class
	int count = 0; //keeps count in move down function to run the number of times the board is tall to move all pieces down after a flip. 
	char[][] spaces = new char[][]{							// array of O's for empty spaces, use R & W for red and white players
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
			  { 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
			};
	
	public int getMoves() { // return number of moves, ex. could print "game won in # moves at end"
		return moves;
	}

	public char[][] getBoard() {  // gets the current board
		return spaces;
	}

	public Board flipBoard(){  // makes mirror image of board
		char flip[][] = new char[8][8];
		for(int row = 0; row < this.spaces.length; row++)
			for(int col = 0; col < this.spaces[row].length; col++)
			{
			flip[row][col] = this.spaces[this.spaces.length - 1 - row][col];
		}
		count = 0;
		Board temp = moveDown(flip);
		
		return temp;
	}
	
	public Board setBoard(char[][] array){ // sets the current board
		Board board = new Board();
		this.spaces = array;
		return board;
	}
	
	public Board moveDown(char[][] array){ //helper function that allows pieces to fall down board after flipped 
	
		for(int col = 0; col < array[0].length; col++){
			
			for(int row = array.length -2 ; row >=0; row--){
				
					if(array[row][col] != 'O' && array[row+1][col] == 'O'){
						array[row+1][col] = array[row][col];
						array[row][col] = 'O';
				
						}
				
					}
			
				}
		while(count < array.length){
			count++;
			moveDown(array);
		}
		this.spaces = array;

		return this;
		
	}
	
	public boolean isValid(int value){ // checks if row isn't full 
		boolean valid = false; 
		char current[][] = getBoard();
			for(int row = 0; row < this.spaces.length; row++)
			{
				if(current[row][value] != 'O'){
				valid = true;
				break;
			}
			}
			return valid; 
	}
	
	public void makeMove(int value, char piece){			// makemove ( column number, 'R' or 'W')
		char current[][] = this.spaces;
		if(isValid(value)){
			for(int row = this.spaces.length -1 ; row >0; row--){
				if(current[row][value] == 'O'){
					
						current[row][value] = piece;
						break;
				}
					
			}
		}
			moves++;
			this.spaces = current;
	}
	
	public void undoMove(int col){
		char current[][] = this.spaces;
		for(int row = 0; row < this.spaces.length-1; row++){
			if(current[row][col] != 'O'){
				current[row][col] = 'O';
				break;
			}
		}
		this.spaces = current;
	}
	
	public boolean isWin(char value){		// checks up down, side to side, then diagonals
		boolean win = false;
		char current[][] = this.spaces;
		for(int row = 0; row < current.length; row++)
			for(int col = 0; col < current[row].length; col++)
			{
				if(row <= 4){
				if(current[row][col] == value && current[row+1][col] == value && current[row+2][col] == value && current[row+3][col] == value){
					win = true;
					break;}
				}
				if(col <= 3){
				
				if(current[row][col] == value && current[row][col+1] == value && current[row][col+2] == value && current[row][col+3] == value){
					win = true;
					break;
				}
				}
			
			
			}
		for(int col = 0; col < this.spaces[0].length; col++)
			for(int row = this.spaces.length -1 ; row >0; row--){
				if(row <=4)
				{
				if(current[row][col] == value && current[row+1][col+1] == value && current[row+2][col+2] == value && current[row+3][col+3] == value){
					win = true;
					break;}
				}
				if(row >=3)
				{
				if(current[row][col] == value && current[row-1][col+1] == value && current[row-2][col+2] == value && current[row-3][col+3] == value){
					win = true;
					break;
					}
				
				}
			}
		return win;
	}
	
	
	public void printBoard(){ // prints current board
		for(int row = 0; row < this.spaces.length; row++)
		{
			for(int col = 0; col < this.spaces[row].length; col++)
			{
				System.out.print(" " + this.spaces[row][col] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
}


