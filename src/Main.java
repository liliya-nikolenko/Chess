import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner move;

	public static void main(String[] args) throws IOException {
		ChessBoard chess = new ChessBoard();
		chess.arrangeFigures();
		chess.printBoard();
		move = new Scanner(System.in);
		String s = "";
	    ParseMove parse = new ParseMove();
	    ChessLogic logic = new ChessLogic(chess);
	    while(true) { 
	    	   System.out.println();
	           System.out.println("next move is ");
	           s = move.nextLine();
	           if(s.equals("end") == true)
	        	   break;
	           int [] temp = parse.parseMove(s);
	           if(parse.checkMove(temp)){
	        	   if(logic.checkPossible(temp[0], temp[1], temp[2], temp[3]))
	        		   chess.move(temp[0], temp[1], temp[2], temp[3]);
	           }
	           chess.printBoard();     
	    }    		
				
		
	}

}
