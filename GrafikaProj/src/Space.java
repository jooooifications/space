import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import rafgfxlib.GameFrame;
import rafgfxlib.Util;

public class Space extends GameFrame{
	
	
	private static final int STAR_MAX = 2000;
	
	private Color backgroundColor = new Color(25, 25, 80);
	private BufferedImage background = null;
	Bilinear bilinear = new Bilinear();	
	private Star[] stars = new Star[STAR_MAX];
	private Planet[] planets = new Planet[10];
	private BufferedImage spaceship = Util.loadImage("spaceship.png");
	
	private Planet sun = new Planet(200, 300, "sun.png");
	private Planet mercury = new Planet(550, 300, "mercury.png");
	private Planet venus = new Planet(800, 300, "venus.png");
	private Planet earth = new Planet(1100, 300, "earth.png");
	private Planet mars = new Planet(1400, 300, "mars.png");
	private Planet jupiter = new Planet(1700, 300, "jupiter.png");
	private Planet saturn = new Planet(2100, 300, "saturn.png");
	private Planet uranus = new Planet(2400, 300, "uranus.png");
	private Planet neptune = new Planet(2700, 300, "neptune.png");
	private Planet pluto = new Planet(3000, 270, "pluto.png");
	
	protected Space(String title, int sizeX, int sizeY) {
		
		super(title, sizeX, sizeY);
		setUpdateRate(110);
	
		for(int i = 0; i < STAR_MAX; ++i)
		{
			int posX = (int) (Math.random() * 800);
			int posY = (int) (Math.random() * 600);
			stars[i] = new Star(posX, posY);
		}
		
		planets[0] = sun;
		planets[1] = mercury;
		planets[2] = venus;
		planets[3] = earth;
		planets[4] = mars;
		planets[5] = jupiter;
		planets[6] = saturn;
		planets[7] = uranus;
		planets[8] = neptune;
		planets[9] = pluto;
		
		startThread();
	}

	@Override
	public void handleWindowInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleWindowDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g, int sw, int sh) {
		
		g.setBackground(backgroundColor);
		g.clearRect(0, 0, sw, sh);
		g.drawImage(background, 0, 0, null);
		g.setColor(new Color(255,255,155));
		
		for(Star s : stars)
		{				
			s.draw(g);
		}
		g.drawImage(spaceship, 500, 100, null);
		
		for (Planet planet : planets) {
			planet.draw(g);
		}		
	}

	@Override
	public void update() {
		
		for(Star s : stars)
		{
			if (isKeyDown(KeyEvent.VK_LEFT)) s.update('l');
			if (isKeyDown(KeyEvent.VK_RIGHT)) s.update('r');
			else s.update('n');
		}
		
		for (Planet planet : planets) {
			if (isKeyDown(KeyEvent.VK_LEFT)) planet.update('l');
			if (isKeyDown(KeyEvent.VK_RIGHT)) planet.update('r');
		}
		
		if (isKeyDown(KeyEvent.VK_LEFT)) bilinear.update('l');
		if (isKeyDown(KeyEvent.VK_RIGHT)) bilinear.update('r');
		background = bilinear.getImg();
		
	}

	@Override
	public void handleMouseDown(int x, int y, GFMouseButton button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseUp(int x, int y, GFMouseButton button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleKeyDown(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleKeyUp(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
