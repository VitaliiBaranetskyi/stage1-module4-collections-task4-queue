package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(firstQueue.poll());
        arrayDeque.offer(firstQueue.poll());
        arrayDeque.offer(secondQueue.poll());
        arrayDeque.offer(secondQueue.poll());
        while (firstQueue.size() != 0 && secondQueue.size() != 0){
            firstQueue.offer(arrayDeque.pollLast());
            arrayDeque.offer(firstQueue.poll());
            arrayDeque.offer(firstQueue.poll());
            secondQueue.offer(arrayDeque.pollLast());
            arrayDeque.offer(secondQueue.poll());
            arrayDeque.offer(secondQueue.poll());
        }
        //firstQueue = [7 9 2]
        //secondQueue = [8 3 4]
        //Array 1 3 4 5 8 5
        //
        return arrayDeque;
    }
}
