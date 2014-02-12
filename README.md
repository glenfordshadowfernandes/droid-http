droid-http
==========

Simple POST and GET Http Helper for ease-of coding for Android.


Usage
=====
POST Method Usage:

    public class CallingActivity extends Activity{
    
      protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ....
        ...
        String url = "http://www.example.com";
        
        HashMap<String, String> sendContainer = new HashMap<String, String>();
        sendContainer.put("paramOne", "TextOne");
        sendContainer.put("paramTwo", "TextTwo");
          
        new AsyncTask(CurrentActivity.this, sendContainer).execute(url);
      }
    }


The above called "AsyncTask" can then be handled in its "doInBackground" method using the droid-http's HttpConnect().Post() method as follows..

    public class AsyncTask extends AsyncTask<Object, Void, Boolean>
    {
    
          public AsyncTask(HashMap<String, String> c, Context context) {
        		this.postContainer = c;
        		this.postAct = context;
        	}
        
        	@Override
        	protected Boolean doInBackground(Object... params)
        	{
        		try
        		{
        			HttpEntity resEntityGet = new HttpConnect((String) params[0]).Post(this.postContainer);
        
        			if (resEntityGet != null)
        			{
        				String responseString = EntityUtils.toString(resEntityGet);
        				....
        			}
        		}
        		catch (ClientProtocolException e)
        		{
        			e.printStackTrace();
        		}
        		catch (IOException e)
        		{
        			e.printStackTrace();
        		}
        		catch (JSONException e)
        		{
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		return ...
        
        	}
    
    }
    
GET Method Usage:

    public ... {
      HttpEntity resEntityGet = new HttpConnect(url).Get();
    }    

This is a straight forward method call just passing the "Url" in the HttpConnect() constructor.


