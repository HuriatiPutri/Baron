package com.fgt.baron;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

public class ChangeActivity extends AppCompatActivity {

    Button btnBelajar, btnMengajar;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        btnBelajar = (Button)findViewById(R.id.btnBelajar);
        btnMengajar = (Button)findViewById(R.id.btnMengajar);
    }

    private void action() {
        btnBelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBelajar.setAnimation(buttonClick);
                Intent goBelajar = new Intent(getApplicationContext(), DeskripsiMateriActivity.class);
                startActivity(goBelajar);
                finish();
                Toast.makeText(getApplicationContext(), "Anda Berada di Mode Belajar",Toast.LENGTH_SHORT).show();
            }
        });

        btnMengajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBelajar.setAnimation(buttonClick);
                Intent goMengajar = new Intent(getApplicationContext(), MengajarActivity.class);
                startActivity(goMengajar);
                finish();
                Toast.makeText(getApplicationContext(), "Anda Berada di Mode Mengajar",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
