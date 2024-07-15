package Store.retailer.controller;


import Store.retailer.dto.ShopDTO;
import Store.retailer.model.Shop;
import Store.retailer.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shop")
public class RestControllerShop {

   private final ShopService service;

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShopFromMongoDB() {

        List<Shop> shops = service.getAllShopFromMongoDB();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getLastShopFromMongoDB(@PathVariable("id") String id) {

        Shop shop = service.getLastShopFromMongoDB(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveShopFromMongoDB(@RequestBody ShopDTO shopDTO) {

        service.saveShopInMongoDB(shopDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
