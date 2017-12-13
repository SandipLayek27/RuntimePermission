# RuntimePermission
Here user easily access Runtime Permission(Single and Multiple) Permissions both accessible. 
We modify this library for my working purpose.
Here, we used some pre generated libraries and modify it's working process.
## Developed
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27)  
# ★ Gradle Dependency
Here, We download .jar file from link below and drop this jar file to your libs folder:
LINK:-
https://github.com/SandipLayek27/RuntimePermission/blob/master/app/libs/MarshmallowPermission.jar
Now Copy this .jar file.
and now, GoTo application Project file and libs folder and paste this .jar file here.
Now sync your application again.

# ★ Features are.
1. Single Run-Time Permission.
2. Multiple Run-Time Permission.

# ★ Screen
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p1.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p2.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p3.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p4.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p5.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/p6.png)
![alt text](https://raw.githubusercontent.com/SandipLayek27/RuntimePermission/master/app/src/main/assets/pm1.png)

# ★ Uses of this features.
```sh
❆ activity_main.xml PAGE:-
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Single Permission"
        android:id="@+id/btn_single_permission"/>
    <Button
        android:id="@+id/btn_multiple_permission"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Multiple Permission"/>
</LinearLayout>
----------------------------------------------------------------------------------------------------------
❆ MainActivity.java PAGE:-
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
        if(requestCode==123){
            Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
        }else if(requestCode==124){

        }else{
            Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivity(intent);
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
}
----------------------------------------------------------------------------------------------------------
❆ strings.xml PAGE:-
<string name="rationale_camera">This app needs access to your camera so you can take pictures.</string>
<string name="rationale_location_contacts">This app needs access to your location and contacts to know where and who you are.</string>
----------------------------------------------------------------------------------------------------------
❆ AndroidManifest.xml PAGE:-
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.READ_CONTACTS" />
```
