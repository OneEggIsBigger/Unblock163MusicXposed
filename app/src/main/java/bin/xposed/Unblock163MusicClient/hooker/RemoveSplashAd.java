package bin.xposed.Unblock163MusicClient.hooker;

import android.content.pm.PackageManager;

import bin.xposed.Unblock163MusicClient.CloudMusicPackage;
import bin.xposed.Unblock163MusicClient.Hooker;
import bin.xposed.Unblock163MusicClient.Settings;
import de.robv.android.xposed.XC_MethodReplacement;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class RemoveSplashAd extends Hooker {

    @Override
    protected void howToHook() throws PackageManager.NameNotFoundException, IllegalAccessException {
        if (Settings.isRemoveUpdate()) {
            findAndHookMethod(CloudMusicPackage.LoadActivity.getClazz(), "a", "com.netease.cloudmusic.module.ad.meta.AdInfo", "int", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return null;
                }
            });

            findAndHookMethod(CloudMusicPackage.LoadAdActivity.getClazz(), "a", "android.content.Context", "com.netease.cloudmusic.module.ad.meta.AdInfo", "int", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return null;
                }
            });


        }
    }
}






