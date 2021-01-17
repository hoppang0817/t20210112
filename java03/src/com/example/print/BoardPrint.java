package com.example.print;

import com.example.vo.BoardVO;

public class BoardPrint {

	BoardVO[] a;

	public BoardPrint() {// 생성자 : 값이 없음

	}

	public BoardPrint(BoardVO[] a) {// 생성자 : 전돨된 값을 a에 넣음
		this.a = a;
	}

	public void print() {//출력하는 메소드
		for (int i = 0; i < a.length; i++) {
			BoardVO tmp = a[i];
			System.out.println(tmp.getBrd_No() + "," + tmp.getBrd_Title());
		}
	}
}
