package antoniogiovanni.marchese.u5w1l1.config;


import antoniogiovanni.marchese.u5w1l1.entities.*;
import antoniogiovanni.marchese.u5w1l1.enums.OrderState;
import antoniogiovanni.marchese.u5w1l1.enums.TableState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;

@Configuration
@PropertySource("application.properties")
public class BeansConfiguration {

    @Bean
    public Topping cheese(){
        Topping t =  new Topping();
        t.setName("Cheese");
        t.setKCalories(92);
        t.setPrice(0.69);
        return  t;
    }
    @Bean
    public Topping ham(){
        Topping t =  new Topping();
        t.setName("Ham");
        t.setKCalories(35);
        t.setPrice(0.99);
        return  t;
    }
    @Bean
    public Topping onions(){
        Topping t =  new Topping();
        t.setName("Onions");
        t.setKCalories(22);
        t.setPrice(0.69);
        return  t;
    }
    @Bean
    public Topping pineapple(){
        Topping t =  new Topping();
        t.setName("Cheese");
        t.setKCalories(24);
        t.setPrice(0.79);
        return  t;
    }
    @Bean
    public Topping salami(){
        Topping t =  new Topping();
        t.setName("Salami");
        t.setKCalories(86);
        t.setPrice(0.99);
        return  t;
    }
    @Bean
    public Pizza margherita(){
        return  new Pizza();
    }
    @Bean
    public Pizza hawaiianPizza(){
        Pizza p = new Pizza();
        p.setName("Hawaiian Pizza");
        p.addTopping(ham());
        p.addTopping(pineapple());
        return p;
    }
    @Bean
    public Pizza salamiPizza(){
        Pizza p = new Pizza();
        p.setName("Salami Pizza");
        p.addTopping(salami());
        return p;
    }

    @Bean
    public Drink lemonade(){
        Drink d = new Drink();
        d.setName("Lemonade");
        d.setKCalories(128);
        d.setPrice(1.29);
        return d;
    }

    @Bean
    public Drink water(){
        Drink d = new Drink();
        d.setName("Water");
        d.setKCalories(0);
        d.setPrice(1.29);
        return d;
    }

    @Bean
    public Drink wine(){
        Drink d = new Drink();
        d.setName("Wine");
        d.setKCalories(607);
        d.setPrice(7.49);
        return d;
    }

    @Bean(name = "menu")
    public Menu menu(){
        Menu menu = new Menu();
        menu.addPizza(margherita());
        menu.addPizza(hawaiianPizza());
        menu.addPizza(salamiPizza());

        menu.addTopping(cheese());
        menu.addTopping(ham());
        menu.addTopping(onions());
        menu.addTopping(pineapple());
        menu.addTopping(salami());

        menu.addDrink(lemonade());
        menu.addDrink(water());
        menu.addDrink(wine());
        return menu;
    }
    @Bean
    public Table table(){
        return new Table(1,4, TableState.FREE);
    }

    @Bean
    public Order order(Table table,@Value("${coverCost}")Double coverCost){
        Order order = new Order(1, OrderState.IN_PROGRESS,2, LocalDateTime.now(),table,coverCost);
        order.addItem(hawaiianPizza());
        order.addItem(margherita());
        order.addItem(water());
        order.addItem(lemonade());
        order.addItem(pineapple());
        return order;
    }
}
