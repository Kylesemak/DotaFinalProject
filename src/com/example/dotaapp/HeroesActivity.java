package com.example.dotaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HeroesActivity extends Activity
implements OnItemClickListener, HeroImages
{
	ListView list; 
	ListView displayList;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);	
				
		HeroAdapter adapter = new HeroAdapter(this, heroName, heroImage, heroAttribute);
		
		list = (ListView) findViewById(R.id.contentList);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(this);
	
    }
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	{
		
		Intent heroDisplayIntent = new Intent(view.getContext(), HeroDisplayActivity.class);
		heroDisplayIntent.putExtra("POS", position);
		//heroDisplayIntent.putExtra("HERO_NAME", heroName[position]);
		startActivity(heroDisplayIntent);
		
	}
}	
