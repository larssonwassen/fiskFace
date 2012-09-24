/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.larsdan.fiskface;

import edu.chl.hajo.shop.core.IProductCatalogue;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.ProductCatalogue;
import edu.chl.hajo.shop.core.Shop;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author xclose
 */
@Named("ProductCatalogueBean")
@SessionScoped
public class ProductCatalogueBean implements Serializable {

    IProductCatalogue prodcat = Shop.INSTANCE.getProductCatalogue();

    public ProductCatalogueBean() {
    }

    @PostConstruct
    public void postContruct() {
        LogUtil.isAlive(this, LogUtil.MAGENTA);
    }

    public List<Product> getAll() {
        return prodcat.getAll();
    }

    public void add(Product product) {
        prodcat.add(product);
    }

    public void delete(Long id) {
        prodcat.remove(id);
    }

    public void edit(Long id, String name, Double price) {
        prodcat.update(new Product(id, name, price));
    }
}
