
public interface Observer {
	public void update(int warriorsScore, int lakersScore);
}

class scoreDisplay implements Observer{
	
	//inits
	private int wScore;
	private int lScore;
	private int quarter = 0;
	
	//update the scores and predictions
	public void update(int warriorsScore, int lakersScore) {
		//update the quarter
		quarter++;
		this.wScore = warriorsScore;
		this.lScore = lakersScore;
		display();
	}
	
	//display quarter stats
	public void display() {
		System.out.println("Heres the stats for this quarter folks!"
				+ "\nWarriors: " + wScore + " | Lakers: " + lScore);
	}
}

class averagePredictions implements Observer{
	//inits
	private int wScore;
	private int lScore;
	private int wPred;
	private int lPred;
	private int quarter = 0;
	
	//update the scores and predictions
	public void update(int warriorsScore, int lakersScore) {
		//update the quarter
		quarter++;
		this.wScore = warriorsScore;
		this.lScore = lakersScore;
		this.wPred = (wScore/quarter) * 4;
		this.lPred = (lScore/quarter) * 4;
		display();
	}
	
	public void display() {
		if (quarter<4) {
			System.out.println("\n\nWarriors total game points prediction: " + wPred
					+ "\nLakers total game points prediction: " + lPred
					+ "\n\nTrust our predictions they are simple math! Correct game predictions 0/1"
					+"\n(Game scores are random here so it's kinds hard to make a prediction)");
		}
	}
}

class gameTitle implements Observer{
	
	//inits
		private int wScore;
		private int lScore;
		private int wPred;
		private int lPred;
		private int quarter = 0;
		
		//update the scores and predictions
		public void update(int warriorsScore, int lakersScore) {
			//update the quarter
			quarter++;
			this.wPred = (wScore/quarter) * 4;
			this.lPred = (lScore/quarter) * 4;
			this.wScore = warriorsScore;
			this.lScore = lakersScore;
		}
		
	//display final game stats
		public void endDisplay() {
			
			//HEADLINE
			if (wScore>=lScore) {
				System.out.println("\nWARRIORS BEAT THE LAKERS BY " + (wScore - lScore) + " POINTS! WHAT A GAME!");
			}else if (lScore>=wScore) {
				System.out.println("\nLAKERS BEAT THE WARRIORS BY " + (lScore - wScore) + " POINTS! WHAT A GAME!");
			}else {
				System.out.println("IT'S A TIE FOLKS! (Sorry we don't share overtime stats here!");
			}
			
			//final scores
			if (wScore==wPred) {
				System.out.println("\n\n\nGAME STATS:\n");
				System.out.println("\nLooks like our prediction for the Warriors points was right! The Warriors end the game with " + wScore + " points!");
			}else {
				System.out.println("\nThe Warriors end the game with " + wScore + " points!");
			}
			if (lScore==lPred) {
				System.out.println("Looks like our prediction for the Lakers points was right! The Lakers end the game with " + lScore + " points!");
			}else {
				System.out.println("\nThe Lakers end the game with " + lScore + " points!");
			}
			
			System.out.println("\nAVERAGES PER QUARTER:");
			System.out.println("Warriors: " + (wScore/4) + " | Lakers: " + (lScore/4));
			
		}
}
