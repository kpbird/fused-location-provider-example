package com.kpbird.fusedlocation;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

import com.google.android.gms.location.LocationClient;

public class LocationService extends IntentService {

	private String TAG = this.getClass().getSimpleName();
	public LocationService() {
		super("Fused Location");
	}
	
	public LocationService(String name) {
		super("Fused Location");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
			
			Location location = intent.getParcelableExtra(LocationClient.KEY_LOCATION_CHANGED);
			if(location !=null){
				Log.i(TAG, "onHandleIntent " + location.getLatitude() + "," + location.getLongitude());
				NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); 
				Builder noti = new NotificationCompat.Builder(this);
				noti.setContentTitle("Fused Location");
				noti.setContentText(location.getLatitude() + "," + location.getLongitude());
				noti.setSmallIcon(R.drawable.ic_launcher);
				
				notificationManager.notify(1234, noti.build());
				
				  
			}
			
	}

}
