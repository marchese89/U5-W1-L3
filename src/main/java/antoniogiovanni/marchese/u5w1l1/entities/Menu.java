package antoniogiovanni.marchese.u5w1l1.entities;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class Menu {
    List<Pizza> pizzas = new ArrayList<>();
    List<Topping> toppings = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu\n\nPizzas\n");
        for(Pizza pizza: pizzas){
            sb.append(pizza.toString()+"\n");
        }
        sb.append("Toppings\n");
        for(Topping topping: toppings){
            sb.append(topping.toString()+"\n");
        }
        sb.append("Drinks\n");
        for(Drink drink: drinks){
            sb.append(drink.toString()+"\n");
        }

        return sb.toString();
    }
}
