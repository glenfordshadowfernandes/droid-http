/*
	Author: Glenford Fernandes
	Date: Long Back
	Description: HttpConnect class for simplicity and ease...
	
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpConnect
{
	HttpClient httpClient;
	String Url;
	
	
	public HttpConnect(String url) {
		this.Url = url;
		httpClient = new DefaultHttpClient();
	}
	
	public HttpEntity Get() throws ClientProtocolException, IOException{
		
		HttpGet httpGet = new HttpGet(Url);
		HttpResponse httpResponseGet = httpClient.execute(httpGet);
		HttpEntity resEntityGet = httpResponseGet.getEntity();
		return resEntityGet;
	}
	
	public HttpEntity Post(HashMap<String, String> c) throws ClientProtocolException, IOException{
	
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(Url);

		// set up post data
		ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		Iterator<String> it = c.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			nameValuePair.add(new BasicNameValuePair(key, c.get(key)));
		}
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, "UTF-8"));
		HttpResponse httpResponseGet = httpClient.execute(httpPost);
		HttpEntity resEntityGet = httpResponseGet.getEntity();
		return resEntityGet;
			
	}

}
