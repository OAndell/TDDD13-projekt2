package com.example.oscar.tddd13_projekt_stepsleft.StepsLeft;

import java.util.ArrayList;

/**
 * Created by Oscar on 2016-12-07.
 */

public abstract class StepsLeftSpecifier {

   public abstract ArrayList<String> getStepLabels();

   public abstract int getIconColorUncompleted();

   public abstract int getIconColorSelected();

   public abstract int getIconColorCompleted();

}
