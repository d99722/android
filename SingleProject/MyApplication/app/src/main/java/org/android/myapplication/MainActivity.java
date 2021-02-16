package org.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    EditText heightText;
    EditText weightText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightText = findViewById(R.id.height);
        weightText = findViewById(R.id.weight);
        button = findViewById(R.id.button);
        resultView = findViewById(R.id.result);

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    imm.hideSoftInputFromWindow(weightText.getWindowToken(),0);
                    double height = Double.parseDouble(heightText.getText().toString());
                    double weight = Double.parseDouble(weightText.getText().toString());
                    double bmi = Math.round(Calculate(height, weight)*100)/100.0;


                    resultView.setText(bmi+"\n메롱ㅋㅋ");


                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }

    public double Calculate(double height, double weight){
        return weight/((height/100)*(height/100));
    }

}