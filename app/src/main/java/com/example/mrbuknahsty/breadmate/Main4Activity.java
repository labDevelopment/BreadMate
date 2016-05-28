package com.example.mrbuknahsty.breadmate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main4);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Your currency has been successfully converted!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        final TextView all1TV = (TextView) findViewById(R.id.all1TV);
        final TextView all2TV = (TextView) findViewById(R.id.all2TV);
        final TextView all3TV = (TextView) findViewById(R.id.all3TV);
        final TextView allNum1TV = (TextView) findViewById(R.id.allNum1TV);
        final TextView allNum2TV = (TextView) findViewById(R.id.allNum2TV);
        final TextView allNum3TV = (TextView) findViewById(R.id.allNum3TV);
        final TextView firstChoiceAllTV = (TextView) findViewById(R.id.firstChoiceAllTV);

        String secondChoiceBtn1 = getIntent().getStringExtra("num4");
        String secondChoiceBtn2 = getIntent().getStringExtra("num5");
        String secondChoiceBtn3 = getIntent().getStringExtra("num6");
        String firstAll = getIntent().getStringExtra("num1");

        Intent nIntent = getIntent();
        double finalValue1 = nIntent.getDoubleExtra("intKeyX", 0);
        double finalValue2 = nIntent.getDoubleExtra("intKeyY", 0);
        double finalValue3 = nIntent.getDoubleExtra("intKeyZ", 0);

        allNum1TV.setText(String.format("%.2f", finalValue1));
        allNum2TV.setText(String.format("%.2f", finalValue2));
        allNum3TV.setText(String.format("%.2f", finalValue3));

        firstChoiceAllTV.setText(firstAll);
        all1TV.setText(secondChoiceBtn1);
        all2TV.setText(secondChoiceBtn2);
        all3TV.setText(secondChoiceBtn3);
    }
}
