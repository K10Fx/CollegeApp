package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PLTW on 1/7/2016.
 */
public class Sibling extends FamilyMember {

    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        return json;
    }

    public Sibling(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mFirstName = json.getString(JSON_FIRST_NAME);
    }

    public String toString() {
        return "Sibling: " + mFirstName + " " + mLastName;
    }

    public Sibling(){
        super();
        setRelation(super.SIBLING);
        setFirstName("Michael");
        setLastName("Cane");
    }

    public Sibling(String firstName, String lastName) {
        super();
        setRelation(super.SIBLING);
        setFirstName(firstName);
        setLastName(lastName);
    }

}
