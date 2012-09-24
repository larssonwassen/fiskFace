/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.larsdan.fiskface;

import edu.chl.hajo.shop.core.Product;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author xclose
 */
@Named("newProduct")
@RequestScoped
public class NewProductBB {

    private ProductCatalogueBean pcb;
    
    @NotNull
    @Size(min = 1, max = 8, message = "Must use 1-10 chars")    
    @Pattern(regexp = "[a-zA-Z0-9\\s]*")
    private String name;
    
    /*@NotNull
    @Size(min = 1, max = 4, message = "Maximum price of 9999 :-")
    @Pattern(regexp = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])")*/
    private Double price;
    
    public NewProductBB() {
    }
    
    @Inject
    public NewProductBB(ProductCatalogueBean pcb) {
        this.pcb = pcb;
    }
    
    public void add(){
        LogUtil.isAlive("addar vi ölite här", LogUtil.RED);
        pcb.add(new Product(name, price));
    }
    
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;} 
}
