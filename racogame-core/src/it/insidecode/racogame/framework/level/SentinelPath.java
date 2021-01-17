package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

/**
 * Left-right/right-left path
 * @author Francesco Raco
 */
public class SentinelPath extends CompositePath
{
	private LineDirection dir1;
	private LineDirection dir2;
	
	/**
	 * Constructor with the first direction and the integer value of the width
	 * @param dir The first direction
	 * @param width The width of the path
	 */
	public SentinelPath(MyDirection dir, int width)
	{
		super();
		switch(dir)
		{
		   case LEFT: dir1 = LineDirection.LEFT; dir2 = LineDirection.RIGHT; break;
		   case RIGHT: dir1 = LineDirection.RIGHT; dir2 = LineDirection.LEFT; break;
		   case UP: dir1 = LineDirection.UP; dir2 = LineDirection.DOWN; break;
		   case DOWN: dir1 = LineDirection.DOWN; dir2 = LineDirection.UP; break;
		}
	    path = new Path[]
	    		{
	    		   new LinePath(dir1, width),
	    		   new LinePath(dir2, width)
	    		};
	    delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param dir The first direction
	 * @param width The width of the path
	 * @param isLoop If the path is a loop
	 */
	public SentinelPath(MyDirection dir, int width, boolean isLoop)
	{
		this(dir, width);
		super.isLoop = isLoop;
	}

}
