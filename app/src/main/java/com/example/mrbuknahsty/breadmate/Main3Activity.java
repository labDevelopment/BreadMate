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

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main3);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Your currency has been converted!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        Intent mIntent = getIntent();

        final TextView dollarAmount = (TextView) findViewById(R.id.dollarAmountTV);
        final TextView firstChoice2TV = (TextView) findViewById(R.id.firstChoice2TV);
        final TextView secondChoice2TV = (TextView) findViewById(R.id.secondChoice2TV);
        final TextView resultsTV = (TextView) findViewById(R.id.resultsTV);

        double dollar = mIntent.getDoubleExtra("dollarAmnt", 0);
        dollarAmount.setText(String.format("$ %.2f", dollar));

        String value = getIntent().getStringExtra("num1");
        firstChoice2TV.setText(value);

        String valueB = getIntent().getStringExtra("num2");
        secondChoice2TV.setText(valueB);

        String results = getIntent().getStringExtra("intKey");
        String resultsFinish = getIntent().getStringExtra("keyFinal");


        resultsTV.setText("Converted value = \n\n"+results+" "+resultsFinish);


      //  String value2 = getIntent().getStringExtra("num1");
     //   firstChoice2TV.setText(value2);

    }






}
