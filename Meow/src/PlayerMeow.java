import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class PlayerMeow implements Player{

	private Image image;
	
	public static final int X_Position = 50;
	public static final int Y_Position = 320;
	public static final int SIZE_MEOW = 100;
	
	public static int HP = 12;
	
	public PlayerMeow() throws SlickException{
		image = new Image("res/playerCat.png");

	}
	
	public void render(){
		image.draw(X_Position, Y_Position, SIZE_MEOW , SIZE_MEOW );
		
	}

	public void hitedRock() {
		int checkX = ObjectRock.getX(MeowGame.catPlay());
		int checkY = ObjectRock.getY();
		if(checkX <= X_Position + 99) {
			if(checkY >= Y_Position) {
				MeowGame.getHited = true;
				System.out.println("hited!");
			}
		}
		if(HP == 0) {
			
		}
	}
}
