package Store.retailer.service;


import Store.retailer.dto.ShopDTO;
import Store.retailer.model.Shop;
import Store.retailer.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    @Override
    @Transactional
    public void saveShopInMongoDB(ShopDTO shop) {
        shopRepository.save(Shop.builder()
                                .description(shop.description())
                                .name(shop.name())
                                .build());
    }

    @Override
    @Transactional(readOnly = true)
    public Shop getLastShopFromMongoDB(String id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent())
             return shop.get();

        //TODO
        throw new RuntimeException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getAllShopFromMongoDB() {
        return shopRepository.findAll();
    }
}
