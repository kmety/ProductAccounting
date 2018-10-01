package by.itstep.bevza.productAccounting.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itstep.bevza.productAccounting.model.SellingHistory;
import by.itstep.bevza.productAccounting.model.Shop;
import by.itstep.bevza.productAccounting.model.ShopStorage;
import by.itstep.bevza.productAccounting.service.impls.ProductService;
import by.itstep.bevza.productAccounting.service.impls.SellingHistoryService;
import by.itstep.bevza.productAccounting.service.impls.ShopService;
import by.itstep.bevza.productAccounting.service.impls.ShopStorageService;

@Controller
public class CustomerSiteController {
	@Autowired
	private ShopStorageService storageService;

	@Autowired
	private ShopService shopService;

	@Autowired
	private SellingHistoryService sellingHistoryService;

	@Autowired
	private ProductService productService;

	@GetMapping("/shop/{id}")
	public ModelAndView shop1(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("Shop");
		mv.addObject("shop", shopService.getShopById(id).orElse(null));
		mv.addObject("id", id);
		mv.addObject("shopStorageList", storageService.getStorageList(id));
		return mv;
	}

	@GetMapping("/product/{id}")
	public ModelAndView product(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("product", productService.getById(id));
		return mv;
	}

	@PostMapping("/shop/makeOrder")
	public ModelAndView makeOrder(@RequestParam List<Long> ids, @RequestParam List<Integer> amounts,
			@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("redirect:/shop/" + id);
		for (int i = 0; i < ids.size(); i++) {
			ShopStorage shopStorage = storageService.getById(ids.get(i));
			shopStorage.setAmount(shopStorage.getAmount() - amounts.get(i));
			storageService.putStorageItem(shopStorage);
			SellingHistory sellingHistory = new SellingHistory();
			sellingHistory.setDatetimeOfSelling(new Date());
			sellingHistory.setProduct(shopStorage.getProduct());
			sellingHistory.setAmount(amounts.get(i));
			sellingHistory.setFactPrice(amounts.get(i) * shopStorage.getFactPrice());
			Shop shop = new Shop();
			shop.setId(id);
			sellingHistory.setShop(shop);
			sellingHistoryService.putSellingHistory(sellingHistory);
		}
		return mv;
	}

}
