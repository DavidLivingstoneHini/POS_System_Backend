package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "inventory_group2")
public class InventoryGroup2 extends Model {

    private static final long serialVersionUID = -9032493882725635231L;


    private String groupTWOName = "Second Group Sub";
    @ManyToOne
    InventoryGroupName inventoryGroupName;

    public InventoryGroupName getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(InventoryGroupName inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getGroupTWOName() {
        return groupTWOName;
    }

    public void setGroupTWOName(String groupTWOName) {
        this.groupTWOName = groupTWOName;
    }


}
