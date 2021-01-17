package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;


/**
 * "L" path
 * @author Francesco Raco
 */
public class LPath extends CompositePath
{
	private LineDirection dir1;
	private LineDirection dir2;
	
	/**
	 * Constructor with the directions and dimensions of both sides
	 * @param dir1 the first direction
	 * @param myDir the second direction
	 * @param height the height
	 * @param width the width
	 */
	public LPath(LineDirection dir1, MyDirection myDir, int height, int width)
	{
		super();
		switch(dir1)
		{
		case UP: dir1 = LineDirection.UP; break;
		default: dir1 = LineDirection.DOWN; break;
		}
		switch(myDir)
		{
		   case LEFT: dir2 = LineDirection.LEFT; break;
		   case RIGHT: dir2 = LineDirection.RIGHT; break;
		}
		this.dir1 = dir1;
		path = new Path[]
				{
				  new LinePath(dir1, height),
				  new LinePath(dir2, width)
				};
		delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param dir1 the first direction
	 * @param myDir the second direction
	 * @param height the height
	 * @param width the width
	 * @param isLoop if the path is in loop
	 */
	public LPath(LineDirection dir1, MyDirection myDir, int height, int width, boolean isLoop)
	{
		this(dir1, myDir, height, width);
		super.isLoop = isLoop;
	}
	
}
