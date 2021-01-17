package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.Rectangle;

/**
 * Rock barrier
 * @author Francesco Raco
 */
public class RockBarrier extends EnemyModel
{
	/**
	 * Max energy value of the monster
	 */
	public static final float ENERGY_VALUE = 10;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 800;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = (float)0.5;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float SPEED_VALUE = 0;
		
	/**
	 * Current instance of framework
	 */
	private Framework framework;
	
	/**
	 * Constructor with the current instance of framework and the position
	 * @param framework The current instance of framework
	 * @param position The position of the rock barrier
	 */
	public RockBarrier(Framework framework, Vector2 position)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "rockBarrier", "rockExp");
		this.framework = framework;
	}
	
	@Override
	public void setRotation(float angle)
	{
		this.body = new Rectangle(this.getCenter(), 5, 5);
		super.setRotation(angle);
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
			destroy();
		    super.handleContact(e);
		}
	}

}
