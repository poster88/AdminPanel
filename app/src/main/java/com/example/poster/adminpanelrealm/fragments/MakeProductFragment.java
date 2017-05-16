package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeProductFragment extends BaseFragment{

    public static MakeProductFragment newInstance(){
        return new MakeProductFragment();
    }

    @BindView(R.id.container_products)
    LinearLayout containerCategories;
    private View.OnClickListener addNewLineListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v = getActivity().getLayoutInflater().inflate(R.layout.add_line, null);
            ImageView addNewLine = ButterKnife.findById(v, R.id.add_line);
            addNewLine.setOnClickListener(addNewLineListener);
            Spinner spinner = ButterKnife.findById(v, R.id.spinner);
            spinner.setAdapter(new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, new String[]{"cat 1", "cat2"}));
            containerCategories.addView(v);

            System.out.println("count " + containerCategories.getChildCount());
            View view = containerCategories.getChildAt(containerCategories.getChildCount() - 1);
            Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner);
            System.out.println(spinner1.getSelectedItem());
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_make_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view = getActivity().getLayoutInflater().inflate(R.layout.add_line, null);
        //category
        ImageView addNewLine = ButterKnife.findById(view, R.id.add_line);
        addNewLine.setOnClickListener(addNewLineListener);
        Spinner spinner = ButterKnife.findById(view, R.id.spinner);
        List<String> categories = new ArrayList<>();
        List<String> subCategories = new ArrayList<>();
        for (int i = 0; i < CategoryModel.StaticCategory.getCategoryModels().size(); i++) {
            categories.add(CategoryModel.StaticCategory.getCategoryModels().get(i).getName());
        }
        /*for (int j = 0; j < CategoryModel.StaticCategory.getCategoryModels().get(0).getSubCategories().size(); j++) {
                subCategories.add(CategoryModel.StaticCategory.getCategoryModels().get(0).getSubCategories().get(j).getName());
        }*/

        spinner.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, categories));
        containerCategories.addView(view);

        View view1 = getActivity().getLayoutInflater().inflate(R.layout.add_line, null);
        ImageView addNewLine1 = ButterKnife.findById(view1, R.id.add_line);
        //addNewLine1.setOnClickListener(addNewLineListener1);
        Spinner spinner1 = (Spinner) view1.findViewById(R.id.spinner);
        System.out.println(spinner1.getSelectedItem());
    }
}
