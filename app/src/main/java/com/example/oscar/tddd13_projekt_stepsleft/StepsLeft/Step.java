package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Object that hold the components and info that is step-specific. These components are StepIcon,
 * a textView that hold the label and the DisplayView that is shown when the step is selected.
 * @see StepIcon
 * @author Oscar Andell
 */
public class Step extends LinearLayout{

    private StepIcon icon; //View that changes color to
    private TextView companionText; //Text next to icon
    private View displayedView; //View to be displayed when this step is selected.

    private boolean complete = false;
    private boolean selected = false;

    public Step(Context context, int stepNumber, String label, View view, StepAdapter stepAdapter){
        super(context);
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        //Create the StepIcon object in this step.
        icon = new StepIcon(context, stepAdapter.getIconSize() , String.valueOf(stepNumber+1), stepAdapter.getIconColorUncompleted());
        //Get the colors that is specified in the StepAdapter
        icon.setColorComplete(stepAdapter.getIconColorCompleted());
        icon.setColorUncompleted(stepAdapter.getIconColorUncompleted());
        icon.setColorSelected(stepAdapter.getIconColorSelected());
        icon.uncomplete(); //Default mode is uncompleted
        this.addView(icon);
        companionText = new TextView(context);
        companionText.setText(label);
        this.addView(companionText);
        displayedView = view;
    }

    /**
     * Select this step. Icon color is updated.
     */
    public void select(){
        selected = true;
        complete = false;
        icon.select();
    }

    /**
     * Complete this step. Icon color is updated.
     */
    public void complete(){
        icon.complete();
        complete = true;
        selected = false;
    }

    /**
     * Sets this step to uncomplete. Icon color is updated.
     */
    public void uncomplete(){
        icon.uncomplete();
        complete = false;
        selected = false;
    }

    /**
     * @return Returns the icon view in this step.
     */
    public StepIcon getIcon(){
        return icon;
    }

    /**
     * @return Return the label TextView associated with this step.
     */
    public TextView getCompanionTextView() {
        return companionText;
    }

    /**
     * @return True if this step is complete
     */
    public boolean isComplete(){
        return complete;
    }

    /**
     * @return True if selected.
     */
    public boolean isSelected(){
        return selected;
    }

    /**
     * @return Return the view to be displayed when this step is selected.
     */
    public View getDisplayedView() {
        return displayedView;
    }
}
