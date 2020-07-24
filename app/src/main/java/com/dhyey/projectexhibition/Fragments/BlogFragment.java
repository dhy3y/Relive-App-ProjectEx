package com.dhyey.projectexhibition.Fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dhyey.projectexhibition.Adapter.ImageAdapter;
import com.dhyey.projectexhibition.Model.Image;
import com.dhyey.projectexhibition.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BlogFragment extends Fragment {

    DatabaseReference mImage;

    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        final ArrayList<Image> imgList = new ArrayList<Image>();
        final ListView listView = (ListView) view.findViewById(R.id.image_recycler_view);

        mImage = FirebaseDatabase.getInstance().getReference().child("Images");

        mImage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    String imageId = dataSnapshot1.child("image").getValue().toString();
                    Log.d(null, "************" + imageId);

                    Image i = new Image(imageId);

                    imgList.add(i);
                }

                ImageAdapter adapter = new ImageAdapter(getContext(),imgList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

}
