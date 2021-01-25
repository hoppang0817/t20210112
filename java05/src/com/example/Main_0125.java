package com.example;

import com.example.db.DBConn1;

public class Main_0125 {

	public static void main(String[] args) {
		/*
		try {
			//정보를 가져올 서버 URL주소
			String url = "http://ihongss.com/json/exam1.json";
			
			//다른 서버를 호출할 클라이언트 객체 생성 okhttp3-10.0.jar라이브러리 이용
			OkHttpClient client = new OkHttpClient();
			
			//요청 방법 설정 : GET방식
			Request.Builder builder = new Request.Builder().url(url).get();
			
			//Request객체 생성
			Request request = builder.build();
			
			//Response 객체 생성
			Response response = client.newCall(request).execute();
			
			//가져온 결과가 성공이라면
			if(response.isSuccessful()) {
				//body에 담겨진 내용 출력하기
				ResponseBody body = response.body();
				String bodyString = body.string();
				System.out.println(bodyString);
				
				//String = JSONObject(HashMap과 비슷함)
				JSONObject jsonObject = new JSONObject(bodyString);
				// 키 와 값 = HashMap<키,값>
				System.out.println(jsonObject.get("ret")+","+jsonObject.get("data"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		// exam2.json 가져오기
		
		try {
			//정보를 가져올 서버 URL주소
			String url = "http://ihongss.com/json/exam2.json";
			
			//다른 서버를 호출할 클라이언트 객체 생성 okhttp3-10.0.jar라이브러리 이용
			OkHttpClient client = new OkHttpClient();
			
			//요청 방법 설정 : GET방식
			Request.Builder builder = new Request.Builder().url(url).get();
			
			//Request객체 생성
			Request request = builder.build();
			
			//Response 객체 생성
			Response response = client.newCall(request).execute();
			
			//가져온 결과가 성공이라면
			if(response.isSuccessful()) {
				//body에 담겨진 내용 출력하기
				ResponseBody body = response.body();
				String bodyString = body.string();
				System.out.println(bodyString);
				
				
				// [{"ret":"y1","data":"123"},{"ret":"y2","data":"234"}]
				// ArrayList<Map<String, Object>>
				JSONArray jsonArray = new JSONArray(bodyString);
				
				//전체를 한번에 출력
				for(int i=0; i<jsonArray.length();i++) {
					JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
					System.out.println(jsonObject.get("ret")+","+jsonObject.get("data"));
				}
				
				//{"ret":"y1","data":"123"}
				JSONObject jsonObject0 = new JSONObject(jsonArray.get(0).toString());
				
				//{"ret":"y1","data":"234"}
				JSONObject jsonObject1 = new JSONObject(jsonArray.get(1).toString());
				
				System.out.println(jsonObject1.get("ret"));
				
				//실습 : data에서 파싱해서 234출력
			    System.out.println(jsonObject1.get("data"));
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//실습 exam4.json에서 회원정보 가져와서7명출력
		
		try {
			//정보를 가져올 서버 URL주소
			String url = "http://ihongss.com/json/exam4.json";
			
			//다른 서버를 호출할 클라이언트 객체 생성 okhttp3-10.0.jar라이브러리 이용
			OkHttpClient client = new OkHttpClient();
			
			//요청 방법 설정 : GET방식
			Request.Builder builder = new Request.Builder().url(url).get();
			
			//Request객체 생성
			Request request = builder.build();
			
			//Response 객체 생성
			Response response = client.newCall(request).execute();
			
			
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				String bodyString = body.string();
				System.out.println(bodyString);
				
				//Object<Array<Object>>
				//Map<Array<Map>>
				JSONObject jsonObject = new JSONObject(bodyString);
				String ret = jsonObject.get("ret").toString();
				String ret1 = jsonObject.get("ret1").toString();
				
				JSONArray jsonArray = new JSONArray(ret);
				for(int i=0;i<jsonArray.length();i++) {
					JSONObject tmpObject = new JSONObject(jsonArray.get(i).toString());
					System.out.println(tmpObject.get("id")+","+tmpObject.get("name")+","+tmpObject.get("age"));
					
				}
				JSONArray jsonArray1 = new JSONArray(ret1);
				for(int i=0;i<jsonArray1.length();i++) {
					JSONObject tmpObject1 = new JSONObject(jsonArray1.get(i).toString());
					System.out.println(tmpObject1.get("id")+","+tmpObject1.get("name")+","+tmpObject1.get("age"));
					
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//exam21.json
		//rank,movieNm,openDt출력
		//Object<Object<Array<Object>>>
		
		try {
			//정보를 가져올 서버 URL주소
			String url = "http://ihongss.com/json/exam21.json";
			
			//다른 서버를 호출할 클라이언트 객체 생성 okhttp3-10.0.jar라이브러리 이용
			OkHttpClient client = new OkHttpClient();
			
			//요청 방법 설정 : GET방식
			Request.Builder builder = new Request.Builder().url(url).get();
			
			//Request객체 생성
			Request request = builder.build();
			
			//Response 객체 생성
			Response response = client.newCall(request).execute();
			
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				String bodyString = body.string();
				System.out.println(bodyString);
				
				
				JSONObject jsonObject = new JSONObject(bodyString);
				String ret = jsonObject.get("boxOfficeResult").toString();
				
				JSONObject jsonObject1 = new JSONObject(ret);
				String ret1 = jsonObject1.get("dailyBoxOfficeList").toString();
				String ret2 = jsonObject1.get("boxofficeType").toString();
				String ret3 = jsonObject1.get("showRange").toString();
				System.out.println(ret2);
				System.out.println(ret3);
				
				
				JSONArray jsonArray = new JSONArray(ret1);
				for(int i =0;i<jsonArray.length();i++) {
					JSONObject tmpObject = new JSONObject(jsonArray.get(i).toString());
					System.out.println(tmpObject.get("rank")+","+tmpObject.get("movieNm")+","+tmpObject.get("openDt"));
				}
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		//exam10
		//Object<Array<Object<Object>>>
		try {
			//정보를 가져올 서버 URL주소
			String url = "http://ihongss.com/json/exam10.json";
			
			//다른 서버를 호출할 클라이언트 객체 생성 okhttp3-10.0.jar라이브러리 이용
			OkHttpClient client = new OkHttpClient();
			
			//요청 방법 설정 : GET방식
			Request.Builder builder = new Request.Builder().url(url).get();
			
			//Request객체 생성
			Request request = builder.build();
			
			//Response 객체 생성
			Response response = client.newCall(request).execute();
			
			if (response.isSuccessful()) {
				ResponseBody body = response.body();
				String bodyString = body.string();
				System.out.println(bodyString);

				JSONObject jsonObject = new JSONObject(bodyString);
				String ret = jsonObject.get("ret").toString();
				String ret1 = jsonObject.get("data").toString();

				JSONArray jsonArray = new JSONArray(ret1);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject tmpObject = new JSONObject(jsonArray.get(i).toString());

					JSONObject tmpObject1 = new JSONObject(tmpObject.get("score").toString());

					System.out.println(tmpObject.get("id") + "," + tmpObject.get("name") + "," + tmpObject.get("age")
							+ "," + tmpObject1.get("math") + "," + tmpObject1.get("eng") + "," + tmpObject1.get("kor"));

				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		DBConn1 db = new DBConn1();
		db.callProcedure(46);//삭제할 게시물 번호
		
	}
}
