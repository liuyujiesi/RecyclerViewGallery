package com.example.recycleviewgallery;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.widget.RecyclerView.OnScrollListener;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by Administrator on 2016/8/4.
 */
//代码没什么变化~多了个设置回调~
public class MyRecycleView extends RecyclerView {
    View mCurrentView;

    private OnItemScrollingListener mOnItemScrollingListener;

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        View newView = getChildAt(0);
        if (mOnItemScrollingListener != null) {
            //滚动时，判断当前第一个View是否发生变化，发生才回调
            //放弃了重写onTouchEvent方法，而是让这个类实现RecyclerView.OnScrollListener接口，然后设置监听，在onScrolled里面进行判断。
            if (newView != null && newView != mCurrentView) {
                mCurrentView = newView;
                mOnItemScrollingListener.onChange(mCurrentView,
                        getChildPosition(mCurrentView));
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mOnItemScrollingListener != null) {
            mOnItemScrollingListener.onChange(mCurrentView, getChildPosition(mCurrentView));
        }
    }

    public void setOnItemScrollingListener(OnItemScrollingListener listener) {
        this.mOnItemScrollingListener = listener;
    }

    //直接在ACTION_MOVE中回调，触发的频率太高了，理论上一张图片只会触发一次.下面有onScrollListener实现.
//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//        if (e.getAction() == MotionEvent.ACTION_MOVE) {
//            mCurrentView = getChildAt(0);
//            // Log.e("TAG", getChildPosition(getChildAt(0)) + "");
//            if (mOnItemScrollingListener != null) {
//                mOnItemScrollingListener.onChange(mCurrentView,
//                        getChildPosition(mCurrentView));
//            }
//        }
//        return super.onTouchEvent(e);
//    }

    public interface OnItemScrollingListener {
        void onChange(View view, int position);
    }
}
