package com.github.gudian1618.cgb2011flinklog.dataset;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple5;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/9/9 9:51 下午
 * 针对Transformation的练习
 */

public class TransformationTestDataSet {

    public static void main(String[] args) throws Exception {
        // 1.获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // 2.获取数据源
        DataSource<String> source = env.readTextFile("3.txt").setParallelism(3);
        // DataSource<String> source = env.fromElements("hadoop", "hive", "flume", "kafka", "flink");

        // 3.Transformation 转化
        source.map(new MapFunction<String, Tuple5<String, String, String, String, Integer>>() {
            @Override
            public Tuple5<String, String, String, String, Integer> map(String s) throws Exception {
                String[] a = s.split("\\|");
                return new Tuple5<>(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]));
            }
        }).project(2,0).project(1)

            // .filter(new FilterFunction<String>() {
            //     @Override
            //     public boolean filter(String s) throws Exception {
            //         return s.split("\\|")[2].equals("中国");
            //     }
            // })

        //     .flatMap(new FlatMapFunction<String, String>() {
        //         @Override
        //         public void flatMap(String s, Collector<String> collector) throws Exception {
        //             String[] split = s.split("\\|");
        //             for (String a : split) {
        //                 collector.collect(a);
        //             }
        //         }
        //     })
        //     .mapPartition(new MapPartitionFunction<String, Long>() {
        //     @Override
        //     public void mapPartition(Iterable<String> iterable, Collector<Long> collector) throws Exception {
        //         long l = 0;
        //         for (String s : iterable) {
        //             l++;
        //         }
        //         collector.collect(l);
        //     }
        // })

        //     .flatMap(new FlatMapFunction<String, String>() {
        //     @Override
        //     public void flatMap(String s, Collector<String> collector) throws Exception {
        //         String[] split = s.split("\\|");
        //         for (int i = 0; i < split.length; i++) {
        //             collector.collect(split[i] + " " + i);
        //         }
        //     }
        // })

            // .map(new MapFunction<String, Book>() {
            //     @Override
            //     public Book map(String s) throws Exception {
            //         String[] a = s.split("\\|");
            //         Book book = new Book();
            //         book.setBookName(a[0]);
            //         book.setAuthor(a[1]);
            //         book.setCountry(a[2]);
            //         book.setGender(a[3]);
            //         book.setAge(Integer.parseInt(a[4]));
            //         return book;
            //     }
            // })

            //     .map(new MapFunction<String, Tuple5<String, String, String, String, Integer>>() {
            //     @Override
            //     public Tuple5<String, String, String, String, Integer> map(String s) throws Exception {
            //         String[] a = s.split("\\|");
            //         return new Tuple5<>(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]));
            //     }
            // })

            // 4.sink输出
            .print();

        // 5.提交执行

    }

}
