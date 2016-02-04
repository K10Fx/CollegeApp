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
 * Created by PLTW on 1/7/2016.
 */
public class SiblingFragment extends FamilyMemberFragment {
    private static final String TAG = "SiblingFragment";

    private final String FILENAME = "sibling.json";

    private Sibling mSibling;

    //private TextView mOccupation;

    //private EditText mEnterOccupation;

    //SiblingJSONStorer mStorer;

    public SiblingFragment(){
        try {
           // mSibling = mStorer.load(); // Tries to load previous version
        } catch (Exception e) {
            mSibling = new Sibling();  // If there isn't one, a new one's created
            Log.e(TAG, "Error loading sibling: " + FILENAME, e);
        }
    }

    //@Override
    //public void onCreate(Bundle savedInstanceState) {
    //    mGuardian = new Guardian();
    //}

   /* public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSibling = new Sibling();

        if (savedInstanceState != null) {
            mSibling.setFirstName(savedInstanceState.getString(KEY_FIRST_NAME));
            Log.i(TAG, "The name is " + mSibling.getFirstName());
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sibling, container, false);

        mSibling = (Sibling)Family.get().getFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);
        //mOccupation = (TextView)rootView.findViewById(R.id.occupation);
        //mEnterOccupation = (EditText)rootView.findViewById(R.id.enter_occupation);


        mFirstName.setText(mSibling.getFirstName());
        mLastName.setText(mSibling.getLastName());
        //mOccupation.setText(mGuardian.getOccupation());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();
        //OccupationTextChanger occupationTextChanger = new OccupationTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);

        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        //mEnterOccupation.addTextChangedListener(occupationTextChanger);

        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);

        //mStorer = new SiblingJSONStorer(mAppContext, FILENAME);

        return rootView;
    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState got called and it was a BLAST!!!1: " + mSibling.getFirstName());
        savedInstanceState.putString(KEY_FIRST_NAME, mSibling.getFirstName());
    }*/

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setFirstName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember) mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mSibling.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setLastName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mSibling.getLastName());
        }
    }


    /*private class OccupationTextChanger implements TextWatcher {
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
    }*/

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }


    /*public boolean saveSibling() {
        try {
            mStorer.save(mSibling);//Trying to save the profile to device
            Log.d(TAG, "sibling saved to file.");//when profile is saved
            return true;
        } catch (Exception e) {//if profile is not saved catch error
            Log.e(TAG, "Error saving sibling: ", e);//Says error saving profile is error occurs
            return false;
        }
    }*/

    /*public boolean loadSibling() {
        try{
            mStorer.load();
            Log.d(TAG, "sibling saved to file");
            return true;
        }
        catch(Exception e) {
            Log.e(TAG, "Error loading sibling", e);
            return false;
        }
    }*/

    /*@Override
    public void onPause() {
        super.onPause();
        saveSibling();
        Log.d(TAG, "Fragment paused.");
    }*/

    /*@Override
    public void onResume() {
        super.onResume();
        loadSibling();
        try{
            mSibling = mStorer.load();//loads the saved profile
            Log.d(TAG, "Loaded " + mSibling.getFirstName());//when profile loaded, update the DoB
            mFirstName.setText(mSibling.getFirstName());
            mLastName.setText(mSibling.getLastName());
            // mOccupation.setText(mGuardian.getOccupation());
        }catch (Exception e){//if error catch error
            mSibling = new Sibling();//if no profile in device storage create new profile
            Log.e(TAG, "Error loading sibling from: " + FILENAME, e);
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
