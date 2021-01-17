package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;

/**
 * Circle path for physics entities
 * @author Francesco Raco
 */
public class CirclePath extends CompositePath
{
	/**
	 * Direction of the first half path
	 */
	private Type firstHalf;
	
	/**
	 * Direction of the second half path
	 */
	private Type secondHalf;
	
	/**
	 * Constructor with width and height of the path
	 * @param type The direction of the first half path
	 * @param width The width of the path
	 * @param height The height of the path
	 */
	public CirclePath(Type type, int width, int height)
	{
		super();
		firstHalf = type;
		switch(type)
		{
		case DOWNRIGHT: secondHalf = Type.UPRIGHT; break;
		case UPRIGHT: secondHalf = Type.DOWNRIGHT; break;
		case DOWNLEFT: secondHalf = Type.UPLEFT; break;
		case UPLEFT: secondHalf = Type.DOWNLEFT; break;
		case RIGHTDOWN: secondHalf = Type.RIGHTUP; break;
		case RIGHTUP: secondHalf = Type.RIGHTDOWN; break;
		case LEFTDOWN: secondHalf = Type.LEFTUP; break;
		case LEFTUP: secondHalf = Type.LEFTDOWN; break;
		         
		}
		path = new Path[]
				{
				  new HalfCirclePath(firstHalf, width, height/2),
				  new HalfCirclePath(secondHalf, width, height/2)
		        };
		delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param type The direction of the first half path
	 * @param width The width of the path
	 * @param height The height of the path
	 * @param isLoop If the path is a loop
	 */
	public CirclePath(Type type, int width, int height, boolean isLoop)
	{
		this(type, width, height);
		super.isLoop = isLoop;
	}
}
