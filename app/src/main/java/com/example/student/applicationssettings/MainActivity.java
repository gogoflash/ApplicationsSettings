package com.example.student.applicationssettings;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String APP_PERMITTIONS = "APP_PERMITTIONS";
    public static final String APP_NAME = "APP_NAME";
    private ListView list;

    public static final String APP_EXTRA = "APP_EXTRA";

    private ArrayList<ApplicationData> appsData = new ArrayList<>();
    //private List<String> appsData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        //ArrayList<ApplicationData> arrayOfUsers = new ArrayList<ApplicationData>();
        appsData = new ArrayList<ApplicationData>();

        fillAppsData();

        ApplicationsAdapter adapter = new ApplicationsAdapter(this, appsData);

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);


    }

    private void fillAppsData()
    {
        ApplicationData appData;

        StringBuffer appNameAndPermissions;
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo applicationInfo : packages)
        {
            //Log.d("appC", "App: " + applicationInfo.name + " Package: " + applicationInfo.packageName);
            //System.out.println("App: " + applicationInfo.name + " Package: " + applicationInfo.packageName);
            try {

                appData = new ApplicationData(applicationInfo.loadLabel(packageManager).toString(), applicationInfo.packageName);
                appsData.add(appData);

                appData.icon = getPackageManager().getApplicationIcon(applicationInfo.packageName);
                //Drawable icon = getPackageManager().getApplicationIcon("com.example.testnotification");
                //imageView.setImageDrawable(icon);

                PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, PackageManager.GET_PERMISSIONS);

                appNameAndPermissions = new StringBuffer();
                //appNameAndPermissions.append(packageInfo.packageName+"*:\n");

                //Get Permissions
                String[] requestedPermissions = packageInfo.requestedPermissions;
                if(requestedPermissions != null) {
                    for (int i = 0; i < requestedPermissions.length; i++) {
                        //Log.d("test", requestedPermissions[i]);
                        if(i % 2 != 0) {
                            appNameAndPermissions.append(Integer.toString(i + 1) + ". " + requestedPermissions[i]+ "<br>");
                        }
                        else {
                            appNameAndPermissions.append("<font color=\"#666699\"><b>" + (i + 1) + ". " + requestedPermissions[i]+ "</b></font>" + "<br>");
                        }
                    }

                    appNameAndPermissions.append("\n");
                    appData.setPermittions(appNameAndPermissions.toString());
                }

                appsData.add(appData);

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ApplicationData appData = (ApplicationData) appsData.get(position);
        //Log.d("hamster", ss);

        Intent intent = new Intent(this, AppPermittionsDetalize.class);
        intent.putExtra(APP_PERMITTIONS, appData.getPermittions());
        intent.putExtra(APP_NAME, appData.name);
        //startActivityForResult(intent, RATING_REQUEST);
        startActivity(intent);
    }


}
