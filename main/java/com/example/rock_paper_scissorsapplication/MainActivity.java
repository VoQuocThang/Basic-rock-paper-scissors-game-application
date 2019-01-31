package com.example.rock_paper_scissorsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    private static final String[] pics = {"rock","paper","scissors"};
    private int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        points=0;
    }

    private int chooseImag(){
        ImageView imag = $(R.id.computer);
        Random randy = new Random();
        int inx = randy.nextInt(3);
        switch (inx) {
            case(0):{
                imag.setImageResource(R.drawable.paper);
                break;
            }
            case(1):{
                imag.setImageResource(R.drawable.scissors);
                break;
            }
            case(2):{
                imag.setImageResource(R.drawable.rock);
                break;
            }
        }
        return inx;

    }
    private int win(int a,int b){
          if(b==2 && a==0) return -1;
          if(b==0 && a ==2) return 1;
          if(b==a) return 0;
          if(b>a) return 1;
          else return -1;
    }

    public void paper_click(View view) {
           ImageView imag = $(R.id.player);
           imag.setImageResource(R.drawable.paper);
           points+= win(chooseImag(),0);
           $TV(R.id.points).setText("YOUR SCORCE: "+points);
    }

    public void scissors_click(View view) {
        ImageView imag = $(R.id.player);
        imag.setImageResource(R.drawable.scissors);
        points+= win(chooseImag(),1);
        $TV(R.id.points).setText("YOUR SCORCE: "+points);
    }

    public void rock_click(View view) {
        ImageView imag = $(R.id.player);
        imag.setImageResource(R.drawable.rock);
        points+= win(chooseImag(),2);
        $TV(R.id.points).setText("YOUR SCORCE: "+points);
    }
}
