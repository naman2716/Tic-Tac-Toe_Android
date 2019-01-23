package com.example.singh.tic_tac_toe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //yello - 0 and red - 1

    Integer activePlayer = 0;

    Integer[] gameStatus = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    Integer[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;


        System.out.println(counter.getTag().toString());
        Log.i("tag nO.", counter.getTag().toString());

        Integer counterTag = Integer.parseInt(counter.getTag().toString());

        if (gameStatus[counterTag] == 2) {
            counter.setTranslationY(-2000f);

            gameStatus[counterTag] = activePlayer;

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yello);

                activePlayer = 1;
            } else if (activePlayer == 1) {
                counter.setImageResource(R.drawable.red);

                activePlayer = 0;
            }

            counter.animate()
                    .rotation(360f)
                    .translationYBy(2000f)
                    .setDuration(300);

            for (Integer[] winningPosition : winningPositions) {
                if (gameStatus[winningPosition[0]] == gameStatus[winningPosition[1]] &&
                        gameStatus[winningPosition[1]] == gameStatus[winningPosition[2]] &&
                        gameStatus[winningPosition[0]] != 2) {
                    System.out.println(gameStatus[winningPosition[0]]);

//                    Toast.makeText(MainActivity.this, "Win "+String.valueOf(activePlayer), Toast.LENGTH_SHORT).show();

//                    Intent i = new Intent(MainActivity.this , playagain.class  );
//                    i.putExtra("win",String.valueOf(activePlayer));
//                    startActivity(i);
//                    finish();

                    String winner = "Player "+String.valueOf(activePlayer)+" Win";
                    GameFinish(winner);
                }
            }

        } else {
            Toast.makeText(this, "TRY ANOTHER LOCATION", Toast.LENGTH_SHORT).show();
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Tic Tac TOE");





    }


    void GameFinish(String winner){


        AlertDialog.Builder builder = new  AlertDialog.Builder(MainActivity.this);

        // Set the alert dialog title
        builder.setTitle(winner);

        // Display a message on alert dialog
        builder.setMessage("Do you Want to Play Again or Quit?");


        builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               finish();
            }
        });
       builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

               Button btnPlayAgain = findViewById(R.id.btnPlayAgain);
               ImageView imgPlayAgain = findViewById(R.id.imgPlayAgain);
               btnPlayAgain.setVisibility(View.VISIBLE);
               imgPlayAgain.setVisibility(View.VISIBLE);

               btnPlayAgain.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(MainActivity.this,MainActivity.class));
                   }
               });


           }
       });



        // Finally, make the alert dialog using builder
        AlertDialog dialog  = builder.create();

        // Display the alert dialog on app interface
        dialog.show();





    }
}
