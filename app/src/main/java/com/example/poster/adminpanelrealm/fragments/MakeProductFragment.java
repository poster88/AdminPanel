package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.models.CategoryModel;
import com.example.poster.adminpanelrealm.models.ProductModel;
import com.example.poster.adminpanelrealm.models.SubCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;

public class MakeProductFragment extends BaseFragment implements AdapterView.OnItemSelectedListener{

    public static MakeProductFragment newInstance(){
        return new MakeProductFragment();
    }
    private LinearLayout subcatContainer;
    private Spinner spinner1;
    private Spinner spinner;
    private List<String> categories = new ArrayList<>();
    private List<String> local_sbcategories = new ArrayList<>();
    private boolean categoryClick = false;
    private boolean subcategoryClick = false;
    private List<CategoryModel> categoryModels = new ArrayList<>();
    @BindView(R.id.category_container)
    LinearLayout categoryContainer;
    @BindView(R.id.nameEdit) EditText name;
    @BindView(R.id.descrEdit) EditText description;
    @BindView(R.id.countEdit) EditText count;

    private View.OnClickListener addNewLineListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
            v = getActivity().getLayoutInflater().inflate(R.layout.category_group, null);
            subcatContainer.findViewById(R.id.add_line_spinner).setVisibility(View.GONE);
            subcatContainer = ButterKnife.findById(v, R.id.subcat_container);
            ImageView addNewLine = ButterKnife.findById(v, R.id.add_line_spinner);
            addNewLine.setOnClickListener(addNewLineListener);
            Spinner spinner = ButterKnife.findById(v, R.id.spinner);
            spinner.setAdapter(new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, categories));
            categoryContainer.addView(v);
            LinearLayout subcatLayout = (LinearLayout) v.findViewById(R.id.subcat);
            ImageView addNewLine1 = ButterKnife.findById(subcatLayout, R.id.add_line_spinner);
            addNewLine1.setOnClickListener(addNewLineListener1);
        }
    };

    private View.OnClickListener addNewLineListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "sub cat add click", Toast.LENGTH_SHORT).show();
            v = getActivity().getLayoutInflater().inflate(R.layout.add_line, null);
            ImageView addNewLine = ButterKnife.findById(v, R.id.add_line_spinner);
            addNewLine.setOnClickListener(addNewLineListener1);
            Spinner spinner = ButterKnife.findById(v, R.id.spinner);
            spinner.setAdapter(new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, new String[]{"subcatcat 1", "subcatcat2"}));
            subcatContainer.addView(v);
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
        view = getActivity().getLayoutInflater().inflate(R.layout.category_group, null);

        LinearLayout catLayout = (LinearLayout) view.findViewById(R.id.cat);
        LinearLayout subcatLayour = (LinearLayout) view.findViewById(R.id.subcat);

        subcatContainer = ButterKnife.findById(view, R.id.subcat_container);
        //category
        ImageView addNewLine = ButterKnife.findById(view, R.id.add_line_spinner);
        addNewLine.setOnClickListener(addNewLineListener);
        spinner = ButterKnife.findById(catLayout, R.id.spinner);
        initSpinnersData();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("cat position is " + position);
                for (int i = 0; i < CategoryModel.StaticCategory.getCategoryModels().get(position).getSubCategories().size(); i++) {
                    local_sbcategories.add(CategoryModel.StaticCategory.getCategoryModels().get(position).getSubCategories().get(i).getName());
                }
                spinner1.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, local_sbcategories));
                local_sbcategories = new ArrayList<>();
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        System.out.println("subcat position is " + position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        categoryContainer.addView(view);

        //subcategory
        ImageView addNewLine1 = ButterKnife.findById(subcatLayour, R.id.add_line_spinner);
        addNewLine1.setOnClickListener(addNewLineListener1);
        spinner1 = ButterKnife.findById(subcatLayour, R.id.spinner);

    }

    private void initSpinnersData() {
        for (int i = 0; i < CategoryModel.StaticCategory.getCategoryModels().size(); i++) {
            categories.add(CategoryModel.StaticCategory.getCategoryModels().get(i).getName());
        }
        /*for (int j = 0; j < CategoryModel.StaticCategory.getCategoryModels().get(0).getSubCategories().size(); j++) {
            sbcategories.add(CategoryModel.StaticCategory.getCategoryModels().get(0).getSubCategories().get(j).getName());
        }*/
        spinner.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, categories));

        /*try {
            spinner1.setAdapter(new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, sbcategories));
        }catch (Exception e){

        }*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        System.out.println("spinner click");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.saveBtn)
    public void saveProductClick(){
        //subCategoryModel
        SubCategoryModel subCategoryModel = CategoryModel.StaticCategory.getCategoryModels().get(0).getSubCategories().get(0);
        SubCategoryModel subCategoryModel1 = CategoryModel.StaticCategory.getCategoryModels().get(1).getSubCategories().get(0);

        //subCategoryModels.add();
        RealmList<SubCategoryModel> subCategoryModels = new RealmList<>();
        subCategoryModels.add(subCategoryModel);
        subCategoryModels.add(subCategoryModel1);

        try{
            final ProductModel productModel = new ProductModel();
            productModel.setId(new Random().nextInt());
            productModel.setName(name.getText().toString());
            productModel.setDescription(description.getText().toString());
            productModel.setCount(Integer.valueOf(count.getText().toString()));
            productModel.setSubCategories(subCategoryModels);
            Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(productModel);
                }
            });
        }catch (Exception e){
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
