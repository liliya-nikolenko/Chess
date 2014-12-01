
public class ChessLogic {
	private ChessBoard board;	
	ChessLogic(ChessBoard cb){
		board = new ChessBoard();
		board = cb;
	}
	public ChessBoard getBoard() {
		return board;
	}
	public void setBoard(ChessBoard board) {
		this.board = board;
	}
	public boolean checkPossible(int oldPosX, int oldPosY, int newPosX, int newPosY){
		return true;
	}
}
