import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public interface Subject {
	
	public void registerObserver(Observer o);
	public void unregisterObserver(Observer o);
	public void notifyObservers();

}

class Scoring implements Subject{
	
	Random r = new Random();
	
	int warriorsScore = 0;
	int lakersScore = 0;
	
	ArrayList<Observer> observerList;
	
	public Scoring() {
		observerList = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);
	}
	
	@Override
	public void unregisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));
		
	}
	
	@Override
	public void notifyObservers() {
		for (Iterator<Observer> it =
				observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(warriorsScore, lakersScore);
		}
		
	}
	
	//get lakers score for the quarter
	private int getLQScore() {
		return r.nextInt(31);
	}
	
	//get the warriors score for the quarter
	private int getWQScore() {
		return r.nextInt(31);
	}
	
	public void dataChanged() {
		warriorsScore = warriorsScore + getWQScore();
		lakersScore = lakersScore + getLQScore();
		
		notifyObservers();
	}
}
