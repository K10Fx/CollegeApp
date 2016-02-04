package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by PLTW on 12/10/2015.
 */
public class Family {
    private static final String TAG = Family.class.getName();
    private static Family sFamily;

    ArrayList <FamilyMember> mFamily;

    private Family() {
        mFamily = new ArrayList <FamilyMember>();
        mFamily.add(new Guardian());
        mFamily.add(new Guardian("Jimmy", "Newtron"));
        mFamily.add(new Sibling());
        mFamily.add(new Sibling("Patrick", "Star"));
    }

    public static Family get() {
        if (sFamily == null) {
           sFamily = new Family();
        }
        return sFamily;
    }

    public void addFamilyMember(FamilyMember familyMember){
        Log.d(TAG, "Adding" + familyMember);
        mFamily.add(familyMember);
    }

    public void deleteFamilyMember(FamilyMember familyMember){
        Log.d(TAG, "Deleting" + familyMember);
        mFamily.remove(familyMember);
    }

    public ArrayList<FamilyMember> getFamily() {
        return mFamily;
    }

    public void setFamily(ArrayList<FamilyMember> family) {
        mFamily = family;
    }


}
