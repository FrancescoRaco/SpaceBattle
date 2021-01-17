package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.Rectangle;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 07
 * @author Francesco Raco
 */
public class Scene07 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 07";
	public static final int GARGOYLE_MAX_SHOTS = 3;
	public static final int GUARDIAN_MAX_SHOTS = 2;
	public static final float TIME = 13000;
		
	private float timer = 0;
		
	public Scene07(Framework framework)
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
		
		framework.getGameEngine().setBackground(new DarkSpaceBackground());
		
		addEntity(new Gargoyle(framework, new Vector2(100, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), GARGOYLE_MAX_SHOTS), 5, new RisaliAiLati(MyDirection.LEFT, 350, 100, 450));
		addEntity(new Gargoyle(framework, new Vector2(300, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), GARGOYLE_MAX_SHOTS), 5, new RisaliAiLati(MyDirection.RIGHT, 350, 100, 450));
		
		countDown(5000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new Guardian(framework, new Vector2(145, 550), shot, new IceShotDecorator(framework.getGameEngine(), shot), GUARDIAN_MAX_SHOTS), 3, new LinePath(LineDirection.DOWN, 600));
				addEntity(new Guardian(framework, new Vector2(245, 550), shot, new IceShotDecorator(framework.getGameEngine(), shot), GUARDIAN_MAX_SHOTS), 3, new LinePath(LineDirection.DOWN, 600));
				
			}
		});
		
		countDown(10000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				
				addEntity(new AlienMonster(framework, new Vector2(50, 350), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), 1, new SentinelPath(MyDirection.RIGHT, 150));
				addEntity(new BlackHole(framework, new Vector2(50, 450)));
				GfxEnemy e = new RockBarrier(framework, new Vector2(150, 475));
				e.setRotation(90);
				addEntity(e);
				addEntity(new Star(framework, new Vector2(50, 550), new MonetinaBonus(framework, new Vector2(50, 550))), new CirclePath(Type.DOWNLEFT, 200, 200, true));
			}
		});
		
		
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new RockBoss(framework, new Vector2(300, 0)), 1, new LinePath(LineDirection.UP, 650));
			addEntity(new RockBoss(framework, new Vector2(350, 0)), 1, new LinePath(LineDirection.UP, 650));
			addEntity(new RockBoss(framework, new Vector2(400, 0)), 1, new LinePath(LineDirection.UP, 650));
			timer = -3000;
		}
		super.update(delta);
	}
	
	
}	