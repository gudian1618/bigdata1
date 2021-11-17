package com.github.gudian1618.bigdata1.mapreduce.serialflow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 7:32 下午
 */

public class SerialFlowDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SerialFlowDriver.class);
        job.setMapperClass(SerialFlowMapper.class);
        job.setReducerClass(SerialFlowReducer.class);

        // 因为mapper和reducer数据类型不一致,必须分开写
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Flow.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/flow.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/flow_count"));

        job.waitForCompletion(true);

    }

}
