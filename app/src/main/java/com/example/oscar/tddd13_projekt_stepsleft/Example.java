package com.example.oscar.tddd13_projekt_stepsleft;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.oscar.tddd13_projekt_stepsleft.StepsLeft.SLSpecifier;

import java.util.ArrayList;

/**
 * Created by Oscar on 2016-12-08.
 */

public class Example {

    public static SLSpecifier getExampleSettings(Context context){

        final TextView step1TextView = new TextView(context);
        step1TextView.setText("Step 1\nWelcome to this step-by-step Example\nEach step display a new view");
        final TextView step2TextView = new TextView(context);
        step2TextView.setText("Congratulations!\nYou made it to step 2!");
        final EditText step3Text = new EditText(context);
        step3Text.setText("This view is an EditText");
        final Button step4Button = new Button(context);
        step4Button.setText("This view is a Button");
        SLSpecifier settings = new SLSpecifier() {
            @Override
            public ArrayList<String> getStepLabels() {
                ArrayList<String> steps = new ArrayList<>();
                steps.add("Step 1");
                steps.add("Step 2");
                steps.add("Step 3");
                steps.add("Step 4");
                return steps;
            }

            @Override
            public ArrayList<View> getStepViews() {
                ArrayList<View> viewList = new ArrayList<>();
                viewList.add(step1TextView);
                viewList.add(step2TextView);
                viewList.add(step3Text);
                viewList.add(step4Button);
                return viewList;
            }

            @Override
            public int getIconColorUncompleted() {
                return Color.LTGRAY;
            }

            @Override
            public int getIconColorSelected() {
                return Color.rgb(123,166,116);
            }

            @Override
            public int getIconColorCompleted() {
                return Color.GREEN;
            }

            @Override
            public int getIconSize() {
                return 150;
            }

        };
        return settings;
    }
}
