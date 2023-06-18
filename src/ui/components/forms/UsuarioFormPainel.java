package ui.components.forms;

import model.EstudanteModel;
import repositories.EstudanteRepository;
import ui.components.Componente;

import javax.swing.*;
import java.awt.*;

public class UsuarioFormPainel extends JPanel implements Componente {

    /**
     * Constroi o formulário com os campos específicos
     **/
    public UsuarioFormPainel() {
        // Tamanho e layout

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        // Elementos filhos
        construirFilhos();

    }

    @Override
    public void construirFilhos() {
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
        constroiCampoSenha();

        // Curso
        constroiCampoCurso();

        // Observações
        constroiCampoObservacoes();

        // Ativo
        constroiCampoAtivo();

        // Botão para cadastrar
        constroiBotaoCadastrar();
    }

    /**
     * Dimensões e espaçamentos padrões dos campos do formulário
     **/
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

        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createCompoundBorder(campo.getBorder(),

                // Espaçamento interno do campo do formulário
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campo, getDefaultConstraints());
    }

    private void constroiCampoSenha() {
        add(new JLabel("Senha: "), getDefaultConstraints());
        JPasswordField campoSenha = new JPasswordField();

        campoSenha.setBorder(BorderFactory.createCompoundBorder(campoSenha.getBorder(),

                // Espaçamento interno do campo do formulário
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campoSenha, getDefaultConstraints());
    }

    private void constroiCampoCurso() {
        add(new JLabel("Curso: "), getDefaultConstraints());
        JComboBox<String> cursoBox = new JComboBox<>(new String[]{"Curso 1", "Curso 2", "Curso 3"});
        add(cursoBox, getDefaultConstraints());
    }

    private void constroiCampoObservacoes() {
        add(new JLabel("Observações: "), getDefaultConstraints());
        JTextArea observacoesArea = new JTextArea();
        observacoesArea.setBorder(BorderFactory.createCompoundBorder(observacoesArea.getBorder(),

                // Espaçamento interno do campo do formulário
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        add(observacoesArea, getDefaultConstraints());
    }

    private void constroiCampoAtivo() {
        add(new JLabel("Ativo: "), getDefaultConstraints());
        JRadioButton simButton = new JRadioButton("Sim");
        JRadioButton naoButton = new JRadioButton("Não");
        ButtonGroup group = new ButtonGroup();

        group.add(simButton);
        group.add(naoButton);

        add(simButton, getDefaultConstraints());
        add(naoButton, getDefaultConstraints());
    }

    private void constroiBotaoCadastrar() {
        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> {
            EstudanteModel novoEstudante = new EstudanteModel();

            // Configure o novoEstudante com os dados do formulário...
            // Por exemplo: novoEstudante.setNomeCompleto(campoNomeCompleto.getText());

            new EstudanteRepository().insert(novoEstudante);
        });

        add(cadastrarButton, getDefaultConstraints());
    }


}
