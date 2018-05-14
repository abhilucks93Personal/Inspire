package com.viscocits.redeem.utils;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.viscocits.redeem.R;
import com.viscocits.redeem.catalogue.ModelGetCampaignData;
import com.viscocits.redeem.catalogue.ModelGetCampaignResponse;
import com.viscocits.redeem.catalogue.ModelLoginData;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.content.ContentValues.TAG;


/**
 * @author Wildnet technologies
 */
public class Utility {


    private static final int REQUEST_LOCATION = 2000;
    private static AlertDialog.Builder builder;
    private static AlertDialog alert;


    public static void datePickerDialog(Activity context, DatePickerDialog.OnDateSetListener listner) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(context, listner,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        dialog.show();
    }

    public static void datePickerDialogDob(Activity context, DatePickerDialog.OnDateSetListener listner) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(context, listner,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);

        dialog.show();
    }

    public static Uri getImageUri(Context context, Bitmap mBitmap) {
        Uri uri = null;
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            // Calculate inSampleSize
            // options.inSampleSize = calculateInSampleSize(options, 100, 100);
            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            Bitmap newBitmap = Bitmap.createScaledBitmap(mBitmap, 200, 200,
                    true);
            File file = new File(context.getFilesDir(), "Image"
                    + new Random().nextInt() + ".jpeg");
            FileOutputStream out = context.openFileOutput(file.getName(),
                    Context.MODE_WORLD_READABLE);

            newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            //Bitmap compressedImageBitmap = Compressor.getDefault(context).compressToBitmap(file1);
            out.flush();
            out.close();
            //get absolute path
            String realPath = file.getAbsolutePath();
            File f = new File(realPath);
            uri = Uri.fromFile(f);

        } catch (Exception e) {
            Log.e("Your Error Message", e.getMessage());
        }
        return uri;
    }


    @Nullable
    public static Uri saveBitmapToDisk(Context context, Bitmap bmp) {
        Uri finalUri = null;
      /*  File file = new File(context.getFilesDir(), "Image" + new Random().nextInt() + ".png");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 80, bytes);
        try {
            file.createNewFile();
            boolean wasSuccessful = file.createNewFile();
            if (!wasSuccessful)
                Log.e("error", "failed");
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            fo.close();
            File file1 = new Compressor(context).compressToFile(file);
            finalUri = Uri.fromFile(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return finalUri;
    }

    public static String getRealPathFromUri(Context mContext, Uri mUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(mContext, mUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public static void setStatusBarTranslucent(Activity context, boolean makeTranslucent) {
        if (makeTranslucent) {
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static void showSnackBar(Activity context, String str) {
        hideKeyboard(context);
        View view = context.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(view, str, Snackbar.LENGTH_LONG).show();

    }

    public static void showSnackBar(View view, String str) {
        Snackbar.make(view, str, Snackbar.LENGTH_LONG).show();

    }

    public static void showEditTextsAsMandatory(TextInputLayout... ets) {
        for (TextInputLayout et : ets) {


            String hint = et.getHint().toString() + "  ";

            et.setHint(Html.fromHtml(hint + "<font color=\"#ff0000\">" + "* " + "</font>"));
        }
    }

    public static void showEditTextsAsMandatory(EditText... ets) {
        for (EditText et : ets) {


            String hint = et.getHint().toString() + "  ";

            et.setHint(Html.fromHtml(hint + "<font color=\"#ff0000\">" + "* " + "</font>"));
        }
    }

    public static void displayAlert(final Context context, String title, String msg) {
        new AlertDialog.Builder(context).setMessage(msg).setTitle(title).setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do your code here
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();

            }
        }).show();
    }

    private static void call() {


    }

    public static boolean checkPermissions(Context context, String... permissions) {
        for (String permission : permissions) {
            int res = context.checkCallingOrSelfPermission(permissions[0]);
            if (res != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        //String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String expression = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static String convertDate(String str) {

        String[] separated = str.split("T");
        String date = formatDateFromString("yyyy-MM-dd", "MMM d, yyyy", separated[0]);

        return date;
    }

    public static String convertDateOnly(String str) {

        String[] separated = str.split("T");
        String date = separated[0];

        return date;
    }

   /* public static boolean checkGooglePlayServicesAvailable(Activity activity) {
        final int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS) {
            return true;
        }

        Log.e("LOGTAG", "Google Play Services not available: " + GooglePlayServicesUtil.getErrorString(status));

        if (GooglePlayServicesUtil.isUserRecoverableError(status)) {
            final Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(status, activity, 1);
            if (errorDialog != null) {
                errorDialog.show();
            }
        }

        return false;
    }*/

    public static String formatDateFromString(String inputFormat, String outputFormat, String inputDate) {

        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.e(TAG, "ParseException - dateFormat");
        }

        return outputDate;

    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static void showDevelopmentToast(Context context) {
        Toast.makeText(context, "Under Development", Toast.LENGTH_SHORT).show();
    }

    public static void addPreferences(Context context, String key, String value) {
        if (context != null) {
            SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static void addPreferences(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void addPreferenceProfileData(Context context, ModelLoginData modelLoginData) {
        if (modelLoginData != null) {
            SharedPreferences pref = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
            pref.edit().putString(Constants.PREF_PROFILE_DATA,
                    getJson(modelLoginData)).commit();
        } else {
            SharedPreferences pref = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
            pref.edit().putString(Constants.PREF_PROFILE_DATA, null).commit();
        }

    }

    public static ModelLoginData getPreferenceProfileData(Context context) {
        SharedPreferences pref = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        ModelLoginData profile = parseJson(pref.getString(Constants.PREF_PROFILE_DATA, "{}"), ModelLoginData.class);
        return profile;
    }

    public static void addPreferenceCampaignData(Context context, ArrayList<ModelGetCampaignData> campaigns) {
        if (campaigns != null) {
            SharedPreferences pref = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
            pref.edit().putString(Constants.PREF_CAMPAIGNS,
                    getJson(campaigns)).commit();
        } else {
            SharedPreferences pref = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
            pref.edit().putString(Constants.PREF_CAMPAIGNS, null).commit();
        }

    }

    public static ArrayList<ModelGetCampaignData> getPreferenceCampaignData(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        ArrayList<ModelGetCampaignData> campaigns = parseJson(prefs.getString(Constants.PREF_CAMPAIGNS, "[]"),
                new TypeToken<ArrayList<ModelGetCampaignData>>() {
                }.getType());
        return campaigns;
    }

    public static <T> T parseJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }


    public static String getJson(Object profile) {
        return new Gson().toJson(profile);
    }


    public static String getPreferences(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        String text = prefs.getString(key, "");
        return text;
    }


    public static Boolean getPreferences(Context context, String key, boolean defaut) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        Boolean text = prefs.getBoolean(key, defaut);
        return text;
    }

    public static void clearPreferenceData(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }

    public static boolean lengthValidation(String str) {
        if (str.length() > 0)
            return true;
        else
            return false;
    }

    public static boolean isInternetConnected(Activity mContext) {


        if (mContext != null) {
            hideKeyboard(mContext);
            ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            } else {
                showSnackBar(mContext, "offline msg");
            }
        }

        return false;
    }

    public static void showToast(Context mContext, String string) {
        Toast t = Toast.makeText(mContext, string, Toast.LENGTH_SHORT);
        t.show();

    }

    public static boolean isLocationEnabled(Context context) {

        LocationManager lm = null;
        boolean gps_enabled = false, network_enabled = false;
        if (lm == null) {
            lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        }
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }
        if (gps_enabled == true && network_enabled == true) {
            return true;
        } else {
            return false;
        }

    }

    public static String getFormattedPostDate(String _endDate) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

        _endDate = _endDate.replace("T", " ");

        Date endDate = null;
        try {
            endDate = dateFormat.parse(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault()).parse(_endDate)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //milliseconds
        StringBuilder updatedTime = new StringBuilder();


        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateFormat.format(cal.getTime()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (endDate != null) {
            long different = startDate.getTime() - endDate.getTime();


            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            System.out.printf(
                    "%d days, %d hours, %d minutes, %d seconds%n",
                    elapsedDays,
                    elapsedHours, elapsedMinutes, elapsedSeconds);
            if (elapsedDays > 0) {
                updatedTime.append(elapsedDays + " days ago");
                return updatedTime.toString();

            }
            if (elapsedHours > 0) {
                updatedTime.append(elapsedHours + " hour ago");
                return updatedTime.toString();


            }
            if (elapsedMinutes > 0) {
                updatedTime.append(elapsedMinutes + " minutes ago");
                return updatedTime.toString();


            }
            if (elapsedSeconds > 0) {
                updatedTime.append(elapsedSeconds + " seconds ago");
                return updatedTime.toString();


            }
            return "Just now";
        } else
            return "";
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static String getEncoded64ImageStringFromBitmap(Bitmap bmp) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);

        return imgString;
    }

    public static Bitmap getBitmapFromUri(Context context, Uri imageUri) {

        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static String getEncoded64ImageStringFromUri(Context context, Uri mImageUri) {

        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), mImageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);

        return imgString;

    }

    public static void password_visible(EditText et_password, ImageView iv) {
        if (et_password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            et_password.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
            iv.setImageResource(R.drawable.ic_launcher_round);
        } else {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            iv.setImageResource(R.drawable.ic_launcher_round);
        }
        et_password.setSelection(et_password.getText().length());
    }


   /* public static Uri saveBitmapToDisk(Context context, Bitmap bmp) {
        Uri finalUri = null;
        File file = new File(context.getFilesDir(), "Image" + new Random().nextInt() + ".png");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 80, bytes);
        try {
            file.createNewFile();
            boolean wasSuccessful = file.createNewFile();
            if (!wasSuccessful)
                Log.e("error", "failed");
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            fo.close();
            File file1 = new Compressor(context).compressToFile(file);
            finalUri = Uri.fromFile(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalUri;
    }
*/

    public static String getLoginErrorMessage(int loginType) {
        switch (loginType) {
            case 0:
                return "This email ID is already registered.";
            case 1:
                return "This email ID is already registered. Login with Facebook";
            case 2:
                return "This email ID is already registered. Login with Gmail";
        }
        return "This email ID is already registered.";
    }


    public static void showTextViewsAsMandatory(TextView... tvs) {
        for (TextView tv : tvs) {
            String hint = tv.getHint().toString() + " ";
            tv.setHint(Html.fromHtml(hint + "<font color=\"#ff0000\">" + "* " + "</font>"));
        }
    }

    public static void showDialog(Activity activity, String alert, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);

        // set title
        //alertDialogBuilder.setTitle(alert);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }


    public static void shareImageOnly(Activity activity, ImageView imageView) {
        try {
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            if (drawable != null) {
                Bitmap bitmap = drawable.getBitmap();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("image/*");
                i.putExtra(Intent.EXTRA_STREAM, Utility.getLocalBitmapUri(activity.getApplicationContext(), bitmap));
                activity.startActivity(Intent.createChooser(i, "Share with"));
            }
        } catch (Exception e) {
            Utility.showToast(activity.getApplicationContext(), "Cannot share this post");
        }

    }

    public static void shareImagesOnly(Activity activity, ArrayList<ImageView> imageViews) {
        try {
            ArrayList<Uri> files = new ArrayList<>();
            int index = 0;
            for (ImageView iv : imageViews) {
                BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
                if (drawable != null) {
                    Bitmap bitmap = drawable.getBitmap();
                    Uri uri = Utility.getLocalBitmapUri2(activity.getApplicationContext(), bitmap, index);
                    files.add(uri);
                }
                index++;
            }

            Intent i = new Intent(Intent.ACTION_SEND_MULTIPLE);
            i.setType("image/*");

            i.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
            activity.startActivity(Intent.createChooser(i, "Share with"));

        } catch (Exception e) {
            Utility.showToast(activity.getApplicationContext(), "Cannot share this post");
        }

    }

    public static Intent shareImageIntent(Context context, ImageView imageView) {
        Intent i = null;
        try {
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            if (drawable != null) {
                Bitmap bitmap = drawable.getBitmap();
                i = new Intent(Intent.ACTION_SEND);
                i.setType("image/*");
                i.putExtra(Intent.EXTRA_STREAM, Utility.getLocalBitmapUri(context, bitmap));

            }
        } catch (Exception e) {
            Utility.showToast(context, "Cannot share this post");
        }

        return i;
    }

    public static Uri getLocalBitmapUri(Context context, Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "image.png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    public static Uri getLocalBitmapUri2(Context context, Bitmap bmp, int i) {
        Uri bmpUri = null;
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "" + i + "image.png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    public static void buildAlertMessageNoGps(final Activity _activity) {
        if (builder == null) {
            builder = new AlertDialog.Builder(_activity);
            builder.setMessage("Your GPS seems to be disabled.Please turn on the GPS to find businesses around you.")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            _activity.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            dialog.cancel();
                        }
                    });
        }
        if (alert == null)
            alert = builder.create();
        if (!alert.isShowing())
            alert.show();
    }

    public static boolean isGpsEnabled(Activity activity) {
        boolean isEnabled = false;
        LocationManager locationManager = (LocationManager) activity.getApplicationContext().getSystemService(activity.getApplicationContext().LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // Check Permissions Now
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION);
                isEnabled = false;
            } else {
                isEnabled = true;
            }
        }

        return isEnabled;
    }

    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(address.getLocality()).append(", ");
                        sb.append(address.getAdminArea()).append(", ");
                        sb.append(address.getCountryName());
                        result = sb.toString();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Unable to connect Geocoder", e);
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("address", result);
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }
            }
        };
        thread.start();
    }


    public static void OpenPlayStore(Activity activity) {
        final String appPackageName = activity.getPackageName(); // getPackageName() from Context or Activity object
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static String getAppUrl(Activity activity) {
        final String appPackageName = activity.getPackageName(); // getPackageName() from Context or Activity object
        return "https://play.google.com/store/apps/details?id=" + appPackageName;

    }


    public static SweetAlertDialog getSweetAlertProgressDialog(Activity context) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.setTitleText("Adding item to cart");
        pDialog.setCancelable(false);
        pDialog.show();
        return null;
    }

    public static SweetAlertDialog getSweetAlertSuccessDialog(Activity context, String msg) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.setTitleText(msg);
        pDialog.setConfirmText("Ok");
        pDialog.show();
        return null;
    }
}
