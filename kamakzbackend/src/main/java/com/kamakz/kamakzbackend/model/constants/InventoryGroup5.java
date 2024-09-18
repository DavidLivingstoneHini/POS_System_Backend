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
@Table(name = "inventory_group5")
public class InventoryGroup5 extends Model {

    private static final long serialVersionUID = -7152424164758528228L;

    private String groupFiveName = "Fifth Group Sub";

    @ManyToOne
    InventoryGroupName inventoryGroupName;

    public InventoryGroupName getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(InventoryGroupName inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getGroupFiveName() {
        return groupFiveName;
    }

    public void setGroupFiveName(String groupFiveName) {
        this.groupFiveName = groupFiveName;
    }


}
