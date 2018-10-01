package by.itstep.bevza.productAccounting.controller;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itstep.bevza.productAccounting.service.impls.ProductService;
import by.itstep.bevza.productAccounting.service.impls.SellingHistoryService;
import by.itstep.bevza.productAccounting.service.impls.ShopService;
import by.itstep.bevza.productAccounting.service.impls.ShopStorageService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopStorageService storageService;
	@Autowired
	private SellingHistoryService historyService;
	@Autowired
	private ProductService prService;

	@RequestMapping("/dashboard/{id}") // dashboard
	public ModelAndView managerStartPage1(@PathVariable Long id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date searchFrom,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date searchTo,
			@RequestParam(required = false) String productName) {
		System.err.println(searchFrom);
		System.err.println(searchTo);
		System.err.println(productName);
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("shopList", shopService.getShops());
		mv.addObject("shopStorageList", storageService.getStorageList(id));
		mv.addObject("sHistoryList", historyService.getSellingHistory(id).stream().filter(item -> {
			if (productName == null || productName.trim().isEmpty()
					|| item.getProduct().getName().equalsIgnoreCase(productName)) {
				if ((searchFrom == null && searchTo == null)
						|| (searchTo == null && item.getDatetimeOfSelling().after(searchFrom))
						|| (searchFrom == null && item.getDatetimeOfSelling().before(searchTo))
						|| (searchFrom != null && searchTo != null && item.getDatetimeOfSelling().after(searchFrom)
								&& item.getDatetimeOfSelling().before(searchTo))) {
					System.err.println("true1");
					return true;
				} else {
					System.err.println("false1");
					return false;
				}
			} else {
				System.err.println("false2");
				return false;
			}
		}).collect(Collectors.toList()));
		mv.addObject("productList", prService.getProducts());
		mv.addObject("tradingList", storageService.getListForTrading(id));
		mv.addObject("id", id);
		return mv;
	}

}
