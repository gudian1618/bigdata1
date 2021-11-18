package com.github.gudian1618.bigdata1.mapreduce.sorfflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 12:04 下午
 */

public class SortFlowMapper extends Mapper<LongWritable, Text, Flow, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // adair	13766	19363
        String[] arr = value.toString().split("\t");
        Flow f = new Flow();
        f.setName(arr[0]);
        f.setUpFlow(Integer.parseInt(arr[1]));
        f.setDownFlow(Integer.parseInt(arr[2]));
        context.write(f, NullWritable.get());
    }
}
