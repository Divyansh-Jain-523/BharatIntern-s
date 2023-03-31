package com.divyansh.jain.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class calc extends AppCompatActivity {
    Button AC , backSpace, modulo,plus, minus, divide , multiply, result, exponential, _0,_1,_2,_3,_4,_5,_6,_7,_8,_9;
    BigInteger v1 = BigInteger.valueOf(0), v  = v1;
    int id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        AC = findViewById(R.id.AC);
        modulo = findViewById(R.id.modulo);
        backSpace = findViewById(R.id.backSpace);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        result = findViewById(R.id.result);
        exponential = findViewById(R.id.exponential);
        _0 = findViewById(R.id._0);
        _1 = findViewById(R.id._1);
        _2 = findViewById(R.id._2);
        _3 = findViewById(R.id._3);
        _4 = findViewById(R.id._4);
        _5 = findViewById(R.id._5);
        _6 = findViewById(R.id._6);
        _7 = findViewById(R.id._7);
        _8 = findViewById(R.id._8);
        _9 = findViewById(R.id._9);
    }
    public void allClear(View view) {
        v1 = BigInteger.valueOf(0);
        v = BigInteger.valueOf(0);
        TextView x = findViewById(R.id.textView);
        x.setMovementMethod(new ScrollingMovementMethod());
        x.setText(String.valueOf(v1));
    }

    public void updateValue(View view) {
        Button current = (Button) view;
        byte w = Byte.parseByte(current.getText().toString());
        v1 = v1.multiply(BigInteger.valueOf(10));
        v1 = v1.add(BigInteger.valueOf(w));
        TextView x = findViewById(R.id.textView);
        x.setMovementMethod(new ScrollingMovementMethod());
        x.setText(String.valueOf(v1));
    }

    public void backSpace(View view) {
        v1 = v1.divide(BigInteger.valueOf(10));
        v1 = v1.divide(BigInteger.valueOf(10));
        TextView x = findViewById(R.id.textView);
        x.setMovementMethod(new ScrollingMovementMethod());
        x.setText(String.valueOf(v1));
    }
    public void operation(View view){
        if (v == BigInteger.valueOf(0)){
            v = v1;
        }
        else {
            if(id == minus.getId()){
                v = v.subtract(v1);
            }
            else if(id == plus.getId()){
                v = v.add(v1);
            }
            else if(id == multiply.getId()){
                v = v.multiply(v1);
            }
            else if(id == divide.getId()){
                v = v.divide(v1);
            }
            else if(id == modulo.getId()){
                v = v.remainder(v1);
            }
            else if(id == exponential.getId()){
                v = v.pow(Integer.parseInt(v1.toString()));
            }
            else if (id == result.getId()){

            }
        }
        v1 = BigInteger.valueOf(0);
        TextView x = findViewById(R.id.textView);
        x.setMovementMethod(new ScrollingMovementMethod());
        x.setText(String.valueOf(v));
        id =  view.getId();
    }

    @Override
    public void onBackPressed() {
        Intent n = new Intent(this,calc.class);
        startActivity(n);
    }

}