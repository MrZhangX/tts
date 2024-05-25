package com.xi.liuliu.tts.view;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.sogou.tts.offline.TTSPlayer;
import com.sogou.tts.offline.listener.TTSPlayerListener;
import com.xi.liuliu.tts.R;
import com.xi.liuliu.tts.util.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorkFragment extends Fragment {

    private static final String TAG = "zxd";
    private TTSPlayer mTtsPlayer;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView viewById = view.findViewById(R.id.b1);
        TextView textView = view.findViewById(R.id.b2);
        TextView textView1 = view.findViewById(R.id.b3);
        mTtsPlayer = new TTSPlayer(true);
        Log.e("zd", "onClick: " + mTtsPlayer.getVersion());
        viewById.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                init2();
//                mTtsPlayer.init(getActivity().getApplicationContext(), "/sdcard/iflytek/res/", "dict.dat", "chinese.dat", new TTSPlayerListener() {
//                    @Override
//                    public void onInit(boolean b) {
//                        Log.e("zxd", "onInit: " + b);
//                    }
//
//                    @Override
//                    public void onStart() {
//                        Log.i(TAG, "onStart: ");
//                    }
//
//                    @Override
//                    public void onSpeakProgress(Float aFloat) {
//                        Log.i(TAG, "onSpeakProgress: " + aFloat);
//                    }
//
//                    @Override
//                    public void onSpeakSentenceProgress(List<String> list, int i) {
//                        Log.e(TAG, "onSpeakSentenceProgress: " + list.size() + "\t" + i);
//                    }
//
//                    @Override
//                    public void onSegSyn(byte[] bytes) {
//
//                    }
//
//                    @Override
//                    public void onEnd() {
//                        Log.e(TAG, "onEnd: ");
//                    }
//
//                    @Override
//                    public void onError(int i) {
//                        Log.e(TAG, "onError: " + i);
//                    }
//
//                    @Override
//                    public void onPause() {
//                        Log.d(TAG, "onPause: ");
//                    }
//
//                    @Override
//                    public void onSynEnd(Float aFloat) {
//                        Log.e(TAG, "onSynEnd: " + aFloat);
//                    }
//
//                    @Override
//                    public void onRelease(boolean b) {
//                        Log.d(TAG, "onRelease: " + b);
//                    }
//                });
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XXPermissions.with(v.getContext()).permission(Permission.MANAGE_EXTERNAL_STORAGE)
                        .request(new OnPermissionCallback() {
                            @Override
                            public void onGranted(List<String> permissions, boolean all) {
                                if (all) {
                                    String path = "/sdcard/iflytek/res";
                                    if (!new File(path).exists()) new File(path).mkdirs();
//                                    FileUtils.AssetToSD(v.getContext(), "", "/sdcard/iflytek/res");
                                    FileUtils.AssetToSD(v.getContext(), "snd-f24.dat", "/sdcard/iflytek/res/snd-f24.dat");
                                    FileUtils.AssetToSD(v.getContext(), "chinese.dat", "/sdcard/iflytek/res/chinese.dat");
                                    FileUtils.AssetToSD(v.getContext(), "dict.dat", "/sdcard/iflytek/res/dict.dat");
                                    FileUtils.AssetToSD(v.getContext(), "english.dat", "/sdcard/iflytek/res/english.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-lhy.dat", "/sdcard/iflytek/res/snd-lhy.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-ybh.dat", "/sdcard/iflytek/res/snd-ybh.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-yzh.dat", "/sdcard/iflytek/res/snd-yzh.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-zj.dat", "/sdcard/iflytek/res/snd-zj.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-zjc.dat", "/sdcard/iflytek/res/snd-zjc.dat");
                                    FileUtils.AssetToSD(v.getContext(), "snd-zsh.dat", "/sdcard/iflytek/res/snd-zsh.dat");
                                }
                            }
                        });
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTtsPlayer.setSpeed(-1);
                List<String> list = new ArrayList<>();
                list.add("诸王大自在 不能除渴爱\n" +
                        "\n" +
                        "如干草遇火 是故应舍欲\n" +
                        "\n" +
                        "常行于淫欲 未曾满足时\n" +
                        "\n" +
                        "如渴饮碱水 终不能除渴\n" +
                        "\n" +
                        "如众流归海 终无有满足\n" +
                        "\n" +
                        "爱欲亦如是 曾无满足时\n" +
                        "\n" +
                        "如火焚草木 无有厌足时\n" +
                        "\n" +
                        "爱欲亦如是 终无有满足\n" +
                        "\n" +
                        "犹如深谷响 随声无休息\n" +
                        "\n" +
                        "闻声亦如是 亦无休息时\n" +
                        "\n" +
                        "亦如盛香箧 受香无简择\n" +
                        "\n" +
                        "嗅香亦如是 亦无有厌足");
                mTtsPlayer.play(list, "打招呼");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigator_work, container, false);
        return view;
    }

    public void init2(){
        mTtsPlayer.initFromAssets(getActivity().getApplicationContext(), new TTSPlayerListener() {
            @Override
            public void onInit(boolean b) {
                if (b) {
                    List<String> list = new ArrayList<>();
                    list.add("你好啊");
                    mTtsPlayer.play(list, "你好");
                }
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onSpeakProgress(Float aFloat) {

            }

            @Override
            public void onSpeakSentenceProgress(List<String> list, int i) {

            }

            @Override
            public void onSegSyn(byte[] bytes) {

            }

            @Override
            public void onEnd() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onSynEnd(Float aFloat) {

            }

            @Override
            public void onRelease(boolean b) {

            }
        }, "", "chinese.dat");
    }
}
