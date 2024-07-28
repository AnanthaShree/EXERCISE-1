import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String stockPrice);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// ConcreteSubject Class
class StockMarket implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String stockPrice;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(String newStockPrice) {
        this.stockPrice = newStockPrice;
        notifyObservers();
    }
}

// ConcreteObserver Class
class BrokerDisplay implements Observer {
    private String stockPrice;

    @Override
    public void update(String stockPrice) {
        this.stockPrice = stockPrice;
        display();
    }

    private void display() {
        System.out.println("Broker Display: Stock price updated - " + stockPrice);
    }
}

// ConcreteObserver Class
class InvestorDisplay implements Observer {
    private String stockPrice;

    @Override
    public void update(String stockPrice) {
        this.stockPrice = stockPrice;
        display();
    }

    private void display() {
        System.out.println("Investor Display: Stock price updated - " + stockPrice);
    }
}

// Usage Class
public class StockMarketApp {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer brokerDisplay = new BrokerDisplay();
        Observer investorDisplay = new InvestorDisplay();

        stockMarket.addObserver(brokerDisplay);
        stockMarket.addObserver(investorDisplay);

        // Simulating stock price change
        stockMarket.setStockPrice("120.5 USD");

       
    }
}
