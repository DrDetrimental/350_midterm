package interfaces;

public interface Subject {
	public void registerSubscriber(Subscriber s);
	public void unregisterSubscriber(Subscriber s);
	public void notifySubscribers();
}
