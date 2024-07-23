package test01_interface;

public class IPhone implements AlarmSound{
	@Override
	public void playAlarm() {
		// TODO Auto-generated method stub
		System.out.println("IPhone 알람을 울립니다.");
	}
}
