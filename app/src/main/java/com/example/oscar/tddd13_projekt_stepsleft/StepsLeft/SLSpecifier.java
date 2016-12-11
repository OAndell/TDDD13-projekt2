package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;
import android.view.View;
import java.util.ArrayList;

/**
 * The SLSpecifier abstract class is used to specify settings in the StepsLeftObject. It specifies
 * the color of the step icons, the label text next to the icons and the views that should be
 * displayed when a specific step is selected.
 * NOTE: the functions getStepLabels() and getStepViews() should return arrays of the same size.
 * @see StepsLeft
 * @author Oscar Andell
 */
public abstract class SLSpecifier {

   /**
    * Specify the label text that is shown next to the step icon.
    * @return Return an ArrayList<String> that contains the labels for each step. Should be the same
    * size as the ArrayList<View> that is returned in getStepViews()
     */
   public abstract ArrayList<String> getStepLabels();

   /**
    * Specify the view that is displayed when a specific step is selected.
    * @return Return an ArrayList<View> that contains the views for each step. Should be the same
    * size as the ArrayList<String> that is returned in  getStepLabels()
    */
   public abstract ArrayList<View> getStepViews();

   /**
    * Specify the color of the stepIcon when it is uncompleted.
    * @return Return a color code. Example: return android.graphics.Color.GREEN;
     */
   public abstract int getIconColorUncompleted();

   /**
    * Specify the color of the stepIcon when it is selected.
    * @return Return a color code. Example: return android.graphics.Color.GREEN;
    */
   public abstract int getIconColorSelected();

   /**
    * Specify the color of the stepIcon when it is completed.
    * @return Return a color code. Example: return android.graphics.Color.GREEN;
    */
   public abstract int getIconColorCompleted();

   /**
    * Specify the size of the step Icons. The radius of icon circle is IconSize/3
    * @return Return an integer that set the width and height of the icon view in pixels.
     */
   public abstract int getIconSize();

}
