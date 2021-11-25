import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import model.Aluno;
import controller.AlunoController;

public class Interface implements ActionListener, MouseListener {

    private JFrame janela;
    
    private JPanel botaoPanel;
    private JPanel textoPanel;
    private JPanel entradaPanel;

    private JTable tabela;
    private DefaultTableModel model;

    // Botões para selecionar a operação
    private JButton insert;
    private JButton select;
    private JButton update;
    private JButton delete;
    private JButton clear;
    private JLabel autor;

    // Labels e TextFields para insert
    private JLabel ins1;
    private JLabel ins2;
    private JLabel ins3;
    private JTextField insMat;
    private JTextField insNom;
    private JTextField insTel;
    AlunoController controller = new AlunoController();

    
    private DefaultTableModel puxarTable() {
        DefaultTableModel temp = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "Matrícula";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Telefone";

        temp.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];

        for (Aluno aluno:controller.readAll()) {
            rowData[0] = aluno.getMatricula();
            rowData[1] = aluno.getNome();
            rowData[2] = aluno.getTelefone();
            temp.addRow(rowData);
        }

        return temp;
    }

    private DefaultTableModel selectTable(Aluno al) {
        DefaultTableModel temp = new DefaultTableModel();
        Object[] nomeColuna = new Object[3];
        nomeColuna[0] = "Matrícula";      
        nomeColuna[1] = "Nome";
        nomeColuna[2] = "Telefone";

        temp.setColumnIdentifiers(nomeColuna);

        Object[] rowData = new Object[3];

        for (Aluno aluno:controller.select(al)) {
            rowData[0] = aluno.getMatricula();
            rowData[1] = aluno.getNome();
            rowData[2] = aluno.getTelefone();
            temp.addRow(rowData);
        }

        return temp;
    }



    public Interface () {
        janela = new JFrame("Semana 11 - CRUD");
        GridLayout layoutGeral = new GridLayout(1, 2);
        layoutGeral.setVgap(0);
        layoutGeral.setHgap(0);
        janela.setLayout(layoutGeral);


        // Criar tabela
        tabela = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
             }
        };

        tabela.addMouseListener(this);
        tabela.setModel(puxarTable());
        JScrollPane lista = new JScrollPane(tabela);


        // Criar entrada botões
        entradaPanel = new JPanel();
        GridLayout layoutEntrada = new GridLayout(2, 1);
        layoutEntrada.setVgap(50);
        layoutEntrada.setHgap(0);
        entradaPanel.setLayout(layoutEntrada);


        // Entradas de texto
        ins1 = new JLabel("Matrícula:");
        ins2 = new JLabel("Nome:");
        ins3 = new JLabel("Telefone:");
        insMat = new JTextField();
        insNom = new JTextField();
        insTel = new JTextField();
        textoPanel = new JPanel();

        GridLayout layoutTexto = new GridLayout(3, 2);
        layoutTexto.setVgap(10);
        layoutTexto.setHgap(0);
        textoPanel.setLayout(layoutTexto);
        textoPanel.add(ins1);
        textoPanel.add(insMat);
        textoPanel.add(ins2);
        textoPanel.add(insNom);
        textoPanel.add(ins3);
        textoPanel.add(insTel);

        // Botões
        insert = new JButton("Insert");
        insert.addActionListener(this);
        select = new JButton("Select");
        select.addActionListener(this);
        update = new JButton("Update");
        update.addActionListener(this);
        delete = new JButton("Delete");
        delete.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        autor = new JLabel("<html>Feito por<br/> Salim Bou-Issa</html>");
        botaoPanel = new JPanel();
        GridLayout layoutBotao = new GridLayout(3, 2);
        layoutBotao.setVgap(25);
        layoutBotao.setHgap(25);
        botaoPanel.setLayout(layoutBotao);
        botaoPanel.add(insert);
        botaoPanel.add(select);
        botaoPanel.add(update);
        botaoPanel.add(delete);
        botaoPanel.add(autor);
        botaoPanel.add(clear);

        entradaPanel.add(textoPanel);
        entradaPanel.add(botaoPanel);

        // Adicionar ao Frame
        janela.add(lista);
        janela.add(entradaPanel);
        janela.setSize(500, 500);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            if (evento.getSource() == insert) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(insMat.getText());
                aluno.setNome(insNom.getText());
                aluno.setTelefone(insTel.getText());
                controller.create(aluno);
                model = puxarTable();
                tabela.setModel(model);
            } else if (evento.getSource() == select) {
                Aluno aluno = new Aluno();
                if (insMat.getText().isEmpty()) {
                    aluno.setMatricula("");
                } else {
                    aluno.setMatricula(insMat.getText());
                }
                if (insNom.getText().isEmpty()) {
                    aluno.setNome("");
                } else {
                    aluno.setNome(insNom.getText());
                }
                if (insTel.getText().isEmpty()) {
                    aluno.setTelefone("");
                } else {
                    aluno.setTelefone(insTel.getText());
                }
                tabela.setModel(selectTable(aluno));
            } else if (evento.getSource() == update) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(insMat.getText());
                aluno.setNome(insNom.getText());
                aluno.setTelefone(insTel.getText());
                controller.update(aluno);
                model = puxarTable();
                tabela.setModel(model);
            } else if (evento.getSource() == delete){
                Aluno aluno = new Aluno();
                aluno.setMatricula(insMat.getText());
                aluno.setNome(insNom.getText());
                aluno.setTelefone(insTel.getText());
                controller.delete(aluno);
                model = puxarTable();
                tabela.setModel(model);;
            } else {
                model = puxarTable();
                tabela.setModel(model);
            }
           
        } catch (Exception e) {
            System.err.println("Erro não identificado" + e.getMessage());
        }

    }

    public static void main (String[] args) {
        new Interface();
    }

    // Listener para pegar os valores da tabela
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        insMat.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        insNom.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        insTel.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        
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