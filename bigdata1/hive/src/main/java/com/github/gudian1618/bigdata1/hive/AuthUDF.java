package com.github.gudian1618.bigdata1.hive;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2022/3/15 11:27 PM
 * 需求:
 * 传入两个字符创,获取字串在原串中第一次出现的下标
 */

public class AuthUDF extends GenericUDF {
    // 初始化
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        return null;
    }

    // Hive调用函数的功能的时候,就是调用这个方法
    // 函数要执行的逻辑需要覆盖这个方法中
    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        return null;
    }

    @Override
    public String getDisplayString(String[] strings) {
        return null;
    }
}
