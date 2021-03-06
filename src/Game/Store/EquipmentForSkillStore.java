package Game.Store;

import bean.Equipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentForSkillStore implements EquipmentStore {

    public List<Equipment> equipments=new ArrayList<>();

    @Override
    public List<Equipment> addEquipment(Equipment equipment){
        equipments.add(equipment);
        return equipments;
    }

    @Override
    public List<Equipment> removeEquipment(Equipment equipment){
        int index = equipments.indexOf(equipment);
        if(index>=0 && index < equipments.size()){  //存在 删除
            equipments.remove(index);
            return equipments;
        }else {
            return equipments;
        }
    }

    @Override
    public Equipment searchEquipment(Equipment equipment){
        int index = equipments.indexOf(equipment);
        if(index>=0 && index<equipments.size()){
            return equipments.get(index);
        }else {
            return null;
        }
    }

    @Override
    public List<Equipment> getAllEquipments(){
        return equipments;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
