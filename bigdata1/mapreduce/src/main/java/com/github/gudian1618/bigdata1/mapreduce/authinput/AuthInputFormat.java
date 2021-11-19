package com.github.gudian1618.bigdata1.mapreduce.authinput;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.net.URI;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 7:00 下午
 * 这里的泛型表示读取出来的数据类型
 */

public class AuthInputFormat extends FileInputFormat<Text,Text> {
    @Override
    public RecordReader<Text, Text> createRecordReader(InputSplit inputSplit, TaskAttemptContext context) throws IOException, InterruptedException {
        return new AuthReader();
    }
}

class AuthReader extends RecordReader<Text, Text> {

    // 初始化方法,在初始化的时候会被调用一次,来获取实际的流用于读取数据
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        // 转化
        FileSplit fileSplit = (FileSplit) inputSplit;
        // 获取切片所存储的位置
        Path path = fileSplit.getPath();
        // 获取切片大小
        long length = fileSplit.getLength();
        // 连接HDFS
        FileSystem fs = FileSystem.get(URI.create(path.toString()), taskAttemptContext.getConfiguration());
        // 获取实际用于读取数据的输入流
        FSDataInputStream in = fs.open(path);
        // 获取到的输入流是一个字节流,要处理的文件是一个字符文件

    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        return false;
    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return null;
    }

    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        return null;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
