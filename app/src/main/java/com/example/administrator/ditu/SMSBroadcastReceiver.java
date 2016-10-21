package com.example.administrator.ditu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.baidu.location.BDLocation;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/18.
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            SmsMessage msg = null;
            Object[] pdusObj = (Object[]) intent.getExtras().get("pdus");
            for (Object p : pdusObj) {
                msg= SmsMessage.createFromPdu((byte[]) p);
                String msgTxt =msg.getMessageBody();//得到消息的内容
                String senderNumber = msg.getOriginatingAddress();
                MainActivity edg=new MainActivity();
                if (msgTxt.equals("where are you")) {
                    SmsManager manager=SmsManager.getDefault();
                    String text=String.valueOf(edg.dingwei.longitude)+"/"+String.valueOf(edg.dingwei.latitude);
                    manager.sendTextMessage(senderNumber,null,text,null,null);
                }
            }
    }
}
