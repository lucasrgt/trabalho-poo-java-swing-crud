package ui.components.forms;

import model.EstudanteModel;
import repositories.EstudanteRepository;
import ui.components.Componente;
import ui.components.table.TabelaAlunos;

import javax.swing.*;
import java.awt.*;

public class UsuarioFormPainel extends JPanel implements Componente {
    public JTextField campoNomeCompleto;
    public JTextField campoIdadeMatricula;
    public JTextField campoEmail;
    public JTextField campoEndereco;
    public JTextField campoCEP;
    public JTextField campoTelefone;
    public JTextField campoUsuario;
    public JPasswordField campoSenha;
    public JComboBox<String> campoCurso;
    public JTextArea campoObservacoes;
    public JRadioButton campoAtivo;
    private TabelaAlunos tabelaAlunos;

    public UsuarioFormPainel(TabelaAlunos tabelaAlunos) {
        this.tabelaAlunos = tabelaAlunos;
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        campoNomeCompleto = constroiCampoFormulario("Nome completo");
        campoIdadeMatricula = constroiCampoFormulario("Idade na matrícula");
        campoEmail = constroiCampoFormulario("E-mail");
        campoEndereco = constroiCampoFormulario("Endereço");
        campoCEP = constroiCampoFormulario("CEP");
        campoTelefone = constroiCampoFormulario("Telefone");
        campoUsuario = constroiCampoFormulario("Usuário");
        campoSenha = constroiCampoSenha();
        campoCurso = constroiCampoCurso();
        campoObservacoes = constroiCampoObservacoes();
        campoAtivo = constroiCampoAtivo();

        constroiBotaoCadastrar();
    }

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

    private JTextField constroiCampoFormulario(String nome) {
        add(new JLabel(nome + ": "), getDefaultConstraints());

        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createCompoundBorder(campo.getBorder(),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campo, getDefaultConstraints());
        return campo;
    }

    private JPasswordField constroiCampoSenha() {
        add(new JLabel("Senha: "), getDefaultConstraints());
        JPasswordField campoSenha = new JPasswordField();

        campoSenha.setBorder(BorderFactory.createCompoundBorder(campoSenha.getBorder(),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campoSenha, getDefaultConstraints());
        return campoSenha;
    }

    private JComboBox<String> constroiCampoCurso() {
        add(new JLabel("Curso: "), getDefaultConstraints());
        JComboBox<String> cursoBox = new JComboBox<>(new String[]{"Curso 1", "Curso 2", "Curso 3"});
        add(cursoBox, getDefaultConstraints());
        return cursoBox;
    }

    private JTextArea constroiCampoObservacoes() {
        add(new JLabel("Observações: "), getDefaultConstraints());
        JTextArea observacoesArea = new JTextArea();
        observacoesArea.setBorder(BorderFactory.createCompoundBorder(observacoesArea.getBorder(),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        add(observacoesArea, getDefaultConstraints());
        return observacoesArea;
    }

    private JRadioButton constroiCampoAtivo() {
        add(new JLabel("Ativo: "), getDefaultConstraints());
        JRadioButton simButton = new JRadioButton("Sim");
        JRadioButton naoButton = new JRadioButton("Não");
        ButtonGroup group = new ButtonGroup();

        group.add(simButton);
        group.add(naoButton);

        add(simButton, getDefaultConstraints());
        add(naoButton, getDefaultConstraints());
        return simButton;
    }

    private void constroiBotaoCadastrar() {
        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> {
            EstudanteModel novoEstudante = new EstudanteModel();

            novoEstudante.setNomeCompleto(campoNomeCompleto.getText());
            novoEstudante.setAnoMatricula(campoIdadeMatricula.getText());
            novoEstudante.setEmail(campoEmail.getText());
            novoEstudante.setEndereco(campoEndereco.getText());
            novoEstudante.setCEP(campoCEP.getText());
            novoEstudante.setTelefone(campoTelefone.getText());
            novoEstudante.setUsuario(campoUsuario.getText());
            novoEstudante.setSenha(new String(campoSenha.getPassword()));
            novoEstudante.setCurso(campoCurso.getSelectedItem().toString());
            novoEstudante.setObservacoes(campoObservacoes.getText());
            novoEstudante.setAtivo(campoAtivo.isSelected());

            new EstudanteRepository().insert(novoEstudante);
            tabelaAlunos.atualizaTabela();

        });

        add(cadastrarButton, getDefaultConstraints());
    }
}
