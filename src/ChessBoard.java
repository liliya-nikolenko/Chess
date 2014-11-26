public class ChessBoard {
	final int size = 8;
	int letter = 97;
	private Figure[][] board;		
	ChessBoard(){
		board = new Figure [size][];		
		for(int i = 0; i < board.length; i++){
			board[i] = new Figure[size];			
		}					
	}	
	public Figure[][] getBoard() {
		return board;
	}
	public void setDesk(Figure[][] board) {
		this.board = board;
	}
	public void arrangeFigures(){
		board[0][0] = (new Castle(false, 97,  1)); //ладья
		board[0][1] = (new Knight(false, 98,  1)); //конь
		board[0][2] = (new Bishop(false, 99,  1)); //слон
		board[0][3] = (new King  (false, 100, 1));
		board[0][4] = (new Queen (false, 101, 1));
		board[0][5] = (new Bishop(false, 102, 1));
		board[0][6] = (new Knight(false, 103, 1));
		board[0][7] = (new Castle(false, 104, 1));
		board[7][0] = (new Castle(true,  97,  8));
		board[7][1] = (new Knight(true,  98,  8)); 
		board[7][2] = (new Bishop(true,  99,  8));
		board[7][3] = (new Queen (true,  100, 8));
		board[7][4] = (new King  (true,  101, 8));
		board[7][5] = (new Bishop(true,  102, 8));
		board[7][6] = (new Knight(true,  103, 8));
		board[7][7] = (new Castle(true,  104, 8));
		for(int i = 0, k = 97; i < board.length; i++, k++){
			board[1][i] = (new Pawn(false, k, 2));
			board[6][i] = (new Pawn(true,  k, 7));
		}
	}	
	public void printBoard(){
		System.out.println("   a    b    c    d    e    f    g    h");
		for(int i = 0; i < board.length; i++){			
			System.out.println("  ---------------------------------------");
			for(int j = 0; j < board.length; j++){
				if(j == 0)
					System.out.print(i+1);	
				if(board[i][j] == null)
					System.out.print("|    ");
				else 	
					System.out.print("| " + board[i][j] + " ");
				if(j == board.length - 1)
					System.out.print("|");
			}
			System.out.println();
		}	
		System.out.print("  ---------------------------------------");
	}	
	
	/*public boolean move(int oldPosX, int oldPosY, int newPosX, int newPosY){
		if(oldPosX < letter && oldPosX > letter + size &&
		   newPosX < letter && newPosX > letter + size &&
		   oldPosY < 1 && oldPosY > size &&
		   newPosY < 1 && newPosX > size)
			return false;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j].getIsEmpty())
					continue;
				else{
					if(board[i][j].getCoordX() == oldPosX && board[i][j].getCoordY() == oldPosY)
						if(board[i][j].getFigure().moveFigure(newPosX, newPosY)){
							Figure figure = board[i][j].getFigure();
							board[i][j].setIsEmpty(true);							
							board[newPosY-1][newPosX-letter].setFigure(figure);	
							return true;
						}
				}					
			}
		}
		return false;	
	}	*/
}
