package com.example.mrbuknahsty.breadmate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main2);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Enter amount and choose currency to convert to");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        final Button optionOneBtn = (Button) findViewById(R.id.optionOneButton);
        final Button optionTwoBtn = (Button) findViewById(R.id.optionTwoButton);
        final Button optionThreeBtn = (Button) findViewById(R.id.optionThreeButton);
        final Button all = (Button) findViewById(R.id.converAllButton);//converts users first choice with rest of currencys


        final TextView firstChoiceTV = (TextView) findViewById(R.id.firstChoiceTV);//users first choice of currency
/*
        optionOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });*/


        String valueBtn1 = getIntent().getStringExtra("keyA");//first unselected choice from MainActivity
        String valueBtn2 = getIntent().getStringExtra("keyB");//second unselected choice from MainActivity
        String valueBtn3 = getIntent().getStringExtra("keyC");//last unselected choice from MainActivity

        optionOneBtn.setText(valueBtn1);//set text with value of first unselected choice from MainActivity
        optionTwoBtn.setText(valueBtn2);//set text with value of second unselected choice from MainActivity
        optionThreeBtn.setText(valueBtn3);//set text with value of last unselected choice from MainActivity

        String value = getIntent().getStringExtra("key");//get users choice from MainActivity
        firstChoiceTV.setText(value);//set value of users choice in textview box

    }




    public void secondCurrencyChoice(View view)
    {
        int MIN = 0;

        EditText userAmount = (EditText) findViewById(R.id.userAmountET);

        if(userAmount.getText().toString().trim().length() == 0)//if nothing was entered
        {
           userAmount.setError("Amount Should not be blank");
        }
        else if(userAmount.getText().toString().trim().length() < MIN)//just in ase user finds a way to enter a negative value
        {
            userAmount.setError("Amount Should be greater than 0");
        }
        else//continue on...
        {
            double val = Double.parseDouble(userAmount.getText().toString());//getting user input
            Intent mIntent = getIntent();
            Intent b = null;//intialize intent but leave unused
            String value = getIntent().getStringExtra("key");//get users choice from MainActivity

            double currencyValue1 = mIntent.getDoubleExtra("intKey", 0);//
            double currencyValue2 = mIntent.getDoubleExtra("intKey1", 0);//get value of intKeys 0 1 2 if is none then default to 0
            double currencyValue3 = mIntent.getDoubleExtra("intKey2", 0);//


            String valueA = getIntent().getStringExtra("keyA");//
            String valueB = getIntent().getStringExtra("keyB");//get values from keys A B C in MainActivity
            String valueC = getIntent().getStringExtra("keyC");//

            String resultsFinish = getIntent().getStringExtra("keyFinal");//passing over from MainActivity

            switch (view.getId()) {
                case R.id.optionOneButton:
                    String total = (String.format("%.2f", val * currencyValue1));//conversion calculation


                    b = new Intent(Main2Activity.this, Main3Activity.class);//start new Intent to pass values
                    b.putExtra("dollarAmnt", val);
                    b.putExtra("num2", valueA);
                    b.putExtra("num1", value);
                    b.putExtra("intKey", total);

                    b.putExtra("keyFinal", resultsFinish);
                    break;

                case R.id.optionTwoButton:
                    String total1 = (String.format("%.2f", val * currencyValue2));

                    b = new Intent(Main2Activity.this, Main3Activity.class);
                    b.putExtra("dollarAmnt", val);
                    b.putExtra("num2", valueB);
                    b.putExtra("num1", value);
                    b.putExtra("intKey", total1);

                    b.putExtra("keyFinal", resultsFinish);
                    break;

                case R.id.optionThreeButton:
                    String total2 = (String.format("%.2f", val * currencyValue3));
//(String.format("%.2f",
                    b = new Intent(Main2Activity.this, Main3Activity.class);
                    b.putExtra("dollarAmnt", val);
                    b.putExtra("num2", valueC);
                    b.putExtra("num1", value);
                    b.putExtra("intKey", total2);

                    b.putExtra("keyFinal", resultsFinish);
                    break;

                case R.id.converAllButton:
                    double totalAll1 = (val * currencyValue1);
                    double totalAll2 = (val * currencyValue2);
                    double totalAll3 = (val * currencyValue3);

                    b = new Intent(Main2Activity.this, Main4Activity.class);
                    b.putExtra("num4", valueA);
                    b.putExtra("num5", valueB);
                    b.putExtra("num6", valueC);

                    b.putExtra("num1", value);

                    b.putExtra("intKeyX", totalAll1);
                    b.putExtra("intKeyY", totalAll2);
                    b.putExtra("intKeyZ", totalAll3);

                    b.putExtra("keyFinal", resultsFinish);
                    break;
            }
            startActivity(b);
        }

    }
}
