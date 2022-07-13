package com.example.truyum.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApplicationUtil {
	private List<String> categoryList = new ArrayList<>();
	private List<String> activeList = new ArrayList<>();

	public List<String> getCategoryList() {
		return categoryList;
	}

	public List<String> getActiveList() {
		return activeList;
	}

	public ApplicationUtil() {
		super();
		categoryList.add("Main Course");
		categoryList.add("Starters");
		categoryList.add("Dessert");
		categoryList.add("Drinks");
		activeList.add("Yes");
		activeList.add("No");
	}
}
