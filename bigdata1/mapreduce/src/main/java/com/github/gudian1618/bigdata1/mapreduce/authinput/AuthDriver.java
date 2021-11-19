package com.github.gudian1618.bigdata1.mapreduce.authinput;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/19 7:56 下午
 */

public class AuthDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 构建环境变量
        Configuration conf = new Configuration();
        // 构建任务
        Job job = Job.getInstance(conf);
        // 设置入口类
        job.setJarByClass(AuthDriver.class);
        // 设置Mapper类
        job.setMapperClass(AuthMapper.class);
        // 设置Reduce类
        job.setReducerClass(AuthReducer.class);

        // 设置mapper的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 指定输入格式类
        job.setInputFormatClass(AuthInputFormat.class);

        // 设置输入路径
        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/score.txt"));
        // 设置输出路径 - 要求输出路径必须不存在
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.1.200:9000/result/auth_input"));

        // 提交任务
        job.waitForCompletion(true);
    }

}
