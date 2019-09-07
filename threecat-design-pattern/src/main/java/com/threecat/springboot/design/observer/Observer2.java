package com.threecat.springboot.design.observer;

public class Observer2 implements Observer
{
	@Override public void observeChange()
	{
		System.out.println("changed.");
	}
}
