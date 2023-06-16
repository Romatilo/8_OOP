package seminar2;

public interface I_MarketBehaviour {
    public void takeOrder(Order order);
    public void completeOrder(int orderId);
    public void update();
}
