package com.example.inheritance;

@FunctionalInterface
interface InterfaceA { 
	public String getVal();
    default void defaultMethod(){ 
        System.out.println("Interface A default method"); 
    }
    public static void staticMethod() {
    	System.out.println("Interface A static method");
    }

}

@FunctionalInterface
interface InterfaceB {
	public String getVal();
    default void defaultMethod(){
        System.out.println("Interface B default method");
    }
    default void defaultMethod2(){
        System.out.println("Interface B default method2");
    }
    default void defaultMethod3(){
        System.out.println("Interface B default method3");
    }
    public static void staticMethod() {
    	System.out.println("Interface B static method");
    }
    public static void staticMethod1() {
    	System.out.println("Interface B static method1");
    }
}

public class FunctionalInterfaceDemo implements InterfaceA, InterfaceB{
	
	public void defaultMethod(){
		InterfaceA.super.defaultMethod(); // call interfaceA default method
		InterfaceB.super.defaultMethod(); // call interfaceB default method
        System.out.println("Interface B default method");
    }
	
	@Override
	public String getVal() {
		return null;
	}
	public static void main(String[] args) {

	}
}
