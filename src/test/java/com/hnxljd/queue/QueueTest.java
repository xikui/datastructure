package com.hnxljd.queue;

import com.hnxljd.queue.impl.ArrayQueue;
import com.hnxljd.queue.impl.LinkedQueue;
import org.junit.Test;
import org.junit.runners.Parameterized;

public class QueueTest {
    private Queue arrq = testArrayPush();
    private Queue linkq = testLinkedPush();
    @Parameterized.Parameters
    public Queue testArrayPush(){
        Queue queue = new ArrayQueue<>();
        int var1 = queue.push("123");
        int var2 = queue.push("345");
       return queue;
    }
    @Parameterized.Parameters
    public Queue testLinkedPush(){
        Queue queue = new LinkedQueue<>();
        int var1 = queue.push("123");
        int var2 = queue.push("345");
       return queue;
    }
    @Test
    public void testPop(){
        System.out.println(arrq.pop());

        System.out.println(linkq.pop());
    }
}
