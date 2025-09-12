# Sample Foreground Service

This sample project demonstrates the setup for a foreground service. The service in this project is
used to request location updates. The required permission, `<uses-permission android:name="
android.permission.FOREGROUND_SERVICE_LOCATION" />`, depends on the type of foreground service.

# Setup

## Manifest Setup

```xml

<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

    <!--Location Permissions-->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />

    <!--Foreground Service Permissions-->
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION" />

    <!--Restart Service After Reboot the Mobile Device-->
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

    <application>
        <!--other code here-->

        <!--Service-->
        <service android:name=".service.LocationService" android:enabled="true"
            android:exported="false" android:foregroundServiceType="location" />

        <!--Broadcast Receiver (Optional)-->
        <receiver android:name=".broadcast_receiver.RestartServiceBroadcastReceiver"
            android:enabled="true" android:exported="false">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>

        <!--other code here-->
    </application>
</manifest>
```

> [!IMPORTANT]  
> Check my article for the setup :point_right: [Foreground Service in Android - Medium](https://medium.com/@nicosnicolaou/foreground-service-in-android-9ff18be69ef6) :point_left: <br />

> [!IMPORTANT]
> Similar project with (Dart Language) :point_right: [SampleForegroundServiceFlutter](https://github.com/NicosNicolaou16/SampleForegroundServiceFlutter) :point_left: <br />

# Versioning

Target SDK version: 36 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.2.20 <br />
Gradle version: 8.13.0 <br />

# References

https://developer.android.com/about/versions/14/changes/fgs-types-required <br />
https://stackoverflow.com/questions/14385231/android-broadcastreceiver-auto-run-service-after-reboot-of-device <br />