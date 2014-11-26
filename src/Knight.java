
public class Knight extends Figure{
	Knight(){};
	Knight(boolean colour, int posX, int posY){
		super(colour, posX, posY);		
	}
	@Override
	public boolean moveFigure(int posX, int posY) {
		setPosX(posX);
		setPosY(posY);
		return true;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		if(getIsWhite())
			return "wk";
		else
			return "bk";
	}

}