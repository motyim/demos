package mypack;

import javax.jws.WebService; 
/**
* here will be server imp
*/
@WebService 
public class ServerImp {

	public String sayHello(String name){
		return "hello "+ name + "from WebService...";
	}

	public int sum(int num1 , int num2){
		return num1 + num2 ; 
	}

}