package com.github.gudian1618.bigdata1.mapreduce.partflow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 11:33 上午
 * 统计总流量
 */

public class PartFlowReducer extends Reducer<Text, Flow, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<Flow> values, Reducer<Text, Flow, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Flow value : values) {
            sum += value.getUpFlow() + value.getDownFlow();
        }
        context.write(key, new IntWritable(sum));
    }
}
