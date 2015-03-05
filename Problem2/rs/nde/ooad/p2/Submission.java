package rs.nde.ooad.p2;
/**
* Submission.java
*
* A representation of a Submission
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Submission implements SubmissionSubject
{	
	List<Observer> observers;
    private Random myRandom;
	private boolean lastErrorWasTimeout;
	private boolean passed;

    // You may add attributes to this class if necessary

	public Submission()
	{
	    myRandom = new Random();
		lastErrorWasTimeout = false;
		observers = new ArrayList<Observer>();
	}

    public void runTestCase()
	{
	    // For now, randomly pass or fail, possibly due to a timeout
		passed = myRandom.nextBoolean();
		if(!passed)
		{
		    lastErrorWasTimeout = myRandom.nextBoolean();
		}
		
		// You can add to the end of this method for reporting purposes
	}
	
    public boolean wasTimeoutError()
	{
	    return lastErrorWasTimeout;
	}
    
    public boolean hasFailed()
    {
    	return passed;
    }

	@Override
	public void registerObserver(Observer obj) {
		this.observers.add(obj);
	}

	@Override
	public void unregisterObserver(Observer obj) {
		this.observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update();
		}
	}
}
