import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import rafgfxlib.Util;

public class Bilinear {
	
	private Colooor cUL, cUR, cLL, cLR;
	
	private int UL[] = {0, 250, 250};
	private int UR[] = {0, 0, 0};
	private int LL[] = {45, 0, 45};
	private int LR[] = {0, 0, 30};
	private int U[] = new int[3];
	private int L[] = new int[3];
	private int BIL[] = new int[3];
	private BufferedImage img;
	WritableRaster raster = Util.createRaster(800, 600, false);
	
	public Bilinear() {
		super();
		cUL = new Colooor(UL, true);
		cUR = new Colooor(UR, true);
		cLL = new Colooor(LL, true);
		cLR = new Colooor(LR, true);
	}
	
	public BufferedImage getImg(){
		for(int y = 0; y < raster.getHeight(); y++)
		{
			for(int x = 0; x < raster.getWidth(); x++)
			{
				double fX = x / (double)raster.getWidth();
				double fY = y / (double)raster.getHeight();
				
				Util.lerpRGBi(UL, UR, (float) fX, U);
				Util.lerpRGBi(LL, LR, (float) fX, L);
				Util.lerpRGBi(U, L, (float) fY, BIL);
				
				raster.setPixel(x, y, BIL);
			}
			
		}
		
		img = Util.rasterToImage(raster);
		return img;
	}
	
	public void update(char c){
		
		cUL.update(c);
		cUR.update(c);
		cLL.update(c);
		cLR.update(c);
	}
	
	public void change(int[] color, boolean shine){
		
	}
	
	
}
