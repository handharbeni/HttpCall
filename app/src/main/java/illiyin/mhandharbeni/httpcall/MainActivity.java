package illiyin.mhandharbeni.httpcall;

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
        /*initialization*/
        androidCall = new AndroidCall(this);
        setContentView(R.layout.activity_main);
        sampleGet();
        samplePost();
    }

    public void sampleGet(){
        try {
            String url = "";
            String response = androidCall.get(url);

            /*JSON Parsing*/
            JSONObject jsonObject = new JSONObject(response);

            /*DO IT YOURSELF*/
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public void samplePost(){
        try {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("access_token", "YOUR-PARAMETER")
                    .build();
            String url = "";
            String response = androidCall.post(url, requestBody);

            /*JSON Parsing*/
            JSONObject jsonObject = new JSONObject(response);

            /*DO IT YOUR SELF*/
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
