package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.util.Rectangle;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

/**
 * Star
 * @author Francesco Raco
 */
public class Star extends EnemyModel
{

	/**
	 * Max energy value of the monster
	 */
	public static float ENERGY_VALUE = 1;
	
	/**
	 * Score value assigned after death
	 */
	public static int SCORE_VALUE = 100;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static float DAMAGE_VALUE = (float) 0.5;
	
	/**
	 * Speed value of the monster
	 */
	public static float SPEED_VALUE = 3;
    
	/**
	 * Current instance of framework
	 */
	protected Framework framework;
    
	/**
	 * Powerup (extra life, new graphics and shot for the ship)
	 */
	protected static PowerUp powerUp;

	/**
	 * Constructor with framework, position and powerUp
	 * @param framework The framework
	 * @param position The position of the star
	 * @param powerUp The powerUp to call (after death)
	 */
    public Star(final Framework framework, Vector2 position, PowerUp powerUp)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "stars",
				"defExp",
				new SimpleCallback()
		        {
			       @Override
			       public void onComplete()
			       {
				       Star.powerUp.activate();
			       }
		       });
		Star.powerUp = powerUp;
	    this.framework = framework;
	}
	
    /**
	 * Handle the collision with an other physics entity, damaging it if it is the ship (1 point)
	 * @param e the physics entity with which collides
	 */
    @Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		if (e instanceof Ship)
			{
			   e.damage(1);
			}
		super.handleContact(e);
	}
	
	/**
	 * Override in order to bind the position of powerup with that of the star
	 */
    @Override
	public void update(float delta)
	{
		if (isAlive()) powerUp.setPosition(getPosition());
		super.update(delta);
	}
	
}
