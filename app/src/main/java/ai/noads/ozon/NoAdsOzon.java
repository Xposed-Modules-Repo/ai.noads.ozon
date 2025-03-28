package ai.noads.ozon;

import java.util.ArrayList;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;


public class NoAdsOzon implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (lpparam.packageName.equals("ru.ozon.app.android")) {

            XposedHelpers.findAndHookMethod("ru.ozon.app.android.ugc.widgets.rateboughtitems.presentation.RateBoughtItemsBottomBehavior", lpparam.classLoader, "showBottomNavigationView", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                }
            });

            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.plain.single.AdvBannerV4SingleVO", lpparam.classLoader, "long", "ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4ItemVO", "boolean", "double", "int", "android.os.Parcelable", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[1] = new Object[0]; // Set banner to empty list
                    param.args[2] = false; // Set isPagerVisible to false
                }
            });

            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advPageStay.presentation.AdvPageStayVO", lpparam.classLoader, "long", "java.util.List", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[1] = new Object[0]; // Set events to empty list
                }
            });

            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4VO", lpparam.classLoader, "long", "java.util.List", "boolean", "double", "int", "android.os.Parcelable", "ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4VO$RotationOptions", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[1] = new Object[0]; // Set items to empty list
                    param.args[2] = false; // Set isPagerVisible to false
                }
            });

            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO", lpparam.classLoader, "long", "java.lang.String", "java.lang.String", "java.lang.String", "float", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$TokenizedEvents", "ru.ozon.app.android.ads.data.analytics.SwitchModeTracking", "boolean", "boolean", "long", "ru.ozon.app.android.atoms.data.dsBadge.BadgeDTO", "java.util.List", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.data.ProductType", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$SmallPreviewProduct", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$PackShotVO", "ru.ozon.app.android.atoms.data.texts.TextAtom", "boolean", "boolean", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$PackshotOptions", "java.lang.String", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[1] = ""; // Set playlistUrl to empty string
                    param.args[2] = ""; // Set previewUrl to empty string
                    param.args[3] = ""; // Set deeplink to empty string
                    param.args[10] = new Object[0]; // Set pixel to empty list
                    param.args[7] = false; // Set isVisible to false
                }
            });

            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.storefront.widgets.cms.bannercarousel.BannerCarouselVO", lpparam.classLoader, long.class, int.class, int.class, java.util.List.class, android.os.Parcelable.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[2] = 1;
                    param.args[3] = new ArrayList<>();
                }
            });

            Class<?> ProductVO = XposedHelpers.findClass("ru.ozon.app.android.product.common.product.ProductVO", lpparam.classLoader);
            XposedBridge.hookAllConstructors(ProductVO, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (param.args[1].toString().equals("GRID3")) {
                        param.setResult(null);
                    }
                }
            });

        }
    }
}
