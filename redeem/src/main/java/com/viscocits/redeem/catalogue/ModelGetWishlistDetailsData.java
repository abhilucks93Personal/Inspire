package com.viscocits.redeem.catalogue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelGetWishlistDetailsData implements Parcelable{


    @SerializedName("User_id")
    @Expose
    private int userId;
    @SerializedName("Product_id")
    @Expose
    private int productId;
    @SerializedName("ProductCode")
    @Expose
    private String productCode;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("ProductDescription")
    @Expose
    private String productDescription;
    @SerializedName("Quantity")
    @Expose
    private int quantity;
    @SerializedName("ImageName")
    @Expose
    private String imageName;
    @SerializedName("CartAmount")
    @Expose
    private int cartAmount;
    @SerializedName("ClientPrice")
    @Expose
    private int clientPrice;
    @SerializedName("Published")
    @Expose
    private boolean published;
    @SerializedName("InStock")
    @Expose
    private boolean inStock;
    @SerializedName("WishList_Id")
    @Expose
    private int wishListId;

    protected ModelGetWishlistDetailsData(Parcel in) {
        userId = in.readInt();
        productId = in.readInt();
        productCode = in.readString();
        productName = in.readString();
        productDescription = in.readString();
        quantity = in.readInt();
        imageName = in.readString();
        cartAmount = in.readInt();
        clientPrice = in.readInt();
        published = in.readByte() != 0;
        inStock = in.readByte() != 0;
        wishListId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(productId);
        dest.writeString(productCode);
        dest.writeString(productName);
        dest.writeString(productDescription);
        dest.writeInt(quantity);
        dest.writeString(imageName);
        dest.writeInt(cartAmount);
        dest.writeInt(clientPrice);
        dest.writeByte((byte) (published ? 1 : 0));
        dest.writeByte((byte) (inStock ? 1 : 0));
        dest.writeInt(wishListId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelGetWishlistDetailsData> CREATOR = new Creator<ModelGetWishlistDetailsData>() {
        @Override
        public ModelGetWishlistDetailsData createFromParcel(Parcel in) {
            return new ModelGetWishlistDetailsData(in);
        }

        @Override
        public ModelGetWishlistDetailsData[] newArray(int size) {
            return new ModelGetWishlistDetailsData[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    public int getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(int clientPrice) {
        this.clientPrice = clientPrice;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }
}
