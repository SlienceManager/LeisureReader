package com.xiaoming.slience.global;

import android.app.Application;

import com.xiaoming.slience.utils.GlideImageLoader;
import com.xiaoming.slience.utils.GlidePauseOnScrollListener;

import org.xutils.x;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * @author slience
 * @des
 * @time 2017/6/1019:20
 */

public class Global_Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this); //xUtils全局配置

        //设置主题
        ThemeConfig themeConfig = ThemeConfig.CYAN;
        ThemeConfig theme = new ThemeConfig.Builder()
                .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true) //开启照相机
                .setEnableEdit(true)  //图像可编辑
                .setEnableCrop(true)  // 裁剪
                .setEnableRotate(true)  //旋转
                .setCropSquare(false)  //裁剪正方形
                .setEnablePreview(true) //预览
                .build();

        //配置imageloader
        ImageLoader imageloader = new GlideImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new GlidePauseOnScrollListener(false,true))
                .build();
        GalleryFinal.init(coreConfig);
    }
}
