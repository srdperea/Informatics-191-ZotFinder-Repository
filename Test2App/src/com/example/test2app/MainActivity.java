package com.example.test2app;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.test2app.DirectionsJSONParser;
import com.example.test2app.view.viewgroup.FlyOutContainer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;



public class MainActivity extends FragmentActivity {
	private GoogleMap mMap;
	FlyOutContainer root;
	static final LatLng UCI = new LatLng(33.6455843, -117.8419771);
	static final LatLng EA1 = new LatLng(33.644729, -117.842226);
	static final LatLng EA2 = new LatLng(33.646716, -117.841561);
	static final LatLng EA3 = new LatLng(33.644805, -117.840108);
	static final LatLng BP1 = new LatLng(33.645876,-117.845483);
	static final LatLng BP2 = new LatLng(33.648047, -117.843874);
	static final LatLng BP3 = new LatLng(33.646073, -117.843166);
	ArrayList<Marker> emergencyArea = new ArrayList<Marker>();
	ArrayList<Marker> bluePhone = new ArrayList<Marker>();
	ArrayList<Marker> buildings = new ArrayList<Marker>();
	public boolean eaShow=true;
	public boolean bpShow=true;
	
	
	Button mapLinkButton;
	Button emergencyLinkButton;
	Button dialerLinkButton;
	
	public LatLng currentLocation;
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_main, null);
		
		this.setContentView(root);
		
		//Initialize Buttons
	    mapLinkButton = (Button) findViewById(R.id.mapLinkButton);
	    emergencyLinkButton = (Button) findViewById(R.id.emergencyLinkButton);
	    dialerLinkButton = (Button) findViewById(R.id.dialerLinkButton);
	    
	    //Initialize Map
	    FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment =  (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
	   
        //set UI settings
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setMyLocationEnabled(true);
        //sets current location
        double[] d = getlocation();
	    currentLocation = new LatLng(d[0], d[1]);
	    
	    //add uci marker and set zoom
	     if (mMap!=null){

	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA1).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA2).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA3).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP1).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP2).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP3).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));

	         buildings.add(mMap.addMarker(new MarkerOptions().position(new LatLng(33.643183,-117.842028)).title("Donald Bren Hall")
	        		 .snippet("DBH").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));

	         //animate camera
	         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UCI, 15));
	         mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null); 
	         
	     }
	}
	
	public void findDirections(View v){
	     // Getting URL to the Google Directions API
        String url = getDirectionsUrl(currentLocation,BP2);

        DownloadTask downloadTask = new DownloadTask();

        // Start downloading json data from Google Directions API
        downloadTask.execute(url);
	  
		  // Enable MyLocation Button in the Map
	      mMap.setMyLocationEnabled(true);
	}
	

    private String getDirectionsUrl(LatLng origin,LatLng dest){
 
        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;
 
        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;
 
        // Sensor enabled
        String sensor = "sensor=false";
        
 
        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor+"&"+"mode=walking";
 
        // Output format
        String output = "json";
 
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
 
        return url;
    }
 
    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException{
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);
 
            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();
 
            // Connecting to url
            urlConnection.connect();
 
            // Reading data from url
            iStream = urlConnection.getInputStream();
 
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
 
            StringBuffer sb = new StringBuffer();
 
            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }
 
            data = sb.toString();
 
            br.close();
 
        }catch(Exception e){
            Log.d("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
 
    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String>{
 
        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {
 
            // For storing data from web service
            String data = "";
 
            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }
 
        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
 
            ParserTask parserTask = new ParserTask();
 
            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
 
    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{
 
        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
 
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
 
            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
 
                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }
 
        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
 
            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();
 
                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);
 
                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);
 
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
 
                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(2);

                // Changing the color polyline according to the mode
                lineOptions.color(Color.BLUE);
            }
 
            if(result.size()<1){
                Toast.makeText(getBaseContext(), "No Points", Toast.LENGTH_SHORT).show();
                return;
            }
 
            // Drawing polyline in the Google Map for the i-th route
            mMap.addPolyline(lineOptions);
        }
    }

	 
	 public void goToMap(View view) { 
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
	 
	 public void goToEmergencyInfo(View view) { 
			Intent intent = new Intent(this,EmergencyInfoActivity.class);
			startActivity(intent);
		}
	 
	 public void goToEmergencyDialer(View view) { 
			Intent intent = new Intent(this,DialerActivity.class);
			startActivity(intent);
		}
	 
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void toggleMenu(View v){
		this.root.toggleMenu();
	}
	
	public void toggleEaMarker(View v){
		if(eaShow){
			for(Marker m :emergencyArea){
				m.setVisible(false);
			}
			eaShow = false;
		}
		else 
		{
			for( Marker m : emergencyArea){
				m.setVisible(true);
			}
			eaShow = true;
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UCI, 15));
	        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
			
		}
	}
	
	public void toggleBpMarker(View v){
		if(bpShow){
			for (Marker m : bluePhone){
				m.setVisible(false);
			}
			bpShow = false;
		}
		else
		{
			for (Marker m : bluePhone){
				m.setVisible(true);
			}
			bpShow = true;
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UCI, 15));
	        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
		}
	}
	
	public void findLocation(View v){
		double[] d = getlocation();
	    currentLocation = new LatLng(d[0], d[1]);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
	}
	
	public double[] getlocation() {
	    LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    List<String> providers = lm.getProviders(true);

	    Location l = null;
	    for (int i = 0; i < providers.size(); i++) {
	        l = lm.getLastKnownLocation(providers.get(i));
	        if (l != null)
	            break;
	    }
	    double[] gps = new double[2];

	    if (l != null) {
	        gps[0] = l.getLatitude();
	        gps[1] = l.getLongitude();
	    }
	    return gps;
	}
	
/*	public void readHTTPRequest(View v){
		try {
			TextView httptextview = (TextView)findViewById(R.id.httpTextView);
			httptextview.setText(getData());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	public void getData(View v) {
	    try {
	        StrictMode.ThreadPolicy policy = new StrictMode.
	          ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        URL url = new URL("http://directory.uci.edu/index.php?uid=djpatter&form_type=plaintext");
	        HttpURLConnection con = (HttpURLConnection) url
	          .openConnection();
	        TextView httptextview = (TextView)findViewById(R.id.httpTextView);
	        httptextview.setText(readStream(con.getInputStream()));
	        //readStream(con.getInputStream());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}     

	private String readStream(InputStream in) {
	  BufferedReader reader = null;
	  String output = "";
	  try {
	    reader = new BufferedReader(new InputStreamReader(in));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	      output+=line;
	    }
	    return output;
	  } catch (IOException e) {
	    e.printStackTrace();
	  } finally {
	    if (reader != null) {
	      try {
	        reader.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	return output;
	} 
/*	public String getHTTPRequest() throws ClientProtocolException, IOException{
		HttpClient httpclient = new DefaultHttpClient();
	    HttpResponse response = httpclient.execute(new HttpGet("http://directory.uci.edu/index.php?uid=djpatter&form_type=plaintext"));
	    StatusLine statusLine = response.getStatusLine();
	    if(statusLine.getStatusCode() == HttpStatus.SC_OK){
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        response.getEntity().writeTo(out);
	        out.close();
	        String responseString = out.toString();
	        //System.out.println(responseString);
	        return responseString;
	    } else{
	        //Closes the connection.
	        response.getEntity().getContent().close();
	        throw new IOException(statusLine.getReasonPhrase());
	    }
	}*/
}
