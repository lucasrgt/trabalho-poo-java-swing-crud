package ui.components.panels;

import ui.components.Componente;
import ui.components.table.TabelaAlunos;

import javax.swing.*;
import java.awt.*;

public class PainelDireito extends JPanel implements Componente {

    TabelaAlunos tabelaAlunos;

    public PainelDireito(TabelaAlunos tabelaAlunos) {
        this.tabelaAlunos = tabelaAlunos;
        setBackground(new Color(229, 237, 245));
        setLayout(new BorderLayout());
        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        // Adiciona a tabela dos alunos
        add(tabelaAlunos, BorderLayout.CENTER);
    }
}
