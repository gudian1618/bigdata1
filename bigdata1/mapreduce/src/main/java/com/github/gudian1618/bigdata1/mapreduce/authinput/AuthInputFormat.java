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
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.net.URI;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 7:00 下午
 * 这里的泛型表示读取出来的数据类型
 */

public class AuthInputFormat extends FileInputFormat<Text, Text> {
    @Override
    public RecordReader<Text, Text> createRecordReader(InputSplit inputSplit, TaskAttemptContext context) throws IOException, InterruptedException {
        return new AuthReader();
    }
}

class AuthReader extends RecordReader<Text, Text> {

    private LineReader reader;
    private static final byte[] blank = new Text(" ").getBytes();
    private Text key;
    private Text value;
    private float pos = 0;
    private long length;

    // 初始化方法,在初始化的时候会被调用一次,来获取实际的流用于读取数据
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException {
        // 转化
        FileSplit fileSplit = (FileSplit) inputSplit;
        // 获取切片所存储的位置
        Path path = fileSplit.getPath();
        // 获取切片大小
        length = fileSplit.getLength();
        // 连接HDFS
        FileSystem fs = FileSystem.get(URI.create(path.toString()), taskAttemptContext.getConfiguration());
        // 获取实际用于读取数据的输入流
        FSDataInputStream in = fs.open(path);
        // 获取到的输入流是一个字节流,要处理的文件是一个字符文件
        // 考虑将字节流包装成一个字符流,最好还能够按行读取
        reader = new LineReader(in);

    }

    // 判断是否有下一个键值对要交给map方法来处理
    // 试着读取文件,读取到文件为true
    @Override
    public boolean nextKeyValue() throws IOException {
        // 构建对象来存储数据
        key = new Text();
        value = new Text();
        Text tmp = new Text();
        // 读取第一行数据
        // 将读取到的数据放到tmp中
        // 返回值表示读取到的字节个数
        if (reader.readLine(tmp) <= 0) {
            return false;
        }
        key.set(tmp.toString());
        pos += tmp.getLength();
        // 读取第二行数据
        if (reader.readLine(tmp) <= 0) {
            return false;
        }
        value.set(tmp.toString());
        pos += tmp.getLength();
        // 读取第三行数据
        if (reader.readLine(tmp) <= 0) {
            return false;
        }
        value.append(blank, 0, blank.length);
        value.append(tmp.getBytes(), 0, tmp.getLength());
        pos += tmp.getLength();
        return true;
    }

    // 获取键
    @Override
    public Text getCurrentKey() {
        return key;
    }

    // 获取值
    @Override
    public Text getCurrentValue() {
        return value;
    }

    // 获取执行进度
    @Override
    public float getProgress() throws IOException, InterruptedException {
        return pos / length;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}
