
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
}*/

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
        List<UserData> list = null;
        super.onCreate(savedInstanceState);
        HttpToJson client = new HttpToJson();
        try {
            client.run();
        } catch (Exception e) {
        }
        // ATTENTE DEGUEUX A REVOIR
        while( (list = client.getList()) == null){
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
            }
            Log.i("Thread ","DEGUEUX" + " ");
        }

        for(UserData user : list){
            System.out.println(user.getName()+" "+user.getPicture());
        }
        //ImageView imageView = (ImageView) findViewById(R.id.imageView1);

        //Glide.with(this).load(list.get(0).getPicture()).into(imageView);

        setContentView(R.layout.activity_main);

        GridView listView = (GridView) findViewById(R.id.usage_example_gridview);
        listView.setAdapter(new ImageListAdapter(MainActivity.this, list));
    }
}


/**
 *
 * GLIDE EXAMPLE
 */
/*
public class MainActivity extends Activity {
    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        GridView listView = (GridView) findViewById(R.id.usage_example_gridview);
        listView.setAdapter(new ImageListAdapter(MainActivity.this, eatFoodyImages));
    }
}
*/

/*public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView targetImageView = (ImageView) findViewById(R.id.imageView1);
        String internetUrl = "http://i.imgur.com/DvpvklR.png";

//        Glide.with(this).load(internetUrl).into(targetImageView);
//        GridView gridview = (GridView) findViewById(R.id.gridview);
//        gridview.setAdapter(new ImageAdapter(this));
    }
*/
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}*/