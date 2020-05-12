package braingame.amax.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

//--------var block---------------

private long backPressedTime;
private Toast backToast;

//----- end. var block------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//--------------------Убираем строку состояния и название активити-----------------------------------------
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//----------------------------------------------------------------------------------------------------------


        Button buttonPlay = (Button)findViewById(R.id.btn_play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomePage.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }

//----------System button_back event---------------

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

//----------edn. System button_back event---------------
}
