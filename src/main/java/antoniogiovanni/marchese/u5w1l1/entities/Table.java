package antoniogiovanni.marchese.u5w1l1.entities;

import antoniogiovanni.marchese.u5w1l1.enums.TableState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Table {
    private int tableNumber;
    private int maxTableCovers;

    private TableState state;
}
