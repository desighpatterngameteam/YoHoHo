package Game.Store;

import bean.Equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * 商店接口（包含，增，删商品）
 */
public interface EquipmentStore {

    public List<Equipment> addEquipment(Equipment equipment);

    public List<Equipment> removeEquipment(Equipment equipment);

    public Equipment searchEquipment(Equipment equipment);

//    public Equipment updateEquipment(Equipment equipment);

}
