package com.jikim._interface;

public class Main {
	public static void main(String[] args) {
		Foo	foo = new DefaultFoo("Kim");
		foo.printName();
		foo.printNameUpperCase();

		Foo.printAnything();
	}
}
