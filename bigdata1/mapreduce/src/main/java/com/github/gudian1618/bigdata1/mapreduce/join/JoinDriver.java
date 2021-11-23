package com.github.gudian1618.bigdata1.mapreduce.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/23 10:05 上午
 */

public class JoinDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(JoinDriver.class);
        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Order.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 确定主要处理文件 - 统计每一天卖了多少钱 - 键是日期,值是钱
        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/order.txt"));
        // 将关联文件的路径放到缓存中,需要使用的时候再从缓存中取出来处理即可
        URI[] files = {URI.create("hdfs://192.168.1.200:9000/txt/product.txt")};
        job.setCacheFiles(files);
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/join"));

        job.waitForCompletion(true);
    }

}
