package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.Path;

/**
 * Prototype of composite path
 * @author Francesco Raco
 */
abstract public class CompositePath extends Path
{
	/**
	 * Array of paths
	 */
	protected Path[] path;
	
	/**
	 * Current path
	 */
	protected Path delegate;
	
	/**
	 * Current index of the array of paths
	 */
	protected int current = 0;
	
	/**
	 * If path is a loop
	 */
	protected boolean isLoop = false;
			
	/**
	 * Enemy with this path (optional)
	 */
	protected Enemy e;
	
	
	public CompositePath() {}
	
	/**
	 * Set enemy (optional)
	 * @param e the enemy to assign to protected field e
	 */
	public void setEnemy(Enemy e)
	{
		this.e = e;
	}
	
	/**
	 * Override in order to set (eventually) a loop for the path
	 * @param speed Float speed value
	 * @return The next position (in function of speed)
	 */
	@Override
	public Vector2 getNextPositionIncrement(float speed)
	{
		if (delegate.isComplete())
		{
			if (current < path.length - 1) delegate = path[++current];
			else if (current == path.length - 1 && isLoop) reset();
		}
		return delegate.getNextPositionIncrement(speed);
	}

	@Override
	public boolean isComplete()
	{
		return current == path.length -1 && delegate.isComplete() && !isLoop;
	}
	
	@Override
	public float getX(float speed)
	{
		return e.getPosition().x;
	}
	
	@Override
	public float getY(float speed)
	{
		return e.getPosition().y;
	}

	@Override
	public void reset()
	{
		for (Path p : path) p.reset();
		current = 0;
		delegate = path[current];
	}

}
