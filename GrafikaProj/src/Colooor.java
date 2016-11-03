import rafgfxlib.Util;

public class Colooor {
	
	private int rgb[] = new int[3];
	private int max[] = new int[3]; 
	private int min[] = new int[3];
	private boolean change[] = new boolean[3];
	float delta;
	boolean shine;
	int limitr = 0, limitl = 0;
	int dif = 1;
	private int diff;
	
	public Colooor(int[] rgb, boolean shine) {
		
		super();
		this.rgb = rgb;
		this.shine = shine;
		
		for (int i=0; i<3; i++) {
			if (rgb[i] == 0) change[i] = false;
			else change[i] = true;
		}
		
		if (shine) {
			min = rgb;
			diff = Math.min(255-rgb[0], 255-rgb[1]);
			diff = Math.min(diff, 255-rgb[2]);
			max[0] = Util.clamp(rgb[0]+diff, 0 ,255);
			max[1] = Util.clamp(rgb[1]+diff, 0 ,255);
			max[2] = Util.clamp(rgb[2]+diff, 0 ,255);
		}else{
			max = rgb;
			diff = Math.min(rgb[0], rgb[1]);
			diff = Math.min(diff, rgb[2]);
			min[0] = Util.clamp(rgb[0]-diff, 0 ,255);
			min[1] = Util.clamp(rgb[1]-diff, 0 ,255);
			min[2] = Util.clamp(rgb[2]-diff, 0 ,255);
			System.out.println("promenio se");
		}
	}
	
	
	public void update(char c){
		if (c == 'l') shine = true;
		if (c == 'r') shine = false;
		if (c == 'n') return;
		if (shine){
			if ((rgb[0] < max[0]) && (rgb[1] < max[1]) && (rgb[2] < max[2])) {
				if (limitl == 0){
					if (change[0]) rgb[0] = Util.clamp(rgb[0]+ dif, 0, 255);
					if (change[1]) rgb[1] = Util.clamp(rgb[1]+ dif, 0, 255);
					if (change[2]) rgb[2] = Util.clamp(rgb[2]+ dif, 0, 255);
				}else{
					limitl--;
				}
			}else{
				limitl++;
			}
		}else{
			/*System.out.println("RGB");
			System.out.println(rgb[0]);
			System.out.println(rgb[1]);
			System.out.println(rgb[2]);
			System.out.println("MIN");
			System.out.println(min[0]);
			System.out.println(min[1]);
			System.out.println(min[2]);*/
			if ((rgb[0] >= min[0]) && (rgb[1] >= min[1]) && (rgb[2] >= min[2])) {
				if (limitr == 0){
					if (change[0]) rgb[0] = Util.clamp(rgb[0]- dif, 0, 255);
					if (change[1]) rgb[1] = Util.clamp(rgb[1]- dif, 0, 255);
					if (change[2]) rgb[2] = Util.clamp(rgb[2]- dif, 0, 255);
				}else{
					limitr --;
				}
			}else{
				limitr ++;
			}
		}
	}

}
