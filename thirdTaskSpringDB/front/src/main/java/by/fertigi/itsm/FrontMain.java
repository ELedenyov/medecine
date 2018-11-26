package by.fertigi.itsm;

import by.fertigi.itsm.service.IAuthorizationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan("by.fertigi.itsm.entity")
public class FrontMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FrontMain.class, args);
        System.out.println("Enter your login: ");
        String login = new Scanner(System.in).nextLine();
        System.out.println("Enter your password: ");
        String password = System.console() != null ? String.valueOf(System.console().readPassword()) : new Scanner(System.in).nextLine();
        if(context.getBean(IAuthorizationService.class).authorization(login, password)){
            Runnable mainMenu = (Runnable) context.getBean("mainMenu");
            mainMenu.run();
        } else {
            System.out.println("you entered your username or password incorrectly");
        }
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue queueReport() {
        return new Queue("report");
    }

    @Bean
    public ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }
}
