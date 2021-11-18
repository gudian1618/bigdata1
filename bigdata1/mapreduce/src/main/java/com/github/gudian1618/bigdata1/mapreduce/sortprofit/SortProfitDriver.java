package com.github.gudian1618.bigdata1.mapreduce.sortprofit;

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
 * @date 2021/11/18 1:59 下午
 */

public class SortProfitDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SortProfitDriver.class);
        job.setMapperClass(SortProfitMapper.class);
        job.setReducerClass(SortProfitReducer.class);

        // 因为mapper和reducer数据类型不一致,必须分开写
        job.setMapOutputKeyClass(Profit.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/profit.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/sort_profit"));

        job.waitForCompletion(true);
    }

}
