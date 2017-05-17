package com.example.poster.adminpanelrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.poster.adminpanelrealm.R;
import com.example.poster.adminpanelrealm.activities.BaseFragment;
import com.example.poster.adminpanelrealm.activities.MainActivity;
import com.example.poster.adminpanelrealm.models.CategoryModel;
import com.example.poster.adminpanelrealm.models.SubCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;


public class MakeCategoryFragment extends BaseFragment {

    public static MakeCategoryFragment newInstance(){
        return new MakeCategoryFragment();
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
            v.findViewById(R.id.subcat_line).setOnClickListener(addLineClickListener);
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
        view = getActivity().getLayoutInflater()
                .inflate(R.layout.subcategory_line, null);
        container.addView(view);
        view.findViewById(R.id.subcat_line).setOnClickListener(addLineClickListener);
    }

    @OnClick(R.id.saveCategoryBtn)
    public void saveCategory(){
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < container.getChildCount(); i++) {
            strings.add(((EditText) container.getChildAt(i).findViewById(R.id.subcategoryName)).getText().toString());
        }
        for (String s: strings) {
            System.out.println(s.toString());
        }
        final CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryName.getText().toString());
        categoryModel.setId(new Random().nextInt());
        RealmList<SubCategoryModel> subCategoryModels = new RealmList<>();
        for (String str: strings){
            SubCategoryModel subCategoryModel = new SubCategoryModel();
            subCategoryModel.setId(new Random().nextInt());
            subCategoryModel.setName(str);
            subCategoryModels.add(subCategoryModel);
        }
        categoryModel.setSubCategories(subCategoryModels);
        CategoryModel.StaticCategory.getCategoryModels().add(categoryModel);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(categoryModel);
            }
        });
        ((MainActivity)getActivity()).changeFragment(MainFragment.newInstance());
    }
}
