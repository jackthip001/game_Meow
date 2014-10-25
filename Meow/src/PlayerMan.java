import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class PlayerMan {

	private Image image;

	public static final int X_Position = 500;
	public static final int Y_Position = 320;
	
	private static int HP = 12;
	
	public PlayerMan() throws SlickException {
		image = new Image("res/playerMan.png");
	}

	public void render(){
		image.draw(X_Position, Y_Position, 100, 100);
		
	}
	
}
