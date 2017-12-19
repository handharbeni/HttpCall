package illiyin.mhandharbeni.httpcall;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import illiyin.mhandharbeni.httpcalllibrary.AndroidCall;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {
    AndroidCall androidCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        /*initialization*/
        androidCall = new AndroidCall(this);
        setContentView(R.layout.activity_main);
        sampleGet();
//        samplePost();
    }

    public void sampleGet(){
        try {
            String url = "https://api.chucknorris.io/jokes/random";
            String response = androidCall.get(url);

            /*JSON Parsing*/
            JSONObject jsonObject = new JSONObject(response);

            /*DO IT YOURSELF*/
        } catch (IOException | JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void samplePost(){
        try {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("NAMA PARAMETER", "ISI PARAMETER")
                    .build();
            String url = "https://api.chucknorris.io/jokes/random";
            String response = androidCall.post(url, requestBody);

            /*JSON Parsing*/
            JSONObject jsonObject = new JSONObject(response);

            /*DO IT YOUR SELF*/
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}