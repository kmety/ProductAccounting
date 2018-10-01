package by.itstep.bevza.productAccounting.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShopStorage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	private Integer amount;
	private Double avgPrice;
	private Double factPrice;
	private Boolean onTrading;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public Double getFactPrice() {
		return factPrice;
	}

	public void setFactPrice(Double factPrice) {
		this.factPrice = factPrice;
	}

	public Boolean getOnTrading() {
		return onTrading;
	}

	public void setOnTrading(Boolean onTrading) {
		this.onTrading = onTrading;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopStorage [shop=").append(shop).append(", product=").append(product).append(", amount=")
				.append(amount).append(", avgPrice=").append(avgPrice).append(", factPrice=").append(factPrice)
				.append(", onTrading=").append(onTrading).append("]");
		return builder.toString();
	}

}
