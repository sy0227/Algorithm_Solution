package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Bday implements Comparable<Bday> {
	String name;
	int year, month, day;
	public Bday(String name, int year, int month, int day) {
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public int compareTo(Bday o) {
		if(this.year == o.year) {
			if(this.month == o.month) return Integer.compare(this.day, o.day);
			else return Integer.compare(this.month, o.month);
		}
		return Integer.compare(this.year, o.year);
	}
}

public class Main_S5_5635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Bday> list = new ArrayList<>();
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list.add(new Bday(name, year, month, day));
		}
		Collections.sort(list);
		System.out.println(list.get(list.size()-1).name+"\n"+list.get(0).name);
	}
}
