package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Planet boss
 * @author Francesco Raco
 */
public class PlanetBoss extends EnemyModel
{
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = (float) 0.5;
	
	/**
	 * Max energy value of the monster
	 */
	public static final float ENERGY_VALUE = 5;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 100;
	
	/**
	 * Speed value of the monster
	 */
	public static final float SPEED_VALUE = 3;
	
	/**
	 * Float value used to synchronize smart path
	 */
	public static final float PATH_TIME = 50;
	
	/**
	 * Current instance of framework
	 */
	private Framework framework;
	
	/**
	 * Timer used to synchronize smart path
	 */
	private float timer = PATH_TIME;
	
	/**
	 * Initial position of the boss
	 */
	private Vector2 initialPos;
	
	/**
	 * If is in movement
	 */
	private boolean isInMovement = false;
	
	/**
	 * Constructor with callback to call after dead
	 * @param framework The framework
	 * @param position The position
	 * @param scl The callback to call after dead
	 */
	public PlanetBoss(Framework framework, Vector2 position, SimpleCallback scl)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "planet",
				"planetExp", scl);
		this.framework = framework;
		this.initialPos = position;
	}
	
	/**
	 * Handle the collision with an other physics entity, damaging it if it is the ship (2 points)
	 * @param e The physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity entity)
	{
		if (entity instanceof Ship) entity.damage(2);
		super.handleContact(entity);
	}
	
	/**
	 * Override in order to synchronize smart path
	 */
	@Override
	public void update(float delta)
	{
		if (framework.getShip().getPosition().x >= 170 && framework.getShip().getPosition().y >= 450)
		{
			if ((timer += delta) > PATH_TIME)
		    {
				move(framework.getShip().getPosition());
		        timer = 0;
		        isInMovement = true;
		    }
		}
		else move(initialPos);
		super.update(delta);
	}

}

