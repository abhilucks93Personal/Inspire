package com.viscocits.redeem.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viscocits.redeem.catalogue.ModelGetAllCategoriesResponse;
import com.viscocits.redeem.catalogue.ModelGetAllProductsResponse;
import com.viscocits.redeem.catalogue.ModelGetBooleanDataResponse;
import com.viscocits.redeem.catalogue.ModelGetCampaignResponse;
import com.viscocits.redeem.catalogue.ModelGetCartDetailsResponse;
import com.viscocits.redeem.catalogue.ModelGetWishlistDetailsResponse;
import com.viscocits.redeem.catalogue.ModelLoginResponse;
import com.viscocits.redeem.catalogue.ModelGetStringDataResponse;
import com.viscocits.redeem.demo.ModelSampleResponse;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

import java.util.Date;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by abhishekagarwal on 3/21/17.
 */

public class RetrofitApi {

    private ProgressDialog mProgressDialog;
    private static RetrofitApi retrofitApi = null;
    private ResponseListener mlistener_response;


    public static RetrofitApi getInstance() {

        if (retrofitApi != null)
            return retrofitApi;
        else
            return new RetrofitApi();
    }


    public interface ResponseListener {

        void _onCompleted();

        void _onError(Throwable e);

        void _onNext(Object obj);


    }

    public interface ActivityToFragmentListener {

        void update(String tag, String str);

    }


    // --------------------- Retrofit Api Methods ----------------------------------------------------------


    public void loginApi(final Activity activity,
                         final ResponseListener _mlistener_response, String strUserName, String strPassword) {

        this.mlistener_response = _mlistener_response;

        final ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setCancelable(false);
        dialog.setMessage("Checking credentials...");
        dialog.show();

        RetrofitClient.getClient().login(strUserName, strPassword, Constants.CLIENT_ID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelLoginResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelLoginResponse model) {
                        dialog.dismiss();
                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getAllCategories(final Activity activity,
                                 final ResponseListener _mlistener_response, final ProgressBar progressBar, String action) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getAllCategories(Constants.CLIENT_ID, Constants.DEFAULT_USER_ID, action)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetAllCategoriesResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetAllCategoriesResponse model) {

                        if (model.getStatusCode().equals("200") && model.getData() != null)
                            mlistener_response._onNext(model);
                    }
                });
    }

    public void getFeaturedProducts(final Activity activity,
                                    final ProgressBar progressBar, final TextView tvNoProducts, final ResponseListener _mlistener_response,
                                    int userId) {

        this.mlistener_response = _mlistener_response;
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getFeaturedProducts(userId, Constants.CLIENT_ID, Constants.DEFAULT_CAMPAIGN_ID, Constants.DEFAULT_CATEGORY_ID, 1, 5)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetAllProductsResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        tvNoProducts.setVisibility(View.VISIBLE);
                        Utility.hideKeyboard(activity);
                        // Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetAllProductsResponse model) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        if (model.getStatusCode().equals("200") && model.getData() != null) {
                            tvNoProducts.setVisibility(View.GONE);
                            mlistener_response._onNext(model);
                        } else
                            tvNoProducts.setVisibility(View.VISIBLE);
                    }

                });
    }

    public void getProducts(final Activity activity,
                            final ProgressBar progressBar, final ResponseListener _mlistener_response,
                            int categoryId, final TextView tvNoProducts, String searchCriteria, int pointsFrom, int pointsTo, String brandName, int pageNum, int pageSize, String sortCol) {

        this.mlistener_response = _mlistener_response;
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getProducts(Constants.DEFAULT_USER_ID, Constants.CLIENT_ID, Constants.DEFAULT_CAMPAIGN_ID, categoryId, pageNum, pageSize, searchCriteria, pointsFrom, pointsTo, brandName, sortCol)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetAllProductsResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        tvNoProducts.setVisibility(View.VISIBLE);
                        Utility.hideKeyboard(activity);
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetAllProductsResponse model) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        if (model.getStatusCode().equals("200") && model.getData() != null &&
                                model.getData().size() > 0) {
                            mlistener_response._onNext(model);
                        } else {
                            tvNoProducts.setVisibility(View.VISIBLE);
                        }

                    }

                });
    }

    public void getProductsByCategory(final Activity activity,
                                      final ProgressBar progressBar, final ResponseListener _mlistener_response,
                                      int categoryId, final TextView tvNoProducts) {

        this.mlistener_response = _mlistener_response;
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getProductsByCategory(Constants.DEFAULT_USER_ID, Constants.CLIENT_ID, Constants.DEFAULT_CAMPAIGN_ID, categoryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetAllProductsResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        tvNoProducts.setVisibility(View.VISIBLE);
                        Utility.hideKeyboard(activity);
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetAllProductsResponse model) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        if (model.getStatusCode().equals("200") && model.getData() != null &&
                                model.getData().size() > 0) {
                            mlistener_response._onNext(model);
                        } else {
                            tvNoProducts.setVisibility(View.VISIBLE);
                        }

                    }

                });
    }


    public void getProductDetails(final Activity activity,
                                  final ResponseListener _mlistener_response,
                                  int userId,
                                  int clientId,
                                  int productId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getProductDetails(userId,
                clientId,
                productId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void addToBasket(final Activity activity,
                            final ResponseListener _mlistener_response,
                            int productId,
                            String code,
                            int quantity,
                            final int campaignId,
                            final int userId) {

        this.mlistener_response = _mlistener_response;

        //  final SweetAlertDialog sweetAlertDialog = Utility.getSweetAlertProgressDialog(activity);

        RetrofitClient.getClient().addToBasket(productId,
                code,
                quantity,
                campaignId,
                userId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetBooleanDataResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);

                        //  mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetBooleanDataResponse model) {

                        if (model.getStatusCode().equals("200") && model.getData()) {
                            Utility.getSweetAlertSuccessDialog(activity, "Added to cart !");
                            getCartDetails(activity, null, _mlistener_response, userId, campaignId);
                        }

                        // mlistener_response._onNext(model);


                    }

                });
    }

    public void addToWishlist(final Activity activity,
                              final ResponseListener _mlistener_response,
                              int productId,
                              int quantity,
                              final int campaignId,
                              final int userId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().addToWishlist(productId,
                quantity,
                campaignId,
                userId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetStringDataResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        //   mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetStringDataResponse model) {
                        if (model.getStatusCode().equals("200")) {
                            if (model.getStatusMsg().toUpperCase().equals("SUCCESS"))
                                Utility.getSweetAlertSuccessDialog(activity, "Added to wishlist !");
                            else if (model.getStatusMsg().toUpperCase().equals("ALREADY_EXIST"))
                                Utility.getSweetAlertSuccessDialog(activity, "Item already exist in your wishlist!");
                        }
                        //  mlistener_response._onNext(model);

                    }

                });
    }

    public void getCartDetails(final Activity activity,
                               final ProgressBar progressBar,
                               final ResponseListener _mlistener_response,
                               int userId,
                               int campaignId) {

        this.mlistener_response = _mlistener_response;

        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getCartDetails(userId,
                campaignId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetCartDetailsResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetCartDetailsResponse model) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getWishListDetails(final Activity activity,
                                   final ProgressBar progressBar,
                                   final ResponseListener _mlistener_response,
                                   int userId,
                                   int campaignId) {

        this.mlistener_response = _mlistener_response;

        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getWishlistDetails(userId,
                campaignId,
                Constants.CLIENT_ID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelGetWishlistDetailsResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelGetWishlistDetailsResponse model) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        mlistener_response._onNext(model);

                    }

                });
    }

    public void updateCartQty(final Activity activity,
                              final ResponseListener _mlistener_response,
                              int userId,
                              int quantity,
                              int countryId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().updateCartQty(userId,
                quantity,
                countryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void deleteItem(final Activity activity,
                           final ResponseListener _mlistener_response,
                           int userId,
                           int countryId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().deleteItem(userId,
                countryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void placeFinalOrder(final Activity activity,
                                final ResponseListener _mlistener_response,
                                int userId,
                                int clientId,
                                int cartId,
                                String clientName,
                                String title,
                                String firstName,
                                String lastName,
                                String address1,
                                String address2,
                                String town,
                                String country,
                                String postCode,
                                String mobilePhone,
                                String branchId,
                                String workPhone,
                                String emailAddress,
                                String notes,
                                boolean isTermAccepted,
                                int countryId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().placeFinalOrder(userId,
                clientId,
                cartId,
                clientName,
                title,
                firstName,
                lastName,
                address1,
                address2,
                town,
                country,
                postCode,
                mobilePhone,
                workPhone,
                branchId,
                emailAddress,
                notes,
                isTermAccepted,
                countryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getOrderDetailsConfirmation(final Activity activity,
                                            final ResponseListener _mlistener_response,
                                            int userId,
                                            String orderNumber,
                                            int countryId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getOrderDetailsConfirmation(userId,
                orderNumber,
                countryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getOrderInvoiceDetails(final Activity activity,
                                       final ResponseListener _mlistener_response,
                                       int userId,
                                       String orderNumber) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getOrderInvoiceDetails(userId,
                orderNumber)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getRewardStatement(final Activity activity,
                                   final ResponseListener _mlistener_response,
                                   int userId,
                                   int countryId) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getRewardStatement(userId,
                countryId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }

    public void getTwoDirectionStatement(final Activity activity,
                                         final ResponseListener _mlistener_response,
                                         int userId,
                                         int countryId,
                                         Date fromDate,
                                         Date toDate,
                                         int direction) {

        this.mlistener_response = _mlistener_response;

        RetrofitClient.getClient().getTwoDirectionStatement(userId,
                countryId,
                fromDate,
                toDate,
                direction)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelSampleResponse>() {
                    @Override
                    public void onCompleted() {
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Utility.showSnackBar(activity, Constants.error_msg_failed);
                        mlistener_response._onError(e);

                    }

                    @Override
                    public void onNext(ModelSampleResponse model) {

                        mlistener_response._onNext(model);

                    }

                });
    }


}