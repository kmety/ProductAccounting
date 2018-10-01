package by.itstep.bevza.productAccounting.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SellingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datetimeOfSelling;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priduct_id")
	private Product product;
	private Integer amount;
	private Double factPrice;
	private Double profit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatetimeOfSelling() {
		return datetimeOfSelling;
	}

	public void setDatetimeOfSelling(Date datetimeOfSelling) {
		this.datetimeOfSelling = datetimeOfSelling;
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

	public Double getFactPrice() {
		return factPrice;
	}

	public void setFactPrice(Double factPrice) {
		this.factPrice = factPrice;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellingHistory [id=").append(id).append(", datetimeOfSelling=").append(datetimeOfSelling)
				.append(", shop=").append(shop).append(", product=").append(product).append(", amount=").append(amount)
				.append(", factPrice=").append(factPrice).append(", profit=").append(profit).append("]");
		return builder.toString();
	}

}
