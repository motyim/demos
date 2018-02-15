package client ; 

import wspack.*;

public class SampleClient{

	public static void main(String[] args) {
		ServerImp  serverImp = new ServerImpService().getServerImpPort();
		System.out.println("call Say hello ");
		String s = serverImp.sayHello("motyim");
		System.out.println(">> " + s);
		System.out.println("call Say sum ");
		System.out.println(" 2 + 3 = "+serverImp.sum(2,3));
	}

}