package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PLTW on 12/3/2015.
 */
public interface ApplicantData {

    final int FAMILY = 1;
    public static final int PROFILE = 0;
    public static final int GUARDIAN = 0;
    public static final int SIBLING = 0;

    public JSONObject toJSON() throws JSONException;
}
