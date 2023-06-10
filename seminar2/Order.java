package seminar2;

public class Order {

    private static int id;
    private static String status;

    Order(int i){
        id = i;
    }
    public int getId() {
        return id;
    }

    public Object getStatus() {
        return status();
    }

    private String status() {
        return status;
    }

    public void setStatus(String ready) {
        this.status = status;
    }
}
