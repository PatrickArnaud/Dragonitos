/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick tool for processing data
 */
public class Utils {

    public static Object convertArrayDragonsToTab() {

        Object data[][];
        List<Dragon> dragons = new ArrayList<>();
        dragons = DragonDB.getAllDragons();
        data = new Object[dragons.size()][7];
        int i = 0;

        while (i < dragons.size()) {
            data[i][0] = dragons.get(i).getId_dragon();
            data[i][1] = dragons.get(i).getDragon();
            data[i][2] = dragons.get(i).getSexe();
            data[i][3] = dragons.get(i).getLongueur();
            data[i][4] = dragons.get(i).getNombre_ecailles();
            data[i][5] = dragons.get(i).GetCrache_feu();
            data[i][6] = dragons.get(i).getComportement_amoureux();
            i++;
        }
        return data;
    }
}
