package com.example.olivier.androiduserlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private List<UserData> users;

    public ImageListAdapter(Context context, List<UserData> users) {
        super(context, R.layout.listview_item_image, users);

        this.context = context;
        this.users = users;

        inflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.user_picture);
        TextView textView = (TextView) convertView.findViewById(R.id.user_name);
        Glide
            .with(context)
            .load(users.get(position).getPicture())
            .into(imageView);

        textView.setText(users.get(position).getName());
        return convertView;
    }
}