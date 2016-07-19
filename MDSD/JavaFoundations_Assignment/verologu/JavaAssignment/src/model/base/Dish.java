package model.base;

public abstract class Dish {

    public enum Type {
        GLUTEN_FREE,
        VEGETARIAN,
        HALAL_MEAT,
        SEAFOOD_FREE,
    }

    protected String name;
    protected Type type;

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
