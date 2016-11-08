package com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter;

import android.content.Context;

import com.somnus.mylib.recycleutils.recycleadapter.BaseQuickAdapter;
import com.somnus.mylib.recycleutils.recycleadapter.BaseViewHolder;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.R;

/**
 * Created by cc on 2016/4/12.
 */
public class Fragment2BaseAdapter extends BaseQuickAdapter<String> {

    public Fragment2BaseAdapter(Context context) {
        super(context, R.layout.item_fragment2_layout);
    }



    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.listview_detail_one_tv, item + helper.getAdapterPosition());
    }
}
