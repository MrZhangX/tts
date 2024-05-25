package com.xi.liuliu.tts.global;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xi.liuliu.tts.util.LogUtil;

/***
 * todo 2024.05.25
 * 因为之前一直报jni未实现的错误，我没重视
 * 现在看来就是这个错误导致的。
 * 将jni里面的so文件复制出来使用就好了。
 *
 * 参考文章：
 * https://github.com/sogouspeech/tts-android-demo/tree/master 搜狗知音官方地址 ，在线的TTS，grpc
 * https://github.com/sogouspeech/tts-android-sdk
 *
 * https://github.com/sogouspeech/asr-android-demo asr
 * https://github.com/sogouspeech/asr-android-sdk
 *
 * https://github.com/sogouspeech/mt-android-demo 在线翻译
 * https://github.com/sogouspeech/mt-android-sdk
 *
 * https://github.com/xiyy/voiceTranslator 这个是使用的搜狗知音，在线。还包括在线的asr、翻译
 * https://github.com/xiyy/tts 主要是这篇文章，离线
 */
public class TtsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            System.loadLibrary("ttsoff");
        }catch (Throwable t) {
            t.printStackTrace();
        }
        LogUtil.setDebug(true);
        //application监听activity的生命周期
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityCreated");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityStarted");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityResumed");
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityPaused");
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                LogUtil.log(activity.getClass().getSimpleName(),"onActivityDestroyed");
            }
        });
    }
}
