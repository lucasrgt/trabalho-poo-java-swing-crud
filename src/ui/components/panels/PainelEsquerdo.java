package ui.components.panels;

import ui.components.forms.UsuarioFormPainel;

import javax.swing.*;
import java.awt.*;

public class PainelEsquerdo extends JPanel {

    public PainelEsquerdo() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(170, 192, 199)));
        construirFilhos();
    }

    private void construirFilhos() {
        add(new UsuarioFormPainel(), BorderLayout.CENTER);
    }
}
