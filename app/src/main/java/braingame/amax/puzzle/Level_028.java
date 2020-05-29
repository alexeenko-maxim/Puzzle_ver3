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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Level_028 extends AppCompatActivity {

    //-Блок переменных-//
    private static GestureDetectGridView28 mGridView;

    private Dialog hint;
    private SharedPreferences save;
    private static Dialog dialogFinish;
    private static final int COLLUMN = 5;
    private static final int DIMENSIONS = COLLUMN * COLLUMN;
    private static int mColumnWidth, mColumnHeight;
    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    private static String[] tileList;
    private InterstitialAd interstitialAd;
    //-Конец Блока переменных-//

    @Override//-ON-CREATED METHOD-//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_028);
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
                    editor.putInt("Level", 29);
                    editor.apply();
                    Intent intent = new Intent(Level_028.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception ignored) {

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
        Button btn_go_next_in_finishDialog = dialogFinish.findViewById(R.id.btn_go_next_in_finishDialog);

        //-Сохранение данных активности-//
        save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        //-Конец сохранения данных-//

        btn_go_next_in_finishDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>28){
                        //none
                    }else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", 29);
                        editor.apply();
                    }
                    dialogFinish.dismiss();
                    Intent intent = new Intent(Level_028.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    System.exit (0);
                }catch (Exception ignored) {               }
            }
        });
        //-Конец финишного диалога-//
        //-Диалог с подсказкой-//
        hint = new Dialog(this);
        hint.requestWindowFeature(Window.FEATURE_NO_TITLE);
        hint.setContentView(R.layout.activity_hint);
        Objects.requireNonNull(hint.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageView = hint.findViewById(R.id.img_hint);
        imageView.setBackgroundResource(R.drawable.lvl_28_full);
        Button btn_close_hint = hint.findViewById(R.id.close_hint_button);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        btn_close_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {hint.dismiss();}
                catch (Exception ignored) {}
            }
        });
        //-Обработка кнопки Закрыть подсказку-//
        Button btn_openHint = findViewById(R.id.btn_hint_lvl_028);
        btn_openHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hint.show();
                }catch (Exception ignored) {               }
            }
        });
        //-Конец обработки кнопки Закрыть подсказку-//
        //-Конец диалога с подсказкой-//



        //-Обработка кнопки назад-//
        Button btn_back_to_game_levels = findViewById(R.id.btn_back_lvl_02);
        btn_back_to_game_levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                    Intent intent = new Intent(Level_028.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    System.exit (0);
                }catch (Exception ignored) {               }
            }
        });
        //-Конец обработки кнопки назад-//

        init();//-запустить создание поля-//
        scramble();//-смешать пазлы-//
        setDimensions();

    }//-Конец ON-CREATED-//

    private void init() {

        mGridView = findViewById(R.id.grid_lvl_028);
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

        for (String s : tileList) {
            button = new Button(context);

            switch (s) {
                case "0":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part1);
                    break;
                case "1":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part2);
                    break;
                case "2":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part3);
                    break;
                case "3":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part4);
                    break;
                case "4":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part5);
                    break;
                case "5":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part6);
                    break;
                case "6":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part7);
                    break;
                case "7":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part8);
                    break;
                case "8":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part9);
                    break;
                case "9":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part10);
                    break;
                case "10":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part11);
                    break;
                case "11":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part12);
                    break;
                case "12":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part13);
                    break;
                case "13":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part14);
                    break;
                case "14":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part15);
                    break;
                case "15":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part16);
                    break;
                case "16":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part17);
                    break;
                case "17":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part18);
                    break;
                case "18":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part19);
                    break;
                case "19":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part20);
                    break;
                case "20":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part21);
                    break;
                case "21":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part22);
                    break;
                case "22":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part23);
                    break;
                case "23":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part24);
                    break;
                case "25":
                    button.setBackgroundResource(R.drawable.lvl_28_img_part25);
                    break;
            }

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));

    }

    private static void swapLvl_028(Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved()) {
            //Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            dialogFinish.show();
        }
    } //-метод передвижения блоков-//

    public static void moveTilesLvl_028(Context context, String direction, int position) {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(RIGHT)) swapLvl_028(context, position, 1);
            else if (direction.equals(DOWN)) swapLvl_028(context, position, COLLUMN);


            // Upper-center tiles
        } else if (position > 0 && position < COLLUMN - 1) {
            switch (direction) {
                case LEFT:
                    swapLvl_028(context, position, -1);
                    break;
                case DOWN:
                    swapLvl_028(context, position, COLLUMN);
                    break;
                case RIGHT:
                    swapLvl_028(context, position, 1);
                    break;
                default:

                    break;
            }

            // Upper-right-corner tile
        } else if (position == COLLUMN - 1) {
            if (direction.equals(LEFT)) swapLvl_028(context, position, -1);
            else if (direction.equals(DOWN)) swapLvl_028(context, position, COLLUMN);


            // Left-side tiles
        } else if (position > COLLUMN - 1 && position < DIMENSIONS - COLLUMN &&
                position % COLLUMN == 0) {
            switch (direction) {
                case UP:
                    swapLvl_028(context, position, -COLLUMN);
                    break;
                case RIGHT:
                    swapLvl_028(context, position, 1);
                    break;
                case DOWN:
                    swapLvl_028(context, position, COLLUMN);
                    break;
                default:

                    break;
            }

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLLUMN * 2 - 1 || position == COLLUMN * 3 - 1) {
            switch (direction) {
                case UP:
                    swapLvl_028(context, position, -COLLUMN);
                    break;
                case LEFT:
                    swapLvl_028(context, position, -1);
                    break;
                case DOWN:

                    // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                    // right-corner tile.
                    if (position <= DIMENSIONS - COLLUMN - 1) swapLvl_028(context, position,
                            COLLUMN);
                    else
                    break;
                default:

                    break;
            }

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLLUMN) {
            if (direction.equals(UP)) swapLvl_028(context, position, -COLLUMN);
            else if (direction.equals(RIGHT)) swapLvl_028(context, position, 1);


            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLLUMN) {
            switch (direction) {
                case UP:
                    swapLvl_028(context, position, -COLLUMN);
                    break;
                case LEFT:
                    swapLvl_028(context, position, -1);
                    break;
                case RIGHT:
                    swapLvl_028(context, position, 1);
                    break;
                default:

                    break;
            }

            // Center tiles
        } else {
            switch (direction) {
                case UP:
                    swapLvl_028(context, position, -COLLUMN);
                    break;
                case LEFT:
                    swapLvl_028(context, position, -1);
                    break;
                case RIGHT:
                    swapLvl_028(context, position, 1);
                    break;
                default:
                    swapLvl_028(context, position, COLLUMN);
                    break;
            }
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
