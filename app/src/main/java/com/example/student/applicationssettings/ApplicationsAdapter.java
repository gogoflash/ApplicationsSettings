package com.example.student.applicationssettings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 2016.
 */
public class ApplicationsAdapter extends ArrayAdapter<ApplicationData> {

    public ApplicationsAdapter(Context context, ArrayList<ApplicationData> apps) {
        super(context, 0, apps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ApplicationData appData = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.application, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.app_name);
        name.setText(appData.name);

        ImageView imageView = (ImageView)  convertView.findViewById(R.id.app_image);
        imageView.setImageDrawable(appData.icon);

        return convertView;
    }
}

