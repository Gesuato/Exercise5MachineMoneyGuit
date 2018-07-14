package com.cryptog.exercise5machinemoney;

import android.graphics.drawable.Drawable;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
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

                        }

                        if (j == slotValues[i][0] && j == slotValues[i][1] && j == slotValues[i][2]) {
                            System.out.println("Horizontal = " + formatedResult(slotValues[i][0]));
                            score = formatedResult(j);

                        }
                    }

                }

                // valores na diagonal
                for(int i = 0;i < 4;i++){
                    if( i == slotValues[0][0] && i == slotValues[1][1] && i == slotValues[2][2]){
                        System.out.println("Diagonal Esquerda = " + formatedResult(i));
                        score = formatedResult(i);

                    }

                    if (i == slotValues[0][2] && i == slotValues[1][1] && i == slotValues[2][0]){
                        System.out.println("Diagonal Direita = " + formatedResult(i));
                        score = formatedResult(i);
                    }
                }
                rollImage();

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

    public void rollImage(){

        final int[] rollImageNumber = {0};

        final ImageView imageView0 = findViewById(R.id.imageView0);
        final ImageView imageView1 = findViewById(R.id.imageView1);
        final ImageView imageView2 = findViewById(R.id.imageView2);
        final ImageView imageView3 = findViewById(R.id.imageView3);
        final ImageView imageView4 = findViewById(R.id.imageView4);
        final ImageView imageView5 = findViewById(R.id.imageView5);
        final ImageView imageView6 = findViewById(R.id.imageView6);
        final ImageView imageView7 = findViewById(R.id.imageView7);
        final ImageView imageView8 = findViewById(R.id.imageView8);


        // 1 table row

        //image0
        final SpringAnimation anim1Image0 = new SpringAnimation(imageView0, DynamicAnimation.TRANSLATION_X,  600);
        final SpringAnimation anim2Image0 = new SpringAnimation(imageView0, DynamicAnimation.TRANSLATION_X,  0);


        //image1
        final SpringAnimation anim1Image1 = new SpringAnimation(imageView1, DynamicAnimation.TRANSLATION_X,  -300);
        final SpringAnimation anim2Image1 = new SpringAnimation(imageView1, DynamicAnimation.TRANSLATION_X,  300);
        final SpringAnimation anim3Image1 = new SpringAnimation(imageView1, DynamicAnimation.TRANSLATION_X,  0);

        //image2
        final SpringAnimation anim1Image2 = new SpringAnimation(imageView2, DynamicAnimation.TRANSLATION_X,  -600);
        final SpringAnimation anim2Image2 = new SpringAnimation(imageView2, DynamicAnimation.TRANSLATION_X,  0);



        // 2 table Row

        //image3
        final SpringAnimation anim1Image3 = new SpringAnimation(imageView3, DynamicAnimation.TRANSLATION_X,  600);
        final SpringAnimation anim2Image3 = new SpringAnimation(imageView3, DynamicAnimation.TRANSLATION_X,  0);

        //image4
        final SpringAnimation anim1Image4 = new SpringAnimation(imageView4, DynamicAnimation.TRANSLATION_X,  -300);
        final SpringAnimation anim2Image4 = new SpringAnimation(imageView4, DynamicAnimation.TRANSLATION_X,  300);
        final SpringAnimation anim3Image4 = new SpringAnimation(imageView4, DynamicAnimation.TRANSLATION_X,  0);

        // image5
        final SpringAnimation anim1Image5 = new SpringAnimation(imageView5, DynamicAnimation.TRANSLATION_X,  -600);
        final SpringAnimation anim2Image5 = new SpringAnimation(imageView5, DynamicAnimation.TRANSLATION_X,  0);


        // table row 3
        //image6
        final SpringAnimation anim1Image6 = new SpringAnimation(imageView6, DynamicAnimation.TRANSLATION_X,  600);
        final SpringAnimation anim2Image6 = new SpringAnimation(imageView6, DynamicAnimation.TRANSLATION_X,  0);

        //image7
        final SpringAnimation anim1Image7 = new SpringAnimation(imageView7, DynamicAnimation.TRANSLATION_X,  -300);
        final SpringAnimation anim2Image7 = new SpringAnimation(imageView7, DynamicAnimation.TRANSLATION_X,  300);
        final SpringAnimation anim3Image7 = new SpringAnimation(imageView7, DynamicAnimation.TRANSLATION_X,  0);

        // image8
        final SpringAnimation anim1Image8 = new SpringAnimation(imageView8, DynamicAnimation.TRANSLATION_X,  -600);
        final SpringAnimation anim2Image8 = new SpringAnimation(imageView8, DynamicAnimation.TRANSLATION_X,  0);


        // animacoes 1 start
        anim1Image0.start();
        anim1Image1.start();
        anim1Image2.start();
        anim1Image3.start();
        anim1Image4.start();
        anim1Image5.start();
        anim1Image6.start();
        anim1Image7.start();
        anim1Image8.start();


        // table row 1
        //image0
        anim1Image0.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image0.start();

            }
        });

        anim2Image0.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
               if(rollImageNumber[0] < 3) {
                   anim1Image0.start();
               }
            }
        });

        // image1

        anim1Image1.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image1.start();
            }
        });

        anim2Image1.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim3Image1.start();
            }
        });
        anim3Image1.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
         if(rollImageNumber[0] < 3){
             anim1Image1.start();
         }else{
             textViewResult.setText(Integer.toString(score));
         }
         rollImageNumber[0]++;

            }
        });

        // image2

        anim1Image2.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image2.start();

            }
        });

        anim2Image2.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
            if(rollImageNumber[0] < 3) {
                anim1Image2.start();
            }
            }
        });


        // table row 2
        // image3

        anim1Image3.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image3.start();

            }
        });

        anim2Image3.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3) {
                    anim1Image3.start();
                }
            }
        });

        // image4

        anim1Image4.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image4.start();
            }
        });

        anim2Image4.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim3Image4.start();
            }
        });
        anim3Image4.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3){
                    anim1Image4.start();
                }

            }
        });

        // image5

        anim1Image5.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image5.start();

            }
        });

        anim2Image5.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3) {
                    anim1Image5.start();
                }
            }
        });


        // table row 3
        // image6

        anim1Image6.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image6.start();

            }
        });

        anim2Image6.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3) {
                    anim1Image6.start();
                }
            }
        });

        // image7

        anim1Image7.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image7.start();
            }
        });

        anim2Image7.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim3Image7.start();
            }
        });
        anim3Image7.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3){
                    anim1Image7.start();
                }

            }
        });

        // image8

        anim1Image8.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Image8.start();

            }
        });

        anim2Image8.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(rollImageNumber[0] < 3) {
                    anim1Image8.start();
                }
            }
        });
    }

}
