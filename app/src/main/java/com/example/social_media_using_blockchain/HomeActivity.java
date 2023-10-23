

package com.example.social_media_using_blockchain;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.social_media_using_blockchain.Adapter.DemoAdapter;
import com.example.social_media_using_blockchain.models.MediaObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ImageView sound_dis;
    private List<MediaObject> mediaObjectList = new ArrayList<>();
    private DemoAdapter demoAdapter;
    private RecyclerView recyclerview;
    private ImageView imageView7;
      private ImageView imageView9; 
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        imageView9 = findViewById(R.id.imageView9);

        imageView7 =(ImageView) findViewById(R.id.imageView7); // Initialize the imageView7
        Glide.with(this).load(R.drawable.add).into(imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        imageView9 = findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout searchLayout = findViewById(R.id.searchLayout);
                // Find the search bar layout

                // Toggle visibility of the search layout
                if (searchLayout.getVisibility() == View.VISIBLE) {
                    searchLayout.setVisibility(View.GONE);
                } else {
                    searchLayout.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private void init() {

        if(Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <21){
            setWindowFlag(this , WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS , true);
        }
        if(Build.VERSION.SDK_INT >= 19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
        if(Build.VERSION.SDK_INT <21){
            setWindowFlag(this , WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerview);

        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));
        mediaObjectList.add(new MediaObject("","","","","","","","","",""));

        demoAdapter = new DemoAdapter(mediaObjectList, getApplicationContext());
        recyclerview.setAdapter(demoAdapter);
        demoAdapter.notifyDataSetChanged();


    }

    public static void setWindowFlag(@NotNull Activity activity , final int bits , boolean on){
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if(on){
            winParams.flags |= bits;
        }
        else{
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            // Now you have the selected image URI, and you can use it as needed.
            // For example, you can display the image in imageView7.
            Glide.with(this).load(selectedImageUri).into(imageView7);
        }
    }



}
