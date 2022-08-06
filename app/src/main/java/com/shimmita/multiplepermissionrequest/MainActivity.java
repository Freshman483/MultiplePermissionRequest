package com.shimmita.multiplepermissionrequest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public final String TAG="MainActivity";
    ActivityResultLauncher<String[]> mPermissions;

    private boolean isReadPermissionGranted = false;
    private boolean isLocationPermissionGranted = false;
    private boolean isRecordPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "\nonCreate: 000\n");

        Log.d(TAG, "\nonCreate: In Step 0 readGrant? :"+isReadPermissionGranted);
        Log.d(TAG, "\nonCreate  In Step 0 locationGrant? :"+isLocationPermissionGranted);
        Log.d(TAG, "\nonCreate  In Step 0  recordGranted? :"+isRecordPermissionGranted);



        mPermissions = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {

                //8
                Log.d(TAG, "\nonActivityResult: after initialisation of mPermissions  Step 8\n");


                Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 8 readGrant? :"+isReadPermissionGranted);
                Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 8 locationGrant? :"+isLocationPermissionGranted);
                Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 8  recordGranted? :"+isRecordPermissionGranted);
                //

                if (Boolean.TRUE.equals(result.get(Manifest.permission.READ_EXTERNAL_STORAGE != null))) {
                    //9
                    Log.d(TAG, "\nonActivityResult: if(Boolean.TRUE.equals(result.get(Manifest.permission.READ_EXTERNAL_STORAGE != null))) step 9\n");
                    isReadPermissionGranted = result.get(Manifest.permission.READ_EXTERNAL_STORAGE);
                    Log.d(TAG, "\nonActivityResult: readGrant: "+isReadPermissionGranted);

                }
                if (Boolean.TRUE.equals(result.get(Manifest.permission.ACCESS_FINE_LOCATION != null))) {

                    //10
                    Log.d(TAG, "\nonActivityResult: if (Boolean.TRUE.equals(result.get(Manifest.permission.ACCESS_FINE_LOCATION != null))) step 10\n");

                    isReadPermissionGranted = result.get(Manifest.permission.ACCESS_FINE_LOCATION);
                    Log.d(TAG, "\nonActivityResult: locationGrant:"+isLocationPermissionGranted);
                }

                if (Boolean.TRUE.equals(result.get(Manifest.permission.RECORD_AUDIO != null))) {

                    // 11
                     Log.d(TAG, "\nonActivityResult:  if (Boolean.TRUE.equals(result.get(Manifest.permission.RECORD_AUDIO != null))) step 11\n");
                    isReadPermissionGranted = result.get(Manifest.permission.RECORD_AUDIO);
                    Log.d(TAG, "\nonActivityResult: recordGrant:"+isRecordPermissionGranted);
                }
            }
        });
        requestPermissionsFunction();
    }

    //1
    private void requestPermissionsFunction() {
        Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 1\n ");
        isReadPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        isLocationPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        isRecordPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED;

        Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 1 readGrant? :"+isReadPermissionGranted);
        Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 1 locationGrant? :"+isLocationPermissionGranted);
        Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 1  recordGranted? :"+isRecordPermissionGranted);



     //2
        List<String> permissionList = new ArrayList<String>();
        Log.d(TAG, "\nrequestPermissionsFunction: List In Step 2\n");

      //3
        if (!isReadPermissionGranted) {
            Log.d(TAG, "\nrequestPermissionsFunction: if (!isReadPermissionGranted) Step 3\n");
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            Log.d(TAG, "\nrequestPermissionsFunction: !isreadpermissiongranted: "+!isReadPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 3 readGrant? :"+isRecordPermissionGranted);

        }

        //4
        if (!isLocationPermissionGranted) {
            Log.d(TAG, "\nrequestPermissionsFunction:  if (!isLocationPermissionGranted) Step 4\n");
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
            Log.d(TAG, "\nrequestPermissionsFunction: !isLocationpermissiongranted: "+!isLocationPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 3 locationGrant? :"+isLocationPermissionGranted);

        }

        //5
        if (!isRecordPermissionGranted) {
            Log.d(TAG, "\nrequestPermissionsFunction: if (!isRecordPermissionGranted) Step 5\n");
            permissionList.add(Manifest.permission.RECORD_AUDIO);
            Log.d(TAG, "\nrequestPermissionsFunction: !isrecordpermissiongranted: "+!isRecordPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 3  recordGranted? :"+isRecordPermissionGranted);

        }


        //6

        //if permission list is empty then it means all the permissions were granted;
        //using negate permissionlist means they are not granted
        if (!permissionList.isEmpty()) {
            Log.d(TAG, "\nrequestPermissionsFunction: if (!permissionList.isEmpty()) Step 6\n");
            mPermissions.launch(permissionList.toArray(new String[0]));
            Log.d(TAG, "\nrequestPermissionsFunction: !permissionList.isEmpty(): "+ !permissionList.isEmpty());


            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 6 readGrant? :"+isReadPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 6 locationGrant? :"+isLocationPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 6  recordGranted? :"+isRecordPermissionGranted);

        }

        //7
        if (permissionList.isEmpty())
        {
            Log.d(TAG, "\nrequestPermissionsFunction:  if (permissionList.isEmpty()) Step 7\n");
            Log.d(TAG, "\nrequestPermissionsFunction: permissionList.isEmpty(): "+permissionList.isEmpty());


            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 7 readGrant? :"+isReadPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 7 locationGrant? :"+isLocationPermissionGranted);
            Log.d(TAG, "\nrequestPermissionsFunction: ContextCompat In Step 8  recordGranted? :"+isRecordPermissionGranted);
        }

    }

}