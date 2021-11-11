package com.github.gudian1618.bigdata1.avro;

import org.junit.Test;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/11 9:13 下午
 */

public class AvroDemo01 {

    @Test
    public void create() {
        // 方式1: 先创建对象在赋值
        Student s1 = new Student();
        s1.setName("zhangsan");
        s1.setAge(18);
        s1.setGender("female");
        s1.setHeight(167.5);
        s1.setWeight(57.8);
        System.out.println(s1);

        // 方式2: 在创建对象时赋值
        Student s2 = new Student("lisi",23,"male",178.4,72.5);
        System.out.println(s2);

        // 方式3: 通过枚举创建
        Student s3 = new Student();
        s3.put(0, "wangwu");
        s3.put(1, 34);
        s3.put(2, "male");
        s3.put(3, 186.3);
        s3.put(4, 87.4);
        System.out.println(s3);

        // 方式4: 适用于反射
        Student s4 = new Student();
        s4.put("name", "zhaoliu");
        s4.put("age", 16);
        s4.put("gender", "male");
        s4.put("height", 167.4);
        s4.put("weight", 56.2);
        System.out.println(s4);

        // 方式5: 建造者模式
        Student s5 = Student.newBuilder().setName("bob").setAge(54).setGender("male").setHeight(187.2).setWeight(87.4).build();
        System.out.println(s5);

        // 方式6: 建造者模式
        Student s6 = Student.newBuilder().setName("jerry").build();
        System.out.println(s6);

    }
}
