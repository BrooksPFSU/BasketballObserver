import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class game {
	
	//inits
	static Random r = new Random();
	static Scanner s = new Scanner(System.in);
	static int ltoc = 0;
	static int wtoc = 0;
	static int wf =0;
	static int lf = 0;
	
	static ArrayList<String> lakers = new ArrayList<String>();
	static ArrayList<String> warriors = new ArrayList<String>();
			
	static String warriorFoul = "There's a foul for the Warriors.";
	static String lakersFoul = "Oh and there's a foul for the Lakers. Let's see if they can make this free throw.";
	static String lto = "Looks like the lakers are calling a timeout, I wonder what they're talking about folks?";
	static String wto = "And here go the Warriors taking a time out, let's see what they're up to.";
	
	
	public static void main(String[] args) {
		
		//inits
		scoreDisplay display = new scoreDisplay();
		averagePredictions pred = new averagePredictions();
		gameTitle title = new gameTitle();
		Scoring score = new Scoring();
		score.registerObserver(display);
		score.registerObserver(pred);
		score.registerObserver(title);
		
		//set game lines
		lakers.add("Ohhh! He shoots!! Aww and he misses but I know he'll get it next time!"); 
		lakers.add("Anthony Davis takes it to the line and scores a 3!");
		lakers.add("Here comes Lebron James. Here he is bringing it to the basket and dunks it!"); 
		lakers.add("Another 2 points for the Lakers!"); 
		lakers.add("Reaves coming in to make a 3 wow! That was unexpected folks!"); 
		lakers.add("Heres Anthony taking it to the rim! Oh wait, but here comes the Warriors to take it back!"); 
		warriors.add("Ohhh! He shoots!! Aww and he misses lets try again!");
		warriors.add("And Curry does his thing and scores another 3!");
		warriors.add("Here comes Thompson bringing it to the basket and look at that he dunks it!");
		warriors.add("Another 2 points for the Lakers!");
		warriors.add("Looney coming in to make a 3 wow! That was unexpected folks!");
		warriors.add("Heres Anthony taking it to the rim! Oh wait, but here comes the Warriors to take it back!");
		
		//let watcher know the game is starting
		System.out.println("Are you ready to read tonight's game? Press ENTER to start! We will pick the game you are watching!");
		String input = s.nextLine();
		
		System.out.println("Get ready folks the game is about to start!");
		System.out.println("And the ball is live!\n");
		
		//start quarter loop
		int quarter = 1;
		while(quarter<5){
			//generate 30 random lines
			int i;
			for (i=0; i<31; i++) {
				int r = rand();
				
				if (r<11) {
					System.out.println(lakers.get(0));
				}else if (r<21) {
					System.out.println(lakers.get(1));
				}else if (r<31) {
					System.out.println(lakers.get(2));
				}else if (r<41) {
					System.out.println(lakers.get(3));
				}else if (r<51) {
					System.out.println(lakers.get(4));
				}else if (r<61) {
					System.out.println(lakers.get(5));
				}else if (r<71) {
					System.out.println(warriors.get(0));
				}else if (r<81) {
					System.out.println(warriors.get(1));
				}else if (r<91) {
					System.out.println(warriors.get(1));
				}else if (r<101) {
					System.out.println(warriors.get(2));
				}else if (r<111) {
					System.out.println(warriors.get(3));
				}else if (r<121) {
					System.out.println(warriors.get(4));
				}else if (r<131) {
					System.out.println(warriors.get(5));
				}else if (r<141) {
					System.out.println(warriorFoul);
					wf++;
				}else if (r<151) {
					System.out.println(lakersFoul);
					lf++;
				}else if (r<161) {
					if (wtoc<7) {
						System.out.println(wto);
						wtoc++;
					}else {
						i--;
						
					}
				}else if (r<171) {
					if (ltoc<7) {
						System.out.println(lto);
						ltoc++;
					}else {
						i--;
					}
				}else {
					System.out.println("Woah! I don't even know what happened there! Let's watch a replay!");
					i--;
				}
			}
			
			//stops quarter to wait for user input
			System.out.println("\nAnd that's it for quarter number " + quarter + " folks! We'll see you here back in a minute!");
			
			//DISPLAY QUARTER STATS AND PREDICTIONS
			score.dataChanged();
			
			//breakline
			System.out.println("____________________________________________________________________________________________________");
			
			if (quarter<4) {
				System.out.println("Please type 'ready' to start the next quarter.");
				String response = s.nextLine();
				quarter++;
				
				if(response.equals("ready")) continue;
			}else {
				s.close();
				break;
			}
	}
		
		//DISPLAY GAME STATS
		title.endDisplay();
		
		//show foul and to counts
		System.out.println("\nFOULS:");
		System.out.println("Warriors: " + wf + " | Lakers: " + lf);
		System.out.println("\nTIME OUTS:");
		System.out.println("Warriors: " + wtoc + " | Lakers: " + ltoc);
		
		//close the observers
		score.unregisterObserver(display);
		score.unregisterObserver(title);
		score.unregisterObserver(pred);
	}
	
	public static int rand() {
		return r.nextInt(1,171);
	}
}
