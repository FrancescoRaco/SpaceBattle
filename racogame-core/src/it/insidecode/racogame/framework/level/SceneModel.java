package it.insidecode.racogame.framework.level;

import java.util.ArrayList;
import java.util.Vector;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.path.Type;

/**
 * Scene prototype
 * @author Francesco Raco
 */
abstract public class SceneModel extends Scene
{
	/**
	 * Float value used to synchronize scene end
	 */
	public static final float TIME = 4000;
	
	/**
	 * Timer used to synchronize scene end
	 */
	protected float timer = 0;
	
	/**
	 * Float value used to save the speed of the ship
	 */
	protected float speed;

	/**
	 * List of physis entities
	 */
	protected ArrayList<DynamicPhysicsEntity> entities = new ArrayList<DynamicPhysicsEntity>();
	
	/**
	 * If scene is completed
	 */
	protected boolean isComplete = false;
	
	/**
	 * Default shot
	 */
	protected Shot shot = new SimpleShot(framework.getGameEngine(), new Vector2(10, 10));
	
	/**
	 * Wind sound
	 */
	protected static Sound windSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("windSound"))));
	
	/**
	 * Default ship sound
	 */
	protected static Sound defaultShipSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("defaultShipSound"))));
	
	/**
	 * Constructor with the current instance of framework
	 * @param framework The current instance of framework
	 */
	public SceneModel(Framework framework)
	{
		super(framework);
	}
	
	/**
	 * Check if the scene is completed
	 * @return If completed or not
	 */
	public boolean isComplete() {return isComplete;}
	
	/**
	 * Complete the scene
	 */
	public void complete()
	{
		windSound.play();
		framework.getGameEngine().setBackground(new CloudBackground());
		float speed = framework.getGameEngine().getShip().getSpeed();
		this.speed = speed;
		framework.getGameEngine().getShip().setPosition(new Vector2(100,0));
		framework.getGameEngine().getShip().setSpeed(0);
		removeAllEntities();
		isComplete = true;
	}

	abstract public String getName();
	
	
	/**
	 * Add entity
	 * @param entity The physics entity to add
	 */
	public void addEntity(DynamicPhysicsEntity entity)
	{
		entity.activate();
		entities.add(entity);
		if (entity instanceof BlackHole) ((BlackHole)entity).setScene(this);
	}
	
	/**
	 * Add entity and assign it a path
	 * @param entity The physics entity to add
	 * @param path The path to assign to the entity
	 */
	public void addEntity(DynamicPhysicsEntity entity, Path path)
	{
		entity.setPath(path);
		addEntity(entity);
	}
	
	/**
	 * Add entity and set its speed
	 * @param entity The physics entity to add
	 * @param speed The new speed of the entity
	 */
	public void addEntity(DynamicPhysicsEntity entity, float speed)
	{
		entity.setSpeed(speed);
		addEntity(entity);
	}
	
	/**
	 * Add entity, set its speed and assign it a path
	 * @param entity The physics entity to add
	 * @param speed The new speed of the entity
	 * @param path The path to assign to the entity
	 */
	public void addEntity(DynamicPhysicsEntity entity, float speed, Path path)
	{
		entity.setPath(path);
		addEntity(entity, speed);
	}
	
	/**
	 * remove an entity
	 * @param entity A physics entity
	 */
	public void removeEntity(DynamicPhysicsEntity entity)
	{
		if (entity.isAlive() && entities.contains(entity))
			{
			   entity.deactivate();
			   entities.remove(entity);
			}
	}
	
	/**
	 * Remove all physics entities
	 */
	public void removeAllEntities()
	{
		for (DynamicPhysicsEntity entity : framework.getGameEngine().getEnemies())
		{
			removeEntity(entity);
		}
	}

	@Override
	public void init()
	{
		Gdx.app.log(getName(), "init");
		float energy = framework.getShip().getEnergy();
		if (framework.getShip() instanceof DreamShip) framework.setShip(new DreamShip(framework, new Vector2(framework.getShip().getPosition())));
		else framework.setShip(new DefaultShip(framework, new Vector2(framework.getShip().getPosition())));
		framework.getShip().setEnergy(energy);
	}

	@Override
	public void dispose()
	{
		Gdx.app.log(getName(), "dispose");

	}

	/**
	 * Override in order to personalize the logic of the scene
	 */
	@Override
	public void update(float delta)
	{
		super.update(delta);
		if (isComplete() && (timer += delta) > TIME)
	    {
			getLevel().goToNextScene();
			framework.getGameEngine().getShip().setSpeed(speed);
	    }
		if (framework.getShip() instanceof DreamShip && framework.getShip().getEnergy() < 2.5)
    	{
    		float energy = framework.getShip().getEnergy();
    		framework.setShip(new DefaultShip(framework, framework.getShip().getPosition()));
    	    framework.getShip().setEnergy(energy);
    	    defaultShipSound.play();
    	}
	}

}
