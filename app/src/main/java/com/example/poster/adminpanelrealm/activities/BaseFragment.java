package com.example.poster.adminpanelrealm.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;


public class BaseFragment extends Fragment{
    private Unbinder unbinder;
    protected Realm realm;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        realm.close();
        super.onDestroyView();
    }
}
