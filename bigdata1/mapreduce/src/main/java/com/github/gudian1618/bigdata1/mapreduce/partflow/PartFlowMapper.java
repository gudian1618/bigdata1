package com.github.gudian1618.bigdata1.mapreduce.partflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 10:18 上午
 */

public class PartFlowMapper extends Mapper<LongWritable, Text, Text, Flow> {

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Flow>.Context context) throws IOException, InterruptedException {
        // 16936842654 shanghai peter 5223 9645
        String[] arr = value.toString().split(" ");
        // 封装对象
        Flow f = new Flow();
        f.setCity(arr[1]);
        f.setUpFlow(Integer.parseInt(arr[3]));
        f.setDownFlow(Integer.parseInt(arr[4]));
        context.write(new Text(arr[2]), f);
    }
}
