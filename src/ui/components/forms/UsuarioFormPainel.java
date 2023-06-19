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
    public JRadioButton campoInativo;
    private TabelaAlunos tabelaAlunos;

    // ButtonGroup declarado fora dos métodos
    ButtonGroup group = new ButtonGroup();

    public UsuarioFormPainel(TabelaAlunos tabelaAlunos) {
        this.tabelaAlunos = tabelaAlunos;
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        construirFilhos();
    }

    @Override
    public void construirFilhos() {
        campoNomeCompleto = constroiCampoFormulario("Nome completo *");
        campoIdadeMatricula = constroiCampoFormulario("Idade na matrícula *");
        campoEmail = constroiCampoFormulario("E-mail *");
        campoEndereco = constroiCampoFormulario("Endereço *");
        campoCEP = constroiCampoFormulario("CEP");
        campoTelefone = constroiCampoFormulario("Telefone");
        campoUsuario = constroiCampoFormulario("Usuário *");
        campoSenha = constroiCampoSenha();
        campoCurso = constroiCampoCurso();
        campoObservacoes = constroiCampoObservacoes();
        campoAtivo = constroiCampoAtivo();
        campoInativo = constroiCampoInativo();

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
        add(new JLabel(nome), getDefaultConstraints());

        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createCompoundBorder(campo.getBorder(), BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campo, getDefaultConstraints());
        return campo;
    }

    private JPasswordField constroiCampoSenha() {
        add(new JLabel("Senha *"), getDefaultConstraints());
        JPasswordField campoSenha = new JPasswordField();

        campoSenha.setBorder(BorderFactory.createCompoundBorder(campoSenha.getBorder(), BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        add(campoSenha, getDefaultConstraints());
        return campoSenha;
    }

    private JComboBox<String> constroiCampoCurso() {
        add(new JLabel("Curso *"), getDefaultConstraints());
        JComboBox<String> cursoBox = new JComboBox<>(new String[]{"Curso 1", "Curso 2", "Curso 3"});
        add(cursoBox, getDefaultConstraints());
        return cursoBox;
    }

    private JTextArea constroiCampoObservacoes() {
        add(new JLabel("Observações"), getDefaultConstraints());
        JTextArea observacoesArea = new JTextArea();
        observacoesArea.setBorder(BorderFactory.createCompoundBorder(observacoesArea.getBorder(), BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        add(observacoesArea, getDefaultConstraints());
        return observacoesArea;
    }

    private JRadioButton constroiCampoAtivo() {
        add(new JLabel("Ativo *"), getDefaultConstraints());
        JRadioButton simButton = new JRadioButton("Sim");

        group.add(simButton);

        add(simButton, getDefaultConstraints());
        return simButton;
    }

    private JRadioButton constroiCampoInativo() {
        JRadioButton naoButton = new JRadioButton("Não");

        group.add(naoButton);

        add(naoButton, getDefaultConstraints());
        return naoButton;
    }

    private void constroiBotaoCadastrar() {
        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> {
            EstudanteModel novoEstudante = new EstudanteModel();

            try {
                novoEstudante.setNomeCompleto(campoNomeCompleto.getText());
                if (campoNomeCompleto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome completo é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    novoEstudante.setAnoMatricula(Integer.parseInt(campoIdadeMatricula.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ano de matrícula inválido. Por favor, insira um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setEmail(campoEmail.getText());
                if (campoEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "E-mail é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setEndereco(campoEndereco.getText());
                if (campoEndereco.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Endereço é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setCEP(campoCEP.getText());
                novoEstudante.setTelefone(campoTelefone.getText());

                novoEstudante.setUsuario(campoUsuario.getText());
                if (campoUsuario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuário é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setSenha(new String(campoSenha.getPassword()));
                if (new String(campoSenha.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Senha é obrigatória", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setCurso(campoCurso.getSelectedItem().toString());
                if (campoCurso.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Curso é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setObservacoes(campoObservacoes.getText());

                if (!(campoAtivo.isSelected() || campoInativo.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Status de ativação é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                novoEstudante.setAtivo(campoAtivo.isSelected());

                new EstudanteRepository().insert(novoEstudante);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir aluno: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tabelaAlunos.atualizaTabela();
        });

        add(cadastrarButton, getDefaultConstraints());
    }
}
