package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Oscar on 2016-12-07.
 */

public class StepIcon extends View {

    private int backgroundColor;

    private int colorSelected;
    private int colorComplete;
    private int colorUncompleted;


    private int textColor;
    private int sideLength;
    private Paint paint = new Paint();
    private String displayText;
    private float radius = 50;

    public StepIcon(Context context, int sideLength, String displayText, int backgroundColor) {
        super(context);
        this.sideLength = sideLength;
        this.displayText = displayText;
        this.backgroundColor = backgroundColor;
        textColor = Color.BLACK;
        radius = sideLength/3;
        paint.setTextSize(sideLength/2);
        paint.setTextAlign(Paint.Align.CENTER);
        this.setLayoutParams(new LinearLayout.LayoutParams(sideLength, sideLength));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(backgroundColor);
        canvas.drawCircle(sideLength/2, sideLength /2 , radius , paint); // Draw circle at center of view
        paint.setColor(textColor);
        canvas.drawText(displayText, sideLength /2, sideLength/2 + radius/2 ,paint); //Draw text in middle of circle
    }

    public void complete(){
        backgroundColor = colorComplete;
        invalidate();
    }

    public void select(){
        backgroundColor = colorSelected;
        invalidate();
    }

    public void uncomplete(){
        backgroundColor = colorUncompleted;
        invalidate();
    }

    public void setBackgroundColor(int color){
        backgroundColor = color;
    }

    public void setColorComplete(int colorComplete) {
        this.colorComplete = colorComplete;
    }

    public void setColorSelected(int colorSelected) {
        this.colorSelected = colorSelected;
    }

    public void setColorUncompleted(int colorUncompleted) {
        this.colorUncompleted = colorUncompleted;
    }
}
