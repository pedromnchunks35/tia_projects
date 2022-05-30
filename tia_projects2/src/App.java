package src;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
import java.util.Map;


public class App{ 
    static String result, LI, LF, nProbably, A1, A2; 
    static int  nIteractions, nPaccing;
    public static void main(String[] args) {  
    JFrame f=new JFrame();//creating instance of JFrame  
    
    
    

    ////////////////////////////////////////////
                ///FIRST STAGE\\\
    ///////////////////////////////////////////
    JButton b=new JButton("START");//creating instance of JButton1
    b.setBounds(330,220,150, 60);//x axis, y axis, width, height  
    b.setBackground(new Color(116,253,111,250));
    b.setFont(new Font("Calibri", Font.BOLD, 18));


    JLabel t= new JLabel("Aquisicao Automatica de Conhecimento");//creating instance of JLabel
    t.setBounds(170,80,800, 40);//x axis, y axis, width, height  
    t.setFont(new Font("Calibri", Font.BOLD, 28));
    t.setForeground(new Color(0,102,51,250));


    //ADD TO THE FRAME
    f.add(b);//adding button1 in JFrame   
    f.add(t);//adding lable1 in JFrame 


    ////////////////////////////////////////////
                ///SECOND STAGE\\\
    ///////////////////////////////////////////


    JLabel tt= new JLabel("Selecione o Ponto de Partida e o Pondo de Chegada ");//creating instance of JLabel
    tt.setBounds(100,60,800, 40);//x axis, y axis, width, height  
    tt.setFont(new Font("Calibri", Font.BOLD, 28));//set font and weight
    tt.setForeground(new Color(0,102,51,250));//set foreground color

    
    JLabel Q1= new JLabel("Ponto Partida:");//creating instance of JLabel
    Q1.setBounds(60,160,800, 40);//x axis, y axis, width, height  
    Q1.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight


    String[] LocationList = {"l1", "l2", "l3", "l4", "l5", "l6", "l7", "l8"};//create a list of all locations
    JComboBox LocationCombo = new JComboBox(LocationList);//create instance JComboBox
    LocationCombo.setBounds(180,160,100, 40);//x axis, y axis, width, height  


    JLabel Q2= new JLabel("Ponto Chegada:");//creating instance of JLabel
    Q2.setBounds(60,240,800, 40);//x axis, y axis, width, height  
    Q2.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight


    JComboBox LocationCombo2 = new JComboBox(LocationList);//create instance JComboBox2
    LocationCombo2.setBounds(180,240,100, 40);//x axis, y axis, width, height  
    
    
    JLabel Q= new JLabel("Iteractions:");//creating instance of JLabel
    Q.setBounds(60,210,800, 40);//x axis, y axis, width, height  
    Q.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight


    JSpinner s = new JSpinner();
    s.setBounds(180, 210, 100, 30);
    

    JLabel Q5 = new JLabel("Pacing:");
    Q5.setBounds(60, 210, 800, 40);
    Q5.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight


    JSpinner s2 = new JSpinner();
    s2.setBounds(180, 210, 100, 30);


    JLabel Q4 = new JLabel("Probabilidade:");
    Q4.setBounds(60, 210, 800, 40);
    Q4.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight

    String[] Probs = {"0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1"};//create a list of all locations
    JComboBox ProbsCombo = new JComboBox(Probs);//create instance JComboBox
    ProbsCombo.setBounds(180,210,100, 40);//x axis, y axis, width, height  
    

    ImageIcon Image2 = new ImageIcon("p1.png");//create instance of ImageIcon
    JLabel Q3= new JLabel(" ");//creating image
    Q3.setBounds(400,80,400, 400);//x axis, y axis, width, height  
    Q3.setIcon(Image2);//set image2 as icon


    JButton bb2=new JButton("Next");//creating instance of JButton2  
    bb2.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bb2.setBackground(new Color(116,253,111,250));//set background color
    bb2.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size


    JButton bbb3=new JButton("Next");//creating instance of JButton2  
    bbb3.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bbb3.setBackground(new Color(116,253,111,250));//set background color
    bbb3.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size


    JButton bbb4=new JButton("Next");//creating instance of JButton2  
    bbb4.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bbb4.setBackground(new Color(116,253,111,250));//set background color
    bbb4.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size


    JButton bbb5=new JButton("Calcular");//creating instance of JButton2  
    bbb5.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bbb5.setBackground(new Color(116,253,111,250));//set background color
    bbb5.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size


    //ADD TO JFRAME
    f.add(s);
    f.add(Q);
    f.add(tt);//adding label2 in JFrame
    f.add(LocationCombo);//adding LocationCombo to JFrame
    f.add(LocationCombo2);//adding LocationCombo2 to JFrame
    f.add(Q1);//adding Q1 in JFrame
    f.add(Q2);//adding Q2 in JFrame
    f.add(Q3);//adding Q3 in JFrame
    f.add(Q4);
    f.add(Q5);
    f.add(s2);
    f.add(ProbsCombo);
    f.add(bb2);//adding bb2 in JFrame
    f.add(bbb3);
    f.add(bbb4);
    f.add(bbb5);

    //TURN INVISIBLE
    s.setVisible(false);
    Q.setVisible(false);
    tt.setVisible(false);
    LocationCombo.setVisible(false);
    LocationCombo2.setVisible(false);
    Q1.setVisible(false);
    Q2.setVisible(false);
    Q3.setVisible(false);
    Q4.setVisible(false);
    Q5.setVisible(false);
    s2.setVisible(false);
    ProbsCombo.setVisible(false);
    bb2.setVisible(false);
    bbb3.setVisible(false);
    bbb4.setVisible(false);
    bbb5.setVisible(false);
    

    ////////////////////////////////////////////
                ///THIRD STAGE\\\
    ///////////////////////////////////////////


    JLabel ttt= new JLabel("Caminho Mais Curto");//creating instance of JLabel
    ttt.setBounds(260,40,800, 40);//x axis, y axis, width, height  
    ttt.setFont(new Font("Calibri", Font.BOLD, 28));//set font and text size
    ttt.setForeground(new Color(0,102,51,250));//set foreground color

    String x1 = "<html><u> Gerar e Testar:</u></html>";
    JLabel P1= new JLabel();//creating instance of JLabel
    P1.setText(x1);
    P1.setBounds(150,120,800, 40);//x axis, y axis, width, height  
    P1.setFont(new Font("Calibri", Font.BOLD, 22));//set font and text size


    JLabel P2= new JLabel();//creating instance of JLabel
    P2.setBounds(150,220,800, 40);//x axis, y axis, width, height  
    P2.setFont(new Font("Calibri", Font.BOLD, 16));//set font and text size


    String x2 = "<html><u>Will Climbing:</u></html>";
    JLabel P3= new JLabel();//creating instance of JLabel
    P3.setText(x2);
    P3.setBounds(500,120,800, 40);//x axis, y axis, width, height  
    P3.setFont(new Font("Calibri", Font.BOLD, 22));//set font and text size


    JLabel P4= new JLabel();//creating instance of JLabel
    P4.setBounds(500,220,800, 40);//x axis, y axis, width, height  
    P4.setFont(new Font("Calibri", Font.BOLD, 16));//set font and text size


    JButton bb4=new JButton("REPETIR");//creating instance of JButton2  
    bb4.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bb4.setBackground(new Color(116,253,111,250));//set background color
    bb4.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size


    JButton bb5=new JButton("SAIR");//creating instance of JButton2  
    bb5.setBounds(530,380,150, 60);//x axis, y axis, width, height  
    bb5.setBackground(new Color(116,253,111,250));//set background color
    bb5.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size

    //ADD TO JFrama
    f.add(ttt);
    f.add(P1);
    f.add(P2);
    f.add(P3);
    f.add(P4);
    f.add(bb4);
    f.add(bb5);

    
    //TURN INVISIBLE
    ttt.setVisible(false);
    P1.setVisible(false);
    P2.setVisible(false);
    P3.setVisible(false);
    P4.setVisible(false);
    bb4.setVisible(false);
    bb5.setVisible(false);


    ////////////////////////////////////////////
                ///FUNCTIONS STAGE\\\
    ///////////////////////////////////////////


    //when standard button is pressed the program will move from STAGE ONE to STAGE TWO
    //all the STAGE ONE instances will turn invisible and all the instances from STAGE TWO will turn visible
    b.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            b.setVisible(false);
            t.setVisible(false);
            tt.setVisible(true);
            LocationCombo.setVisible(true);
            LocationCombo2.setVisible(true);
            Q1.setVisible(true);
            Q2.setVisible(true);
            Q3.setVisible(true);
            bb2.setVisible(true);
        }
    } );


    //when calculate button is pressed the program will move from STAGE TWO to STAGE THREE
    //all the STAGE TWO instances will turn invisible and all the instances from STAGE THREE will turn visible
    bb2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Q.setVisible(true);
            s.setVisible(true);
            LocationCombo.setVisible(false);
            LocationCombo2.setVisible(false);
            Q1.setVisible(false);
            Q2.setVisible(false);
            bb2.setVisible(false);
            bbb3.setVisible(true);
            LI = LocationCombo.getSelectedItem().toString();
            LF = LocationCombo2.getSelectedItem().toString();
            System.out.println("LOCATION FIRST " + LI);
            System.out.println("LOCATION FINAL " + LF);
        }
    } );

        //when calculate button is pressed the program will move from STAGE TWO to STAGE THREE
    //all the STAGE TWO instances will turn invisible and all the instances from STAGE THREE will turn visible
    bbb3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Q.setVisible(false);
            s.setVisible(false);
            Q3.setVisible(true);
            Q5.setVisible(true);
            s2.setVisible(true);
            bbb3.setVisible(false);
            bbb4.setVisible(true);
            nIteractions = (Integer) s.getValue();
            System.out.println("ITERACTION " + nIteractions);
            
            
            s2.setModel(new SpinnerNumberModel(0,0,nIteractions,1));
        }
    } );


        //when calculate button is pressed the program will move from STAGE TWO to STAGE THREE
    //all the STAGE TWO instances will turn invisible and all the instances from STAGE THREE will turn visible
    bbb4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            tt.setVisible(true);
            Q3.setVisible(true);
            Q5.setVisible(false);
            Q4.setVisible(true);
            s2.setVisible(false);
            ProbsCombo.setVisible(true);
            bbb4.setVisible(false);
            bbb5.setVisible(true);
            nPaccing = (Integer) s2.getValue();
            System.out.println("PACCING " + nPaccing);
        }
    } );


        //when calculate button is pressed the program will move from STAGE TWO to STAGE THREE
    //all the STAGE TWO instances will turn invisible and all the instances from STAGE THREE will turn visible
    bbb5.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            tt.setVisible(false);
            Q3.setVisible(false);
            Q4.setVisible(false);
            s2.setVisible(false);
            ProbsCombo.setVisible(false);
            bbb5.setVisible(false);
            ttt.setVisible(true);
            P1.setVisible(true);
            P2.setVisible(true);
            P3.setVisible(true);
            P4.setVisible(true);  
            bb4.setVisible(true);
            bb5.setVisible(true);
            nProbably = ProbsCombo.getSelectedItem().toString();
            System.out.println("Probably " + nProbably);

            
            Query q1 = new Query("consult('bd.pl').");
            q1.hasSolution();
            Query q2 = new Query("consult('ops_geral.pl').");
            q2.hasSolution();
            Query q3 = new Query("findminpath("+LI+","+LF+",A1,A2");
            Map<String,Term> resposta1=q3.oneSolution();

            P2.setText(resposta1);
            

            Query q4 = new Query("consult('bd.pl').");
            q1.hasSolution();
            Query q5 = new Query("consult('ops_climbV2.pl').");
            q2.hasSolution();
            Query q6 = new Query("demo("+LI+","+LF+","+nIteractions+","+nPaccing+","+nProbably);
            Map<String,Term> resposta2=q3.oneSolution();

            P4.setText(q4.hasSolution(resposta2));
        }
    } );



    //when repete button is pressed the program will move from STAGE THREE to STAGE ONE again
    //all the STAGE THREE instances will turn invisible and all the instances from STAGE ONE will turn visible
    bb4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            ttt.setVisible(false);
            P1.setVisible(false);
            P2.setVisible(false);
            P3.setVisible(false);
            P4.setVisible(false);
            bb4.setVisible(false);
            bb5.setVisible(false);
            b.setVisible(true);
            t.setVisible(true);            
        }
    } );

    //close the program
    bb5.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    } );


    f.setSize(800,500);//800 width and 500 height  
    f.setLocationRelativeTo(null);
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
      
} 

}