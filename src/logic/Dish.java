package logic;

public class Dish {
    private String code;

    private String name;

    private int calories;

    private boolean isVegetarian;

    private double value;

    public Dish(String code, String name, int calories, boolean isVegetarian, double value) {
        this.code = code;
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                ", value=" + value +
                '}';
    }
}
