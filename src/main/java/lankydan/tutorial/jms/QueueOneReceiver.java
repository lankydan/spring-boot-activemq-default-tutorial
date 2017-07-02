package lankydan.tutorial.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class QueueOneReceiver {

  @JmsListener(destination = "QueueOne")
  public void receiveMessage(final int number) throws InterruptedException {
    System.out.println("<QueueOne> message <" + number + "> received");
    sleep(1000);
    System.out.println("<QueueOne> transaction <" + number + "> finished");
  }
}
