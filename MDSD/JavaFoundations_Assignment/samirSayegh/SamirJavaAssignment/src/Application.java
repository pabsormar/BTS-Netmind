import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samir.sayegh on 2/17/2016.
 */
public class Application {

    public static void testMethods(List<Object> list) {
        OrderList orderList = new OrderList();

        List<Object> feature1 = orderList.getDishesByFeature(list, "gfd");
        List<Object> feature2 = orderList.getDishesByFeature(list, "vgd");
        List<Object> feature3 = orderList.getDishesByFeature(list, "hmd");
        List<Object> feature4 = orderList.getDishesByFeature(list, "sfd");

        List<Object> type1 = orderList.getDishesByType(list, "st");
        List<Object> type2 = orderList.getDishesByType(list, "mc");
        List<Object> type3 = orderList.getDishesByType(list, "ds");

        System.out.println("------ NUMBER OF ORDERS ------");
        System.out.println(orderList.getNumberOrders(list));

        System.out.println("------ GET ORDER ------");
        System.out.println(orderList.getOrder(list, 1));

        System.out.println("------ ALL ORDERS ------");
        System.out.println(orderList.getAllOrdersToString(list));

        System.out.println("------ ALL DISHES ------");
        System.out.println(orderList.getAllDishToString(list));

        System.out.println("------ DISH BY FEATURE ------");
        System.out.println("gfd");
        System.out.println(orderList.getAllOrdersToString(feature1));
        System.out.println("vgd");
        System.out.println(orderList.getAllOrdersToString(feature2));
        System.out.println("hmd");
        System.out.println(orderList.getAllOrdersToString(feature3));
        System.out.println("sfd");
        System.out.println(orderList.getAllOrdersToString(feature4));

        System.out.println("------ DISH BY TYPE ------");
        System.out.println("st");
        System.out.println(orderList.getAllOrdersToString(type1));
        System.out.println("mc");
        System.out.println(orderList.getAllOrdersToString(type2));
        System.out.println("ds");
        System.out.println(orderList.getAllOrdersToString(type3));

        System.out.println("------ STATS BY DISH TYPE ------");
        System.out.println("gfd");
        System.out.println(orderList.getStatsByDishType(list, "gfd"));
        System.out.println("vgd");
        System.out.println(orderList.getStatsByDishType(list, "vgd"));
        System.out.println("hmd");
        System.out.println(orderList.getStatsByDishType(list, "hmd"));
        System.out.println("sfd");
        System.out.println(orderList.getStatsByDishType(list, "sfd"));
    }

    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("onlineOrderSample.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    arrayList.add(new DishInformation(line));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testMethods(arrayList);
    }

}
