package com.example.recycleviewgallery;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    MyOnItemClickListener myOnItemClickListener;
    private List<ImageBean> images;

    public MyRecycleViewAdapter(List<ImageBean> data) {
        images = data;
    }

    public void setOnItemClickListener(MyOnItemClickListener listener) {
        myOnItemClickListener = listener;
    }

    @Override
    public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyRecycleViewAdapter.ViewHolder holder, final int position) {
        final ImageBean imageBean = images.get(position);
        holder.iv_item.setImageResource(imageBean.getImageId());
        holder.tv_item.setText(imageBean.getDescription());
        Log.d("监听外:", imageBean.toString());
        /*
         * 这里加了判断，itemViewHolder.itemView.hasOnClickListeners()
         * 目的是减少对象的创建，如果已经为view设置了click监听事件,就不用重复设置了
         * 不然每次调用onBindViewHolder方法，都会创建两个监听事件对象，增加了内存的开销
        */
        //if (!holder.itemView.hasOnClickListeners()) {  //這個場景不能加, 加了會產生錯位問題.
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("监听内:", imageBean.toString());
                    myOnItemClickListener.onItemClick(v, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    myOnItemClickListener.onItemLongClick(v, position);
                    return false;
                }
            });
        //}
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_item;
        ImageView iv_item;
//        LinearLayout item_view;

        public ViewHolder(View view) {
            super(view);
            tv_item = (TextView) view.findViewById(R.id.tv_item);
            iv_item = (ImageView) view.findViewById(R.id.iv_item);
//            item_view = (LinearLayout) view.findViewById(R.id.item_view);
        }
    }
}
