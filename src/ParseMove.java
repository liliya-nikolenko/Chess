/*
 * ƒоделать проверку неверных значений или 
 * текста
 */
public class ParseMove {
	public int [] parseMove(String s){
		int [] moves = new int[4];
		char[] c_arr = s.toCharArray();
		moves[0] = (int)c_arr[0];
		moves[1] = (int)c_arr[1];
		moves[2] = (int)c_arr[3];
		moves[3] = (int)c_arr[4];
		moves[0] -= 96;
		moves[1] -= 48;
		moves[2] -= 96;
		moves[3] -= 48;
		return moves;
	}
	public boolean checkMove(int [] m){
		for(int i = 0; i < m.length; i++){
			if(m[i] < 1 && m[i] > 8)
				return false;
		}
	return true;
	}
}
