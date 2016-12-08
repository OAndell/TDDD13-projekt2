package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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
    private View currentView;

    private LinearLayout columnLayout;

    public StepsLeft(Context context, StepsLeftSpecifier specifier) {
        super(context);
        initiate(context, specifier);
    }

    private void initiate(Context context, StepsLeftSpecifier specifier){
        this.context = context;
        this.specifier = specifier;
        stepLabels = specifier.getStepLabels();
        columnLayout = new LinearLayout(context);
        columnLayout.setOrientation(VERTICAL);
        for (int i = 0; i < stepLabels.size(); i++) {
            addStep();
        }
        this.setOrientation(HORIZONTAL); //HORIZONTAL IF LANDSCAPE MODE
        this.addView(columnLayout);
        selectStep(currentStep);
        //this.addView(currentView);
    }

    public void setCurrentDisplayedView(View view){
        currentView = view;
    }


    public void completeStep(){
        if(currentStep == stepList.size()-1){
            stepList.get(currentStep).complete();
        }
        else{
            stepList.get(currentStep).complete();
            currentStep++;
            selectStep(currentStep);
        }

    }

    public void undoStep(){
        if(currentStep == 0){
            return;
        }
        else{
            stepList.get(currentStep).uncomplete();
            currentStep--;
            selectStep(currentStep);
        }

    }

    /**
     * Selects a specific step, and displayes the assigned view.
     * @param pos Position of step to be selected
     */
    public void selectStep(int pos){
        stepList.get(pos).select();
        this.removeView(currentView); //Remove old view
        currentView = stepList.get(pos).getDisplayedView(); //Display view assigned to specific view.
        this.addView(currentView); //Adds new view to layout.
    }

    private void addStep(){
        numberOfSteps++;
        Step newStep = new Step(context , numberOfSteps, specifier);
        stepList.add(newStep);
        columnLayout.addView(newStep);
    }

    public StepIcon getStepIcon(int pos){
        return stepList.get(pos).getIcon();
    }

}
