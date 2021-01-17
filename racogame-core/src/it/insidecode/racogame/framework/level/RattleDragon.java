package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class RattleDragon extends ShootingEnemy
{
	/**
	 * Shot time
	 */
	public static final float TIME = 500;
	
	/**
	 * Max energy value of the monster
	 */
	public static float ENERGY_VALUE = 1;
	
	/**
	 * Score value assigned after death
	 */
	public static int SCORE_VALUE = 400;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static float DAMAGE_VALUE = 1;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static float SPEED_VALUE = 6;
	
	/**
	 * Shot sound
	 */
	private static Sound shotSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("flameSound"))));
	
	/**
	 * Constructor with type of shot and shot decorator
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 */
	public RattleDragon(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, "rattleDragon",
				"ratExp", shotSound, TIME, shot, shotDec);
		super.framework = framework;
	}
	
	/**
	 * Constructor with a maximum number of shots allowed
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 * @param maxShots The max number of shots allowed
	 */
	public RattleDragon(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec, int maxShots)
	{
		this(framework, position, shot, shotDec);
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
	public RattleDragon(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec, boolean unlimited)
	{
		this(framework, position, shot, shotDec);
		super.unlimited = unlimited;
	}

	/**
	 * Handle the collision with an other physics entity, damaging it if it is the ship (1 point)
	 * @param e the physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		if (e instanceof Ship) e.damage(1);
		super.handleContact(e);
	}


}
