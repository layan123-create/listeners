package com.example.listeners;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch sw1;
    private SeekBar bar12;
    private ImageView pecture1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw1 = findViewById(R.id.sw);
        bar12 = findViewById(R.id.bar1);
        pecture1 = findViewById(R.id.pecture);

        sw1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                pecture1.setImageResource(R.drawable.happy);
            } else {
                pecture1.setImageResource(R.drawable.sad);
            }
        });

        bar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pecture1.setX(pecture1.getX() + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Image X ="+ pecture1.getX(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}