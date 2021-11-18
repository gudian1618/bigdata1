package com.github.gudian1618.bigdata1.mapreduce.sortprofit;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/18 1:40 下午
 */

public class Profit implements WritableComparable<Profit> {

    private int month;
    private String name = "";
    private int profit;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    // 先按照月份进行升序排序,同一个月中,按照利润进行降序排序
    @Override
    public int compareTo(Profit o) {
        int r = getMonth() - o.getMonth();
        if (r == 0) {
            return o.getProfit() - this.getProfit();
        }
        return r;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(getMonth());
        dataOutput.writeUTF(getName());
        dataOutput.writeInt(getProfit());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setMonth(dataInput.readInt());
        setName(dataInput.readUTF());
        setProfit(dataInput.readInt());
    }
}
