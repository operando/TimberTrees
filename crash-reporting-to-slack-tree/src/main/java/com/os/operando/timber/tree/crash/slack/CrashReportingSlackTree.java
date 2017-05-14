package com.os.operando.timber.tree.crash.slack;

import android.os.Build;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class CrashReportingSlackTree extends LogPriorityTree {

    private static final MediaType MEDIA_TYPE = MediaType.parse("Content-type: application/json; charset=utf-8");

    private static final String DEVICE_INFO =
            "OS Version : " + Build.VERSION.RELEASE + "(" + Build.VERSION.SDK_INT + ") \n" +
                    "Device : " + Build.MANUFACTURER + " " + Build.MODEL + " \n" +
                    "Default Language : " + Locale.getDefault().getLanguage() + "\n\n";

    private final String slackWebHookUrl;
    private final String channel;
    private final String userName;
    private final String iconEmoji;

    private CrashReportingSlackTree(Builder builder) {
        super(builder.logPriority);
        slackWebHookUrl = builder.slackWebHookUrl;
        channel = builder.channel;
        userName = builder.userName;
        iconEmoji = builder.iconEmoji;
    }

    @Override
    protected void log(int priority, String tag, String message, final Throwable t) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                t.printStackTrace(pw);
                pw.flush();

                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("text", DEVICE_INFO + sw.toString());

                    if (channel != null) {
                        jsonObject.put("channel", channel);
                    }

                    if (userName != null) {
                        jsonObject.put("username", userName);
                    }

                    if (iconEmoji != null) {
                        jsonObject.put("icon_emoji", iconEmoji);
                    }

                    sink.writeUtf8(jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Request request = new Request.Builder().url(slackWebHookUrl).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public static final class Builder {

        final String slackWebHookUrl;
        int logPriority;
        String channel;
        String userName;
        String iconEmoji;

        public Builder(String slackWebHookUrl) {
            logPriority = Log.ERROR;
            this.slackWebHookUrl = slackWebHookUrl;
        }

        public Builder logPriority(int logPriority) {
            this.logPriority = logPriority;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder iconEmoji(String iconEmoji) {
            this.iconEmoji = iconEmoji;
            return this;
        }

        public CrashReportingSlackTree build() {
            return new CrashReportingSlackTree(this);
        }
    }
}