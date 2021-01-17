package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;


/**
 * Zig-zag path
 * @author Francesco Raco
 */
public class ZigZagPath extends CompositePath
{
	/**
	 * Direction of the sides
	 */
	private LineDirection dir1, dir2;
	
	/**
	 * Side integer value
	 */
	private int side;
	
	/**
	 * Constructor with the first direction and integer value for both sides
	 * @param dir1 The first direction of the path
	 * @param side The integer value for both sides
	 */
	public ZigZagPath(LineDirection dir1, int side)
	{
		super();
		this.dir1 = dir1;
		this.side = side;
		switch(dir1)
		{
		case DOWNRIGHT: dir2 = LineDirection.DOWNLEFT;
		case DOWNLEFT: dir2 = LineDirection.DOWNRIGHT;
		case UPRIGHT: dir2 = LineDirection.UPLEFT;
		case UPLEFT: dir2 = LineDirection.UPRIGHT;
		default: dir1 = LineDirection.DOWNRIGHT; dir2 = LineDirection.DOWNLEFT;
		}
		path = new Path[]
				{
				   new LinePath(dir1, side),
				   new LinePath(dir2, side),
				   new LinePath(dir1, side),
				   new LinePath(dir2, side)
		        };
		delegate = path[current];
    }
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param dir1 The first direction of the path
	 * @param side The integer value for both sides
	 * @param isLoop If the path is a loop
	 */
	public ZigZagPath(LineDirection dir1, int side, boolean isLoop)
	{
		this(dir1, side);
		super.isLoop = isLoop;
	}
	
}
