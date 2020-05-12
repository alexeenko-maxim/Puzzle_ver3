package braingame.amax.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Level_01 extends AppCompatActivity {

    //--------------------------------------Блок переменных-----------------------------------------
    private static GestureDetectGridView mGridView;
    public Button btn_play_preview;
    public Button btn_back_to_game_levels;

    public static Dialog dialogStart;
    public static Dialog dialogFinish;
    private static final int COLLUMN = 4;
    private static final int DIMENSIONS = COLLUMN * COLLUMN;
    private static int mColumnWidth, mColumnHeight;
    public static String UP = "up";
    public static String DOWN = "down";
    public static String LEFT = "left";
    public static String RIGHT = "right";
    private static String[] tileList;
    //----------------------------------------------------------------------------------------------

    //-------------------------------------ON-CREATED METHOD----------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_01);
    //--------------------Убираем строку состояния и название активити------------------------------
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //----------------------------------------------------------------------------------------------

    //---------------------------------------Блок диалоговых окон-----------------------------------
        final Dialog dialogStart = new Dialog(this);
        dialogStart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogStart.setContentView(R.layout.activity_level_01_start_dialog);
        Objects.requireNonNull(dialogStart.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialogStart.setCancelable(false);
        btn_play_preview = dialogStart.findViewById(R.id.btn_start_lvl);
        btn_play_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialogStart.dismiss();
                }catch (Exception e) {                }
            }
        });

        Dialog dialogFinish = new Dialog(this);
        dialogFinish.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogFinish.setContentView(R.layout.activity_level_01_end_dialog);
        Objects.requireNonNull(dialogFinish.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialogFinish.setCancelable(false);
        btn_play_preview = (Button)dialogFinish.findViewById(R.id.btn_start_lvl);
        btn_play_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Level_01.dialogFinish.dismiss();
                }catch (Exception e) {               }
            }
        });
    //----------------------------------------------------------------------------------------------

    //------------------------------------Блок обработки кнопок-------------------------------------

        btn_back_to_game_levels = (Button)findViewById(R.id.btn_back_lvl_01);
        btn_back_to_game_levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level_01.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {               }
            }
        });

    //----------------------------------------------------------------------------------------------


    //--------------------------------Блок вызова методов-------------------------------------------
        dialogStart.show();//показать стартовый диалог
        init();//запустить создание поля
        scramble();//смешать пазлы
        setDimensions();
    //----------------------------------------------------------------------------------------------

    }//--Конец ON-CREATED---

    //-----------------------------------Блок обьявления методов------------------------------------

    private void init() {

        mGridView = (GestureDetectGridView) findViewById(R.id.grid_lvl_01);
        mGridView.setNumColumns(COLLUMN);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }//метод создающий игровое поле

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
    }//метод смешивания паззлов в случайном порядке

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

            if (tileList[i].equals("0")) button.setBackgroundResource(R.drawable.image_part_001);
            else if (tileList[i].equals("1")) button.setBackgroundResource(R.drawable.image_part_002);
            else if (tileList[i].equals("2")) button.setBackgroundResource(R.drawable.image_part_003);
            else if (tileList[i].equals("3")) button.setBackgroundResource(R.drawable.image_part_004);
            else if (tileList[i].equals("4")) button.setBackgroundResource(R.drawable.image_part_005);
            else if (tileList[i].equals("5")) button.setBackgroundResource(R.drawable.image_part_006);
            else if (tileList[i].equals("6")) button.setBackgroundResource(R.drawable.image_part_007);
            else if (tileList[i].equals("7")) button.setBackgroundResource(R.drawable.image_part_008);
            else if (tileList[i].equals("8")) button.setBackgroundResource(R.drawable.image_part_009);
            else if (tileList[i].equals("9")) button.setBackgroundResource(R.drawable.image_part_010);
            else if (tileList[i].equals("10")) button.setBackgroundResource(R.drawable.image_part_011);
            else if (tileList[i].equals("11")) button.setBackgroundResource(R.drawable.image_part_012);
            else if (tileList[i].equals("12")) button.setBackgroundResource(R.drawable.image_part_013);
            else if (tileList[i].equals("13")) button.setBackgroundResource(R.drawable.image_part_014);
            else if (tileList[i].equals("14")) button.setBackgroundResource(R.drawable.image_part_015);
            else if (tileList[i].equals("15")) button.setBackgroundResource(R.drawable.image_part_016);

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));

    }//метод отображения графики

    public static void swap(Context context, int currentPosition, int swap) throws InterruptedException {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved()) {
            Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();

        }
    } //метод передвижения блоков

    public static void moveTiles(Context context, String direction, int position) throws InterruptedException {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(RIGHT)) swap(context, position, 1);
            else if (direction.equals(DOWN)) swap(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLLUMN - 1) {
            if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) swap(context, position, COLLUMN);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLLUMN - 1) {
            if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) swap(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLLUMN - 1 && position < DIMENSIONS - COLLUMN &&
                position % COLLUMN == 0) {
            if (direction.equals(UP)) swap(context, position, - COLLUMN);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else if (direction.equals(DOWN)) swap(context, position, COLLUMN);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLLUMN * 2 - 1 || position == COLLUMN * 3 - 1) {
            if (direction.equals(UP)) swap(context, position, - COLLUMN);
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLLUMN - 1) swap(context, position,
                        COLLUMN);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLLUMN) {
            if (direction.equals(UP)) swap(context, position, -COLLUMN);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLLUMN) {
            if (direction.equals(UP)) swap(context, position, -COLLUMN);
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(UP)) swap(context, position, -COLLUMN);
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else swap(context, position, COLLUMN);
        }
    }//логика перестановки блоков

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
    }//условие победы
    //----------------------------------------------------------------------------------------------


}//--Конец class Level_01--


