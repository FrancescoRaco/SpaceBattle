package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.Constants;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

/**
 * Alien monster
 * @author Francesco Raco
 */
public class AlienMonster extends ShootingEnemy
{
    /**
     * Shot time
     */
	public static final float TIME = 1000;
	
	/**
	 * Max energy value of the monster
	 */
	public static final float ENERGY_VALUE = 1;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 350;
	
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = 1;
	
	/**
	 * Speed value of the monster
	 */
	public static final float SPEED_VALUE = 6;
	
	/**
	 * Shot sound
	 */
	private static Sound shotSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("flameSound"))));
	
	/**
	 * Constructor with type of shot and shot decorator
	 * @param framework  The framework
	 * @param position The Vector2 position of the monster
	 * @param shot The type of shot
	 * @param shotDec The type of shot decorator
	 */
	public AlienMonster(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE,"alienMonster", "ratExp", shotSound, TIME, shot, shotDec);
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
	public AlienMonster(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec, int maxShots)
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
	public AlienMonster(Framework framework, Vector2 position, Shot shot, ShotDecorator shotDec, boolean unLimited)
	{
		this(framework, position, shot, shotDec);
		super.unlimited = unlimited;
	}

	/**
	 * Handle the collision with an other physics entity, damaging it if this is the ship (2 points)
	 * @param e the physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		if (e instanceof Ship) e.damage(2);
		super.handleContact(e);
	}

}