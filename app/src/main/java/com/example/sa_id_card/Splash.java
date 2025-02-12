package com.example.sa_id_card;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View first=findViewById(R.id.first);
        Animation top_to_bottom_f1= AnimationUtils.loadAnimation(this,R.anim.top_to_bottom);
        first.startAnimation(top_to_bottom_f1);

        View second=findViewById(R.id.second);
        Animation top_to_bottom_f2= AnimationUtils.loadAnimation(this,R.anim.top_to_bottom);
        second.startAnimation(top_to_bottom_f2);

        View third=findViewById(R.id.third);
        Animation top_to_bottom_f3= AnimationUtils.loadAnimation(this,R.anim.top_to_bottom);
        third.startAnimation(top_to_bottom_f3);

        View fourth=findViewById(R.id.fourth);
        Animation top_to_bottom_f4= AnimationUtils.loadAnimation(this,R.anim.top_to_bottom);
        fourth.startAnimation(top_to_bottom_f4);


        ImageView id_card_logo=findViewById(R.id.id_card_logo);
        Animation move_left_to_right= AnimationUtils.loadAnimation(this,R.anim.move_left_to_right);
        id_card_logo.startAnimation(move_left_to_right);


        new Handler().postDelayed(()->{
            Intent i=new Intent(Splash.this,MainActivity.class);
            startActivity(i);
            finish();
        },5000);
    }


}