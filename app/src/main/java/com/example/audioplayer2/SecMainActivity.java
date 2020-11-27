package com.example.audioplayer2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecMainActivity extends AppCompatActivity implements View.OnClickListener {
    Button BackMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secmain_activity);
    }

    public void run(View view) {
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.res);

        double D = b * b - 4 * a * c;
        if (a == 0 && b == 0 && c == 0) {
            result.setText("any");
        }
        else if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            result.setText(String.format("%s",x1) + " " + String.format("%s",x2));
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            result.setText(String.valueOf(x));
        }
        else {
            result.setText("none");
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back) {
            finish();
        }
    }
}
