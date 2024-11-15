package com.ssafy.off.day09;

class MyClose implements AutoCloseable {
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyClose");
	}
}

public class ExceptionTest01 {
	public static void main(String[] args) {
//		MyClose mc = null;
//		
//		try {
//			mc = new MyClose();
//			System.out.println(1);
//		} catch (Exception e) {
//			System.out.println(2);
//			// TODO: handle exception
//		} finally { // 마지막에 자원 정리에 주로 사용
//			try {
//				mc.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(3);
//		}
//		System.out.println(4);
		
		// The resource type MyClose does not implement java.lang.AutoCloseable
		try (MyClose mc = new MyClose()) {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
			// TODO: handle exception
		} finally { // 마지막에 자원 정리에 주로 사용
			System.out.println(3);
		}
		System.out.println(4);
	}
}
