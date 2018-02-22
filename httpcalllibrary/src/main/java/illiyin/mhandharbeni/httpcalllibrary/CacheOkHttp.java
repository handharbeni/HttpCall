package illiyin.mhandharbeni.httpcalllibrary;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by root on 1/26/18.
 */

public class CacheOkHttp {
    private OkHttpClient client;

    public void initCache() throws IOException {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        File cacheLoc = new File("/var/tmp/okhttp");
        Cache cache = new Cache(cacheLoc, cacheSize);
        // Clear all previous caches on the given directory to make sure
        // all our tests run correctly
        cache.evictAll();
        client = new OkHttpClient.Builder().cache(cache).build();
    }
}
