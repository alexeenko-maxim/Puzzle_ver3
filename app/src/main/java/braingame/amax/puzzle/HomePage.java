package braingame.amax.puzzle;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.PublicKey;

public class HomePage extends AppCompatActivity {

    //-Блок переменных-//
    private long backPressedTime;
    private Toast backToast;
    public Dialog dialogAbout;
    Button btn_close_dialog;
    //-Конец блока переменных-//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //-Скрытие строки состояния-//
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //-Конец скрытия строки состояния-//

        //-Диалоговое окно "О ИГРЕ"-//
        dialogAbout = new Dialog(HomePage.this);
        dialogAbout.setContentView(R.layout.activity_dialog_about);
        btn_close_dialog = (Button)dialogAbout.findViewById(R.id.btn_close_dialog_about);
        //-Обработка кнопки ЗАКРЫТЬ в диалоговом окне-//
        btn_close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    dialogAbout.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //-Конец обработки кнопки ЗАКРЫТЬ в диалоговом окне-//
        //-Конец диалогового окна "О ИГРЕ"-//

        //-Обработка кнопки "ИГРАТЬ"-//
        Button btn_play = (Button) findViewById(R.id.home_btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomePage.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){              }
            }
        });
        //-Конец обработки кнопки "ИГРАТЬ"-//

        //-Обработка кнопки "О ИГРЕ"-//
        Button btn_about = (Button) findViewById(R.id.home_btn_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialogAbout.show();
                }catch (Exception e){                }
            }
        });
        //-Конец обработки кнопки "О ИГРЕ"-//

        //-Обработка кнопки "ВЫХОД"-//
        Button btn_exit = (Button) findViewById(R.id.home_btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   System.exit(0);
                }catch (Exception e){                }
            }
        });
        //-Конец обработки кнопки "ВЫХОД"-//

    }//-Конец ON-CREATED-//

    //-Обработка системной кнопки BACK-//
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
    //-Конец обработки системной кнопки BACK-//



}
