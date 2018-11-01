package jp.co.rakus.form;

/**
 * 洋服検索のフォームクラス.
 * 
 * @author risa.okumura
 *
 */
public class ClothesForm {
	
	/**	id */
	private String id;
	/** カテゴリー */
	private String category;
	/** ジャンル */
	private String genre;
	/** 性別 */
	private String gender;
	/** 色 */
	private String color;
	/** 価格 */
	private String price;
	/** サイズ */
	private String size;
	
	public Integer getIntId() {
		return Integer.parseInt(this.id);
	}
	
	public Integer getIntGender() {
		return Integer.parseInt(this.gender);
	}
	
	public Integer getIntPrice() {
		return Integer.parseInt(this.price);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ClothesForm [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender
				+ ", color=" + color + ", price=" + price + ", size=" + size + "]";
	}
	
	

}
