package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Default implementation of the StepAdapter.
 * Creates 4 example steps to showcase the component
 * @see StepAdapter
 * @author Oscar Andell
 */
public class MyAdapter extends StepAdapter{

    private Context context;

    public MyAdapter(Context context){
        this.context = context;
    }

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
        final TextView step1TextView = new TextView(context);
        step1TextView.setText("Step 1\nWelcome to this step-by-step Example \nEach step display a new view");
        final TextView step2TextView = new TextView(context);
        step2TextView.setText("This is using the default adapter\nYou can create custom settings\nby using the StepAdapter");
        final EditText step3Text = new EditText(context);
        step3Text.setText("This view is an EditText");
        final Button step4Button = new Button(context);
        step4Button.setText("This view is a Button");
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
}
