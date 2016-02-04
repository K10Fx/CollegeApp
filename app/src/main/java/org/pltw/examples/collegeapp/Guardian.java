package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by wdumas on 2/11/2015.
 */
public class Guardian extends FamilyMember implements ApplicantData {
    private String mOccupation;

    static final String JSON_OCCUPATION = "occupation";

    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(JSON_OCCUPATION, getOccupation());
        return json;
    }

    public Guardian(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mOccupation = json.getString(JSON_OCCUPATION);
    }

    public String toString() {
        return "Guardian: " + mFirstName + " " + mLastName + "\nOccupation: " + mOccupation;
    }

    public Guardian(){
        super();
        setRelation(super.GUARDIAN);
        setFirstName("Roger");
        setLastName("Dumas");
        setOccupation("Programmer");
    }

    public Guardian(String firstName, String lastName, String occupation) {
        super();
        setRelation(super.GUARDIAN);
        setFirstName(firstName);
        setLastName(lastName);
        setOccupation(occupation);
    }

    public Guardian(String firstName, String lastName) {
        super();
        setRelation(super.GUARDIAN);
        setFirstName(firstName);
        setLastName(lastName);
        setOccupation("unknown");
    }

    public String getOccupation() {
        return mOccupation;
    }

    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

}

