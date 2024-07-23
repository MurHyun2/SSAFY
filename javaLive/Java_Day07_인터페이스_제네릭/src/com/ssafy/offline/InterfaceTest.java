package com.ssafy.offline;

import java.util.ArrayList;
import java.util.List;

class WebServer implements Server {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Start");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stop");
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println("ReStart");
	}
	
}
class MobServer implements Server {
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("MobStart");
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("MobStop");
	}
	
	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println("MobReStart");
	}
	
}


public class InterfaceTest {
	public static void main(String[] args) {
//		Server s = new Server();
		Server s = new MobServer();
		s.start();
		s.restart();
		s.stop();
		
		System.out.println(Server.PORT);
//		Server.PORT = 100; The final field Server.PORT cannot be assigned
		
		List<String> list = new ArrayList<>();
		list.add("1번");
		list.add("1번");
		list.add("1번");
		System.out.println(list.size());
		System.out.println(list.isEmpty() ? "list는 빔" : "list는 !빔");
	}
}
