package com.github.gudian1618.bigdata1.mapreduce.serialflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 7:15 下午
 */

public class SerialFlowMapper extends Mapper<LongWritable, Text, Text, Flow> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 拆分字段
        String[] arr = value.toString().split(" ");

        // 13012945687 beijing helen 4152 5321
        // 封装对象
        Flow f = new Flow();
        f.setUpFlow(Integer.parseInt(arr[3]));
        f.setDownFlow(Integer.parseInt(arr[4]));
        context.write(new Text(arr[2]), f);
    }
}
