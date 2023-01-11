package in.nareshtechnologies.googlebooks;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchData extends AsyncTask<String,Void,String> {

    private ProgressBar progressBar;
    private TextView textView;

    public FetchData(ProgressBar progressBar, TextView textView) {
        this.progressBar = progressBar;
        this.textView = textView;
    }

    // doInBackground(...) method works on the worker thread
    @Override
    protected String doInBackground(String... strings) {
        String l = strings[0];
        // Convert the link to URL type
        try {
            URL url = new URL(l);
            // Open the connection on the url
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            // Read the inputStream
            InputStream is = connection.getInputStream();
            // READ the data line by line
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while((line = br.readLine())!=null){
                builder.append(line);
            }

            // return the results to onPostExecute(...)
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // This method executes on the Main thread or UI thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        // AS the data has arrived, We would like to display the data on the TextView
        // Also We would like to stop showing the progressbar to the user
        progressBar.setVisibility(View.INVISIBLE);
        textView.setText("");
        try {
            JSONObject root = new JSONObject(s);
            JSONArray items = root.getJSONArray("items");
            for(int i=0; i<items.length(); i++){
                JSONObject item = items.getJSONObject(i);
                JSONObject volinfo = item.getJSONObject("volumeInfo");
                String title = volinfo.getString("title");
                textView.append(title+"\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
