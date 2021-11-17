package com.github.gudian1618.bigdata1.mapreduce.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 1:47 下午
 */

public class WordCountDriver {

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);


    }

}
