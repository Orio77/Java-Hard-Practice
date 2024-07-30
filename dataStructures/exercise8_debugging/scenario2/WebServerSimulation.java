package dataStructures.exercise8_debugging.scenario2;

import java.util.*;
import java.util.concurrent.*;

public class WebServerSimulation {
    static class Request {
        private final int data;

        public Request(int data) {
            this.data = data;
        }

        public int handle() {
            // Simulate handling the request by performing some operation on the data
            return (int) Math.sqrt(data);
        }
    }

    public static void main(String[] args) {
        // Use a LinkedBlockingQueue to simulate incoming requests
        BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

        // Start a new thread to generate requests
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(100);
                    queue.put(new Request(random.nextInt()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Start a new thread to handle requests
        new Thread(() -> {
            while (true) {
                try {
                    Request request = queue.take();
                    request.handle();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
