package com.example.oscar.tddd13_projekt_stepsleft;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepIcon;
import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepsLeft;
import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepsLeftSpecifier;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        final StepsLeft s = new StepsLeft(this, new StepsLeftSpecifier() {
            @Override
            public ArrayList<String> getStepLabels() {
                ArrayList<String> steps = new ArrayList<>();
                steps.add("Register");
                steps.add("Work");
                steps.add("Get payed!");
                steps.add("Step 4");
                return steps;
            }

            @Override
            public int getIconColorUncompleted() {
                return Color.LTGRAY;
            }

            @Override
            public int getIconColorSelected() {
                return Color.GRAY;
            }

            @Override
            public int getIconColorCompleted() {
                return Color.GREEN;
            }
        });
        layout.addView(s);
        Button testButton = new Button(this);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.completeStep();
            }
        });
        layout.addView(testButton);
        setContentView(layout);
    }
}
