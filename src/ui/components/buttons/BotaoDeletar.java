package ui.components.buttons;

import repositories.EstudanteRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoDeletar extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    JButton renderButton;
    JButton editButton;
    String text;
    JTable table;

    public BotaoDeletar() {

        renderButton = new JButton();
        renderButton.setBackground(new Color(255, 80, 80));

        editButton = new JButton();
        editButton.setBackground(new Color(255, 80, 80));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int row = table.getSelectedRow();

                // Obtenha o ID do estudante na linha selecionada
                int idEstudante = (int) table.getModel().getValueAt(row, 0);  // Supondo que o ID esteja na coluna 0

                // Remove o estudante do banco de dados
                new EstudanteRepository().delete(idEstudante);

                // Remove a linha da tabela
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);

                // Atualize a tabela...
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            renderButton.setText("");
        } else {
            renderButton.setText(value.toString());
        }
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            editButton.setText("");
        } else {
            editButton.setText(value.toString());
        }
        this.table = table;
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }

}
