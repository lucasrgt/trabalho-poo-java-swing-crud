package ui.components.panels;

import ui.components.Componente;
import ui.components.table.TabelaAlunos;

import javax.swing.*;
import java.awt.*;

public class PainelDireito extends JPanel implements Componente {

    public PainelDireito() {
        setBackground(new Color(229, 237, 245));
        setLayout(new BorderLayout());
        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        // Adiciona a tabela dos alunos
        JPanel tabelaAlunos = new TabelaAlunos();
        add(tabelaAlunos, BorderLayout.CENTER);
    }
}
