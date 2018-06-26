package com.limbo.sdk_demo.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.activity.CompanySelectorActivity;
import com.limbo.sdk_demo.activity.PersonSelectorActivity;
import com.limbo.sdk_demo.bean.SLABean;
import com.limbo.sdk_demo.inter.ResultCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqi on 2018/5/15.
 */

public class SendWorkFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private static final int REQUEST_COMPANY_SEND = 101;
    private static final int REQUEST_PERSON_SEND = 102;
    private static final int REQUEST_COMPANY_RECEIVE = 103;

    private LinearLayout llSendCompany;
    private LinearLayout llSendPerson;
    private LinearLayout llReceiveCompany;
    private TextView tvSendCompany;
    private TextView tvSendPerson;
    private TextView tvReceiveCompany;
    private RadioGroup rgUrgent;
    private EditText etSlaDay;
    private EditText etSlaHour;
    private EditText etDescribe;
    private TextView tvDescribeNumber;
    private ImageView ivSendCompany;
    private ImageView ivSendPerson;
    private ImageView ivReceiveCompany;
    private SLABean slaBean;
    private String levelId;
    private String ownerCompanyCode;
    private String sendUser;
    private String serviceCompanyCode;
    private String outsourceFlag;

    public Map<String, String> getData() {
        String days = etSlaDay.getText().toString();
        String hours = etSlaHour.getText().toString();
        String title = etDescribe.getText().toString();

        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE && TextUtils.isEmpty(ownerCompanyCode)) {
            Toast.makeText(getContext(),"发起企业不能为空！",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE && TextUtils.isEmpty(sendUser)) {
            Toast.makeText(getContext(),"发起人不能为空！",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER && TextUtils.isEmpty(serviceCompanyCode)) {
            Toast.makeText(getContext(),"处理企业不能为空！",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (TextUtils.isEmpty(levelId)) {
            Toast.makeText(getContext(),"请选择故障等级",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (TextUtils.isEmpty(days) || TextUtils.isEmpty(hours)) {
            Toast.makeText(getContext(),"SLA不能为空！",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(getContext(),"简要描述不能为空！",Toast.LENGTH_SHORT).show();
            return null;
        }

        Map<String, String> map = new HashMap<>();
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            map.put("serviceProviderCode", serviceCompanyCode);
            map.put("outsourceFlag", outsourceFlag);
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            map.put("ownerCode", ownerCompanyCode);
            map.put("sendUser", sendUser);
        }
        map.put("currentUserId", YunNa.mLoginBean.getRows().getEmployeeId());
        map.put("levelId", levelId);
        map.put("days", days);
        map.put("hours", hours);
        map.put("title", title);
        return map;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_work, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        llSendCompany = view.findViewById(R.id.ll_send_company);
        llSendPerson = view.findViewById(R.id.ll_send_person);
        llReceiveCompany = view.findViewById(R.id.ll_receive_company);
        tvSendCompany = view.findViewById(R.id.tv_send_company);
        tvSendPerson = view.findViewById(R.id.tv_send_person);
        tvReceiveCompany = view.findViewById(R.id.tv_receive_company);
        rgUrgent = view.findViewById(R.id.rg_urgent);
        etSlaDay = view.findViewById(R.id.et_sla_day);
        etSlaHour = view.findViewById(R.id.et_sla_hour);
        etDescribe = view.findViewById(R.id.et_describe);
        tvDescribeNumber = view.findViewById(R.id.tv_describe_number);
        ivSendCompany = view.findViewById(R.id.iv_send_company);
        ivSendPerson = view.findViewById(R.id.iv_send_person);
        ivReceiveCompany = view.findViewById(R.id.iv_receive_company);

        llSendCompany.setOnClickListener(this);
        llSendPerson.setOnClickListener(this);
        llReceiveCompany.setOnClickListener(this);

        rgUrgent.setOnCheckedChangeListener(this);

        etDescribe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int length = charSequence.length();
                tvDescribeNumber.setText(length + "");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            tvSendCompany.setText(YunNa.mLoginBean.getRows().getCompany().getCompanyName());
            tvSendPerson.setText(YunNa.mLoginBean.getRows().getName());
            // 隐藏 箭头控件
            ivSendCompany.setVisibility(View.INVISIBLE);
            ivSendPerson.setVisibility(View.INVISIBLE);
            // 取消点击事件
            llSendCompany.setOnClickListener(null);
            llSendPerson.setOnClickListener(null);
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            tvReceiveCompany.setText(YunNa.mLoginBean.getRows().getCompany().getCompanyName());
            // 隐藏 箭头控件
            ivReceiveCompany.setVisibility(View.INVISIBLE);
            // 取消点击事件
            llReceiveCompany.setOnClickListener(null);
        }
    }

    private void initData() {
        // 初始化SLA数据
        YunNa.getInstance().getSlaList(new ResultCallback<String>() {
            @SuppressLint("ResourceType")
            @Override
            public void onSuccess(String s) {
                slaBean = new Gson().fromJson(s, SLABean.class);
                if (slaBean.getMessage().getCode() == 200) {
                    // 设置故障等级
                    List<SLABean.RowsBean> list = slaBean.getRows();
                    for (int i = 0; i < list.size(); i++) {
                        RadioButton rb = new RadioButton(getContext());
                        RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(0,
                                ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
                        rb.setLayoutParams(params);
                        rb.setText(list.get(i).getLevelName());
                        rb.setGravity(Gravity.CENTER);
                        rb.setTextSize(13f);
                        rb.setButtonDrawable(null);
                        rb.setTextColor(getResources().getColorStateList(R.drawable.selector_rg_text));

                        if (i == 0) {
                            rb.setBackgroundResource(R.drawable.selector_rg_left);
                        } else if (i == list.size() - 1) {
                            rb.setBackgroundResource(R.drawable.selector_rg_right);
                        } else {
                            rb.setBackgroundResource(R.drawable.selector_rg_center);
                        }
                        rb.setId(i);
                        rgUrgent.addView(rb);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.ll_send_company) {
            CompanySelectorActivity.OpenActivity(this, REQUEST_COMPANY_SEND, CompanySelectorActivity.TYPE_SEND);

        } else if (i == R.id.ll_send_person) {
            PersonSelectorActivity.OpenActivity(this, REQUEST_PERSON_SEND, ownerCompanyCode);

        } else if (i == R.id.ll_receive_company) {
            CompanySelectorActivity.OpenActivity(this, REQUEST_COMPANY_RECEIVE, CompanySelectorActivity.TYPE_RECEIVE);

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        if (slaBean != null) {
            SLABean.RowsBean bean = slaBean.getRows().get(id);
            levelId = bean.getTempId();
            etSlaDay.setText(bean.getCompleteDay() + "");
            etSlaHour.setText(bean.getCompleteHour() + "");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = null;
            if (data != null) {
                bundle = data.getExtras();
            }
            if (requestCode == REQUEST_COMPANY_SEND) {
                tvSendCompany.setText(bundle.getString("serverName"));
                ownerCompanyCode = bundle.getString("companyCode");

                tvSendPerson.setText("");
                sendUser = "";
            } else if (requestCode == REQUEST_PERSON_SEND) {
                tvSendPerson.setText(bundle.getString("name"));
                sendUser = bundle.getString("userId");
            } else if (requestCode == REQUEST_COMPANY_RECEIVE) {
                tvReceiveCompany.setText(bundle.getString("serverName"));
                serviceCompanyCode = bundle.getString("companyCode");
                if ("1".equals(bundle.getString("bindFlag"))) {  //外协
                    outsourceFlag = "1";
                } else { // 内
                    outsourceFlag = "0";
                }
            }

        }
    }
}
