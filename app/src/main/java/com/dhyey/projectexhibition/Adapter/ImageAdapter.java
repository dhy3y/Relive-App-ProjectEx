package com.dhyey.projectexhibition.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.lang.UCharacter;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhyey.projectexhibition.Model.Image;
import com.dhyey.projectexhibition.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends ArrayAdapter<Image> {

    public ImageAdapter(@NonNull Context context, ArrayList<Image> image) {
        super(context, 0, image);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.image_list,parent, false);

        Image currentImg = getItem(position);

        ImageView quote = (ImageView) listItemView.findViewById(R.id.rImageView);
        Picasso.get().load(currentImg.getImage()).into(quote);

        return listItemView;
    }
}
