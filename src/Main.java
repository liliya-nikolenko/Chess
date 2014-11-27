import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		ChessBoard chess = new ChessBoard();
		chess.arrangeFigures();
		chess.printBoard();
		System.out.println();
		chess.move('a', 2, 'a', 3);		
		chess.printBoard();
		System.out.println();
		chess.move('c', 7, 'c', 6);		
		chess.printBoard();
		System.out.println();
		chess.move('c', 7, 'c', 0);	// проверка ошибочного кода	
		chess.printBoard();
	}

}
