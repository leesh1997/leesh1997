

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

@WebServlet("/Webtoon")
public class Webtoon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB에 있는 웹툰 데이터를 WebtoonInfo 객체로 만들어서
		//Webtoon.html에 전달!
		
		//DB에 있는 데이터 가정
		//프리드로우 전선욱 토요일
		//갓오브하이스쿨 박용제 금요일
		//신의 탑 SIU 월요일
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plane; charset=UTF-8");
		//response.setContentType("application/x-json; charset=UTF-8");
		
		WebtoonInfo wt1 = new WebtoonInfo("프리드로우", "전선욱", "토요일");
		WebtoonInfo wt2 = new WebtoonInfo("갓오하", "박용제", "금요일");
		WebtoonInfo wt3 = new WebtoonInfo("신의 탑", "SIU", "월요일");
		
		ArrayList<WebtoonInfo> wtList = new ArrayList<WebtoonInfo>();
		wtList.add(wt1);
		wtList.add(wt2);
		wtList.add(wt3);
		//DB에 있는 데이터를 가져왔다!
		
		System.out.println("들어왔니..?");
		//데이터를 json 타입으로 바꾼뒤 반환 시켜줘야한다.
		//Gson라이브러리 필요
		
		//Gson 객체 만들기 --> 자바의 데이터를 json 타입으로 바꾸어 주는 역할
		Gson gson = new Gson(); 
		//JsonArray 객체 --> json 타입으로 바뀐 데이터를 저장할 수 있는 역할
		JsonArray jarray = new JsonArray();
		
		for (int i = 0; i < wtList.size(); i++) {
			jarray.add(gson.toJson(wtList.get(i)));
			//Gson 객체를 사용한다면 키값을 알아서 지정해줌
			//키값 --> 해당하는 변수명
		}
		
		PrintWriter out = response.getWriter();
		out.print(jarray);
		
	}

}
