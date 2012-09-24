/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.larsdan.fiskface;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author xclose
 */
@Named("deleteProduct")
@ConversationScoped
public class DeleteProductBB implements Serializable {

    private ProductCatalogueBean pcb;
    @Inject
    Conversation conv;

    public DeleteProductBB() {}      

    @Inject
    public DeleteProductBB(ProductCatalogueBean pcb) {
        this.pcb = pcb;
    }

    public void actionListener(Long id) {
        if (conv.isTransient()) {
            conv.begin();
        } else {
        }
        pcb.delete(id);
    }
     public String action() {
        if (!conv.isTransient()) {
            conv.end();
        }
        try {
            return "products?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }
}
