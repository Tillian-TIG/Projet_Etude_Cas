/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icon;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Trafiquant de Tigbé
 */
public class tablecelleditor extends DefaultCellEditor{

    private tableaction event ;
    public tablecelleditor( tableaction event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      PanelAction action = new PanelAction();
      action.initEvent(event, row);
      action.setBackground(table.getSelectionBackground());
      return action;
    }
    
    
}
