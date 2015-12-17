
package com.example.dotaapp;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;




public class MainActivity extends Activity
implements OnClickListener
{

	private Button heroesButton;
	private Button itemsButton;
	private Button signInButton;
	
//	private String apiKey = "3CC5C24005597152DFD99FC9EB350E87";
//	private String mySteamId = "76561198083432281";
//	private String matchId = "1996580013";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
					
		//Define references to widgets
		
		heroesButton = (Button) findViewById(R.id.heroesButton);
		itemsButton = (Button) findViewById(R.id.itemsButton);
		signInButton = (Button) findViewById(R.id.signInButton);
				
		//Define the listeners
		heroesButton.setOnClickListener(this);
		itemsButton.setOnClickListener(this);
		signInButton.setOnClickListener(this);
		
	}
				
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View view) 
	{		
		switch(view.getId())
		{
		case R.id.heroesButton:
			{
				Intent heroesIntent = new Intent(view.getContext(), HeroesActivity.class);
				startActivityForResult(heroesIntent, 0);
				break;
			}
		case R.id.itemsButton:
			{
				Intent itemsIntent = new Intent(view.getContext(), ItemDisplayActivity.class);
				startActivityForResult(itemsIntent, 0);
				break;
			}
		case R.id.signInButton:
			{
				Intent userStatsIntent = new Intent(view.getContext(), UserStatsActivity.class);
				startActivityForResult(userStatsIntent, 0);
				break;			
			}
		}
	}	
}
