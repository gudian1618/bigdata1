package com.github.gudian1618.bigdata1.mapreduce.authinput;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/19 7:51 下午
 */

public class AuthMapper extends Mapper<Text, Text, Text, IntWritable> {

    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        // 拆分数据
        String[] arr = value.toString().split(" ");
        context.write(key, new IntWritable(Integer.parseInt(arr[1])));
        context.write(key, new IntWritable(Integer.parseInt(arr[3])));
    }
}
