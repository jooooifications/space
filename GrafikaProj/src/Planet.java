import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import rafgfxlib.GameFrame;
import rafgfxlib.Util;

public class Planet {
	
	public int posX,posY, width, height;
	public BufferedImage image;
	
	public Planet(int posX, int posY, String src) {
		super();
		image = Util.loadImage(src);
		width = image.getWidth();
		height = image.getHeight();
		this.posX = posX - width/2;
		this.posY = posY - height/2;
	}
	
	public void update(char c){
		if (c == 'r') posX -= 10;
		if (c == 'l') posX += 10;
	}
	
	public void draw(Graphics2D g){
		if (posX<(800 + width) || posX>(-width))
			g.drawImage(image, posX, posY, null);
	}

}
