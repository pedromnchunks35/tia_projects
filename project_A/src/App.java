import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*; 
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Map;
public class App {
    //State
    int state=0;
    //Array
    List<String> respostas = new ArrayList<String>(9);
    //view
    public void view (){
        //Array List
        List<Image> icons = new ArrayList<Image>();
        //Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //CRIAR UM FRAME
        JFrame frame = new JFrame();
        // Detalhes do ecra
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        //Tamanho da janela relativo
        int window_width= (int)(size.getWidth()*0.30);
        int window_height= (int)(size.getHeight()*0.30);
        //Setar tamanho
        frame.setSize(window_width,window_height);
         // x posicao centrada
        int width = (int)((size.getWidth()-frame.getWidth())/2);
        // y posicao centrada
        int height = (int)((size.getHeight()-frame.getHeight())/2);
        //setar localizacao
        frame.setLocation(width,height);
        //operacao de close da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setar titulo
        frame.setTitle("TIA's Housing");
        icons.add(toolkit.getImage("assets/16.png"));
        icons.add(toolkit.getImage("assets/24.png"));
        icons.add(toolkit.getImage("assets/32.png"));
        icons.add(toolkit.getImage("assets/64.png"));
        icons.add(toolkit.getImage("assets/128.png"));
        icons.add(toolkit.getImage("assets/256.png"));
        icons.add(toolkit.getImage("assets/524.png"));
        //Icon
        frame.setIconImages(icons);
        //init
        BufferedImage myPicture=null;
        //Imagens
        try {
           myPicture = ImageIO.read(new File("assets/64.png"));   
        } catch (IOException e) {
            //TODO: handle exception
        }
        
        System.out.println(myPicture);
        //Quadro
        JLabel quadro = new JLabel(new ImageIcon(myPicture)); 
        //Painel
        JPanel painel= new JPanel();
        //layout
        painel.setLayout(null);
        //tamanho painel
        painel.setSize(window_width,window_height);
        //tamanho e posi do quadro
        quadro.setBounds((int)(window_width*0.46),(int)(window_height*0.10),64,64);
        //button
        JButton button = new JButton("Start");
        //tamanho e posi do botao
        button.setBounds((int)(window_width*0.435),(int)(window_height*0.40),100,60);
        //remover background
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        //criar cor de borda
        Color othercolor=new Color(79,240,93);
        //colocar cor na borda
        button.setBorder(BorderFactory.createLineBorder(othercolor,4));
        //Just an label
        JLabel questions= new JLabel("");
        //tornar invi
        questions.setVisible(false);
        //pos
        questions.setBounds((int)(window_width*0.37),(int)(window_height*0.20),400,100);
        //combobox
        JComboBox combo=new JComboBox<String>();
        //combo pos and size
        combo.setBounds((int)(window_width*0.38),(int)(window_height*0.10),200,30);
        //remover focus
        combo.setFocusable(false);
        //opacidade
        combo.setOpaque(true);
        //setar background para verde
        combo.setBackground(othercolor);
        //letras pretas
        combo.setForeground(Color.black);
        //font
        combo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        //tornar invi
        combo.setVisible(false);
        //add to painel
        painel.add(combo);
        //add to painel
        painel.add(questions);
        //action listener
        button.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                //estado da app
                    state+=1;
                //switch para cada estado
                    switch (state) {
                        case 1:
                        //setar imagem invi
                        quadro.setVisible(false);
                        //mudar button para next
                        button.setText("Next");
                        //pergunta
                        questions.setText("What does your home represent?"); 
                        //setar visivel 
                        questions.setVisible(true);
                        //setar nova loc do botao 
                        button.setLocation((int)(window_width*0.432),(int)(window_height*0.60));
                        //setar combo visivel
                        combo.setVisible(true);
                        //setar loc da combo
                        combo.setLocation((int)(window_width*0.37),(int)(window_height*0.43));
                        //setar modelo da box
                        String myArray[]={"confort","A place to sleep","A place to work"};
                        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(myArray);
                        combo.setModel(model);
                        break;
                        case 2:
                        //get index
                        int index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("confort");
                            break;
                            
                            case 1:
                            respostas.add("place_to_sleep");
                            break;

                            case 2:
                            respostas.add("place_to_work");
                            break;
                        }
                        //alterar perg
                        questions.setText("How do you handle with nature?");
                        //mudar respostas
                        String myArray2[]={"I love it","Its slightly irritant"};
                        DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(myArray2);
                        combo.setModel(model2);
                        break;
    
                        case 3:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("i_love_it");
                            break;
                            
                            case 1:
                            respostas.add("irritant");
                            break;
                        }
                        //alterar pergunta
                        questions.setText("How is your relation with your neighbours?");
                        //mudar respostas
                        String myArray3[]={"I like people","Neutral","I dont really like people"};
                        DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<>(myArray3);
                        combo.setModel(model3);
                        break;
    
                        case 4:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("i_like_people");
                            break;
                            
                            case 1:
                            respostas.add("neutral");
                            break;

                            case 2:
                            respostas.add("i_dont_like_people");
                            break;
                        }
                        //mudar perg
                        questions.setText("Which music do you prefer most?");
                        //mudar resposta
                        String myArray4[]={"Jazz","Pop","Rap"};
                        DefaultComboBoxModel<String> model4 = new DefaultComboBoxModel<>(myArray4);
                        combo.setModel(model4);
                        break;
    
                        case 5:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("jazz");
                            break;
                            
                            case 1:
                            respostas.add("pop");
                            break;

                            case 2:
                            respostas.add("rap");
                            break;
                        }
                        //mudar perg
                        questions.setText("You know how to swim?");
                        //mudar respostas
                        String myArray5[]={"Yes, a lot","I'm a champion","Not rly"};
                        DefaultComboBoxModel<String> model5 = new DefaultComboBoxModel<>(myArray5);
                        combo.setModel(model5);
                        break;
    
                        case 6:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("yes_a_lot");
                            break;
                            
                            case 1:
                            respostas.add("champion");
                            break;

                            case 2:
                            respostas.add("not_rly");
                            break;
                        }
                        //mudar perg
                        questions.setText("Do you have a family?");
                        //mudar resp
                        String myArray6[]={"Yes , a big one","Yes","No"};
                        DefaultComboBoxModel<String> model6 = new DefaultComboBoxModel<>(myArray6);
                        combo.setModel(model6);
                        break;
    
                        case 7:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("big_one");
                            break;
                            
                            case 1:
                            respostas.add("yes_family");
                            break;

                            case 2:
                            respostas.add("no_family");
                            break;
                        }
                        //mudar perg
                        questions.setText("Do you enjoy relaxing at a fireplace?");
                        //mudar resp
                        String myArray7[]={"Its my favorite thing to do","Its okay","Not needed at all"};
                        DefaultComboBoxModel<String> model7 = new DefaultComboBoxModel<>(myArray7);
                        combo.setModel(model7);
                        break;
    
                        case 8:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("yes_favorite_fireplace");
                            break;
                            
                            case 1:
                            respostas.add("its_ok_fireplace");
                            break;

                            case 2:
                            respostas.add("not_rly_fireplace");
                            break;
                        }
                        //mudar perg
                        questions.setText("You rely a lot on appearences?");
                        //mudar resp
                        String myArray8[]={"yes , a lot","just a bit","not rly"};
                        DefaultComboBoxModel<String> model8 = new DefaultComboBoxModel<>(myArray8);
                        combo.setModel(model8);
                        break;
    
                        case 9:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("yes_alot_appear");
                            break;
                            
                            case 1:
                            respostas.add("just_a_bit_appear");
                            break;

                            case 2:
                            respostas.add("not_rly_appear");
                            break;
                        }
                        //mudar perg
                        questions.setText("Do you like the Mountains?");
                        //mudar resp
                        String myArray9[]={"yes, i love it","I prefer beatches","I like more of a green zone"};
                        DefaultComboBoxModel<String> model9 = new DefaultComboBoxModel<>(myArray9);
                        combo.setModel(model9);
                        button.setText("Next");
                        break;
    
                        case 10:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("yes_i_love_it");
                            break;
                            
                            case 1:
                            respostas.add("i_prefer_beatches");
                            break;

                            case 2:
                            respostas.add("i_prefer_green_zones");
                            break;
                        }
                        //mudar perg
                        questions.setText("What is your price range?");
                        //mudar resp
                        String myArray10[]={"<140k","<160k","<180k","<200k", "<220k"};
                        DefaultComboBoxModel<String> model10 = new DefaultComboBoxModel<>(myArray10);
                        combo.setModel(model10);
                        button.setText("Submit");
                        break;
    
                        case 11:
                        //get index
                        index = combo.getSelectedIndex();
                        //Ir buscar resposta e colocar correspondente no array pela index
                        switch (index) {
                            case 0:
                            respostas.add("140000");
                            break;
                            
                            case 1:
                            respostas.add("160000");
                            break;

                            case 2:
                            respostas.add("180000");
                            break;

                            case 3:
                            respostas.add("200000");
                            break;

                            case 4:
                            respostas.add("220000");
                            break;
                        }

                        //confirmar respostas
                        System.out.println(respostas.get(0)+" "+respostas.get(1)+" "+respostas.get(2)+" "+respostas.get(3)+" "+respostas.get(4)+" "+respostas.get(5)+" "+respostas.get(6)+" "+respostas.get(7)+" "+respostas.get(8)+" "+respostas.get(9));
                        //get a solução
                        Query q1= new Query("consult('bd.pl').");
                        System.out.println(q1.hasSolution());
                        Query q2= new Query("consult('ops.pl').");
                        System.out.println(q2.hasSolution());
                        Query q3= new Query("cabeca("+respostas.get(9)+","+respostas.get(0)+","+respostas.get(1)+","+respostas.get(2)+","+respostas.get(3)+","+respostas.get(4)+","+respostas.get(5)+","+respostas.get(6)+","+respostas.get(7)+","+respostas.get(8)+",R),nth0("+0+",R,[Id1,_]),nth0("+1+",R,[Id2,_]),nth0("+2+",R,[Id3,_]),nth0("+3+",R,[Id4,_]),nth0("+4+",R,[Id5,_]).");
                        //mudar a pergunta para as soluções
                        Map<String,Term> resposta= q3.oneSolution();
                        questions.setText("The best houses, are: " + resposta.get("Id1") + " // " + resposta.get("Id2") + " // " + resposta.get("Id3") + " // " + resposta.get("Id4") + " // " + resposta.get("Id5"));
                        //alterar o texto do botao
                        button.setText("Finish");
                        combo.setVisible(false);
                        break;

                        default:
                        System.exit(200);
                        break;
                    }
                }  
            });  
    
        //adicionar ao painel
        painel.add(quadro);
        painel.add(button);
        //adicionar painel ao frame
        frame.add(painel);
        //setar visibilidade
        frame.setVisible(true);
    
        }

        
    public static void main(String[] args) throws Exception {
        
        Query q1= new Query("consult('bd.pl').");
        System.out.println(q1.hasSolution());
        Query q2= new Query("consult('ops.pl').");
        System.out.println(q2.hasSolution());
        
        Query q3= new Query("cabeca(160000,confort,i_love_it,i_like_people,rap,champion,big_one,not_rly_fireplace,yes_alot_appear,i_prefer_green_zones,R),nth0("+0+",R,[Id1,_]),nth0("+1+",R,[Id2,_]),nth0("+2+",R,[Id3,_]),nth0("+3+",R,[Id4,_]),nth0("+4+",R,[Id5,_]).");
        //MAP
        Map<String,Term> resposta= q3.oneSolution();

        System.out.println(resposta.get("Id1"));
        System.out.println(resposta.get("Id2"));
        System.out.println(resposta.get("Id3"));
        System.out.println(resposta.get("Id4"));
        System.out.println(resposta.get("Id5"));
        

        //Invocar janela
        App app=new App();
        app.view();
        //HELLO
        System.out.println("Hello, World!");
        


    }
}
