package com.example.oscar.tddd13_projekt_stepsleft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepIcon;
import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepsLeft;
import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepsLeftSpecifier;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        final StepsLeft s = new StepsLeft(this, new StepsLeftSpecifier() {
            @Override
            public ArrayList<String> getStepLabels() {
                ArrayList<String> steps = new ArrayList<>();
                steps.add("Step 1");
                steps.add("Step 2");
                steps.add("Step 3");
                steps.add("Step 4");
                steps.add("Step 5");
                steps.add("Step 6");
                return steps;
            }

            @Override
            public ArrayList<View> getStepViews() {
                ArrayList<View> viewList = new ArrayList<>();
                viewList.add(new Button(context));
                viewList.add(new EditText(context));
                viewList.add(new Button(context));
                viewList.add(new EditText(context));
                viewList.add(new Button(context));
                viewList.add(new EditText(context));
                return viewList;
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
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(s);
        Button testButtonComplete = new Button(this);
        testButtonComplete.setText("Complete");
        testButtonComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.completeStep();
            }
        });
        layout.addView(testButtonComplete);
        Button testButtonUndo = new Button(this);
        testButtonUndo.setText("Undo");
        testButtonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.undoStep();
            }
        });

        layout.addView(testButtonUndo);

        setContentView(layout);
    }
}
