package illiyin.mhandharbeni.httpcalllibrary;

import android.content.Context;

import java.io.IOException;

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
        client = new OkHttpClient();
    }
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public String post(String url, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
