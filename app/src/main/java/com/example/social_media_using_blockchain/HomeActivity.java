package com.example.social_media_using_blockchain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.example.social_media_using_blockchain.Adapter.VideoAdapter;
import com.example.social_media_using_blockchain.models.VideoModel;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private ImageView imageView7;
    private ImageView imageView;
    private ViewPager2 viewPager;
    private static final float TARGET_VIDEO_RATIO = 9f / 16f;
    private VideoAdapter videoAdapter;
    private ArrayList<VideoModel> videos;
    private int currentVideoIndex = 0;
    private static final long AUTO_SCROLL_DELAY = 120000; // 60 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupViewPager();

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        // Start auto-scrolling through videos
        startAutoScroll();
    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.viewPager2);
        videoAdapter = new VideoAdapter(videos, viewPager); // Pass viewPager reference to the adapter
        viewPager.setAdapter(videoAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == videos.size() - 1) {
                    currentVideoIndex = 0;
                    viewPager.setCurrentItem(currentVideoIndex, false);
                }
            }
        });
    }
    private void initViews() {

        imageView7 = findViewById(R.id.imageView7);
        Glide.with(this).load(R.drawable.add).into(imageView7);

        videos = new ArrayList<>();
        viewPager = findViewById(R.id.viewPager2);
        int rawResourceId0 = R.raw.a;
        Uri rawVideoUri0 = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId0);
        VideoModel rawVideo0 = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri0.toString(), "Enjoying the sunset!");
        videos.add(rawVideo0);

        int rawResourceId = R.raw.d;
        Uri rawVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId);
        VideoModel rawVideo = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri.toString(), "Enjoying the sunset!");
        videos.add(rawVideo);

        int rawResourceId2 = R.raw.b;
        Uri rawVideoUri2 = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId2);
        VideoModel rawVideo2 = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri2.toString(), "Enjoying the sunset!");
        videos.add(rawVideo2);

        int rawResourceId5 = R.raw.e;
        Uri rawVideoUri5 = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId5);
        VideoModel rawVideo5 = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri5.toString(), "Enjoying the sunset!");
        videos.add(rawVideo5);

        int rawResourceId3 = R.raw.c;
        Uri rawVideoUri3 = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId3);
        VideoModel rawVideo3 = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri3.toString(), "Enjoying the sunset!");
        videos.add(rawVideo3);

        int rawResourceId4 = R.raw.video;
        Uri rawVideoUri4 = Uri.parse("android.resource://" + getPackageName() + "/" + rawResourceId4);
        VideoModel rawVideo4 = new VideoModel("Sunset View", "Abhishek",
                rawVideoUri4.toString(), "Enjoying the sunset!");
        videos.add(rawVideo4);
        VideoModel onlineVideo = new VideoModel("Hello, it's a nice day", "Abhishek",
                "https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-804.mp4", "Nature's beauty!");
        videos.add(onlineVideo);

        VideoModel anotherOnlineVideo = new VideoModel("Beautiful Scenery", "Abhishek",
                "https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-804.mp4", "Nature's beauty!");
        videos.add(anotherOnlineVideo);

    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    private void startAutoScroll() {
        final android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentVideoIndex < videos.size() - 1) {
                    currentVideoIndex++;
                } else {
                    currentVideoIndex = 0;
                }

                viewPager.setCurrentItem(currentVideoIndex);
                handler.postDelayed(this, AUTO_SCROLL_DELAY);
            }
        }, AUTO_SCROLL_DELAY);
    }


    //below code is for the image view
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            Glide.with(this).load(selectedImageUri).into(imageView7);
        }
    }
}
