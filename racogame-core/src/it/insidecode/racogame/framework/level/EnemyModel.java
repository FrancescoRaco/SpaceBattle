package it.insidecode.racogame.framework.level;

import java.util.Random;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.util.Rectangle;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

/**
 * Prototype of Enemy
 * @author Francesco Raco
 */
abstract public class EnemyModel extends GfxEnemy
{
	/**
	 * Float value used to change enemy animation when it has been hit
	 */
	public static final float TIME = 250;
	
	/**
	 * Current instance of framework
	 */
	protected Framework framework;
	
	/**
	 * Float value used to save the previous energy value (of the enemy)
	 */
	private float previous = getEnergy();
	
	/**
	 * Animation string
	 */
	private String s1;
	
	/**
	 * Animation string (on dead)
	 */
	private String s2;
	
	/**
	 * Float value used to synchronize animation changes
	 */
	private float timer = 0;
	
	/**
	 * If enemy has just been hit
	 */
	private boolean isExp = false;
		
	/**
	 * Default constructor for the enemy
	 * @param framework The framework
	 * @param position The position
	 * @param ENERGY_VALUE The energy value
	 * @param SCORE_VALUE The score value
	 * @param DAMAGE_VALUE The damage value
	 * @param SPEED_VALUE The speed value
	 * @param s1 String path of animation
	 * @param s2 String path of animation (on dead)
	 */
	public EnemyModel(Framework framework, Vector2 position, final float ENERGY_VALUE, final int SCORE_VALUE, final float DAMAGE_VALUE,
				final float SPEED_VALUE, String s1, String s2)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(s1),
				PropertiesManager.getParameter(s2));
		initAction(s1, s2);
	}
	
	/**
	 * Constructor with callback
	 * @param framework The framework
	 * @param position The position
	 * @param ENERGY_VALUE The energy value
	 * @param SCORE_VALUE The score value
	 * @param DAMAGE_VALUE The damage value
	 * @param SPEED_VALUE The speed value
	 * @param s1 String path of animation
	 * @param s2 String path of animation (on dead)
	 * @param scl Callback to call after dead
	 */
	public EnemyModel(Framework framework, Vector2 position, final float ENERGY_VALUE, final int SCORE_VALUE, final float DAMAGE_VALUE,
			final float SPEED_VALUE, String s1, String s2, SimpleCallback scl)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE, PropertiesManager.getParameter(s1),
				PropertiesManager.getParameter(s2), scl);
		initAction(s1, s2);
	}
	
	/**
	 * Initial action
	 * @param s1 String to be assigned to private field s1
	 * @param s2 String to be assigned to private field s2
	 */
	private void initAction(String s1, String s2)
	{
		this.s1 = s1;
		this.s2 = s2;
	}
	
	/**
	 * Override in order to handle animation changes (when enemy is attacked)
	 */
	@Override
	public void update(float delta)
	{
		if (previous > getEnergy() && isAlive())
		{
			setAnimation(Animation.createAnimation(PropertiesManager.getParameter(s2), AnimationType.LOOP, 1));
			previous = getEnergy();
			isExp = true;
		}
		if (isExp && (timer += delta) > TIME)
		{
			setAnimation(Animation.createAnimation(PropertiesManager.getParameter(s1), AnimationType.LOOP, 1));
			isExp = false;
			timer = 0;
		}
		super.update(delta);
	}
}
