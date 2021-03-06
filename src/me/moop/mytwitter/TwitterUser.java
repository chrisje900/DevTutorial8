
package me.moop.mytwitter;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.SystemClock;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

public class TwitterUser {
	
	@DatabaseField(id=true)
	String mId;
	@DatabaseField
	long mLastUpdate = 0;
	
	@DatabaseField
	String mWebsite;
	@DatabaseField
	String mDescription;
	@DatabaseField
	int mFavouritesCount;
	@DatabaseField
	String mUserName;
	
	TwitterUser(){
	}
	
	public TwitterUser(String jsonString){
		try {
			JSONObject jSONObject = new JSONObject(jsonString);
			mUserName = jSONObject.optString("screen_name");
			mId = mUserName.toLowerCase();
			mWebsite = jSONObject.optString("url");
			mDescription = jSONObject.optString("description");
			mFavouritesCount = jSONObject.optInt("favourites_count");
			mLastUpdate = SystemClock.elapsedRealtime();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getId(){
		return mId;
	}

	public String getUserName(){
		return mUserName;
	}

	public String getWebsite(){
		return mWebsite;
	}
	
	public String getDescription(){
		return mDescription;
	}
	
	public int getFavouritesCount(){
		return mFavouritesCount;
	}
	
	public long getLastUpdate(){
		return mLastUpdate;
	}
	
	@Override
	public String toString(){
		return mUserName;
	}
	
	
}
