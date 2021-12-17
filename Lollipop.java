package Exam01;

public class Lollipop implements Phone{
	// 인터페이스를 상속받을때는 implements 라는 키워드를 사용한다!
	
	@Override
	public void Camera() {
		System.out.println("카메라 찍다");
	}

	@Override
	public void Call() {
		System.out.println("전화하다");
	}

	@Override
	public void Message() {
		System.out.println("문자하다");
	}
	
	
}
