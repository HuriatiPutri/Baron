package com.fgt.baron;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

public class ForgetPasswordActivity extends AppCompatActivity {

    ImageButton btnNext;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        btnNext = (ImageButton)findViewById(R.id.btnNext);
    }

    private void action() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.startAnimation(buttonClick);
                Intent goInfoForget = new Intent(getApplicationContext(), InformasiForgetActivity.class);
                startActivity(goInfoForget);
                finish();
            }
        });
    }

}
