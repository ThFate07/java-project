import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void displayReport() {
        System.out.println("Cakes Sold Report:");
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
