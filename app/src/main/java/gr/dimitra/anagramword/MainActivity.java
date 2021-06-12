package gr.dimitra.anagramword;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.transition.MaterialElevationScale;

import java.io.IOException;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView wordTv;
    private TextView timeTv;
    private TextView liveTv;
    private TextView highscoretext;
    private EditText wordEnteredTv;
    private Button validate, newGame;
    private String wordToFind;

    private static final long START_TIME_IN_MILLIS = 400000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private int[] lives = new int[4];
    private int len = lives.length;
    private int count = 0;
    private MediaPlayer mediaPlayer;
    private String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordTv = (TextView) findViewById(R.id.wordTv);
        timeTv = (TextView) findViewById(R.id.timeText);
        liveTv = (TextView) findViewById(R.id.liveText);
        liveTv.setText("Lives: "+lives.length);
        highscoretext = (TextView) findViewById(R.id.animator);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(this);

        if (getIntent().hasExtra("country")){
            country = getIntent().getStringExtra("country");
        }

        newGame();
        startTimer();
    }

    @Override
    public void onClick(View view) {

        if (view == validate) {
            validate();
        } else if (view == newGame) {
            newGame();
        }
    }

    private void validate() {
        String w = wordEnteredTv.getText().toString();

        if (wordToFind.equals(w)) {
            Toast.makeText(this, "Congratulations ! You found the word " + wordToFind, Toast.LENGTH_SHORT).show();
            playMusic(R.raw.app_src_main_res_raw_correct);
            viewValueAnimator();
            //count = count+5;
            Log.d("dimitra","count "+count);
            newGame();
            startTimer();
        } else {
            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show();
            playMusic(R.raw.app_src_main_res_raw_wrong);
            len--;
            lives = new int[len];
            liveTv.setText(""+lives.length);
            resetTimer();
        }
        if (lives.length == 0){
            Toast.makeText(this, "Loose !", Toast.LENGTH_SHORT).show();
            newGame();
            startTimer();
        }
        if (count >= 55){
            Intent intent = new Intent(MainActivity.this,WinActivity.class);
            startActivity(intent);
        }
    }

    private void newGame() {
        if (country.equals("GREECE"))
            wordToFind = AnagmamClass.randomWordGreece();
        else if (country.equals("UK"))
            wordToFind = AnagmamClass.randomWordUk();
        else if (country.equals("BRAZIL"))
            wordToFind = AnagmamClass.randomWordBrazil();
        else if (country.equals("AUSTRALIA"))
            wordToFind = AnagmamClass.randomWordAustralia();
        else if (country.equals("FRANCE"))
            wordToFind = AnagmamClass.randomWordFrance();
        else if (country.equals("EGYPT"))
            wordToFind = AnagmamClass.randomWordEgypt();
        else
            wordToFind = AnagmamClass.randomWordItaly();

        String wordShuffled = AnagmamClass.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timeTv.setText(timeLeftFormatted);
    }

    private void playMusic(int id){
        AssetFileDescriptor file = getResources().openRawResourceFd(id);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();//Let the Mediaplayer enter the ready state
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public void viewValueAnimator(){
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(count, count+5);// here you set the range, from 0 to "count" value
        //animator.setRepeatCount(5);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                highscoretext.setText("Score: "+String.valueOf(animation.getAnimatedValue()));
                count = (Integer)animation.getAnimatedValue();
            }
        });
        animator.setDuration(1000); // here you set the duration of the anim
        animator.start();
    }
}