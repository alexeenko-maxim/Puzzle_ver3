package braingame.amax.puzzle;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class HomePage extends AppCompatActivity {

    //-Блок переменных-//
    private long mBackPressedTime;
    private Toast mBackToast;
    private Dialog mDialogAbout;
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
        mDialogAbout = new Dialog(HomePage.this);
        mDialogAbout.setContentView(R.layout.activity_dialog_about);
        Button btn_close_dialog = mDialogAbout.findViewById(R.id.btn_close_dialog_about);
        //-Обработка кнопки ЗАКРЫТЬ в диалоговом окне-//
        btn_close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mDialogAbout.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //-Конец обработки кнопки ЗАКРЫТЬ в диалоговом окне-//
        //-Конец диалогового окна "О ИГРЕ"-//

        //-Обработка кнопки "ИГРАТЬ"-//
        Button mBtn_play = findViewById(R.id.home_btn_play);
        mBtn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomePage.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    System.exit (0);
                }catch (Exception ignored){              }
            }
        });
        //-Конец обработки кнопки "ИГРАТЬ"-//

        //-Обработка кнопки "О ИГРЕ"-//
        Button mBtn_about = findViewById(R.id.home_btn_about);
        mBtn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mDialogAbout.show();
                }catch (Exception ignored){                }
            }
        });
        //-Конец обработки кнопки "О ИГРЕ"-//

        //-Обработка кнопки "ВЫХОД"-//
        Button mBtn_exit = findViewById(R.id.home_btn_exit);
        mBtn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   System.exit(0);
                }catch (Exception ignored){                }
            }
        });
        //-Конец обработки кнопки "ВЫХОД"-//

    }//-Конец ON-CREATED-//

    //-Обработка системной кнопки BACK-//
    @Override
    public void onBackPressed() {
        if (mBackPressedTime + 2000 > System.currentTimeMillis()){
            mBackToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            mBackToast = Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            mBackToast.show();
        }
        mBackPressedTime = System.currentTimeMillis();
    }
    //-Конец обработки системной кнопки BACK-//



}
