package pureView.dto;

public class CosmeticDto {
	private int cosNum, price, volume;
	private String name, category, company, sideEffect, ingrdName;

	public CosmeticDto() {
	}

	public CosmeticDto(int cosNum, String name, String category, int price, String company, int volume) {
		super();
		this.cosNum = cosNum;
		this.price = price;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.company = company;
	}

	public CosmeticDto(int cosNum, String name, String category, int price, String company, int volume,
			String sideEffect, String ingrdName) {
		super();
		this.cosNum = cosNum;
		this.price = price;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.company = company;
		this.sideEffect = sideEffect;
		this.ingrdName = ingrdName;
	}

	public int getCosNum() {
		return cosNum;
	}

	public void setCosNum(int cosNum) {
		this.cosNum = cosNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		if (sideEffect != null && ingrdName != null)
			return "상품명: " + name + ", 카테고리: " + category + ", 위험재료명: " + ingrdName + ", 부작용: " + sideEffect + ", 가격: "
					+ price + ", 용량: " + volume + ", 회사명: " + company;
		return "상품명: " + name + ", 카테고리: " + category + "가격: " + price + ", 용량: " + volume + ", 회사명: " + company;
	}

}