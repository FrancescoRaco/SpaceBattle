package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

/**
 * Cusp path
 * @author Francesco Raco
 */
public class CuspPath extends CompositePath
{
	/**
	 * Directions of the path
	 */
	private LineDirection dir1, dir2, dir3, dir4;
	
	/**
	 * Integer value referring to the side of the path
	 */
	private int side;
	
	/**
	 * Constructor with the direction of the first side
	 * @param dir1 The first direction of the path
	 * @param side The integer value of the side
	 */
	public CuspPath(LineDirection dir1, int side)
	{
		switch(dir1)
		{
		   case DOWNRIGHT: dir2 = LineDirection.UPRIGHT; dir3 = LineDirection.DOWNRIGHT; dir4 = LineDirection.UPRIGHT; break;
		   case DOWNLEFT: dir2 = LineDirection.UPLEFT; dir3 = LineDirection.DOWNLEFT; dir4 = LineDirection.UPLEFT; break;
		   case UPRIGHT: dir2 = LineDirection.DOWNRIGHT; dir3 = LineDirection.UPRIGHT; dir4 = LineDirection.DOWNRIGHT; break;
		   case UPLEFT: dir2 = LineDirection.DOWNLEFT; dir3 = LineDirection.UPLEFT; dir4 = LineDirection.DOWNLEFT; break;
		   default: dir1 = LineDirection.UPRIGHT; dir2 = LineDirection.DOWNRIGHT; dir3 = LineDirection.UPRIGHT; dir4 = LineDirection.DOWNRIGHT; break;
		}
		this.dir1 = dir1;
		this.side = side;
		path = new Path[]
				{
				   new LinePath(dir1, side), new LinePath(dir2, side),
				   new LinePath(dir3, side), new LinePath(dir4, side)
				};
		delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param dir1 The first direction of the path
	 * @param side The integer value of the side
	 * @param isLoop If the path is a loop
	 */
	public CuspPath(LineDirection dir1, int side, boolean isLoop)
	{
		this(dir1, side);
		super.isLoop = isLoop;
	}

}
