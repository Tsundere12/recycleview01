package com.example.mywork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class pengyouquanFragment extends Fragment {

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;

//    public static weixinFragment newInstance(String param1, String param2) {
//        weixinFragment fragment = new weixinFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
private RecyclerView recyclerView;
    private List<String> mList = new ArrayList<>();
    private Context context;
    private VerticalAdapter adapter;
    public pengyouquanFragment() {
        // Required empty public constructor
    }
    private void initData() {
        mList.add("欧米伽--全自动冲锋枪");
        mList.add("圆舞曲--全自动冲锋枪");
        mList.add("警卫兵--全自动冲锋枪");
        mList.add("阿尔法--全自动冲锋枪");
        mList.add("蜂鸟--全自动双持冲锋枪");
        mList.add("自由先锋--全自动步枪");
        mList.add("三角洲--全自动步枪");
        mList.add("火线冲突--三连发步枪");
        mList.add("天空之子--全自动步枪");
        mList.add("龙骑士--全自动步枪");
        mList.add("无名旅者--稀有全自动步枪");
        mList.add("星际中尉--全自动步枪");
        mList.add("火烈鸟--单发狙击枪");
        mList.add("冷酷核心--单发狙击枪");
        mList.add("终级制裁--稀有单发狙击枪");
        mList.add("空灵柩--半自动狙击枪");
        mList.add("女武神--稀有半自动狙击枪");
        mList.add("狂鲨--半自动霰弹手炮");
        mList.add("虎鲸--半自动手炮");
        mList.add("南丁格尔--治疗手炮");
        mList.add("震荡波--全自动手炮");
        mList.add("万有引力--电弧手炮");
        mList.add("绝对零度--冰冻重武器");
        mList.add("火流星--榴弹重武器");
        mList.add("毁灭者--电磁弹重武器");

    }

    private void initView_1() {
        context=this.getActivity();
        VerticalAdapter adapter = new VerticalAdapter(context);
        RecyclerView rcvVertical = recyclerView.findViewById(R.id.rcv_vertical);
        LinearLayoutManager managerVertical = new LinearLayoutManager(context);
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        rcvVertical.setLayoutManager(managerVertical);
        rcvVertical.setHasFixedSize(true);
        rcvVertical.setAdapter(adapter);
        adapter.setVerticalDataList(mList);
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pengyouquan, container, false);
        recyclerView=view.findViewById(R.id.rcv_vertical);
        initData();
        initView_1();

        return view;
    }
}