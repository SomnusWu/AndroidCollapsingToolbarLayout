package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.somnus.mylib.recycleutils.utils.DividerGridItemDecoration;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter.RecyclerViewListAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private Toolbar toolbar_tab_layout_fragment;
    private RecyclerView recyclerView_list;
    private RecyclerViewListAdapter mRecylerViewAdapter;
    private List<String> mDatas;

    private TextView resultCountTv;
    boolean isDispaly = false;

    @TargetApi(Build.VERSION_CODES.M)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);

        resultCountTv = (TextView) findViewById(R.id.resultCountTv);
        onAction();
        toolbar_tab_layout_fragment = (Toolbar) findViewById(R.id.toolbar_tab_layout_fragment);
        setSupportActionBar(toolbar_tab_layout_fragment);

        //  给左上角图标的左边加上一个返回的
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_tab_layout_fragment.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData();
        recyclerView_list = (RecyclerView) findViewById(R.id.recyclerView_list);
        // 设置item增加和删除时的动画
        recyclerView_list.setItemAnimator(new DefaultItemAnimator());
        mRecylerViewAdapter = new RecyclerViewListAdapter(this, mDatas);
        //设置布局管理器
        /**
         * LinearLayoutManager 现行管理器，支持横向、纵向。
         * GridLayoutManager 网格布局管理器
         * StaggeredGridLayoutManager 瀑布就式布局管理器
         */
        //#if false
        //1:普通列表方式
//        recyclerView_list.setLayoutManager(new LinearLayoutManager(this));
        // 设置listView普通样式的 分割线 （分割线需要自己写 DividerItemDecoration ）
//        recyclerView_list.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST));

        /***
         //2:Grid方式
         recyclerView_list.setLayoutManager(new GridLayoutManager(this, 4));
         //设置Grid样式分割线 （DividerGridItemDecoration）
         recyclerView_list.addItemDecoration(new DividerGridItemDecoration(this));
         ****/
        //#end if

        //3:瀑布流样式 StaggeredGridLayoutManager
        /**
         * 注意StaggeredGridLayoutManager构造的第二个参数传一个orientation，
         * 如果传入的是StaggeredGridLayoutManager.VERTICAL代表有多少列；
         * 那么传入的如果是StaggeredGridLayoutManager.HORIZONTAL就代表有多少行
         */
        //a:水平滚动的列表
        recyclerView_list.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recyclerView_list.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView_list.setAdapter(mRecylerViewAdapter);

        /**
         * 瀑布流
         */
        //  仅仅在适配器的onBindViewHolder方法中为我们的item设置个随机的高度

//        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//        int _height = (int) (200 + Math.random() * 400);
//        params.height = _height;
//        holder.itemView.setLayoutParams(params);


        /**
         * 给recyclerView设置点击事件  (需要自己写）
         */

        mRecylerViewAdapter.setmOnItemClickLitener(new RecyclerViewListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + "long click",
                        Toast.LENGTH_SHORT).show();
            }
        });


//        recyclerView_list.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
////                Log.d("scrollx",scrollX+"");
////                Log.d("scrolly",scrollY+"");
////                Log.d("scrolloldx",oldScrollX+"");
////                Log.d("scrolloldy",oldScrollY+"");
//            }
//        });

        recyclerView_list.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("scrollx", dx + "");
                Log.d("scrolly", dy + "");

                if (!isDispaly && dy > 0 ) {
                    Animation anim_down = AnimationUtils.loadAnimation(RecyclerViewActivity.this, R.anim.down_show);
                    anim_down.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            resultCountTv.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
//                            resultCountTv.setVisibility(View.GONE);
                            isDispaly = true;
                            resultCountTv.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    resultCountTv.startAnimation(anim_down);
                }

            }
        });
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_toolbar_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Toast.makeText(this, "点击了item1", Toast.LENGTH_SHORT).show();
                mRecylerViewAdapter.addData(1);
                break;
            case R.id.action_delete:
                Toast.makeText(this, "点击了item2", Toast.LENGTH_SHORT).show();
                mRecylerViewAdapter.removeData(1);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * 注意，这里更新数据集不是用adapter.notifyDataSetChanged()而是
     * notifyItemInserted(position)与notifyItemRemoved(position)
     */


    public void onAction() {
        Animation anim_up = AnimationUtils.loadAnimation(this, R.anim.up_hide);
        anim_up.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub
                resultCountTv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                // TODO Auto-generated method stub
                resultCountTv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Animation anim_down = AnimationUtils.loadAnimation(RecyclerViewActivity.this, R.anim.down_show);
                        resultCountTv.startAnimation(anim_down);
                        resultCountTv.setVisibility(View.GONE);
                    }
                }, 3000);

            }
        });
        resultCountTv.startAnimation(anim_up);
    }

}
