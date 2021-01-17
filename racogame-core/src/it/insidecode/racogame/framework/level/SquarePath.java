package it.insidecode.racogame.framework.level;

import java.util.ArrayList;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;

import com.badlogic.gdx.math.Vector2;

/**
 * Square path
 * @author Francesco Raco
 */
public class SquarePath extends CompositePath
{
	/**
	 * Lista delle direzioni dello sparo composto
	 */
	private ArrayList<LineDirection> directions = new ArrayList<LineDirection>();
	private int side;
	
	/**
	 * Default constructor
	 * @param corner The initial corner
	 * @param myDir The poligonal direction
	 * @param side The integer side value
	 */
	public SquarePath(Corner corner, PoligonalDirection myDir, int side)
	{
		this.side = side;
		switch(corner)
		{
		case UPLEFT: switch(myDir)
		             {
		               case HORIZONTAL: directions.add(LineDirection.RIGHT);
		                                directions.add(LineDirection.DOWN);
		                                directions.add(LineDirection.LEFT);
		                                directions.add(LineDirection.UP); break;
		               
		               case VERTICAL:   directions.add(LineDirection.DOWN);
                                        directions.add(LineDirection.RIGHT);
                                        directions.add(LineDirection.UP);
                                        directions.add(LineDirection.LEFT); break;
		             }; break;
		
		case UPRIGHT: switch(myDir)
                      {
                          case HORIZONTAL: directions.add(LineDirection.LEFT);
                                           directions.add(LineDirection.DOWN);
                                           directions.add(LineDirection.RIGHT);
                                           directions.add(LineDirection.UP); break;
          
                          case VERTICAL:   directions.add(LineDirection.DOWN);
                                           directions.add(LineDirection.LEFT);
                                           directions.add(LineDirection.UP);
                                           directions.add(LineDirection.RIGHT); break;
                     }; break;
                     
		case DOWNLEFT: switch(myDir)
                       {
                           case HORIZONTAL: directions.add(LineDirection.RIGHT);
                                            directions.add(LineDirection.UP);
                                            directions.add(LineDirection.LEFT);
                                            directions.add(LineDirection.DOWN); break;

                           case VERTICAL:   directions.add(LineDirection.UP);
                                            directions.add(LineDirection.RIGHT);
                                            directions.add(LineDirection.DOWN);
                                            directions.add(LineDirection.LEFT); break;
                       }; break;
       
	    case DOWNRIGHT: switch(myDir)
        {
            case HORIZONTAL: directions.add(LineDirection.LEFT);
                             directions.add(LineDirection.UP);
                             directions.add(LineDirection.RIGHT);
                             directions.add(LineDirection.DOWN); break;

            case VERTICAL:   directions.add(LineDirection.UP);
                             directions.add(LineDirection.LEFT);
                             directions.add(LineDirection.DOWN);
                             directions.add(LineDirection.RIGHT); break;
       }; break;
       }
		path = new Path[]
				{
				  new LinePath(directions.get(0), side),
				  new LinePath(directions.get(1), side),
				  new LinePath(directions.get(2), side),
				  new LinePath(directions.get(3), side)
				};
		delegate = path[current];
	}
	
	/**
	 * Constructor which lets to set a loop for the path
	 * @param corner The initial corner
	 * @param myDir The poligonal direction
	 * @param side The integer side value
	 * @param isLoop If the path is a loop
	 */
	public SquarePath(Corner corner, PoligonalDirection myDir, int side, boolean isLoop)
	{
		this(corner, myDir, side);
		super.isLoop = isLoop;
	}
}
