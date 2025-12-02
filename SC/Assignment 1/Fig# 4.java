public interface Shipping {
    double getCost(Order order);
    String getDate(Order order);
}
//Ground implements Shipping
public class Ground implements Shipping {
    public double getCost(Order order) {
        if (order.getTotal() > 100) {
            return 0;
        }
        double cost = order.getTotalWeight() * 1.5;
        return Math.max(10, cost);
    }

    public String getDate(Order order) {
        return "Ground delivery: 5-7 days";
    }
}
//Air implements Shipping
public class Air implements Shipping {
    public double getCost(Order order) {
        return order.getTotalWeight() * 3;
    }

    public String getDate(Order order) {
        return "Air delivery: 1-2 days";
    }
}
 //Order
public class Order {
    private double total;
    private double totalWeight;
    private Shipping shipping;

    public Order(double total, double totalWeight, Shipping shipping) {
        this.total = total;
        this.totalWeight = totalWeight;
        this.shipping = shipping;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getShippingCost() {
        return shipping.getCost(this);
    }

    public String getShippingDate() {
        return shipping.getDate(this);
    }
}
//Main
public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(120, 20, new Ground());
        System.out.println(o1.getShippingCost());
        System.out.println(o1.getShippingDate());

        Order o2 = new Order(80, 10, new Air());
        System.out.println(o2.getShippingCost());
        System.out.println(o2.getShippingDate());
    }
}
