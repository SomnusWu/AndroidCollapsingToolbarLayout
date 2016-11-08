package com.somnus.toolbar.androidcollapsingtoolbarlayout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.somnus.mylib.recycleutils.recycleadapter.BaseQuickAdapter;
import com.somnus.mylib.recycleutils.utils.DividerItemDecoration;
import com.somnus.mylib.recycleutils.utils.ToastUtils;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.R;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter.Fragment2BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView mRecyclerView;
    private List<String> mlist;
    private Fragment2BaseAdapter mFragmentAdapter;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("ss", "sss");
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment_02);
        mlist = new ArrayList<String>();
        initData();
        Log.d("ss", mlist.size() + "------");
        mFragmentAdapter = new Fragment2BaseAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置listView普通样式的 分割线 （分割线需要自己写 DividerItemDecoration ）
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
//                DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mFragmentAdapter);
        mFragmentAdapter.addAll(mlist);
//        mFragmentAdapter.openLoadAnimation();
        mFragmentAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mFragmentAdapter.setFirstOnly(false);

        mFragmentAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView content = (TextView) view.findViewById(R.id.listview_detail_one_tv);
                ToastUtils.showToast(getActivity(),content.getText().toString());
            }
        });

    }

    //输入itar按tab, 使用模板for循环，其他模板参照 File | Settings | Live Templates
    private void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mlist.add("" + (char) i);
        }

    }
}
