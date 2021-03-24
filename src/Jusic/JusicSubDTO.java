package Jusic;

public class JusicSubDTO {
	String seq;
	String name;
	String price;
	String upPrice;
	String per;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUpPrice() {
		return upPrice;
	}
	public void setUpPrice(String upPrice) {
		this.upPrice = upPrice;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	
	public JusicSubDTO(String seq, String name, String price, String upPrice, String per) {
		super();
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.upPrice = upPrice;
		this.per = per;
	}
}

