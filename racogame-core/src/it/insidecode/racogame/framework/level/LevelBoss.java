package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.HorizontalBar;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.Rectangle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Level boss
 * @author Francesco Raco
 */
public class LevelBoss extends ShootingEnemy
{
	/**
	 * Shot time
	 */
	public static final float TIME = 500;
	
	/**
	 * Max energy value of the monster
	 */
	public static float ENERGY_VALUE = 10;
	
	/**
	 * Score value assigned after death
	 */
	public static int SCORE_VALUE = 2000;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static float DAMAGE_VALUE = .1f;
	
	/**
	 * Speed value of the monster
	 */
	public static float SPEED_VALUE = .8f;
	
	/**
	 * Float value used to synchronize smart path
	 */
	public static final float PATH_TIME = 50;
	
	/**
	 * Timer used to synchronize smart path
	 */
	private float timer = PATH_TIME;
	
	/**
	 * Private field used to save previous position of the ship
	 */
	private Vector2 shipPos = new Vector2(100, 200);
	
	/**
	 * shot sound
	 */
	private static Sound shotSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("flameSound"))));
	
	/**
	 * Boss bar
	 */
	private HorizontalBar bossBar;
	
	/**
	 * Constructor with type of shot and shot decorator
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 */
	public LevelBoss(Framework framework, Vector2 position, HorizontalBar bossBar, Shot shot, ShotDecorator shotDec)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE,"zombieDrag",
				"defExp", shotSound, TIME, shot, shotDec);
		this.body = new Rectangle(getCenter(), 30, 30);
		this.bossBar = bossBar;
		super.framework = framework;
		addChildEntity(bossBar);
		isShootAll = true;
	}
	
	/**
	 * Constructor with a maximum number of shots allowed
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 * @param maxShots The max number of shots allowed
	 */
	public LevelBoss(Framework framework, Vector2 position, HorizontalBar bossBar, Shot shot, ShotDecorator shotDec, int maxShots)
	{
		this(framework, position, bossBar, shot, shotDec);
		super.maxShots = maxShots;
	}
	
	/**
	 * Constructor which lets to set a loop for the shots
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 * @param unLimited If shots are unlimited
	 */
	public LevelBoss(Framework framework, Vector2 position, HorizontalBar bossBar, Shot shot, ShotDecorator shotDec, boolean unlimited)
	{
		this(framework, position, bossBar, shot, shotDec);
		super.unlimited = unlimited;
	}
	
	/**
	 * Handle the collision with an other physics entity: when the ship is attacked, it moves to opposite direction (if the entity is the ship, the boss damage it (0.1 points)
	 * @param e The physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		if (e instanceof Ship)
		{
			e.damage((float)0.1);
		    if (e.getPosition().x >=150 && e.getPosition().x <= 330 && e.getPosition().y >= 150 && e.getPosition().y <= 490)
		    {
			    switch(framework.getShip().getDirection(shipPos, framework.getShip().getPosition()))
			    {
			        case UP: framework.getShip().setPath(new LinePath(LineDirection.DOWN, 150)); break;
			        case DOWN: framework.getShip().setPath(new LinePath(LineDirection.UP, 150)); break;
			        case LEFT: framework.getShip().setPath(new LinePath(LineDirection.RIGHT, 150)); break;
			        case RIGHT: framework.getShip().setPath(new LinePath(LineDirection.LEFT, 150)); break;
			        case UPLEFT: framework.getShip().setPath(new LinePath(LineDirection.DOWNRIGHT, 150)); break;
			        case UPRIGHT: framework.getShip().setPath(new LinePath(LineDirection.DOWNLEFT, 150)); break;
			        case DOWNLEFT: framework.getShip().setPath(new LinePath(LineDirection.UPRIGHT, 150)); break;
			        case DOWNRIGHT: framework.getShip().setPath(new LinePath(LineDirection.UPLEFT, 150)); break;
			    }
		    } 
		}
		super.handleContact(e);
	}
	
	/**
	 * Override in order to enable multiple shots
	 */
	@Override
    public Vector2[] getShotPoint()
    {
  	  return new Vector2[]
  			  {
  			     new Vector2(40, getBody().getHeight()).add(getPosition()),
  			     new Vector2(80, getBody().getHeight()).add(getPosition()),
  			     
              };
    }
	
	/**
	 * Override in order to synchronize smart path
	 */
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > PATH_TIME)
		{
		  move(framework.getShip().getPosition());
		  timer = 0;
		}
	    bossBar.setEnergy(getEnergy());
	    bossBar.setPosition(getPosition());
	    shot.setPosition(getPosition());
	    setShot(shot);
		shipPos = framework.getShip().getPosition();
		super.update(delta);
	}
	
}
