package by.itstep.bevza.productAccounting.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IncomingProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateOfProductIncome;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priduct_id")
	private Product product;
	private Integer amount;
	private Double price;
	private Double totalPrice;

	public IncomingProductHistory() {
		super();
		this.dateOfProductIncome = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfProductIncome() {
		return dateOfProductIncome;
	}

	public void setDateOfProductIncome(LocalDate dateOfProductIncome) {
		this.dateOfProductIncome = dateOfProductIncome;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IncomingProductHistory [dateOfProductIncome=").append(dateOfProductIncome).append(", shop=")
				.append(shop).append(", product=").append(product).append(", amount=").append(amount).append(", price=")
				.append(price).append(", totalPrice=").append(totalPrice).append("]");
		return builder.toString();
	}

}
