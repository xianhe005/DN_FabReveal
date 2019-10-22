package com.hxh.dn_fabreveal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFabPressed(v);
            }
        });
    }

    private void onFabPressed(View v) {
        AnimatorPath path = new AnimatorPath();
        path.moveTo(0f, 0f);
        path.cubicTo(-200f, 200f, -400f, 200f, -600f, 50f);
        path.lineTo(-900f, 200f);
        path.lineTo(0f, 0f);
        path.startAnimation(v, 1000);
    }
}
