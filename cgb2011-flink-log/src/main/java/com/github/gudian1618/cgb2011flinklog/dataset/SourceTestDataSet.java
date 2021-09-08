package com.github.gudian1618.cgb2011flinklog.dataset;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import java.util.ArrayList;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/9/8 10:01 下午
 * 针对DataSet数据源的练习
 */

public class SourceTestDataSet {

    public static void main(String[] args) throws Exception {
        // 1.获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // 2.获取数据源
        // 2.1. env.fromElements("")
        // ArrayList<String> list = new ArrayList<>();
        // list.add("陈子枢");
        // list.add("齐雷");
        // list.add("王海涛");
        // list.add("刘沛霞");
        // list.add("张培镇");
        // list.add("刘钰江");
        // list.add("董长春");
        // list.add("张久军");
        // 测试中使用
        // DataSource<String> source = env.fromCollection(list);

        // 2.2.
        DataSource<String> source = env.readTextFile("1.txt");
        // 3.转化
        source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] split = s.split(" ");
                for (String s1 : split) {
                    collector.collect(new Tuple2<String, Integer>(s1, 1));
                }
            }
        }).groupBy(0).sum(1)
        // 4.输出结果
        .print();
    }

}
