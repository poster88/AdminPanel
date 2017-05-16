package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MakeCategoryFragment extends BaseFragment {

    public static MakeProductFragment newInstance(){
        return new MakeProductFragment();
    }

    @BindView(R.id.categoryName)
    EditText categoryName;
    @BindView(R.id.category_container)
    LinearLayout container;

    private View.OnClickListener addLineClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v = getActivity().getLayoutInflater().inflate(R.layout.subcategory_line, null);
            container.addView(v);
            v.findViewById(R.id.add_line).setOnClickListener(addLineClickListener);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_make_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view = getActivity().getLayoutInflater().inflate(R.layout.subcategory_line, null);
        container.addView(view);
        view.findViewById(R.id.add_line).setOnClickListener(addLineClickListener);
    }

    @OnClick(R.id.saveCategoryBtn)
    public void saveCategory(){
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < container.getChildCount(); i++) {
            strings.add(((EditText) container.getChildAt(i).findViewById(R.id.subcategoryName)).getText().toString());
        }
        System.out.println(strings);
    }
}
