package ui.components.table;

import model.EstudanteModel;
import repositories.EstudanteRepository;
import ui.components.Componente;
import ui.components.buttons.BotaoDeletar;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TabelaAlunos extends JPanel implements Componente {

    private DefaultTableModel model;

    public TabelaAlunos() {
        setBackground(new Color(229, 237, 245));
        setLayout(new BorderLayout());  // Adiciona o BorderLayout
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        construirTabela();
    }

    private void construirTabela() {
        // Colunas da tabela
        String[] columnNames = {
                "Id",
                "Nome",
                "Idade na Matrícula",
                "E-mail",
                "Endereço",
                "CEP",
                "Telefone",
                "Usuário",
                "Curso",
                "Ativo",
                "Deletar"
        };

        // Modelo da tabela
        model = new DefaultTableModel(columnNames, 0);

        // Tabela
        JTable table = new JTable(model);

        // Adiciona a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Adiciona o painel de rolagem ao painel
        add(scrollPane, BorderLayout.CENTER);

        BotaoDeletar botaoDeletar = new BotaoDeletar();
        table.getColumn("Deletar").setCellRenderer(botaoDeletar);
        table.getColumn("Deletar").setCellEditor(botaoDeletar);

        // Atualiza a tabela ao iniciar o programa
        atualizaTabela();
    }

    public void atualizaTabela() {
        // Limpa a tabela
        model.setRowCount(0);

        // Buscar estudantes do banco de dados
        EstudanteRepository estudanteRepository = new EstudanteRepository();
        List<EstudanteModel> estudantes = estudanteRepository.findAll();

        // Adicionar estudantes à tabela
        for (EstudanteModel estudante : estudantes) {
            Object[] rowData = {
                    estudante.getId(),
                    estudante.getNomeCompleto(),
                    estudante.getAnoMatricula(),
                    estudante.getEmail(),
                    estudante.getEndereco(),
                    estudante.getCEP(),
                    estudante.getTelefone(),
                    estudante.getUsuario(),
                    estudante.getCurso(),
                    estudante.isAtivo(),
                    "Deletar"
            };
            model.addRow(rowData);
        }

        System.out.println("Tabela atualizada.");
    }
}
