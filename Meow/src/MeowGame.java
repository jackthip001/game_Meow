import java.util.ArrayList;

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
	private PlayerMan man;
	public ArrayList<Player> players;
	
	private ObjectRock rock;
	
	public static boolean gemeStart = false;
	public static boolean gameOver = false;
	public static String checkPlayer = "CAT";
	public static boolean checkForce = false;
	public static boolean getHited = false;
	
	private String hpMeow;
	private String hpMan;
	public static String stateGame;
//	private String message = "Press any key, mouse button, or drag the mouse";
	
	public MeowGame(String title) {
		super(title);
		players = new ArrayList<Player>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		backGround.draw(0,0);
		for(Player player : players) {
			player.render();
		}
	//	g.drawString(message, 10, 50);
		g.drawString(hpMeow, 10 , 50);
		g.drawString(hpMan, 550, 50);
		if(checkForce){
			rock.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		backGround = new Image("res/BackGround2.png");
		cat = new PlayerMeow();
		man = new PlayerMan();
		players.add(cat);
		players.add(man);
		
		rock = new ObjectRock();
		
		upDateHP();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		for(Player player : players) {
			player.hitedRock();
		}
		upDateHP();
		Input input = container.getInput();
		if(!gameOver) {
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
//		message = "You pressed key code "+key+" (character = "+c+")";
		if (key == Input.KEY_SPACE) {
			checkForce = true;
			
	    }
	}
	
	public static boolean catPlay() {
		return checkPlayer.equals("CAT");
	}
	
	private void upDateHP() {
		hpMeow = "HP : " + PlayerMeow.HP;
		hpMan = "HP : " + PlayerMan.HP;
	}
}
