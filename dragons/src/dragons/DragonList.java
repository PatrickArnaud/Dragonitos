/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import java.util.ArrayList;

/**
 *
 * @author Patri
 */
public class DragonList {

    ArrayList<Dragon> dragon;

    public DragonList() {
        dragon = new ArrayList<Dragon>();
    }

    public ArrayList<Dragon> getDragon() {
        return dragon;
    }

    public int numberOfDragon() {
        return dragon.size();
    }
    public Dragon DragonListSizeColumn(int index){
        return dragon.get(index);
    }
    

}
