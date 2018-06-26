package com.limbo.sdk_demo.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.limbo.sdk_demo.YunNa;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangqi on 2017/5/19.
 */

public class RRetrofit {
    public static final String CUSTOMER_URL = "http://192.168.15.90:8080/AppCloudServer/"; //业主
    public static final String SERVICE_URL = "http://192.168.15.90:8080/AppServiceProvider/"; //服务商
    public static final String MIDDLE_URL = "http://192.168.15.90:8080/MiddleServer/";//中间平台
    public static final String CUSTOMER_FILE_URL = "http://192.168.15.90:8080/CloudServer/";//业主文件
    public static final String SERVICE_FILE_URL = "http://192.168.15.90:8080/ServiceProvider/";//服务商文件
    private static Retrofit.Builder builder;
    private static RRetrofit retrofit;
    private OkHttpClient httpClient;

    private RRetrofit(String basUrl) {
        //每次网络请求携带请求头(token上传，校验唯一登陆)
        //sp_token = mContext.getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE);
        httpClient = getHttpClient();
        builder = new Retrofit.Builder()
                .baseUrl(basUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient);
    }

    private RRetrofit() {
        //每次网络请求携带请求头(token上传，校验唯一登陆)
        //sp_token = mContext.getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE);
        httpClient = getHttpClient();
        builder = new Retrofit.Builder()
                .baseUrl(YunNa.mType == YunNa.YUN_TYPE.TYPE_CUSTOMER ? RRetrofit.CUSTOMER_URL : RRetrofit.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient);
    }

    public static RRetrofit getInstance(String baseUrl) {
        synchronized (RRetrofit.class) {
            retrofit = new RRetrofit(baseUrl);
            return retrofit;
        }
    }

    public static RRetrofit getInstance() {
        synchronized (RRetrofit.class) {
            retrofit = new RRetrofit();
            return retrofit;
        }
    }

    /**
     * 构造httpclient
     *
     * @return
     */
    private static OkHttpClient getHttpClient() {

        //设置连接超时时间 ;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
//                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                .addHeader("Accept-Encoding", "gzip, deflate")
//                                .addHeader("Connection", "keep-alive")
//                                .addHeader("Accept", "")
//                                .addHeader("token", token)
                                .build();
                        Response proceed = chain.proceed(request);
                        return proceed;
                    }
                })
                .build();

        try {

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            client.newBuilder().sslSocketFactory(sslSocketFactory, new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }).hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return client;
    }

    /*public ApiService getApiService( String username, String password) {
        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            httpClient.interceptors().clear();
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", basic)
                        .header("Accept", "applicaton/json")
                        .method(original.method(), original.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(ApiService.class);
    }*/

    public ApiService getApiService() {
        Retrofit retrofit = builder.build();
        return retrofit.create(ApiService.class);
    }
}
