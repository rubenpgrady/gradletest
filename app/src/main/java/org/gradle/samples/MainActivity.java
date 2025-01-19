package org.gradle.samples;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuilder output = new StringBuilder();
        PackageManager pm = getPackageManager();
        // Refer to https://developer.android.com/reference/android/content/pm/PackageManager.html#getInstalledPackages(int)
        // Quote: If flag MATCH_UNINSTALLED_PACKAGES is set, the package
        // information is retrieved from the list of uninstalled applications
        // (which includes installed applications as well as applications
        // with data directory i.e. applications which had been deleted
        // with DELETE_KEEP_DATA flag set).
        /*List<ApplicationInfo> applications = pm.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (ApplicationInfo info : applications) {
            // Refer to https://developer.android.com/reference/android/content/pm/ApplicationInfo
            output.append(appName);
            // TODO nativeLibraryDir
            output.append("\n");
        }
        output.append("\n");*/
        List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (PackageInfo info : packages) {
            // Refer to https://developer.android.com/reference/android/content/pm/PackageInfo
            output.append(info.packageName);
            if (info.applicationInfo != null) {
                output.append(" -> ");
                output.append(info.applicationInfo.nativeLibraryDir);
            }
            output.append("\n");
        }
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(output.toString());
    }

}
