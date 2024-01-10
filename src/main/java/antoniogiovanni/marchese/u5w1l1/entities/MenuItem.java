package antoniogiovanni.marchese.u5w1l1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class MenuItem {
    private int kCalories;
    private double price;
    private String name;
}
