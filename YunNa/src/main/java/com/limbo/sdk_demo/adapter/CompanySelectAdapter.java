package com.limbo.sdk_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.bean.CompanyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqi on 2018/5/15.
 */

public class CompanySelectAdapter extends RecyclerView.Adapter<CompanySelectAdapter.TextViewHolder> {

    private Context mContext;
    private OnItemClick mOnItemClick;
    private List<CompanyBean.Rows> mList = new ArrayList<>();


    public interface OnItemClick{
        void onItemClick(View view,int position);
    }

    public CompanySelectAdapter(Context context) {
        this.mContext = context;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }

    public void setData(List<CompanyBean.Rows> list) {
        if (null != mList) {
            this.mList.clear();
            this.mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<CompanyBean.Rows> getData() {
        return mList;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_simple_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position).getServerName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClick!=null){
                    mOnItemClick.onItemClick(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {


         TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
