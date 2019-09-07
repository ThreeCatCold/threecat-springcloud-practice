package com.threecat.springboot.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject
{
	private List<Observer> obs = new ArrayList<>();

	public void attach(Observer ob)
	{
		obs.add(ob);
	}

	/**
	 * 做出变化时或者某些状态改变时可触发通知方法
	 */
	public void notifyObs()
	{
		obs.stream().forEach(observer -> {observer.observeChange();});
	}
}
