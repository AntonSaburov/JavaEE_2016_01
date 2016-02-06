package edu.javacourse.jmock;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public String publish(String message) {
        String answer = null;
        for (Subscriber s : subscribers) {
            answer = s.receive(message);
            System.out.println(answer);
        }
        return answer;
    }
}
