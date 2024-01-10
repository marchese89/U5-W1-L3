package antoniogiovanni.marchese.u5w1l1;

import antoniogiovanni.marchese.u5w1l1.entities.MenuItem;
import antoniogiovanni.marchese.u5w1l1.entities.Order;
import antoniogiovanni.marchese.u5w1l1.entities.Table;
import antoniogiovanni.marchese.u5w1l1.enums.OrderState;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5W1L2ApplicationTests {

	private static final double TOLERANCE = 0.0001;

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1L2Application.class);

	@Test
	void margheritaTest(){
		MenuItem margherita = ctx.getBean("margherita", MenuItem.class);
		assertEquals(4.99,margherita.getPrice());
	}
	@Test
	void wineTest(){
		MenuItem wine = ctx.getBean("wine", MenuItem.class);
		assertEquals(7.49,wine.getPrice());
	}

	@Test
	void totalOrder() {
		Order order = ctx.getBean(Order.class);
		assertEquals(17.35,order.totalPrice(),TOLERANCE);
	}
	@Test
	void totalOrder2(){
		Order order = new Order(2, OrderState.IN_PROGRESS,1, LocalDateTime.now(),ctx.getBean(Table.class),2);
		order.addItem(ctx.getBean("margherita", MenuItem.class));
		order.addItem(ctx.getBean("water", MenuItem.class));
		assertEquals(8.28,order.totalPrice(),TOLERANCE);
	}
	@Test
	void orderChecks(){
		Order order = new Order(3, OrderState.IN_PROGRESS,1, LocalDateTime.now(),ctx.getBean(Table.class),2);
		assertAll(
			() -> assertEquals(1,order.getCovers()),
			() -> assertEquals(2,order.getCoverCost())
		);
	}
}
