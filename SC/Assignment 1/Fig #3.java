//Employee
import java.util.Arrays;
import java.util.List;

public interface Employee {
    void doWork();
}
 //Designer implements Employee
public class Designer implements Employee {
    public void doWork() {
        System.out.println("Designer creating design");
    }
}

public class Programmer implements Employee {
    public void doWork() {
        System.out.println("Programmer writing code");
    }
}

public class Tester implements Employee {
    public void doWork() {
        System.out.println("Tester testing software");
    }
}
//abstract Company 

public abstract class Company {

    protected abstract List<Employee> getEmployees();

    public void createSoftware() {
        for (Employee e : getEmployees()) {
            e.doWork();
        }
    }
}



public class GameDevCompany extends Company {
    protected List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Programmer());
    }
}

public class OutsourcingCompany extends Company {
    protected List<Employee> getEmployees() {
        return Arrays.asList(new Programmer(), new Tester());
    }
}
public class Main {
    public static void main(String[] args) {
        Company game = new GameDevCompany();
        game.createSoftware();

        Company outsource = new OutsourcingCompany();
        outsource.createSoftware();
    }
}
