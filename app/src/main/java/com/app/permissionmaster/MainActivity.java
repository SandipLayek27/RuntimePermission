package com.app.permissionmaster;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,EasyPermissions.PermissionCallbacks{
    Button btn_single_permission,btn_multiple_permission;

    private static final String[] LOCATION_AND_CONTACTS ={Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS};
    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_LOCATION_CONTACTS_PERM = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();
    }

    private void findIds() {
        btn_single_permission=(Button)findViewById(R.id.btn_single_permission);
        btn_multiple_permission=(Button)findViewById(R.id.btn_multiple_permission);
        btn_single_permission.setOnClickListener(this);
        btn_multiple_permission.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btn_single_permission){
            if (hasCameraPermission()) {
                Toast.makeText(this, "TODO: Camera things", Toast.LENGTH_LONG).show();
            } else {
                EasyPermissions.requestPermissions(this,getString(R.string.rationale_camera), RC_CAMERA_PERM, Manifest.permission.CAMERA);
            }
        }else if(view==btn_multiple_permission){
            if (hasLocationAndContactsPermissions()) {
                Toast.makeText(this, "TODO: Location and Contacts things", Toast.LENGTH_LONG).show();
            } else {
                EasyPermissions.requestPermissions(this, getString(R.string.rationale_location_contacts), RC_LOCATION_CONTACTS_PERM, LOCATION_AND_CONTACTS);
            }
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }



    private boolean hasCameraPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA);
    }

    private boolean hasLocationAndContactsPermissions() {
        return EasyPermissions.hasPermissions(this, LOCATION_AND_CONTACTS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            boolean camPer=hasCameraPermission()?true:false;
            boolean locationContact=hasLocationAndContactsPermissions()?true:false;
            Toast.makeText(this, "CameraPermission:"+camPer+"\nLocationContact:"+locationContact, Toast.LENGTH_SHORT).show();
        }
    }
}
