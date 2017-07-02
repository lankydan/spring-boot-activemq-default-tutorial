package lankydan.tutorial.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@ComponentScan(basePackages = "lankydan.tutorial")
@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired private JmsTemplate jmsTemplate;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(final String args[]) {
    for (int i = 0; i < 10; i++) {
      System.out.println("<QueueOne> send message");
      jmsTemplate.convertAndSend("QueueOne", i);

      System.out.println("<QueueTwo> send message");
      jmsTemplate.convertAndSend("QueueTwo", i);
    }
  }
}
