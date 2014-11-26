
abstract public class Figure {
	private String title;
	private boolean isWhite;	
	private int posX;
	private int posY;
	Figure(){};
	Figure(boolean colour){
		isWhite = colour;		
	}
	Figure(boolean colour, int posX, int posY){
		isWhite = colour;
		this.posX = posX;
		this.posY = posY;
	}
	abstract public boolean moveFigure(int posX, int posY);
	abstract public void draw();
	public boolean getIsWhite() {
		return isWhite;
	}
	public void setIsWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
