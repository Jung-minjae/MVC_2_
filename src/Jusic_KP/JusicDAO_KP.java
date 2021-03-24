package Jusic_KP;

import java.io.IOException;
import java.util.ArrayList;
import Jusic.JusicDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JusicDAO_KP {
	public JusicDTO_KP getUP() {

		JusicDTO_KP jK = new JusicDTO_KP();

		try {
			String url = "https://finance.naver.com/sise/sise_rise.nhn?sosok=1"; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			ArrayList<String> list3 = new ArrayList<>();
			ArrayList<String> list4 = new ArrayList<>();
			ArrayList<String> list5 = new ArrayList<>();

			// select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
			for (int i = 1; i < 6; i++) {
				Elements element = doc
						.select("#contentarea > div.box_type_l > table > tbody > tr > td:nth-child(" + i + ")");
				for (Element e : element) {
					if (i == 1) {
						if (e.text().equals("")) {
							System.out.println("공백");
						} else {
							System.out.println(i + ":" + e.text());
							list1.add(e.text());
						}
					} else if (i == 2) {
						System.out.println(i + ":" + e.text()); // add
						list2.add(e.text());
					} else if (i == 3) {
						System.out.println(i + ":" + e.text()); // add
						list3.add(e.text());
					} else if (i == 4) {
						System.out.println(i + ":" + e.text()); // add
						list4.add(e.text());
					} else {
						System.out.println(i + ":" + e.text()); // add
						list5.add(e.text());
					}

					System.out.println("============================================================");
				}

				jK = new JusicDTO_KP(list1, list2, list3, list4, list5);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jK;

	}
}