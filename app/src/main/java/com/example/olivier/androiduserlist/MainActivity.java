
package com.example.olivier.androiduserlist;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpToJson client = new HttpToJson();
        List<UserData> list;
        try {
            client.run();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        // ATTENTE ACTIVE sleep pas sleep ? :/ Lancer un pong en attendant ...
        while( (list = client.getList()) == null);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.mainGrindView);
        gridview.setAdapter(new ImageListAdapter(MainActivity.this, list));

        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });/*/
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