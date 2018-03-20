package sample;

import java.io.*;

public class XingzuoInfo {
	private int[] startDay = new int[]{120, 219, 321, 421, 521, 622, 723, 823, 923, 1024, 1123};
	private int[] endDay = new int[]{218, 320, 420, 520, 621, 722, 822, 922, 1023, 1122, 1221};

	private String desc;

	private String url;

	private Integer month, day, number;

	public XingzuoInfo(Integer month, Integer day) {
		this.month = month;
		this.day = day;
		number = month * 100 + day;
//		System.out.println(number);
		boolean exist = false;
		for (int i = 0; i < 11; i++) {
			if (number <= endDay[i] && number >= startDay[i]) {
				number = i + 1;
				exist = true;
				break;
			}
		}
		if(!exist){
			number = 12;
		}
	}

	public int getNumber(){
		return number;
	}

	public int[] getStartDay() {
		return startDay;
	}

	public void setStartDay(int[] startDay) {
		this.startDay = startDay;
	}

	public int[] getEndDay() {
		return endDay;
	}

	public void setEndDay(int[] endDay) {
		this.endDay = endDay;
	}

	public String getDesc() {
		StringBuilder result = new StringBuilder();
		try {
			String path = "src/text/check/" + number + ".txt";
//			System.out.println(path);
			BufferedReader br = new BufferedReader(new FileReader(path));
			desc = null;
			while ((desc = br.readLine()) != null){
				result.append(desc);
			}
			desc = result.toString();
//			System.out.println(desc);
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		url = "/img/" + number + ".jpg";
//		System.out.println(url);
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
}
