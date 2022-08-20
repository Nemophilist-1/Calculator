package Calculator;

import javax.swing.*;
import java.util.Stack;

public class Calculate {
    private char ss[][]={   {'>','>','<','<','<','>','>'},
                            {'>','>','<','<','<','>','>'},
                            {'>','>','>','>','<','>','>'},
                            {'>','>','>','>','<','>','>'},
                            {'<','<','<','<','<','=',' '},
                            {'>','>','>','>',' ','>','>'},
                            {'<','<','<','<','<',' ','='}
    };

    public Calculate() {

    }

    double Move(double num,int k){
        if(k==0){
            return num/1.0;
        }
        if(k==1){
            return num/10.0;
        }
        return Move(num/10.0,k-1);
    }

    double Operate(double a,char c,double b){
        switch (c){
            case '+':return b+a;
            case '-':return b-a;
            case '*':return b*a;
            case '/':{
                if (a==0.0){
                    JOptionPane.showMessageDialog(null,"式子有误，请重新输入(除数为0)");
                    return 0;
                }else {
                    return b/Move(a,0);
                }
            }
        }
        return 0;
    }

    int OPTRint(char c){
        if (c == '+') {
            return 0;
        }
        if (c == '-') {
            return 1;
        }
        if (c == '*') {
            return 2;
        }
        if (c == '/') {
            return 3;
        }
        if (c == '(') {
            return 4;
        }
        if (c == ')') {
            return 5;
        }
        if (c == '@') {
            return 6;
        }
        return 0;
    }





    double Fun(String str){
        if (str.contains("^")){
            String[] splitres=str.split("\\^",2);
            if(splitres.length!=2){
                JOptionPane.showMessageDialog(null,"式子有误，不能乘方！");
                return 0;
            }
            try{
                Double a1=Double.parseDouble(splitres[0]);
                Double a2=Double.parseDouble(splitres[1]);
                return Math.pow(a1,a2);
            }catch (NumberFormatException num){
                JOptionPane.showMessageDialog(null,"式子有误，不能转化为前后两实数");
                return 0;
            }
        }
        Stack<Character> OPTR=new Stack<>();//符号栈
        Stack<Double> OPND=new Stack<>();//数字栈
        Stack<Character> st=new Stack<>();
        String s=str+"@";


        int i;

        boolean flag=true;

        for(i=1;i<s.length();i++){
            if(s.charAt(i-1)=='(' && s.charAt(i)==')'){
                JOptionPane.showMessageDialog(null,"括号内无实数");
                return 0;
            }
        }

        for(i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':st.push(s.charAt(i));break;
                case ')':
                    if(st.peek()=='('){
                        st.pop();
                    }else{
                        flag=false;
                    }
                    break;
            }
        }

        if(!flag){
            JOptionPane.showMessageDialog(null,"式子有误");
            return 0;
        }else if(!st.empty()){
            JOptionPane.showMessageDialog(null,"式子有误");
            return 0;
        }

        OPTR.push('@');
        char ch;
        i=0;
        ch=s.charAt(i);
        i++;
        flag=false;

        double num=0.0;
        while(ch!='@'||OPTR.peek()!='@'){
            if(ch>='0'&&ch<='9'){
                num=num*10+ch-'0';
                flag=true;
                ch=s.charAt(i);
                i++;
            }else if(ch=='.'){
                int k=0;
                ch=s.charAt(i);
                i++;
                while (ch>='0'&&ch<='9'){
                    num=num*10+ch-'0';
                    k++;
                    ch=s.charAt(i);
                    i++;
                }
                num=Move(num,k);
                k=0;
            }else if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '(' && ch != ')' && ch != '@'){
                JOptionPane.showMessageDialog(null,"式子有非法符号");
                return 0;
            }else{
                if(flag){
                    OPND.push(num);
                    flag=false;
                }
                num=0.0;
                char pre_op=OPTR.peek();
                switch (ss[OPTRint(pre_op)][OPTRint(ch)]){
                    case '<':
                        OPTR.push(ch);
                        ch = s.charAt(i);
                        i++;
                        break;
                    case '=':
                        ch = OPTR.pop();
                        ch = s.charAt(i);
                        i++;
                        break;
                    case '>':
                        double a = OPND.pop(), b = OPND.pop();
                        pre_op = OPTR.pop();
                        OPND.push(Operate(a, pre_op, b));
                        break;
                }
            }
        }
        return OPND.peek();
    }

}
