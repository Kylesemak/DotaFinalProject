package com.example.dotaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.view.View;
import android.view.View.OnClickListener;


public class HeroDisplayActivity extends HeroesActivity
implements HeroImages, OnClickListener
{
	SparseArray<Group> groups = new SparseArray<Group>();			
			
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.hero_display_activity_list);
	    
		Intent previousIntent = getIntent();
		//String selectedHero = previousIntent.getStringExtra("HERO_NAME");
		int selectedHero = previousIntent.getIntExtra("POS", 0);
		
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.contentHeroList);
		
    	Button heroLinkButton  = (Button) findViewById(R.id.heroLinkButton);
    	heroLinkButton.setText("Learn more about this hero online.");
    	heroLinkButton.setOnClickListener(this);
		
    	determineSelectedHero(listView, selectedHero);    							 
	}
	
	  
	  public void createData(String[] heroAbilityStrings) 
	  {
		  
	      for (int j = 0; j < heroAbilityStrings.length; j++) 
	      {
	        Group group = new Group(heroAbilityStrings[j]);
	        for (int i = 0; i < 1; i++) 
	        {
	          group.children.add(heroAbilityStrings[j]);
	        }
	        groups.append(j, group);
	      }
	  }

	@Override
	public void onClick(View view) 
	{
		Intent previousIntent = getIntent();
		int buttonPressed = previousIntent.getIntExtra("POS", 0);
		
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(heroURLS[buttonPressed]));
		startActivity(browserIntent);			
	}
	
	public void determineSelectedHero(ExpandableListView listView, int selectedHero)
	{
		if (selectedHero == 0)
		{
		    createData(abbadonAbilitiesStrings);
		    	    
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, abbadonBundleImages, abbadonAbilityImages);
		    listView.setAdapter(adapter);		    
		}
		if (selectedHero == 1)
		{
		    createData(alchemistAbilitiesStrings);
		    	    
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, alchemistBundleImages, alchemistAbilityImages);
		    listView.setAdapter(adapter);
		}
		if (selectedHero == 2)
		{
			createData(aaAbilityStrings);
			
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, aaBundleImages, aaAbilityImages);
		    listView.setAdapter(adapter);			
		}
		if (selectedHero == 3)
		{
			createData(antimageAbilityStrings);
			
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, antimageBundleImages, antimageAbilityImages);
		    listView.setAdapter(adapter);			
		}
		if (selectedHero == 4)
		{
			createData(axeAbilityStrings);
			
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, axeBundleImages, axeAbilityImages);
		    listView.setAdapter(adapter);			
		}
		if (selectedHero >= 5)
		{
			createData(fillinAbilityStrings);
			
		    HeroDisplayAdapter adapter = new HeroDisplayAdapter(this, groups, fillinBundleImages, fillinAbilityImages);
		    listView.setAdapter(adapter);
		}
	}
}