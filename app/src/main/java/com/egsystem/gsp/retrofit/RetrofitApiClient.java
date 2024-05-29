package com.egsystem.gsp.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitApiClient {


//
//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//    OkHttpClient client = new OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            //.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
//            .addNetworkInterceptor(new Interceptor() {
//
//                @Override
//
//                public okhttp3.Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder()
//                            // .addHeader(Constant.Header, authToken)
//                            .build();
//                    return chain.proceed(request);
//                }
//            }).build();
//
//    final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(Constant.baseUrl)
//            .client(client) // This line is important
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//



    public static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
//                           interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//    public static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    Request requestWithUserAgent = originalRequest.newBuilder()
                            .header("User-Agent", "Android App: version: " + "SplashActivity.version" + " source_id: " + "SplashActivity.source_id")
                            .build();
                    return chain.proceed(requestWithUserAgent);
                }
            })
            .addNetworkInterceptor(new Interceptor() {

                @Override

                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            // .addHeader(Constant.Header, authToken)
                            .build();
                    return chain.proceed(request);
                }
            })
            .build();



    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitApiClient() {
    }

    public static synchronized Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }


        return retrofit;
    }

    public static ApiInterface getApiInterface() {
        return RetrofitApiClient.getClient().create(ApiInterface.class);

    }



}
