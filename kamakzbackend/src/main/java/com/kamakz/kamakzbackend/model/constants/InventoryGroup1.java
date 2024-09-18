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
@Table(name = "inventory_group1")
public class InventoryGroup1 extends Model {

    private static final long serialVersionUID = -6499346147024120400L;

    private String groupOneName = "First Group Sub";
    @ManyToOne
    InventoryGroupName inventoryGroupName;

    public InventoryGroupName getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(InventoryGroupName inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }



    public String getGroupOneName() {
        return groupOneName;
    }

    public void setGroupOneName(String groupOneName) {
        this.groupOneName = groupOneName;
    }
}

