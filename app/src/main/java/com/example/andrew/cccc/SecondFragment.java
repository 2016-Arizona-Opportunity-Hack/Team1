package com.example.andrew.cccc;

/**
 * Created by Andrew on 10/1/2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment implements View.OnClickListener{
    Button donateButton, virtualFoodDriveLink;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.nav_second_fragment,
                container, false);

        donateButton = (Button)view.findViewById(R.id.donateButton);
        virtualFoodDriveLink = (Button)view.findViewById(R.id.virtualFoodDriveLink);
        donateButton.setOnClickListener(this);
        virtualFoodDriveLink.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.donateButton){
            goToUrl("http://chandlerfoodbank.org/causes/donate/");
        }
        else if(v.getId() == R.id.virtualFoodDriveLink){
            goToUrl("http://fooddriveonline.org/chandlerfoodbank/");
        }
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
