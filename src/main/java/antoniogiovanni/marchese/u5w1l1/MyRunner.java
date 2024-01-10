package antoniogiovanni.marchese.u5w1l1;

import antoniogiovanni.marchese.u5w1l1.entities.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1L2Application.class);
        System.out.println(ctx.getBean(Order.class));
        ctx.close();
    }
}

