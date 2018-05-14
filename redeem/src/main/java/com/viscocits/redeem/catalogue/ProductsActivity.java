package com.viscocits.redeem.catalogue;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

import java.util.ArrayList;

/**
 * Created by abhi on 24/03/18.
 */

public class ProductsActivity extends AppCompatActivity implements RetrofitApi.ResponseListener {


    private ArrayList<ModelGetAllProductsData> products = new ArrayList<>();
    ProductsAdapter productsAdapter;
    RecyclerView rvProducts;
    private ProgressBar progressBar;
    RetrofitApi.ActivityToFragmentListener listener;
    private TextView tvNoProducts;
    public final String ASC_SORT = "Point_Asc";
    public final String DSC_SORT = "Point_Desc";
    private String searchCriteria = "", brandName = "", sortCol = ASC_SORT;
    int pageNum = 1, pageSize = 50, pointsFrom = 0, pointsTo;


    private int currentBalance;
    private int categoryId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_products);

        initUi();

        initData();
    }


    private void initData() {

        ModelLoginData userData = Utility.getPreferenceProfileData(ProductsActivity.this);
        currentBalance = (int) userData.getCurrentBalance();
        pointsTo = currentBalance;

        categoryId = getIntent().getIntExtra("categoryId", -1);
        getProducts(categoryId);
    }


    private void getProducts(int categoryId) {

        if (categoryId == 0)
            RetrofitApi.getInstance().getProducts(ProductsActivity.this, progressBar, this, categoryId, tvNoProducts, searchCriteria, pointsFrom, pointsTo, brandName, pageNum, pageSize, sortCol);
        else
            RetrofitApi.getInstance().getProductsByCategory(ProductsActivity.this, progressBar, this, categoryId, tvNoProducts);

    }

    private void initUi() {

        setTitle("Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable d = getResources().getDrawable(R.drawable.layout_bg_toolbar);
        getSupportActionBar().setBackgroundDrawable(d);

        ImageView ivSortFilter = findViewById(R.id.ivSortFilter);
        ivSortFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ProductsActivity.this, SortFilterActivity.class)
                        .putExtra("sort", sortCol)
                        .putExtra("pointFrom", pointsFrom)
                        .putExtra("pointTo", pointsTo)
                        .putExtra("brandNames", brandName), 100
                );
            }
        });

        progressBar = findViewById(R.id.progressBar);

        tvNoProducts = findViewById(R.id.tv_no_products);

        rvProducts = findViewById(R.id.rvProducts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductsActivity.this, LinearLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(layoutManager);
        productsAdapter = new ProductsAdapter(ProductsActivity.this, this, products);
        rvProducts.setAdapter(productsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        sortCol = getIntent().getStringExtra("sort");
        brandName = getIntent().getStringExtra("brandNames");
        pointsFrom = getIntent().getIntExtra("pointsFrom", 0);
        pointsTo = getIntent().getIntExtra("pointsTo", currentBalance);

        getProducts(categoryId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {

        if (obj instanceof ModelGetAllProductsResponse) {

            ModelGetAllProductsResponse response = (ModelGetAllProductsResponse) obj;
            products.clear();
            products.addAll(response.getData());
            productsAdapter.notifyDataSetChanged();

        }
    }
}