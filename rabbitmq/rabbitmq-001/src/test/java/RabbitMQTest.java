import com.hxt.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import org.junit.Test;

public class RabbitMQTest {
    @Test
    public void testTemporaryQueue() throws Exception {
        Channel channel = RabbitMQUtil.getChannel();
        String queue = channel.queueDeclare().getQueue();
        channel.queueDeclare(queue, false, false, false, null);
        System.out.println(queue);
    }
}
