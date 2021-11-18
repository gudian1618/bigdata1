package com.github.gudian1618.bigdata1.mapreduce.sorfflow;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 11:55 上午
 */

public class Flow implements WritableComparable<Flow> {

    private String name = "";
    private int upFlow;
    private int downFlow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // 按照下行流量进行升序排序
    @Override
    public int compareTo(Flow o) {
        return this.getDownFlow() - o.getDownFlow();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getName());
        dataOutput.writeInt(getUpFlow());
        dataOutput.writeInt(getDownFlow());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setName(dataInput.readUTF());
        setUpFlow(dataInput.readInt());
        setDownFlow(dataInput.readInt());
    }

    @Override
    public String toString() {
        return "Flow{" +
            "name='" + name + '\'' +
            ", upFlow=" + upFlow +
            ", downFlow=" + downFlow +
            '}';
    }
}

