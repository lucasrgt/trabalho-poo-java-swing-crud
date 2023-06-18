package ui.components.table;

import model.EstudanteModel;
import repositories.EstudanteRepository;
import ui.components.Componente;
import ui.components.buttons.BotaoDeletar;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TabelaAlunos extends JPanel implements Componente {

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

        // Dados da tabela (para teste)
        Object[][] data = {
                {"João", 20, "joao@email.com", "Rua 1, 123", "12345-678", "(11) 1234-5678", "joao123", "Curso 1", true, "Deletar"},
                {"Maria", 22, "maria@email.com", "Rua 2, 456", "23456-789", "(22) 2345-6789", "maria456", "Curso 2", false, "Deletar"},
                // adicione mais linhas conforme necessário
        };

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

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



    }

}
