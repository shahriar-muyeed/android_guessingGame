package com.example.guessing_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private int r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumber();

    }

    private void randomNumber(){
        if(count<0)
        {
            count=0;
            Toast.makeText(this, "You lost!!!!!!!", Toast.LENGTH_SHORT).show();
        }


        Random rand=new Random();
        r1=rand.nextInt(99);
        while(true) {
            r2 = rand.nextInt(99);
            if(r1!=r2)
                break;
        }
        Button b1=findViewById(R.id.buttonLeft);
        b1.setText(Integer.toString(r1));
        Button b2=findViewById(R.id.buttonRight);
        b2.setText(Integer.toString(r2));
    }

    public void onClickLeft(View view) {
        if(r1>r2)
        {
            count++;
        }
        else {
            count--;
        }
        TextView txt=findViewById(R.id.Result);
        txt.setText("Points: "+ count);
        randomNumber();
    }

    public void onClickRight(View view) {
        if(r1<r2)
        {
            count++;
        }
        else{
            count--;
        }
        TextView txt=findViewById(R.id.Result);
        txt.setText("Points: "+ count);
        randomNumber();
    }

}
