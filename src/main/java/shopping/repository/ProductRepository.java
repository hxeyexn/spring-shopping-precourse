package shopping.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import shopping.domain.Product;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();
    private long sequence = 1L;

    public Product save(Product product) {
        Product saved = new Product(sequence, product.name(), product.price(), product.imageUrl());
        products.put(sequence, saved);
        sequence++;

        return saved;
    }
}
