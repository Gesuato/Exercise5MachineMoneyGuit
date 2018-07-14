package com.cryptog.exercise5machinemoney;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[][] slotValues = new int[3][3];
    private TextView[][] texts = new TextView[3][3];
    private Button btnGo;
    private int score = 0;
    private TextView textViewResult;

    private String[] letters = new String[] {"A","K","Q","J"};

    private int [] points = new int[]{100,20,5,1};

    private int[] colorLetters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorLetters = new int[]{
        ContextCompat.getColor(this, R.color.ColorA),ContextCompat.getColor(this, R.color.ColorK),
        ContextCompat.getColor(this, R.color.ColorQ),ContextCompat.getColor(this, R.color.ColorJ)
        };

        int[] textViewIds = new int[]{
                R.id.textView0,
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8
        };

        textViewResult = findViewById(R.id.textViewResult);

        // Linkando as referencias no textView
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                texts[i][j] = findViewById(textViewIds[3*i + j]);
            }
        }

        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                for (int i = 0;i < 3;i++) {
                    for(int k = 0;k < 3;k++){
                        slotValues[i][k] = random.nextInt(4);
                    }
                }

                // Setando os valores randomicos nos textView
                for(int i = 0;i < 3;i++) {
                    for (int j = 0; j < 3; j++) {
                        texts[i][j].setTextColor(formatedColor(slotValues[i][j]));
                        texts[i][j].setText(formatedLetre(slotValues[i][j]));
                    }
                }

                // valores na horizontal e vertical
                for (int i = 0; i < 3; i++) {
                    for(int j = 0;j < 4;j++){
                        if (j == slotValues[0][i] && j == slotValues[1][i] && j == slotValues[2][i]) {
                            System.out.println("vertical = " + formatedResult(j));
                            score = formatedResult(j);
                            textViewResult.setText(Integer.toString(score));
                        }

                        if (j == slotValues[i][0] && j == slotValues[i][1] && j == slotValues[i][2]) {
                            System.out.println("Horizontal = " + formatedResult(slotValues[i][0]));
                            score = formatedResult(j);
                            textViewResult.setText(Integer.toString(score));
                        }
                    }

                }

                // valores na diagonal
                for(int i = 0;i < 4;i++){
                    if( i == slotValues[0][0] && i == slotValues[1][1] && i == slotValues[2][2]){
                        System.out.println("Diagonal Esquerda = " + formatedResult(i));
                        score = formatedResult(i);
                        textViewResult.setText(Integer.toString(score));
                    }

                    if (i == slotValues[0][2] && i == slotValues[1][1] && i == slotValues[2][0]){
                        System.out.println("Diagonal Direita = " + formatedResult(i));
                        score = formatedResult(i);
                        textViewResult.setText(Integer.toString(score));
                    }
                }

            }
        });

    }

    public int formatedResult(int i){
        Log.d("valor",String.valueOf(score + points[i]));
    return score + points[i] ;

    }
    public String formatedLetre(int numeber){
        return letters[numeber];
    }

    public int formatedColor(int index){
        return colorLetters[index];
    }
}
