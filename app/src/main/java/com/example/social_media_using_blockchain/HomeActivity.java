

package com.example.social_media_using_blockchain;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    private ImageView sound_dis;
    private ImageView imageView7;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         intit();
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


    }

    private void intit() {
        imageView7 = findViewById(R.id.imageView7); // Initialize the imageView7

        Glide.with(this).load(R.drawable.add).into(imageView7);
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
