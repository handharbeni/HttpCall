package illiyin.mhandharbeni.httpcalllibrary;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by root on 16/07/17.
 */

public class AndroidCall {
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
        client = new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS).build();
    }
    public String get(String url) throws IOException {
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
    public String post(String url, RequestBody requestBody) throws IOException {
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
}
