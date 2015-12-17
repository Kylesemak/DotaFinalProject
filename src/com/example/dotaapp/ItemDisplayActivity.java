package com.example.dotaapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;


public class ItemDisplayActivity extends Activity
implements ItemImages
{
	SparseArray<Group> groups = new SparseArray<Group>();		
		
			
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.item_display_activity_list);
	    
		
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.contentItemList);
				
		
	    createData(itemName);
	    	    
	    ItemDisplayAdapter adapter = new ItemDisplayAdapter(this, groups, itemImage, itemDescription);
	    listView.setAdapter(adapter);
		
						 
	}
	
	  
	  public void createData(String[] itemName) 
	  {
		  
	      for (int j = 0; j < itemName.length; j++) 
	      {
	        Group group = new Group(itemName[j]);
	        for (int i = 0; i < 1; i++) 
	        {
	          group.children.add(itemName[j]);
	        }
	        groups.append(j, group);
	      }
	  }
}