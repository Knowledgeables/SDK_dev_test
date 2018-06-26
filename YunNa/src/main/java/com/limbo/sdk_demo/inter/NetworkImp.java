package com.limbo.sdk_demo.inter;

import java.io.File;
import java.util.Map;

/**
 * Created by wangqi on 2018/5/4.
 */

public interface NetworkImp {
    void connect(String mobile, String password, final ResultCallback<String> connectCallback);

    void checkSdkSectet(String ownerAppKey, String ownerAppSectet,String serviceAppKey, String serviceAppSectet, ResultCallback<String> checkCallBack) ;

    void getSendCompanyList(ResultCallback<String> getCompanyCallback);

    void getReceiveCompanyList(ResultCallback<String> getCompanyCallback);

    void getSendPersonList(String ownerCompanyCode, ResultCallback<String> resultCallback);

    void getSlaList(ResultCallback<String> resultCallback);

    void uploadImg(File file, ResultCallback<String> resultCallback);

    void sendWorkOrder(String companyCode, String sendUserId, String levelId, String days, String hours, String outsourceFlag, String title, String filenames, String attachPath, String attachSize,String appkey,String secret, ResultCallback<String> resultCallback);
    void sendWorkOrder(Map<String,String> map, ResultCallback<String> resultCallback);
}
