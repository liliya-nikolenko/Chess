
public class Player {
	private String name;
	private boolean isWhite;
	Player(){};
	Player(String name, boolean colour){
		this.setName(name);
		setWhite(colour);
	}
	public boolean isWhite() {
		return isWhite;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
