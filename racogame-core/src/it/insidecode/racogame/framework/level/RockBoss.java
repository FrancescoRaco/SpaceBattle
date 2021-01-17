package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;

import com.badlogic.gdx.math.Vector2;

/**
 * Rock boss
 * @author Francesco Raco
 */
public class RockBoss extends EnemyModel
{
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = (float) 0.5;
	
	/**
	 * Max energy value of the rock boss
	 */
	public static final float ENERGY_VALUE = 1;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 100;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float SPEED_VALUE = 4;
	
	/**
	 * Current instance of framework
	 * @param framework The current instance of framework
	 */
	private Framework framework;
	
	
	/**
	 * Constructor with current instance of framework and the position
	 * @param framework The current instance of framework
	 * @param position the position of the rock boss
	 */
	public RockBoss(Framework framework, Vector2 position)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "rockBoss",
				"rockExp");
		this.framework = framework;
	}
	
	/**
	 * Handle the collision with an other physics entity, damaging it if it is the ship (0.5 point)
	 * @param e the physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity entity)
	{
		if (entity instanceof Ship) entity.damage((float)0.5);
		super.handleContact(entity);
	}

}
