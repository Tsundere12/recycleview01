package com.example.mywork;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    private static final String TAG =MainActivity.class.getSimpleName();
    private List<String>list=new ArrayList<>();

    private Fragment mTab01=new weixinFragment();
    private Fragment mTab02=new lianxirenFragment();
    private Fragment mTab03=new pengyouquanFragment();
    private Fragment mTab04=new shezhiFragment();

    private FragmentManager fm;

    LinearLayout mTabWechat;
    LinearLayout mTabFriend;
    LinearLayout mTabContact;
    LinearLayout mTabSettings;

    ImageButton mimgWechat;
    ImageButton mimgFriend;
    ImageButton mimgContact;
    ImageButton mimgSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        initView();
        initEvent();
        initFragment();
        selectfragment(0);


    }
    private void initEvent(){
        mTabWechat.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }
    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }
    private void initView(){
        mTabWechat=findViewById(R.id.LinearLayout_weixin);
        mTabFriend = findViewById(R.id.LinearLayout_lianxiren);
        mTabContact = findViewById(R.id.LinearLayout_pengyouquan);
        mTabSettings = findViewById(R.id.LinearLayout_shezhi);

        mimgWechat = findViewById(R.id.id_tab_wechat_image);
        mimgFriend = findViewById(R.id.id_tab_friend_image);
        mimgContact = findViewById(R.id.id_tab_contact_image);
        mimgSettings = findViewById(R.id.id_tab_settings_image);
    }
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }
    private void resetImgs(){
        mimgWechat.setImageResource(R.drawable.p1);
        mimgFriend.setImageResource(R.drawable.p2);
        mimgContact.setImageResource(R.drawable.p3);
        mimgSettings.setImageResource(R.drawable.p4);
    }
    private void selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                mimgWechat.setImageResource(R.drawable.p1_press);
                break;
            case 1:
                transaction.show(mTab02);
                mimgFriend.setImageResource(R.drawable.p2_press);
                break;
            case 2:
                transaction.show(mTab03);
                mimgContact.setImageResource(R.drawable.p3_press);
                break;
            case 3:
                transaction.show(mTab04);
                mimgSettings.setImageResource(R.drawable.p4_press);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    @SuppressLint("NonConstantResourceId")
    public void onClick(View v){
        resetImgs();
        switch (v.getId()){
            case R.id.LinearLayout_weixin:
                selectfragment(0);
                break;
            case R.id.LinearLayout_lianxiren:
                selectfragment(1);
                break;
            case R.id.LinearLayout_pengyouquan:
                selectfragment(2);
                break;
            case R.id.LinearLayout_shezhi:
                selectfragment(3);
                break;

        }
    }
}


