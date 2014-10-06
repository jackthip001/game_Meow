import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ObjectRock {
private Image image;
	
	private int xPosition = 100;
	private int yPosition = 290;
	
	private int m = 0;
	
	private int force;
	
	public ObjectRock() throws SlickException{
		image =new Image("res/FlintStone.png");
		reset();
	}
	
	public void render(){
		image.draw(xPosition, yPosition,30 ,30);
	
	}
	
	public void update(){
		
		force += 3;
		if(force == 234) {
			force = 231;
		}
	}
	
	public void reset() {
		xPosition = 100;
		yPosition = 290;
		force = 0;
	}
	
	public int getForce(){

		return force;
	}
	public void rockMove(){
		if(m<force && MeowGame.checkForce){
			xPosition += 2;
			if(m<force/2)
				yPosition -= 1;
			else
				yPosition += 1;
				m++;
			if(m>=force){
				MeowGame.checkForce = false;
				m=0;
			}
		}
	}
}
