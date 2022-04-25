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
                        questions.setText("Do you like fire?");
                        //mudar resp
                        String myArray7[]={"Its beautiful","Its okay","Nop , it scares me"};
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
                        
                        //get a solução
                        Query q1= new Query("consult('bd.pl').");
                        q1.hasSolution();
                        Query q2= new Query("consult('ops.pl').");
                        q2.hasSolution();
                        Query q3= new Query("cabeca("+respostas.get(9)+","+respostas.get(0)+","+respostas.get(1)+","+respostas.get(2)+","+respostas.get(3)+","+respostas.get(4)+","+respostas.get(5)+","+respostas.get(6)+","+respostas.get(7)+","+respostas.get(8)+",R),nth0("+0+",R,[Id1,_]),nth0("+1+",R,[Id2,_]),nth0("+2+",R,[Id3,_]),nth0("+3+",R,[Id4,_]),nth0("+4+",R,[Id5,_]).");
                        //mudar a pergunta para as soluções
                        Map<String,Term> resposta= q3.oneSolution();
                        //Setting questions to false
                        questions.setVisible(false);
                        //alterar o texto do botao
                        button.setText("Finish");
                        //colocar combo invisivel
                        combo.setVisible(false);
                        //CRIAR LABELS
                        //labels top normal
                        JLabel top5_text= new JLabel("Top 5");
                        JLabel top1=new JLabel("1º - "+resposta.get("Id1").toString());
                        JLabel top2=new JLabel("2º - "+resposta.get("Id2").toString());
                        JLabel top3=new JLabel("3º - "+resposta.get("Id3").toString());
                        JLabel top4=new JLabel("4º - "+resposta.get("Id4").toString());
                        JLabel top5=new JLabel("5º - "+resposta.get("Id5").toString());
                        //labels info
                        JLabel car_text= new JLabel("Caracteristics");
                        car_text.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,15));
                        JLabel preco_text=new JLabel("Price-");
                        JLabel Qualidadegeral_text=new JLabel("Overall Quality-");
                        JLabel Condicaogeral_text=new JLabel("Overall Condition-");
                        JLabel Qualidadecozinha_text=new JLabel("Kitchen Quality-");
                        JLabel Tipolocalidade_text=new JLabel("Local type-");
                        JLabel TipoAlojamento_text=new JLabel("Property type-");
                        JLabel MaterialTelhado_text=new JLabel("Roof Material-");
                        JLabel MaterialExterior_text=new JLabel("Exterior Material-");
                        JLabel Piscina_text=new JLabel("Pool-");
                        JLabel TamanhoCasa_text=new JLabel("Home type-");
                        JLabel Fogueira=new JLabel("Fireplace-");
                        JLabel QualidadeMaterialExterior=new JLabel("Exterior Quality-");
                        JLabel CondicaoMaterialExterior=new JLabel("Exterior Condition-");
                        JLabel Cidade=new JLabel("City-");

                        //Setar tamanho
                        frame.setSize(window_width,window_height+100);
                        //SETAR POSI DO BOTAO
                        button.setLocation((int)(window_width*0.432),(int)(window_height*0.90));
                    
                        
                        //adicionar um evento em que o rato passa por cima 
                            top1.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta.get("Id1").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });
                            
                            //adicionar um evento em que o rato passa por cima 
                            top2.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta.get("Id2").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                            top3.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta.get("Id3").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                            top4.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta.get("Id4").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                            top5.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta.get("Id5").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                        //adicionar ao painel
                        painel.add(Qualidadegeral_text);
                        painel.add(Condicaogeral_text);
                        painel.add(Qualidadecozinha_text);
                        painel.add(Tipolocalidade_text);
                        painel.add(TipoAlojamento_text);
                        painel.add(MaterialTelhado_text);
                        painel.add(MaterialExterior_text);
                        painel.add(Piscina_text);
                        painel.add(TamanhoCasa_text);
                        painel.add(Fogueira);
                        painel.add(QualidadeMaterialExterior);
                        painel.add(CondicaoMaterialExterior);
                        painel.add(Cidade);
                        painel.add(car_text);
                        painel.add(preco_text);
                        painel.add(top5_text);
                        painel.add(top1);
                        painel.add(top2);
                        painel.add(top3);
                        painel.add(top4);
                        painel.add(top5);
                        //labels segundo top caso o preco seja igual ou inferior a 180000
                       if (Integer.valueOf(respostas.get(9))<=180000) {
                        //outra query
                        Query q4= new Query("cabeca("+(Integer.valueOf(respostas.get(9))+40000)+","+respostas.get(0)+","+respostas.get(1)+","+respostas.get(2)+","+respostas.get(3)+","+respostas.get(4)+","+respostas.get(5)+","+respostas.get(6)+","+respostas.get(7)+","+respostas.get(8)+",R),nth0("+0+",R,[Id1,_]),nth0("+1+",R,[Id2,_]),nth0("+2+",R,[Id3,_]),nth0("+3+",R,[Id4,_]),nth0("+4+",R,[Id5,_]).");
                        //mudar a pergunta para as soluções
                        Map<String,Term> resposta_op= q4.oneSolution();
                        //labels de top opcional
                        JLabel top5_text_op=new JLabel("Top 5 + 40k");
                        JLabel top1_op=new JLabel("1º - "+resposta_op.get("Id1").toString());
                        JLabel top2_op=new JLabel("2º - "+resposta_op.get("Id2").toString());
                        JLabel top3_op=new JLabel("3º - "+resposta_op.get("Id3").toString());
                        JLabel top4_op=new JLabel("4º - "+resposta_op.get("Id4").toString());
                        JLabel top5_op=new JLabel("5º - "+resposta_op.get("Id5").toString());
                        
                        //adicionar um evento em que o rato passa por cima 
                        top1_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id1").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                        top2_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id2").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                        top3_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id3").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                        top4_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id4").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                            //adicionar um evento em que o rato passa por cima 
                        top5_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id5").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price-"+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("Overall Quality-"+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("Overall Condition-"+sequenciarespostas.get("Q2"));
                                //setar qualidade da cozinha
                                Qualidadecozinha_text.setText("Kitchen Quality-"+sequenciarespostas.get("Q3"));
                                //setar tipo localidade
                                Tipolocalidade_text.setText("Local type-"+sequenciarespostas.get("Q4"));
                                //setar tipo alojamento
                                TipoAlojamento_text.setText("Property type-"+sequenciarespostas.get("Q5"));
                                //setar material telhado
                                MaterialTelhado_text.setText("Roof Material-"+sequenciarespostas.get("Q6"));
                                //setar material telghado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool- No");
                                }else{
                                    Piscina_text.setText("Pool- Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));

                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace-Yes");
                                }else{
                                    Fogueira.setText("Fireplace-No");  
                                }

                                //setar qualidade material exterior
                                QualidadeMaterialExterior.setText("Exterior Quality-"+sequenciarespostas.get("Q11"));

                                //setar condicao do material exterior
                                CondicaoMaterialExterior.setText("Exterior Condition-"+sequenciarespostas.get("Q12"));
                                
                                //setar cidade
                                Cidade.setText("City-"+sequenciarespostas.get("Q13"));
                                }
                            });

                        //add to painel
                        painel.add(top5_text_op);
                        painel.add(top1_op);
                        painel.add(top2_op);
                        painel.add(top3_op);
                        painel.add(top4_op);
                        painel.add(top5_op);

                        //Setar coords do title
                        car_text.setBounds((int)(window_width*0.43), (int)(window_height*0.05),200,100);
                        preco_text.setBounds((int)(window_width*0.43), (int)(window_height*0.10),200,100);
                        Qualidadegeral_text.setBounds((int)(window_width*0.43), (int)(window_height*0.15),200,100);
                        Condicaogeral_text.setBounds((int)(window_width*0.43), (int)(window_height*0.20),200,100);
                        Qualidadecozinha_text.setBounds((int)(window_width*0.43), (int)(window_height*0.25),200,100);
                        Tipolocalidade_text.setBounds((int)(window_width*0.43), (int)(window_height*0.30),200,100);
                        TipoAlojamento_text.setBounds((int)(window_width*0.43), (int)(window_height*0.35),200,100);
                        MaterialTelhado_text.setBounds((int)(window_width*0.43), (int)(window_height*0.40),200,100);
                        Piscina_text.setBounds((int)(window_width*0.43), (int)(window_height*0.45),200,100);
                        TamanhoCasa_text.setBounds((int)(window_width*0.43), (int)(window_height*0.50),200,100);
                        Fogueira.setBounds((int)(window_width*0.43), (int)(window_height*0.55),200,100);
                        QualidadeMaterialExterior.setBounds((int)(window_width*0.43), (int)(window_height*0.60),200,100);
                        CondicaoMaterialExterior.setBounds((int)(window_width*0.43), (int)(window_height*0.65),200,100);
                        Cidade.setBounds((int)(window_width*0.43), (int)(window_height*0.70),200,100);

                        //setar cords top5 normal
                        top5_text_op.setBounds((int)(window_width*0.85), (int)(window_height*0.15),100,15);
                        top1_op.setBounds((int)(window_width*0.85), (int)(window_height*0.20),70,10);
                        top2_op.setBounds((int)(window_width*0.85), (int)(window_height*0.30),70,10);
                        top3_op.setBounds((int)(window_width*0.85), (int)(window_height*0.40),70,10);
                        top4_op.setBounds((int)(window_width*0.85), (int)(window_height*0.50),70,10);
                        top5_op.setBounds((int)(window_width*0.85), (int)(window_height*0.60),70,10);

                        //setar cords top5 normal
                        top5_text.setBounds((int)(window_width*0.05), (int)(window_height*0.15),100,15);
                        top1.setBounds((int)(window_width*0.05), (int)(window_height*0.20),70,10);
                        top2.setBounds((int)(window_width*0.05), (int)(window_height*0.30),70,10);
                        top3.setBounds((int)(window_width*0.05), (int)(window_height*0.40),70,10);
                        top4.setBounds((int)(window_width*0.05), (int)(window_height*0.50),70,10);
                        top5.setBounds((int)(window_width*0.05), (int)(window_height*0.60),70,10);

                       }else{
                       
                        //setar cords top5 normal
                        top5_text.setBounds((int)(window_width*0.20), (int)(window_height*0.15),100,15);
                        top1.setBounds((int)(window_width*0.20), (int)(window_height*0.25),70,10);
                        top2.setBounds((int)(window_width*0.20), (int)(window_height*0.35),70,10);
                        top3.setBounds((int)(window_width*0.20), (int)(window_height*0.45),70,10);
                        top4.setBounds((int)(window_width*0.20), (int)(window_height*0.55),70,10);
                        top5.setBounds((int)(window_width*0.20), (int)(window_height*0.65),70,10);
                        //Setar coords do title
                        car_text.setBounds((int)(window_width*0.70), (int)(window_height*0.05),200,100);
                        preco_text.setBounds((int)(window_width*0.70), (int)(window_height*0.10),200,100);
                        Qualidadegeral_text.setBounds((int)(window_width*0.70), (int)(window_height*0.15),200,100);
                        Condicaogeral_text.setBounds((int)(window_width*0.70), (int)(window_height*0.20),200,100);
                        Qualidadecozinha_text.setBounds((int)(window_width*0.70), (int)(window_height*0.25),200,100);
                        Tipolocalidade_text.setBounds((int)(window_width*0.70), (int)(window_height*0.30),200,100);
                        TipoAlojamento_text.setBounds((int)(window_width*0.70), (int)(window_height*0.35),200,100);
                        MaterialTelhado_text.setBounds((int)(window_width*0.70), (int)(window_height*0.40),200,100);
                        Piscina_text.setBounds((int)(window_width*0.70), (int)(window_height*0.45),200,100);
                        TamanhoCasa_text.setBounds((int)(window_width*0.70), (int)(window_height*0.50),200,100);
                        Fogueira.setBounds((int)(window_width*0.70), (int)(window_height*0.55),200,100);
                        QualidadeMaterialExterior.setBounds((int)(window_width*0.70), (int)(window_height*0.60),200,100);
                        CondicaoMaterialExterior.setBounds((int)(window_width*0.70), (int)(window_height*0.65),200,100);
                        Cidade.setBounds((int)(window_width*0.70), (int)(window_height*0.70),200,100);

                       }

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
        //Invocar janela
        App app=new App();
        app.view();
    }
}
