package com.example.test2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.test2app.view.viewgroup.FlyOutContainer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class MainActivity extends Activity {
	private GoogleMap mMap;
	FlyOutContainer root;
	static final LatLng UCI = new LatLng(33.6455843, -117.8419771);
	Button mapLinkButton;
	Button emergencyLinkButton;
	Button dialerLinkButton;
	 
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
	    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	     
	    //add uci marker and set zoom
	     if (mMap!=null){
	         Marker uci = mMap.addMarker(new MarkerOptions().position(UCI).title("UCI").snippet("University of California Irvine"));
	         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UCI, 15));
	         mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null); 
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

}
