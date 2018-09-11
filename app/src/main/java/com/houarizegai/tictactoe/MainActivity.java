package com.houarizegai.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtPlayer1, txtPlayer2, txtScore;

    TextView txtPlayer;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private static String namePlayer1, namePlayer2;
    private int[] tablePlayer = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int scorePlayer1 = 0,
            scorePlayer2 = 0;

    // Active Player
    private boolean isPlayer1 = true;

    private final static String COLOR_PLAYER_1 = "#2196f3";
    private final static String COLOR_PLAYER_2 = "#03C9A9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundleData = getIntent().getExtras();
        namePlayer1 = bundleData.getString("namePlayer1");
        namePlayer2 = bundleData.getString("namePlayer2");

        initViews();
        addListenerToButton();
    }

    public void initViews() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtPlayer1 = (TextView) findViewById(R.id.txtPlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtPlayer2);
        txtPlayer = (TextView) findViewById(R.id.txtPlayer);

        txtPlayer.setText(namePlayer1);
        txtPlayer1.setText(namePlayer1);
        txtPlayer2.setText(namePlayer2);
    }

    public void addListenerToButton() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                if(tablePlayer[0] != 0) {
                    return;
                }
                tablePlayer[0]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn2: {
                if(tablePlayer[1] != 0) {
                    return;
                }
                tablePlayer[1]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn3: {
                if(tablePlayer[2] != 0) {
                    return;
                }
                tablePlayer[2]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn4: {
                if(tablePlayer[3] != 0) {
                    return;
                }
                tablePlayer[3]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn5: {
                if(tablePlayer[4] != 0) {
                    return;
                }
                tablePlayer[4]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn6: {
                if(tablePlayer[5] != 0) {
                    return;
                }
                tablePlayer[5]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn7: {
                if(tablePlayer[6] != 0) {
                    return;
                }
                tablePlayer[6]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn8: {
                if(tablePlayer[7] != 0) {
                    return;
                }
                tablePlayer[7]= isPlayer1 ? 1 : 2;
            } break;
            case R.id.btn9: {
                if(tablePlayer[8] != 0) {
                    return;
                }
                tablePlayer[8]= isPlayer1 ? 1 : 2;
            } break;
        }
        changeText((Button) v);
        checkWinner();
    }

    private void changeText(Button selectedBtn) {
        if(isPlayer1) {
            selectedBtn.setText("X");
            selectedBtn.setBackgroundColor(Color.parseColor(COLOR_PLAYER_1));
            txtPlayer.setText(namePlayer2);
            txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_2));
        } else {
            selectedBtn.setText("O");
            selectedBtn.setBackgroundColor(Color.parseColor(COLOR_PLAYER_2));
            txtPlayer.setText(namePlayer1);
            txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_1));
        }
        isPlayer1 = !isPlayer1;
    }

    private void checkWinner() {
        if(((tablePlayer[0] == tablePlayer[1]) && (tablePlayer[1] == tablePlayer[2])) && (tablePlayer[2] != 0) ||
            (tablePlayer[3] == tablePlayer[4]) && (tablePlayer[4] == tablePlayer[5]) && (tablePlayer[5] != 0) ||
            (tablePlayer[6] == tablePlayer[7] && (tablePlayer[7] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[0] == tablePlayer[3] && (tablePlayer[3] == tablePlayer[6])) && (tablePlayer[6] != 0) ||
            (tablePlayer[1] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[7])) && (tablePlayer[7] != 0) ||
            (tablePlayer[2] == tablePlayer[5] && (tablePlayer[5] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[0] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[2] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[6]) && (tablePlayer[6] != 0))
                ) {

            if(!isPlayer1)
                scorePlayer1++;
            else
                scorePlayer2++;
            txtScore.setText(scorePlayer1 + " - " + scorePlayer2);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("You Winner is : " + (!isPlayer1? namePlayer1 : namePlayer2) + "!")
            .setMessage("do you want to replay ?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    clear();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                //deprecated in API 26
                v.vibrate(500);
            }

            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        for(int item : tablePlayer) {
            if(item == 0)
                return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Draw")
                .setMessage("do you want to replay ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clear();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClear(View view) {
        clear();
    }

    public void onReset(View view) {
        clear();
        txtScore.setText("0 - 0");
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, LoginToGameActivity.class);
        startActivity(intent);
    }

    public void clear() {
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);

        btn1.setBackgroundColor(Color.parseColor("#ffffff"));
        btn2.setBackgroundColor(Color.parseColor("#ffffff"));
        btn3.setBackgroundColor(Color.parseColor("#ffffff"));
        btn4.setBackgroundColor(Color.parseColor("#ffffff"));
        btn5.setBackgroundColor(Color.parseColor("#ffffff"));
        btn6.setBackgroundColor(Color.parseColor("#ffffff"));
        btn7.setBackgroundColor(Color.parseColor("#ffffff"));
        btn8.setBackgroundColor(Color.parseColor("#ffffff"));
        btn9.setBackgroundColor(Color.parseColor("#ffffff"));

        for(int i = 0; i < tablePlayer.length; i++)
            tablePlayer[i] = 0;
        txtPlayer.setText(namePlayer1);
        txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_1));
    }

}
