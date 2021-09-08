package com.github.gudian1618.cgb2011flinklog.dataset;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/9/8 10:29 下午
 * 针对DataSet的sink数据输出的练习
 */

public class SinkTestDataSet {

    public static void main(String[] args) throws Exception {
        // 1.获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // 2.获取数据源
        DataSource<String> source = env.readTextFile("1.txt");

        // 3.转化
        AggregateOperator<Tuple2<String, Integer>> data = source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] split = s.split(" ");
                for (String s1 : split) {
                    collector.collect(new Tuple2<String, Integer>(s1, 1));
                }
            }
        }).groupBy(0).sum(1);

        // 4.输出数据到本地文件
        // flink在运行时默认会调用服务器中的所有可见资源(比如CPU核和超线程),这里通过链式调用api设定setParallelism设定CPU并行度
        data.writeAsText("2.txt").setParallelism(1);
        data.writeAsText("hdfs://hadoop01:9000/data/2.txt").setParallelism(1);
        System.out.println("执行成功");

        // 5.触发执行(当输出数据为文件时,必须要触发)
        env.execute("SinkTestDataSet");
    }

}
