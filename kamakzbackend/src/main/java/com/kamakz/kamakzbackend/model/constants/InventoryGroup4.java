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
@Table(name = "inventory_group4")
public class InventoryGroup4 extends Model {

    private static final long serialVersionUID = -7152424164758528228L;

    private String groupFourName = "Fourth Group Sub";
    @ManyToOne
    InventoryGroupName inventoryGroupName;

    public InventoryGroupName getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(InventoryGroupName inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getGroupFourName() {
        return groupFourName;
    }

    public void setGroupFourName(String groupFourName) {
        this.groupFourName = groupFourName;
    }


}
