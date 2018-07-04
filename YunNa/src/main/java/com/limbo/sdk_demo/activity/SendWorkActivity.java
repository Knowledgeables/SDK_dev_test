package com.limbo.sdk_demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.limbo.sdk_demo.R;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.adapter.TablayoutAdapter;
import com.limbo.sdk_demo.bean.PhotoBean;
import com.limbo.sdk_demo.bean.SendOrderResultBean;
import com.limbo.sdk_demo.fragment.PhotoUpdateFragment;
import com.limbo.sdk_demo.fragment.SendWorkFragment;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.limbo.sdk_demo.view.SimpleOptionView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SendWorkActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleOptionView titleView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button btSend;
    private SendWorkFragment sendWorkFragment;
    private PhotoUpdateFragment photoUpdateFragment;

    public static void OpenActivity(Context context) {
        Intent intent = new Intent(context, SendWorkActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_work);

        initView();
    }

    private void initView() {
        titleView = findViewById(R.id.title_view);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        btSend = findViewById(R.id.bt_send_work);
        btSend.setOnClickListener(this);
        titleView.setTitle("发起工单");
        String[] titles = {"基本信息", "添加附件"};
        List<Fragment> list = new ArrayList<>();
        sendWorkFragment = new SendWorkFragment();
        photoUpdateFragment = new PhotoUpdateFragment();
        list.add(sendWorkFragment);
        list.add(photoUpdateFragment);
        TablayoutAdapter adapter = new TablayoutAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.bt_send_work) {
            Map<String, String> sendWorkMap = sendWorkFragment.getData();
            ArrayList<PhotoBean> photoBeans = photoUpdateFragment.getData();
            String ownerKey = "";
            String ownerSectet = "";
            String serviceKey = "";
            String serviceSectet = "";
            try {
                ApplicationInfo info = null;
                info = getPackageManager()
                        .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                ownerKey = info.metaData.getString("YUNNA_OWNER_APPKEY");
                ownerSectet = info.metaData.getString("YUNNA_OWNER_APPSECRET");
                serviceKey = info.metaData.getString("YUNNA_SERVICE_APPKEY");
                serviceSectet = info.metaData.getString("YUNNA_SERVICE_APPSECRET");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } finally {
                Log.e("YUNNA_OWNER_APPKEY", ownerKey);
                Log.e("YUNNA_OWNER_APPSECRET", ownerSectet);
                Log.e("YUNNA_SERVICE_APPKEY", serviceKey);
                Log.e("YUNNA_SERVICE_APPSECRET", serviceSectet);
            }
            if (sendWorkMap != null) {
                String filenames = "";
                String attachPath = "";
                String attachSize = "";
                for (PhotoBean bean : photoBeans) {
                    filenames += bean.getName() + ",";
                    attachPath += bean.getPath() + ",";
                    attachSize += bean.getSize() + ",";
                }
                sendWorkMap.put("filenames", filenames);
                sendWorkMap.put("attachPath", attachPath);
                sendWorkMap.put("attachSize", attachSize);
                sendWorkMap.put("sort", "1");
                sendWorkMap.put("appKey", YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER ? ownerKey : serviceKey);
                sendWorkMap.put("appSectet", YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER ? ownerSectet : serviceSectet);
                Log.d("sendWorkMap", sendWorkMap.toString());
                YunNa.getInstance().sendWokrOrder(sendWorkMap, new ResultCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Log.d("sendWokrOrder", s);
                        SendOrderResultBean sendOrderResultBean = new Gson().fromJson(s, SendOrderResultBean.class);
                        if (sendOrderResultBean.getMessage() != null) {
                            switch (sendOrderResultBean.getMessage().getCode()) {
                                case 200:
                                    Toast.makeText(SendWorkActivity.this, "工单发送成功", Toast.LENGTH_LONG).show();
                                    break;
                                case 1008:
                                    Toast.makeText(SendWorkActivity.this, "无权限", Toast.LENGTH_LONG).show();
                                    break;
                                case 202:
                                    Toast.makeText(SendWorkActivity.this, "SDK密钥不正确", Toast.LENGTH_LONG).show();
                                    break;
                                default:
                                    Toast.makeText(SendWorkActivity.this, "系统执行异常", Toast.LENGTH_LONG).show();
                                    break;

                            }
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
            }
        }
    }

}
