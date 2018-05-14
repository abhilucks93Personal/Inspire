package com.viscocits.redeem.catalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelGetCampaignData {


    @SerializedName("Campaign_Id")
    @Expose
    private int campaignId;
    @SerializedName("CampaignTitle")
    @Expose
    private String campaignTitle;
    @SerializedName("CampaignDesc")
    @Expose
    private String campaignDesc;
    @SerializedName("CampaignStartDate")
    @Expose
    private String campaignStartDate;
    @SerializedName("CampaignEndDate")
    @Expose
    private String campaignEndDate;
    @SerializedName("CampaignTypeId")
    @Expose
    private int campaignTypeId;
    @SerializedName("CampaignBudget")
    @Expose
    private Object campaignBudget;
    @SerializedName("Client_Id")
    @Expose
    private int clientId;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("CreatedBy")
    @Expose
    private int createdBy;
    @SerializedName("IsActive")
    @Expose
    private boolean isActive;
    @SerializedName("ImagePath")
    @Expose
    private Object imagePath;
    @SerializedName("ContentType")
    @Expose
    private Object contentType;
    @SerializedName("Campaign_Priority")
    @Expose
    private int campaignPriority;
    @SerializedName("Totalpoints")
    @Expose
    private int totalpoints;
    @SerializedName("TotalSale")
    @Expose
    private int totalSale;
    @SerializedName("TotalBaseTarget")
    @Expose
    private int totalBaseTarget;
    @SerializedName("SalesTillDate")
    @Expose
    private int salesTillDate;
    @SerializedName("RewardImage")
    @Expose
    private Object rewardImage;
    @SerializedName("RankingImageText")
    @Expose
    private Object rankingImageText;
    @SerializedName("Ranking")
    @Expose
    private Object ranking;
    @SerializedName("TargetPending")
    @Expose
    private int targetPending;
    @SerializedName("SpentPerDay")
    @Expose
    private int spentPerDay;
    @SerializedName("IsCampaignShopOpenClose")
    @Expose
    private boolean isCampaignShopOpenClose;
    @SerializedName("IsWishListShowHide")
    @Expose
    private boolean isWishListShowHide;
    @SerializedName("ShowasCampaign")
    @Expose
    private boolean showasCampaign;
    @SerializedName("ShowOnHomepage")
    @Expose
    private boolean showOnHomepage;
    @SerializedName("Tier1Target")
    @Expose
    private int tier1Target;
    @SerializedName("Tier2Target")
    @Expose
    private int tier2Target;
    @SerializedName("Tier3Target")
    @Expose
    private int tier3Target;
    @SerializedName("Tier4Target")
    @Expose
    private int tier4Target;
    @SerializedName("Tier5Target")
    @Expose
    private int tier5Target;

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getCampaignDesc() {
        return campaignDesc;
    }

    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public void setCampaignStartDate(String campaignStartDate) {
        this.campaignStartDate = campaignStartDate;
    }

    public String getCampaignEndDate() {
        return campaignEndDate;
    }

    public void setCampaignEndDate(String campaignEndDate) {
        this.campaignEndDate = campaignEndDate;
    }

    public int getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(int campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public Object getCampaignBudget() {
        return campaignBudget;
    }

    public void setCampaignBudget(Object campaignBudget) {
        this.campaignBudget = campaignBudget;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Object getImagePath() {
        return imagePath;
    }

    public void setImagePath(Object imagePath) {
        this.imagePath = imagePath;
    }

    public Object getContentType() {
        return contentType;
    }

    public void setContentType(Object contentType) {
        this.contentType = contentType;
    }

    public int getCampaignPriority() {
        return campaignPriority;
    }

    public void setCampaignPriority(int campaignPriority) {
        this.campaignPriority = campaignPriority;
    }

    public int getTotalpoints() {
        return totalpoints;
    }

    public void setTotalpoints(int totalpoints) {
        this.totalpoints = totalpoints;
    }

    public int getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }

    public int getTotalBaseTarget() {
        return totalBaseTarget;
    }

    public void setTotalBaseTarget(int totalBaseTarget) {
        this.totalBaseTarget = totalBaseTarget;
    }

    public int getSalesTillDate() {
        return salesTillDate;
    }

    public void setSalesTillDate(int salesTillDate) {
        this.salesTillDate = salesTillDate;
    }

    public Object getRewardImage() {
        return rewardImage;
    }

    public void setRewardImage(Object rewardImage) {
        this.rewardImage = rewardImage;
    }

    public Object getRankingImageText() {
        return rankingImageText;
    }

    public void setRankingImageText(Object rankingImageText) {
        this.rankingImageText = rankingImageText;
    }

    public Object getRanking() {
        return ranking;
    }

    public void setRanking(Object ranking) {
        this.ranking = ranking;
    }

    public int getTargetPending() {
        return targetPending;
    }

    public void setTargetPending(int targetPending) {
        this.targetPending = targetPending;
    }

    public int getSpentPerDay() {
        return spentPerDay;
    }

    public void setSpentPerDay(int spentPerDay) {
        this.spentPerDay = spentPerDay;
    }

    public boolean isIsCampaignShopOpenClose() {
        return isCampaignShopOpenClose;
    }

    public void setIsCampaignShopOpenClose(boolean isCampaignShopOpenClose) {
        this.isCampaignShopOpenClose = isCampaignShopOpenClose;
    }

    public boolean isIsWishListShowHide() {
        return isWishListShowHide;
    }

    public void setIsWishListShowHide(boolean isWishListShowHide) {
        this.isWishListShowHide = isWishListShowHide;
    }

    public boolean isShowasCampaign() {
        return showasCampaign;
    }

    public void setShowasCampaign(boolean showasCampaign) {
        this.showasCampaign = showasCampaign;
    }

    public boolean isShowOnHomepage() {
        return showOnHomepage;
    }

    public void setShowOnHomepage(boolean showOnHomepage) {
        this.showOnHomepage = showOnHomepage;
    }

    public int getTier1Target() {
        return tier1Target;
    }

    public void setTier1Target(int tier1Target) {
        this.tier1Target = tier1Target;
    }

    public int getTier2Target() {
        return tier2Target;
    }

    public void setTier2Target(int tier2Target) {
        this.tier2Target = tier2Target;
    }

    public int getTier3Target() {
        return tier3Target;
    }

    public void setTier3Target(int tier3Target) {
        this.tier3Target = tier3Target;
    }

    public int getTier4Target() {
        return tier4Target;
    }

    public void setTier4Target(int tier4Target) {
        this.tier4Target = tier4Target;
    }

    public int getTier5Target() {
        return tier5Target;
    }

    public void setTier5Target(int tier5Target) {
        this.tier5Target = tier5Target;
    }

}

