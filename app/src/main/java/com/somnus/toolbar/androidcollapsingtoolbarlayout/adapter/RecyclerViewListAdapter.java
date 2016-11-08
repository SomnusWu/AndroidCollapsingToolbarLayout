package com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.somnus.toolbar.androidcollapsingtoolbarlayout.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by cc on 2016/4/7.
 */

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.RecyclerViewListHodler> {
    private Context mContext;
    private List<String> mlist;
    private List<Integer> lists;

    public RecyclerViewListAdapter(Context mContext, List<String> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
        getRandomHeights(mlist);
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    private OnItemClickLitener mOnItemClickLitener;

    private void getRandomHeights(List<String> datas) {
        lists = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            lists.add((int) (200 + Math.random() * 400));
        }
    }

    /**
     * 添加 数据
     * **/
    public void addData(int position) {
        mlist.add(position, "Insert One");
        lists.add(position,(int) (200 + Math.random() * 400));
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mlist.remove(position);
        lists.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerViewListHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_list, parent, false);
        RecyclerViewListHodler holder = new RecyclerViewListHodler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewListHodler holder, final int position) {

        /*
            设置瀑布流的样式 修改布局
         */
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        int _height = lists.get(position);
        params.height = _height;
        holder.itemView.setLayoutParams(params);


        String text = mlist.get(position);
        holder.tv_label.setText(text);
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class RecyclerViewListHodler extends ViewHolder {
        private TextView tv_label;

        public RecyclerViewListHodler(View itemView) {
            super(itemView);
            tv_label = (TextView) itemView.findViewById(R.id.id_num);
        }
    }

}
