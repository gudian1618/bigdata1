package com.github.gudian1618.bigdata1.mapreduce.serialflow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/17 7:13 下午
 */

public class Flow implements Writable {

    private int upFlow;
    private int downFlow;

    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }

    // 需要将有必要的属性依次序列化写出即可
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(getUpFlow());
        dataOutput.writeInt(getDownFlow());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setUpFlow(dataInput.readInt());
        setDownFlow(dataInput.readInt());
    }
}
