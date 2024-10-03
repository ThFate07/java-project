import java.util.Date;

public class Order {
    private Cake cake;
    private int quantity;
    private double discount;
    private String deliveryDetails;

    public Order(Cake cake, int quantity, double discount, String deliveryDetails) {
        this.cake = cake;
        this.quantity = quantity;
        this.discount = discount;
        this.deliveryDetails = deliveryDetails;
    }

    public double calculateTotalPrice() {
        double totalPrice = cake.getPrice() * quantity;
        return totalPrice - (totalPrice * (discount / 100));
    }

    @Override
    public String toString() {
        return "Cake: " + cake.getName() + ", Size: " + cake.getSize() +
               ", Quantity: " + quantity + ", Total Price: " + calculateTotalPrice() +
               ", Delivery: " + deliveryDetails;
    }
}
