package main;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Jogo;
import controller.JogoController;

import model.Desenvolvedora;
import controller.DesenvolvedoraController;

import model.Publicadora;
import controller.PublicadoraController;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
 

public class Login implements ActionListener, MouseListener {

    // Atributos para a tela de login
    private JFrame login;
    
    private JLabel usuario;
    private JLabel senha;

    private JTextField entUsuario;
    private JPasswordField entSenha;

    private JButton confLogin;

    private char[] senhaCerta = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

    // Atributos para a tela com as informações
    private JFrame janela;

    private GridBagConstraints c;

    private JLabel botaoDev;
    private JLabel botaoPubli;
    private JLabel botaoJogos;
    private Integer tela;

    private JButton botaoInsert;
    private JButton botaoSelect;
    private JButton botaoUpdate;
    private JButton botaoDelete;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    private JTextField ent1;
    private JTextField ent2;
    private JTextField ent3;

    private JComboBox<String> listDev;
    private JComboBox<String> listPubli;

    private JTable tabela;

    private DefaultTableModel modelDev;
    private DefaultTableModel modelPubli;
    private DefaultTableModel modelJogo;
    
    private void verificarSenha() {
        if (entUsuario.getText().toString().equals("admin") && Arrays.equals(entSenha.getPassword(), senhaCerta)) {
            tela();
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Login inválido");
        }
    }

    public Login () {
        login = new JFrame("Tela de Login");

        login.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        usuario = new JLabel("Usuário: ");
        c.insets = new Insets(0, 10, 0, 10);
        usuario.setPreferredSize(new Dimension(80, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        login.add(usuario, c);

        senha = new JLabel("Senha");
        senha.setPreferredSize(new Dimension(80, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        login.add(senha, c);

        entUsuario = new JTextField();
        entUsuario.setPreferredSize(new Dimension(150, 25));
        entUsuario.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                   verificarSenha();
                   }
                }
        });
        c.insets = new Insets(0, 0, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        login.add(entUsuario, c);

        entSenha = new JPasswordField();
        entSenha.setPreferredSize(new Dimension(150, 25));
        entSenha.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                   verificarSenha();
                   }
                }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        login.add(entSenha, c);

        confLogin = new JButton("Login");
        confLogin.setPreferredSize(new Dimension(50, 20));
        c.insets = new Insets(0, 40, 0, 20);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        login.add(confLogin, c);

        confLogin.addActionListener(this);

        login.pack();

        login.setSize(300, 200);
        login.setVisible(true);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // Puxar informações das tabelas
    private DefaultTableModel puxarDevs () {
        DesenvolvedoraController controller = new DesenvolvedoraController();
        DefaultTableModel info = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Local";

        info.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];

        listDev.removeAllItems();
        listDev.addItem("");

        for (Desenvolvedora dev:controller.readAll()) {
            rowData[0] = dev.getId();
            rowData[1] = dev.getNome();
            rowData[2] = dev.getLocal();
            listDev.addItem(dev.getNome());
            info.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");
        
        return info;
    }

    private DefaultTableModel puxarPubli () {
        PublicadoraController controller = new PublicadoraController();
        DefaultTableModel info = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Local";

        info.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];
        
        listPubli.removeAllItems();
        listPubli.addItem("");

        for (Publicadora publi:controller.readAll()) {
            rowData[0] = publi.getId();
            rowData[1] = publi.getNome();
            rowData[2] = publi.getLocal();
            listPubli.addItem(publi.getNome());
            info.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");

        return info;
    }

    private DefaultTableModel puxarJogos () {
        JogoController controller = new JogoController();
        DefaultTableModel info = new DefaultTableModel();
        Object[] nomeColuna = new Object[5];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Gênero";
        nomeColuna[3] = "Desenvolvedora";
        nomeColuna[4] = "Publicadora";

        info.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[5];

        for (Jogo jogo:controller.readAllNome()) {
            rowData[0] = jogo.getId();
            rowData[1] = jogo.getNome();
            rowData[2] = jogo.getGenero();
            rowData[3] = jogo.getId_dev();
            rowData[4] = jogo.getId_publi();
            info.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");

        listDev.setSelectedItem("");
        listPubli.setSelectedItem("");

        return info;
    }

    // Puxar Tabelas com Select
    private DefaultTableModel selectTableDev (Desenvolvedora de) {
        DesenvolvedoraController controller = new DesenvolvedoraController();
        DefaultTableModel temp = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Local";

        temp.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];

        for (Desenvolvedora dev:controller.select(de)) {
            rowData[0] = dev.getId();
            rowData[1] = dev.getNome();
            rowData[2] = dev.getLocal();
            temp.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");

        return temp;
    }

    private DefaultTableModel selectTablePubli (Publicadora pub) {
        PublicadoraController controller = new PublicadoraController();
        DefaultTableModel temp = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Local";

        temp.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];

        for (Publicadora publi:controller.select(pub)) {
            rowData[0] = publi.getId();
            rowData[1] = publi.getNome();
            rowData[2] = publi.getLocal();
            temp.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");

        return temp;
    }

    private DefaultTableModel selectTableJogo (Jogo jog) {
        JogoController controller = new JogoController();
        DefaultTableModel temp = new DefaultTableModel();
        Object[] nomeColuna = new Object[5];
        nomeColuna[0] = "ID";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Gênero";
        nomeColuna[3] = "Desenvolvedora";
        nomeColuna[4] = "Publicadora";

        temp.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[5];

        for (Jogo jogo:controller.selectNome(jog)) {
            rowData[0] = jogo.getId();
            rowData[1] = jogo.getNome();
            rowData[2] = jogo.getGenero();
            rowData[3] = jogo.getId_dev();
            rowData[4] = jogo.getId_publi();
            temp.addRow(rowData);
        }

        ent1.setText("");
        ent2.setText("");
        ent3.setText("");

        listDev.setSelectedItem("");
        listPubli.setSelectedItem("");

        return temp;
    }

    private void tela() {
        tela = 1;
        janela = new JFrame("Banco de Dados de Jogos");
        janela.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
    

        // Botões para escolher a tabela
        botaoDev = new JLabel("Desenvolvedora", SwingConstants.CENTER);
        botaoDev.setPreferredSize(new Dimension(100, 40));
        botaoDev.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        botaoDev.setBackground(new Color(180, 180, 180));
        botaoDev.setOpaque(true);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        botaoDev.addMouseListener(this);
        janela.add(botaoDev, c);

        botaoPubli = new JLabel("Publicadora", SwingConstants.CENTER);
        botaoPubli.setPreferredSize(new Dimension(100, 40));
        botaoPubli.setBorder(BorderFactory.createEtchedBorder());
        botaoPubli.setBackground(new Color(180, 180, 180));
        c.gridx = 1;
        c.gridy = 0;
        botaoPubli.addMouseListener(this);
        janela.add(botaoPubli, c);

        botaoJogos = new JLabel("Jogos", SwingConstants.CENTER);
        botaoJogos.setPreferredSize(new Dimension(100, 40));
        botaoJogos.setBorder(BorderFactory.createEtchedBorder());
        botaoJogos.setBackground(new Color(180, 180, 180));
        c.gridx = 2;
        c.gridy = 0;
        botaoJogos.addMouseListener(this);
        janela.add(botaoJogos, c);


        // Labels
        label1 = new JLabel("ID");
        label1.setPreferredSize(new Dimension(100, 40));
        c.insets = new Insets(0, 10, 0, 0);
        c.ipady = 40;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        janela.add(label1, c);

        label2 = new JLabel("Nome");
        label2.setPreferredSize(new Dimension(100, 40));
        c.gridx = 3;
        c.gridy = 2;
        janela.add(label2, c);

        label3 = new JLabel("Local");
        label3.setPreferredSize(new Dimension(100, 40));
        c.gridx = 3;
        c.gridy = 3;
        janela.add(label3, c);

        label4 = new JLabel("Desenvolvedora");
        label4.setPreferredSize(new Dimension(100, 40));
        c.gridx = 3;
        c.gridy = 4;
        janela.add(label4, c);
        label4.setVisible(false);

        label5 = new JLabel("Publicadora");
        label5.setPreferredSize(new Dimension(100, 40));
        c.gridx = 3;
        c.gridy = 5;
        janela.add(label5, c);
        label5.setVisible(false);


        // Entradas de Texto
        ent1 = new JTextField();
        ent1.setPreferredSize(new Dimension(150, 0));
        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 40;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 1;
        janela.add(ent1, c);

        ent2 = new JTextField();
        ent2.setPreferredSize(new Dimension(150, 0));
        c.gridx = 4;
        c.gridy = 2;
        janela.add(ent2, c);

        ent3 = new JTextField();
        ent3.setPreferredSize(new Dimension(150, 0));
        c.gridx = 4;
        c.gridy = 3;
        janela.add(ent3, c);

        listDev = new JComboBox<>();
        listDev.setPreferredSize(new Dimension(150, 0));
        c.gridx = 4;
        c.gridy = 4;
        janela.add(listDev, c);
        listDev.setVisible(false);

        listPubli = new JComboBox<>();
        listPubli.setPreferredSize(new Dimension(150, 0));
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 5;
        janela.add(listPubli, c);
        listPubli.setVisible(false);


        // Tabela
        tabela = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        tabela.addMouseListener(this);
        
        // Pré carregar as tabelas
        modelDev = puxarDevs();
        modelPubli = puxarPubli();
        modelJogo = puxarJogos();

        tabela.setModel(modelDev);

        JScrollPane lista = new JScrollPane(tabela);
        c.ipadx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.5;
        c.gridwidth = 3;
        c.gridheight = 5;
        c.gridx = 0;
        c.gridy = 1;
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        janela.add(lista, c);
    

        // Botões de Operações
        botaoInsert = new JButton("Insert");
        botaoInsert.setPreferredSize(new Dimension(60, 30));
        botaoInsert.setMargin(new Insets(0, 0, 0, 0));
        c.ipady = 0;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5, 30, 5, 30);
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 6;
        botaoInsert.addActionListener(this);
        janela.add(botaoInsert, c);
    
        botaoSelect = new JButton("Select");
        botaoSelect.setMargin(new Insets(0, 0, 0, 0));
        botaoSelect.setPreferredSize(new Dimension(60, 30));
        c.gridx = 4;
        c.gridy = 6;
        botaoSelect.addActionListener(this);
        janela.add(botaoSelect, c);
    
        botaoUpdate = new JButton("Update");
        botaoUpdate.setPreferredSize(new Dimension(60, 30));
        botaoUpdate.setMargin(new Insets(0, 0, 0, 0));
        c.gridx = 3;
        c.gridy = 7;
        botaoUpdate.addActionListener(this);
        janela.add(botaoUpdate, c);

        botaoDelete = new JButton("Delete");
        botaoDelete.setMargin(new Insets(0, 0, 0, 0));
        botaoDelete.setPreferredSize(new Dimension(60, 30));
        c.gridx = 4;
        c.gridy = 7;
        botaoDelete.addActionListener(this);
        janela.add(botaoDelete, c);

        janela.pack();
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private Desenvolvedora getDev () {
        Desenvolvedora dev = new Desenvolvedora();
        dev.setId(ent1.getText());
        dev.setNome(ent2.getText());
        dev.setLocal(ent3.getText());

        return dev;
    }

    private Publicadora getPubli () {
        Publicadora publi = new Publicadora();
        publi.setId(ent1.getText());
        publi.setNome(ent2.getText());
        publi.setLocal(ent3.getText());

        return publi;
    }

    private Jogo getJogo () {
        JogoController controller = new JogoController();
        Jogo jogo = new Jogo();
        jogo.setId(ent1.getText());
        jogo.setNome(ent2.getText());
        jogo.setGenero(ent3.getText());
        jogo.setId_dev(controller.getDevId(listDev.getSelectedItem().toString()));
        jogo.setId_publi(controller.getPubliId(listPubli.getSelectedItem().toString()));

        return jogo;
    }

    private void setTabela () {
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);;
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == confLogin) {
            verificarSenha();
        } else {
            try {
                if (tela == 1) {;
                    DesenvolvedoraController controller = new DesenvolvedoraController();
                    Desenvolvedora dev = new Desenvolvedora();
                    if (evento.getSource() == botaoInsert) {
                        dev = getDev();
                        controller.create(dev);
                        modelDev = puxarDevs();
                        tabela.setModel(modelDev);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);

                    } else if (evento.getSource() == botaoSelect) {
                        if (ent1.getText().isEmpty()) {
                            dev.setId("");
                        } else {
                            dev.setId(ent1.getText());
                        }
                        if (ent2.getText().isEmpty()) {
                            dev.setNome("");
                        } else {
                            dev.setNome(ent2.getText());
                        }
                        if (ent3.getText().isEmpty()) {
                            dev.setLocal("");
                        } else {
                            dev.setLocal(ent3.getText());
                        }
                        tabela.setModel(selectTableDev(dev));
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    } else if (evento.getSource() == botaoUpdate) {
                        dev = getDev();
                        controller.update(dev);
                        modelDev = puxarDevs();
                        tabela.setModel(modelDev);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    } else if (evento.getSource() == botaoDelete) {
                        dev = getDev();
                        controller.delete(dev);
                        modelDev = puxarDevs();
                        tabela.setModel(modelDev);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    }
                } else if (tela == 2) {
                    PublicadoraController controller = new PublicadoraController();
                    Publicadora publi = new Publicadora();
                    if (evento.getSource() == botaoInsert) {
                        publi = getPubli();
                        controller.create(publi);
                        modelPubli = puxarPubli();
                        tabela.setModel(modelPubli);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    } else if (evento.getSource() == botaoSelect) {
                        if (ent1.getText().isEmpty()) {
                            publi.setId("");
                        } else {
                            publi.setId(ent1.getText());
                        }
                        if (ent2.getText().isEmpty()) {
                            publi.setNome("");
                        } else {
                            publi.setNome(ent2.getText());
                        }
                        if (ent3.getText().isEmpty()) {
                            publi.setLocal("");
                        } else {
                            publi.setLocal(ent3.getText());
                        }
                        if (publi.getId() == "" && publi.getNome() == "" && publi.getLocal() == "") {
                            tabela.setModel(modelPubli);
                        } else {
                            tabela.setModel(selectTablePubli(publi));
                        }
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    } else if (evento.getSource() == botaoUpdate) {
                        publi = getPubli();
                        controller.update(publi);
                        modelPubli = puxarPubli();
                        tabela.setModel(modelPubli);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    } else if (evento.getSource() == botaoDelete) {
                        publi = getPubli();
                        controller.delete(publi);
                        modelPubli = puxarPubli();
                        tabela.setModel(modelPubli);
                        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
                    }
                } else if (tela == 3) {
                    JogoController controller = new JogoController();
                    Jogo jogo = new Jogo();
                    if (evento.getSource() == botaoInsert) {
                        jogo = getJogo();
                        controller.create(jogo);
                        modelJogo = puxarJogos();
                        tabela.setModel(modelJogo);
                        setTabela(); 
                    } else if (evento.getSource() == botaoSelect) {
                        if (ent1.getText().isEmpty()) {
                            jogo.setId("");
                        } else {
                            jogo.setId(ent1.getText());
                        }
                        if (ent2.getText().isEmpty()) {
                            jogo.setNome("");
                        } else {
                            jogo.setNome(ent2.getText());
                        }
                        if (ent3.getText().isEmpty()) {
                            jogo.setGenero("");
                        } else {
                            jogo.setGenero(ent3.getText());
                        }
                        if (listDev.getSelectedItem() == "") {
                            jogo.setId_dev("");
                        } else {
                            jogo.setId_dev(controller.getDevId(listDev.getSelectedItem().toString()));
                        }
                        if (listPubli.getSelectedItem() == "") {
                            jogo.setId_publi("");
                        } else {
                            jogo.setId_publi(controller.getPubliId(listPubli.getSelectedItem().toString()));
                        }
                        if (jogo.getId() == "" && jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                            tabela.setModel(modelJogo);
                        } else {
                            tabela.setModel(selectTableJogo(jogo));
                        }
                        setTabela();
                    } else if (evento.getSource() == botaoUpdate) {
                        jogo = getJogo();
                        controller.update(jogo);
                        modelJogo = puxarJogos();
                        tabela.setModel(modelJogo);
                        setTabela();
                    } else if (evento.getSource() == botaoDelete) {
                        jogo = getJogo();
                        controller.delete(jogo);
                        modelJogo = puxarJogos();
                        tabela.setModel(modelJogo);
                        setTabela();
                    }
                }
            } catch(Exception e) {
                System.err.println("Erro não identificado" + e.getMessage());
            }
        }  
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getSource() == botaoDev && tela != 1) {
            botaoDev.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
            botaoDev.setOpaque(true);
            botaoPubli.setBorder(BorderFactory.createEtchedBorder());
            botaoPubli.setOpaque(false);
            botaoJogos.setBorder(BorderFactory.createEtchedBorder());
            botaoJogos.setOpaque(false);
            tabela.setModel(modelDev);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
            label3.setText("Local");
            if (tela == 3) {
                label4.setVisible(false);
                label5.setVisible(false);
                listDev.setVisible(false);
                listPubli.setVisible(false);
            }
            tela = 1;
            ent1.setText("");
            ent2.setText("");
            ent3.setText("");

        } else if (e.getSource() == botaoPubli && tela != 2) {
            botaoPubli.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
            botaoPubli.setOpaque(true);
            botaoDev.setBorder(BorderFactory.createEtchedBorder());
            botaoDev.setOpaque(false);
            botaoJogos.setBorder(BorderFactory.createEtchedBorder());
            botaoJogos.setOpaque(false);
            tabela.setModel(modelPubli);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
            label3.setText("Local");
            if (tela == 3) {
                label4.setVisible(false);
                label5.setVisible(false);
                listDev.setVisible(false);
                listPubli.setVisible(false);
            }
            tela = 2;

        } else if (e.getSource() == botaoJogos && tela != 3) {
            botaoJogos.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
            botaoJogos.setOpaque(true);
            botaoDev.setBorder(BorderFactory.createEtchedBorder());
            botaoDev.setOpaque(false);
            botaoPubli.setBorder(BorderFactory.createEtchedBorder());
            botaoPubli.setOpaque(false);
            tabela.setModel(modelJogo);
            setTabela();
            label3.setText("Gênero");
            label4.setVisible(true);
            label5.setVisible(true);
            listDev.setVisible(true);
            listPubli.setVisible(true);
            tela = 3;
            ent1.setText("");
            ent2.setText("");
            ent3.setText("");

        } else if (e.getSource() == tabela) {
            ent1.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            ent2.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            ent3.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            if (tela == 3) {
               listDev.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
               listPubli.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            }
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {} 
    
}