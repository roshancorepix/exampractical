package com.example.parasexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView iv_img;
    RadioGroup radio_group;
    RadioButton radioFruitButton;
    Button btn_submit;
    RelativeLayout ll_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_img = findViewById(R.id.iv_img);
        radio_group = findViewById(R.id.radio_group);
        btn_submit = findViewById(R.id.btn_submit);
        ll_main = findViewById(R.id.ll_main);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radio_group.getCheckedRadioButtonId();

                radioFruitButton = findViewById(selectedId);

                startActivity(new Intent(MainActivity.this, HomeActivity.class).putExtra("fruit", radioFruitButton.getText()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.red:
                ll_main.setBackgroundColor(getResources().getColor(R.color.red));
                return true;
            case R.id.rotate:
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
                iv_img.startAnimation(rotate);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}