package com.houarizegai.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginToGameActivity extends AppCompatActivity {

    EditText namePlayer1, namePlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_game);

        namePlayer1 = (EditText) findViewById(R.id.nameplayer1);
        namePlayer2 = (EditText) findViewById(R.id.nameplayer2);
    }

    public void onPlay(View view) {
        if(namePlayer1.getText() == null || namePlayer1.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please type the name of Player 1", Toast.LENGTH_SHORT).show();
            return;
        }
        if(namePlayer2.getText() == null || namePlayer2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please type the name of Player 2", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString("namePlayer1", namePlayer1.getText().toString().trim());
        bundle.putString("namePlayer2", namePlayer2.getText().toString().trim());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onExit(View view) {
        finish();
    }
}
