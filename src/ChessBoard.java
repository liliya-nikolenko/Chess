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
		board[0][0] = new Figure(Figures.Castle, false,  97, 1);
		board[0][1] = new Figure(Figures.Knight, false,  98, 1);
		board[0][2] = new Figure(Figures.Bishop, false,  99, 1);
		board[0][3] = new Figure(Figures.King,   false, 100, 1);
		board[0][4] = new Figure(Figures.Queen,  false, 101, 1);
		board[0][5] = new Figure(Figures.Bishop, false, 102, 1);
		board[0][6] = new Figure(Figures.Knight, false, 103, 1);
		board[0][7] = new Figure(Figures.Castle, false, 104, 1);
		board[7][0] = new Figure(Figures.Castle, true,   97, 8);
		board[7][1] = new Figure(Figures.Knight, true,   98, 8); 
		board[7][2] = new Figure(Figures.Bishop, true,   99, 8);
		board[7][3] = new Figure(Figures.Queen,  true,  100, 8);
		board[7][4] = new Figure(Figures.King,   true,  101, 8);
		board[7][5] = new Figure(Figures.Bishop, true,  102, 8);
		board[7][6] = new Figure(Figures.Knight, true,  103, 8);
		board[7][7] = new Figure(Figures.Castle, true,  104, 8);
		for(int i = 0, k = 97; i < board.length; i++, k++){
			board[1][i] = new Figure(Figures.Pawn, false, k, 2);
			board[6][i] = new Figure(Figures.Pawn, true,  k, 7);
		}
		for(int i = 0; i < board.length; i++){
			board[0][i].setWhite(false);
			board[1][i].setWhite(false);
			board[6][i].setWhite(true);
			board[7][i].setWhite(true);
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
	
	public boolean move(int oldPosX, int oldPosY, int newPosX, int newPosY){
		if(oldPosX < letter && oldPosX > letter + size &&
		   newPosX < letter && newPosX > letter + size &&
		   oldPosY < 1 && oldPosY > size &&
		   newPosY < 1 && newPosX > size)
			return false;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j]==null)
					continue;
				else{
					if(board[i][j].getPosX() == oldPosX && board[i][j].getPosY() == oldPosY){	
						board[i][j].setPosX(newPosX);
						board[i][j].setPosY(newPosY);
						board[newPosY-1][newPosX-letter] = new Figure();
						board[newPosY-1][newPosX-letter].setFigure(board[i][j].getFigure());
						board[i][j] = null;	
						return true;
					}
				}					
			}
		}
		return false;	
	}	
}
