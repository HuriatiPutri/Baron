package com.fgt.baron.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.fgt.baron.R;
import com.fgt.baron.model.videoModel;

import java.util.List;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.videoViewHolder> {

    List<videoModel> youtubeVideoList;

    public videoAdapter() {
    }

    public videoAdapter(List<videoModel> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @Override
    public videoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.video_view, parent, false);

        return new videoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(videoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );

    }


    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public class videoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public videoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {


            } );
        }
    }
}
