package com.example.raymond.thebrandonator;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //array of images
    int imageNo[]={R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4};
    //amt of images
    int countImage = imageNo.length;
    //get image pos
    int currentImage = -1;

    //text array
    String myText[] = {"Hindsight is 4:20. - Luubricator", "Just want a piece of Percy's ass, ya know? - Luudysseus",
            "It's lit - Luum", "Is it better to have memed and lost, than to have never memed at all? - Marcus Aurelius",
            "People don't think it be how it be, but it do - Brandon 'Smokes' DaGrasse Tyson",
            "'I'll be Frank, guys-' - Marluu Brando, '-Okay, I'll be Raymond' - Raymond"};
    int currentText = -1;
    int countText = myText.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add button and imageviewer and textviewer to fetch id
        Button nextImage=(Button)findViewById(R.id.btnNext);
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageChanger);
        final TextSwitcher textSwitcher = (TextSwitcher)  findViewById(R.id.switchText);
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

        //code to use textSwitcher
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                //add Imageview dynamically
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(24);
                myText.setTextColor(Color.WHITE);
                return myText;
            }

        });
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

                //change text on button press
                currentText++;
                if(currentText >= countText) {
                    currentText = 0;
                }
                textSwitcher.setText(myText[currentText]);

            }
        });
    }
}
