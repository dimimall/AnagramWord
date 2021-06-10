package gr.dimitra.anagramword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    private ImageView gifImageView;
    private final int SPLASH_DISPLAY_LENGTH = 8000;
    private String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getIntent().hasExtra("country")){
            country = getIntent().getStringExtra("country");
        }

        gifImageView = (ImageView) findViewById(R.id.gifImageView);

        playGif(country);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                mainIntent.putExtra("country",country);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    public void playGif(String country){

        if (country.equals("FRANCE")){
            Glide.with(this).asGif().load(R.drawable.france_map).into(gifImageView);
        }
        else if (country.equals("AUSTRALIA")){
            Glide.with(this).asGif().load(R.drawable.australia_gif).into(gifImageView);
        }
        else if (country.equals("ITALY")){
            Glide.with(this).asGif().load(R.drawable.italy_gif).into(gifImageView);
        }
        else if (country.equals("GREECE")){
            Glide.with(this).asGif().load(R.drawable.greece_gif).into(gifImageView);
        }
        else if (country.equals("EGYPT")) {
            Glide.with(this).asGif().load(R.drawable.egypt_gif).into(gifImageView);
        }
        else if (country.equals("BRAZIL")){
            Glide.with(this).asGif().load(R.drawable.brazil_gif).into(gifImageView);
        }
        else if (country.equals("UK")){
            Glide.with(this).asGif().load(R.drawable.uk_gif).into(gifImageView);
        }
    }
}