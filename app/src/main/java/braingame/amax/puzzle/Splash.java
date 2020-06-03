package braingame.amax.puzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    //-Блок переменных-//
    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;
    private TextView textView;
    //-Конец блока переменных-//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //-Создание прогресс бара-//
        progressBar= findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setScaleY(4f);
        textView= findViewById(R.id.count_progress_txt);
        textView.setText("");
        timer=new Timer();
        long period = 100;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            textView.setText(i +"%");
                        }
                    });
                    progressBar.setProgress(i);
                    i=i+2;
                }
                else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(Splash.this, HomePage.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);
        //-Конец создание прогресс бара-//
    }
}