package com.github.gudian1618.bigdata1.mapreduce.sortprofit;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 1:57 下午
 */

public class SortProfitReducer extends Reducer<Profit, NullWritable, Text, Text> {
    @Override
    protected void reduce(Profit key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(new Text(key.getName()), new Text(key.getMonth() + "\t" + key.getProfit()));
    }
}
