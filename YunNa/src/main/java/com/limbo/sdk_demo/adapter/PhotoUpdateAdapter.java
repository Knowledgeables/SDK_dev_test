package com.limbo.sdk_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.bean.PhotoBean;
import com.limbo.sdk_demo.util.YunUtils;

import java.util.ArrayList;

/**
 * Created by wangqi on 2018/5/16.
 */

public class PhotoUpdateAdapter extends RecyclerView.Adapter<PhotoUpdateAdapter.PhotoViewHolder> {

    private Context mContext;
    private OnItemClick mOnItemClick;
    private ArrayList<PhotoBean> mPhotos = new ArrayList<>();

    public PhotoUpdateAdapter(Context context) {
        this.mContext = context;
    }

    public void setmOnItemClick(OnItemClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public ArrayList<PhotoBean> getAllData(){
        return mPhotos;
    }

    public void addData(PhotoBean photo) {
        if (photo != null) {
            this.mPhotos.add(photo);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_photo_update, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotoViewHolder holder, final int position) {
        if (position== mPhotos.size()){
            holder.iv.setImageResource(R.mipmap.photo);
            holder.ivDelete.setVisibility(View.GONE);
        }else{
            PhotoBean photoBean= mPhotos.get(position);
            YunUtils.setNetImage(photoBean.getPath(),holder.iv);
            holder.ivDelete.setVisibility(View.VISIBLE);
        }
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPhotos.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClick != null) {
                    mOnItemClick.onItemClick(view, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPhotos.size() + 1;
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView ivDelete;
        ImageView iv;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            ivDelete = itemView.findViewById(R.id.iv_delete);
        }
    }

    public interface OnItemClick {
        void onItemClick(View view, int position);
    }
}
