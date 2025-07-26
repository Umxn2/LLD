import java.util.HashSet;
import java.util.Set;

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

    Set<Observer> observers = new HashSet<>();
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
    }

    public Integer getValue() {
        return stockValue;
    }
}
