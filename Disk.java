/**
 * @author Amy Gold
 * 1 May 2015 
 * disk class provides methods for disk objects in game class!
 */
import java.util.Random;


public class Disk {
/**
 * define data fields.
 */
	int counter=0;
	float locx=(float)0.0;
	float locy=(float)0.0;
	float sizex=(float)0.0;
	float sizey=(float)0.0;
	float speedx=(float)0.0;
	float speedy=(float)0.0;
	int  number=0;
/**
 * 
 * @param locx
 * @param locy
 * @param sizex
 * @param sizey
 * @param speed
 * @param number
 * constructor accepts disk data fields from disk class.
 */
	public Disk (float locx, float locy, float sizex, float sizey,float speed, int number) {
		this.locx=locx;
		this.locy=locy;
		this.sizex=sizex;
		this.sizey=sizey;
		this.number=number;
		int counter=0;
/**
 * code causes disks to appear to move randomly.
 */
		Random rand = new Random();
		int numX = rand.nextInt(10) + 1;
		int numY = rand.nextInt(10) + 1;

		if (numX < 5) {
			this.speedx = speed;
		}
		else {
			this.speedx = -speed;

		}
		if (numY < 5) {
			this.speedy = speed;
		}
		else {
			this.speedy = -speed;
		}

		
	}
/**
 * draw method draws disks to PApplet.	
 * @param canvas
 * note- canvas a param allows method to control PApplet even though class does not extend PApplet.
 */
	public void draw(MyGame canvas){

		counter++;
		canvas.fill(0,255,255);
		canvas.ellipse (locx, locy, sizex, sizey);
		canvas.fill(0,0,0);
		canvas.textSize(10);

		canvas.textAlign(canvas.CENTER);
		canvas.text(number ,locx , locy); 


	}
/**
 * move method accepts speed as a parameter and places disks that have exited the PApplet screen at a random 
 * location within the screen.
 * @param speed
 */
	public void move(int speed){
	
		locx+=speedx;
		locy+=speedy;
		if(locx>=500|| locx<=0||locy>=500||locy<=0){
			locx=(float)Math.random()*500;
			locy=(float)Math.random()*500;
		}
	}
/**
 * mouse determines if user has clicked on a disk. 
 * @param mouseX
 * @param mouseY
 * @return boolean 
 */
	public boolean mouse(float mouseX, float mouseY ){
		if( Math.abs(locx-mouseX)<sizex&&Math.abs(locy-mouseY)<sizex){
			
		return true; 
		}
		else{
			return false;
		}
	}
/**
 * getScore() returns the value of the current disk object which is recognized as a n integer data field.
 *  @return value of disk. 
 */
	public int getScore(){
		return number;
	}
/**
 * disappear method moves disks that have been clicked on to an arbitrary location outside of  the screen.
 * @param canvas
 */
	public void disappear(MyGame canvas){
		locx=550;
		locy=550;
		

		
	}


}



		






