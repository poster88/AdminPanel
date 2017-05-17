package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.activities.MainActivity;
import com.example.poster.adminpanelrealm.models.UserModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;


public class LoginFragment extends BaseFragment {
    @BindView(R.id.editLogin) EditText login;
    @BindView(R.id.editPass) EditText pass;

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @OnClick (R.id.loginBtn)
    public void onLoginClick(){
        RealmResults<UserModel> resultLogin = Realm.getDefaultInstance().where(UserModel.class)
                .equalTo("login", login.getText().toString())
                .equalTo("pass", pass.getText().toString())
                .findAll();
        //System.out.println("size is: " + resultLogin.size());
        //ArrayList<UserModel> list = new ArrayList<>(resultLogin);
        ((MainActivity)getActivity()).changeFragment(MainFragment.newInstance());
    }
    @OnClick (R.id.passBtn)
    public void  onSignInClick(){
        ((MainActivity)getActivity()).changeFragment(RegistrationFragment.newInstance());
    }
}
