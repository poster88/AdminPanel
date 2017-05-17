package com.example.poster.adminpanelrealm.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.fragments.LoginFragment;
import com.example.poster.adminpanelrealm.fragments.MainFragment;
import com.example.poster.adminpanelrealm.fragments.MakeCategoryFragment;
import com.example.poster.adminpanelrealm.fragments.MakeProductFragment;
import com.example.poster.adminpanelrealm.fragments.RegistrationFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        changeFragment(LoginFragment.newInstance());
    }

    public void changeFragment(Fragment fragment) {
        this.fragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (fragment instanceof RegistrationFragment){
            changeFragment(LoginFragment.newInstance());
            return;
        }
        if (fragment instanceof MakeProductFragment){
            changeFragment(MainFragment.newInstance());
            return;
        }
        if (fragment instanceof MakeCategoryFragment){
            changeFragment(MainFragment.newInstance());
            return;
        }
        super.onBackPressed();
    }
}
