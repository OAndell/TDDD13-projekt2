package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Component used for creating a step by step design pattern that can used in for example account
 * registration. Every step is represented by a Step class.
 * @see Step
 * @see StepAdapter for customizion of the StepsLeft object.
 * @author Oscar Andell
 */
public class StepsLeft extends LinearLayout {

    private Context context;
    private StepAdapter specifier; //Holds settings for the component.
    private ArrayList<Step> stepList = new ArrayList<>(); //Hold all steps.
    private int numberOfSteps = 0; //Total number of steps in component.
    private int currentStep = 0; //Current step selected.
    private View currentView; //Step specific view that is currently being displayed

    private LinearLayout columnLayout; //Holds steps
    private LinearLayout viewLayout; //Holds the step specific content

    private boolean complete = false; //True when all steps are complete

    /**
     * Initialize a StepsLeft object.
     * @param context
     * @param adapter StepAdapter that hold settings that will be used to create the component.
     * @see StepAdapter
     */
    public StepsLeft(Context context, StepAdapter adapter) {
        super(context);
        initialize(context, adapter);
    }

    /**
     * Initialize a StepsLeft object with default example adapter.
     * @param context
     */
    public StepsLeft(Context context){
        super(context);
        initialize(context, new MyAdapter(context));
    }

    /**
     * Private function that sets up the layout of the component and creates all the step objects
     */
    private void initialize(Context context, StepAdapter adapter){
        this.context = context;
        this.specifier = adapter;
        columnLayout = new LinearLayout(context);
        columnLayout.setOrientation(VERTICAL);
        //Create a step for every label specified in the adapter.
        for (int i = 0; i < adapter.getStepLabels().size(); i++) {
            initStep(); //Create and add step
        }
        this.setOrientation(HORIZONTAL);
        this.addView(columnLayout);
        viewLayout = new LinearLayout(context);
        viewLayout.setGravity(Gravity.CENTER); //Step view should be displayed in center.
        viewLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        this.addView(viewLayout);
        selectStep(currentStep); //Select first step
    }

    /**
     * Private method to initialize the steps.
     */
    private void initStep(){
        //Create new step
        Step newStep = new Step(context , numberOfSteps, specifier.getStepLabels().get(numberOfSteps), specifier.getStepViews().get(numberOfSteps), specifier);
        numberOfSteps++;
        stepList.add(newStep);
        columnLayout.addView(newStep);
    }

    /**
     * Method to change the view currently displayed. Does not change the view associated with the
     * current step.
     * @param view
     */
    public void setCurrentDisplayedView(View view){
        viewLayout.removeView(currentView);
        currentView = view;
        viewLayout.addView(currentView);
    }

    /**
     * Complete the current step and select the next one.
     */
    public void completeStep(){
        if(currentStep == stepList.size()-1){ //All steps completed
            stepList.get(currentStep).complete();
            viewLayout.removeView(currentView);
            complete = true;
        }
        else{ //Default case. Go forward one step
            stepList.get(currentStep).complete();
            currentStep++;
            selectStep(currentStep);
        }

    }

    /**
     * Return to the previous step. The current step will be unselected.
     */
    public void undoStep(){
        complete = false;
        if(currentStep == 0){ //Cant go further back, return
            return;
        }
        if(currentStep == stepList.size()-1 && stepList.get(currentStep).isSelected()){ //Special case when undoing from the last step.
            stepList.get(currentStep).uncomplete();
            currentStep--;
            selectStep(currentStep);
        }
        else if(currentStep == stepList.size()-1){ //If all steps are complete. Unselect the top one.
            selectStep(currentStep);
        }
        else{ //Default case. Go back one step.
            stepList.get(currentStep).uncomplete();
            currentStep--;
            selectStep(currentStep);
        }
    }

    /**
     * Selects a specific step, and displayed the assigned view.
     * @param pos Position of step to be selected
     */
    public void selectStep(int pos){
        stepList.get(pos).select();
        viewLayout.removeView(currentView); //Remove old view
        currentView = stepList.get(pos).getDisplayedView(); //Display view assigned to specific view.
        viewLayout.addView(currentView); //Adds new view to layout.
    }


    /**
     * Function to add step after initialization of the StepsLeft object.
     * @param label String displayed next to the Step icon
     * @param displayView View to be displayed when step is selected.
     */
    public void addStep(String label, View displayView){
        Step newStep = new Step(context , numberOfSteps, label, displayView, specifier);
        numberOfSteps++;
        stepList.add(newStep);
        columnLayout.addView(newStep);
    }

    /**
     * Get the StepIcon view at the specified position.
     * @param pos position of the step.
     * @return Returns StepIcon object.
     */
    public StepIcon getStepIcon(int pos){
        return stepList.get(pos).getIcon();
    }

    /**
     * Get a specific step object.
     * @param pos Position of the step.
     * @see Step
     */
    public Step getStep(int pos){
        return stepList.get(pos);
    }

    /**
     * Check if all steps is complete.
     * @return True if all steps are complete.
     */
    public boolean isAllStepsComplete(){
        return complete;
    }


}
