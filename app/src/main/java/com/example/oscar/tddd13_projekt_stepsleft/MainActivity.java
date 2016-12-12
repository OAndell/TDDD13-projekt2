package com.example.oscar.tddd13_projekt_stepsleft;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.StepsLeft;

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //Create stepsLeft object with the default adapter.
        final StepsLeft s = new StepsLeft(this);
        //It is possible to add steps after creating StepsLeft object.
        s.addStep("Step 5", new Button(context));
        layout.addView(s);

        //Add two buttons for testing purposes.
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
