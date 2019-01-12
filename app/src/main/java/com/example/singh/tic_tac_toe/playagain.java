package com.example.singh.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class playagain extends AppCompatActivity {
    TextView tvWin;
    Button btnAgain;
    String str ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playagain);
        tvWin= findViewById(R.id.tvWin);
        btnAgain=  findViewById(R.id.btnAgain);
        tvWin.setText(getIntent().getExtras().getString("win"));
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playagain.this,MainActivity.class));
                finish();
            }
        });


    }

}
