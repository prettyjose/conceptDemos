package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application {

    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            public String getMessage() {
                return "Pretty dear, Christ's peace be with you.";
            }
        };
    }



    public static void main(String[] args) {

        /* MessagePrinter is decoupled from MessageService*/
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
