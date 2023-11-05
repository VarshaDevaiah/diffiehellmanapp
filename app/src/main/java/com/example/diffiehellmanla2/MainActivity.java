package com.example.diffiehellmanla2;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText inputP, inputG, inputA, inputB;
    private TextView textResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set taskbar area color to sea green
        getWindow().setStatusBarColor(Color.parseColor("#2E8B57"));

        inputP = findViewById(R.id.input_p);
        inputG = findViewById(R.id.input_g);
        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        textResult = findViewById(R.id.text_result);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiffieHellman();
            }
        });
    }

    private void calculateDiffieHellman() {
        BigInteger p = new BigInteger(inputP.getText().toString());
        BigInteger g = new BigInteger(inputG.getText().toString());
        BigInteger a = new BigInteger(inputA.getText().toString());
        BigInteger b = new BigInteger(inputB.getText().toString());

        BigInteger A = g.modPow(a, p); //'A' is public key of A
        BigInteger B = g.modPow(b, p);

        BigInteger sharedKeyA = B.modPow(a, p);
        BigInteger sharedKeyB = A.modPow(b, p);

        String result = "Shared Key A: " + sharedKeyA.toString() + "\n\nShared Key B: " + sharedKeyB.toString();
        textResult.setText(result);
    }
}