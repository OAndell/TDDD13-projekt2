package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Oscar on 2016-12-07.
 */

public class Step extends LinearLayout{

    private StepIcon icon;
    private TextView companionText;

    private boolean complete = false;
    private boolean selected = false;

    public Step(Context context, int stepNumber, StepsLeftSpecifier specifier){
        super(context);
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        icon = new StepIcon(context, 150, String.valueOf(stepNumber), specifier.getIconColorUncompleted());
        icon.setColorComplete(specifier.getIconColorCompleted());
        icon.setColorUncompleted(specifier.getIconColorUncompleted());
        icon.setColorSelected(specifier.getIconColorSelected());
        icon.uncomplete();
        this.addView(icon);
        companionText = new TextView(context);
        companionText.setText(specifier.getStepLabels().get(stepNumber-1));
        this.addView(companionText);
    }

    public void select(){
        icon.select();
    }

    public void complete(){
       icon.complete();
    }

    public void uncomplete(){
        icon.uncomplete();
    }

    public StepIcon getIcon(){
        return icon;
    }

    public TextView getCompanionTextView() {
        return companionText;
    }

    public boolean isComplete(){
        return complete;
    }

    public boolean isSelected(){
        return selected;
    }


}
