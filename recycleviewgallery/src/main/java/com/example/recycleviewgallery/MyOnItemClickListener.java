package com.example.recycleviewgallery;

import android.view.View;

/**
 * Created by Administrator on 2016/8/3.
 */
public interface MyOnItemClickListener {
    abstract void onItemClick(View view, int position);

    abstract void onItemLongClick(View view, int position);
}
