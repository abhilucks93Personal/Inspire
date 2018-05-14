package com.viscocits.redeem.catalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLoginData {


    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("OnHold")
    @Expose
    private boolean onHold;
    @SerializedName("Forename")
    @Expose
    private String forename;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("Id")
    @Expose
    private int id;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("PasswordSalt")
    @Expose
    private String passwordSalt;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("AccessLevel")
    @Expose
    private int accessLevel;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("WorkTelephone")
    @Expose
    private String workTelephone;
    @SerializedName("CompanyName")
    @Expose
    private String companyName;
    @SerializedName("Department")
    @Expose
    private String department;
    @SerializedName("MobileTelephone")
    @Expose
    private String mobileTelephone;
    @SerializedName("Address1")
    @Expose
    private String address1;
    @SerializedName("Address2")
    @Expose
    private String address2;
    @SerializedName("Address3")
    @Expose
    private String address3;
    @SerializedName("Address4")
    @Expose
    private String address4;
    @SerializedName("AddressVerified")
    @Expose
    private boolean addressVerified;
    @SerializedName("Postcode")
    @Expose
    private String postcode;
    @SerializedName("DoB")
    @Expose
    private String doB;
    @SerializedName("Enabled")
    @Expose
    private boolean enabled;
    @SerializedName("CanContact")
    @Expose
    private boolean canContact;
    @SerializedName("ContactViaEmail")
    @Expose
    private boolean contactViaEmail;
    @SerializedName("BusinessType")
    @Expose
    private Object businessType;
    @SerializedName("Notes")
    @Expose
    private Object notes;
    @SerializedName("Team_id")
    @Expose
    private int teamId;
    @SerializedName("Client")
    @Expose
    private Object client;
    @SerializedName("OldId")
    @Expose
    private int oldId;
    @SerializedName("OldPassword")
    @Expose
    private String oldPassword;
    @SerializedName("AccountExpires")
    @Expose
    private Object accountExpires;
    @SerializedName("LastResetRequest")
    @Expose
    private String lastResetRequest;
    @SerializedName("branchID")
    @Expose
    private int branchID;
    @SerializedName("JobDescription")
    @Expose
    private int jobDescription;
    @SerializedName("Client_ID")
    @Expose
    private int clientID;
    @SerializedName("ParentUserId")
    @Expose
    private int parentUserId;
    @SerializedName("RoleId")
    @Expose
    private int roleId;
    @SerializedName("RoleTitle")
    @Expose
    private Object roleTitle;
    @SerializedName("ChildCount")
    @Expose
    private int childCount;
    @SerializedName("ProfilePic")
    @Expose
    private String profilePic;
    @SerializedName("UserId")
    @Expose
    private int userId;
    @SerializedName("IsTermsAccepted")
    @Expose
    private boolean isTermsAccepted;
    @SerializedName("AlternateEmail")
    @Expose
    private String alternateEmail;
    @SerializedName("IsSA")
    @Expose
    private boolean isSA;
    @SerializedName("TotalDebit")
    @Expose
    private int totalDebit;
    @SerializedName("TotalCredit")
    @Expose
    private int totalCredit;
    @SerializedName("CustomField1")
    @Expose
    private String customField1;
    @SerializedName("RoleName")
    @Expose
    private String roleName;
    @SerializedName("CurrentBalance")
    @Expose
    private double currentBalance;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("UserPic")
    @Expose
    private Object userPic;
    @SerializedName("WishlishDetails")
    @Expose
    private String wishlishDetails;
    @SerializedName("ClientName")
    @Expose
    private String clientName;
    @SerializedName("CartDetails")
    @Expose
    private String cartDetails;
    @SerializedName("IsDetailsUpdated")
    @Expose
    private boolean isDetailsUpdated;
    @SerializedName("IsRebate")
    @Expose
    private boolean isRebate;
    @SerializedName("IsCampaign")
    @Expose
    private boolean isCampaign;
    @SerializedName("CampaignCount")
    @Expose
    private int campaignCount;
    @SerializedName("CurrentCampaignId")
    @Expose
    private int currentCampaignId;
    @SerializedName("WishListShowHide")
    @Expose
    private boolean wishListShowHide;
    @SerializedName("ShopOpenClose")
    @Expose
    private boolean shopOpenClose;
    @SerializedName("UserGroupId")
    @Expose
    private int userGroupId;
    @SerializedName("UserGroupName")
    @Expose
    private Object userGroupName;
    @SerializedName("LastLoginDate")
    @Expose
    private String lastLoginDate;
    @SerializedName("CampaignProfileUpdate")
    @Expose
    private boolean campaignProfileUpdate;
    @SerializedName("CampaignName")
    @Expose
    private String campaignName;
    @SerializedName("IsPasswordReset")
    @Expose
    private boolean isPasswordReset;
    @SerializedName("PrimaryDomain")
    @Expose
    private Object primaryDomain;
    @SerializedName("SubDomain")
    @Expose
    private Object subDomain;
    @SerializedName("ResendURL")
    @Expose
    private Object resendURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOnHold() {
        return onHold;
    }

    public void setOnHold(boolean onHold) {
        this.onHold = onHold;
    }

    public String getForename() {
        if (forename == null)
            forename = "";
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public void setWorkTelephone(String workTelephone) {
        this.workTelephone = workTelephone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobileTelephone() {
        return mobileTelephone;
    }

    public void setMobileTelephone(String mobileTelephone) {
        this.mobileTelephone = mobileTelephone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public boolean isAddressVerified() {
        return addressVerified;
    }

    public void setAddressVerified(boolean addressVerified) {
        this.addressVerified = addressVerified;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCanContact() {
        return canContact;
    }

    public void setCanContact(boolean canContact) {
        this.canContact = canContact;
    }

    public boolean isContactViaEmail() {
        return contactViaEmail;
    }

    public void setContactViaEmail(boolean contactViaEmail) {
        this.contactViaEmail = contactViaEmail;
    }

    public Object getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Object businessType) {
        this.businessType = businessType;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Object getAccountExpires() {
        return accountExpires;
    }

    public void setAccountExpires(Object accountExpires) {
        this.accountExpires = accountExpires;
    }

    public String getLastResetRequest() {
        return lastResetRequest;
    }

    public void setLastResetRequest(String lastResetRequest) {
        this.lastResetRequest = lastResetRequest;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public int getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(int jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(int parentUserId) {
        this.parentUserId = parentUserId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Object getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(Object roleTitle) {
        this.roleTitle = roleTitle;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIsTermsAccepted() {
        return isTermsAccepted;
    }

    public void setIsTermsAccepted(boolean isTermsAccepted) {
        this.isTermsAccepted = isTermsAccepted;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public boolean isIsSA() {
        return isSA;
    }

    public void setIsSA(boolean isSA) {
        this.isSA = isSA;
    }

    public int getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(int totalDebit) {
        this.totalDebit = totalDebit;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getCurrentBalance() {
        return (int) currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Object getUserPic() {
        return userPic;
    }

    public void setUserPic(Object userPic) {
        this.userPic = userPic;
    }

    public String getWishlishDetails() {
        return wishlishDetails;
    }

    public void setWishlishDetails(String wishlishDetails) {
        this.wishlishDetails = wishlishDetails;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(String cartDetails) {
        this.cartDetails = cartDetails;
    }

    public boolean isIsDetailsUpdated() {
        return isDetailsUpdated;
    }

    public void setIsDetailsUpdated(boolean isDetailsUpdated) {
        this.isDetailsUpdated = isDetailsUpdated;
    }

    public boolean isIsRebate() {
        return isRebate;
    }

    public void setIsRebate(boolean isRebate) {
        this.isRebate = isRebate;
    }

    public boolean isIsCampaign() {
        return isCampaign;
    }

    public void setIsCampaign(boolean isCampaign) {
        this.isCampaign = isCampaign;
    }

    public int getCampaignCount() {
        return campaignCount;
    }

    public void setCampaignCount(int campaignCount) {
        this.campaignCount = campaignCount;
    }

    public int getCurrentCampaignId() {
        return currentCampaignId;
    }

    public void setCurrentCampaignId(int currentCampaignId) {
        this.currentCampaignId = currentCampaignId;
    }

    public boolean isWishListShowHide() {
        return wishListShowHide;
    }

    public void setWishListShowHide(boolean wishListShowHide) {
        this.wishListShowHide = wishListShowHide;
    }

    public boolean isShopOpenClose() {
        return shopOpenClose;
    }

    public void setShopOpenClose(boolean shopOpenClose) {
        this.shopOpenClose = shopOpenClose;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Object getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(Object userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isCampaignProfileUpdate() {
        return campaignProfileUpdate;
    }

    public void setCampaignProfileUpdate(boolean campaignProfileUpdate) {
        this.campaignProfileUpdate = campaignProfileUpdate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public boolean isIsPasswordReset() {
        return isPasswordReset;
    }

    public void setIsPasswordReset(boolean isPasswordReset) {
        this.isPasswordReset = isPasswordReset;
    }

    public Object getPrimaryDomain() {
        return primaryDomain;
    }

    public void setPrimaryDomain(Object primaryDomain) {
        this.primaryDomain = primaryDomain;
    }

    public Object getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(Object subDomain) {
        this.subDomain = subDomain;
    }

    public Object getResendURL() {
        return resendURL;
    }

    public void setResendURL(Object resendURL) {
        this.resendURL = resendURL;
    }

}

