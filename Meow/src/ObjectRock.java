import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ObjectRock {
private Image image;
	
	private int xPositionCAT = 100;
	private int yPositionCAT = 290;
	
	private int xPositionMAN = 499;
	private int yPositionMAN = 290;
	
	private int checkDistance = 0;
	
	private int force;
	
	public ObjectRock() throws SlickException{
		image = new Image("res/FlintStone.png");
		reset();
	}
	
	public void render(){
		if(MeowGame.checkPlayer.equals("CAT"))
			image.draw(xPositionCAT, yPositionCAT,30 ,30);
		else
			image.draw(xPositionMAN, yPositionMAN,30 ,30);
	}
	
	public void update(){
		force += 3;
		if(force == 234) {
			force = 231;
		}
	}
	
	public void reset() {
		xPositionCAT = 100;
		yPositionCAT = 290;
		xPositionMAN = 499;
		yPositionMAN = 290;
		force = 0;
	}
	
	public int getForce() {
		return force;
	}
	
	public void rockMove(){ 
		if(checkDistance<force && MeowGame.checkForce) {
			if(MeowGame.checkPlayer.equals("CAT")) {
				catThrow();
			}
			else {
				manThrow();
			}
			
			checkDistance++;
			
			controlPlayerAndReset();
			
		}
	}

	private void controlPlayerAndReset() {
		if(checkDistance >= force){
			MeowGame.checkForce = false;
			checkDistance = 0;
			if(MeowGame.checkPlayer.equals("CAT"))
				MeowGame.checkPlayer = "MAN";
			else
				MeowGame.checkPlayer = "CAT";
		}
	}

	private void manThrow() {
		xPositionMAN -= 3;
		if(checkDistance < force/3)
			yPositionMAN -= 1;
		else
			yPositionMAN += 1;
	}

	private void catThrow() {
		xPositionCAT += 3;
		if(checkDistance < force/3)
			yPositionCAT -= 1;
		else
			yPositionCAT += 1;
	}
}
