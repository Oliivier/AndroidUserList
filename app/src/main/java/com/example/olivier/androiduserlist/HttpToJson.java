package com.example.olivier.androiduserlist;

import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


class HttpToJson {
    List<UserData> list;

    private final OkHttpClient client = new OkHttpClient();
/*	  String run(String url) throws IOException {
          Request request = new Request.Builder().url(url).build();
          Response response = client.newCall(request).execute();
          return response.body().string();
	 }
*/
      public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://api.randomuser.me/?format=json&results=50")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                Gson gson = new GsonBuilder().create();
                Users results = gson.fromJson(response.body().string(), Users.class);
                list = results.userList();

                for(UserData user : list){
                    System.out.println(user.getName()+" "+user.getPicture());
                }
                response.body().close();
            }
        });
    }


    public List<UserData> getList() {
        return list;
    }
}