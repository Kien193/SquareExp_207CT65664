package com.example.squareexp_207ct65664;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numA, numB, numC;
    Button Run;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matching();
        Run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaiPTbac2();
            }
        });
    }

    public void giaiPTbac2() {
        String snumA = numA.getText().toString();
        double dnumA = Double.parseDouble(snumA);
        String snumB = numB.getText().toString();
        double dnumB = Double.parseDouble(snumB);
        String snumC = numC.getText().toString();
        double dnumC = Double.parseDouble(snumC);

        if(dnumA == 0) {
            if (dnumB == 0) {
                if (dnumC == 0) {
                    Result.setText("Phương trình vô số nghiệm");
                }
                else {
                    Result.setText("Phương trình vô nghiệm");
                }
            }
            else {
                Result.setText("Phương trình có nghiệm duy nhất " + -dnumC/dnumB);
            }
        }
        else {
            double delta = dnumB * dnumB - 4 * dnumA * dnumC;
            if (delta > 0) {
                double x1 = (-dnumB + Math.sqrt(delta) / (2*dnumA));
                double x2 = (-dnumB - Math.sqrt(delta) / (2*dnumA));

                String sresult = "";
                sresult += "Nghiệm thứ 1: " + x1 + "\n";
                sresult += "Nghiệm thứ 2: " + x2 + "\n";
                Result.setText(sresult);
            }
            else if (delta == 0) {
                Result.setText("Phương trình có nghiệm kép: x1 = x2 = " + -dnumB/2*dnumA);
            }
            else {
                Result.setText("Phương trình vô nghiệm");
            }
        }
    }

    public void matching() {
        numA = (EditText) findViewById(R.id.etA);
        numB = (EditText) findViewById(R.id.etB);
        numC = (EditText) findViewById(R.id.etC);
        Run = (Button) findViewById(R.id.btnRun);
        Result = (TextView) findViewById(R.id.tvResult);
    }
}