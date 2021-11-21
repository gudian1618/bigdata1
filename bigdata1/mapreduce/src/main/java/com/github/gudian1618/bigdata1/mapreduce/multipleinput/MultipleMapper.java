package com.github.gudian1618.bigdata1.mapreduce.multipleinput;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/21 10:05 上午
 */

public class MultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final IntWritable once = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取到一行数据之后都需要拆分字母
        char[] cs = value.toString().toCharArray();
        for (char c : cs) {
            context.write(new Text(c + ""), once);
        }
    }
}
