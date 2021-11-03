import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Calc implements ActionListener {

    private JFrame janela;
    private JPanel painelEntrada;
    private JPanel painelBotao;

    private JLabel titulo;
    private JLabel num1;
    private JLabel num2;

    private JTextField ent1;
    private JTextField ent2;

    private JButton somar;
    private JButton sub;
    private JButton div;
    private JButton multi;

    private JLabel resultado;

    
    public Calc () {
        janela = new JFrame("Semana 9 - Calculadora");
        GridLayout layoutGeral = new GridLayout(4, 1);
        layoutGeral.setVgap(50);
        layoutGeral.setHgap(0);
        janela.setLayout(layoutGeral);

        painelEntrada= new JPanel();
        GridLayout layoutEntrada = new GridLayout(2, 2);
        layoutEntrada.setVgap(0);
        layoutEntrada.setHgap(0);
        painelEntrada.setLayout(layoutEntrada);

        painelBotao = new JPanel();
        GridLayout layoutButao = new GridLayout(1, 4);
        layoutButao.setVgap(0);
        layoutButao.setHgap(10);
        painelBotao.setLayout(layoutButao);
        


        titulo = new JLabel("Calculadora");
        titulo.setFont(new Font ("Verdana", Font.BOLD, 24));

        num1 = new JLabel("Primeiro número: ");
        num2 = new JLabel("Segundo número: ");
        ent1 = new JTextField();
        ent2 = new JTextField();

        somar = new JButton("Somar");
        somar.addActionListener(this);
        sub = new JButton("Subtrair");
        sub.addActionListener(this);
        div = new JButton("Dividir");
        div.addActionListener(this);
        multi = new JButton("Multiplicar");
        multi.addActionListener(this);

        resultado = new JLabel("Resultado = ");
        

        painelEntrada.add(num1);
        painelEntrada.add(ent1);
        painelEntrada.add(num2);
        painelEntrada.add(ent2);
        painelBotao.add(somar);
        painelBotao.add(sub);
        painelBotao.add(div);
        painelBotao.add(multi);


        titulo.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        janela.add(titulo, BorderLayout.NORTH);
        janela.add(painelEntrada, BorderLayout.WEST);
        janela.add(painelBotao, BorderLayout.CENTER);
        janela.add(resultado, BorderLayout.WEST);

        janela.setSize(400, 400);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Integer val1 = Integer.parseInt(ent1.getText());
            Integer val2 = Integer.parseInt(ent2.getText());

            if (evento.getSource() == somar) {
                resultado.setText("Resultado = " + (val1 + val2));
            } else if (evento.getSource() == sub) {
                resultado.setText("Resultado = " + (val1 - val2));
            } else if (evento.getSource() == div) {
                resultado.setText("Resultado = " + (val1 / val2));
            } else {
                resultado.setText("Resultado = " + (val1 * val2));
            }
            
            resultado.setForeground(Color.BLACK);
        } catch (NumberFormatException e) {
            resultado.setText("***Erro** Entre apeans com números!");
            resultado.setForeground(Color.RED);
        } catch (Exception e) {
            System.err.println("Erro não identificado" + e.getMessage());
        }
    }

    public static void main (String[] args) {
        new Calc();
    }
}