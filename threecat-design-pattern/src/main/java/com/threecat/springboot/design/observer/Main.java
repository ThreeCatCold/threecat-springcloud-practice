package com.threecat.springboot.design.observer;

public class Main
{
	public static void main(String[] args)
	{
		Observer ob1 = new Observer1();
		Observer ob2 = new Observer2();
		Subject subject = new Subject();
		subject.attach(ob1);
		subject.attach(ob2);

		subject.notifyObs();
	}
}
