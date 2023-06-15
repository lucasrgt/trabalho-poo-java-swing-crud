package ui.components;

import ui.components.panels.PainelDireito;
import ui.components.panels.PainelEsquerdo;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    /** Cria a janela principal do programa com os parâmetros pré definidos**/
    public JanelaPrincipal() {
        // Informações gerais
        setTitle("Sistema ESTUDANTES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tamanho e layout
        setSize(1600, 900);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        // Construir filhos
        construirFilhos();

        // Mostrar na tela
        setVisible(true);
    }

    private void construirFilhos() {
        getContentPane().add(new PainelEsquerdo(), BorderLayout.CENTER);

        getContentPane().add(new PainelDireito(), BorderLayout.EAST);
    }

}
