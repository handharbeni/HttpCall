package illiyin.mhandharbeni.httpcalllibrary;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by root on 16/07/17.
 */

public class AndroidCall {
    File httpCacheDirecotory;
    Cache cache;
    Context mContext;
    OkHttpClient client;
    public AndroidCall(Context context) {
        this.mContext = context;
        initClient(10, 10, 30);
    }
    public AndroidCall(Context context, int connectTimeout){
        this.mContext = context;
        initClient(connectTimeout, 10, 30);
    }
    public AndroidCall(Context context, int connectTimeout, int writeTimeout){
        this.mContext = context;
        initClient(connectTimeout, writeTimeout, 30);

    }
    public AndroidCall(Context context, int connectTimeout, int writeTimeout, int readTimeout){
        this.mContext = context;
        initClient(connectTimeout, writeTimeout, readTimeout);
    }
    private void initClient(int connectTimeout, int writeTimeout, int readTimeout){
//        httpCacheDirecotory = new File(this.mContext.getCacheDir(), "CACHE-OKHTTP");
//        cache = new Cache(httpCacheDirecotory, 10 * 1024 * 1024);
        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(provideCacheInterceptor())
//                .cache(cache)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .build();
    }
    public String get(String url) throws Exception {
        String returns = null;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            returns = response.body().string();
        }catch (Exception e){
            returns = null;
        }
        return returns;
    }
    public String post(String url, RequestBody requestBody) throws Exception {
        String returns  = null;
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            returns = response.body().string();
        }catch (Exception e){
            returns = null;
        }
        return returns;
    }
    private Interceptor provideCacheInterceptor () {
        return new Interceptor() {
            @Override
            public Response intercept (Chain chain) throws IOException {
                Response response = chain.proceed( chain.request() );
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge( 2, TimeUnit.MINUTES )
                        .build();

                return response.newBuilder()
                        .header("Connection", "close")
                        .build();
            }
        };
    }
}
