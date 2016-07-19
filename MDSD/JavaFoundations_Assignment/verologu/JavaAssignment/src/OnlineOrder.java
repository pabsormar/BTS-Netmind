import model.Order;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by verologu on 15/03/16.
 */
public class OnlineOrder implements OnlineOrderOps {

    private static final String TRUE = "true";

    private static List<Order> orders = new ArrayList<Order>();

    public static void main(String[] args) {
        readFile();
        printOrders();
    }

    private static void readFile() {
        try {
            Scanner in = new Scanner(new FileReader("data/online_order_test.csv"));
            in = in.useDelimiter("\\n");
            in.next();
            while (in.hasNext()) {
                readOrder(in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readOrder(String orderLine) {
        String[] orderItems = orderLine.split(",");
        if (orderItems.length < 7) {
            System.out.println("The order has wrong items size");
            return;
        }

        Order order = new Order();
        order.setCustomerName(orderItems[0]);
        order.setDishName(orderItems[1]);
        order.setTypeString(orderItems[2]);
        order.setGfd(TRUE.equals(orderItems[3]));
        order.setVgd(TRUE.equals(orderItems[4]));
        order.setHmd(TRUE.equals(orderItems[5]));
        order.setSfd(TRUE.equals(orderItems[6]));
        order.setExtras(orderItems[7]);

        orders.add(order);
    }

    private static void printOrders() {
        String orderDetails = "--------- Orders ---------";

        for (Order order : orders) {
            orderDetails += "\n-- Dish start --";
            orderDetails += "\nCustomer name: " + order.getCustomerName();
            orderDetails += "\nDish name: " + order.getDishName();
            orderDetails += "\nDish type: " + order.getTypeString();
            orderDetails += "\nDish is: " + order.getDishIs();
            orderDetails += "\nDish extras: " + order.getExtras();
            orderDetails += "\n-- Dish end --";
        }

        System.out.println(orderDetails);
    }


    @Override
    public int getOrdersCount() {
        return orders.size();
    }

    @Override
    public String getOrderDescription(int line) {
        String orderDescription = getOrderDescriptionForLine(line);

        System.out.println(orderDescription);

        return orderDescription;
    }

    private String getOrderDescriptionForLine(int line) {
        Order order = orders.get(line);

        return getOrderDetails(order, line);
    }

    private String getOrderDetails(Order order, int line) {
        String orderDetails = "--------- Order #" + line + " ---------";
        orderDetails += "\nCustomer name: " + order.getCustomerName();
        orderDetails += "\nDish name: " + order.getDishName();
        orderDetails += "\nDish type: " + order.getTypeString();
        orderDetails += "\nDish is: " + order.getDishIs();
        orderDetails += "\nDish extras: " + order.getExtras();
        orderDetails += "\n-------------------------";

        return orderDetails;
    }
}
