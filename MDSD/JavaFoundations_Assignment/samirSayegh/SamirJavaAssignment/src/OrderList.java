import java.util.ArrayList;
import java.util.List;

/**
 * Created by samir.sayegh on 2/17/2016.
 */
public class OrderList implements OnlineOrderOps {

    private static final String STR_GLUTEN_FREE = "gfd";
    private static final String STR_VEGETARIAN = "vgd";
    private static final String STR_HALAL_MEAT = "hmd";
    private static final String STR_SEAFOOD_FREE = "sfd";

    public OrderList() {

    }

    @Override
    public int getNumberOrders(List<Object> orderList) {
        return orderList.size();
    }

    @Override
    public Object getOrder(List<Object> orderList, int orderIndex) {
        return orderList.get(orderIndex);
    }

    @Override
    public String getAllOrdersToString(List<Object> orderList) {
        String stringOfAllOrders = "";
        for (Object object : orderList) {
            stringOfAllOrders += object.toString() + "\n";
        }
        return stringOfAllOrders;
    }

    @Override
    public Object getDish(List<Object> dishList, int dishIndex) {
        return dishList.get(dishIndex);
    }

    @Override
    public String getAllDishToString(List<Object> dishList) {
        String stringOfAllDish = "";
        for (Object object : dishList) {
            if (object instanceof Dish) {
                Dish dish = (Dish) object;
                stringOfAllDish += dish.getDishName() + "\n";
            }
        }
        return stringOfAllDish;
    }

    @Override
    public List<Object> getDishesByType(List<Object> dishList, String dishType) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int dishTypeInt = DishInformation.getTypeValue(dishType);
        for (Object object : dishList) {
            if (object instanceof DishInformation) {
                DishInformation dishInformation = (DishInformation) object;
                if (dishTypeInt == dishInformation.getType()) {
                    arrayList.add(dishInformation);
                }
            }
        }
        return arrayList;
    }

    @Override
    public List<Object> getDishesByFeature(List<Object> dishList, String feature) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object object : dishList) {
            if (getObjectFromFeature(object, feature))
                arrayList.add(object);
        }
        return arrayList;
    }

    @Override
    public String getStatsByDishType(List<Object> dishList, String dishType) {
        int dishTypeInt = DishInformation.getTypeValue(dishType);
        int total = dishList.size();
        int count = 0;
        for (Object object : dishList) {
            if (getObjectFromFeature(object, dishType))
                count++;
        }
        float percentage = count * 100 / total;
        return percentage + "%";
    }

    private boolean getObjectFromFeature(Object object, String feature) {
        if (object instanceof DishInformation) {
            DishInformation dishInformation = (DishInformation) object;
            switch (feature) {
                case STR_GLUTEN_FREE:
                    if (dishInformation.isGlutenFree())
                        return true;
                    break;
                case STR_HALAL_MEAT:
                    if (dishInformation.isHalalMeat())
                        return true;
                    break;
                case STR_SEAFOOD_FREE:
                    if (dishInformation.isSeafoodFree())
                        return true;
                    break;
                case STR_VEGETARIAN:
                    if (dishInformation.isVegetarian())
                        return true;
                    break;
                default:
                    return false;
            }
        }
        return false;
    }
}
