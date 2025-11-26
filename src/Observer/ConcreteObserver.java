package Observer;

public record ConcreteObserver(String userName) implements Observer {

    @Override
    public void update(String availability) {
        System.out.println("Hello " + userName + ", the product is now " + availability + "!");
    }

    public void addSubscriber(Subject subscriber) {
        subscriber.registerObserver(this);
    }

    public void removeSubscriber(Subject subscriber) {
        subscriber.removeObserver(this);
    }
}
