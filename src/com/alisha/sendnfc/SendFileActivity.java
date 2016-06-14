package com.alisha.sendnfc;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class SendFileActivity extends Activity {
	
	private NfcAdapter mNfcAdapter;
    // Flag to indicate that Android Beam is available
    boolean mAndroidBeamAvailable  = false;

 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);
        PackageManager pm = this.getPackageManager();
     // NFC isn't available on the device
       if (!pm.hasSystemFeature(PackageManager.FEATURE_NFC)) {
            /*
             * Disable NFC features here.
             * For example, disable menu items or buttons that activate
             * NFC-related features
             */

        // Android Beam file transfer isn't supported
    	   Toast.makeText(this, "The device does not has NFC hardware.", 
                   Toast.LENGTH_SHORT).show();  
        } else if (Build.VERSION.SDK_INT <
                Build.VERSION_CODES.JELLY_BEAN_MR1) {
            // If Android Beam isn't available, don't continue.
            mAndroidBeamAvailable = false;
            /*
             * Disable Android Beam file transfer features here.
             */

        // Android Beam file transfer is available, continue
        } else {
        	 Toast.makeText(this, "Android Beam is supported on your device.", 
                     Toast.LENGTH_SHORT).show();
        }
    }
       
       public void sendFile(View view) {
    	   mNfcAdapter = NfcAdapter.getDefaultAdapter(this);  
            
           // Check whether NFC is enabled on device
           if(!mNfcAdapter.isEnabled()){
               // NFC is disabled, show the settings UI
               // to enable NFC
               Toast.makeText(this, "Please enable NFC.", 
                               Toast.LENGTH_SHORT).show(); 
               startActivity(new Intent(Settings.ACTION_NFC_SETTINGS));
           }        
           // Check whether Android Beam feature is enabled on device
           else if(!mNfcAdapter.isNdefPushEnabled()) {
               // Android Beam is disabled, show the settings UI
               // to enable Android Beam 
               Toast.makeText(this, "Please enable Android Beam.", 
                               Toast.LENGTH_SHORT).show();
               startActivity(new Intent(Settings.ACTION_NFCSHARING_SETTINGS));
           }
           else {
               // NFC and Android Beam both are enabled 
            
               // File to be transferred    
               // For the sake of this tutorial I've placed an image 
               // named 'wallpaper.png' in the 'Pictures' directory
               String fileName = "Lamb.jpg";
            
               // Retrieve the path to the user's public pictures directory 
               /*File fileDirectory = Environment
                                       .getExternalStoragePublicDirectory(
                                               Environment.DIRECTORY_PICTURES);*/
               File fileDirectory = new File("/storage/emulated/0/Pictures/");
               Log.i("Alisaa", "fileDirectory: " + fileDirectory.getName());
            
               // Create a new file using the specified directory and name
               File fileToTransfer = new File(fileDirectory, fileName);
               fileToTransfer.setReadable(true, false);
            
               mNfcAdapter.setBeamPushUris(
                               new Uri[]{Uri.fromFile(fileToTransfer)}, this);             
           }                   
       }
}
