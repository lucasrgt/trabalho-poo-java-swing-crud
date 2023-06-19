package ui.components.table.cell;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursoEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private String[] cursos = {"Curso 1", "Curso 2", "Curso 3"};
    private JComboBox<String> comboBox;

    public CursoEditor() {
        this.comboBox = new JComboBox<>(cursos);
        comboBox.addActionListener(this);
    }

    @Override
    public Object getCellEditorValue() {
        return comboBox.getSelectedItem();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        comboBox.setSelectedItem(value);
        return comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stopCellEditing();
    }
}
