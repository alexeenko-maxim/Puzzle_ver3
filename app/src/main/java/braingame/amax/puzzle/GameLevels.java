package braingame.amax.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);
    //---------------Убираем строку состояния и название активити-----------------------------------
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //----------------------------------------------------------------------------------------------

    //----------------Button back event-------------------------------------------------------------
        Button buttonBack = (Button)findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){

                }
            }
        });
        //----------------end. Button back event----------------------------------------------------

        //------------textview1 ckick event---------------------------------------------------------
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent(GameLevels.this, Level_01.class);
                    startActivity(intent1);
                    finish();
                }
                catch (Exception e){

                }
            }
        });
        //------------------------------------------------------------------------------------------

        //------------textview2 ckick event---------------------------------------------------------
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent2 = new Intent(GameLevels.this, Level_02.class);
                    startActivity(intent2);
                    finish();
                }
                catch (Exception e){

                }
            }
        });
        //------------end. textview2 ckick event----------------------------------------------------

    }




    //----------System button_back event---------------
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, HomePage.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }
    //----------edn. System button_back event---------------
}
