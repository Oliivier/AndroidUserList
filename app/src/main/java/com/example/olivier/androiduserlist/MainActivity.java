
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

        HttpToJson client = new HttpToJson();
        try {
            client.run();
        } catch (Exception e) {
        }
        /*List<UserData> users = client.getList();
        for(UserData user : users){
            System.out.println(user.getName()+" "+user.getPicture());
        }*/


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
        text.setText("Agaprout ");

        setContentView(text);
        //setContentView(imageView);
    }
}
