/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.larsdan.fiskface;

import edu.chl.hajo.shop.core.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;

/**
 *
 * @author xclose
 */

@Named("products")
@RequestScoped
public class ProductsBB {
    
    private ProductCatalogueBean pcb;
    
    public ProductsBB(){
    }
    
    @Inject
    public ProductsBB(ProductCatalogueBean pcb){
        this.pcb = pcb;
    }
    
    public List<Product> getAll(){
        LogUtil.isAlive(pcb.getAll(), LogUtil.MAGENTA);
        return pcb.getAll();
    }
    
    
}
