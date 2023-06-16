package seminar2;

import java.util.*;

public class Market implements I_QueueBehaviour, I_MarketBehaviour{
    private int maxSize;
    static List<String> queue;
    static List<Order> orders;

    public Market(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<String>();
        this.orders = new ArrayList<Order>();
    }

    @FunctionalInterface
    interface I_MarketOperation<T> {
        T performOperation(Market market);
    }
    @Override
    /// Добавление клиента в очередь ///
    public void addCustomer(String customer) {
        if (queue.size() < maxSize) {
            queue.add(customer);
            System.out.println(customer + " добавлен в очередь");
        } else {
            System.out.println("Некуда добавлять, очередь полная!");
        }
    }

    @Override
    /// Удаленпие клиента из очереди ///
    public void removeCustomer(String customer) {
        if (queue.contains(customer)) {
            queue.remove(customer);
            System.out.println(customer + " удален из очереди");
        } else {
            System.out.println(customer + " не в очереди");
        }
    }

    @Override
    /// Добавление заказа в список заказов ///
    public void takeOrder(Order order) {
        orders.add(order);
        System.out.println("Заказ " + order.getId() + " принят");
    }

    @Override
    /// Удаление заказа из списка заказов, если он там есть ///
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

    @Override
    /// Обновление состояния магазина путем принятия и отдачи заказов ///
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

    public<T> T performMarketOperation(Market market, I_MarketOperation<T> operation) {
        return operation.performOperation(market);
    }
    Market market = new Market(100);

    Market.I_MarketOperation<Integer> getQueueSize = (market) -> queue.size();
    int queueSize = performMarketOperation(market, getQueueSize);

    Iterator <String> iterator = queue.iterator();

    public void isPersonInQueue() {

        if (iterator.hasNext()) {
            System.out.println("В очереди есть человек");
        } else {
            System.out.println("Очередь пуста");
        }
    }
    public List<String> getQueue() {
        return queue;
    }

    public List<Order> getOrders() {
        return orders;
    }
}