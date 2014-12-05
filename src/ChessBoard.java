
public class ChessBoard {
	final int size = 8;
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
		board[0][0] = new Figure(Figures.Castle, false, 1, 1);
		board[0][1] = new Figure(Figures.Knight, false, 2, 1);
		board[0][2] = new Figure(Figures.Bishop, false, 3, 1);
		board[0][3] = new Figure(Figures.King,   false, 4, 1);
		board[0][4] = new Figure(Figures.Queen,  false, 5, 1);
		board[0][5] = new Figure(Figures.Bishop, false, 6, 1);
		board[0][6] = new Figure(Figures.Knight, false, 7, 1);
		board[0][7] = new Figure(Figures.Castle, false, 8, 1);
		board[7][0] = new Figure(Figures.Castle, true,  1, 8);
		board[7][1] = new Figure(Figures.Knight, true,  2, 8); 
		board[7][2] = new Figure(Figures.Bishop, true,  3, 8);
		board[7][3] = new Figure(Figures.Queen,  true,  4, 8);
		board[7][4] = new Figure(Figures.King,   true,  5, 8);
		board[7][5] = new Figure(Figures.Bishop, true,  6, 8);
		board[7][6] = new Figure(Figures.Knight, true,  7, 8);
		board[7][7] = new Figure(Figures.Castle, true,  8, 8);
		for(int i = 0, k = 1; i < board.length; i++, k++){
			board[1][i] = new Figure(Figures.Pawn, false, k, 2);
			board[6][i] = new Figure(Figures.Pawn, true,  k, 7);
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
	
	public void move(int oldPosX, int oldPosY, int newPosX, int newPosY){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j] == null)
					continue;
				else{
					if(board[i][j].getPosX() == oldPosX && board[i][j].getPosY() == oldPosY){							
						board[newPosY - 1][newPosX - 1] = new Figure(board[i][j].getFigure(), board[i][j].getIsWhite(), newPosX, newPosY);						
						board[i][j] = null;							
					}
				}					
			}
		}
	}
}
