import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 


public class App{ 
    //method selected 1=Procura // 2=Hill Climbing 
    static int a=0;
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
    tt.setFont(new Font("Calibri", Font.BOLD, 28));
    tt.setForeground(new Color(0,102,51,250));

    
    String[] LocationList = {"l1", "l2", "l3", "l4", "l5", "l6", "l7", "l8"};
    JComboBox LocationCombo = new JComboBox(LocationList);
    LocationCombo.setBounds(200,180,100, 40);//x axis, y axis, width, height  


    JComboBox LocationCombo2 = new JComboBox(LocationList);
    LocationCombo2.setBounds(200,300,100, 40);//x axis, y axis, width, height  


    JLabel Q1= new JLabel("Ponto Partida");//creating instance of JLabel
    Q1.setBounds(80,180,800, 40);//x axis, y axis, width, height  
    Q1.setFont(new Font("Calibri", Font.BOLD, 16));
    

    JLabel Q2= new JLabel("Ponto Chegada");//creating instance of JLabel
    Q2.setBounds(80,300,800, 40);//x axis, y axis, width, height  
    Q2.setFont(new Font("Calibri", Font.BOLD, 16));


    ImageIcon Image2 = new ImageIcon("p1.png");
    JLabel Q3= new JLabel(" ");//creating image
    Q3.setBounds(400,80,400, 400);//x axis, y axis, width, height  
    Q3.setIcon(Image2);


    JButton bb2=new JButton("Calcular");//creating instance of JButton2  
    bb2.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bb2.setBackground(new Color(116,253,111,250));
    bb2.setFont(new Font("Calibri", Font.BOLD, 18));


    //ADD TO JFRAME
    f.add(tt);//adding label2 in JFrame
    f.add(LocationCombo);
    f.add(LocationCombo2);
    f.add(Q1);
    f.add(Q2);
    f.add(Q3);
    f.add(bb2);

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
    ttt.setFont(new Font("Calibri", Font.BOLD, 28));
    ttt.setForeground(new Color(0,102,51,250));


    JLabel P1= new JLabel("RESULTADO");//creating instance of JLabel
    P1.setBounds(100,180,800, 40);//x axis, y axis, width, height  
    P1.setFont(new Font("Calibri", Font.BOLD, 16));


    JLabel P2= new JLabel(" ");//creating instance of JLabel
    P2.setBounds(200,180,800, 40);//x axis, y axis, width, height  
    P2.setFont(new Font("Calibri", Font.BOLD, 16));


    JButton bb4=new JButton("REPETIR");//creating instance of JButton2  
    bb4.setBounds(130,380,150, 60);//x axis, y axis, width, height  
    bb4.setBackground(new Color(116,253,111,250));
    bb4.setFont(new Font("Calibri", Font.BOLD, 18));


    JButton bb5=new JButton("SAIR");//creating instance of JButton2  
    bb5.setBounds(530,380,150, 60);//x axis, y axis, width, height  
    bb5.setBackground(new Color(116,253,111,250));
    bb5.setFont(new Font("Calibri", Font.BOLD, 18));

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