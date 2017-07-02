package lankydan.tutorial.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class QueueTwoReceiver {

  @JmsListener(destination = "QueueTwo")
  public void receiveMessage(final int number) throws InterruptedException {
    System.out.println("<QueueTwo> message <" + number + "> received");
    sleep(1000);
    System.out.println("<QueueTwo> transaction <" + number + "> finished");
  }
}
