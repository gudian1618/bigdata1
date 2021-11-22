package com.github.gudian1618.bigdata1.mapreduce.compress;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/22 9:07 下午
 */

public class CompressMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    private final IntWritable once = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        for (String s : arr) {
            context.write(new Text(s), once);
        }
    }
}
