package it.insidecode.racogame.framework.level;

	import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.logic.Direction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

/**
 * Bonus coin (extra life and new graphic for the ship)
 * @author Francesco Raco
 */
public class MonetinaBonus extends GfxPowerUp
    {
	   /**
	   * Max energy value of this entity
	   */
	    public static final float ENERGY_VALUE = 1;
	    
	    /**
	     * Extra life for the ship
	     */
	    public static final float ENERGY =  1;
	    
	    /**
	     * Bonus sound
	     */
	    private static Sound bonusSound = Gdx.audio.newSound(Gdx.files
				.internal((PropertiesManager.getParameter("coin"))));
	    
	    /**
	     * New Ship sound
	     */
	    private static Sound newShipSound = Gdx.audio.newSound(Gdx.files
				.internal((PropertiesManager.getParameter("newShipSound"))));

		/**
		 * Current instance of framework
		 */
	    private Framework framework;

		/**
		 * Construtor with the current instance of framework and the position of the coin
		 * @param f The current instance of framework
		 * @param center The position of the coin
		 */
	    public MonetinaBonus(Framework f, Vector2 center) {
			super(f, center, PropertiesManager.getParameter("monetina"));
			this.setCenter(center);
			this.framework = f;
		}

		/**
		 * Override in order to increase the life of the ship and, if its energy value is greater or equal to 2, improve its graphics and type of shot
		 */
	    @Override
		public void apply()
		{
			bonusSound.play();
			framework.getShip().setEnergy(framework.getShip().getEnergy() + ENERGY);
			if (framework.getShip().getEnergy() >= 2)
				{
				   newShipSound.play();
				   framework.setShip(new DreamShip(framework, new Vector2(framework.getShip().getPosition())));
				}
		}
		
		/**
		 * Override in order to personalize the logic state of the coin (moving it down)
		 */
	    @Override
		public void update(float delta)
		{
			super.update(delta);
			move(Direction.DOWN);
		}

	}


