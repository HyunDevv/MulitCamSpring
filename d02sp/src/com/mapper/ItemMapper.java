package com.mapper;

import java.util.ArrayList;

import com.vo.Item;

public interface ItemMapper {
	public void insert(Item obj);
	public void delete(Integer obj);
	public void update(Item obj);
	public Item select(Integer obj);
	public ArrayList<Item> selectall();
	public ArrayList<Item> search(Integer obj);
	public ArrayList<Item> search(Integer obj1, Integer obj2);
}



