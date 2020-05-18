package braingame.amax.puzzle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Level_035 extends AppCompatActivity {

    //-Блок переменных-//
    private static GestureDetectGridView35 mGridView;
    public Button btn_back_to_game_levels;
    public Button btn_go_next_in_finishDialog;

    protected Button btn_close_hint;
    protected Button btn_openHint;
    public Dialog hint;
    protected SharedPreferences save;
    public static Dialog dialogFinish;
    private static final int COLLUMN = 6;
    private static final int DIMENSIONS = COLLUMN * COLLUMN;
    private static int mColumnWidth, mColumnHeight;
    public static String UP = "up";
    public static String DOWN = "down";
    public static String LEFT = "left";
    public static String RIGHT = "right";
    private static String[] tileList;
    public InterstitialAd interstitialAd;
    //-Конец Блока переменных-//

    @Override//-ON-CREATED METHOD-//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_035);
        //-Рекламный блок-//
        MobileAds.initialize(this, "ca-app-pub-6829999012626733~5810211480");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-6829999012626733/1372751959");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        //-Конец рекламного блока-//
        //-Закрытие рекламы на крестик-//
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                try {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Level", 36);
                    editor.apply();
                    Intent intent = new Intent(Level_035.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
        //-Конец закрытия рекламы на крестик-//
        //-Скрытие строки состояния-//
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //-Конец скрытия строки состояния-//

        //-Финишный диалог-//
        dialogFinish = new Dialog(this);
        dialogFinish.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogFinish.setContentView(R.layout.activity_end_level_dialog);
        Objects.requireNonNull(dialogFinish.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogFinish.setCancelable(false);
        btn_go_next_in_finishDialog = (Button)dialogFinish.findViewById(R.id.btn_go_next_in_finishDialog);

        //-Сохранение данных активности-//
        save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        //-Конец сохранения данных-//

        btn_go_next_in_finishDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>35){
                        //none
                    }else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", 36);
                        editor.apply();
                    }
                    dialogFinish.dismiss();
                    Intent intent = new Intent(Level_035.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    System.exit (0);
                }catch (Exception e) {               }
            }
        });
        //-Конец финишного диалога-//
        //-Диалог с подсказкой-//
        hint = new Dialog(this);
        hint.requestWindowFeature(Window.FEATURE_NO_TITLE);
        hint.setContentView(R.layout.activity_hint);
        Objects.requireNonNull(hint.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageView = (ImageView)hint.findViewById(R.id.img_hint);
        imageView.setBackgroundResource(R.drawable.lvl_35_full);
        btn_close_hint = (Button)hint.findViewById(R.id.close_hint_button);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        btn_close_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {hint.dismiss();}
                catch (Exception ignored) {}
            }
        });
        //-Обработка кнопки Закрыть подсказку-//
        btn_openHint = (Button)findViewById(R.id.btn_hint_lvl_035);
        btn_openHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hint.show();
                }catch (Exception e) {               }
            }
        });
        //-Конец обработки кнопки Закрыть подсказку-//
        //-Конец диалога с подсказкой-//



        //-Обработка кнопки назад-//
        btn_back_to_game_levels = (Button)findViewById(R.id.btn_back_lvl_02);
        btn_back_to_game_levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                    Intent intent = new Intent(Level_035.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    System.exit (0);
                }catch (Exception e) {               }
            }
        });
        //-Конец обработки кнопки назад-//

        init();//-запустить создание поля-//
        scramble();//-смешать пазлы-//
        setDimensions();

    }//-Конец ON-CREATED-//

    private void init() {

        mGridView = (GestureDetectGridView35) findViewById(R.id.grid_lvl_035);
        mGridView.setNumColumns(COLLUMN);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }//-метод создающий игровое поле-//

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length-1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }//-метод смешивания паззлов в случайном порядке-//

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int diplayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                mColumnWidth = diplayWidth / COLLUMN;
                mColumnHeight = requiredHeight / COLLUMN;

                display(getApplicationContext());
            }
        });
    }

    private int getStatusBarHeight (Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar", "dimen", "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;

        for (int i = 0; i < tileList.length; i++) {
            button = new Button(context);

            if (tileList[i].equals("0")) button.setBackgroundResource(R.drawable.lvl_35_img_part1);
            else if (tileList[i].equals("1")) button.setBackgroundResource(R.drawable.lvl_35_img_part2);
            else if (tileList[i].equals("2")) button.setBackgroundResource(R.drawable.lvl_35_img_part3);
            else if (tileList[i].equals("3")) button.setBackgroundResource(R.drawable.lvl_35_img_part4);
            else if (tileList[i].equals("4")) button.setBackgroundResource(R.drawable.lvl_35_img_part5);
            else if (tileList[i].equals("5")) button.setBackgroundResource(R.drawable.lvl_35_img_part6);
            else if (tileList[i].equals("6")) button.setBackgroundResource(R.drawable.lvl_35_img_part7);
            else if (tileList[i].equals("7")) button.setBackgroundResource(R.drawable.lvl_35_img_part8);
            else if (tileList[i].equals("8")) button.setBackgroundResource(R.drawable.lvl_35_img_part9);
            else if (tileList[i].equals("9")) button.setBackgroundResource(R.drawable.lvl_35_img_part10);
            else if (tileList[i].equals("10")) button.setBackgroundResource(R.drawable.lvl_35_img_part11);
            else if (tileList[i].equals("11")) button.setBackgroundResource(R.drawable.lvl_35_img_part12);
            else if (tileList[i].equals("12")) button.setBackgroundResource(R.drawable.lvl_35_img_part13);
            else if (tileList[i].equals("13")) button.setBackgroundResource(R.drawable.lvl_35_img_part14);
            else if (tileList[i].equals("14")) button.setBackgroundResource(R.drawable.lvl_35_img_part15);
            else if (tileList[i].equals("15")) button.setBackgroundResource(R.drawable.lvl_35_img_part16);
            else if (tileList[i].equals("16")) button.setBackgroundResource(R.drawable.lvl_35_img_part17);
            else if (tileList[i].equals("17")) button.setBackgroundResource(R.drawable.lvl_35_img_part18);
            else if (tileList[i].equals("18")) button.setBackgroundResource(R.drawable.lvl_35_img_part19);
            else if (tileList[i].equals("19")) button.setBackgroundResource(R.drawable.lvl_35_img_part20);
            else if (tileList[i].equals("20")) button.setBackgroundResource(R.drawable.lvl_35_img_part21);
            else if (tileList[i].equals("21")) button.setBackgroundResource(R.drawable.lvl_35_img_part22);
            else if (tileList[i].equals("22")) button.setBackgroundResource(R.drawable.lvl_35_img_part23);
            else if (tileList[i].equals("23")) button.setBackgroundResource(R.drawable.lvl_35_img_part24);
            else if (tileList[i].equals("24")) button.setBackgroundResource(R.drawable.lvl_35_img_part25);
            else if (tileList[i].equals("25")) button.setBackgroundResource(R.drawable.lvl_35_img_part26);
            else if (tileList[i].equals("26")) button.setBackgroundResource(R.drawable.lvl_35_img_part27);
            else if (tileList[i].equals("27")) button.setBackgroundResource(R.drawable.lvl_35_img_part28);
            else if (tileList[i].equals("28")) button.setBackgroundResource(R.drawable.lvl_35_img_part29);
            else if (tileList[i].equals("29")) button.setBackgroundResource(R.drawable.lvl_35_img_part30);
            else if (tileList[i].equals("30")) button.setBackgroundResource(R.drawable.lvl_35_img_part31);
            else if (tileList[i].equals("31")) button.setBackgroundResource(R.drawable.lvl_35_img_part32);
            else if (tileList[i].equals("32")) button.setBackgroundResource(R.drawable.lvl_35_img_part33);
            else if (tileList[i].equals("33")) button.setBackgroundResource(R.drawable.lvl_35_img_part34);
            else if (tileList[i].equals("34")) button.setBackgroundResource(R.drawable.lvl_35_img_part35);
            else if (tileList[i].equals("35")) button.setBackgroundResource(R.drawable.lvl_35_img_part36);

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));

    }

    public static void swapLvl_035(Context context, int currentPosition, int swap) throws InterruptedException {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved()) {
            //Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            dialogFinish.show();
        }
    } //-метод передвижения блоков-//

    public static void moveTilesLvl_035(Context context, String direction, int position) throws InterruptedException {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else if (direction.equals(DOWN)) swapLvl_035(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLLUMN - 1) {
            if (direction.equals(LEFT)) swapLvl_035(context, position, -1);
            else if (direction.equals(DOWN)) swapLvl_035(context, position, COLLUMN);
            else if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLLUMN - 1) {
            if (direction.equals(LEFT)) swapLvl_035(context, position, -1);
            else if (direction.equals(DOWN)) swapLvl_035(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLLUMN - 1 && position < DIMENSIONS - COLLUMN &&
                position % COLLUMN == 0) {
            if (direction.equals(UP)) swapLvl_035(context, position, - COLLUMN);
            else if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else if (direction.equals(DOWN)) swapLvl_035(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLLUMN * 2 - 1 || position == COLLUMN * 3 - 1) {
            if (direction.equals(UP)) swapLvl_035(context, position, - COLLUMN);
            else if (direction.equals(LEFT)) swapLvl_035(context, position, -1);
            else if (direction.equals(DOWN)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLLUMN - 1) swapLvl_035(context, position,
                        COLLUMN);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLLUMN) {
            if (direction.equals(UP)) swapLvl_035(context, position, -COLLUMN);
            else if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLLUMN) {
            if (direction.equals(UP)) swapLvl_035(context, position, -COLLUMN);
            else if (direction.equals(LEFT)) swapLvl_035(context, position, -1);
            else if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(UP)) swapLvl_035(context, position, -COLLUMN);
            else if (direction.equals(LEFT)) swapLvl_035(context, position, -1);
            else if (direction.equals(RIGHT)) swapLvl_035(context, position, 1);
            else swapLvl_035(context, position, COLLUMN);
        }
    }//-логика перестановки блоков-//

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))){
                solved = true;
            }
            else {
                solved = false;
                break;
            }
        }
        return solved;
    }//-условие победы-//

}//--Конец class Level_02--
