package com.viscocits.redeem.catalogue;

public class ModelGetAllProductsData {

    private String Name;
    private String ImageName;
    private String Description;
    private Double ClientPrice;
    private String Brand;
    private String Code;
    private String Tags;
    private Long ProductId;
    private Double TotalAmount;
    private Double CartAmount;
    private Double ProductCount;
    private String ResultType;
    private Boolean InStock;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getClientPrice() {
        return ClientPrice;
    }

    public void setClientPrice(Double clientPrice) {
        ClientPrice = clientPrice;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public Long getProductId() {
        if (ProductId == null)
            ProductId = (long) -1;
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public Double getCartAmount() {
        return CartAmount;
    }

    public void setCartAmount(Double cartAmount) {
        CartAmount = cartAmount;
    }

    public Double getProductCount() {
        return ProductCount;
    }

    public void setProductCount(Double productCount) {
        ProductCount = productCount;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }

    public Boolean getInStock() {
        return InStock;
    }

    public void setInStock(Boolean inStock) {
        InStock = inStock;
    }
}
