package com.hxh.dn_fabreveal;

/**
 * Created by HXH at 2019/10/21
 * 指令路径
 */
public class PathPoint {
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CUBIC = 2;

    // 1.指令类型
    int mOperation;

    // 2.坐标
    float mX, mY;
    float mControl0X, mControl0Y, mControl1X, mControl1Y;

    public PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    public PathPoint(int operation, float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
        mControl0X = c0x;
        mControl0Y = c0y;
        mControl1X = c1x;
        mControl1Y = c1y;
    }
}
