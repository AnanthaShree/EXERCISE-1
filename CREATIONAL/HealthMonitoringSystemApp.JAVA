import java.util.ArrayList;
import java.util.List;

// SensorData class to represent the data collected from sensors
class SensorData {
    private String animalId;
    private String healthMetric;
    private double value;

    public SensorData(String animalId, String healthMetric, double value) {
        this.animalId = animalId;
        this.healthMetric = healthMetric;
        this.value = value;
    }

    public String getAnimalId() {
        return animalId;
    }

    public String getHealthMetric() {
        return healthMetric;
    }

    public double getValue() {
        return value;
    }
}

// Singleton HealthMonitoringSystem class
public class HealthMonitoringSystem {
    private static HealthMonitoringSystem instance;
    private List<SensorData> sensorDataList;

    private HealthMonitoringSystem() {
        sensorDataList = new ArrayList<>();
    }

    public static synchronized HealthMonitoringSystem getInstance() {
        if (instance == null) {
            instance = new HealthMonitoringSystem();
        }
        return instance;
    }

    public void collectData(SensorData data) {
        sensorDataList.add(data);
        System.out.println("Data collected: " + data.getAnimalId() + " - " + data.getHealthMetric() + ": " + data.getValue());
    }

    public void analyzeData() {
        System.out.println("Analyzing data...");
        for (SensorData data : sensorDataList) {
            // Perform analysis (placeholder)
            System.out.println("Analyzing " + data.getAnimalId() + " - " + data.getHealthMetric() + ": " + data.getValue());
        }
    }

    public void alertIfNeeded() {
        System.out.println("Checking for alerts...");
        for (SensorData data : sensorDataList) {
            // Check for health issues and alert (placeholder)
            if (data.getValue() > 100) { // example condition
                System.out.println("Alert: " + data.getAnimalId() + " has abnormal " + data.getHealthMetric() + ": " + data.getValue());
            }
        }
    }
}

// Main class to demonstrate the HealthMonitoringSystem
public class HealthMonitoringSystemApp {
    public static void main(String[] args) {
        HealthMonitoringSystem healthSystem = HealthMonitoringSystem.getInstance();

        SensorData data1 = new SensorData("Cow1", "Heart Rate", 80);
        SensorData data2 = new SensorData("Cow2", "Temperature", 101.5);

        healthSystem.collectData(data1);
        healthSystem.collectData(data2);

        healthSystem.analyzeData();
        healthSystem.alertIfNeeded();
    }
}
