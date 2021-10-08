package com.example.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //枪械名字
    private TextView Q_name;
    //枪械信息
    private  TextView Q_info;
    //
    private ImageView Q_view;
    //返回上一页
    private TextView B_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        setListeners();
    }

    private void init() {
        Q_name=(TextView) findViewById(R.id.Q_name);
        Q_info=(TextView) findViewById(R.id.Q_info);
        Q_view=(ImageView) findViewById(R.id.Q_view);
        B_back=(TextView) findViewById(R.id.B_back);
    }

    private void setListeners() {
        B_back.setOnClickListener(backMain);

    }
    private Button.OnClickListener backMain=new Button.OnClickListener(){
        @Override
        public void onClick(View arg0) {
            MainActivity2.this.finish();
        }


    };
}