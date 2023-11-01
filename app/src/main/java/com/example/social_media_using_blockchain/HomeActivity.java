package com.example.social_media_using_blockchain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.social_media_using_blockchain.Adapter.VideoAdapter;
import com.example.social_media_using_blockchain.models.VideoModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private ImageView imageView7;
    private ImageView imageView9;
    private ViewPager2 viewPager;
    private VideoAdapter videoAdapter;
    private ArrayList<VideoModel> videos;
    private int currentVideoIndex = 0;
    private boolean isAutoScrolling = true;
    private static final long AUTO_SCROLL_DELAY = 5000; // 5 seconds delay

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

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSearchLayout();
            }
        });

        // Start auto-scrolling through videos
        startAutoScroll();
    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.viewPager2);
        videoAdapter = new VideoAdapter(videos);
        viewPager.setAdapter(videoAdapter);

        // Set a listener to detect the end of the list
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == videos.size() - 1) {
                    // Reached the end of the list
                    stopAutoScroll();
                }
            }
        });
    }

    private void initViews() {
        imageView7 = findViewById(R.id.imageView7);
        Glide.with(this).load(R.drawable.add).into(imageView7);

        imageView9 = findViewById(R.id.imageView9);
        videos = new ArrayList<>();

        // Example VideoModel:
        VideoModel video = new VideoModel("Hello, it's a nice day", "Abhishek",
                "https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-804.mp4", "Let's enjoy the day!");
        videos.add(video);
        VideoModel video1 = new VideoModel("Greetings from Abhishek", "Abhishek",
                "https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-804.mp4", "Have a great day!");
        videos.add(video1);
        VideoModel video2 = new VideoModel("Beautiful Scenery", "Abhishek",
                "https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-804.mp4", "Nature's beauty!");
        videos.add(video2);

        // Add more VideoModel instances as needed
    }

    private void toggleSearchLayout() {
        LinearLayout searchLayout = findViewById(R.id.searchLayout);
        int visibility = searchLayout.getVisibility();
        searchLayout.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
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
                if (isAutoScrolling && currentVideoIndex < videos.size() - 1) {
                    // Scroll to the next video
                    currentVideoIndex++;
                    viewPager.setCurrentItem(currentVideoIndex);
                }
                handler.postDelayed(this, AUTO_SCROLL_DELAY);
            }
        }, AUTO_SCROLL_DELAY);
    }

    private void stopAutoScroll() {
        isAutoScrolling = false;
        Toast.makeText(this, "Reached the end of the list", Toast.LENGTH_SHORT).show();
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
