package edu.chl.larsdan.fiskface;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author xclose
 */
@Named("editProduct")
@ConversationScoped
public class EditProductBB implements Serializable {

    private ProductCatalogueBean pcb;
    @Inject
    private Conversation conv;
    @NotNull
    @Size(min = 1, max = 8, message = "Must use 1-10 chars")    
    @Pattern(regexp = "[a-zA-Z0-9\\s]*")
    private String name;
    
    /*@NotNull
    @Size(min = 1, max = 4, message = "Maximum price of 9999 :-")
    @Pattern(regexp = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])")*/
    private Double price;

    
    private Long id;

    public EditProductBB() {
    }

    @Inject
    public EditProductBB(ProductCatalogueBean pcb) {
        this.pcb = pcb;
    }

    public void actionListener(Long id, String name, Double price) {
        if (conv.isTransient()) {
            conv.begin();
        } else {
        }
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String action() {
        if (!conv.isTransient()) {            
            conv.end();
        }
        try {
            pcb.edit(this.id, this.name, this.price);
            return "products?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}