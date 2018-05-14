package com.viscocits.redeem.catalogue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.catalogue.threeLevelView.FirstLevelAdapter;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

import java.util.ArrayList;

/**
 * Created by abhi on 24/03/18.
 */

public class CatalogueFragment extends Fragment implements RetrofitApi.ResponseListener {


    private ProgressBar progressBar;
    ArrayList<ModelGetAllCategoriesData> categories = new ArrayList<>();
    String categoryAction = "Main";
    ExpandableListView elvCategories;
    private FirstLevelAdapter adapter;
    private TextView tvAllProducts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);

        initUi(view);

        initData();

        return view;

    }

    private void initData() {

        adapter = new FirstLevelAdapter(getActivity(), this, categories);
        elvCategories.setAdapter(adapter);
        tvAllProducts.setVisibility(View.GONE);
        RetrofitApi.getInstance().getAllCategories(getActivity(), this, progressBar, categoryAction);
    }


    private void initUi(View view) {

        progressBar = view.findViewById(R.id.progressBar);

        elvCategories = view.findViewById(R.id.elv_categories);

        tvAllProducts = view.findViewById(R.id.tv_all_products);
        tvAllProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductActivity(0);
            }
        });
    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {
        tvAllProducts.setVisibility(View.VISIBLE);
    }

    @Override
    public void _onNext(Object obj) {
        if (obj instanceof ModelGetAllCategoriesResponse) {
            ModelGetAllCategoriesResponse response = (ModelGetAllCategoriesResponse) obj;
            if (categoryAction.equalsIgnoreCase("MAIN")) {
                categories.clear();
                categories.addAll(response.getData());
                categoryAction = "ALL";
                RetrofitApi.getInstance().getAllCategories(getActivity(), this, null, categoryAction);
            } else if (categoryAction.equalsIgnoreCase("ALL")) {
                getUpdatedCategoryList(response.getData());
            } else {
                tvAllProducts.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }

    }

    private void getUpdatedCategoryList(ArrayList<ModelGetAllCategoriesData> data) {
        try {
            for (ModelGetAllCategoriesData modelMain : categories) {

                ArrayList<ModelGetAllCategoriesData> categoriesL2 = new ArrayList<>();
                for (ModelGetAllCategoriesData modelLevel2 : data) {
                    if (modelLevel2.getParentId() == modelMain.getId()) {
                        categoriesL2.add(modelLevel2);
                    }
                }

                modelMain.setSubCategories(categoriesL2);

                for (ModelGetAllCategoriesData modelLevel2 : modelMain.getSubCategories()) {

                    ArrayList<ModelGetAllCategoriesData> categoriesL3 = new ArrayList<>();
                    for (ModelGetAllCategoriesData modelLevel3 : data) {
                        if (modelLevel3.getParentId() == modelLevel2.getId() && modelLevel3.getProductCount() > 0) {
                            categoriesL3.add(modelLevel3);
                        }
                    }

                    modelLevel2.setSubCategories(categoriesL3);
                }
            }
            tvAllProducts.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
            tvAllProducts.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }

    }

    public void _onGroupClick(ExpandableListView parent, View v, int firstLevelPos, int secondLevelPos, int thirdLevelPos, long id, int level) {
        switch (level) {
            case 1:
                if (firstLevelPos != -1 &&
                        categories.get(firstLevelPos) != null) {

                    if (categories.get(firstLevelPos).getSubCategories() == null || categories.get(firstLevelPos).getSubCategories().size() == 0) {
                        openProductActivity(categories.get(firstLevelPos).getId());
                    } else {
                        updateGroupView(parent, firstLevelPos);
                    }
                }
                break;

            case 2:

                if (firstLevelPos != -1 &&
                        categories.get(firstLevelPos).getSubCategories() != null &&
                        secondLevelPos != -1 &&
                        categories.get(firstLevelPos).getSubCategories().size() > secondLevelPos &&
                        categories.get(firstLevelPos).getSubCategories().get(secondLevelPos) != null) {

                    if (categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getSubCategories() == null ||
                            categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getSubCategories().size() == 0) {
                        openProductActivity(categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getId());
                    } else {
                        updateGroupView(parent, secondLevelPos);
                    }
                }
                break;

            case 3:

                if (firstLevelPos != -1 &&
                        categories.get(firstLevelPos).getSubCategories() != null &&
                        secondLevelPos != -1 &&
                        categories.get(firstLevelPos).getSubCategories().size() > secondLevelPos &&
                        thirdLevelPos != -1 &&
                        categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getSubCategories().size() > thirdLevelPos &&
                        categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getSubCategories().get(thirdLevelPos) != null) {
                    openProductActivity(categories.get(firstLevelPos).getSubCategories().get(secondLevelPos).getSubCategories().get(thirdLevelPos).getId());

                }


                break;
        }
    }

    public void openProductActivity(int productId) {
        startActivity(new Intent(getActivity(), ProductsActivity.class)
                .putExtra("categoryId", productId));
    }

    private void updateGroupView(ExpandableListView parent, int groupPosition) {
        if (parent.isGroupExpanded(groupPosition)) {
            parent.collapseGroup(groupPosition);
        } else {
            parent.expandGroup(groupPosition);
        }
    }
}