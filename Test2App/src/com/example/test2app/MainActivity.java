package com.example.test2app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.test2app.view.viewgroup.FlyOutContainer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



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
	public boolean eaShow=true;
	public boolean bpShow=true;
	
	
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
	    FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment =  (SupportMapFragment)
            fragmentManager.findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
	   // mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	     
	    //add uci marker and set zoom
	     if (mMap!=null){
	         Marker uci = mMap.addMarker(new MarkerOptions().position(UCI).title("UCI").snippet("University of California Irvine"));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA1).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA2).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA3).title("Emergency Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP1).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP2).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP3).title("Blue Light Phone").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
	         	         
	         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UCI, 15));
	         mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
	         
	         mMap.getUiSettings().setCompassEnabled(true);
	         mMap.getUiSettings().setZoomControlsEnabled(true);
	         mMap.getUiSettings().setMyLocationButtonEnabled(true);
	         
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

}
