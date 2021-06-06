import java.util.Date;

public class Orders {
    private long OrdersID;
    private long CarsID;
    private long CustomersId;
    private Date date;

    public Orders() {
    }

    public Orders(long ordersID, long carsID, long customersId, Date date) {
        OrdersID = ordersID;
        CarsID = carsID;
        CustomersId = customersId;
        this.date = date;
    }

    public long getOrdersID() {
        return OrdersID;
    }

    public void setOrdersID(long ordersID) {
        OrdersID = ordersID;
    }

    public long getCarsID() {
        return CarsID;
    }

    public void setCarsID(long carsID) {
        CarsID = carsID;
    }

    public long getCustomersId() {
        return CustomersId;
    }

    public void setCustomersId(long customersId) {
        CustomersId = customersId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

