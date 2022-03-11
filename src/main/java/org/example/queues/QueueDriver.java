package org.example.queues;

public class QueueDriver {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayListQueue<>();

        queue.offer("Hello");
        queue.offer("World");

        System.out.println(queue);

    }
}
