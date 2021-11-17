package com.github.gudian1618.bigdata1.mapreduce.ip;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 6:34 下午
 */

public class IPDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(IPDriver.class);
        job.setMapperClass(IPMapper.class);
        job.setReducerClass(IPReducer.class);

        // 如果Mapper和Reducer的输出类型一致，那么可以只设置一次
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/ip.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/ip_count"));

        job.waitForCompletion(true);
    }

}
