/***************
 Developer: Alex Hornick
 App: Calculator
 **************/

package com.alexhornick.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] buttonIds = {R.id.plus, R.id.minus, R.id.divide, R.id.multiply, R.id.cos,R.id.sin,R.id.power,R.id.sqrt,R.id.clearButton};

        for(int id: buttonIds)
        {
            Button b = (Button) findViewById(id);
            b.setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        String result = "";
        EditText number1Text = (EditText) findViewById(R.id.numberOne);
        EditText number2Text = (EditText) findViewById(R.id.numberTwo);
        TextView tv = (TextView) findViewById(R.id.resultText);
        boolean error = false;
        String errorMessage = "";

        if(number2Text.getText().toString().equals("0") && v.getId() == R.id.divide)
        {
            error = true;
            errorMessage = "ERROR: Cannot divide by 0";
        }

        if(number2Text.getText().toString().equals("") || number1Text.getText().toString() == "")
        {
            error = true;
            errorMessage = "ERROR: Number 1 and Number 2 must both have values.";
        }

        if(error)
        {
            tv.setTextColor(Color.parseColor("#ff6666"));
            tv.setText(errorMessage);
        }
        else {
            double num1 = Double.parseDouble(number1Text.getText().toString());
            double num2 = Double.parseDouble(number2Text.getText().toString());
            double resultValue;


            if (v.getId() == R.id.plus) {
                resultValue = num1 + num2;
                result = num1 + " + " + num2 + " = " + resultValue;
            } else if (v.getId() == R.id.minus) {
                resultValue = num1 - num2;
                result = num1 + " - " + num2 + " = " + resultValue;
            } else if (v.getId() == R.id.multiply) {
                resultValue = num1 * num2;
                result = num1 + " x " + num2 + " = " + resultValue;
            } else if (v.getId() == R.id.divide) {
                resultValue = num1 / num2;
                result = num1 + " / " + num2 + " = " + resultValue;
            } else if (v.getId() == R.id.sqrt) {
                resultValue = Math.sqrt(num1);
                result = "sqrt(" + num1 + ") = " + resultValue;
            } else if (v.getId() == R.id.power) {
                resultValue = Math.pow(num1, num2);
                result = num1 + " ** " + num2 + " = " + resultValue;
            } else if (v.getId() == R.id.cos) {
                resultValue = Math.cos(num1);
                result = "cos(" + num1 + ") = " + resultValue;
            } else if (v.getId() == R.id.sin) {
                resultValue = Math.sin(num1);
                result = "sin(" + num1 + ") = " + resultValue;
            } else if(v.getId() == R.id.clearButton) {
                tv.setText("");
                number1Text.setText("");
                number2Text.setText("");
            }

            tv.setTextColor(Color.parseColor("#777777"));
            tv.setText(result);
        }


    }


}
