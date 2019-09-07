package com.threecat.springboot.design.observer;

public class Observer1 implements Observer
{
	@Override
	public void observeChange()
	{
		System.out.println("subject changed.");
	}
}
