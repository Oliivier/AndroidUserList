package com.example.olivier.androiduserlist;
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements Callback {
    private List<UserData> users;
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Request request = new Request.Builder()
                .url("http://api.randomuser.me/?format=json&results=50")
                .build();
        client.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        Gson gson = new GsonBuilder().create();

        Users results = gson.fromJson(response.body().string(), Users.class);
        users = results.userList();
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_main);

                GridView gridview = (GridView) findViewById(R.id.mainGrindView);
                gridview.setAdapter(new ImageListAdapter(MainActivity.this, users));
            }
        });

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