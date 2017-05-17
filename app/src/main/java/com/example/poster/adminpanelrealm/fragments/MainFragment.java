package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.MainActivity;

import butterknife.OnClick;


public class MainFragment extends BaseFragment {

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.addCategory)
    public void showFragmentMakeCategory(){
        ((MainActivity)getActivity()).changeFragment(MakeCategoryFragment.newInstance());
    }

    @OnClick(R.id.addProduct)
    public void showFragmentMakeProduct(){
        ((MainActivity)getActivity()).changeFragment(MakeProductFragment.newInstance());
    }
}