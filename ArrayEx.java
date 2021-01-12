package com.example;

//배열 실습
public class ArrayEx {

	int[] a; // 배열 선언

	public ArrayEx() {  // 생성자 : 값이 없음   
		a = new int[5];// int a, int b,.....int e
		a[0] = 12;
		a[1] = 13;
		a[2] = 32;
		a[3] = 17;
		a[4] = 56;
	}

	public ArrayEx(int[] a) {// 생성자 : 전돨된 값을 a에 넣음
		this.a = a;
	}

	//a를 차례로 출력.
	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// a라는 배열에서 값이 짝수인 것만 출력하시오.
	public void print1() {
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}

	// a 배열의 값에서 10 더해진 값을 출력하시오.
	public void print2() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + 10 + " ");
		}
		System.out.println();
	}

	// a 배열의 합계, 평균
	public void print3() {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		float avg = (float) sum / a.length;
		System.out.println("합은 " + sum + "입니다");
		System.out.println("평균은 " + avg + "입니다");
	}

	// a 배열의 최대값
	public void print4() {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("최대값은 " + max + "입니다.");
	}

	// a 배열의 최소 값
	public void print5() {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("최소값은 " + min + "입니다.");
	}

	// 문제) a배열의 짝수합과 홀수합을 구하시오.
	public void print6() {
		int sum = 0;// 짝수 합
		int sum2 = 0;// 홀수 합
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				sum += a[i];
			} else {
				sum2 += a[i];
			}
		}

		System.out.println("짝수합: "+sum+"홀수합: "+sum2 );
	}

	// 문제)a배열의 값을 반대로 출력하시오.
	public void print7() {
		for (int i = a.length-1; i >=0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[a.length-1-i] + " ");
		}
	}

	// 문제)a배열의 위치가 3의 배수인것을 평균을 구하시오.
	public void print8() {
		int sum = 0;
		int cnt = 0;
		float avg =0;
		//0 1 2 3 4 5 6....
		//0 1 2 0 1 2 0 1 2....
		for (int i = 0; i < a.length; i ++) {
			if(i%3 ==2) {
				sum +=a[i];
				cnt++;
			}
		}
		avg = (float) sum / (float)cnt;
		System.out.println("평균은: " + avg);
	}
}
