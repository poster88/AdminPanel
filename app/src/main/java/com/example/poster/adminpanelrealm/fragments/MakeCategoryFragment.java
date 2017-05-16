package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.BaseFragment;

import butterknife.BindView;


public class MakeCategoryFragment extends BaseFragment {
    public static MakeProductFragment newInstance(){
        return new MakeProductFragment();
    }
    @BindView(R.id.cat_subcat_container)
    LinearLayout container;

    private View.OnClickListener addLineClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v = getActivity().getLayoutInflater().inflate(R.layout.subcategory_line, null);
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
}
