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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;

import java.util.ArrayList;

import retrofit2.Retrofit;

/**
 * Created by abhi on 24/03/18.
 */

public class ConfirmOrderActivity extends AppCompatActivity implements RetrofitApi.ResponseListener {


    private TextView tvConfirm;
    private Spinner spTitle;
    private EditText etForename, etSurname, etEmail, etMobile, etAddress1, etAddress2, etAddress3;
    private TextView tvViewCart;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirm_order);

        initUi();

        initData();
    }


    private void initData() {


    }


    private void initUi() {

        setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable d = getResources().getDrawable(R.drawable.layout_bg_toolbar);
        getSupportActionBar().setBackgroundDrawable(d);

        spTitle = findViewById(R.id.sp_title);
        etForename = findViewById(R.id.et_forename);
        etSurname = findViewById(R.id.et_surname);
        etEmail = findViewById(R.id.et_email);
        etMobile = findViewById(R.id.et_mobile);
        etAddress1 = findViewById(R.id.et_address1);
        etAddress2 = findViewById(R.id.et_address2);
        etAddress3 = findViewById(R.id.et_address3);


        tvConfirm = findViewById(R.id.tv_confirm);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetails();
            }
        });

        tvViewCart = findViewById(R.id.tv_view_cart);
        tvViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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

    private void getDetails() {
        String strTitle = "Mr";
        String strForename = etForename.getText().toString().trim();
        String strSurname = etSurname.getText().toString().trim();
        String strEmail = etEmail.getText().toString().trim();
        String strContactNum = etMobile.getText().toString().trim();
        String strAddress1 = etAddress1.getText().toString().trim();
        String strAddress2 = etAddress2.getText().toString().trim();
        String strAddress3 = etAddress3.getText().toString().trim();

        String completeAddress = getCompleteAddress(strAddress1, strAddress2, strAddress3);

        if (isValidated(strForename, strSurname, strEmail, strContactNum, completeAddress)) {
            RetrofitApi.getInstance().placeFinalOrder(this, this, Constants.DEFAULT_USER_ID, Constants.CLIENT_ID, 0, Constants.CLIENT_NAME, strTitle, strForename, strSurname, strAddress1, strAddress2, strAddress3, "test", "test", strContactNum, "0", "", strEmail, "", true, Constants.DEFAULT_CAMPAIGN_ID);
        }
    }

    private boolean isValidated(String strForename, String strSurname, String strEmail, String strContactNum, String completeAddress) {

        if (strForename.length() == 0)
            return false;
        if (strSurname.length() == 0)
            return false;
        if (strEmail.length() == 0)
            return false;
        if (strContactNum.length() == 0)
            return false;
        if (completeAddress.length() == 0)
            return false;

        return true;
    }

    private String getCompleteAddress(String strAddress1, String strAddress2, String strAddress3) {
        return strAddress1 + "\n" + strAddress2 + "\n" + strAddress3;

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

            if (response.getStatusCode().equals("200")) {

            }
        }
    }
}