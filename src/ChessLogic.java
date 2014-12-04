
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
		try{
		int i = oldPosY-1;
		int j = oldPosX-1;
		int ni = newPosY-1;
		int nj = newPosX-1;		
		if(board.getBoard()[i][j].getFigure().getTitle().equals("p")){
			if(board.getBoard()[i][j].getIsWhite()){
				if(oldPosY == 7 && oldPosX == newPosX && 
						(newPosY == oldPosY-1 || (newPosY == oldPosY-2 && board.getBoard()[i-1][j]==null))) {
					return true;
				}
				else if(oldPosX == newPosX && newPosY == oldPosY-1 && board.getBoard()[ni][nj]==null){
					return true;
				}
				else if((oldPosX == newPosX+1 || oldPosX == newPosX-1) && newPosY == oldPosY-1 
						&& board.getBoard()[ni][nj]!=null && !board.getBoard()[ni][nj].getIsWhite()){
					return true;
				}
			}
			if(!board.getBoard()[i][j].getIsWhite()){
				if(oldPosY == 2 && oldPosX == newPosX && 
						(newPosY == oldPosY+1 || (newPosY == oldPosY+2 && board.getBoard()[i+1][j]==null))) {
					return true;
				}
				else if(oldPosX == newPosX && newPosY == oldPosY+1 && board.getBoard()[ni][nj]==null){
					return true;
				}
				else if((oldPosX == newPosX+1 || oldPosX == newPosX-1) && newPosY == oldPosY+1 
						&& board.getBoard()[ni][nj]!=null && board.getBoard()[ni][nj].getIsWhite()){
					return true;
				}
			}				
		}
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("c")){
			boolean isNull = false;
			if((newPosX > oldPosX || newPosX < oldPosX) && newPosY == oldPosY){				
				if(newPosX > oldPosX){
					for(int k = 0; k < newPosX-oldPosX; k++){
						isNull = false;
						if(board.getBoard()[i][j+k]==null)
							isNull = true;
					}
				}
				else if(newPosX < oldPosX){
					for(int k = 0; k < oldPosX-newPosX; k++){
						isNull = false;
						if(board.getBoard()[i][j+k]==null)
							isNull = true;
					}
				}
			}
			else if((newPosY > oldPosY || newPosY < oldPosY) && newPosX == oldPosX){
				if(newPosY > oldPosY){
					for(int k = 0; k < newPosY-oldPosY; k++){
						isNull = false;
						if(board.getBoard()[i+k][j]==null)
							isNull = true;
					}
				}
				else if(newPosY < oldPosY){
					for(int k = 0; k < oldPosY-newPosY; k++){
						isNull = false;
						if(board.getBoard()[i-k][j]==null)
							isNull = true;
					}
				}
			}
			if(isNull &&
			  (board.getBoard()[ni][nj]==null ||
			   board.getBoard()[i][j].getIsWhite() != board.getBoard()[ni][nj].getIsWhite()) ){				
				return true;
			}				
		}
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("k")){
			
		}	
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("b")){
			boolean isNull = false;
			int dif = newPosX > oldPosX ? newPosX-oldPosX : oldPosX-newPosX;
			if(dif == 1 &&
			    	((newPosX == oldPosX+dif && newPosY == oldPosY+dif) ||
					(newPosX == oldPosX-dif && newPosY == oldPosY-dif) ||
					(newPosX == oldPosX-dif && newPosY == oldPosY+dif) ||
					(newPosX == oldPosX+dif && newPosY == oldPosY-dif))){
						isNull = true;
			}				
			else {
				for(int k = 1; k < dif; k++){
					isNull = false;
					if(newPosX == oldPosX+dif && newPosY == oldPosY+dif){
						if(board.getBoard()[i+k][j+k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX-dif && newPosY == oldPosY-dif){
						if(board.getBoard()[i-k][j-k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX-dif && newPosY == oldPosY+dif){
						if(board.getBoard()[i+k][j-k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX+dif && newPosY == oldPosY-dif){
						if(board.getBoard()[i-k][j+k]==null)
							isNull = true;
					}
				}
			}
			if(isNull &&
			  (board.getBoard()[ni][nj]==null ||
			   board.getBoard()[i][j].getIsWhite() != board.getBoard()[ni][nj].getIsWhite()) ){				
				return true;
			}				
		}	
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("K")){
			if(((newPosX == oldPosX+1 || newPosX == oldPosX-1) && newPosY == oldPosY) ||
			   ((newPosY == oldPosY+1 || newPosY == oldPosY-1) && newPosX == oldPosX) ||
			   ((newPosY == oldPosY+1 || newPosY == oldPosY-1) && newPosX == oldPosX-1) ||
			   ((newPosY == oldPosY+1 || newPosY == oldPosY-1) && newPosX == oldPosX+1)){		
			 	if(board.getBoard()[ni][nj]==null ||
			 	   board.getBoard()[i][j].getIsWhite() != board.getBoard()[ni][nj].getIsWhite()){				
			 		   return true;
						}
			}
		}
				
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("Q")){
			
		}			
		}
		catch(NullPointerException e){
			System.out.println("Check is empty");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Wrong move");
		}
		System.out.println("Repeat, wrong move");
		return false;
	}
	
	public boolean checkEmptyChecks(){
		
		return false;
	}
}
