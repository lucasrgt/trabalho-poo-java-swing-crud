import ui.GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Construir a interface gráfica do sistema
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI.construir();
            }
        });
    }
}