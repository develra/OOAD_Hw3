/**
 * 
 * @author develra
 *
 */
public class Submission_Queue {
	 
	private 
	private static Submission_Queue instance= null;
	private Submission_Queue(){
		//defeat extra instances
	}

	public synchronized static Submission_Queue getInstance(){
		if(instance==null)
			instance= new Submission_Queue();
		}
	 public add(Submission s){
		 
	 }
	 return instance; 
}
