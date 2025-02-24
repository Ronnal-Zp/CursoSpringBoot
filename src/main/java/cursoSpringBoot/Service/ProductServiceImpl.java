package cursoSpringBoot.Service;

import cursoSpringBoot.Domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl
{
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"PC AMD", 3000.00, 5),
            new Product(2,"PC INTEL", 5000.00, 7),
            new Product(3,"TECLADO", 100.00, 2)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> addProduct(Product product) {
        products.add(product);
        return products;
    }

}
