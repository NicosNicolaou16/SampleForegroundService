# Sample Foreground Service

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This sample project demonstrates the setup and implementation of a foreground service in Android. It specifically showcases how to handle location updates and manage service persistence.

> [!IMPORTANT]  
> Check out the full guide here:  
> 👉 **[Foreground Service in Android - Medium](https://medium.com/@nicosnicolaou/foreground-service-in-android-9ff18be69ef6)** 👈

> [!IMPORTANT]
> Similar project with (Dart Language) :point_right: [SampleForegroundServiceFlutter](https://github.com/NicosNicolaou16/SampleForegroundServiceFlutter) :point_left: <br />

## ✨ Features

*   **Location Tracking:** Demonstrates background/foreground location updates.
*   **Android 14+ Ready:** Properly declares `foregroundServiceType` as required by the latest SDKs.
*   **Persistent Service:** Includes a Broadcast Receiver to restart the service after device reboots.
*   **Permission Management:** Shows the specific setup for `FOREGROUND_SERVICE_LOCATION`.

## 🛠️ Setup

### Manifest Configuration

To use a foreground service for location, you must declare the appropriate permissions and the service type in your `AndroidManifest.xml`:

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
Kotlin version: 2.3.10 <br />
Gradle version: 9.1.0 <br />

# References

https://developer.android.com/about/versions/14/changes/fgs-types-required <br />
https://stackoverflow.com/questions/14385231/android-broadcastreceiver-auto-run-service-after-reboot-of-device <br />


## 🔧 Versioning

- **Target SDK:** **36**
- **Minimum SDK:** **29**
- **Kotlin Version:** **2.3.10**
- **Gradle Version:** **9.1.0**

## 📚 References

- **Android Developers:** [Foreground service types are required](https://developer.android.com/about/versions/14/changes/fgs-types-required)
- **Stack Overflow:** [Auto-run service after reboot](https://stackoverflow.com/questions/14385231/android-broadcastreceiver-auto-run-service-after-reboot-of-device)

## ⭐ Stargazers

If you find this project useful, please give it a star!  
[View Stargazers on GitHub](https://github.com/NicosNicolaou16/SampleForegroundService/stargazers)

## 🙏 Support & Contributions

This project is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.