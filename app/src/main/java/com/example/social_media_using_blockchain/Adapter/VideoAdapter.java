package com.example.social_media_using_blockchain.Adapter;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.social_media_using_blockchain.R;
import com.example.social_media_using_blockchain.models.VideoModel;
import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private ArrayList<VideoModel> videoData;

    public VideoAdapter(ArrayList<VideoModel> videoData) {
        this.videoData = videoData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setData(videoData.get(position));
    }

    @Override
    public int getItemCount() {
        return videoData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView songName, description, username;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            songName = itemView.findViewById(R.id.songName);
            description = itemView.findViewById(R.id.description);
            username = itemView.findViewById(R.id.userName);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setData(VideoModel videoModel) {
            Uri videoUri = Uri.parse(videoModel.getMedia_url());
            videoView.setVideoURI(videoUri);
            description.setText(videoModel.getDescription());
            username.setText(videoModel.getUserName());
            songName.setText(videoModel.getSongName());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
