package com.example.recycleviewgallery;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    List<ImageBean> images = new ArrayList<ImageBean>();
    @Bind(R.id.image_view)
    ImageView imageView;
//    @Bind(R.id.recycle_view)
//    RecyclerView mRecyclerView;
    @Bind(R.id.recycle_view)
    MyRecycleView mRecyclerView;
    private MyRecycleViewAdapter myRecycleViewAdapter;
    private ImageBean imageBean;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyRecycleView.OnItemScrollingListener onItemScrollingListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        myRecycleViewAdapter = new MyRecycleViewAdapter(images);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(myRecycleViewAdapter);
        myRecycleViewAdapter.setOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                imageBean = images.get(position);
                imageView.setImageResource(imageBean.getImageId());
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Snackbar.make(view, "您长按了第" + position + "个", Snackbar.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setOnItemScrollingListener(new MyRecycleView.OnItemScrollingListener() {
            @Override
            public void onChange(View view, int position) {
                imageBean = images.get(position);
                imageView.setImageResource(imageBean.getImageId());
            }
        });
    }

    public void initData() {
        if (!(images.size()>0)) {
            images.add(new ImageBean(R.drawable.ic_1, "hello1"));
            images.add(new ImageBean(R.drawable.ic_2, "hello2"));
            images.add(new ImageBean(R.drawable.ic3, "hello3"));
            images.add(new ImageBean(R.drawable.ic_4, "hello4"));
            images.add(new ImageBean(R.drawable.ic_5, "hello5"));
            images.add(new ImageBean(R.drawable.ic_6, "hello6"));
            images.add(new ImageBean(R.drawable.ic_7, "hello7"));
            images.add(new ImageBean(R.drawable.ic_8, "hello8"));
            images.add(new ImageBean(R.drawable.ic_9, "hello9"));
            images.add(new ImageBean(R.drawable.ic_1, "hello10"));
            images.add(new ImageBean(R.drawable.ic_2, "hello11"));
            images.add(new ImageBean(R.drawable.ic3, "hello12"));
            images.add(new ImageBean(R.drawable.ic_4, "hello13"));
            images.add(new ImageBean(R.drawable.ic_5, "hello14"));
            images.add(new ImageBean(R.drawable.ic_6, "hello15"));
            images.add(new ImageBean(R.drawable.ic_7, "hello16"));
            images.add(new ImageBean(R.drawable.ic_1, "hello17"));
            images.add(new ImageBean(R.drawable.ic_2, "hello18"));
            images.add(new ImageBean(R.drawable.ic3, "hello19"));
            images.add(new ImageBean(R.drawable.ic_4, "hello20"));
            images.add(new ImageBean(R.drawable.ic_5, "hello21"));
            images.add(new ImageBean(R.drawable.ic_6, "hello22"));
            images.add(new ImageBean(R.drawable.ic_7, "hello23"));
            images.add(new ImageBean(R.drawable.ic_8, "hello24"));
            images.add(new ImageBean(R.drawable.ic_9, "hello25"));
            images.add(new ImageBean(R.drawable.ic_1, "hello26"));
            images.add(new ImageBean(R.drawable.ic_2, "hello27"));
            images.add(new ImageBean(R.drawable.ic3, "hello28"));
            images.add(new ImageBean(R.drawable.ic_4, "hello29"));
            images.add(new ImageBean(R.drawable.ic_5, "hello30"));
            images.add(new ImageBean(R.drawable.ic_6, "hello31"));
            images.add(new ImageBean(R.drawable.ic_7, "hello32"));
        }
    }
}
