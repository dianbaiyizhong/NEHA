package hhm.neha.common;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.qawaa.httpclient.HttpClientFactory;


public class CustomerHttpClient {
	 private static class ClientHolder {  
	      private static final HttpClient INSTANCE = HttpClientFactory.createHttpClient(HttpClientFactory.MULTI_THREAD, true);  
	      }  
	      private CustomerHttpClient(){}
	      public static final HttpClient getHttpClient() {  
	          return ClientHolder.INSTANCE;
	      }
    
    public static String get(String url) {
        try {
        	GetMethod request=new GetMethod(url);
            HttpClient client = getHttpClient();
            client.executeMethod(request);
            String str=request.getResponseBodyAsString();
            return str;
        }catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }
    }

}
