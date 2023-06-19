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
    int editRow;
    int editColumn;

    public BotaoDeletar() {

        renderButton = new JButton();
        renderButton.setBackground(new Color(255, 80, 80));

        editButton = new JButton();
        editButton.setBackground(new Color(255, 80, 80));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Você realmente deseja deletar este estudante?",
                        "Aviso", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    fireEditingStopped();

                    int idEstudante = (int) table.getModel().getValueAt(editRow, 0);

                    // Remove o estudante do banco de dados
                    new EstudanteRepository().delete(idEstudante);

                    // Remove a linha da tabela
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(editRow);
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            renderButton.setText("Deletar");
        } else {
            renderButton.setText(value.toString());
        }
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            editButton.setText("Deletar");
        } else {
            editButton.setText(value.toString());
        }
        this.table = table;
        this.editRow = row;
        this.editColumn = column;
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }
}
