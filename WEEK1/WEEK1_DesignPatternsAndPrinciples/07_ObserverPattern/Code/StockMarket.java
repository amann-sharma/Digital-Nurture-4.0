import java.util.*;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
} 