package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

/**
 * Snake path
 * @author Francesco Raco
 */
public class SnakePath extends CompositePath
{
	/**
	 * Directions of the sides
	 */
	private LineDirection dir1, dir2, dir3;
		
	
	/**
	 * Integer sides
	 */
	private int side1, side2, side3;
	 
	
	/**
	 * Constructor with first and second direction, and all sides integer value
	 * @param dir1 The first direction
	 * @param dir2 The second direction
	 * @param side1 The first integer side value
	 * @param side2 The second integer side value
	 * @param side3 The third integer side value
	 */
	public SnakePath(LineDirection dir1, LineDirection dir2, int side1, int side2, int side3)
	{
		path = new Path[]
				{
				   new LinePath(dir1, side1),
				   new LinePath(dir2, side2),
				   new LinePath(dir1, side3)
				};
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.dir3 = dir3;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param dir1 The first direction
	 * @param dir2 The second direction
	 * @param side1 The first integer side value
	 * @param side2 The second integer side value
	 * @param side3 The third integer side value
	 * @param isLoop If the path is a loop
	 */
	public SnakePath(LineDirection dir1, LineDirection dir2, int side1, int side2, int side3, boolean isLoop)
	{
		this(dir1, dir2, side1, side2, side3);
		super.isLoop = isLoop;
	}
	
	public LineDirection getFirstDirection() {return dir1;}
	
	public LineDirection getSecondDirection() {return dir2;}
	
	public int getFirstSide() {return side1;}
	
	public int getSecondSide() {return side2;}
	
	public int getThirdSide() {return side3;}

}
