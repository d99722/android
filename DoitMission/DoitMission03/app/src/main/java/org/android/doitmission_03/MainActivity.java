package org.android.doitmission_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView01;
    ImageView imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView01 = findViewById(R.id.imageView01);
        imageView02 = findViewById(R.id.imageView02);

        Button button01 = findViewById(R.id.button01);



//        button01.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                moveImageUp();
//            }
//        });

        Button button02 = findViewById(R.id.button02);
//        button02.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                moveImageDown();
//            }
//        });

        moveImageUp();



    }

    public void onButton1Clicked(View v){
        moveImageUp();
    }

    public void onButton2Clicked(View v){
        moveImageDown();
    }

    private void moveImageDown(){
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.pho);

        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void moveImageUp(){
        imageView01.setImageResource(R.drawable.pho);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();
    }




}