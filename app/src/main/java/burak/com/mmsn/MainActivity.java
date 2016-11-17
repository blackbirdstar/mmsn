package burak.com.mmsn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Response responseObj;
    private CustomAdapter adapter;
    private Gson gson;
    private AsyncHttpClient client;
    public static String url = "http://www.blackbirdstar.com/memsen/";

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadDatas();
    }
*/
    @Override
    protected void onResume() {
        super.onResume();
        loadDatas();
    }

    protected void loadDatas()
    {
        setContentView(R.layout.activity_main);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        listView = (ListView) findViewById(R.id.entrylist);
        client = new AsyncHttpClient();
        client.get(MainActivity.this, url + "jsonlist.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responseString = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responseString, Response.class);
                adapter = new CustomAdapter(MainActivity.this, responseObj.getEntries());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
