package com.limbo.sdk_demo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.adapter.PhotoUpdateAdapter;
import com.limbo.sdk_demo.bean.PhotoBean;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.loader.ImageLoader;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by wangqi on 2018/5/16.
 */

public class PhotoUpdateFragment extends Fragment implements PhotoUpdateAdapter.OnItemClick {

    private static final int IMAGE_PICKER = 100;
    private RecyclerView recyclerView;
    private PhotoUpdateAdapter adapter;

    public ArrayList<PhotoBean> getData() {
        return adapter.getAllData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_updata, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new PhotoUpdateAdapter(getContext());
        recyclerView.setAdapter(adapter);

        adapter.setmOnItemClick(this);

        // 初始化imagePicker
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(false);        //允许裁剪（单选才有效）
//        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
//        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
//        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
//        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }

    @Override
    public void onItemClick(View view, int position) {
        if ((adapter.getItemCount() - 1) == position) {
            Intent intent = new Intent(getContext(), ImageGridActivity.class);
            startActivityForResult(intent, IMAGE_PICKER);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if (images.size() + adapter.getItemCount() - 1 <= 9) {
                    for (final ImageItem image : images) {
                        YunNa.getInstance().uploadImg(new File(image.path), new ResultCallback<String>() {
                            @Override
                            public void onSuccess(String s) {
                                PhotoBean photoBean = new Gson().fromJson(s, PhotoBean.class);
                                adapter.addData(photoBean);
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        });
                    }
                } else {
                    Toast.makeText(getContext(), "最多只允许上传9张图片，请重新选择", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public static class GlideImageLoader implements ImageLoader {

        @Override
        public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
            Glide.with(activity).load(Uri.fromFile(new File(path)))
                    .into(imageView);
        }

        @Override
        public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
            Glide.with(activity).load(Uri.fromFile(new File(path))).into(imageView);
        }

        @Override
        public void clearMemoryCache() {

        }
    }
}
