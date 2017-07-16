# HttpCall

### Installation
Add this to your build.gradle

```sh
compile 'com.squareup.okhttp3:okhttp:3.8.1'
compile 'illiyin.mhandharbeni.httpcall:httpcalllibrary:0.0.1'
```

### How to use

| Function | Parameter |
| ------ | ------ |
| Get | String |
| Post | String, RequestBody |

### Sample
init in your activity
```sh
AndroidCall androidCall = new AndroidCall(this);
```

### METHOD GET
```sh
String url = "";
String response = androidCall.get(url);

/*JSON Parsing*/
JSONObject jsonObject = new JSONObject(response);
```
### METHOD POST
```sh
RequestBody requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("NAMA PARAMETER", "ISI PARAMETER")
        .build();
String url = "";
String response = androidCall.post(url, requestBody);

/*JSON Parsing*/
JSONObject jsonObject = new JSONObject(response);
```
