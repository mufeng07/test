package com.mufeng.test.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Locale;

/**
 * @Auther: mufeng
 * @Date: 2019/1/17 20:16
 */
public class TestHttpClient {
    @Test
    public void testGet() throws IOException {
        try(CloseableHttpClient httpClient= HttpClients.createDefault()){
            String uri="https://getwayfldev.bndxqc.com/consu/pay/v1/getPaymentTradeResult?orderNo=00001727";
            HttpGet httpGet=new HttpGet(uri);
            System.out.println("http:"+httpGet.getRequestLine());
            ResponseHandler<String> responseHandler=response ->{
                int status = response.getStatusLine().getStatusCode();
                Locale locale = response.getLocale();
                HttpEntity entity = response.getEntity();
                System.out.println(entity);
                System.out.println(locale);
                System.out.println(status);
                return EntityUtils.toString(entity);
            };
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println(responseBody);
        }
    }
    @Test
    public void testPost(){
        try(CloseableHttpClient httpClient= HttpClients.createDefault()){
            String uri="https://getwayfldev.bndxqc.com/consu/pay/v1/getPaymentTradeResult";
            //HttpPost httpPost=new HttpPost(uri);
            HttpPut httpPost=new HttpPut(uri);
            String body="orderNo=00001727";
            StringEntity stringEntity=new StringEntity(body);
            httpPost.setEntity(stringEntity);
            ResponseHandler<String> responseHandler=httpResponse -> {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                System.out.println(statusCode);
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity);
            };
            String response = httpClient.execute(httpPost, responseHandler);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static final String PEER_CERTIFICATES = "PEER_CERTIFICATES";
    @Test
    public void testGetServerCer() throws Exception{
        // create http response certificate interceptor
        HttpResponseInterceptor certificateInterceptor = (httpResponse, context) -> {
            ManagedHttpClientConnection routedConnection = (ManagedHttpClientConnection)context.getAttribute(HttpCoreContext.HTTP_CONNECTION);
            SSLSession sslSession = routedConnection.getSSLSession();
            if (sslSession != null) {

                // get the server certificates from the {@Link SSLSession}
                Certificate[] certificates = sslSession.getPeerCertificates();

                // add the certificates to the context, where we can later grab it from
                context.setAttribute(PEER_CERTIFICATES, certificates);
            }
        };

        // create closable http client and assign the certificate interceptor
        CloseableHttpClient httpClient = HttpClients.custom().addInterceptorLast(certificateInterceptor).build();

        try {

            // make HTTP GET request to resource server
            HttpGet httpget = new HttpGet("https://fundfltest.bndxqc.com");
            System.out.println("Executing request " + httpget.getRequestLine());

            // create http context where the certificate will be added
            HttpContext context = new BasicHttpContext();
            httpClient.execute(httpget, context);

            // obtain the server certificates from the context
            Certificate[] peerCertificates = (Certificate[])context.getAttribute(PEER_CERTIFICATES);

            // loop over certificates and print meta-data
            for (Certificate certificate : peerCertificates){
                X509Certificate real = (X509Certificate) certificate;
                System.out.println("----------------------------------------");
                System.out.println("Type: " + real.getType());
                System.out.println("Signing Algorithm: " + real.getSigAlgName());
                System.out.println("IssuerDN Principal: " + real.getIssuerX500Principal());
                System.out.println("SubjectDN Principal: " + real.getSubjectX500Principal());
                System.out.println("Not After: " + DateUtils.formatDate(real.getNotAfter(), "dd-MM-yyyy"));
                System.out.println("Not Before: " + DateUtils.formatDate(real.getNotBefore(), "dd-MM-yyyy"));
            }

        } finally {
            // close httpclient
            httpClient.close();
        }
    }
}
