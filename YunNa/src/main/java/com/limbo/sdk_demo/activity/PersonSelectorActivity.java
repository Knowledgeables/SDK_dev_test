package com.limbo.sdk_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.adapter.PersonSelectAdapter;
import com.limbo.sdk_demo.bean.PersonBean;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.limbo.sdk_demo.view.SimpleOptionView;

/**
 * Created by wangqi on 2018/5/15.
 */

public class PersonSelectorActivity extends AppCompatActivity implements PersonSelectAdapter.OnItemClick {

    private RecyclerView recyclerView;
    private SimpleOptionView titleView;
    private PersonSelectAdapter adapter;
    private String ownerCompanyCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_selector);

        ownerCompanyCode = getIntent().getStringExtra("ownerCompanyCode");

        initView();
        initData();
    }

    private void initView() {
        titleView = findViewById(R.id.title_view);
        recyclerView = findViewById(R.id.recycler_view);

        titleView.setTitle("选择发起人");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonSelectAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClick(this);

    }

    private void initData() {
        YunNa.getInstance().getSendPersonList(ownerCompanyCode, new ResultCallback<String>() {
            @Override
            public void onSuccess(String s) {
                PersonBean bean = new Gson().fromJson(s, PersonBean.class);
                if (bean.getMessage().getCode() == 200) {
                    if (bean.getRows() != null && bean.getRows().size() != 0) {
                        adapter.setData(bean.getRows());
                    } else {
                        Toast.makeText(PersonSelectorActivity.this,"未查询到人员数据",Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        PersonBean.Rows bean = adapter.getData().get(position);
        Intent intent = new Intent();
        intent.putExtra("name",bean.getName());
        intent.putExtra("userId",bean.getEmployeeId());
        setResult(RESULT_OK,intent);
        finish();
    }

    public static void OpenActivity(android.support.v4.app.Fragment fragment, int requestCode, String ownerCompanyCode){
        Intent intent = new Intent(fragment.getContext(),PersonSelectorActivity.class);
        intent.putExtra("ownerCompanyCode",ownerCompanyCode);
        fragment.startActivityForResult(intent,requestCode);
    }
}
