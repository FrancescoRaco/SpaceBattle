package it.insidecode.racogame.framework.level;

import java.util.Random;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

/**
 * Prototype of the shooting enemy
 * @author Francesco Raco
 */
abstract public class ShootingEnemy extends EnemyModel
{
	/**
	 * Current instance of framework
	 */
	protected Framework framework;
	
	/**
	 * Type of shot (default is SimpleShot)
	 */
	protected Shot shot;
	
	/**
	 * Type of shot decorator
	 */
	protected ShotDecorator shotDec;
	
	/**
	 * Shot sound
	 */
	protected Sound shotSound;
	
	/**
	 * If shots are unlimited
	 */
	protected boolean unlimited = false;
	
	/**
	 * If there are multiple shots
	 */
	protected boolean isShootAll = false;
	
	/**
	 * Shot time
	 */
	protected float shotTime;
	
    
	/**
	 * Timer used to synchronize shots
	 */
	protected float timer = 0;
	
	/**
	 * Occurrences of shots
	 */
	protected int shots = 0;
	
	/**
	 * Max number of shots allowed
	 */
	protected int maxShots = -1;
	
	
	/**
	 * Default constructor
	 * @param framework The framework
	 * @param position The Vetor2 position
	 * @param ENERGY_VALUE The enrgy value
	 * @param SCORE_VALUE The score value
	 * @param DAMAGE_VALUE The damage value
	 * @param SPEED_VALUE The speed value
	 * @param s1 The animation string
	 * @param s2 The animation string (on dead)
	 * @param shotSound The shot sound
	 * @param shotTime The shot sound
	 * @param shot The shot to set
	 * @param shotDec The shot decorator to set
	 */
	public ShootingEnemy(Framework framework, Vector2 position, final float ENERGY_VALUE, final int SCORE_VALUE, final float DAMAGE_VALUE,
				final float SPEED_VALUE, String s1, String s2, Sound shotSound, final float shotTime, Shot shot, ShotDecorator shotDec)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, s1,
				s2);
		initAction(shotSound, shotTime, shot, shotDec);
	}
	
	/**
	 * Constructor with final callback
	 * @param framework The framework
	 * @param position The Vetor2 position
	 * @param ENERGY_VALUE The enrgy value
	 * @param SCORE_VALUE The score value
	 * @param DAMAGE_VALUE The damage value
	 * @param SPEED_VALUE The speed value
	 * @param s1 The animation string
	 * @param s2 The animation string (on dead)
	 * @param shotSound The shot sound
	 * @param shotTime The shot sound
	 * @param shot The shot to set
	 * @param shotDec The shot decorator to set
	 */
	public ShootingEnemy(Framework framework, Vector2 position, final float ENERGY_VALUE, final int SCORE_VALUE, final float DAMAGE_VALUE,
			final float SPEED_VALUE, String s1, String s2, Sound shotSound, final float shotTime, Shot shot, ShotDecorator shotDec, SimpleCallback scl)
    {
	    super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
			    SPEED_VALUE, s1,
			    s2, scl);
	    initAction(shotSound, shotTime, shot, shotDec);
    }
	
	/**
	 * Initial action
	 * @param shotSound The shot sound to set
	 * @param shotTime The shot time to set
	 * @param shot The shot to set
	 * @param shotDec The shot decorator to set
	 */
	private void initAction(Sound shotSound, float shotTime, Shot shot, ShotDecorator shotDec)
	{
		this.shotSound = shotSound;
		this.shotTime = shotTime;
		this.shot = shot;
		shot.activate();
		setShot(shot);
		this.shotDec = shotDec;
		setShotDecorator(shotDec.getClass());
	}
	
	/**
	 * Override in order to choose if shots are unlimited or not
	 */
	@Override
	public Shot shoot()
	{
		if (shots < maxShots || unlimited) {shotSound.play(); shots++;}
		return super.shoot();
	}
	
	/**
	 * Override in order to personalize use of shoot() or shootAll()
	 */
	@Override
	public void update(float delta)
	{
		super.update(delta);
		if ((timer += delta) > shotTime)
		{
			timer = -new Random().nextInt(1500);
			if (isAlive() && getPosition().x >= 0 && getPosition().x <= 480
					&& getPosition().y >= 0 && getPosition().y <= 640)
				{
				   if (!isShootAll) shoot();
				   else shootAll();
				}
		}
	}

}
