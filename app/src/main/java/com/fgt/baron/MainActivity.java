package com.fgt.baron;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    Button btnTutorial, btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        btnTutorial = (Button)findViewById(R.id.btnTutorial);
        btnGet = (Button)findViewById(R.id.btnGet);
    }

    private void action() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGet.setAnimation(buttonClick);
                Intent goHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(goHome);
            }
        });

        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTutorial.setAnimation(buttonClick);
                Intent goHome = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(goHome);
            }
        });
    }
}
