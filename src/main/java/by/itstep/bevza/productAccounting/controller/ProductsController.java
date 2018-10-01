package by.itstep.bevza.productAccounting.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import by.itstep.bevza.productAccounting.model.IncomingProductHistory;
import by.itstep.bevza.productAccounting.model.Product;
import by.itstep.bevza.productAccounting.model.Shop;
import by.itstep.bevza.productAccounting.model.ShopStorage;
import by.itstep.bevza.productAccounting.service.impls.IncomingProductHistoryService;
import by.itstep.bevza.productAccounting.service.impls.ProductService;
import by.itstep.bevza.productAccounting.service.impls.ShopService;
import by.itstep.bevza.productAccounting.service.impls.ShopStorageService;

@Controller
@RequestMapping("/manager")
public class ProductsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private IncomingProductHistoryService incomeService;
    @Autowired
    private ShopStorageService storageService;

    @PostMapping("/processProductForm")
    public ModelAndView processProductForm(@RequestParam Long productId, @RequestParam Integer amount, @RequestParam Double price, @RequestParam Long shopId, @RequestParam Long id) {

        Product product = new Product();
        product.setId(productId);

        Shop shop = new Shop();
        shop.setId(shopId);

        ShopStorage shopStorage = storageService.getStorageByShopIdAndProductId(shopId, productId);
        if (shopStorage == null) {
            shopStorage = new ShopStorage();
            shopStorage.setProduct(product);
        }

        Integer productAmount = shopStorage.getAmount() == null ? 0 : shopStorage.getAmount();
        shopStorage.setAmount(productAmount + amount);

        Double avgPrice = shopStorage.getAvgPrice() == null ? price : shopStorage.getAvgPrice();
        shopStorage.setAvgPrice((avgPrice + price) / 2);
        shopStorage.setShop(shop);
        shopStorage.setOnTrading(false);

        storageService.putStorageItem(shopStorage);

        ModelAndView modelAndView = new ModelAndView("redirect:/manager/dashboard/" + id);
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView processProductForm(@RequestParam String name, @RequestParam String info, @RequestParam Long id) {
        Product product = new Product();
        product.setName(name);
        product.setInfo(info);
        productService.addProduct(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/manager/dashboard/" + id);
        return modelAndView;
    }

    @PostMapping("/putToTrading")
    public ModelAndView putToTradingRedirect(@RequestParam Long storageItemId, @RequestParam Double factPrice, @RequestParam Long id) {
        ShopStorage shopStorage = storageService.getById(storageItemId);
        shopStorage.setOnTrading(true);
        shopStorage.setFactPrice(factPrice);
        storageService.putStorageItem(shopStorage);
        ModelAndView modelAndView = new ModelAndView("redirect:/manager/dashboard/" + id);
        return modelAndView;
    }

    @PostMapping("/putFromTrading")
    public ModelAndView putFromTradingRedirect(@RequestParam Long storageItemId, @RequestParam Long id) {
        ShopStorage shopStorage = storageService.getById(storageItemId);
        shopStorage.setOnTrading(false);
        storageService.putStorageItem(shopStorage);
        ModelAndView modelAndView = new ModelAndView("redirect:/manager/dashboard/" + id);
        return modelAndView;
    }

    @GetMapping("/tradingEdit/{id}")
    public ModelAndView putToTrading(@PathVariable Long id, @RequestParam String productName,
                                     @RequestParam Integer amount, @RequestParam Double avgPrice, @RequestParam Double factPrice) {
        ModelAndView mv = new ModelAndView("redirect:/manager/putToTrading/");
        mv.addObject("shopStorage", storageService.getStorageList(id));
        return mv;
    }

}
