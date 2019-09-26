package ph.com.cpi.entities;

import java.math.BigDecimal;

public class Cart {
	private String productName;
	private BigDecimal price;
	private Integer stocks;
	private Integer productId;
	private String image;
	private Integer quantity;
	private BigDecimal total;
	

	public Cart(Integer productId, String productName, BigDecimal price, Integer stocks, String image, Integer quantity, BigDecimal total) {
		this.productName = productName;
		this.price = price;
		this.productId = productId;
		this.stocks = stocks;
		this.image = image;
		this.quantity = quantity;
		this.total = total;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [productName=" + productName + ", price=" + price + ", stocks=" + stocks + ", productId="
				+ productId + ", image=" + image + ", quantity=" + quantity + ", total=" + total + "]";
	}

	
	
}
