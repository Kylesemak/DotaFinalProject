package com.example.dotaapp;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.Toast;

public class HeroDisplayAdapter extends BaseExpandableListAdapter
{

  private final SparseArray<Group> groups;
  private final Integer[] heroAbilityImages;
  private final Integer[] heroAbilityDescriptionImages;
  public LayoutInflater inflater;
  public Activity activity;

  public HeroDisplayAdapter(Activity act, SparseArray<Group> groups, Integer[] heroAbilityImages, Integer[] heroAbilityDescriptionImages) 
  {
    activity = act;
    this.groups = groups;
    this.heroAbilityImages = heroAbilityImages;
    this.heroAbilityDescriptionImages = heroAbilityDescriptionImages;
    inflater = act.getLayoutInflater();
  }

  @Override
  public Object getChild(int groupPosition, int childPosition) 
  {
    return groups.get(groupPosition).children.get(childPosition);
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) 
  {
    return 0;
  }
  
  @Override
  public View getGroupView(int groupPosition, boolean isExpanded,
      View convertView, ViewGroup parent) 
  {
    if (convertView == null) 
    {
      convertView = inflater.inflate(R.layout.listrow_group, null);
    }
    
    //convertView = inflater.inflate(R.layout.listrow_group, null);
    //TextView abilityName = (TextView) convertView.findViewById(R.id.abilityName);

    Group group = (Group) getGroup(groupPosition);
    ((CheckedTextView) convertView).setText(group.string);

    //DISPLAYS INDIVIDUAL HEROS PORTRAIT AND ABILITY ICON IMAGES
    for(int i = 0; i <= heroAbilityImages.length + 1; i++)
    {
    	((CheckedTextView) convertView).setCompoundDrawablesWithIntrinsicBounds(heroAbilityImages[groupPosition], 0, 0, 0);
    	//((CheckedTextView) convertView).setCheckMarkDrawable(heroAbilityImages[groupPosition]);
    	((CheckedTextView) convertView).setChecked(isExpanded);
    	//Button heroLinkButton  = (Button) convertView.findViewById(R.id.heroLinkButton);
    }
 
    return convertView;
  }

  @Override
  public View getChildView(int groupPosition, final int childPosition,
      boolean isLastChild, View convertView, ViewGroup parent) 
  {
    final String children = (String) getChild(groupPosition, childPosition);

    ImageView heroAbilityDesImg;   
    
    convertView = inflater.inflate(R.layout.hero_display_activity, null);
    
    heroAbilityDesImg = (ImageView) convertView.findViewById(R.id.abilityDescription);
    //Button heroLinkButton  = (Button) convertView.findViewById(R.id.heroLinkButton);
    
    //DISPLAYS INDIVIDUAL HEROS ABILITY DESCRIPTION IMAGES
    for(int i = 0; i < heroAbilityDescriptionImages.length; i++)
    {	
    	heroAbilityDesImg.setImageResource(heroAbilityDescriptionImages[groupPosition]);
    	
    }
    
    convertView.setOnClickListener(new OnClickListener() 
    {
      @Override
      public void onClick(View v) 
      {
        Toast.makeText(activity, children,
            Toast.LENGTH_SHORT).show();
      }
    });
    return convertView;
  }

  @Override
  public int getChildrenCount(int groupPosition) 
  {
    return groups.get(groupPosition).children.size();
  }

  @Override
  public Object getGroup(int groupPosition) 
  {
    return groups.get(groupPosition);
  }

  @Override
  public int getGroupCount() 
  {
    return groups.size();
  }

  @Override
  public void onGroupCollapsed(int groupPosition) 
  {
    super.onGroupCollapsed(groupPosition);
  }

  @Override
  public void onGroupExpanded(int groupPosition) 
  {
    super.onGroupExpanded(groupPosition);
  }

  @Override
  public long getGroupId(int groupPosition) 
  {
    return 0;
  }

  @Override
  public boolean hasStableIds() 
  {
    return false;
  }

  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) 
  {
    return false;
  }

}
