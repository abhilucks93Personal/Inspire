package com.viscocits.redeem.catalogue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelGetCartDetailsData implements Parcelable{


    @SerializedName("CartItem_Id")
    @Expose
    private int cartItemId;
    @SerializedName("Product_id")
    @Expose
    private int productId;
    @SerializedName("Quantity")
    @Expose
    private int quantity;
    @SerializedName("Cart_id")
    @Expose
    private int cartId;
    @SerializedName("PricePaid")
    @Expose
    private Double pricePaid;
    @SerializedName("TotalAmount")
    @Expose
    private int totalAmount;
    @SerializedName("OldId")
    @Expose
    private Object oldId;
    @SerializedName("Status")
    @Expose
    private Object status;
    @SerializedName("ExtraProduct")
    @Expose
    private Object extraProduct;
    @SerializedName("Surcharge")
    @Expose
    private Object surcharge;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("BasePricePaid")
    @Expose
    private Double basePricePaid;
    @SerializedName("Dispatched")
    @Expose
    private boolean dispatched;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ImageName")
    @Expose
    private String imageName;
    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("OrderNum")
    @Expose
    private Object orderNum;
    @SerializedName("Published")
    @Expose
    private boolean published;
    @SerializedName("InStock")
    @Expose
    private boolean inStock;
    @SerializedName("Address1")
    @Expose
    private Object address1;
    @SerializedName("Address2")
    @Expose
    private Object address2;
    @SerializedName("Town")
    @Expose
    private Object town;
    @SerializedName("County")
    @Expose
    private Object county;
    @SerializedName("Postcode")
    @Expose
    private Object postcode;
    @SerializedName("DeliveryAddress1")
    @Expose
    private Object deliveryAddress1;
    @SerializedName("DeliveryAddress2")
    @Expose
    private Object deliveryAddress2;
    @SerializedName("DeliveryTown")
    @Expose
    private Object deliveryTown;
    @SerializedName("DeliveryCounty")
    @Expose
    private Object deliveryCounty;
    @SerializedName("DeliveryPostcode")
    @Expose
    private Object deliveryPostcode;
    @SerializedName("Email")
    @Expose
    private Object email;
    @SerializedName("Branch")
    @Expose
    private Object branch;
    @SerializedName("Instruction")
    @Expose
    private Object instruction;
    @SerializedName("CustomerName")
    @Expose
    private Object customerName;
    @SerializedName("Company")
    @Expose
    private Object company;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("Telephone")
    @Expose
    private Object telephone;
    @SerializedName("Balance")
    @Expose
    private Object balance;

    protected ModelGetCartDetailsData(Parcel in) {
        cartItemId = in.readInt();
        productId = in.readInt();
        quantity = in.readInt();
        cartId = in.readInt();
        if (in.readByte() == 0) {
            pricePaid = null;
        } else {
            pricePaid = in.readDouble();
        }
        totalAmount = in.readInt();
        code = in.readString();
        if (in.readByte() == 0) {
            basePricePaid = null;
        } else {
            basePricePaid = in.readDouble();
        }
        dispatched = in.readByte() != 0;
        name = in.readString();
        imageName = in.readString();
        brand = in.readString();
        published = in.readByte() != 0;
        inStock = in.readByte() != 0;
        createdDate = in.readString();
    }

    public static final Creator<ModelGetCartDetailsData> CREATOR = new Creator<ModelGetCartDetailsData>() {
        @Override
        public ModelGetCartDetailsData createFromParcel(Parcel in) {
            return new ModelGetCartDetailsData(in);
        }

        @Override
        public ModelGetCartDetailsData[] newArray(int size) {
            return new ModelGetCartDetailsData[size];
        }
    };

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Double getPricePaid() {
        if (pricePaid == null)
            return 0.0;
        return pricePaid;
    }

    public void setPricePaid(Double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Object getOldId() {
        return oldId;
    }

    public void setOldId(Object oldId) {
        this.oldId = oldId;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getExtraProduct() {
        return extraProduct;
    }

    public void setExtraProduct(Object extraProduct) {
        this.extraProduct = extraProduct;
    }

    public Object getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Object surcharge) {
        this.surcharge = surcharge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBasePricePaid() {
        return basePricePaid;
    }

    public void setBasePricePaid(Double basePricePaid) {
        this.basePricePaid = basePricePaid;
    }

    public boolean isDispatched() {
        return dispatched;
    }

    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Object getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Object orderNum) {
        this.orderNum = orderNum;
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

    public Object getAddress1() {
        return address1;
    }

    public void setAddress1(Object address1) {
        this.address1 = address1;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public Object getTown() {
        return town;
    }

    public void setTown(Object town) {
        this.town = town;
    }

    public Object getCounty() {
        return county;
    }

    public void setCounty(Object county) {
        this.county = county;
    }

    public Object getPostcode() {
        return postcode;
    }

    public void setPostcode(Object postcode) {
        this.postcode = postcode;
    }

    public Object getDeliveryAddress1() {
        return deliveryAddress1;
    }

    public void setDeliveryAddress1(Object deliveryAddress1) {
        this.deliveryAddress1 = deliveryAddress1;
    }

    public Object getDeliveryAddress2() {
        return deliveryAddress2;
    }

    public void setDeliveryAddress2(Object deliveryAddress2) {
        this.deliveryAddress2 = deliveryAddress2;
    }

    public Object getDeliveryTown() {
        return deliveryTown;
    }

    public void setDeliveryTown(Object deliveryTown) {
        this.deliveryTown = deliveryTown;
    }

    public Object getDeliveryCounty() {
        return deliveryCounty;
    }

    public void setDeliveryCounty(Object deliveryCounty) {
        this.deliveryCounty = deliveryCounty;
    }

    public Object getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(Object deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getBranch() {
        return branch;
    }

    public void setBranch(Object branch) {
        this.branch = branch;
    }

    public Object getInstruction() {
        return instruction;
    }

    public void setInstruction(Object instruction) {
        this.instruction = instruction;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(Object telephone) {
        this.telephone = telephone;
    }

    public Object getBalance() {
        return balance;
    }

    public void setBalance(Object balance) {
        this.balance = balance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cartItemId);
        dest.writeInt(productId);
        dest.writeInt(quantity);
        dest.writeInt(cartId);
        if (pricePaid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(pricePaid);
        }
        dest.writeInt(totalAmount);
        dest.writeString(code);
        if (basePricePaid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(basePricePaid);
        }
        dest.writeByte((byte) (dispatched ? 1 : 0));
        dest.writeString(name);
        dest.writeString(imageName);
        dest.writeString(brand);
        dest.writeByte((byte) (published ? 1 : 0));
        dest.writeByte((byte) (inStock ? 1 : 0));
        dest.writeString(createdDate);
    }
}
