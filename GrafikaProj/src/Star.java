import java.awt.Graphics2D;

public class Star {
	
	public int posX;
	public int posY;
	public int radius;
	public int maxRadius;
	private boolean shine = true;
	private int mod = 0;
	
	public Star(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.radius = (int) (Math.random()*10/3) +1;
		this.maxRadius = (int) (Math.random()*10/3) +2;
		if (maxRadius<radius) maxRadius = radius;
	}

	public void update(char c){
		mod = (mod + 1) % 5;
		
		if ( mod == 0){
		
			if (shine){
				if (radius < maxRadius) radius++;
				else {
					radius --;
					shine = false;
				}
			}else{
				if (radius > 0) radius --;
				else{
					radius++;
					shine = true;
				}
			}
		
		}
		
		if (c == 'r') {
			posX = (posX - 20) % 799;
			if (posX < 20) posX +=780;
		}
		if (c == 'l') posX = (posX + 20) % 799;
	}
	
	public void draw(Graphics2D g){
		g.fillOval((int)posX-(radius/2), (int)posY-(radius/2), radius, radius);
	}


}
