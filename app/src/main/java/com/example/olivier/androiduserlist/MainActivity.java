
package com.example.olivier.androiduserlist;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class MainActivity extends AppCompatActivity {
    Gson gson = new GsonBuilder().create();
    protected void onCreate(Bundle savedInstanceState) {
        //ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.Thread.sleep;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

  /*      HttpToJson client = new HttpToJson();
        try {
            client.run();
            sleep(10);
        } catch (Exception e) {
        }
        List<UserData> users = client.getList();
        for(UserData user : users){
            System.out.println(user.getName()+" "+user.getPicture());
        }*/

       OkHttpClient client = new OkHttpClient();
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
        //System.out.println(client.getAnswer()+"hey");
        /*
        Gson gson = new GsonBuilder().create();
        Users results = gson.fromJson(responses, Users.class);

        List<UserData> list = results.userList();

        for(UserData user : list){
            System.out.println(user.getName()+" "+user.getPicture());
        }
        */
        //ImageView imageView = (ImageView) findViewById(R.id.imageView1);

        //Glide.with(this).load(list.get(0).getPicture()).into(imageView);

        TextView text = new TextView(this);
        text.setText("Bonjour, vous me devez 1 000 000€.");

        setContentView(text);
        //setContentView(imageView);
    }
}