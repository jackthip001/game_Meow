import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ObjectRock {
	
	private Image image;
	
	public static final int POSITION_X_CAT = 100;
	public static final int POSITION_X_MAN = 499;
	public static final int POSITION_Y = 290;
	public static final int MAX_FORCE = 231;
	public static final int FORCE_UP = 3;
	public static final int POSITION_X_MOVE = 3;
	public static final int POSITION_Y_MOVE = 1;
	public static final int SIZE_ROCK = 30;
	
	private static int xPositionCat = POSITION_X_CAT;
	private static int xPositionMan = POSITION_X_MAN;
	private static int yPosition = POSITION_Y;
	
	private int checkDistance = 0;
	
	private int force;
	
	public ObjectRock() throws SlickException{
		image = new Image("res/FlintStone.png");
		reset();
	}
	
	public void render(){
		if(MeowGame.checkPlayer.equals("CAT"))
			image.draw(xPositionCat, yPosition,SIZE_ROCK ,SIZE_ROCK);
		else
			image.draw(xPositionMan, yPosition,SIZE_ROCK ,SIZE_ROCK);
	}
	
	public void update(){
		force += FORCE_UP;
		if(force == MAX_FORCE + FORCE_UP) {
			force = MAX_FORCE;
		}
	}
	
	public static int getX(boolean player) {
		if(player)
			return xPositionCat;
		else
			return xPositionMan;
	}
	
	public static int getY() {
		return yPosition;
	}
	
	public void reset() {
		xPositionCat = POSITION_X_CAT;
		xPositionMan = POSITION_X_MAN;
		yPosition = POSITION_Y;
		
		force = 0;
	}
	
	public int getForce() {
		return force;
	}
	
	public void rockMove(){ 
		if(checkDistance<force && MeowGame.checkForce) {
			if(MeowGame.catPlay()) {
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
			if(MeowGame.catPlay()) {
				if(MeowGame.getHited)
					PlayerMeow.HP -= 3;
				MeowGame.checkPlayer = "MAN";
			}
			else {
				if(MeowGame.getHited)
					PlayerMan.HP -= 3;
				MeowGame.checkPlayer = "CAT";
			}
			MeowGame.getHited = false;
		}
	}

	private void manThrow() {
		xPositionMan -= POSITION_X_MOVE;
		yMove();
	}

	private void catThrow() {
		xPositionCat += POSITION_X_MOVE;
		yMove();
	}

	private void yMove() {
		if(checkDistance < force/3)
			yPosition -= POSITION_Y_MOVE;
		else
			yPosition += POSITION_Y_MOVE;
	}

}
