package com.muxi.wxchat.services.logicservices.MyX509TrustManager;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/*
 *------------------------------.
 *@ClassName : MyX509TrustManager
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:59
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class MyX509TrustManager implements X509TrustManager{


    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

