package com.github.gudian1618.bigdata1.mapreduce.compress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/22 9:23 下午
 */

public class CompressDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        // 设置压缩参数
        // 开启mapper结果的压缩机制
        // conf.set("mapreduce.map.output.compress", "true");
        // 设置压缩编码类
        // conf.setClass("mapreduce.map.output.compress.codec", BZip2Codec.class, CompressionCodec.class);
        Job job = Job.getInstance(conf);

        job.setJarByClass(CompressDriver.class);
        // 如果输入的多个文件的处理方式一直,可以统一设置Mapper
        job.setMapperClass(CompressMapper.class);
        job.setReducerClass(CompressReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 多源输入
        MultipleInputs.addInputPath(job, new Path("hdfs://192.168.1.200:9000/txt/words.txt"), TextInputFormat.class);

        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.200:9000/result/compress"));

        // 对Reduce结果进行压缩
        FileOutputFormat.setCompressOutput(job,true);
        FileOutputFormat.setOutputCompressorClass(job, BZip2Codec.class);
        // FileOutputFormat.setOutputCompressorClass(job, DefaultCodec.class);
        // FileOutputFormat.setOutputCompressorClass(job, ZStandardCodec.class);

        job.waitForCompletion(true);
    }

}
