package antoniogiovanni.marchese.u5w1l1.entities;

import antoniogiovanni.marchese.u5w1l1.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Order {
    int orderNumber;
    OrderState orderState;
    int covers;
    Double coverCost;
    LocalDateTime acquisitionTime;
    Table table;
    List<MenuItem> menuItemList = new ArrayList<>();

    
    public Order(int orderNumber, OrderState orderState, int covers, LocalDateTime acquisitionTime, Table table,double coverCost) {
        this.orderNumber = orderNumber;
        this.orderState = orderState;
        this.covers = covers;
        this.acquisitionTime = acquisitionTime;
        this.table = table;
        this.coverCost = coverCost;
    }

    public double totalPrice(){
        double total = 0;
//        for (MenuItem menuItem: menuItemList){
//            total+= menuItem.getPrice();
//        }
        total = menuItemList.stream().mapToDouble(MenuItem::getPrice).sum();
        return total+(covers*coverCost);
    }

    public void addItem(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order{" +
                "orderNumber=" + orderNumber +
                ", orderState=" + orderState +
                ", covers=" + covers +
                ", acquisitionTime=" + acquisitionTime +
                ", table=" + table +
                "}\n");
        stringBuilder.append("Menu Items List\n");
        for (MenuItem menuItem: menuItemList){
            stringBuilder.append(menuItem+"\n");
        }
        stringBuilder.append("total: "+totalPrice()+"\n");
        return stringBuilder.toString();
    }
}
