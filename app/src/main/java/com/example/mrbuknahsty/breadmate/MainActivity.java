package com.example.mrbuknahsty.breadmate;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("What type of money do you have?");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void firstCurrencyChoice(View view)
    {
        Intent a = null;
        //USD
        double usdToEuro = .92;
        double usdToJPY = 114.17;
        double usdToGBP = .72;

       //EUR
        double euroToUSD = 1.09;
        double euroToJPY = 124.07;
        double euroToGBP = .78;

        //JPY
        double jpyToUSD = .0088;
        double jpyToEUR = .0081;
        double jpyToGBP = .0063;

        //GBP
        double gbpToUSD = 1.40;
        double gbpToEur = 1.29;
        double gbpToJPY = 159.46;

        switch(view.getId())
        {
            case R.id.usdButton:
                a = new Intent(MainActivity.this, Main2Activity.class);
                a.putExtra("key", "USD");
                a.putExtra("intKey", usdToEuro);
                a.putExtra("intKey1", usdToJPY);
                a.putExtra("intKey2", usdToGBP);


                a.putExtra("keyA", "EUR");
                a.putExtra("keyB", "JPY");
                a.putExtra("keyC", "GBP");

                a.putExtra("keyFinal", " Dollars");//used for results text field
                break;

            case R.id.eurButton:
                a = new Intent(MainActivity.this, Main2Activity.class);
                a.putExtra("key", "EUR");
                a.putExtra("intKey", euroToUSD);
                a.putExtra("intKey1", euroToJPY);
                a.putExtra("intKey2", euroToGBP);

                a.putExtra("keyA", "USD");
                a.putExtra("keyB", "JPY");
                a.putExtra("keyC", "GBP");

                a.putExtra("keyFinal", " Euros");//used for results text field
                break;

            case R.id.jpyButton:
                a = new Intent(MainActivity.this, Main2Activity.class);
                a.putExtra("key", "JPY");
                a.putExtra("intKey", jpyToUSD);
                a.putExtra("intKey1", jpyToEUR);
                a.putExtra("intKey2", jpyToGBP);

                a.putExtra("keyA", "USD");
                a.putExtra("keyB", "EUR");
                a.putExtra("keyC", "GBP");

                a.putExtra("keyFinal", " Yen");//used for results text field
                break;

            case R.id.gbpButton:
                a = new Intent(MainActivity.this, Main2Activity.class);
                a.putExtra("key", "GBP");
                a.putExtra("intKey", gbpToUSD);
                a.putExtra("intKey1", gbpToJPY);
                a.putExtra("intKey2", gbpToEur);

                a.putExtra("keyA", "USD");
                a.putExtra("keyB", "EUR");
                a.putExtra("keyC", "JPY");

                a.putExtra("keyFinal", " Pounds");//used for results text field
                break;
        }
        startActivity(a);

    }
}