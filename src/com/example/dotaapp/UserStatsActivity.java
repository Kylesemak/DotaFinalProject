
package com.example.dotaapp;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.widget.TextView;
import java.io.IOException;
import org.json.*;
import java.io.*;



public class UserStatsActivity extends Activity
{

	private TextView steamIdView;
	private TextView profileName;
	private TextView profileURL;
	private TextView gameOnePlayed;
	private TextView gameTwoPlayed;
		
	private TextView updateOne;
	private TextView updateTwo;
	private TextView updateThree;
	private TextView updateFour;
	private TextView updateFive;
	private TextView updateSix;
	private TextView updateSeven;

//	private String apiKey = "3CC5C24005597152DFD99FC9EB350E87";
//	private String mySteamId = "76561198083432281";
//	private String matchId = "1996580013";


	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_stats_format);
		
		//Define references to widgets				
		steamIdView = (TextView) findViewById(R.id.steamIdView);
		profileName = (TextView) findViewById(R.id.steamProfileName);
		profileURL = (TextView) findViewById(R.id.steamProfileURL);
		gameOnePlayed = (TextView) findViewById(R.id.gameOnePlayed);
		gameTwoPlayed = (TextView) findViewById(R.id.gameTwoPlayed);
		
		updateOne = (TextView) findViewById(R.id.updateOne);
		updateTwo = (TextView) findViewById(R.id.updateTwo);
		updateThree = (TextView) findViewById(R.id.updateThree);
		updateFour = (TextView) findViewById(R.id.updateFour);
		updateFive = (TextView) findViewById(R.id.updateFive);
		updateSix = (TextView) findViewById(R.id.updateSix);
		updateSeven = (TextView) findViewById(R.id.updateSeven);

				
		
		//LOCAL API CALLS			
		try
		{ 

			//Only for reading local files, if this is a response from a API call this will not be needed
			AssetManager assetManager = getAssets();
			//http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=3CC5C24005597152DFD99FC9EB350E87&steamids=76561198083432281&format=json
			
			InputStream localUserStatsFile = assetManager.open("userstats.json");						
			String rawJsonResultUserStats = loadJSONFromAsset(localUserStatsFile);						
			JSONObject jsonRawFileUserStats = new JSONObject(rawJsonResultUserStats);						
			JSONArray jsonArrayUserStats = new JSONArray(jsonRawFileUserStats.getJSONArray("players").toString());
						
		    for (int i = 0; i < jsonArrayUserStats.length(); i++) 
		    {
				JSONObject jsonObjectUserStats = jsonArrayUserStats.getJSONObject(i);
				String mySteamId = jsonObjectUserStats.getString("steamid");
				steamIdView.setText("My 64bit SteamID: " + mySteamId);
								
				String myProfileName = jsonObjectUserStats.getString("personaname");
				profileName.setText("My Persona Name: " + myProfileName);
				
				final String myProfileURL = jsonObjectUserStats.getString("profileurl");
					profileURL.setClickable(true);
					profileURL.setText("Profile URL: " + myProfileURL);
					profileURL.setOnClickListener(new OnClickListener() {
					        public void onClick(View arg0) 
					        {
					    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(myProfileURL));
					    		startActivity(browserIntent);
					        }
					    });
		    }
		    
		  //----------------------------------Below is games played json parsing-----------------------------------------------//
		    
		    InputStream gamesPlayedStatsFile = assetManager.open("gamesplayed.json");
		    String rawJsonResultGamesPlayed = loadJSONFromAsset(gamesPlayedStatsFile);
		    JSONObject jsonRawFileGamesPlayed = new JSONObject(rawJsonResultGamesPlayed);
		    JSONArray jsonArrayGamesPlayed = new JSONArray(jsonRawFileGamesPlayed.getJSONArray("games").toString());
		    
	    	JSONObject jsonObjectGamesPlayed = jsonArrayGamesPlayed.getJSONObject(0);
	    	String gameOne = jsonObjectGamesPlayed.getString("name");
	    	gameOnePlayed.setText("Game Played: " + gameOne);
	    	
	    	jsonObjectGamesPlayed = jsonArrayGamesPlayed.getJSONObject(1);
	    	String gameTwo = jsonObjectGamesPlayed.getString("name");
	    	gameTwoPlayed.setText("Game Played: " + gameTwo);
	    	
	    	//----------------------------------Below is update json parsing-----------------------------------------------//	    	
	    	
		    InputStream recentUpdateStatsFile = assetManager.open("dotanews.json");
		    String rawJsonResultUpdates = loadJSONFromAsset(recentUpdateStatsFile);
		    JSONObject jsonRawFileUpdates = new JSONObject(rawJsonResultUpdates);
		    JSONArray jsonArrayUpdates = new JSONArray(jsonRawFileUpdates.getJSONArray("newsitems").toString());
		    //JSONArray jsonArrayURL = new JSONArray(jsonRawFileUpdates.getJSONArray("newsitems").toString());
		    

	    	JSONObject jsonObjectUpdates = jsonArrayUpdates.getJSONObject(0);
	    	String upOne = jsonObjectUpdates.getString("title");
	    	final String urlOne = jsonObjectUpdates.getString("url");
	    	updateOne.setClickable(true);
	    	updateOne.setText(upOne);
			updateOne.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlOne));
		    		startActivity(browserIntent);
		        }
		    });

	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(1);
	    	String upTwo = jsonObjectUpdates.getString("title");
	    	final String urlTwo = jsonObjectUpdates.getString("url");
	    	updateTwo.setClickable(true);
	    	updateTwo.setText(upTwo);
			updateTwo.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlTwo));
		    		startActivity(browserIntent);
		        }
		    });
	    	
	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(2);
	    	String upThree = jsonObjectUpdates.getString("title");
	    	final String urlThree = jsonObjectUpdates.getString("url");
	    	updateThree.setClickable(true);
	    	updateThree.setText(upThree);
			updateThree.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlThree));
		    		startActivity(browserIntent);
		        }
		    });
	    	
	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(3);
	    	String upFour = jsonObjectUpdates.getString("title");
	    	final String urlFour = jsonObjectUpdates.getString("url");
	    	updateFour.setClickable(true);
	    	updateFour.setText(upFour);
			updateFour.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlFour));
		    		startActivity(browserIntent);
		        }
		    });
	    	
	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(4);
	    	String upFive = jsonObjectUpdates.getString("title");
	    	final String urlFive = jsonObjectUpdates.getString("url");
	    	updateFive.setClickable(true);
	    	updateFive.setText(upFive);
			updateFive.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlFive));
		    		startActivity(browserIntent);
		        }
		    });

	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(5);
	    	String upSix = jsonObjectUpdates.getString("title");
	    	final String urlSix = jsonObjectUpdates.getString("url");
	    	updateSix.setClickable(true);
	    	updateSix.setText(upSix);
			updateSix.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlSix));
		    		startActivity(browserIntent);
		        }
		    });
	    	
	    	jsonObjectUpdates = jsonArrayUpdates.getJSONObject(6);
	    	String upSeven = jsonObjectUpdates.getString("title");
	    	final String urlSeven = jsonObjectUpdates.getString("url");
	    	updateSeven.setClickable(true);
	    	updateSeven.setText(upSeven);
			updateSeven.setOnClickListener(new OnClickListener() {
		        public void onClick(View arg0) 
		        {
		    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlSeven));
		    		startActivity(browserIntent);
		        }
		    });
	    	
	    	
	    	
	    	//updateOne.setText(String.format("%s%n%n%s%n%n%s%n%n%s%n%n%s%n%n%s%n%n%s%n%n",  upOne, upTwo, upThree, upFour, upFive, upSix, upSeven));
		    			    		    		    		    
		}catch(JSONException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
						
	}
		
	public String loadJSONFromAsset(InputStream inputStream) {
	    String json = null;
	    try {

	        int size = inputStream.available();

	        byte[] buffer = new byte[size];

	        inputStream.read(buffer);

	        inputStream.close();

	        json = new String(buffer, "UTF-8");


	    } catch (IOException ex) {
	        ex.printStackTrace();
	        return null;
	    }
	    return json;
	}
						
}

