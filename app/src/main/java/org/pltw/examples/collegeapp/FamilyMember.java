package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PLTW on 12/10/2015.
 */
public abstract class FamilyMember implements ApplicantData, Comparable<FamilyMember>{
    protected String mFirstName;
    protected String mLastName;

    protected static final String JSON_FIRST_NAME = "firstName";
    protected static final String JSON_LAST_NAME = "lastName";
    protected static final String JSON_RELATION = "relation";

    public static final int GUARDIAN = 0;
    public static final int SIBLING = 1;
    private int mRelation;

    public static final String EXTRA_RELATION = "org.pltw.examples.collegeapp.relation";
    public static final String EXTRA_INDEX = "org.pltw.examples.collegeapp.index";

    public int getRelation(){
        return mRelation;
    }

    public void setRelation(int relation) {
        mRelation = relation;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FIRST_NAME, mFirstName);
        json.put(JSON_LAST_NAME, mLastName);
        //json.put(JSON_RELATION, mRelation);
        return json;
    }

    @Override
    public int compareTo(FamilyMember another) {
        if (this.mFirstName.equals(another.getFirstName()) && this.mLastName.equals(another.getLastName())) {
            return 0;
        }
        return 1;
    }
}

