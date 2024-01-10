package antoniogiovanni.marchese.u5w1l1.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem{
    List<Topping> ingredients;
    public Pizza(){
        ingredients = new ArrayList<>();
        Topping tomato = new Topping();
        tomato.setName("tomato");
        tomato.setPrice(0.5);
        tomato.setKCalories(40);
        ingredients.add(tomato);
        Topping cheese = new Topping();
        cheese.setName("cheese");
        cheese.setPrice(0.6);
        cheese.setKCalories(300);
        ingredients.add(cheese);
        setName("Pizza Margherita");
        setPrice(4.99);
        setKCalories(1104);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Topping t: ingredients){
            sb.append(t.getName()+", ");
        }
        String ingred = sb.toString();
        return getName()+" ("+ ingred.substring(0, ingred.length() - 2)+")";
    }

    public void addTopping(Topping t){
        ingredients.add(t);
    }
}
