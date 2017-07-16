# CRUD Realm Android
### Installation
Add this to your build.gradle

```sh
compile 'com.squareup.okhttp3:okhttp:3.8.1'
compile 'illiyin.mhandharbeni.httpcall:httpcalllibrary:0.0.1'
```

### How to use

| Function | Parameter |
| ------ | ------ |
| Get | N/A |
| Post | N/A |
| Update | N/A |
| Delete | N/A |

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


### Upload File
```sh
File sourceFile = new File("IMAGE_PATH");
final MediaType MEDIA_TYPE = "IMAGE_PATH".endsWith("png") ?
    MediaType.parse("image/png") : MediaType.parse("image/jpeg");
RequestBody requestBody = new MultipartBody.Builder()
    .setType(MultipartBody.FORM)
    .addFormDataPart("gambar", "IMAGE_NAME", RequestBody.create(MEDIA_TYPE, sourceFile))
    .build();
String url = "";
String response = androidCall.post(url, requestBody);
```
