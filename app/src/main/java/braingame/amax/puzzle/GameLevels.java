package braingame.amax.puzzle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override//-ON-CREATED METHOD-//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //-Сохранения состояния-//
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 0);
        //-Конец сохранения состояния-//

        //-Скрытие строки состояния-//
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //-Конец скрытия строки состояния-//

        //-Обработка кнопки НАЗАД-//
        Button buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, HomePage.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки кнопки НАЗАД-//

        //-Обработка перехода на 1 увроень-//
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent(GameLevels.this, Level_01.class);
                    startActivity(intent1);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 1 увроень-//

        //-Обработка перехода на 2 увроень-//
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_02.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 2 увроень-//

        //-Обработка перехода на 3 увроень-//
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_03.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 3 увроень-//

        //-Обработка перехода на 4 увроень-//
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_04.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 4 увроень-//

        //-Обработка перехода на 5 увроень-//
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_05.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 5 увроень-//

        //-Обработка перехода на 6 увроень-//
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_06.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 6 увроень-//

        //-Обработка перехода на 7 увроень-//
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_07.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 7 увроень-//

        //-Обработка перехода на 8 увроень-//
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_08.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 8 увроень-//

        //-Обработка перехода на 9 увроень-//
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_09.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 9 увроень-//

        //-Обработка перехода на 10 увроень-//
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_010.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 10 увроень-//

        //-Обработка перехода на 11 увроень-//
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_011.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 11 увроень-//

        //-Обработка перехода на 12 увроень-//
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_012.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 12 увроень-//

        //-Обработка перехода на 13 увроень-//
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_013.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 13 увроень-//

        //-Обработка перехода на 14 увроень-//
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_014.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 14 увроень-//

        //-Обработка перехода на 15 увроень-//
        TextView textView15 = (TextView) findViewById(R.id.textView15);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_015.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 15 увроень-//

        //-Обработка перехода на 16 увроень-//
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_016.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 16 увроень-//

        //-Обработка перехода на 17 увроень-//
        TextView textView17 = (TextView) findViewById(R.id.textView17);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_017.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 17 увроень-//

        //-Обработка перехода на 18 увроень-//
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_018.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 18 увроень-//

        //-Обработка перехода на 19 увроень-//
        TextView textView19 = (TextView) findViewById(R.id.textView19);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_019.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 19 увроень-//

        //-Обработка перехода на 20 увроень-//
        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_020.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 20 увроень-//

        //-Обработка перехода на 21 увроень-//
        TextView textView21 = (TextView) findViewById(R.id.textView21);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_021.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 21 увроень-//

        //-Обработка перехода на 22 увроень-//
        TextView textView22 = (TextView) findViewById(R.id.textView22);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_022.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 22 увроень-//

        //-Обработка перехода на 23 увроень-//
        TextView textView23 = (TextView) findViewById(R.id.textView23);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_023.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 23 увроень-//

        //-Обработка перехода на 24 увроень-//
        TextView textView24 = (TextView) findViewById(R.id.textView24);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_024.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 24 увроень-//

        //-Обработка перехода на 25 увроень-//
        TextView textView25 = (TextView) findViewById(R.id.textView25);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_025.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 25 увроень-//

        //-Обработка перехода на 26 увроень-//
        TextView textView26 = (TextView) findViewById(R.id.textView26);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_026.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 26 увроень-//

        //-Обработка перехода на 27 увроень-//
        TextView textView27 = (TextView) findViewById(R.id.textView27);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_027.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 27 увроень-//

        //-Обработка перехода на 28 увроень-//
        TextView textView28 = (TextView) findViewById(R.id.textView28);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_028.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 28 увроень-//

        //-Обработка перехода на 29 увроень-//
        TextView textView29 = (TextView) findViewById(R.id.textView29);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_029.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 29 увроень-//

        //-Обработка перехода на 30 увроень-//
        TextView textView30 = (TextView) findViewById(R.id.textView30);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_030.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 30 увроень-//

        //-Обработка перехода на 31 увроень-//
        TextView textView31 = (TextView) findViewById(R.id.textView31);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_031.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 31 увроень-//

        //-Обработка перехода на 32 увроень-//
        TextView textView32 = (TextView) findViewById(R.id.textView32);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_032.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 32 увроень-//

        //-Обработка перехода на 33 увроень-//
        TextView textView33 = (TextView) findViewById(R.id.textView33);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_033.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 33 увроень-//

        //-Обработка перехода на 34 увроень-//
        TextView textView34 = (TextView) findViewById(R.id.textView34);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_034.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 34 увроень-//

        //-Обработка перехода на 35 увроень-//
        TextView textView35 = (TextView) findViewById(R.id.textView35);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_035.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 35 увроень-//

        //-Обработка перехода на 36 увроень-//
        TextView textView36 = (TextView) findViewById(R.id.textView36);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_036.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 36 увроень-//

        //-Обработка перехода на 37 увроень-//
        TextView textView37 = (TextView) findViewById(R.id.textView37);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_037.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 37 увроень-//

        //-Обработка перехода на 38 увроень-//
        TextView textView38 = (TextView) findViewById(R.id.textView38);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_038.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 38 увроень-//

        //-Обработка перехода на 39 увроень-//
        TextView textView39 = (TextView) findViewById(R.id.textView39);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_039.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 39 увроень-//

        //-Обработка перехода на 40 увроень-//
        TextView textView40 = (TextView) findViewById(R.id.textView40);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level == 1) {
                        Intent intent1 = new Intent(GameLevels.this, Level_040.class);
                        startActivity(intent1);
                        finish();
                    }
                } catch (Exception e) {
                }
            }
        });
        //-Конец обработки перехода на 40 увроень-//

        final int[] x = {
//                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
                R.id.textView16,
                R.id.textView17,
                R.id.textView18,
                R.id.textView19,
                R.id.textView20,
                R.id.textView21,
                R.id.textView22,
                R.id.textView23,
                R.id.textView24,
                R.id.textView25,
                R.id.textView26,
                R.id.textView27,
                R.id.textView28,
                R.id.textView29,
                R.id.textView30,
                R.id.textView31,
                R.id.textView32,
                R.id.textView33,
                R.id.textView34,
                R.id.textView35,
                R.id.textView36,
                R.id.textView37,
                R.id.textView38,
                R.id.textView39,
                R.id.textView40,
        };
        for (int i = 0; i < level; i++) {
            TextView tv = findViewById(x[i]);
            tv.setBackgroundResource(R.drawable.text_link_style);
            tv.setTextColor(Color.WHITE);

        }

    }//-Конец ON-CREATED METHOD-//

    //-Обработка нажатия системной кнопки BACK-//
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, HomePage.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
    //-Конец обработки нажатия системной кнопки BACK-//


}//-Конец class GameLevels-//
