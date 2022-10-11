package com.zakiralekperov.flashapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonFlash;
    private FlashClass flashClass;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        buttonFlash = findViewById(R.id.buttonFlash);
        constraintLayout = findViewById(R.id.constraintLayout);
        flashClass = new FlashClass(this);
    }
    public void onClickFlash(View view){

        if(flashClass.isFlash_on()){
            flashClass.flashOff();
            buttonFlash.setText(R.string.on);
            constraintLayout.setBackgroundResource(R.color.black);
        }
        else{
            flashClass.flashOn();
            buttonFlash.setText(R.string.off);
            constraintLayout.setBackgroundResource(R.color.white);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_on()){
            flashClass.flashOff();
        }
    }
}