package com.github.gudian1618.bigdata1.juc;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 4:34 下午
 * PriorityBlockingQueue在迭代的时候不保证排序
 */

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // PriorityBlockingQueue<Object> queue = new PriorityBlockingQueue<>();
        // queue.put("a");
        // queue.put("b");
        // queue.put("c");
        // queue.put("d");
        // queue.put("f");
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(queue.take());
        // }

        // 在创建队列的时候,如果希望队列中的元素可以按照年纪进行升序排序
        Comparator<Student> c = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()- o2.getAge();
            }
        };
        PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<>(5,c);
        queue.put(new Student("zhangsan", 18, 90));
        queue.put(new Student("lisi", 48, 80));
        queue.put(new Student("wangwu", 58, 70));
        queue.put(new Student("zhaoliu", 28, 60));
        queue.put(new Student("tainqi", 38, 50));
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(queue.take());
        // }
        for (Student s : queue) {
            System.out.println(s);
        }
    }

}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", score=" + score +
            '}';
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore()-this.getScore();
    }
}
