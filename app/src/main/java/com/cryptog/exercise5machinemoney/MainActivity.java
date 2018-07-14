package com.cryptog.exercise5machinemoney;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[][] slotValues = new int[3][3];
    private ImageView[][] tableImages = new ImageView[3][3];
    private Button btnGo;
    private int score = 0;
    private TextView textViewResult;
    private Drawable[] imagesResult;
    private int [] points = new int[]{100,20,5,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesResult = new Drawable[]{ContextCompat.getDrawable(this,R.drawable.rabbitfacingright),ContextCompat.getDrawable(this,R.drawable.elephantfacingright),
                ContextCompat.getDrawable(this,R.drawable.dromedaryfacingright),ContextCompat.getDrawable(this,R.drawable.deerfacingright)};


        int[] textViewIds = new int[]{
                R.id.imageView0,
                R.id.imageView1,
                R.id.imageView2,
                R.id.imageView3,
                R.id.imageView4,
                R.id.imageView5,
                R.id.imageView6,
                R.id.imageView7,
                R.id.imageView8
        };

        textViewResult = findViewById(R.id.textViewResult);

        // Linkando as referencias no textView
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                tableImages[i][j] = findViewById(textViewIds[3*i + j]);
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
                        tableImages[i][j].setImageDrawable(formatedImage(slotValues[i][j]));
//                        texts[i][j].setText(formatedLetre(slotValues[i][j]));
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
    public Drawable formatedImage(int numeber){
        return imagesResult[numeber];
    }


}
