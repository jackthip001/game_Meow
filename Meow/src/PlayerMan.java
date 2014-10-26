import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class PlayerMan implements Player{

	private Image image;

	public static final int X_Position = 500;
	public static final int Y_Position = 320;
	public static final int SIZE_MAN = 100;
	
	public static int HP = 12;
	
	public PlayerMan() throws SlickException {
		image = new Image("res/playerMan.png");
	}

	public void render(){
		image.draw(X_Position, Y_Position, SIZE_MAN, SIZE_MAN);
		
	}
	
	public void hitedRock() {
		int checkX = ObjectRock.getX(MeowGame.catPlay());
		int checkY = ObjectRock.getY();
		if(checkX >= X_Position && X_Position + SIZE_MAN >= checkX) {
			if(checkY >= Y_Position) {
				MeowGame.getHited = true;
				System.out.println("hited!");
			}
		}
		if(HP == 0) {
			MeowGame.gameOver = true;
			MeowGame.stateGame = "MEOW WIN!";
		}
	}
}
