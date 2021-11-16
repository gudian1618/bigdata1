package com.github.gudian1618.bigdata1.mapreduce.charcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/16 5:54 下午
 * 用于完成map计算阶段
 * 在mapreduce中,要求被处理的数据能够被序列化
 * KEYIN - 输入的键类型,如果不指定,默认的情况下,表示行的字节偏移量
 * VALUEIN - 输入的值类型,默认表示取到的一行数据
 * KEYOUT - 输出的键的类型,当前例子,输出的键表示的是字符
 * VALUEOUT - 输出的值的类型,当前案例,输出的值表示的是次数
 */

public class CharCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    private final LongWritable once = new LongWritable(1);

    // 覆盖map方法,将处理逻辑写到这个方法当中
    // key: 行的字节偏移量
    // value: 表示读取到的一行数据
    // context: 配置参数
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 将一行数据中的字符拆分出来
        char[] cs = value.toString().toCharArray();
        // 假设数据是hello,那么拆分出来的数据中包含的就是{'h','e','l','l','o'}
        // 可以写出多种格式形式
        for (char c : cs) {
            context.write(new Text(c + ""), once);
        }
    }
}
