package com.github.gudian1618.bigdata1.mapreduce.sorfflow;

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
 * @date 2021/11/18 12:56 下午
 */

public class SortFlowDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SortFlowDriver.class);
        job.setMapperClass(SortFlowMapper.class);
        job.setReducerClass(SortFlowReducer.class);

        job.setMapOutputKeyClass(Flow.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 输入是目录，那么会处理这个目录下的所有的文件
        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/result/serial_flow/"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/sort_flow"));

        job.waitForCompletion(true);
    }

}
