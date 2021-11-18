package com.github.gudian1618.bigdata1.mapreduce.partflow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 10:08 上午
 */

public class Flow implements Writable {

    private String city;
    private int upFlow;
    private int downFlow;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getCity());
        dataOutput.writeInt(getUpFlow());
        dataOutput.writeInt(getDownFlow());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setCity(dataInput.readUTF());
        setUpFlow(dataInput.readInt());
        setDownFlow(dataInput.readInt());
    }
}
