package it.insidecode.racogame.framework.level;

import javax.swing.text.html.parser.Entity;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.HorizontalBar;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Scene 10
 * @author Francesco Raco
 */
public class Scene10 extends SceneModel
{
    public static final String SCENE_NAME = "Scene 10";
    
    public static final float TIME = 2000;
    
    private Shot shot = new DoubleShot(framework.getGameEngine(), new Vector2(100, 200));
    
    private HorizontalBar bossBar = new HorizontalBar(framework.getGameEngine(), new Vector2(0, 0), 80, 10, LevelBoss.ENERGY_VALUE, Color.RED, Color.BLUE);
    
    private LevelBoss boss = new LevelBoss(framework, new Vector2(250, 550), 
    		bossBar, shot, new FireShotDecorator(framework.getGameEngine(), shot), true);
	
	private float timer = 0;
    
    public Scene10(Framework framework)
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
		
		framework.getGameEngine().setBackground(new BrightBackground());
		
		boss.activate();
		bossBar.activate();
	}
	
	@Override
	public void update(float delta)
	{
		if (!boss.isAlive())
		{
			getLevel().complete();
		}
		else if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new Star(framework, new Vector2(10, 550), new MonetinaBonus(framework, new Vector2(10, 550))), 5, new LinePath(LineDirection.DOWN, 650));
			timer = -3000;
			framework.getShip().setEnergy(framework.getShip().getEnergy() + 1);
		}
		super.update(delta);
	}

}
