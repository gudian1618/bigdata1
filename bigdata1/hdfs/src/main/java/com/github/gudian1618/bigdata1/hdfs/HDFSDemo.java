package com.github.gudian1618.bigdata1.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/15 6:37 下午
 * HDFS的api流程练习
 */

public class HDFSDemo {

    // 创建环境变量
    private final URI uri = URI.create("hdfs://192.168.1.200:9000");
    private final Configuration conf = new Configuration();

    // 创建一个目录
    @Test
    public void mkdir() throws IOException, InterruptedException {
        // 连接文件系统
        FileSystem fs = FileSystem.get(uri, conf, "root");
        // 创建目录
        fs.mkdirs(new Path("/txt"));
        // 关闭资源
        fs.close();
    }

    // 上传文件
    @Test
    public void put() throws IOException, InterruptedException {
        // 连接文件系统
        FileSystem fs = FileSystem.get(uri, conf, "root");
        // 指定存储路径 - 返回输出流用于将数据写入
        FSDataOutputStream out = fs.create(new Path("/txt/a.xml"));
        // 构建输入流,指定要上传的文件
        FileInputStream in = new FileInputStream("/Users/zyd/Desktop/达内大数据学习/大数据高级开发工程师-课程资料及笔记/03-Hadoop/hadoop/tar/pom.xml");
        // 上传文件
        IOUtils.copyBytes(in, out, conf);
        // 关闭流
        in.close();
        out.close();
        fs.close();
    }

    // 下载文件
    @Test
    public void get() throws IOException {
        // 连接文件系统
        FileSystem fs = FileSystem.get(uri, conf);
        // 指定要下载的文件,获取输入流用于读取数据
        FSDataInputStream in = fs.open(new Path("/txt/a.xml"));
        // 构建一个输出流,用于将读取到的数据写出
        FileOutputStream out = new FileOutputStream("/Users/zyd/Desktop/b.xml");
        // 下载文件方法操作
        IOUtils.copyBytes(in, out, conf);
        // 关闭资源流
        in.close();
        out.close();
        fs.close();
    }

    // 删除文件
    @Test
    public void delete() {

    }


}
