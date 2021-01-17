package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.framework.GfxEntity;
import it.insidecode.spacetagger.framework.Level;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.util.Rectangle;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Black hole (access point to next scenes)
 * @author Francesco Raco
 */
public class BlackHole extends GfxEnemy
{

	/**
	 * Damage value which inflicts to its enemies
	 */
	public static final float DAMAGE_VALUE = 1000;
	
	/**
	 * Max energy value of the black hole (it does not care)
	 */
	public static final float ENERGY_VALUE = 0;
	
	/**
	 * Score value assigned after death
	 */
	public static final int SCORE_VALUE = 0;
	
	/**
	 * Speed value of the black hole
	 */
	public static final float SPEED_VALUE = 0;
	
	/**
	 * Current instance of SceneModel
	 */
	private SceneModel scene;

	/**
	 * Current instance of framework
	 */
	private Framework framework;

	/**
	 * Constructor with framework and position
	 * @param framework The framework
	 * @param position The Vector2 position of the monster
	 */
	public BlackHole(final Framework framework, Vector2 position)
	{
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("blackhole"),
				PropertiesManager.getParameter("explosion"));
		this.framework = framework;
		this.body = new Rectangle(this.getCenter(), 0, 0);
	}

	/**
	 * Set the current scene
	 * @param scene The current scene
	 */
	public void setScene(SceneModel scene) {this.scene = scene;}
	
	/**
	 * Make black hole immortal
	 */
	@Override
	public void destroy() {}
	
	/**
	 * Handle the collision with an other physics entity: if it collides with the ship, it disappears and current scene ends
	 * @param e The physics entity with which collides
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		if (e instanceof Ship && !scene.isComplete())
			{
				float energy = e.getEnergy();
				e.setEnergy(energy + 3);
				
				Gdx.audio.newSound(Gdx.files
						.internal((PropertiesManager.getParameter("newShipSound")))).play();
				framework.setShip(new DreamShip(framework, new Vector2(framework.getShip().getPosition())));
				
			    scene.complete();
			    this.deactivate();
			}
		super.handleContact(e);
	}
	
	/**
	 * Remove intersections with other physics entities
	 * @param e The physics entity with which collides
	 * @return false
	 */
	@Override
	public boolean intersects(DynamicPhysicsEntity e)
	{
		return false;
	}
}
