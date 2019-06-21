package com.example.app_sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.app_sample.R;
import com.example.app_sample.utils.PreferenceUtils;

public class PageTwo extends Fragment {

    private TextView textViewName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_two = inflater.inflate(R.layout.fragment_two, container, false);

        textViewName = (TextView) fragment_two.findViewById(R.id.text1);
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra("EMAIL")){
            String nameFromIntent = getActivity().getIntent().getStringExtra("EMAIL");
            textViewName.setText("Welcome " + nameFromIntent);
        }else{
            String email = PreferenceUtils.getEmail(getActivity());
            textViewName.setText("Welcome " + email);

        }
        setHasOptionsMenu(true);

        return fragment_two;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.log_out:
                PreferenceUtils.savePassword(null, getActivity());
                PreferenceUtils.saveEmail(null, getActivity());
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
