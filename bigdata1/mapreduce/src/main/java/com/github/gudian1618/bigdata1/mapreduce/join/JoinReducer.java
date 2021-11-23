package com.github.gudian1618.bigdata1.mapreduce.join;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/23 1:24 下午
 */

public class JoinReducer extends Reducer<Text,Order, Text, DoubleWritable> {

    @Override
    protected void reduce(Text key, Iterable<Order> values, Context context) throws IOException, InterruptedException {
        double sum = 0;
        for (Order value : values) {
            sum += value.getNum() * value.getPrice();
        }
        context.write(key, new DoubleWritable(sum));
    }
}
