package com.example.social_media_using_blockchain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.social_media_using_blockchain.Adapter.VideoAdapter;
import com.example.social_media_using_blockchain.models.VideoModel;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ImageView imageView7;
    private ImageView imageView9;
    private static final int PICK_IMAGE = 1;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private ArrayList<VideoModel> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupRecyclerView();

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSearchLayout();
            }
        });
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(videos);
        recyclerView.setAdapter(videoAdapter);
    }

    private void initViews() {
        imageView7 = findViewById(R.id.imageView7);
        Glide.with(this).load(R.drawable.add).into(imageView7);

        imageView9 = findViewById(R.id.imageView9);
        videos = new ArrayList<>();
        VideoModel video = new VideoModel("hello, such a nice day", "abhishek",
                "https://docjamal.xyz/wp-content/uploads/2020/08/video4.mp4", "ma ta chalya teri or");
        videos.add(video);
        VideoModel video1 = new VideoModel("hello, such a nice day", "abhishek",
                "https://docjamal.xyz/wp-content/uploads/2020/08/video4.mp4", "ma ta chalya teri or");
        videos.add(video1);
        VideoModel video2 = new VideoModel("hello, such a nice day", "abhishek",
                "https://docjamal.xyz/wp-content/uploads/2020/08/video4.mp4", "ma ta chalya teri or");
        videos.add(video2);
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    private void toggleSearchLayout() {
        LinearLayout searchLayout = findViewById(R.id.searchLayout);
        int visibility = searchLayout.getVisibility();
        searchLayout.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            Glide.with(this).load(selectedImageUri).into(imageView7);
        }
    }
}
