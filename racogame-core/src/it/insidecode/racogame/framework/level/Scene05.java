package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 05
 * @author Francesco Raco
 */
public class Scene05 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 05";
	public static final float TIME = 8000;
	public static final int RATTLE_MAX_SHOTS = 4;
	public static final int GARGOYLE_MAX_SHOTS = 5;
	public static final int ALIEN_MAX_SHOTS = 5;
	
	private float timer = 0;
	
	public Scene05(Framework framework)
	{
		super(framework);
	}
	
	@Override
	public String getName()
	{
		return SCENE_NAME;
	}
	
	@Override
	public void init()
	{
        super.init();
		
		framework.getGameEngine().setBackground(new BlueBackground());
		
		addEntity(new RattleDragon(framework, new Vector2(0, 50), shot, new FireShotDecorator(framework.getGameEngine(), shot), RATTLE_MAX_SHOTS), new LPath(LineDirection.UP, MyDirection.RIGHT, 400, 700));
		addEntity(new RattleDragon(framework, new Vector2(450, 50), shot, new FireShotDecorator(framework.getGameEngine(), shot), RATTLE_MAX_SHOTS), new LPath(LineDirection.UP, MyDirection.LEFT, 450, 700));
		
		countDown(3500, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new Gargoyle(framework, new Vector2(0, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), GARGOYLE_MAX_SHOTS), new LPath(LineDirection.DOWN, MyDirection.RIGHT, 400, 700));
				addEntity(new Gargoyle(framework, new Vector2(400, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), GARGOYLE_MAX_SHOTS), new LPath(LineDirection.DOWN, MyDirection.LEFT, 450, 700));
			}
		});
		
		countDown(8000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(80, 450)));
				addEntity(new Guardian(framework, new Vector2(40, 575), shot, new IceShotDecorator(framework.getGameEngine(), shot), true), 12, new SquarePath(Corner.UPLEFT, PoligonalDirection.HORIZONTAL, 150, true));
				addEntity(new Star(framework, new Vector2(530, 550), new MonetinaBonus(framework, new Vector2(430, 550))), new CirclePath(Type.DOWNLEFT, 200, 200, true));
			}
		});
		
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new AlienMonster(framework, new Vector2(280, 0), shot, new FireShotDecorator(framework.getGameEngine(), shot), ALIEN_MAX_SHOTS), 1, new LinePath(LineDirection.UP, 700));
			addEntity(new AlienMonster(framework, new Vector2(380, 0), shot, new FireShotDecorator(framework.getGameEngine(), shot), ALIEN_MAX_SHOTS), 1, new LinePath(LineDirection.UP, 700));
			timer = -3000;
		}
		super.update(delta);
	}

}
