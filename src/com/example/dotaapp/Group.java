package com.example.dotaapp;

import java.util.ArrayList;
import java.util.List;

public class Group 
{

  public String string;
  public Integer integer;
  public final List<String> children = new ArrayList<String>();

  public Group(String string) 
  {
    this.string = string;
  }
  
  public Group(Integer integer)
  {
	  this.integer = integer;
  }

}
           

