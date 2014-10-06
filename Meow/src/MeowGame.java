import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class MeowGame extends BasicGame {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	Image backGround;
	private PlayerMeow cat;
	private ObjectRock rock;
	
	public static boolean checkForce = false;
	
	private String message = "Press any key, mouse button, or drag the mouse";
	
	public MeowGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		backGround.draw(0,0);
		cat.render();
		g.drawString(message, 10, 50);
		if(checkForce){
			rock.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		backGround = new Image("res/BackGround2.png");
		cat = new PlayerMeow();
		rock = new ObjectRock();
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = container.getInput();
	    if (input.isKeyDown(Input.KEY_SPACE)) { 
	      rock.update();
	      System.out.println(rock.getForce());
	    }
	    if(checkForce){
	    	rock.rockMove();
	    	if(!checkForce){
	    		rock.reset();
	    	}
	    	
	    }
	}
	
	public static void main(String[] args) {
		try {
			MeowGame game = new MeowGame("Meow Game");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
	

	
	public void keyReleased(int key, char c) {
		message = "You pressed key code "+key+" (character = "+c+")";
		if (key == Input.KEY_SPACE) {
			checkForce = true;
			
	    }
	}
}
