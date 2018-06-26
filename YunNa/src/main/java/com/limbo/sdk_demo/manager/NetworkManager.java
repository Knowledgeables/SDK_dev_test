package com.limbo.sdk_demo.manager;

import android.util.Log;

import com.google.gson.Gson;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.bean.AppKeyBean;
import com.limbo.sdk_demo.bean.ErrorCode;
import com.limbo.sdk_demo.bean.LoginBean;
import com.limbo.sdk_demo.inter.NetworkImp;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.limbo.sdk_demo.retrofit.ApiService;
import com.limbo.sdk_demo.retrofit.RRetrofit;
import com.limbo.sdk_demo.util.JsonMapUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by wangqi on 2018/5/4.
 */
public class NetworkManager implements NetworkImp {

    @Override
    public void connect(String mobile, String password, final ResultCallback<String> connectCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", mobile);
        map.put("password", password);
        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        RRetrofit.getInstance().getApiService().connect(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        int code = bean.getMessage().getCode();
                        if (code == 200) {
                            YunNa.mLoginBean = bean;
                            if (connectCallback != null) {
                                connectCallback.onSuccess("success");
                            }
                        } else {
                            if (connectCallback != null) {
                                connectCallback.onError(new ErrorCode(code, bean.getMessage().getMessage()));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (connectCallback != null) {
                            connectCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    @Override
    public void checkSdkSectet(String ownerAppKey, String ownerAppSectet, String serviceAppKey, String serviceAppSectet, final ResultCallback<String> checkCallBack) {
        AppKeyBean key = new AppKeyBean();
        key.setKey1(new AppKeyBean.Key1Bean(ownerAppKey, ownerAppSectet));
        key.setKey2(new AppKeyBean.Key2Bean(serviceAppKey, serviceAppSectet));
        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", new Gson().toJson(key));
        RRetrofit.getInstance(RRetrofit.MIDDLE_URL).getApiService().checkSdkSectet(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        Log.d("RRetrofit", new Gson().toJson(bean));
                        checkCallBack.onSuccess(new Gson().toJson(bean));
                    }

                    @Override
                    public void onError(Throwable e) {
                        checkCallBack.onError(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    @Override
    public void getSendCompanyList(final ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();

        HashMap<String, String> map = new HashMap<>();
        map.put("serviceProviderCode", bean.getServiceProviderCode());

        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        RRetrofit.getInstance().getApiService().getSendCompanys(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void getSendPersonList(String ownerCompanyCode, final ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();

        HashMap<String, String> map = new HashMap<>();
        map.put("synCode", ownerCompanyCode);
        map.put("serviceProviderCode", bean.getServiceProviderCode());

        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        RRetrofit.getInstance().getApiService().getSendPersons(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void getReceiveCompanyList(final ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();

        HashMap<String, String> map = new HashMap<>();
        map.put("exeType", "1");
        map.put("serverName", "");
        map.put("ownerCode", bean.getOwnerCode());
        map.put("currentUserId", bean.getEmployeeId());
        HashMap<String, String> jsMap = new HashMap<>();

        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        RRetrofit.getInstance().getApiService().getReceiveCompanys(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void getSlaList(final ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();

        HashMap<String, String> map = new HashMap<>();
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            map.put("ownerCode", bean.getOwnerCode());
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            map.put("serviceProviderCode", bean.getServiceProviderCode());
        }

        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        ApiService apiService = RRetrofit.getInstance().getApiService();
        Observable<Object> observable = null;
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            observable = apiService.getOwnerSla(jsMap);
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            observable = apiService.getServiceSla(jsMap);
        }
        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void uploadImg(File file, final ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("tempPath", "")
                .addFormDataPart("isControl", "1")
                .addFormDataPart("versionCode", bean.getCompany().getVersionCode())
                .addFormDataPart("companyCode", bean.getCompany().getCompanyCode())
                .addFormDataPart("fileuploadFileName", file.getName());
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("fileupload", file.getName(), imageBody);

        List<MultipartBody.Part> parts = builder.build().parts();

        RRetrofit rRetrofit = null;
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            rRetrofit = RRetrofit.getInstance(RRetrofit.CUSTOMER_FILE_URL);
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            rRetrofit = RRetrofit.getInstance(RRetrofit.SERVICE_FILE_URL);
        }
        rRetrofit.getApiService().uploadImg(parts).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void sendWorkOrder(String companyCode, String sendUserId, String levelId, String days, String hours, String outsourceFlag, String title, String filenames, String attachPath, String attachSize, String appkey, String secret, ResultCallback<String> resultCallback) {
        LoginBean.RowsBean bean = YunNa.mLoginBean.getRows();

        HashMap<String, String> map = new HashMap<>();
        if (YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER) {
            map.put("serviceProviderCode", companyCode);
            map.put("outsourceFlag", outsourceFlag);
        } else if (YunNa.mType == YunNa.YUN_TYPE.TYPE_SERVICE) {
            map.put("ownerCode", companyCode);
            map.put("sendUser", sendUserId);
        }
        map.put("levelId", levelId);
        map.put("days", days);
        map.put("hours", hours);
        map.put("title", title);
        map.put("currentUserId", bean.getEmployeeId());
        map.put("filenames", filenames);
        map.put("attachPath", attachPath);
        map.put("attachSize", attachSize);
        map.put("sort", "1");
        map.put("appKey", appkey);
        map.put("appSectet", secret);

        sendWorkOrder(map, resultCallback);
    }


    @Override
    public void sendWorkOrder(Map<String, String> map, final ResultCallback<String> resultCallback) {
        HashMap<String, String> jsMap = new HashMap<>();
        jsMap.put("jsonBean", JsonMapUtil.mapToJson(map));
        RRetrofit.getInstance().getApiService().sendWorkOrder(jsMap).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object bean) {
                        if (resultCallback != null) {
                            resultCallback.onSuccess(new Gson().toJson(bean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultCallback != null) {
                            resultCallback.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
