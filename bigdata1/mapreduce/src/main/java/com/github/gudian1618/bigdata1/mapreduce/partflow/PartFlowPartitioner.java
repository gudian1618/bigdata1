package com.github.gudian1618.bigdata1.mapreduce.partflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 11:36 上午
 */

public class PartFlowPartitioner extends Partitioner<Text, Flow> {

    @Override
    public int getPartition(Text text, Flow flow, int i) {
        String city = flow.getCity();
        if (city.equals("beijing")) {
            return 0;
        } else if (city.equals("shanghai")) {
            return 1;
        } else {
            return 2;
        }


    }
}
