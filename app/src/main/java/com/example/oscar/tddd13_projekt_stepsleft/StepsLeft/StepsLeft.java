package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oscar on 2016-12-07.
 */

public class StepsLeft extends LinearLayout {

    private Context context;
    private StepsLeftSpecifier specifier;
    private ArrayList<String> stepLabels;
    private ArrayList<Step> iconList = new ArrayList<>();
    private ArrayList<Step> stepList = new ArrayList<>();
    private int numberOfSteps = 0;
    private int currentStep = 0;

    public StepsLeft(Context context, StepsLeftSpecifier specifier) {
        super(context);
        initiate(context, specifier);
    }

    private void initiate(Context context, StepsLeftSpecifier specifier){
        this.context = context;
        this.specifier = specifier;
        stepLabels = specifier.getStepLabels();
        for (int i = 0; i < stepLabels.size(); i++) {
            addStep();
        }
        this.setOrientation(VERTICAL);
        selectStep(currentStep);
    }


    public void completeStep(){
        stepList.get(currentStep).complete();
        currentStep++;
        selectStep(currentStep);
    }

    public void undoStep(){
        stepList.get(currentStep).uncomplete();
        currentStep--;
        selectStep(currentStep);
    }

    public void selectStep(int pos){
        stepList.get(pos).select();
    }

    public void addStep(){
        numberOfSteps++;
        Step newStep = new Step(context , numberOfSteps, specifier);
        stepList.add(newStep);
        this.addView(newStep);
    }

    public StepIcon getStepIcon(int pos){
        return stepList.get(pos).getIcon();
    }

}
