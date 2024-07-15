package Store.retailer.service;

import Store.retailer.dto.ShopDTO;
import Store.retailer.model.Shop;

import java.util.List;

public interface ShopService {

    void saveShopInMongoDB(ShopDTO shop);

    Shop getLastShopFromMongoDB(String id);

    List<Shop> getAllShopFromMongoDB();

}
