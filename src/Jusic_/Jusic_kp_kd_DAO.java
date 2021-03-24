package Jusic_;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jusic_kp_kd_DAO {
	public Jusic_kp_kd_DTO getKD_KP() {

		Jusic_kp_kd_DTO jkp = new Jusic_kp_kd_DTO();

		try {
			String url = "https://finance.naver.com/main/main.nhn";
			Document doc = Jsoup.connect(url).get();
			ArrayList<String> list1 = new ArrayList<>();

			Elements element = doc.select(".section_stock_market .section_stock .heading_area .num_quot");
			for (Element a : element) {

				list1.add(a.text());
			}

			jkp = new Jusic_kp_kd_DTO(list1);

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return jkp;
	}
}
