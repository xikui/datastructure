package com.hnxljd.list;

import com.hnxljd.list.impl.oneway.OneWayLinkedList;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.LinkedList;

/**
 * @author : hnxljd
 * @date : Created in 23:42 2018/5/26
 */
public class ListTest {
    private static final LinkedList<User> data = data();
    private static final List<User> test = testData();
    private static final int ARRAY_SIZE = 5000;
    private static int INDEX_TEST = 5000;
    private static final String NAME = "name";

    @Parameterized.Parameters
    public static LinkedList<User> data() {
        LinkedList<User> users = new LinkedList<>();
        for (Integer i = 0; i < ARRAY_SIZE; i++) {
            int age = i * 2 + 1;
            users.add(new User(String.join(NAME, i.toString()), age));
        }
        return users;
    }

    @Parameterized.Parameters
    public static List<User> testData() {
        List<User> users = new OneWayLinkedList<>();
        for (Integer i = 0; i < 5000; i++) {
            int age = i * 2 + 1;
            users.add(new User(String.join(NAME, i.toString()), age));
        }
        return users;
    }

    @Test
    public synchronized void testAll() throws Exception {
        INDEX_TEST = test.size();
        add();
        remove();
        get();
        replace();
        size();
        equalsAll();
        INDEX_TEST = 0;
        add();
        remove();
        get();
        replace();
        size();
        equalsAll();
        INDEX_TEST = 50000;
        add();
        try {
            remove();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("success1");
        }
        try {
            get();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("success2");
        }
        try {
            replace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("successAll");
        }
        size();
        equalsAll();
    }

    @Test
    public void equalsAll() throws Exception {
        size();

        for (int i = 0; i < test.size(); i++) {
            User user = test.get(i);
            User o = data.get(i);
            if (!user.equals(o)) {
                System.out.println("size : ");
                System.out.println("test : " + user.toString());
                System.out.println("data : " + o.toString());
                throw new Exception("equalsAll");
            }
        }
    }

    @Test
    public void size() throws Exception {
        if (test.size() != data.size()) {
            System.out.println("size : ");
            System.out.println("test : " + test.size());
            System.out.println("data : " + data.size());
            throw new Exception("size");
        }
    }

    @Test
    public void remove() throws Exception {
        int index = getIndex();
        test.remove(index);
        data.remove(index);
        equalsAll();
    }


    @Test
    public synchronized void add() throws Exception {
        List<User> userList = new OneWayLinkedList<>();

        for (User aData : data) {
            /*测试每一次的size*/
            size();

            userList.add(aData);
        }
        equalsAll();
    }

    @Test
    public void replace() throws Exception {
        User test = new User("test", 666666);
        int index = getIndex();
        data.set(index, test);
        ListTest.test.replace(index, test);
        equalsAll();
    }

    @Test
    public void get() throws Exception {
        int index = getIndex();
        if (!data.get(index).equals(test.get(index))) {
            throw new Exception("get");
        }
    }

    private int getIndex() {
        return (int) (Math.random() * INDEX_TEST);
    }
}
