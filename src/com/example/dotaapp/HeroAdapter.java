package com.example.dotaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

public class HeroAdapter extends ArrayAdapter<String> 
{
    private final Activity context;
    private final String[] heroName;
    private final Integer[] heroImage;
    private final Integer[] heroAttribute;
    
    
    public HeroAdapter(Activity context, String[] heroName, Integer[] heroImage, Integer[] heroAttribute) 
    {
    	super(context, R.layout.hero_format, heroName);
    	
    	this.context = context;
    	this.heroName = heroName;
    	this.heroImage = heroImage;
    	this.heroAttribute = heroAttribute;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View view, ViewGroup parent) 
    {
    	LayoutInflater inflater = context.getLayoutInflater();
    	View rowView = inflater.inflate(R.layout.hero_format, null, true);
    	
    	ImageView extraText = (ImageView) rowView.findViewById(R.id.heroesAttribute);
    	ImageView imageView = (ImageView) rowView.findViewById(R.id.heroIcon);
    	TextView txtTitle = (TextView) rowView.findViewById(R.id.heroName);
    	
    	for (int i = 0; i <= heroName.length;i++)
    	{
    		txtTitle.setText(heroName[position]);
    		extraText.setImageResource(heroAttribute[position]);
    	}
    	for (int i = 0; i <= heroImage.length; i++)
    	{
    		imageView.setImageResource(heroImage[position]);
    	}
    	
    	return rowView;
    }
           
}
