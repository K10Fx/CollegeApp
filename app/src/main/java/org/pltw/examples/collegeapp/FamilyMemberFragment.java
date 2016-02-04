package org.pltw.examples.collegeapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by PLTW on 1/19/2016.
 */
public abstract class FamilyMemberFragment extends Fragment {
    public static final String KEY_FIRST_NAME = "firstname";

    public TextView mFirstName;
    public TextView mLastName;
    public EditText mEnterFirstName;
    public EditText mEnterLastName;
    public Context mAppContext;
}
