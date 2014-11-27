enum Figures{
	Pawn("p"), Castle("c"), Knight("k"), Bishop("b"), King("K"), Queen("Q");
	private String title;	
	Figures(){};
	Figures(String s){		
		title = s;		
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
public class Figure {	
	private Figures figure;
	private boolean isWhite;
	private int posX;
	private int posY;
	Figure(){};	
	Figure(Figures f, boolean isWhite, int posX, int posY){
		figure = f;
		this.isWhite = isWhite;
		this.posX = posX;
		this.posY = posY;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
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
	public Figures getFigure() {
		return figure;
	}
	public void setFigure(Figures figure) {
		this.figure = figure;
	}
	@Override
	public String toString() {
		if(isWhite)
			return "w" + getFigure().getTitle() ;
		else
			return "b" + getFigure().getTitle() ;
	}	
	
}
