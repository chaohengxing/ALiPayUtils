package com.chx.alipay.alipayutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //签名在客户端
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假设已经从服务端获取必要数据
                MyALipayUtils.ALiPayBuilder builder = new MyALipayUtils.ALiPayBuilder();
                builder.setAppid("123")
                        .setRsa("456")//根据情况设置Rsa2与Rsa
                        .setMoney("0.01")//单位时分
                        .setTitle("支付测试")
                        .setOrderTradeId("487456")//从服务端获取
                        .setNotifyUrl("fdsfasdf")//从服务端获取
                        .build()
                        .toALiPay(MainActivity.this);
            }
        });
        //签名在服务端
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假设已从服务端获取orderInfo
                String orderInfo = "";
                MyALipayUtils.ALiPayBuilder builder = new MyALipayUtils.ALiPayBuilder();
                builder.build().toALiPay(MainActivity.this, orderInfo);

            }
        });
    }
}
