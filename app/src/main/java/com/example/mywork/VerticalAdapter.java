package com.example.mywork;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private static final String TAG = VerticalAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mList = new ArrayList<>();
    public VerticalAdapter(Context context) {
        mContext = context;
    }
    public void setVerticalDataList(List<String> list) {
        Log.d(TAG, "setVerticalDataList: " + list.size());

        mList = list;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.tvNum.setText(position + 1 + "");
        holder.tvContent.setText(mList.get(position));

        final String content=mList.get(position);
        holder.itemView.setContentDescription(content);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "您点击的枪械是：" + content, Toast.LENGTH_SHORT).show();
                //跳转到枪械详情界面
                Intent intent=new Intent();
                intent.setClass(mContext,MainActivity2.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        TextView tvNum, tvContent;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
