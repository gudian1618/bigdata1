package com.github.gudian1618.bigdata1.mapreduce.charcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/16 8:05 下午
 */

public class CharCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 构建环境变量
        Configuration conf = new Configuration();
        conf.set("mapred.job.tracker", "root");
        conf.set("fs.defaultFS", "hdfs://192.168.1.200:9000");
        // 构建任务
        Job job = Job.getInstance(conf);
        // 设置入口类
        job.setJarByClass(CharCountDriver.class);
        // 设置Mapper类
        job.setMapperClass(CharCountMapper.class);
        // 设置Reduce类
        job.setReducerClass(CharCountReducer.class);

        // 设置mapper的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 设置reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 设置输入路径
        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/characters.txt"));
        // 设置输出路径 - 要求输出路径必须不存在
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.1.200:9000/result/char_count"));

        // 提交任务
        job.waitForCompletion(true);
    }

}
