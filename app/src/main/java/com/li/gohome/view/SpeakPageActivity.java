package com.li.gohome.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.speech.asr.SpeechConstant;
import com.li.gohome.R;
import com.li.gohome.util.baiduaudio.IRecogListener;
import com.li.gohome.util.baiduaudio.MyRecognizer;
import com.li.gohome.util.baiduaudio.RecogResult;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpeakPageActivity extends AppCompatActivity {

    ImageView audioButton;
    ImageView audioCancel;
    private MyRecognizer asrManager;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_page);
        audioButton = findViewById(R.id.audio_button);
        audioCancel = findViewById(R.id.audio_cancel);
        asrManager = new MyRecognizer(SpeakPageActivity.this, onAsrListener);
        audioButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    setAnim();
                    Map<String, Object> params = new LinkedHashMap<String, Object>();
                    params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);
                    asrManager.start(params);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    asrManager.stop();
                    audioButton.clearAnimation();
                }
                return true;//此处return true,抬起事件才会响应。
            }
        });
        audioCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakPageActivity.this.finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        asrManager.release();
        super.onDestroy();
    }

    private void setAnim() {
        AnimationSet as = new AnimationSet(true);
        //缩放动画，以中心从原始放大到0.5倍
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        as.setDuration(1000);
        as.addAnimation(scaleAnimation);
        as.addAnimation(alphaAnimation);
        as.setRepeatMode(Animation.REVERSE);
        audioButton.startAnimation(as);
    }


    private IRecogListener onAsrListener = new IRecogListener() {
        @Override
        public void onAsrReady() {

        }

        @Override
        public void onAsrBegin() {

        }

        @Override
        public void onAsrEnd() {

        }

        @Override
        public void onAsrPartialResult(String[] results, RecogResult recogResult) {

        }

        @Override
        public void onAsrOnlineNluResult(String nluResult) {

        }

        @Override
        public void onAsrFinalResult(String[] results, RecogResult recogResult) {
            audioButton.clearAnimation();
            String message = results[0];
            Log.v("aaaa","--"+message);
            if(message != null) {
                Intent intent = new Intent();
                intent.putExtra("result", message);
                setResult(3, intent);
            }
            SpeakPageActivity.this.finish();
        }

        @Override
        public void onAsrFinish(RecogResult recogResult) {

        }

        @Override
        public void onAsrFinishError(int errorCode, int subErrorCode, String descMessage, RecogResult recogResult) {
        }

        @Override
        public void onAsrLongFinish() {

        }

        @Override
        public void onAsrVolume(int volumePercent, int volume) {

        }

        @Override
        public void onAsrAudio(byte[] data, int offset, int length) {

        }

        @Override
        public void onAsrExit() {

        }

        @Override
        public void onOfflineLoaded() {

        }

        @Override
        public void onOfflineUnLoaded() {

        }
    };

}
