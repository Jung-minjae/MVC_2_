package Jusic_KP;
import java.util.ArrayList;

import org.jsoup.nodes.Element;

public class JusicDTO_KP {
	ArrayList<String> list1 = new ArrayList<>();
	ArrayList<String> list2 = new ArrayList<>();
	ArrayList<String> list3 = new ArrayList<>();
	ArrayList<String> list4 = new ArrayList<>();
	ArrayList<String> list5 = new ArrayList<>();
	
	public JusicDTO_KP() {
		
	}

	public JusicDTO_KP(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> list3, ArrayList<String> list4,
			ArrayList<String> list5) {
		super();
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
		this.list4 = list4;
		this.list5 = list5;
	}

	public ArrayList<String> getList1() {
		return list1;
	}

	public void setList1(ArrayList<String> list1) {
		this.list1 = list1;
	}

	public ArrayList<String> getList2() {
		return list2;
	}

	public void setList2(ArrayList<String> list2) {
		this.list2 = list2;
	}

	public ArrayList<String> getList3() {
		return list3;
	}

	public void setList3(ArrayList<String> list3) {
		this.list3 = list3;
	}

	public ArrayList<String> getList4() {
		return list4;
	}

	public void setList4(ArrayList<String> list4) {
		this.list4 = list4;
	}

	public ArrayList<String> getList5() {
		return list5;
	}

	public void setList5(ArrayList<String> list5) {
		this.list5 = list5;
	}
	
	
	
}
