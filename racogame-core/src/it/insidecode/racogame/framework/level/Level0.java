package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxSimpleText;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.framework.Level;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * My level
 * @author Francesco Raco
 */
public class Level0 extends Level
{
    /**
     * Level name
     */
	public static final String LEVEL_NAME = "Raco Game";
    
	/**
	 * Float value used to synchronize the level end
	 */
	public static final float TIME = 5000;
    
    /**
     * Current instance of framework
     */
	private Framework framework;
	
	/**
	 * Timer used to synchronize the level end
	 */
	private static float timer = 0;
	
	/**
	 * Triumph sound
	 */
	private static Sound triumphSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("triumphSound"))));
	
	/**
	 * Constructor with an instance of framework
	 * @param framework The current instance of framework
	 */
	public Level0(Framework framework)
	{
		super(framework, new Scene01(framework), new Scene02(framework), new Scene03(framework), new Scene04(framework), new Scene05(framework),
				new Scene06(framework), new Scene07(framework), new Scene08(framework), new Scene09(framework), new Scene10(framework));
		
		this.framework = framework;
	}
	
	/**
	 * Override in order to personalize level end (a string will appear and a sound will be played)
	 */
	@Override
	public void complete()
	{
		SceneModel scene = (SceneModel)getCurrentScene();
		scene.removeAllEntities();
		GfxSimpleText text = new GfxSimpleText(framework, new Vector2(100, 400), "CONGRATULATIONS: YOU HAVE WON!", 1);
		text.activate();
		triumphSound.play();
		getCurrentScene().countDown((int)TIME, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				timer = TIME;
			}
		}
				);
		if (timer == TIME) super.complete();
	}

	@Override
	public String getName()
	{
		return LEVEL_NAME;
	}
	
	/**
	 * Override in order to personalize music of the level
	 */
	@Override
    public void init()
	{
		setStageMusic(PropertiesManager.getParameter("sottoFondo"));
		super.init();
	}
	
}
