package seminar2;

import java.util.ArrayList;
import java.util.List;

public class Market implements I_QueueBehaviour, I_MarketBehaviour{
    private int maxSize;
    private List<String> queue;
    private List<Order> orders;

    public Market(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<String>();
        this.orders = new ArrayList<Order>();
    }

    public void addCustomer(String customer) {
        if (queue.size() < maxSize) {
            queue.add(customer);
            System.out.println(customer + " добавлен в очередь");
        } else {
            System.out.println("Некуда добавлять, очередь полная!");
        }
    }

    public void removeCustomer(String customer) {
        if (queue.contains(customer)) {
            queue.remove(customer);
            System.out.println(customer + " удален из очереди");
        } else {
            System.out.println(customer + " не в очереди");
        }
    }

    public void takeOrder(Order order) {
        orders.add(order);
        System.out.println("Заказ " + order.getId() + " принят");
    }

    public void completeOrder(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                orders.remove(order);
                System.out.println("Заказ " + orderId + " выполнен");
                break;
            }
        }
        System.out.println("Заказ " + orderId + " не найден");
    }

    public void update() {
        if (!orders.isEmpty()) {
            Order order = orders.get(0);
            if (order.getStatus().equals("готово")) {
                completeOrder(order.getId());
            } else if (order.getStatus().equals("в ожидании")) {
                order.setStatus("готово");
                System.out.println("Заказ " + order.getId() + " готов");
            }
        } else {
            System.out.println("Больше нет заказов");
        }
    }

    public List<String> get_queue() {
        return queue;
    }

    public List<Order> get_orders() {
        return orders;
    }
}