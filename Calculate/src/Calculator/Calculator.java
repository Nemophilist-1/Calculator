package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JPanel inputarea,choosearea;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0;
    private Button btplus,btminus,btmultiply,btdivide,btsquare,btleftbracket,btrightbracket,btequal,btdot,btback,btclear;
    private JLabel bds,jg;
    private JTextField formula,result;
    Calculate cal;
    public Calculator() {
        cal=new Calculate();

        this.setResizable(false);//设置窗口参数
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("计算器");
        this.setLocationRelativeTo(null);

        bds=new JLabel("表达式");
        jg=new JLabel("结果");

        formula=new JTextField("");
        result=new JTextField("0");
        formula.setHorizontalAlignment(JTextField.RIGHT);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);

        inputarea=new JPanel();
        inputarea.setLayout(new GridLayout(2,2,10,10));
        inputarea.add(bds,BorderLayout.CENTER);
        inputarea.add(formula);
        inputarea.add(jg,BorderLayout.CENTER);
        inputarea.add(result);

        bt1=new Button("1");
        bt1.addActionListener(this);
        bt2=new Button("2");
        bt2.addActionListener(this);
        bt3=new Button("3");
        bt3.addActionListener(this);
        bt4=new Button("4");
        bt4.addActionListener(this);
        bt5=new Button("5");
        bt5.addActionListener(this);
        bt6=new Button("6");
        bt6.addActionListener(this);
        bt7=new Button("7");
        bt7.addActionListener(this);
        bt8=new Button("8");
        bt8.addActionListener(this);
        bt9=new Button("9");
        bt9.addActionListener(this);
        bt0=new Button("0");
        bt0.addActionListener(this);

        btplus=new Button("+");
        btplus.addActionListener(this);
        btsquare=new Button("^");
        btsquare.addActionListener(this);
        btminus=new Button("-");
        btminus.addActionListener(this);
        btmultiply=new Button("*");
        btmultiply.addActionListener(this);
        btdivide=new Button("/");
        btdivide.addActionListener(this);
        btleftbracket=new Button("(");
        btleftbracket.addActionListener(this);
        btrightbracket=new Button(")");
        btrightbracket.addActionListener(this);
        btequal=new Button("=");
        btequal.addActionListener(this);
        btdot=new Button(".");
        btdot.addActionListener(this);
        btback=new Button("DELETE");
        btback.addActionListener(this);
        btclear=new Button("CLEAR");
        btclear.addActionListener(this);

        choosearea=new JPanel();
        choosearea.setLayout(new GridLayout(3,7,10,10));

        choosearea.add(bt7);
        choosearea.add(bt8);
        choosearea.add(bt9);
        choosearea.add(bt0);
        choosearea.add(btplus);
        choosearea.add(btdivide);
        choosearea.add(btsquare);
        choosearea.add(bt4);
        choosearea.add(bt5);
        choosearea.add(bt6);
        choosearea.add(btdot);
        choosearea.add(btminus);
        choosearea.add(btleftbracket);
        choosearea.add(btback);
        choosearea.add(bt1);
        choosearea.add(bt2);
        choosearea.add(bt3);
        choosearea.add(btequal);
        choosearea.add(btmultiply);
        choosearea.add(btrightbracket);
        choosearea.add(btclear);

        this.add(inputarea,BorderLayout.NORTH);
        this.add(choosearea,BorderLayout.CENTER);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1) {
            formula.setText(formula.getText()+"1");
        }else if(e.getSource()==bt2) {
            formula.setText(formula.getText()+"2");
        }else if(e.getSource()==bt3) {
            formula.setText(formula.getText()+"3");
        }else if(e.getSource()==bt4) {
            formula.setText(formula.getText()+"4");
        }else if(e.getSource()==bt5) {
            formula.setText(formula.getText()+"5");
        }else if(e.getSource()==bt6) {
            formula.setText(formula.getText()+"6");
        }else if(e.getSource()==bt7) {
            formula.setText(formula.getText()+"7");
        }else if(e.getSource()==bt8) {
            formula.setText(formula.getText()+"8");
        }else if(e.getSource()==bt9) {
            formula.setText(formula.getText()+"9");
        }else if(e.getSource()==bt0) {
            formula.setText(formula.getText()+"0");
        }else if(e.getSource()==btplus) {
            formula.setText(formula.getText()+"+");
        }else if(e.getSource()==btminus) {
            formula.setText(formula.getText()+"-");
        }else if(e.getSource()==btmultiply) {
            formula.setText(formula.getText()+"*");
        }else if(e.getSource()==btdivide) {
            formula.setText(formula.getText()+"/");
        }else if(e.getSource()==btsquare) {
            formula.setText(formula.getText()+"^");
        }else if(e.getSource()==btleftbracket) {
            formula.setText(formula.getText()+"(");
        }else if(e.getSource()==btrightbracket) {
            formula.setText(formula.getText()+")");
        }else if(e.getSource()==btequal) {
            double res=cal.Fun(formula.getText());
            result.setText(res+"");
        }else if(e.getSource()==btdot) {
            formula.setText(formula.getText()+".");
        }else if(e.getSource()==btback) {
            formula.setText(formula.getText().substring(0,formula.getText().length()-1));
        }else if(e.getSource()==btclear) {
            formula.setText("");
            result.setText("");
        }
    }
}

