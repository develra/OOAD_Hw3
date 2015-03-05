package rs.nde.ooad.p2;
public abstract interface Subject {
 
    public void registerObserver(Observer obj);
    public void unregisterObserver(Observer obj);
     
    public void notifyObservers();
}