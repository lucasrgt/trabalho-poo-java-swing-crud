package ui.components.table;

import model.EstudanteModel;
import repositories.EstudanteRepository;
import ui.components.Componente;
import ui.components.buttons.BotaoDeletar;
import ui.components.table.cell.CursoEditor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TabelaAlunos extends JPanel implements Componente {

    private DefaultTableModel model;
    private List<EstudanteModel> estudantes;

    public TabelaAlunos() {
        estudantes = new ArrayList<>();
        setBackground(new Color(229, 237, 245));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        construirTabela();
    }

    private void construirTabela() {
        String[] colunas = {
                "Id",
                "Nome",
                "Idade na Matrícula",
                "E-mail",
                "Endereço",
                "CEP",
                "Telefone",
                "Curso",
                "Observações",
                "Ativo",
                "Deletar"
        };

        model = new DefaultTableModel(colunas, 0) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);

                EstudanteModel estudante = estudantes.get(row);
                switch (column) {
                    case 1:
                        estudante.setNomeCompleto((String) aValue);
                        break;
                    case 2:
                        estudante.setAnoMatricula((String) aValue);
                        break;
                    case 3:
                        estudante.setEmail((String) aValue);
                        break;
                    case 4:
                        estudante.setEndereco((String) aValue);
                        break;
                    case 5:
                        estudante.setCEP((String) aValue);
                        break;
                    case 6:
                        estudante.setTelefone((String) aValue);
                        break;
                    case 7:
                        estudante.setCurso((String) aValue);
                        break;
                    case 8:
                        estudante.setObservacoes((String) aValue);
                        break;
                    case 9:
                        estudante.setAtivo((boolean) aValue);
                        break;

                }

                // Atualiza o estudante com os novos dados
                EstudanteRepository estudanteRepository = new EstudanteRepository();
                estudanteRepository.update(estudante);

                atualizaTabela();
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);

        table.getColumn("Curso").setCellEditor(new CursoEditor());

        BotaoDeletar botaoDeletar = new BotaoDeletar();

        table.getColumn("Deletar").setCellRenderer(botaoDeletar);
        table.getColumn("Deletar").setCellEditor(botaoDeletar);

        atualizaTabela();
    }

    public void atualizaTabela() {
        model.setRowCount(0);

        EstudanteRepository estudanteRepository = new EstudanteRepository();
        estudantes = estudanteRepository.findAll();

        for (EstudanteModel estudante : estudantes) {
            Object[] rowData = {
                    estudante.getId(),
                    estudante.getNomeCompleto(),
                    estudante.getAnoMatricula(),
                    estudante.getEmail(),
                    estudante.getEndereco(),
                    estudante.getCEP(),
                    estudante.getTelefone(),
                    estudante.getCurso(),
                    estudante.getObservacoes(),
                    estudante.isAtivo(),
                    "Deletar"
            };
            model.addRow(rowData);
        }

        System.out.println("Tabela atualizada.");
    }
}
