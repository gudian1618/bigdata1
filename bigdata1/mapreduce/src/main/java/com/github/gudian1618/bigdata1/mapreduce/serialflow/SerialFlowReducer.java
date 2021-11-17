package com.github.gudian1618.bigdata1.mapreduce.serialflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 7:24 下午
 */

public class SerialFlowReducer extends Reducer<Text, Flow, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {
        int sumUp = 0;
        int sumDown = 0;
        for (Flow value : values) {
            sumUp += value.getUpFlow();
            sumDown += value.getDownFlow();
        }
        context.write(key, new Text(sumUp + "\t" + sumDown));
    }
}
