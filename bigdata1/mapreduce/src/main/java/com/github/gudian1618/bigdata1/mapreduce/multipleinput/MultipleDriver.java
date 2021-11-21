package com.github.gudian1618.bigdata1.mapreduce.multipleinput;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/21 10:13 上午
 */

public class MultipleDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MultipleDriver.class);
        // 如果输入的多个文件的处理方式一直,可以统一设置Mapper
        job.setMapperClass(MultipleMapper.class);
        job.setReducerClass(MultipleReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 多源输入
        MultipleInputs.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/words.txt"), TextInputFormat.class);
        MultipleInputs.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/characters.txt"), TextInputFormat.class);

        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/multiple_inputs"));

        job.waitForCompletion(true);
    }

}
