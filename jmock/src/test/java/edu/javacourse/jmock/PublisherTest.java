package edu.javacourse.jmock;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class PublisherTest {

    private Mockery context = new JUnit4Mockery();
    
    @Test
    public void testOneSubscriberReceivesAMessage() {

        final Subscriber subscriber = context.mock(Subscriber.class);
        final String message = "message";
        context.checking(new Expectations() {{
            //never(subscriber).receive(message);
            oneOf(subscriber).receive(message);
            //exactly(1).of(subscriber).receive(message);
            //atLeast(1).of(subscriber).receive(message);
            //atMost(2).of(subscriber).receive(message);
            //between(1, 5).of(subscriber).receive(message);
            //allowing(subscriber).receive(message);
            will(returnValue("Hello world"));
        }});
        
        Publisher publisher = new Publisher();
        publisher.add(subscriber);
        // execute
        String answer = publisher.publish(message);
        // verify
        context.assertIsSatisfied();
        Assert.assertEquals("Hello world", answer);
    }
}