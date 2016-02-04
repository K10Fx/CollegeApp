package org.pltw.examples.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wdumas on 2/18/2015.
 */
public class GuardianFragment extends FamilyMemberFragment {
    private static final String TAG = "GuardianFragment";

    private final String FILENAME = "guardian.json";

    private Guardian mGuardian;

    private TextView mOccupation;

    private EditText mEnterOccupation;

    //GuardianJSONStorer mStorer;

    public GuardianFragment(){
        try {
           // mGuardian = mStorer.load(); // Tries to load previous version
        } catch (Exception e) {
            mGuardian = new Guardian();  // If there isn't one, a new one's created
            Log.e(TAG, "Error loading guardian: " + FILENAME, e);
        }
    }

    //@Override
    //public void onCreate(Bundle savedInstanceState) {
    //    mGuardian = new Guardian();
    //}

   /* public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGuardian = new Guardian();

        if (savedInstanceState != null) {
            mGuardian.setFirstName(savedInstanceState.getString(KEY_FIRST_NAME));
            Log.i(TAG, "The name is " + mGuardian.getFirstName());
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mGuardian = (Guardian)Family.get().getFamily().get(getActivity().
            getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);
        mOccupation = (TextView)rootView.findViewById(R.id.occupation);
        mEnterOccupation = (EditText)rootView.findViewById(R.id.enter_occupation);


        mFirstName.setText(mGuardian.getFirstName());
        mLastName.setText(mGuardian.getLastName());
        mOccupation.setText(mGuardian.getOccupation());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();
        OccupationTextChanger occupationTextChanger = new OccupationTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);

        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        mEnterOccupation.addTextChangedListener(occupationTextChanger);

        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);

       // mStorer = new GuardianJSONStorer(mAppContext, FILENAME);

        return rootView;
    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState got called and it was a BLAST!!!1: " + mGuardian.getFirstName());
        savedInstanceState.putString(KEY_FIRST_NAME, mGuardian.getFirstName());
    }*/

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setFirstName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember) mGuardian);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mGuardian.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setLastName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mGuardian);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mGuardian.getLastName());
        }
    }


    private class OccupationTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setOccupation(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mOccupation.setText(mGuardian.getOccupation());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }


    /*public boolean saveGuardian() {
        try {
            mStorer.save(mGuardian);//Trying to save the profile to device
            Log.d(TAG, "guardian saved to file.");//when profile is saved
            return true;
        } catch (Exception e) {//if profile is not saved catch error
            Log.e(TAG, "Error saving guardian: ", e);//Says error saving profile is error occurs
            return false;
        }
    }*/

    /*public boolean loadGuardian() {
        try{
            mStorer.load();
            Log.d(TAG, "guardian saved to file");
            return true;
        }
        catch(Exception e) {
            Log.e(TAG, "Error loading guardian", e);
            return false;
        }
    }*/

    /*@Override
    public void onPause() {
        super.onPause();
        saveGuardian();
        Log.d(TAG, "Fragment paused.");
    }*/

    /*@Override
    public void onResume() {
        super.onResume();
        loadGuardian();
        try{
            mGuardian = mStorer.load();//loads the saved profile
            Log.d(TAG, "Loaded " + mGuardian.getFirstName());//when profile loaded, update the DoB
            mFirstName.setText(mGuardian.getFirstName());
            mLastName.setText(mGuardian.getLastName());
            mOccupation.setText(mGuardian.getOccupation());
        }catch (Exception e){//if error catch error
            mGuardian = new Guardian();//if no profile in device storage create new profile
            Log.e(TAG, "Error loading guardian from: " + FILENAME, e);
        }
        Log.d(TAG, "Fragment resumed.");
    }*/

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment stopped.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment destroyed.");
    }

}
