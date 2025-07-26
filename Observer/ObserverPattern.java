import java.util.ArrayList;

interface Observable<T> {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
    void setValue(T value);
}

interface Observer {
    void update();
}

class WebStock implements Observable<Integer> {

    ArrayList<Observer> observers = new ArrayList<>();
    private int stockValue = 0;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void setValue(Integer num) {
        stockValue = num;
        notifyObserver();
    }

    public Integer getValue() {
        return stockValue;
    }
}

class MobileStock implements Observable<Integer> {

    ArrayList<Observer> observers = new ArrayList<>();
    private int stockValue = 0;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void setValue(Integer num) {
        stockValue = num;
        notifyObserver();
    }

    public Integer getValue() {
        return stockValue;
    }
}

class Web implements Observer {

    public void update() {
        System.out.println("Web Stock Updated");
    }
}

class Mobile implements Observer {

    public void update() {
        System.out.println("Mobile Stock Updated");
    }
}

class Desktop implements Observer {

    public void update() {
        System.out.println("Desktop Stock Updated");
    }
}

public class ObserverPattern {

    public static void main(String[] args) {
        Observer mobileObserver1 = new Mobile();
        Observer mobileObserver2 = new Mobile();
        Observer webObserver1 = new Web();
        Observer webObserver2 = new Web();

        Observable<Integer> mobileStock = new MobileStock();
        Observable<Integer> webStock = new WebStock();
        mobileStock.addObserver(mobileObserver1);
        mobileStock.addObserver(mobileObserver2);
        mobileStock.addObserver(webObserver1);
        mobileStock.addObserver(webObserver2);

        webStock.addObserver(mobileObserver1);
        webStock.addObserver(mobileObserver2);
        webStock.addObserver(webObserver1);
        webStock.addObserver(webObserver2);

        mobileStock.setValue(10);
        webStock.setValue(100);
    }
}
