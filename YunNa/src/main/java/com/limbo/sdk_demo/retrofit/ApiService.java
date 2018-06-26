package com.limbo.sdk_demo.retrofit;

import com.limbo.sdk_demo.bean.LoginBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

/**
 * Created by wangqi on 2017/9/28.
 */

public interface ApiService {

    //登录
    @POST("appUserCheckLogin.htm")
    Observable<LoginBean> connect(@QueryMap HashMap<String, String> map);

    //checkSdkSectet
    @POST("checkSdkSectet.htm")
    Observable<Object> checkSdkSectet(@QueryMap HashMap<String, String> map);

    //获取发起企业
    @POST("queryAppServerInfoRebuild.htm")
    Observable<Object> getSendCompanys(@QueryMap HashMap<String, String> map);

    //获取发起人
    @POST("queryAppSynEmployeeRebuild.htm")
    Observable<Object> getSendPersons(@QueryMap HashMap<String, String> map);

    //获取处理企业
    @POST("queryAppServerInfo.htm")
    Observable<Object> getReceiveCompanys(@QueryMap HashMap<String, String> map);

    //服务端 SLA
    @POST("getAppTotalMinute.htm")
    Observable<Object> getServiceSla(@QueryMap HashMap<String, String> map);

    //业主 SLA
    @POST("appGetTotalMinute.htm")
    Observable<Object> getOwnerSla(@QueryMap HashMap<String, String> map);

    //上传附件
    @Multipart
    @POST("appUploadFile.htm")
    Observable<Object> uploadImg(@Part List<MultipartBody.Part> partList);

    //上传附件
    @POST("appRebuildRequestServerLimit.htm")
    Observable<Object> sendWorkOrder(@QueryMap HashMap<String, String> map);
}
