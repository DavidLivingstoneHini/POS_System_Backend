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
@Table(name = "inventory_group3")
public class InventoryGroup3 extends Model {

    private static final long serialVersionUID = -5605386231895691598L;

    private String groupThreeName = "Third Group Sub";
    @ManyToOne
    InventoryGroupName inventoryGroupName;

    public InventoryGroupName getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(InventoryGroupName inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getGroupThreeName() {
        return groupThreeName;
    }

    public void setGroupThreeName(String groupThreeName) {
        this.groupThreeName = groupThreeName;
    }


}
