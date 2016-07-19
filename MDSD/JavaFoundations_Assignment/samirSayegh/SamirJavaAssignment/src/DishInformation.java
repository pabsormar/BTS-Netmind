import java.util.List;

/**
 * Created by samir.sayegh on 2/17/2016.
 */
public class DishInformation extends Dish {

    private static final String STR_STARTER = "st";
    private static final String STR_MAIN_COURSE = "mc";
    private static final String STR_DESSERT = "ds";

    public static final int STARTER = 0;
    public static final int MAIN_COURSE = 1;
    public static final int DESSERT = 2;

    private boolean glutenFree;
    private boolean vegetarian;
    private boolean halalMeat;
    private boolean seafoodFree;
    private int type;
    private String customerName;
    private String extras;

    public DishInformation() {
        super();
    }

    public DishInformation(String commaLine) {
        String[] strings = commaLine.split(",");
        if (strings.length == 8) {
            setCustomerName(strings[0]);
            setDishName(strings[1]);
            setType(strings[2]);
            setGlutenFree(getBooleanValueFromString(strings[3]));
            setVegetarian(getBooleanValueFromString(strings[4]));
            setHalalMeat(getBooleanValueFromString(strings[5]));
            setSeafoodFree(getBooleanValueFromString(strings[6]));
            setExtras(strings[7]);
        } else {
            throw new IllegalArgumentException("Incorrect number of arguments");
        }
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isHalalMeat() {
        return halalMeat;
    }

    public void setHalalMeat(boolean halalMeat) {
        this.halalMeat = halalMeat;
    }

    public boolean isSeafoodFree() {
        return seafoodFree;
    }

    public void setSeafoodFree(boolean seafoodFree) {
        this.seafoodFree = seafoodFree;
    }

    public int getType() {
        return type;
    }

    public static int getTypeValue(String typeString) {
        switch (typeString) {
            case STR_DESSERT:
                return DESSERT;
            case STR_MAIN_COURSE:
                return MAIN_COURSE;
            case STR_STARTER:
                return STARTER;
            default:
                return -1;
        }
    }

    public void setType(String typeString) {
        this.type = getTypeValue(typeString);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    private boolean getBooleanValueFromString(String boolString) {
        return boolString.equals("true");
    }

    @Override
    public String toString() {
        String typeString = "";
        switch (type) {
            case STARTER:
                typeString = "Starter";
                break;
            case MAIN_COURSE:
                typeString = "Main course";
                break;
            case DESSERT:
                typeString = "Dessert";
                break;
            default:
                break;
        }
        return "DishInformation{" +
                "dishName='" + getDishName() + '\'' +
                ", glutenFree=" + glutenFree +
                ", vegetarian=" + vegetarian +
                ", halalMeat=" + halalMeat +
                ", seafoodFree=" + seafoodFree +
                ", type=" + typeString +
                ", customerName='" + customerName + '\'' +
                ", extras='" + extras + '\'' +
                '}';
    }
}
