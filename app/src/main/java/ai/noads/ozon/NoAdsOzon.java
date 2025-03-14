package ai.noads.ozon;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;


public class NoAdsOzon implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (lpparam.packageName.equals("ru.ozon.app.android")) {

            // Hook AdvBannerV4SingleVO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.plain.single.AdvBannerV4SingleVO", lpparam.classLoader, "long", "ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4ItemVO", "boolean", "double", "int", "android.os.Parcelable", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvBannerV4SingleVO constructor <<<");
                    param.args[1] = new Object[0]; // Set banner to empty list
                    param.args[2] = false; // Set isPagerVisible to false
                }
            });

            // Hook AdvPageStayVO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advPageStay.presentation.AdvPageStayVO", lpparam.classLoader, "long", "java.util.List", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvPageStayVO constructor <<<");
                    param.args[1] = new Object[0]; // Set events to empty list
                }
            });

            // Hook AdvInfoVO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advInfo.presentation.AdvInfoVO", lpparam.classLoader, "long", "ru.ozon.app.android.atoms.data.texts.TextAtom", "ru.ozon.app.android.atoms.data.texts.TextAtom", "java.lang.String", "java.lang.String", "ru.ozon.app.android.atoms.data.cells.CellAtom$CellAtomWithSubtitle$CellWithSubtitle24Icon", "ru.ozon.app.android.atoms.data.cells.CellAtom$CellAtomWithSubtitle$CellWithSubtitle24Icon", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvInfoVO constructor <<<");
                }
            });

            // Hook AdvBannerVO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advBanner.v3.presentation.model.AdvBannerVO", lpparam.classLoader, "long", "java.util.List", "boolean", "double", "int", "android.os.Parcelable", "ru.ozon.app.android.ads.widgets.advBanner.v3.presentation.model.AdvBannerVO$RotationOptions", "boolean", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvBannerVO constructor <<<");
                }
            });

            // Hook AdvBannerV4VO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4VO", lpparam.classLoader, "long", "java.util.List", "boolean", "double", "int", "android.os.Parcelable", "ru.ozon.app.android.ads.widgets.advBanner.v4.presentation.model.AdvBannerV4VO$RotationOptions", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvBannerV4VO constructor <<<");
                    param.args[1] = new Object[0]; // Set items to empty list
                    param.args[2] = false; // Set isPagerVisible to false
                }
            });

            // Hook AdvBannerVideoV2VO constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO", lpparam.classLoader, "long", "java.lang.String", "java.lang.String", "java.lang.String", "float", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$TokenizedEvents", "ru.ozon.app.android.ads.data.analytics.SwitchModeTracking", "boolean", "boolean", "long", "ru.ozon.app.android.atoms.data.dsBadge.BadgeDTO", "java.util.List", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.data.ProductType", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$SmallPreviewProduct", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$PackShotVO", "ru.ozon.app.android.atoms.data.texts.TextAtom", "boolean", "boolean", "ru.ozon.app.android.ads.widgets.advVideoBannerV2.presentation.AdvBannerVideoV2VO$PackshotOptions", "java.lang.String", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> AdvBannerVideoV2VO constructor <<<");
                    param.args[1] = ""; // Set playlistUrl to empty string
                    param.args[2] = ""; // Set previewUrl to empty string
                    param.args[3] = ""; // Set deeplink to empty string
                    param.args[10] = new Object[0]; // Set pixel to empty list
                    param.args[7] = false; // Set isVisible to false
                }
            });

            // Hook WidgetAdvInfoBinding constructor
            XposedHelpers.findAndHookConstructor("ru.ozon.app.android.ads.databinding.WidgetAdvInfoBinding", lpparam.classLoader, "androidx.constraintlayout.widget.ConstraintLayout", "ru.ozon.app.android.uikit.view.atoms.cells.subtitled.CellWithSubtitle24IconView", "ru.ozon.app.android.uikit.view.atoms.cells.subtitled.CellWithSubtitle24IconView", "ru.ozon.android.uikit.view.atoms.texts.TextAtomView", "ru.ozon.android.uikit.view.atoms.texts.TextAtomView", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(">>>> WidgetAdvInfoBinding constructor <<<");
                }
            });
        }
    }
}
