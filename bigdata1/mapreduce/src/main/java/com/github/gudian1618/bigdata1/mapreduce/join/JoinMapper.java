package com.github.gudian1618.bigdata1.mapreduce.join;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/23 10:43 上午
 */

public class JoinMapper extends Mapper<LongWritable, Text, Text, Order> {

    private final Map<String, Order> map = new ConcurrentHashMap<>();

    @Override

    protected void setup(Context context) throws IOException {
        // 获取文件路径
        URI file = context.getCacheFiles()[0];
        // 连接hdfs
        FileSystem fs = FileSystem.get(file, context.getConfiguration());
        // 获取输入流
        FSDataInputStream in = fs.open(new Path(file.toString()));
        // 获取到的输入流是一个字节流,要处理的问价你是一个字符流,考虑将字节流转换成字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            // 拆分字段
            String[] arr = line.split(" ");
            Order o = new Order();
            o.setProductId(arr[0]);
            o.setPrice(Double.parseDouble(arr[2]));
            map.put(o.getProductId(), o);
        }
        reader.close();
    }

    // 处理主要文件 - order.txt
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1001 20170710 4 2
        String[] arr = value.toString().split(" ");
        Order o = new Order();
        o.setProductId(arr[2]);
        o.setNum(Integer.parseInt(arr[3]));
        o.setPrice(map.get(o.getProductId()).getPrice());
        context.write(new Text(arr[1]), o);
    }
}
