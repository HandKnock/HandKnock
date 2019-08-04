package com.example.testseach;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv.setText(AppUtils.highStr("一个高的大的上的页面", "的"));
    }


    /**
     *
     * @param str 全部的字符串
     * @param needHighStr   需要高亮的字符串
     * @return  这里默认高亮的是屎黄色，需要自定义时，再添加重载的方法吧
     */
    public static Spanned highStr(String str, String needHighStr){
        if (str.contains(needHighStr)) {
            String[] split = str.split(needHighStr);
            String highCircleName = "";
            if (split.length == 0) {
                highCircleName = "<font color=\"#ffbd46\">" + needHighStr + "</font>";
            } else
                for (int i = 0; i < split.length; i++) {
                    highCircleName += split[i];
                    if (i < split.length - 1)
                        highCircleName += "<font color=\"#ffbd46\">" + needHighStr + "</font>";
                }
            return Html.fromHtml(highCircleName);
        }
        return new SpannedString(str);
    }

    /**
     *
     * @param str 全部的字符串
     * @param needHighStr   需要高亮的字符串
     * @return  这里默认高亮的是红色，需要自定义时，再添加重载的方法吧
     * 两个方法亲测都可以的，只是这个方法看着高大上一点
     */
    public static Spanned highStr2(String str, String needHighStr){
        SpannableString s = new SpannableString(str);
        Pattern p = Pattern.compile(needHighStr);
        Matcher m = p.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return s;
    }
}
