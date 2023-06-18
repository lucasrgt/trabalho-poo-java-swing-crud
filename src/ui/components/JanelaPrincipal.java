package ui.components;

import ui.components.panels.PainelDireito;
import ui.components.panels.PainelEsquerdo;
import ui.components.table.TabelaAlunos;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame implements Componente {

    /** Cria a janela principal do programa com os parâmetros pré definidos**/
    public JanelaPrincipal() {
        // Informações gerais
        setTitle("Sistema ESTUDANTES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tamanho e layout
        setMinimumSize(new Dimension(800, 600));
        setLayout(new GridLayout(1, 2));

        // Construir filhos
        construirFilhos();

        // Mostrar na tela
        setVisible(true);
    }

    public void construirFilhos() {
        // Instância compartilhada da  tabela de alunos
        TabelaAlunos tabelaAlunos = new TabelaAlunos();

        // Painel Esquerdo
        JPanel painelEsquerdo = new PainelEsquerdo(tabelaAlunos);
        JScrollPane scrollEsquerdo = new JScrollPane(painelEsquerdo);
        scrollEsquerdo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Painel Direito
        JPanel painelDireito = new PainelDireito(tabelaAlunos);
        JScrollPane scrollDireito = new JScrollPane(painelDireito);
        scrollDireito.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Layout
        setLayout(new GridLayout(1, 2));
        add(scrollEsquerdo);
        add(scrollDireito);
    }

}
