package com.github.gudian1618.bigdata1.mapreduce.join;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/23 10:43 上午
 */

public class Order implements Writable {

    private String productId = "";
    private int num;
    private double price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getProductId());
        dataOutput.writeInt(getNum());
        dataOutput.writeDouble(getPrice());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setProductId(dataInput.readUTF());
        setNum(dataInput.readInt());
        setPrice(dataInput.readDouble());
    }
}
