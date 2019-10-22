package com.hxh.dn_fabreveal;

import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HXH at 2019/10/21
 * 储存一系列的指令：moveTo、lineTo/cubicTo等
 */
public class AnimatorPath {
    // 一系列的指令-要有指令类
    List<PathPoint> mPathPoints = new ArrayList<>();
    private View view;

    public void moveTo(float x, float y) {
        mPathPoints.add(new PathPoint(PathPoint.MOVE, x, y));
    }

    public void lineTo(float x, float y) {
        mPathPoints.add(new PathPoint(PathPoint.LINE, x, y));
    }

    public void cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mPathPoints.add(new PathPoint(PathPoint.CUBIC, c0x, c0y, c1x, c1y, x, y));
    }

    public void startAnimation(View v, long duration) {
        view = v;
        //动起来
        // 属性动画：反射setTranslationX(xxx)方法 setAlpha(0.5f)
        // 属性动画的本质：控制一个对象身上的任务属性(setXXX())
        //ObjectAnimator animator = ObjectAnimator.ofFloat(this, "haha", 0, 100f);
        //ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationX", 0, 100f);
        // 让 x,y按照一个贝塞尔曲线公式计算-估值器
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "haha", new PathEvaluator(), mPathPoints.toArray());
        animator.setDuration(duration);
        animator.start();

    }

    public void setHaha(PathPoint p) {
        // 想要让x，y按照一个贝塞尔曲线公式计算
        view.setTranslationX(p.mX);
        view.setTranslationY(p.mY);
    }
}
