package id.my.note.prakiraancuaca;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hilmiat on 16/12/17.
 */

public class APIClient {
    private static Retrofit retrofit = null;


    static Retrofit getClient(){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("appid","d30e725bba38cbcf7e9eaf3d85e23096")
                        .addQueryParameter("units","metric")
                        .build();
                Request.Builder reqBuilder = original.newBuilder().url(url);
                Request request = reqBuilder.build();
                return chain.proceed(request);
            }
        }).build();

        retrofit = new Retrofit
                .Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
