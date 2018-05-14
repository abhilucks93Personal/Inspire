package com.viscocits.redeem.retrofit;


import com.viscocits.redeem.catalogue.ModelGetAllCategoriesResponse;
import com.viscocits.redeem.catalogue.ModelGetAllProductsResponse;
import com.viscocits.redeem.catalogue.ModelGetBooleanDataResponse;
import com.viscocits.redeem.catalogue.ModelGetCampaignResponse;
import com.viscocits.redeem.catalogue.ModelGetCartDetailsResponse;
import com.viscocits.redeem.catalogue.ModelGetWishlistDetailsResponse;
import com.viscocits.redeem.catalogue.ModelLoginResponse;
import com.viscocits.redeem.catalogue.ModelGetStringDataResponse;
import com.viscocits.redeem.demo.ModelSampleResponse;

import java.util.Date;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * * Interface through which all the api calls will be performed
 */
public interface AppRequestService {

    @FormUrlEncoded
    @POST("UserLogin")
    Observable<ModelLoginResponse> login(@Field("Username") String strUserName,
                                         @Field("Password") String strPassword,
                                         @Field("Client_ID") int clientId);


    @FormUrlEncoded
    @POST("GetClientCategories")
    Observable<ModelGetAllCategoriesResponse> getAllCategories(@Field("ClientID") int clientId,
                                                               @Field("UserId") int defaultUserId,
                                                               @Field("Action") String action);

    @FormUrlEncoded
    @POST("GetAllCategoryProducts")
    Observable<ModelGetAllProductsResponse> getProducts(@Field("UserId") int userId,
                                                        @Field("ClientID") int clientId,
                                                        @Field("CampaignID") int campaignId,
                                                        @Field("CategoryID") int categoryId,
                                                        @Field("PageNumber") int pageNumber,
                                                        @Field("PageSize") int pageSize,
                                                        @Field("SearchCreteria") String searchCriteria,
                                                        @Field("PointsFrom") int pointsFrom,
                                                        @Field("PointsTo") int pointsTo,
                                                        @Field("BrandName") String brandName,
                                                        @Field("SortCol") String sortCol);

    @FormUrlEncoded
    @POST("GetAllCategoryProducts")
    Observable<ModelGetAllProductsResponse> getProductsByCategory(@Field("UserId") int userId,
                                                                  @Field("ClientID") int clientId,
                                                                  @Field("CampaignID") int campaignId,
                                                                  @Field("CategoryID") int categoryId);

    @FormUrlEncoded
    @POST("GetFeaturedProducts")
    Observable<ModelGetAllProductsResponse> getFeaturedProducts(@Field("UserId") int userId,
                                                                @Field("ClientID") int clientId,
                                                                @Field("CampaignID") int campaignId,
                                                                @Field("CategoryID") int categoryId,
                                                                @Field("PageNumber") int pageNumber,
                                                                @Field("PageSize") int pageSize);

    @FormUrlEncoded
    @POST("GetProductDetailsByID")
    Observable<ModelSampleResponse> getProductDetails(@Field("UserId") int userId,
                                                      @Field("ClientID") int clientId,
                                                      @Field("ProductID") int productId);

    @FormUrlEncoded
    @POST("AddToBasket")
    Observable<ModelGetBooleanDataResponse> addToBasket(@Field("ProductID") int productId,
                                                        @Field("Code") String code,
                                                        @Field("Quantity") int quantity,
                                                        @Field("CampaignID") int campaignId,
                                                        @Field("UserId") int userId);

    @FormUrlEncoded
    @POST("AddToWishlistFromCatalog")
    Observable<ModelGetStringDataResponse> addToWishlist(@Field("ProductID") int productId,
                                                         @Field("Quantity") int quantity,
                                                         @Field("CampaignID") int campaignId,
                                                         @Field("UserId") int userId);

    @FormUrlEncoded
    @POST("GetCartDetails")
    Observable<ModelGetCartDetailsResponse> getCartDetails(@Field("UserId") int userId,
                                                           @Field("CampaignID") int campaignId);

    @FormUrlEncoded
    @POST("GetUserWishList")
    Observable<ModelGetWishlistDetailsResponse> getWishlistDetails(@Field("UserId") int userId,
                                                                   @Field("CampaignID") int campaignId,
                                                                   @Field("ClientID") int clientId);

    @FormUrlEncoded
    @POST("UpdateCartQty")
    Observable<ModelSampleResponse> updateCartQty(@Field("ItemID") int userId,
                                                  @Field("Quantity") int quantity,
                                                  @Field("CountryID") int countryId);

    @FormUrlEncoded
    @POST("DeleteItem")
    Observable<ModelSampleResponse> deleteItem(@Field("ItemID") int userId,
                                               @Field("CountryID") int countryId);

    @FormUrlEncoded
    @POST("PlaceFinalOrder")
    Observable<ModelSampleResponse> placeFinalOrder(@Field("UserID") int userId,
                                                    @Field("ClientID") int clientId,
                                                    @Field("CartID") int cartId,
                                                    @Field("ClientName") String clientName,
                                                    @Field("Title") String title,
                                                    @Field("FirstName") String firstName,
                                                    @Field("LastName") String lastName,
                                                    @Field("Address1") String address1,
                                                    @Field("Address2") String address2,
                                                    @Field("Town") String town,
                                                    @Field("Country") String country,
                                                    @Field("PostCode") String postCode,
                                                    @Field("MobilePhone") String mobilePhone,
                                                    @Field("WorkPhone") String workPhone,
                                                    @Field("BranchID") String branchId,
                                                    @Field("EmailAddress") String emailAddress,
                                                    @Field("Notes") String notes,
                                                    @Field("IsTermAccepted") boolean isTermAccepted,
                                                    @Field("CampaignID") int campaignId);

    @FormUrlEncoded
    @POST("GetOrderDetailsConfirmation")
    Observable<ModelSampleResponse> getOrderDetailsConfirmation(@Field("UserId") int userId,
                                                                @Field("OrderNumber") String orderNumber,
                                                                @Field("CountryID") int countryId);

    @FormUrlEncoded
    @POST("GetOrderInvoiceDetails_OpenNewPage")
    Observable<ModelSampleResponse> getOrderInvoiceDetails(@Field("UserId") int userId,
                                                           @Field("OrderNumber") String orderNumber);

    @FormUrlEncoded
    @POST("GetRewardStatement")
    Observable<ModelSampleResponse> getRewardStatement(@Field("UserId") int userId,
                                                       @Field("CountryID") int countryId);

    @FormUrlEncoded
    @POST("GetTwoDirectionStatement")
    Observable<ModelSampleResponse> getTwoDirectionStatement(@Field("UserId") int userId,
                                                             @Field("CountryID") int countryId,
                                                             @Field("FromDate") Date fromDate,
                                                             @Field("ToDate") Date toDate,
                                                             @Field("Direction") int direction);


}