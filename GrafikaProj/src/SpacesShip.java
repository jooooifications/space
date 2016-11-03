import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import rafgfxlib.Util;

public class SpacesShip {
	
	public int posX, posY, width, height;
	public BufferedImage image;
	public SpacesShip(String src) {
		super();
		image = Util.loadImage(src);
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics2D g){
		g.drawImage(image, posX, posY, null);
	}

}
