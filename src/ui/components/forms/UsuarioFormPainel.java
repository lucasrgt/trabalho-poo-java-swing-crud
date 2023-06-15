package ui.components.forms;

import javax.swing.*;
import java.awt.*;

public class UsuarioFormPainel extends JPanel {



    public UsuarioFormPainel() {
        // Tamanho e layout
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        // Campos do formulário

        // Nome completo
        constroiCampoFormulario("Nome completo");

        // Idade na matrícula
        constroiCampoFormulario("Idade na matrícula");

        // E-mail
        constroiCampoFormulario("E-mail");

        // Endereço
        constroiCampoFormulario("Endereço");

        // CEP
        constroiCampoFormulario("CEP");

        // Telefone
        constroiCampoFormulario("Telefone");

        // Usuário
        constroiCampoFormulario("Usuário");

        // Senha
        add(new JLabel("Senha: "), getDefaultConstraints());
        JPasswordField senhaField = new JPasswordField();
        add(senhaField, getDefaultConstraints());

        // Curso
        add(new JLabel("Curso: "), getDefaultConstraints());
        JComboBox<String> cursoBox = new JComboBox<>(new String[]{"Curso 1", "Curso 2", "Curso 3"});
        add(cursoBox, getDefaultConstraints());

        // Observações
        add(new JLabel("Observações: "), getDefaultConstraints());
        JTextArea observacoesArea = new JTextArea();
        add(observacoesArea, getDefaultConstraints());

        // Ativo
        add(new JLabel("Ativo: "), getDefaultConstraints());
        JRadioButton simButton = new JRadioButton("Sim");
        JRadioButton naoButton = new JRadioButton("Não");
        ButtonGroup group = new ButtonGroup();

        group.add(simButton);
        group.add(naoButton);

        add(simButton, getDefaultConstraints());
        add(naoButton, getDefaultConstraints());

        // Botão para cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");
        add(cadastrarButton, getDefaultConstraints());
    }

    /** Dimensões e espaçamentos padrões dos campos do formulário **/
    private GridBagConstraints getDefaultConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;

        constraints.insets = new Insets(5, 5, 5, 5);

        return constraints;
    }
    private void constroiCampoFormulario(String nome) {
        add(new JLabel(nome + ": "), getDefaultConstraints());
        add(new JTextField(), getDefaultConstraints());
    }
}
