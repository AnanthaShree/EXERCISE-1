import java.util.HashMap;
import java.util.Map;

// Animal class to represent individual animals
class Animal {
    private String id;
    private String type;

    public Animal(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

// Feed class to represent feed types
class Feed {
    private String name;
    private double quantity;

    public Feed(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }
}

// Singleton FeedManagementSystem class
public class FeedManagementSystem {
    private static FeedManagementSystem instance;
    private Map<String, Double> feedLevels;

    private FeedManagementSystem() {
        feedLevels = new HashMap<>();
    }

    public static synchronized FeedManagementSystem getInstance() {
        if (instance == null) {
            instance = new FeedManagementSystem();
        }
        return instance;
    }

    public void scheduleFeeding(Animal animal, Feed feed) {
        System.out.println("Scheduled feeding for " + animal.getId() + " with " + feed.getName() + ": " + feed.getQuantity() + " kg");
    }

    public void monitorFeedLevels() {
        System.out.println("Monitoring feed levels...");
        for (Map.Entry<String, Double> entry : feedLevels.entrySet()) {
            System.out.println("Feed: " + entry.getKey() + ", Level: " + entry.getValue() + " kg");
        }
    }

    public void adjustFeedingSchedule() {
        System.out.println("Adjusting feeding schedules...");
        // Adjust feeding schedule logic (placeholder)
    }

    public void updateFeedLevel(String feedName, double quantity) {
        feedLevels.put(feedName, quantity);
        System.out.println("Updated feed level: " + feedName + " to " + quantity + " kg");
    }
}

// Main class to demonstrate the FeedManagementSystem
public class FeedManagementSystemApp {
    public static void main(String[] args) {
        FeedManagementSystem feedSystem = FeedManagementSystem.getInstance();

        Animal cow1 = new Animal("Cow1", "Cow");
        Animal cow2 = new Animal("Cow2", "Cow");

        Feed hay = new Feed("Hay", 5.0);
        Feed grain = new Feed("Grain", 3.0);

        feedSystem.scheduleFeeding(cow1, hay);
        feedSystem.scheduleFeeding(cow2, grain);

        feedSystem.updateFeedLevel("Hay", 100.0);
        feedSystem.updateFeedLevel("Grain", 50.0);

        feedSystem.monitorFeedLevels();
        feedSystem.adjustFeedingSchedule();
    }
}
