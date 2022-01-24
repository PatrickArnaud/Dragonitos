/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dragons;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.table.AbstractTableModel;
//
///**
// *
// * @author Patri
// */
//public class ModelTable extends AbstractTableModel {
//
//    private DragonList dragons;
//
//    public ModelTable(DragonList dragons) {
//        this.dragons = dragons;
//    }
//
//    public int getRowCount() {
//        System.out.println("DragonListSizeColumn" + dragons.numberOfDragon());
//        return dragons.numberOfDragon();
//    }
//
//    
//    public int getColumnCount() {
//        return 7;
//    }
//
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Object[][] drag = (Object[][]) Utils.convertArrayDragonsToTab();
//        System.out.println("Drag"+ drag.length);
//               
//
//        return "Drag"+ drag.length;
//
//    }
//
//    public boolean isCellEditable(int row, int column) {
//        return false;
//    }
//
//    public void setValueAt(Object value, int indexRow, int indexColumn) {
//        Dragon drag = dragons.get(indexRow);
//        fireTableRowsUpdated(indexRow, indexRow);
//    }
//
//    public Class<? extends Object> getColumnClass(int indexColumn) {
//        return getValueAt(0, indexColumn).getClass();
//    }
//
//}
