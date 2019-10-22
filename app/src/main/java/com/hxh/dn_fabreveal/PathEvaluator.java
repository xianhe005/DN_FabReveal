package com.hxh.dn_fabreveal;

import android.animation.TypeEvaluator;

/**
 * Created by HXH at 2019/10/21
 * 估值器
 */
public class PathEvaluator implements TypeEvaluator<PathPoint> {

    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x, y;
        // 分情况计算公式
        if (endValue.mOperation == PathPoint.CUBIC) {// 贝塞尔曲线公式计算
            float ot = 1 - t;
            x = startValue.mX * ot * ot * ot
                    + 3 * startValue.mControl0X * t * ot * ot
                    + 3 * startValue.mControl1X * t * t * ot
                    + endValue.mX * t * t * t;
            y = startValue.mY * ot * ot * ot
                    + 3 * startValue.mControl0Y * t * ot * ot
                    + 3 * startValue.mControl1Y * t * t * ot
                    + endValue.mY * t * t * t;
        } else if (endValue.mOperation == PathPoint.LINE) {
            //线性运动-线性计算
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
            return new PathPoint(PathPoint.MOVE, x, y);
        } else {
            x = endValue.mX;
            y = endValue.mY;
        }
        return new PathPoint(PathPoint.MOVE, x, y);
    }
}
