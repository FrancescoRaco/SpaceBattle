package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;

import com.badlogic.gdx.math.Vector2;

/**
 * Ascend to the sides
 * @author Francesco Raco
 */
public class RisaliAiLati extends CompositePath
{
	private LineDirection lineDir; 
	
    /**
     * Constructor with first direction and all sides integer values
     * @param dir The first direction
     * @param muoviGiu The first side integer value
     * @param muoviALato The second side integer value
     * @param muoviSu The third side integer value
     */
	public RisaliAiLati(MyDirection dir, int muoviGiu, int muoviALato, int muoviSu)
	{
		super();
		switch(dir)
		{
		   case LEFT: lineDir = LineDirection.LEFT; break;
		   case RIGHT: lineDir = LineDirection.RIGHT; break;
		}
		path = new Path[]
				{ new LinePath(LineDirection.DOWN, muoviGiu),
				  new LinePath(lineDir, muoviALato),
				  new LinePath(LineDirection.UP, muoviSu),
				};
		delegate = path[current];
	}
    
	/**
     * Constructor which lets to set a loop for the path
     * @param dir The first direction
     * @param muoviGiu The first side integer value
     * @param muoviALato The second side integer value
     * @param muoviSu The third side integer value
     * @param isLoop If the path is in loop
     */
	public RisaliAiLati(MyDirection dir, int muoviGiu, int muoviALato, int muoviSu, boolean isLoop)
    {
    	this(dir, muoviGiu, muoviALato, muoviSu);
    	super.isLoop = isLoop;
    }
}
