package com.limbo.demo_test;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.activity.SendWorkActivity;
import com.limbo.sdk_demo.bean.CheckSecretBean;
import com.limbo.sdk_demo.inter.ResultCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText etUserName;
    private EditText etPassword;
    private RadioGroup rg;
    private YunNa.YUN_TYPE type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        rg = findViewById(R.id.rg);
        Button btLogin = findViewById(R.id.bt_login);

        btLogin.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        rg.check(R.id.rb_service);
    }

    @Override
    public void onClick(View v) {
        String name = etUserName.getText().toString();
        String psd = etPassword.getText().toString();

        YunNa.connect(name, psd, type, new ResultCallback<String>() {
            @Override
            public void onSuccess(String s) {
                SendWorkActivity.OpenActivity(MainActivity.this);
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
            }
        });
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
        YunNa.checkSdkSectet(ownerKey, ownerSectet, serviceKey, serviceSectet, new ResultCallback<String>() {
            @Override
            public void onSuccess(String s) {
                CheckSecretBean checkSecretBean = new Gson().fromJson(s, CheckSecretBean.class);
                if (checkSecretBean.isRows()) {
                    Toast.makeText(MainActivity.this, "密钥正确", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "密钥错误", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_service:
                type = YunNa.YUN_TYPE.TYPE_SERVICE;
                break;
            case R.id.rb_owner:
                type = YunNa.YUN_TYPE.TYPE_CUSTOMER;
                break;
        }
    }
}
