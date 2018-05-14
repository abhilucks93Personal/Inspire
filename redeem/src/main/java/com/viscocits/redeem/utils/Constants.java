package com.viscocits.redeem.utils;

import android.Manifest;

/**
 * Created by abhi on 31/07/17.
 */

public class Constants {

    public static final int CLIENT_ID = 5;
    public static final int DEFAULT_CAMPAIGN_ID = 22;
    public static final int DEFAULT_CATEGORY_ID = 0;
    public static final int DEFAULT_USER_ID = 182115;
    public static final String DEFAULT_CAMPAIGN_NAME = "Carlsberg credits!";
    public static final String KEY_LOGIN_CHECK = "KEY_LOGIN_CHECK";
    public static final String PREF_PROFILE_DATA = "PREF_PROFILE_DATA";
    public static final String PREF_CAMPAIGNS = "PREF_CAMPAIGNS";


    public static String CLIENT_NAME = "Carlsberg";
    public static String IMAGE_BASE_URL = "http://gvc.aviniti.org/";


    public static String UserImgPath = IMAGE_BASE_URL + "Upload/" + CLIENT_NAME + "/UserImages/";
    public static String UserActivityImgPath = IMAGE_BASE_URL + "Upload/" + CLIENT_NAME + "/UserActivity/";
    public static String RecognitionImgPath = IMAGE_BASE_URL + "Upload/" + CLIENT_NAME + "/RecognitionImages/";
    public static String IdeaImgPath = IMAGE_BASE_URL + "Upload/" + CLIENT_NAME + "/IdeaImages/";
    public static String MainImageUploadPath = "/Upload/";
    public static String MainImagePath = "/Upload/";
    public static String UserActivityUploadPath = "/UserActivity/";
    public static String UserImageUploadPath = "/UserImages/";
    public static String TeamImageUploadPath = "/TeamImages/";
    public static String RecogImageUploadPath = "/RecognitionImages/";
    public static String IdeaImageUploadPath = "/IdeaImages/";
    public static String NoImage = "No-Image.jpg";
    public static String NoImageContentType = "image/jpeg";
    public static String defaultAvatar = "user.png";
    public static final int PAGE_SIZE = 25;
    public static final String STATUS_CODE_SUCCESS = "200";


    public static String readExternalPermission = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static String writeExternalPermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String cameraPermission = Manifest.permission.CAMERA;


    public static String error_msg_failed = "Something went wrong! Please try again.";
}
