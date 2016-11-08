package com.somnus.toolbar.androidcollapsingtoolbarlayout.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.somnus.mylib.recycleutils.utils.DividerItemDecoration;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.R;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.RecyclerViewActivity;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter.RecyclerViewListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView_fragment_01;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<String> mDatas;


    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        recyclerView_fragment_01 = (RecyclerView) v.findViewById(R.id.recyclerView_fragment_01);
        initData();
        return v;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
        RecyclerViewListAdapter mRecylerViewAdapter = new RecyclerViewListAdapter(getActivity(), mDatas);
        recyclerView_fragment_01.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置listView普通样式的 分割线 （分割线需要自己写 DividerItemDecoration ）
        recyclerView_fragment_01.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        recyclerView_fragment_01.setAdapter(mRecylerViewAdapter);

        mRecylerViewAdapter.setmOnItemClickLitener(new RecyclerViewListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }


}
