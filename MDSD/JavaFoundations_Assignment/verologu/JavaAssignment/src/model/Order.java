package model;

import model.base.Dish;

public class Order {

    public static final String STARTER = "st";
    public static final String MAIN_COURSE = "mc";
    public static final String DESSERT = "ds";

    public static final String STARTER_TYPE = "Starter";
    public static final String MAIN_COURSE_TYPE = "Main course";
    public static final String DESSERT_TYPE = "Dessert";

    private String customerName;
    private Dish dish;
    private String dishName;
    private String typeString;
    private boolean gfd;
    private boolean vgd;
    private boolean hmd;
    private boolean sfd;
    private String extras;


    public Order() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        String type = checkTypeString(typeString);
        this.typeString = type;
    }

    private String checkTypeString(String typeString) {
        if (STARTER.equals(typeString)) {
            return STARTER_TYPE;
        } else if (MAIN_COURSE.equals(typeString)) {
            return MAIN_COURSE_TYPE;
        } else if (DESSERT.equals(typeString)) {
            return DESSERT_TYPE;
        } else {
            return typeString;
        }
    }

    public boolean isGfd() {
        return gfd;
    }

    public void setGfd(boolean gfd) {
        this.gfd = gfd;
    }

    public boolean isVgd() {
        return vgd;
    }

    public void setVgd(boolean vgd) {
        this.vgd = vgd;
    }

    public boolean isHmd() {
        return hmd;
    }

    public void setHmd(boolean hmd) {
        this.hmd = hmd;
    }

    public boolean isSfd() {
        return sfd;
    }

    public void setSfd(boolean sfd) {
        this.sfd = sfd;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getDishIs() {
        String dishIs = "";
        if (isGfd()) {
            dishIs += "gluten free";
        }

        if (isVgd()) {
            dishIs += dishIs.length() != 0 ? " & " : " ";
            dishIs += "vegetarian";
        }

        if (isHmd()) {
            dishIs += dishIs.length() != 0 ? " &" : " ";
            dishIs += "halal meal";
        }

        if (isSfd()) {
            dishIs += dishIs.length() != 0 ? " & " : " ";
            dishIs += "seafood free";
        }

        return dishIs;
    }
}
