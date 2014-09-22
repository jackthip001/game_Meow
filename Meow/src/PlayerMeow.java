import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class PlayerMeow {

	private Image image;
	
	public static final int X_Position = 50;
	public static final int Y_Position = 320;
	
	public PlayerMeow() throws SlickException{
		image =new Image("res/playerCat.png");

	}
	public void render(){
		image.draw(X_Position, Y_Position, 100, 100);
		
	}
//	public void update() {
//		y+=vy;
//		vy-=FlappyDotGame.G;
//	}
}
