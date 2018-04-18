package bin.xposed.Unblock163MusicClient.hooker;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import bin.xposed.Unblock163MusicClient.CloudMusicPackage;
import bin.xposed.Unblock163MusicClient.Hooker;
import bin.xposed.Unblock163MusicClient.Settings;
import de.robv.android.xposed.XC_MethodHook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class RemoveUpdate extends Hooker {

    @Override
    protected void howToHook() throws PackageManager.NameNotFoundException, IllegalAccessException {
        if (Settings.isRemoveUpdate()) {

            findAndHookMethod(CloudMusicPackage.LoadActivity.getClazz(), "onCreate", "android.os.Bundle", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    SharedPreferences sharedPreferences = CloudMusicPackage.getContext().getSharedPreferences("com.netease.cloudmusic.preferences", 0);
                    sharedPreferences.edit().putBoolean("firstOpenApp", true).commit();
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    SharedPreferences sharedPreferences = CloudMusicPackage.getContext().getSharedPreferences("com.netease.cloudmusic.preferences", 0);
                    sharedPreferences.edit().putBoolean("firstOpenApp", false).commit();
                }
            });

        }
    }
}






