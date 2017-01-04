/**
 * @author Amy Gold 

 * 30 April 2015
 * This is a processing game in which users accumulate a total score by clicking
 * on objects of different values. 
 */
import processing.core.PApplet; 
//Must "extend PApplet."
public class MyGame extends PApplet{
	int xmax=500;
	int ymax=500;
	private final int numdisks=4;
	Disk[]diskarray=new Disk[numdisks];
	int counter=0;
	private static int totalScore=0;
	private static int ScoreFromLevelOne=0;
	private static int ScoreFromLevelTwo=0;
	private boolean GameOn=false;
	//	this method runs once at the beginning to setup the drawing
	//	area
	public void setup(){
		size(xmax,ymax);

		makeDisks();
	}
	public static void main(String args []) {
		 PApplet.main ( new String [ ] { "MyGame" } ) ;
	 }
	//		set the size of the canvas for your "drawing:
/**
 * manually create an array of disks to be drawn with each iteration of draw method.
 */
	public void makeDisks(){

		
			diskarray[0]= new Disk((float)0,(float)0,(float)100,(float)100,(float)1, 10);
		   
		
			diskarray[1]= new Disk((float)0,(float)0,(float)70,(float)70,(float)2, 20);
			
			
		
		
			diskarray[2]= new Disk((float)0,(float)0,(float)60,(float)60,(float)3,50);
			

	
			diskarray[3]= new Disk((float)0,(float)0,(float)40,(float)40,(float)4,100);
		

		}

/**
 * 	draw method creates background and makes call to corresponding disk class 
 * to draw game interface for each portion of the game.
 */
	
	
	public void draw(){
//beginning user interface welcomes player.
		background(0);
		if (!GameOn){
		text("Welcome! Click anywhere to begin!",250, 250);
		}
		if(mousePressed){
			GameOn=true;
			
		}
//counter keeps track of time. 
		if(GameOn){
		counter++;
		}
//corresponds to 30 seconds.
		if(counter==30*60){
			ScoreFromLevelOne=totalScore;
			totalScore=0;
//loop through array to speed up disks.
			for(int i=0; i<numdisks; i++){
				if(diskarray[i].number==10){
					
				
				diskarray[i].speedx+=1;
				diskarray[i].speedy+=1;
				}
			if(diskarray[i].number==20){
					diskarray[i].speedx+=1;
					diskarray[i].speedy+=1;
				}
			if(diskarray[i].number==50){
				diskarray[i].speedx+=3;
				diskarray[i].speedy+=3;
			}
			else{
				diskarray[i].speedx+=3;
				diskarray[i].speedy+=3;			}
			}
		}
/**
 * level 2.
 * display score and loop through disks to continue to move them.
 */
		if(counter>30*60&&counter<60*60){
			fill(255,255,255);
			textSize(30);

			textAlign(CENTER);
			text("total score:"+totalScore, 250, 60);

			for(int i=0; i<numdisks; i++){
				
					diskarray[i].move((int)(Math.random()*10));

					diskarray[i].draw(this);
 /**
  * if user pressed mouse call disk function to determine if clicked 
  * within disk. Add value to total score using getScore() method which 
  * returns the number on the disk.
  * 
  * 
  */


				if(mousePressed){
					if(diskarray[i].mouse(mouseX, mouseY)){
						totalScore+=diskarray[i].getScore();
						System.out.println(totalScore);
						diskarray[i].disappear(this);
						
						
					}
				}
 /**
  * save score from level two. 
  * for 5 seconds display a welcome to level two interface.         
  */
				ScoreFromLevelTwo=totalScore;
				if (counter>30*60&&counter<35*60&&GameOn==true){
					fill(255);
					textSize(25);
					text("Level 2!",250,30);
				}
				

				}



			}
/**
 * level one. 
 * display total score at top of window.
 * move disks by randome integers using disk class move method.
 * 		
 */
		if(counter<30*60&&GameOn==true){
			fill(255,255,255);
			textSize(30);

			textAlign(CENTER);
			text("total score:"+totalScore, 250, 60);
			for (int i=0; i<numdisks; i++){
				diskarray[i].move((int)(Math.random()*3));

				diskarray[i].draw(this);
				if(mousePressed){
					if(diskarray[i].mouse(mouseX, mouseY)){
						totalScore+=diskarray[i].getScore();
						System.out.println(totalScore);
						diskarray[i].disappear(this);
						
						
					}
				}

			}
		}
			if(counter>60*60){
				fill(255,255,255);
				textSize(30);
				text("GAME OVER",250, 250);
				text("Score from level one:"+ScoreFromLevelOne,250,280);
				text("Score from level two:"+ScoreFromLevelTwo,250,340);
				totalScore=ScoreFromLevelOne+ScoreFromLevelTwo;
				text("Total Score:"+totalScore,250,500);
			
		}
	}
}

	


