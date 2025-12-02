//Engine
public interface Engine {
    void move();
}
// Driver 
public interface Driver {
    void navigate();
}
 CombustionEngine
public class CombustionEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Combustion engine moving.");
    }
}
 ElectricEngine
public class ElectricEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Electric engine moving.");
    }
}
// Human
public class Human implements Driver {
    @Override
    public void navigate() {
        System.out.println("Human driver navigating.");
    }
}
Robot 
public class Robot implements Driver {
    @Override
    public void navigate() {
        System.out.println("Robot driver navigating.");
    }
} 

// Transport 
public class Transport {

    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("Delivering " + cargo + " to " + destination);
        engine.move();
        driver.navigate();
    }
}

 // Main 
public class Main {
    public static void main(String[] args) {

        Engine engine = new ElectricEngine();
        Driver driver = new Robot();

        Transport transport = new Transport(engine, driver);
        transport.deliver("Warehouse A", "Electronics");
    }
}
