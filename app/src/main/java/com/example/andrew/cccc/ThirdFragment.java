package com.example.andrew.cccc;

/**
 * Created by Andrew on 10/1/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.net.Uri;


public class ThirdFragment extends Fragment implements View.OnClickListener {
    Button signupButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.nav_third_fragment,
                container, false);

        signupButton = (Button)view.findViewById(R.id.signupButton);
        signupButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signupButton){
            goToUrl("https://docs.google.com/forms/d/e/1FAIpQLSeR4c7iG3dHbTGlmHUtOJH2Elq-oD5cnwzLEJKc_ufF_fhzpg/viewform?embedded=true");
        }
    }

    private void goToUrl(String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
