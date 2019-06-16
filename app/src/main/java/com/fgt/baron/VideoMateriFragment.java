package com.fgt.baron;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fgt.baron.adapter.videoAdapter;
import com.fgt.baron.model.videoModel;

import java.util.Vector;

public class VideoMateriFragment extends Fragment {

    RecyclerView recyclerView;
    Vector<videoModel> videoModels = new Vector<videoModel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video_materi, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));

        videoModels.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CImiWrrQjwM\" frameborder=\"0\" allowfullscreen></iframe>") );
        videoModels.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_jSfmlecG-4\" frameborder=\"0\" allowfullscreen></iframe>") );
        videoModels.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PikVbDBr7-M\" frameborder=\"0\" allowfullscreen></iframe>") );

        videoAdapter videoAdapter = new videoAdapter(videoModels);

        recyclerView.setAdapter(videoAdapter);

        return v;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

