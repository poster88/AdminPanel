package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.models.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

/**
 * Created by POSTER on 08.05.2017.
 */

public class RegistrationFragment extends BaseFragment{
    @BindView(R.id.loginET) EditText login;
    @BindView(R.id.passwordET) EditText password;
    @BindView(R.id.firstNameET) EditText firstName;
    @BindView(R.id.lastNameET) EditText lastName;
    @BindView(R.id.confirmBtn) Button confirmBtn;

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        return view;
    }

    @OnClick (R.id.confirmBtn)
    public void onConfirmClick(){
        if (validate()){
            saveIntoDataBase();
        }
    }

    private void saveIntoDataBase() {
        try {
            Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    UserModel userModel = new UserModel();
                    userModel.setLogin(login.getText().toString());
                    userModel.setPass(password.getText().toString());
                    userModel.setName(firstName.getText().toString());
                    userModel.setLastName(lastName.getText().toString());
                    realm.insert(userModel);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            //mRealm.close();
        }
    }

    private boolean validate(){
        if (login.getText().length() < 6){
            login.setError("error");
            return false;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
