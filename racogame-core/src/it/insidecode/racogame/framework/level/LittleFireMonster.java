package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;

/**
 * Little fire monster
 * @author Francesco Raco
 */
public class LittleFireMonster extends EnemyModel
{
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = (float) 0.5;
	
	/**
	 * Max energy value of the monster
	 */
	public static final float ENERGY_VALUE = 1;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 100;
	
	/**
	 * Speed value of the monster
	 */
	public static final float SPEED_VALUE = 3;
	
	/**
	 * Current instance of framework
	 */
	private Framework framework;
	
	/**
	 * Constructor with framework and position
	 * @param framework  The framework
	 * @param position The Vector2 position of the monster
	 */
	public LittleFireMonster(Framework framework, Vector2 position)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "littleFireMonster",
				"defExp");
		this.framework = framework;
	}
	
	/**
	 * Handle the collision with an other physics entity, damaging it if this is the ship (0.5 point)
	 * @param e the physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity entity)
	{
		if (entity instanceof Ship) entity.damage((float)0.5);
		super.handleContact(entity);
	}

}
