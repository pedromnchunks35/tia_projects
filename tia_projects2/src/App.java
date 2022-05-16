package src;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 


public class App{ 
    //method selected 1=Procura // 2=Hill Climbing 
    static int a=0;
    static String result;
    public static void main(String[] args) {  
    JFrame f=new JFrame();//creating instance of JFrame  
    
    
    

    ////////////////////////////////////////////
                ///FIRST STAGE\\\
    ///////////////////////////////////////////
    JButton b=new JButton("Procura");//creating instance of JButton1
    b.setBounds(130,220,150, 60);//x axis, y axis, width, height  
    b.setBackground(new Color(116,253,111,250));
    b.setFont(new Font("Calibri", Font.BOLD, 18));


    JButton bb=new JButton("Hill Climbing");//creating instance of JButton2  
    bb.setBounds(530,220,150, 60);//x axis, y axis, width, height  
    bb.setBackground(new Color(116,253,111,250));
    bb.setFont(new Font("Calibri", Font.BOLD, 18));


    JLabel t= new JLabel("Aquisicao Automatica de Conhecimento");//creating instance of JLabel
    t.setBounds(170,80,800, 40);//x axis, y axis, width, height  
    t.setFont(new Font("Calibri", Font.BOLD, 28));
    t.setForeground(new Color(0,102,51,250));


    //ADD TO THE FRAME
    f.add(b);//adding button1 in JFrame  
    f.add(bb);//adding button2 in JFrame  
    f.add(t);//adding lable1 in JFrame 


    ////////////////////////////////////////////
                ///SECOND STAGE\\\
    ///////////////////////////////////////////
    JLabel tt= new JLabel("Selecione o Ponto de Partida e o Pondo de Chegada ");//creating instance of JLabel
    tt.setBounds(100,80,800, 40);//x axis, y axis, width, height  
    tt.setFont(new Font("Calibri", Font.BOLD, 28));//set font and weight
    tt.setForeground(new Color(0,102,51,250));//set foreground color

    
    String[] LocationList = {"l1", "l2", "l3", "l4", "l5", "l6", "l7", "l8"};//create a list of all locations
    JComboBox LocationCombo = new JComboBox(LocationList);//create instance JComboBox
    LocationCombo.setBounds(200,180,100, 40);//x axis, y axis, width, height  


    JComboBox LocationCombo2 = new JComboBox(LocationList);//create instance JComboBox2
    LocationCombo2.setBounds(200,300,100, 40);//x axis, y axis, width, height  


    JLabel Q1= new JLabel("Ponto Partida");//creating instance of JLabel
    Q1.setBounds(80,180,800, 40);//x axis, y axis, width, height  
    Q1.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight
    

    JLabel Q2= new JLabel("Ponto Chegada");//creating instance of JLabel
    Q2.setBounds(80,300,800, 40);//x axis, y axis, width, height  
    Q2.setFont(new Font("Calibri", Font.BOLD, 16));//set font and weight


    ImageIcon Image2 = new ImageIcon("p1.png");//create instance of ImageIcon
    JLabel Q3= new JLabel(" ");//creating image
    Q3.setBounds(400,80,400, 400);//x axis, y axis, width, height  
    Q3.setIcon(Image2);//set image2 as icon


    JButton bb2=new JButton("Calcular");//creating instance of JButton2  
    bb2.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bb2.setBackground(new Color(116,253,111,250));//set background color
    bb2.setFont(new Font("Calibri", Font.BOLD, 18));//set font and text size

    if (a = 0){
    Query q1 = 
    new Query( 
	"consult", 
	new Term[] {new Atom("test.pl")} 
    );

    Query q2=
        new Query(
            "child of",
            new Term[] {new Atom(""), new Atom(""), new Atom(""), new Atom("")}
        )


    //ADD TO JFRAME
    f.add(tt);//adding label2 in JFrame
    f.add(LocationCombo);//adding LocationCombo to JFrame
    f.add(LocationCombo2);//adding LocationCombo2 to JFrame
    f.add(Q1);//adding Q1 in JFrame
    f.add(Q2);//adding Q2 in JFrame
    f.add(Q3);//adding Q3 in JFrame
    f.add(bb2);//adding bb2 in JFrame

    //TURN INVISIBLE
    tt.setVisible(false);
    LocationCombo.setVisible(false);
    LocationCombo2.setVisible(false);
    Q1.setVisible(false);
    Q2.setVisible(false);
    Q3.setVisible(false);
    bb2.setVisible(false);


    ////////////////////////////////////////////
                ///THIRD STAGE\\\
    ///////////////////////////////////////////
    JLabel ttt= new JLabel("Caminho Mais Curto");//creating instance of JLabel
    ttt.setBounds(260,80,800, 40);//x axis, y axis, width, height  
    ttt.setFont(new Font("Calibri", Font.BOLD, 28));//set font and text size
    ttt.setForeground(new Color(0,102,51,250));//set foreground color


    JLabel P1= new JLabel("RESULTADO: ");//creating instance of JLabel
    P1.setBounds(100,180,800, 40);//x axis, y axis, width, height  
    P1.setFont(new Font("Calibri", Font.BOLD, 16));//set font and text size


    JLabel P2= new JLabel(" ");//creating instance of JLabel
    P2.setBounds(200,180,800, 40);//x axis, y axis, width, height  
    P2.setFont(new Font("Calibri", Font.BOLD, 16));//set font and text size


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
    f.add(bb4);
    f.add(bb5);

    
    //TURN INVISIBLE
    ttt.setVisible(false);
    P1.setVisible(false);
    P2.setVisible(false);
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
            bb.setVisible(false);
            t.setVisible(false);
            tt.setVisible(true);
            LocationCombo.setVisible(true);
            LocationCombo2.setVisible(true);
            Q1.setVisible(true);
            Q2.setVisible(true);
            Q3.setVisible(true);
            bb2.setVisible(true);
            a=1;
        }
    } );


    //when will climbing button is pressed the program will move from STAGE ONE to STAGE TWO
    //all the STAGE ONE instances will turn invisible and all the instances from STAGE TWO will turn visible
    bb.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            b.setVisible(false);
            bb.setVisible(false);
            t.setVisible(false);
            tt.setVisible(true);
            LocationCombo.setVisible(true);
            LocationCombo2.setVisible(true);
            Q1.setVisible(true);
            Q2.setVisible(true);
            Q3.setVisible(true);
            bb2.setVisible(true);
            a=1;
        }
    } );



    //when calculate button is pressed the program will move from STAGE TWO to STAGE THREE
    //all the STAGE TWO instances will turn invisible and all the instances from STAGE THREE will turn visible
    bb2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            tt.setVisible(false);
            LocationCombo.setVisible(false);
            LocationCombo2.setVisible(false);
            Q1.setVisible(false);
            Q2.setVisible(false);
            Q3.setVisible(false);
            bb2.setVisible(false);
            ttt.setVisible(true);
            P1.setVisible(true);
            P2.setVisible(true);
            bb4.setVisible(true);
            bb5.setVisible(true);
            a=2;
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
            bb4.setVisible(false);
            bb5.setVisible(false);
            b.setVisible(true);
            bb.setVisible(true);
            t.setVisible(true);
            a=0;
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