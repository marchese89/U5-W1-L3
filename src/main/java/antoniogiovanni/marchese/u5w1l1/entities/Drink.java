package antoniogiovanni.marchese.u5w1l1.entities;

public class Drink extends MenuItem{

    @Override
    public String toString() {
        return getName()+" kcal: "+getKCalories()+" price: "+getPrice();
    }
}
