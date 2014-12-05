
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
		int i = oldPosY - 1;
		int j = oldPosX - 1;
		int ni = newPosY - 1;
		int nj = newPosX - 1;				
		if(board.getBoard()[i][j].getFigure().getTitle().equals("p")){
			if(board.getBoard()[i][j].getIsWhite()){
				if(oldPosY == 7 && oldPosX == newPosX && 
						(newPosY == oldPosY - 1 || (newPosY == oldPosY - 2 && board.getBoard()[i - 1][j] == null))) {
					return true;
				}
				else if(oldPosX == newPosX && newPosY == oldPosY - 1 && board.getBoard()[ni][nj] == null){
					return true;
				}
				else if((oldPosX == newPosX + 1 || oldPosX == newPosX - 1) && newPosY == oldPosY-1 
						&& board.getBoard()[ni][nj] != null && !board.getBoard()[ni][nj].getIsWhite()){
					return true;
				}
			}
			if(!board.getBoard()[i][j].getIsWhite()){
				if(oldPosY == 2 && oldPosX == newPosX && 
						(newPosY == oldPosY + 1 || (newPosY == oldPosY + 2 && board.getBoard()[i+1][j] == null))) {
					return true;
				}
				else if(oldPosX == newPosX && newPosY == oldPosY + 1 && board.getBoard()[ni][nj] == null){
					return true;
				}
				else if((oldPosX == newPosX + 1 || oldPosX == newPosX - 1) && newPosY == oldPosY + 1 
						&& board.getBoard()[ni][nj] != null && board.getBoard()[ni][nj].getIsWhite()){
					return true;
				}
			}				
		}
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("c")){
			boolean isNull = false;
			int difX = newPosX > oldPosX ? newPosX-oldPosX : oldPosX-newPosX;
			int difY = newPosY > oldPosY ? newPosY-oldPosY : oldPosY-newPosY;
			int dif = difX > difY ? difX : difY;
			if((dif == 1) &&
			    	((newPosX == oldPosX + dif && newPosY == oldPosY) ||
					 (newPosX == oldPosX - dif && newPosY == oldPosY) ||
					 (newPosX == oldPosX && newPosY == oldPosY + dif) ||
					 (newPosX == oldPosX && newPosY == oldPosY - dif))){
						isNull = true;
			}				
			else {
				for(int k = 1; k < dif; k++){
					isNull = false;
					if((newPosX > oldPosX || newPosX < oldPosX) && newPosY == oldPosY){				
						if(newPosX > oldPosX){
							if(board.getBoard()[i][j + k]==null)
								isNull = true;
						}
						else if(newPosX < oldPosX){					
							if(board.getBoard()[i][j - k]==null)
								isNull = true;
						}	
					}			
					else if((newPosY > oldPosY || newPosY < oldPosY) && newPosX == oldPosX){
						if(newPosY > oldPosY){					
							if(board.getBoard()[i + k][j]==null)
								isNull = true;
						}
						else if(newPosY < oldPosY){
							if(board.getBoard()[i - k][j]==null)
								isNull = true;
						}
					}
				}
			}
			if(isNull && checkCheckAndColours(oldPosX, oldPosY, newPosX, newPosY)){				
				return true;
			}			
		}
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("k")){
			if(((newPosX == oldPosX + 1 && newPosY == oldPosY + 2) ||
				(newPosX == oldPosX - 1 && newPosY == oldPosY + 2) ||
				(newPosX == oldPosX + 1 && newPosY == oldPosY - 2) ||
				(newPosX == oldPosX - 1 && newPosY == oldPosY - 2) ||
				(newPosX == oldPosX + 2 && newPosY == oldPosY + 1) ||
				(newPosX == oldPosX + 2 && newPosY == oldPosY - 1) ||
				(newPosX == oldPosX - 2 && newPosY == oldPosY + 1) ||
				(newPosX == oldPosX - 2 && newPosY == oldPosY - 1)) &&
				checkCheckAndColours(oldPosX, oldPosY, newPosX, newPosY)){				
						return true;
			}				
		}	
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("b")){
			boolean isNull = false;
			int dif = newPosX > oldPosX ? newPosX-oldPosX : oldPosX-newPosX;
			if(dif == 1 &&
			    	((newPosX == oldPosX + dif && newPosY == oldPosY + dif) ||
					(newPosX == oldPosX - dif && newPosY == oldPosY - dif) ||
					(newPosX == oldPosX - dif && newPosY == oldPosY + dif) ||
					(newPosX == oldPosX + dif && newPosY == oldPosY - dif))){
						isNull = true;
			}				
			else {
				for(int k = 1; k < dif; k++){
					isNull = false;
					if(newPosX == oldPosX + dif && newPosY == oldPosY + dif){
						if(board.getBoard()[i + k][j + k] == null)
							isNull = true;
					}
					else if(newPosX == oldPosX - dif && newPosY == oldPosY - dif){
						if(board.getBoard()[i - k][j - k] == null)
							isNull = true;
					}
					else if(newPosX == oldPosX - dif && newPosY == oldPosY + dif){
						if(board.getBoard()[i + k][j - k] == null)
							isNull = true;
					}
					else if(newPosX == oldPosX+dif && newPosY == oldPosY-dif){
						if(board.getBoard()[i - k][j + k] == null)
							isNull = true;
					}
				}
			}
			if(isNull && checkCheckAndColours(oldPosX, oldPosY, newPosX, newPosY)){				
				return true;
			}				
		}	
		
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("K")){
			if(((newPosX == oldPosX + 1 || newPosX == oldPosX - 1) && newPosY == oldPosY) ||
			   ((newPosY == oldPosY + 1 || newPosY == oldPosY - 1) && newPosX == oldPosX) ||
			   ((newPosY == oldPosY + 1 || newPosY == oldPosY - 1) && newPosX == oldPosX - 1) ||
			   ((newPosY == oldPosY + 1 || newPosY == oldPosY - 1) && newPosX == oldPosX + 1)){		
			 	if(checkCheckAndColours(oldPosX, oldPosY, newPosX, newPosY)){				
			 		   return true;
					}
			}
		}
				
		else if(board.getBoard()[i][j].getFigure().getTitle().equals("Q")){
			boolean isNull = false;
			int difX = newPosX > oldPosX ? newPosX-oldPosX : oldPosX-newPosX;
			int difY = newPosY > oldPosY ? newPosY-oldPosY : oldPosY-newPosY;
			int dif = difX > difY ? difX : difY;
			if((dif == 1) &&
			    	((newPosX == oldPosX + dif && newPosY == oldPosY) ||
					 (newPosX == oldPosX - dif && newPosY == oldPosY) ||
					 (newPosX == oldPosX && newPosY == oldPosY + dif) ||
					 (newPosX == oldPosX && newPosY == oldPosY - dif) ||
					 (newPosX == oldPosX + dif && newPosY == oldPosY + dif) ||
					 (newPosX == oldPosX - dif && newPosY == oldPosY - dif) ||
					 (newPosX == oldPosX - dif && newPosY == oldPosY + dif) ||
					 (newPosX == oldPosX + dif && newPosY == oldPosY - dif))){
						isNull = true;
			}				
			else {
				for(int k = 1; k < dif; k++){
					isNull = false;
					if((newPosX > oldPosX || newPosX < oldPosX) && newPosY == oldPosY){				
						if(newPosX > oldPosX){
							if(board.getBoard()[i][j + k]==null)
								isNull = true;
						}
						else if(newPosX < oldPosX){					
							if(board.getBoard()[i][j - k]==null)
								isNull = true;
						}	
					}			
					else if((newPosY > oldPosY || newPosY < oldPosY) && newPosX == oldPosX){
						if(newPosY > oldPosY){					
							if(board.getBoard()[i + k][j]==null)
								isNull = true;
						}
						else if(newPosY < oldPosY){
							if(board.getBoard()[i - k][j]==null)
								isNull = true;
						}
					}
					else if(newPosX == oldPosX + dif && newPosY == oldPosY + dif){
						if(board.getBoard()[i + k][j + k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX - dif && newPosY == oldPosY - dif){
						if(board.getBoard()[i - k][j - k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX - dif && newPosY == oldPosY + dif){
						if(board.getBoard()[i + k][j - k]==null)
							isNull = true;
					}
					else if(newPosX == oldPosX + dif && newPosY == oldPosY - dif){
						if(board.getBoard()[i - k][j + k]==null)
							isNull = true;
					}
				}
			}
			if(isNull && checkCheckAndColours(oldPosX, oldPosY, newPosX, newPosY)){				
				return true;
			}				
		}			
		}
		
		catch(NullPointerException e){
			System.out.println("Check is empty");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Wrong move, ArrayIndexOutOfBounds");
		}
		System.out.println("Repeat, wrong move, logic");
		return false;
	}
	
	
	public boolean checkCheckAndColours(int oldPosX, int oldPosY, int newPosX, int newPosY){
		if((board.getBoard()[newPosY - 1][newPosX - 1] == null ||
			board.getBoard()[oldPosY - 1][oldPosX - 1].getIsWhite() != board.getBoard()[newPosY - 1][newPosX - 1].getIsWhite())){
			return true;
		}			
		return false;
	}
}
