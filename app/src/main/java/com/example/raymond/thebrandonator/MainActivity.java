package com.example.raymond.thebrandonator;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    //array of images
    int imageNo[]={R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4};
    //amt of images
    int countImage = imageNo.length;
    //get image pos
    int currentImage = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add button and imageviewer to fetch id
        Button nextImage=(Button)findViewById(R.id.btnNext);
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageChanger);

        //code to use image switcher
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                //add Imageview dynamically
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                //Picasso.with(context).load(new File(path/to/File)).fit().centerCrop().into(imageView);
                return imageView;
            }

        });

        //animations
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        //set the animations
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        //button onclick listener
        nextImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //change images on button press
                currentImage++;
                if(currentImage >= countImage) {
                    currentImage = 0;
                }
                //display the image in the switcher
                imageSwitcher.setImageResource(imageNo[currentImage]);

            }
        });
    }
}
