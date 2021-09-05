package com.github.gudian1618.cgb2011flinklog.dataset;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/9/5 1:47 下午
 * 入门案例: 单词统计 WordCount
 * hadoop hive flume kafka zookeeper hadoop hadoop flink flink
 */

public class WorldCountDataSet {

    public static void main(String[] args) throws Exception {
        // 1.获得execution environment
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // 2.加载/创建初始数据
        DataSource<String> source = env.fromElements("hadoop hive flume kafka zookeeper hadoop hadoop flink flink");
        // 3.指定对此数据的转换
        // TODO 数据转化
        // 将字符串用" "进行切分,分别是输出每个元素
        source.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] split = s.split(" ");
                for (String a : split) {
                    collector.collect(a);
                }
            }
        }).map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        }).groupBy(0).sum(1)
        // 4.指定计算结果存放何处
        .print();
        // 5.触发程序执行(离线DataSet)

    }
}
