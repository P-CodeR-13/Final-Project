package ph.com.cpi.entities;

import java.math.BigDecimal;

public class Products {
	private Integer productId;
	private String productName;
	private BigDecimal price;
	private Integer stocks;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStocks() {
		return stocks;
	}
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
	
	
}
