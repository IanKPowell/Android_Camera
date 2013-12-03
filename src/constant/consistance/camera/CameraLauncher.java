package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.xerces.internal.util.URI;


public class startCamera extends CordovaPlugin {

	public static startCamera singleton;
    public URI finalURI;
	
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        singleton = this;
		if (action.equals("takePicture")) {
                    Context context = cordova.getActivity().getApplicationContext();
                    Intent intent = new Intent(context, CapturePhoto.class);
                    this.cordova.startActivityForResult((CordovaPlugin) this, intent, 145);
                    return true;
		}
        return false;
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
    	if(requestCode==145)//camera
    		if(resultCode==Activity.RESULT_OK){
    			finalURI = new URI(returnIntent.getStringExtra("resultURI"));
    		}
    }
    private void finish(){
    	PluginResult pr = new PluginResult(PluginResult.Status.OK, finalURI.toString());
    	this.sendPluginResult(pr);
    }
    
    
}