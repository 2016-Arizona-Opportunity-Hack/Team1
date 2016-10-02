package com.example.andrew.cccc;

/**
 * Created by Andrew on 10/1/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.widget.Button;
import android.content.Intent;





public class FourthFragment extends Fragment implements View.OnClickListener {

    Button contactUs, seniorCenters, iHelp, foodBank, familyResourceCenter, communityActionProgram, websiteLink;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.nav_fourth_fragment,
                container, false);
        communityActionProgram = (Button)view.findViewById(R.id.communityActionProgram);
        familyResourceCenter = (Button)view.findViewById(R.id.familyResourceCenter);
        foodBank= (Button)view.findViewById(R.id.foodBank);
        iHelp = (Button)view.findViewById(R.id.iHelp);
        seniorCenters = (Button)view.findViewById(R.id.seniorCenters);
        contactUs = (Button)view.findViewById(R.id.contactUs);
        websiteLink = (Button)view.findViewById(R.id.websiteLink);

        communityActionProgram.setOnClickListener(this);
        familyResourceCenter.setOnClickListener(this);
        foodBank.setOnClickListener(this);
        iHelp.setOnClickListener(this);
        seniorCenters.setOnClickListener(this);
        contactUs.setOnClickListener(this);
        websiteLink.setOnClickListener(this);

        return view;
    }

    private void goToUrl(String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    public void onClick(View v) {

        Fragment fragment1 = null;
        Class fragmentClass2 = null;

        switch(v.getId()) {
            case R.id.communityActionProgram:
                fragmentClass2 = CommunityAction.class;
                break;
            case R.id.familyResourceCenter:
                fragmentClass2 = FamilyResourceCenter.class;
                break;
            case R.id.foodBank:
                fragmentClass2 = FoodBank.class;
                break;
            case R.id.iHelp:
                fragmentClass2 = IHelp.class;
                break;
            case R.id.seniorCenters:
                fragmentClass2 = SeniorCenters.class;
                break;
            case R.id.contactUs:
                fragmentClass2 = ContactUs.class;
                break;
            case R.id.websiteLink:
                goToUrl("http://chandlerfoodbank.org/");
                break;
            default:
                fragmentClass2 = FourthFragment.class;
        }

        try {
            fragment1 = (Fragment) fragmentClass2.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment1).commit();
    }


}
