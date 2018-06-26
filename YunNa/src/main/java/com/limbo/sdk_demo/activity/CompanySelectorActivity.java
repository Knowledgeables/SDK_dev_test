package com.limbo.sdk_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.adapter.CompanySelectAdapter;
import com.limbo.sdk_demo.bean.CompanyBean;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.limbo.sdk_demo.view.SimpleOptionView;

/**
 * Created by wangqi on 2018/5/15.
 */

public class CompanySelectorActivity extends AppCompatActivity implements CompanySelectAdapter.OnItemClick {

    public static int TYPE_SEND = 11;
    public static int TYPE_RECEIVE = 12;
    private int type;
    private RecyclerView recyclerView;
    private SimpleOptionView titleView;
    private CompanySelectAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_selector);

        type = getIntent().getIntExtra("type", 0);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        titleView = findViewById(R.id.title_view);
        if (type==TYPE_SEND){
            titleView.setTitle("选择发起企业");
        }else if (type == TYPE_RECEIVE){
            titleView.setTitle("选择处理企业");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CompanySelectAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClick(this);
    }

    private void initData(){
        if (type==TYPE_SEND){
            YunNa.getInstance().getSendCompanyList(new ResultCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    CompanyBean companyBean = new Gson().fromJson(s, CompanyBean.class);
                    if (companyBean.getMessage().getCode()==200){
                        if (companyBean.getRows() != null && companyBean.getRows().size() != 0) {
                            adapter.setData(companyBean.getRows());
                        } else {
                            Toast.makeText(CompanySelectorActivity.this,"未查询到企业数据",Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onError(Throwable throwable) {

                }
            });
        }else if (type == TYPE_RECEIVE){
            YunNa.getInstance().getReceiveCompanyList(new ResultCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    CompanyBean companyBean = new Gson().fromJson(s, CompanyBean.class);
                    if (companyBean.getMessage().getCode()==200){
                        if (companyBean.getRows() != null && companyBean.getRows().size() != 0) {
                            adapter.setData(companyBean.getRows());
                        } else {
                            Toast.makeText(CompanySelectorActivity.this,"未查询到企业数据",Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                }
            });
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        CompanyBean.Rows bean = adapter.getData().get(position);
        Intent intent = new Intent();
        intent.putExtra("companyCode",bean.getCompanyCode());
        intent.putExtra("serverName",bean.getServerName());
        intent.putExtra("bindFlag", bean.getBindFlag());
        setResult(RESULT_OK, intent);
        this.finish();
    }

    public static void OpenActivity(Fragment fragment,int requestCode,int type){
        Intent intent = new Intent(fragment.getContext(),CompanySelectorActivity.class);
        intent.putExtra("type",type);
        fragment.startActivityForResult(intent,requestCode);
    }
}
