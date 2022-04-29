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
                        JLabel top5_text= new JLabel("Top 5 Id's");
                        JLabel top1=new JLabel("1º - "+resposta.get("Id1").toString());
                        JLabel top2=new JLabel("2º - "+resposta.get("Id2").toString());
                        JLabel top3=new JLabel("3º - "+resposta.get("Id3").toString());
                        JLabel top4=new JLabel("4º - "+resposta.get("Id4").toString());
                        JLabel top5=new JLabel("5º - "+resposta.get("Id5").toString());
                        //labels info
                        JLabel some_text= new JLabel("Put your mouse over the ids to check more info"); 
                        some_text.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,20));
                        JLabel car_text= new JLabel("Caracteristics");
                        car_text.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,15));
                        JLabel preco_text=new JLabel("Price:");
                        JLabel Qualidadegeral_text=new JLabel("House Quality 0-10:");
                        JLabel Condicaogeral_text=new JLabel("House Condition 0-10:");
                        JLabel Qualidadecozinha_text=new JLabel("Kitchen Quality:");
                        JLabel Tipolocalidade_text=new JLabel("Local type:");
                        JLabel TipoAlojamento_text=new JLabel("Property type:");
                        JLabel MaterialTelhado_text=new JLabel("Roof Material:");
                        JLabel MaterialExterior_text=new JLabel("Exterior Material:");
                        JLabel Piscina_text=new JLabel("We have Pool?:");
                        JLabel TamanhoCasa_text=new JLabel("Home Type:");
                        JLabel Fogueira=new JLabel("We have Fireplace?:");
                        JLabel QualidadeMaterialExterior=new JLabel("Exterior Quality 0-10:");
                        JLabel CondicaoMaterialExterior=new JLabel("Exterior Condition 0-10:");
                        JLabel Cidade=new JLabel("City:");
                    

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
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }

                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

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
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }

                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

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
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }
                                 
                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

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
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }

                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

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
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }

                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

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
                        painel.add(some_text);
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
                        JLabel top5_text_op=new JLabel("Top 5 Id's + 40k$");
                        JLabel top1_op=new JLabel("1º - "+resposta_op.get("Id1").toString());
                        JLabel top2_op=new JLabel("2º - "+resposta_op.get("Id2").toString());
                        JLabel top3_op=new JLabel("3º - "+resposta_op.get("Id3").toString());
                        JLabel top4_op=new JLabel("4º - "+resposta_op.get("Id4").toString());
                        JLabel top5_op=new JLabel("5º - "+resposta_op.get("Id5").toString());
                        
                        //adicionar um evento em que o rato passa por cima 
                        //adicionar um evento em que o rato passa por cima 
                        top1_op.addMouseListener(
                            new MouseAdapter(){
                                public void mouseEntered(MouseEvent e){
                                    //Query para ir buscar dados do Id1
                                Query query_update=new Query("get_descri("+resposta_op.get("Id1").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                //mudar preco
                                preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                //mudar Qualidade
                                Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                //setar condicao
                                Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));

                                //setar qualidade da cozinha
                                switch (sequenciarespostas.get("Q3").toString()) {
                                    case "ex":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                        break;
                                    case "gd":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                    break;

                                    case "ta":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                    break;

                                    case "po":
                                    Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                    break;
                                
                                    default:
                                    Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                    break;
                                }

                                //setar tipo localidade
                                switch (sequenciarespostas.get("Q4").toString()) {

                                    case "a":
                                    Tipolocalidade_text.setText("Local Type: Agriculture");    
                                    break;
                                    case "c":
                                    Tipolocalidade_text.setText("Local Type: Commercial");    
                                    break;

                                    case "fv":
                                    Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                    break;

                                    case "i":
                                    Tipolocalidade_text.setText("Local Type: Industrial");    
                                    break;

                                    case "rh":
                                    Tipolocalidade_text.setText("Local Type: Residential High Density");
    
                                    break;

                                    case "rl":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                    break;

                                    case "rp":
                                    Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                    break;

                                    case "rm":
                                    Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                    break;
                                
                                    default:
                                    Tipolocalidade_text.setText("Local Type: No Information");
                                        break;
                                }
                                //setar tipo alojamento
                                switch (sequenciarespostas.get("Q5").toString()) {
                                    case "n1Fam":
                                    TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                    break;

                                    case "n2fmCon":
                                    TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                    break;

                                    case "duplex":
                                    TipoAlojamento_text.setText("Property type: Duplex");     
                                    break;

                                    case "twnhse":
                                    TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                    break;

                                    case "twnhs":
                                    TipoAlojamento_text.setText("Property type: Townhouse ");     
                                    break;
                                    
                                    case "twnhsi":
                                    TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                    break;
 
                                    default:
                                    TipoAlojamento_text.setText("No Information");
                                     break;
                                }
                                //setar material telhado
                                switch (sequenciarespostas.get("Q6").toString()) {
                                    case "flat":
                                    MaterialTelhado_text.setText("Roof Style: Flat");
                                    break;
                                    case "gable":
                                    MaterialTelhado_text.setText("Roof Style: Gable"); 
                                    break;
                                    case "gambrel":
                                    MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                    break;

                                    case "hip":
                                    MaterialTelhado_text.setText("Roof Style: Hip"); 
                                    break;
  
                                    case "mansard":
                                    MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                    break;

                                    case "shed":
                                    MaterialTelhado_text.setText("Roof Style: shed"); 
                                    break;
                                
                                    default:
                                    MaterialTelhado_text.setText("Roof Style: No Information"); 
                                    break;
                                }
                                //setar material telhado
                                MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));

                                switch (sequenciarespostas.get("Q7").toString()) {
                                    case "asbShng":
                                    MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                        break;
                                        case "asphshn":
                                        MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                        break;
                                        case "brkcomm":
                                        MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                        break;
                                        case "brkface":
                                        MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                        break;

                                        case "cblock":
                                        MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                        break;

                                        case "cemntbd":
                                        MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                        break;

                                        case "hdboard":
                                        MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                        break;

                                        case "imstucc":
                                        MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                        break;

                                        case "metalsd":
                                        MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                        break;

                                        case "other":
                                        MaterialExterior_text.setText("Exterior Material: Other");  
                                        break;

                                        case "plywood":
                                        MaterialExterior_text.setText("Exterior Material: Plywood");  
                                        break;

                                        case "precast":
                                        MaterialExterior_text.setText("Exterior Material: PreCast");  
                                        break;

                                        case "stone":
                                        MaterialExterior_text.setText("Exterior Material: Stone");  
                                        break;

                                        case "stucco":
                                        MaterialExterior_text.setText("Exterior Material: Stucco");  
                                        break;

                                        case "vinylsd":
                                        MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                        break;

                                        case "wdsdng":
                                        MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                        break;

                                        case "wdshing":
                                        MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                        break;
                                
                                    default:
                                    MaterialExterior_text.setText("Exterior Material: No Information");
                                        break;
                                }
                                

                                // Setar Pool
                                if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                    Piscina_text.setText("Pool?: No");
                                }else{
                                    Piscina_text.setText("Pool?: Yes");
                                }
                                //setar tamanho casa
                                TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                switch (sequenciarespostas.get("Q9").toString()) {
                                    case "20":
                                    TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                        break;

                                        case "30":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                        break;

                                        case "40":
                                        TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                        break;

                                        case "45":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                        break;

                                        case "50":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                        break;

                                        case "60":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                        break;

                                        case "70":
                                        TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                        break;

                                        case "75":
                                        TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                        break;

                                        case "80":
                                        TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                        break;

                                        case "85":
                                        TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                        break;

                                        case "90":
                                        TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                        break;

                                        case "120":
                                        TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                        break;

                                        case "150":
                                        TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                        break;

                                        case "160":
                                        TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                        break;

                                        case "180":
                                        TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                        break;

                                        case "190":
                                        TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                        break;
                                
                                    default:
                                    TamanhoCasa_text.setText("Home type: No Information");
                                        break;
                                }
                        
                                //setar fogueira
                                if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                    Fogueira.setText("Fireplace?: Yes");
                                }else{
                                    Fogueira.setText("Fireplace?: No");  
                                }

                                //setar qualidade material exterior
                                switch (sequenciarespostas.get("Q11").toString()) {
                                    case "ex":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                        break;
                                    case "gd":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                    break;

                                    case "ta":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                    break;

                                    case "fa":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                    break;

                                    case "po":
                                    QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                    break;
                                
                                    default:
                                    QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                    break;
                                }

                                //setar condicao do material exterior
                                switch (sequenciarespostas.get("Q12").toString()) {
                                    case "ex":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                        break;
                                    case "gd":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                    break;

                                    case "ta":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                    break;

                                    case "fa":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                    break;

                                    case "po":
                                    CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                    break;
                                
                                    default:
                                    CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                    break;
                                }
                                //setar cidade
                                switch (sequenciarespostas.get("Q13").toString()) {
                                    case "blmngtn":
                                        Cidade.setText("City: Bloomington Heights");
                                        break;

                                        case "blueste":
                                        Cidade.setText("City: Bluestem");
                                        break;

                                        case "brdale":
                                        Cidade.setText("City: Briardale");
                                        break;

                                        case "brkside":
                                        Cidade.setText("City: Brookside");
                                        break;

                                        case "clearcr":
                                        Cidade.setText("City: Clear Creek");
                                        break;

                                        case "collgcr":
                                        Cidade.setText("City: College Creek");
                                        break;

                                        case "crawfor":
                                        Cidade.setText("City: Crawford");
                                        break;

                                        case "edwards":
                                        Cidade.setText("City: Edwards");
                                        break;

                                        case "gilbert":
                                        Cidade.setText("City: Gilbert");
                                        break;

                                        case "idotrr":
                                        Cidade.setText("City: Iowa DOT and Rail Road");
                                        break;

                                        case "meadowv":
                                        Cidade.setText("City: Meadow Village");
                                        break;

                                        case "mitchel":
                                        Cidade.setText("City: Mitchell");
                                        break;

                                        case "names":
                                        Cidade.setText("City: North Ames");
                                        break;

                                        case "noridge":
                                        Cidade.setText("City: Northridge");
                                        break;

                                        case "npkvill":
                                        Cidade.setText("City: Northpark Villa");
                                        break;

                                        case "nridght":
                                        Cidade.setText("City: Northridge Heights");
                                        break;

                                        case "nwames":
                                        Cidade.setText("City: Northwest Ames");
                                        break;

                                        case "oldtown":
                                        Cidade.setText("City: Old Town");
                                        break;

                                        case "swisu":
                                        Cidade.setText("City: South & West of Iowa State University");
                                        break;

                                        case "sawyer":
                                        Cidade.setText("City: Sawyer");
                                        break;

                                        case "sawyerw":
                                        Cidade.setText("City: Sawyer West");
                                        break;

                                        case "somerst":
                                        Cidade.setText("City: Somerset");
                                        break;

                                        case "stonebr":
                                        Cidade.setText("City: Stone Brook");
                                        break;

                                        case "timber":
                                        Cidade.setText("City: Timberland");
                                        break;

                                        case "veenker":
                                        Cidade.setText("City: Veenker");
                                        break;
                                
                                    default:
                                    Cidade.setText("City: No Information");
                                        break;
                                }

                                }
                            });

                            top2_op.addMouseListener(
                                new MouseAdapter(){
                                    public void mouseEntered(MouseEvent e){
                                        //Query para ir buscar dados do Id1
                                    Query query_update=new Query("get_descri("+resposta_op.get("Id2").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                    Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                    //mudar preco
                                    preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                    //mudar Qualidade
                                    Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                    //setar condicao
                                    Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));
    
                                    //setar qualidade da cozinha
                                    switch (sequenciarespostas.get("Q3").toString()) {
                                        case "ex":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                            break;
                                        case "gd":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                        break;
    
                                        case "ta":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                        break;
    
                                        case "po":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                        break;
                                    
                                        default:
                                        Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                        break;
                                    }
    
                                    //setar tipo localidade
                                    switch (sequenciarespostas.get("Q4").toString()) {
    
                                        case "a":
                                        Tipolocalidade_text.setText("Local Type: Agriculture");    
                                        break;
                                        case "c":
                                        Tipolocalidade_text.setText("Local Type: Commercial");    
                                        break;
    
                                        case "fv":
                                        Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                        break;
    
                                        case "i":
                                        Tipolocalidade_text.setText("Local Type: Industrial");    
                                        break;
    
                                        case "rh":
                                        Tipolocalidade_text.setText("Local Type: Residential High Density");
        
                                        break;
    
                                        case "rl":
                                        Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                        break;
    
                                        case "rp":
                                        Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                        break;
    
                                        case "rm":
                                        Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                        break;
                                    
                                        default:
                                        Tipolocalidade_text.setText("Local Type: No Information");
                                            break;
                                    }
                                    //setar tipo alojamento
                                    switch (sequenciarespostas.get("Q5").toString()) {
                                        case "n1Fam":
                                        TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                        break;
    
                                        case "n2fmCon":
                                        TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                        break;
    
                                        case "duplex":
                                        TipoAlojamento_text.setText("Property type: Duplex");     
                                        break;
    
                                        case "twnhse":
                                        TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                        break;
    
                                        case "twnhs":
                                        TipoAlojamento_text.setText("Property type: Townhouse ");     
                                        break;
                                        
                                        case "twnhsi":
                                        TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                        break;
     
                                        default:
                                        TipoAlojamento_text.setText("No Information");
                                         break;
                                    }
                                    //setar material telhado
                                    switch (sequenciarespostas.get("Q6").toString()) {
                                        case "flat":
                                        MaterialTelhado_text.setText("Roof Style: Flat");
                                        break;
                                        case "gable":
                                        MaterialTelhado_text.setText("Roof Style: Gable"); 
                                        break;
                                        case "gambrel":
                                        MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                        break;
    
                                        case "hip":
                                        MaterialTelhado_text.setText("Roof Style: Hip"); 
                                        break;
      
                                        case "mansard":
                                        MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                        break;
    
                                        case "shed":
                                        MaterialTelhado_text.setText("Roof Style: shed"); 
                                        break;
                                    
                                        default:
                                        MaterialTelhado_text.setText("Roof Style: No Information"); 
                                        break;
                                    }
                                    //setar material telhado
                                    MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
    
                                    switch (sequenciarespostas.get("Q7").toString()) {
                                        case "asbShng":
                                        MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                            break;
                                            case "asphshn":
                                            MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                            break;
                                            case "brkcomm":
                                            MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                            break;
                                            case "brkface":
                                            MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                            break;
    
                                            case "cblock":
                                            MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                            break;
    
                                            case "cemntbd":
                                            MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                            break;
    
                                            case "hdboard":
                                            MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                            break;
    
                                            case "imstucc":
                                            MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                            break;
    
                                            case "metalsd":
                                            MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                            break;
    
                                            case "other":
                                            MaterialExterior_text.setText("Exterior Material: Other");  
                                            break;
    
                                            case "plywood":
                                            MaterialExterior_text.setText("Exterior Material: Plywood");  
                                            break;
    
                                            case "precast":
                                            MaterialExterior_text.setText("Exterior Material: PreCast");  
                                            break;
    
                                            case "stone":
                                            MaterialExterior_text.setText("Exterior Material: Stone");  
                                            break;
    
                                            case "stucco":
                                            MaterialExterior_text.setText("Exterior Material: Stucco");  
                                            break;
    
                                            case "vinylsd":
                                            MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                            break;
    
                                            case "wdsdng":
                                            MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                            break;
    
                                            case "wdshing":
                                            MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                            break;
                                    
                                        default:
                                        MaterialExterior_text.setText("Exterior Material: No Information");
                                            break;
                                    }
                                    
    
                                    // Setar Pool
                                    if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                        Piscina_text.setText("Pool?: No");
                                    }else{
                                        Piscina_text.setText("Pool?: Yes");
                                    }
                                    //setar tamanho casa
                                    TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                    switch (sequenciarespostas.get("Q9").toString()) {
                                        case "20":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                            break;
    
                                            case "30":
                                            TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                            break;
    
                                            case "40":
                                            TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                            break;
    
                                            case "45":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                            break;
    
                                            case "50":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                            break;
    
                                            case "60":
                                            TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                            break;
    
                                            case "70":
                                            TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                            break;
    
                                            case "75":
                                            TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                            break;
    
                                            case "80":
                                            TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                            break;
    
                                            case "85":
                                            TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                            break;
    
                                            case "90":
                                            TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                            break;
    
                                            case "120":
                                            TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                            break;
    
                                            case "150":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                            break;
    
                                            case "160":
                                            TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                            break;
    
                                            case "180":
                                            TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                            break;
    
                                            case "190":
                                            TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                            break;
                                    
                                        default:
                                        TamanhoCasa_text.setText("Home type: No Information");
                                            break;
                                    }
                            
                                    //setar fogueira
                                    if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                        Fogueira.setText("Fireplace?: Yes");
                                    }else{
                                        Fogueira.setText("Fireplace?: No");  
                                    }
    
                                    //setar qualidade material exterior
                                    switch (sequenciarespostas.get("Q11").toString()) {
                                        case "ex":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                            break;
                                        case "gd":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                        break;
    
                                        case "ta":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                        break;
    
                                        case "po":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                        break;
                                    
                                        default:
                                        QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                        break;
                                    }
    
                                    //setar condicao do material exterior
                                    switch (sequenciarespostas.get("Q12").toString()) {
                                        case "ex":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                            break;
                                        case "gd":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                        break;
    
                                        case "ta":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                        break;
    
                                        case "po":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                        break;
                                    
                                        default:
                                        CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                        break;
                                    }
                                    //setar cidade
                                    switch (sequenciarespostas.get("Q13").toString()) {
                                        case "blmngtn":
                                            Cidade.setText("City: Bloomington Heights");
                                            break;
    
                                            case "blueste":
                                            Cidade.setText("City: Bluestem");
                                            break;
    
                                            case "brdale":
                                            Cidade.setText("City: Briardale");
                                            break;
    
                                            case "brkside":
                                            Cidade.setText("City: Brookside");
                                            break;
    
                                            case "clearcr":
                                            Cidade.setText("City: Clear Creek");
                                            break;
    
                                            case "collgcr":
                                            Cidade.setText("City: College Creek");
                                            break;
    
                                            case "crawfor":
                                            Cidade.setText("City: Crawford");
                                            break;
    
                                            case "edwards":
                                            Cidade.setText("City: Edwards");
                                            break;
    
                                            case "gilbert":
                                            Cidade.setText("City: Gilbert");
                                            break;
    
                                            case "idotrr":
                                            Cidade.setText("City: Iowa DOT and Rail Road");
                                            break;
    
                                            case "meadowv":
                                            Cidade.setText("City: Meadow Village");
                                            break;
    
                                            case "mitchel":
                                            Cidade.setText("City: Mitchell");
                                            break;
    
                                            case "names":
                                            Cidade.setText("City: North Ames");
                                            break;
    
                                            case "noridge":
                                            Cidade.setText("City: Northridge");
                                            break;
    
                                            case "npkvill":
                                            Cidade.setText("City: Northpark Villa");
                                            break;
    
                                            case "nridght":
                                            Cidade.setText("City: Northridge Heights");
                                            break;
    
                                            case "nwames":
                                            Cidade.setText("City: Northwest Ames");
                                            break;
    
                                            case "oldtown":
                                            Cidade.setText("City: Old Town");
                                            break;
    
                                            case "swisu":
                                            Cidade.setText("City: South & West of Iowa State University");
                                            break;
    
                                            case "sawyer":
                                            Cidade.setText("City: Sawyer");
                                            break;
    
                                            case "sawyerw":
                                            Cidade.setText("City: Sawyer West");
                                            break;
    
                                            case "somerst":
                                            Cidade.setText("City: Somerset");
                                            break;
    
                                            case "stonebr":
                                            Cidade.setText("City: Stone Brook");
                                            break;
    
                                            case "timber":
                                            Cidade.setText("City: Timberland");
                                            break;
    
                                            case "veenker":
                                            Cidade.setText("City: Veenker");
                                            break;
                                    
                                        default:
                                        Cidade.setText("City: No Information");
                                            break;
                                    }
    
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
                                    preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                    //mudar Qualidade
                                    Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                    //setar condicao
                                    Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));
    
                                    //setar qualidade da cozinha
                                    switch (sequenciarespostas.get("Q3").toString()) {
                                        case "ex":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                            break;
                                        case "gd":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                        break;
    
                                        case "ta":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                        break;
    
                                        case "po":
                                        Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                        break;
                                    
                                        default:
                                        Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                        break;
                                    }
    
                                    //setar tipo localidade
                                    switch (sequenciarespostas.get("Q4").toString()) {
    
                                        case "a":
                                        Tipolocalidade_text.setText("Local Type: Agriculture");    
                                        break;
                                        case "c":
                                        Tipolocalidade_text.setText("Local Type: Commercial");    
                                        break;
    
                                        case "fv":
                                        Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                        break;
    
                                        case "i":
                                        Tipolocalidade_text.setText("Local Type: Industrial");    
                                        break;
    
                                        case "rh":
                                        Tipolocalidade_text.setText("Local Type: Residential High Density");
        
                                        break;
    
                                        case "rl":
                                        Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                        break;
    
                                        case "rp":
                                        Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                        break;
    
                                        case "rm":
                                        Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                        break;
                                    
                                        default:
                                        Tipolocalidade_text.setText("Local Type: No Information");
                                            break;
                                    }
                                    //setar tipo alojamento
                                    switch (sequenciarespostas.get("Q5").toString()) {
                                        case "n1Fam":
                                        TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                        break;
    
                                        case "n2fmCon":
                                        TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                        break;
    
                                        case "duplex":
                                        TipoAlojamento_text.setText("Property type: Duplex");     
                                        break;
    
                                        case "twnhse":
                                        TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                        break;
    
                                        case "twnhs":
                                        TipoAlojamento_text.setText("Property type: Townhouse ");     
                                        break;
                                        
                                        case "twnhsi":
                                        TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                        break;
     
                                        default:
                                        TipoAlojamento_text.setText("No Information");
                                         break;
                                    }
                                    //setar material telhado
                                    switch (sequenciarespostas.get("Q6").toString()) {
                                        case "flat":
                                        MaterialTelhado_text.setText("Roof Style: Flat");
                                        break;
                                        case "gable":
                                        MaterialTelhado_text.setText("Roof Style: Gable"); 
                                        break;
                                        case "gambrel":
                                        MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                        break;
    
                                        case "hip":
                                        MaterialTelhado_text.setText("Roof Style: Hip"); 
                                        break;
      
                                        case "mansard":
                                        MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                        break;
    
                                        case "shed":
                                        MaterialTelhado_text.setText("Roof Style: shed"); 
                                        break;
                                    
                                        default:
                                        MaterialTelhado_text.setText("Roof Style: No Information"); 
                                        break;
                                    }
                                    //setar material telhado
                                    MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
    
                                    switch (sequenciarespostas.get("Q7").toString()) {
                                        case "asbShng":
                                        MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                            break;
                                            case "asphshn":
                                            MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                            break;
                                            case "brkcomm":
                                            MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                            break;
                                            case "brkface":
                                            MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                            break;
    
                                            case "cblock":
                                            MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                            break;
    
                                            case "cemntbd":
                                            MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                            break;
    
                                            case "hdboard":
                                            MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                            break;
    
                                            case "imstucc":
                                            MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                            break;
    
                                            case "metalsd":
                                            MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                            break;
    
                                            case "other":
                                            MaterialExterior_text.setText("Exterior Material: Other");  
                                            break;
    
                                            case "plywood":
                                            MaterialExterior_text.setText("Exterior Material: Plywood");  
                                            break;
    
                                            case "precast":
                                            MaterialExterior_text.setText("Exterior Material: PreCast");  
                                            break;
    
                                            case "stone":
                                            MaterialExterior_text.setText("Exterior Material: Stone");  
                                            break;
    
                                            case "stucco":
                                            MaterialExterior_text.setText("Exterior Material: Stucco");  
                                            break;
    
                                            case "vinylsd":
                                            MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                            break;
    
                                            case "wdsdng":
                                            MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                            break;
    
                                            case "wdshing":
                                            MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                            break;
                                    
                                        default:
                                        MaterialExterior_text.setText("Exterior Material: No Information");
                                            break;
                                    }
                                    
    
                                    // Setar Pool
                                    if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                        Piscina_text.setText("Pool?: No");
                                    }else{
                                        Piscina_text.setText("Pool?: Yes");
                                    }
                                    //setar tamanho casa
                                    TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                    switch (sequenciarespostas.get("Q9").toString()) {
                                        case "20":
                                        TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                            break;
    
                                            case "30":
                                            TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                            break;
    
                                            case "40":
                                            TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                            break;
    
                                            case "45":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                            break;
    
                                            case "50":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                            break;
    
                                            case "60":
                                            TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                            break;
    
                                            case "70":
                                            TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                            break;
    
                                            case "75":
                                            TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                            break;
    
                                            case "80":
                                            TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                            break;
    
                                            case "85":
                                            TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                            break;
    
                                            case "90":
                                            TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                            break;
    
                                            case "120":
                                            TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                            break;
    
                                            case "150":
                                            TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                            break;
    
                                            case "160":
                                            TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                            break;
    
                                            case "180":
                                            TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                            break;
    
                                            case "190":
                                            TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                            break;
                                    
                                        default:
                                        TamanhoCasa_text.setText("Home type: No Information");
                                            break;
                                    }
                            
                                    //setar fogueira
                                    if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                        Fogueira.setText("Fireplace?: Yes");
                                    }else{
                                        Fogueira.setText("Fireplace?: No");  
                                    }
    
                                    //setar qualidade material exterior
                                    switch (sequenciarespostas.get("Q11").toString()) {
                                        case "ex":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                            break;
                                        case "gd":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                        break;
    
                                        case "ta":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                        break;
    
                                        case "po":
                                        QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                        break;
                                    
                                        default:
                                        QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                        break;
                                    }
    
                                    //setar condicao do material exterior
                                    switch (sequenciarespostas.get("Q12").toString()) {
                                        case "ex":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                            break;
                                        case "gd":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                        break;
    
                                        case "ta":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                        break;
    
                                        case "fa":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                        break;
    
                                        case "po":
                                        CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                        break;
                                    
                                        default:
                                        CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                        break;
                                    }
                                    //setar cidade
                                    switch (sequenciarespostas.get("Q13").toString()) {
                                        case "blmngtn":
                                            Cidade.setText("City: Bloomington Heights");
                                            break;
    
                                            case "blueste":
                                            Cidade.setText("City: Bluestem");
                                            break;
    
                                            case "brdale":
                                            Cidade.setText("City: Briardale");
                                            break;
    
                                            case "brkside":
                                            Cidade.setText("City: Brookside");
                                            break;
    
                                            case "clearcr":
                                            Cidade.setText("City: Clear Creek");
                                            break;
    
                                            case "collgcr":
                                            Cidade.setText("City: College Creek");
                                            break;
    
                                            case "crawfor":
                                            Cidade.setText("City: Crawford");
                                            break;
    
                                            case "edwards":
                                            Cidade.setText("City: Edwards");
                                            break;
    
                                            case "gilbert":
                                            Cidade.setText("City: Gilbert");
                                            break;
    
                                            case "idotrr":
                                            Cidade.setText("City: Iowa DOT and Rail Road");
                                            break;
    
                                            case "meadowv":
                                            Cidade.setText("City: Meadow Village");
                                            break;
    
                                            case "mitchel":
                                            Cidade.setText("City: Mitchell");
                                            break;
    
                                            case "names":
                                            Cidade.setText("City: North Ames");
                                            break;
    
                                            case "noridge":
                                            Cidade.setText("City: Northridge");
                                            break;
    
                                            case "npkvill":
                                            Cidade.setText("City: Northpark Villa");
                                            break;
    
                                            case "nridght":
                                            Cidade.setText("City: Northridge Heights");
                                            break;
    
                                            case "nwames":
                                            Cidade.setText("City: Northwest Ames");
                                            break;
    
                                            case "oldtown":
                                            Cidade.setText("City: Old Town");
                                            break;
    
                                            case "swisu":
                                            Cidade.setText("City: South & West of Iowa State University");
                                            break;
    
                                            case "sawyer":
                                            Cidade.setText("City: Sawyer");
                                            break;
    
                                            case "sawyerw":
                                            Cidade.setText("City: Sawyer West");
                                            break;
    
                                            case "somerst":
                                            Cidade.setText("City: Somerset");
                                            break;
    
                                            case "stonebr":
                                            Cidade.setText("City: Stone Brook");
                                            break;
    
                                            case "timber":
                                            Cidade.setText("City: Timberland");
                                            break;
    
                                            case "veenker":
                                            Cidade.setText("City: Veenker");
                                            break;
                                    
                                        default:
                                        Cidade.setText("City: No Information");
                                            break;
                                    }
    
                                    }
                                });

                                top4_op.addMouseListener(
                                    new MouseAdapter(){
                                        public void mouseEntered(MouseEvent e){
                                            //Query para ir buscar dados do Id1
                                        Query query_update=new Query("get_descri("+resposta_op.get("Id4").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                        Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                        //mudar preco
                                        preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                        //mudar Qualidade
                                        Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                        //setar condicao
                                        Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));
        
                                        //setar qualidade da cozinha
                                        switch (sequenciarespostas.get("Q3").toString()) {
                                            case "ex":
                                            Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                                break;
                                            case "gd":
                                            Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                            break;
        
                                            case "ta":
                                            Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                            break;
        
                                            case "fa":
                                            Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                            break;
        
                                            case "po":
                                            Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                            break;
                                        
                                            default:
                                            Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                            break;
                                        }
        
                                        //setar tipo localidade
                                        switch (sequenciarespostas.get("Q4").toString()) {
        
                                            case "a":
                                            Tipolocalidade_text.setText("Local Type: Agriculture");    
                                            break;
                                            case "c":
                                            Tipolocalidade_text.setText("Local Type: Commercial");    
                                            break;
        
                                            case "fv":
                                            Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                            break;
        
                                            case "i":
                                            Tipolocalidade_text.setText("Local Type: Industrial");    
                                            break;
        
                                            case "rh":
                                            Tipolocalidade_text.setText("Local Type: Residential High Density");
            
                                            break;
        
                                            case "rl":
                                            Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                            break;
        
                                            case "rp":
                                            Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                            break;
        
                                            case "rm":
                                            Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                            break;
                                        
                                            default:
                                            Tipolocalidade_text.setText("Local Type: No Information");
                                                break;
                                        }
                                        //setar tipo alojamento
                                        switch (sequenciarespostas.get("Q5").toString()) {
                                            case "n1Fam":
                                            TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                            break;
        
                                            case "n2fmCon":
                                            TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                            break;
        
                                            case "duplex":
                                            TipoAlojamento_text.setText("Property type: Duplex");     
                                            break;
        
                                            case "twnhse":
                                            TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                            break;
        
                                            case "twnhs":
                                            TipoAlojamento_text.setText("Property type: Townhouse ");     
                                            break;
                                            
                                            case "twnhsi":
                                            TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                            break;
         
                                            default:
                                            TipoAlojamento_text.setText("No Information");
                                             break;
                                        }
                                        //setar material telhado
                                        switch (sequenciarespostas.get("Q6").toString()) {
                                            case "flat":
                                            MaterialTelhado_text.setText("Roof Style: Flat");
                                            break;
                                            case "gable":
                                            MaterialTelhado_text.setText("Roof Style: Gable"); 
                                            break;
                                            case "gambrel":
                                            MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                            break;
        
                                            case "hip":
                                            MaterialTelhado_text.setText("Roof Style: Hip"); 
                                            break;
          
                                            case "mansard":
                                            MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                            break;
        
                                            case "shed":
                                            MaterialTelhado_text.setText("Roof Style: shed"); 
                                            break;
                                        
                                            default:
                                            MaterialTelhado_text.setText("Roof Style: No Information"); 
                                            break;
                                        }
                                        //setar material telhado
                                        MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
        
                                        switch (sequenciarespostas.get("Q7").toString()) {
                                            case "asbShng":
                                            MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                                break;
                                                case "asphshn":
                                                MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                                break;
                                                case "brkcomm":
                                                MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                                break;
                                                case "brkface":
                                                MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                                break;
        
                                                case "cblock":
                                                MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                                break;
        
                                                case "cemntbd":
                                                MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                                break;
        
                                                case "hdboard":
                                                MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                                break;
        
                                                case "imstucc":
                                                MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                                break;
        
                                                case "metalsd":
                                                MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                                break;
        
                                                case "other":
                                                MaterialExterior_text.setText("Exterior Material: Other");  
                                                break;
        
                                                case "plywood":
                                                MaterialExterior_text.setText("Exterior Material: Plywood");  
                                                break;
        
                                                case "precast":
                                                MaterialExterior_text.setText("Exterior Material: PreCast");  
                                                break;
        
                                                case "stone":
                                                MaterialExterior_text.setText("Exterior Material: Stone");  
                                                break;
        
                                                case "stucco":
                                                MaterialExterior_text.setText("Exterior Material: Stucco");  
                                                break;
        
                                                case "vinylsd":
                                                MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                                break;
        
                                                case "wdsdng":
                                                MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                                break;
        
                                                case "wdshing":
                                                MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                                break;
                                        
                                            default:
                                            MaterialExterior_text.setText("Exterior Material: No Information");
                                                break;
                                        }
                                        
        
                                        // Setar Pool
                                        if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                            Piscina_text.setText("Pool?: No");
                                        }else{
                                            Piscina_text.setText("Pool?: Yes");
                                        }
                                        //setar tamanho casa
                                        TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                        switch (sequenciarespostas.get("Q9").toString()) {
                                            case "20":
                                            TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                                break;
        
                                                case "30":
                                                TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                                break;
        
                                                case "40":
                                                TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                                break;
        
                                                case "45":
                                                TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                                break;
        
                                                case "50":
                                                TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                                break;
        
                                                case "60":
                                                TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                                break;
        
                                                case "70":
                                                TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                                break;
        
                                                case "75":
                                                TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                                break;
        
                                                case "80":
                                                TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                                break;
        
                                                case "85":
                                                TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                                break;
        
                                                case "90":
                                                TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                                break;
        
                                                case "120":
                                                TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                                break;
        
                                                case "150":
                                                TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                                break;
        
                                                case "160":
                                                TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                                break;
        
                                                case "180":
                                                TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                                break;
        
                                                case "190":
                                                TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                                break;
                                        
                                            default:
                                            TamanhoCasa_text.setText("Home type: No Information");
                                                break;
                                        }
                                
                                        //setar fogueira
                                        if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                            Fogueira.setText("Fireplace?: Yes");
                                        }else{
                                            Fogueira.setText("Fireplace?: No");  
                                        }
        
                                        //setar qualidade material exterior
                                        switch (sequenciarespostas.get("Q11").toString()) {
                                            case "ex":
                                            QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                                break;
                                            case "gd":
                                            QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                            break;
        
                                            case "ta":
                                            QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                            break;
        
                                            case "fa":
                                            QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                            break;
        
                                            case "po":
                                            QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                            break;
                                        
                                            default:
                                            QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                            break;
                                        }
        
                                        //setar condicao do material exterior
                                        switch (sequenciarespostas.get("Q12").toString()) {
                                            case "ex":
                                            CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                                break;
                                            case "gd":
                                            CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                            break;
        
                                            case "ta":
                                            CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                            break;
        
                                            case "fa":
                                            CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                            break;
        
                                            case "po":
                                            CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                            break;
                                        
                                            default:
                                            CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                            break;
                                        }
                                        //setar cidade
                                        switch (sequenciarespostas.get("Q13").toString()) {
                                            case "blmngtn":
                                                Cidade.setText("City: Bloomington Heights");
                                                break;
        
                                                case "blueste":
                                                Cidade.setText("City: Bluestem");
                                                break;
        
                                                case "brdale":
                                                Cidade.setText("City: Briardale");
                                                break;
        
                                                case "brkside":
                                                Cidade.setText("City: Brookside");
                                                break;
        
                                                case "clearcr":
                                                Cidade.setText("City: Clear Creek");
                                                break;
        
                                                case "collgcr":
                                                Cidade.setText("City: College Creek");
                                                break;
        
                                                case "crawfor":
                                                Cidade.setText("City: Crawford");
                                                break;
        
                                                case "edwards":
                                                Cidade.setText("City: Edwards");
                                                break;
        
                                                case "gilbert":
                                                Cidade.setText("City: Gilbert");
                                                break;
        
                                                case "idotrr":
                                                Cidade.setText("City: Iowa DOT and Rail Road");
                                                break;
        
                                                case "meadowv":
                                                Cidade.setText("City: Meadow Village");
                                                break;
        
                                                case "mitchel":
                                                Cidade.setText("City: Mitchell");
                                                break;
        
                                                case "names":
                                                Cidade.setText("City: North Ames");
                                                break;
        
                                                case "noridge":
                                                Cidade.setText("City: Northridge");
                                                break;
        
                                                case "npkvill":
                                                Cidade.setText("City: Northpark Villa");
                                                break;
        
                                                case "nridght":
                                                Cidade.setText("City: Northridge Heights");
                                                break;
        
                                                case "nwames":
                                                Cidade.setText("City: Northwest Ames");
                                                break;
        
                                                case "oldtown":
                                                Cidade.setText("City: Old Town");
                                                break;
        
                                                case "swisu":
                                                Cidade.setText("City: South & West of Iowa State University");
                                                break;
        
                                                case "sawyer":
                                                Cidade.setText("City: Sawyer");
                                                break;
        
                                                case "sawyerw":
                                                Cidade.setText("City: Sawyer West");
                                                break;
        
                                                case "somerst":
                                                Cidade.setText("City: Somerset");
                                                break;
        
                                                case "stonebr":
                                                Cidade.setText("City: Stone Brook");
                                                break;
        
                                                case "timber":
                                                Cidade.setText("City: Timberland");
                                                break;
        
                                                case "veenker":
                                                Cidade.setText("City: Veenker");
                                                break;
                                        
                                            default:
                                            Cidade.setText("City: No Information");
                                                break;
                                        }
        
                                        }
                                    });

                                    top5_op.addMouseListener(
                                        new MouseAdapter(){
                                            public void mouseEntered(MouseEvent e){
                                                //Query para ir buscar dados do Id1
                                            Query query_update=new Query("get_descri("+resposta_op.get("Id5").toString()+",Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14).");
                                            Map<String,Term> sequenciarespostas= query_update.oneSolution();
                                            //mudar preco
                                            preco_text.setText("Price: "+sequenciarespostas.get("Q14")+"$");
                                            //mudar Qualidade
                                            Qualidadegeral_text.setText("House Quality 0-10: "+sequenciarespostas.get("Q1"));
                                            //setar condicao
                                            Condicaogeral_text.setText("House Condition 0-10: "+sequenciarespostas.get("Q2"));
            
                                            //setar qualidade da cozinha
                                            switch (sequenciarespostas.get("Q3").toString()) {
                                                case "ex":
                                                Qualidadecozinha_text.setText("Kitchen Quality: Excellent");
                                                    break;
                                                case "gd":
                                                Qualidadecozinha_text.setText("Kitchen Quality: Good");
                                                break;
            
                                                case "ta":
                                                Qualidadecozinha_text.setText("Kitchen Quality: Typical/Average");  
                                                break;
            
                                                case "fa":
                                                Qualidadecozinha_text.setText("Kitchen Quality: Fair");
                                                break;
            
                                                case "po":
                                                Qualidadecozinha_text.setText("Kitchen Quality: Poor"); 
                                                break;
                                            
                                                default:
                                                Qualidadecozinha_text.setText("Kitchen Quality: No Information");
                                                break;
                                            }
            
                                            //setar tipo localidade
                                            switch (sequenciarespostas.get("Q4").toString()) {
            
                                                case "a":
                                                Tipolocalidade_text.setText("Local Type: Agriculture");    
                                                break;
                                                case "c":
                                                Tipolocalidade_text.setText("Local Type: Commercial");    
                                                break;
            
                                                case "fv":
                                                Tipolocalidade_text.setText("Local Type: Floating Village Residential"); 
                                                break;
            
                                                case "i":
                                                Tipolocalidade_text.setText("Local Type: Industrial");    
                                                break;
            
                                                case "rh":
                                                Tipolocalidade_text.setText("Local Type: Residential High Density");
                
                                                break;
            
                                                case "rl":
                                                Tipolocalidade_text.setText("Local Type: Residential Low Density");
                                                break;
            
                                                case "rp":
                                                Tipolocalidade_text.setText("Local Type: Residential Low Density Park");
                                                break;
            
                                                case "rm":
                                                Tipolocalidade_text.setText("Local Type: Residential Medium Density");  
                                                break;
                                            
                                                default:
                                                Tipolocalidade_text.setText("Local Type: No Information");
                                                    break;
                                            }
                                            //setar tipo alojamento
                                            switch (sequenciarespostas.get("Q5").toString()) {
                                                case "n1Fam":
                                                TipoAlojamento_text.setText("Property type: Single-Family Detached"); 
                                                break;
            
                                                case "n2fmCon":
                                                TipoAlojamento_text.setText("Property type: Two-Family Conversion"); 
                                                break;
            
                                                case "duplex":
                                                TipoAlojamento_text.setText("Property type: Duplex");     
                                                break;
            
                                                case "twnhse":
                                                TipoAlojamento_text.setText("Property type: Townhouse End Unit");     
                                                break;
            
                                                case "twnhs":
                                                TipoAlojamento_text.setText("Property type: Townhouse ");     
                                                break;
                                                
                                                case "twnhsi":
                                                TipoAlojamento_text.setText("Townhouse Inside Unit"); 
                                                break;
             
                                                default:
                                                TipoAlojamento_text.setText("No Information");
                                                 break;
                                            }
                                            //setar material telhado
                                            switch (sequenciarespostas.get("Q6").toString()) {
                                                case "flat":
                                                MaterialTelhado_text.setText("Roof Style: Flat");
                                                break;
                                                case "gable":
                                                MaterialTelhado_text.setText("Roof Style: Gable"); 
                                                break;
                                                case "gambrel":
                                                MaterialTelhado_text.setText("Roof Style: Gabrel (Barn)"); 
                                                break;
            
                                                case "hip":
                                                MaterialTelhado_text.setText("Roof Style: Hip"); 
                                                break;
              
                                                case "mansard":
                                                MaterialTelhado_text.setText("Roof Style: Mansard"); 
                                                break;
            
                                                case "shed":
                                                MaterialTelhado_text.setText("Roof Style: shed"); 
                                                break;
                                            
                                                default:
                                                MaterialTelhado_text.setText("Roof Style: No Information"); 
                                                break;
                                            }
                                            //setar material telhado
                                            MaterialExterior_text.setText("Exterior Material-"+sequenciarespostas.get("Q7"));
            
                                            switch (sequenciarespostas.get("Q7").toString()) {
                                                case "asbShng":
                                                MaterialExterior_text.setText("Exterior Material: Asbestos Shingles");  
                                                    break;
                                                    case "asphshn":
                                                    MaterialExterior_text.setText("Exterior Material: Asphalt Shingles");  
                                                    break;
                                                    case "brkcomm":
                                                    MaterialExterior_text.setText("Exterior Material: Brick Common");  
                                                    break;
                                                    case "brkface":
                                                    MaterialExterior_text.setText("Exterior Material: Brick Face");  
                                                    break;
            
                                                    case "cblock":
                                                    MaterialExterior_text.setText("Exterior Material: Cinder Block");  
                                                    break;
            
                                                    case "cemntbd":
                                                    MaterialExterior_text.setText("Exterior Material: Cement Board");  
                                                    break;
            
                                                    case "hdboard":
                                                    MaterialExterior_text.setText("Exterior Material: Hard Board");  
                                                    break;
            
                                                    case "imstucc":
                                                    MaterialExterior_text.setText("Exterior Material: Imitation Stucco");  
                                                    break;
            
                                                    case "metalsd":
                                                    MaterialExterior_text.setText("Exterior Material: Metal Siding");  
                                                    break;
            
                                                    case "other":
                                                    MaterialExterior_text.setText("Exterior Material: Other");  
                                                    break;
            
                                                    case "plywood":
                                                    MaterialExterior_text.setText("Exterior Material: Plywood");  
                                                    break;
            
                                                    case "precast":
                                                    MaterialExterior_text.setText("Exterior Material: PreCast");  
                                                    break;
            
                                                    case "stone":
                                                    MaterialExterior_text.setText("Exterior Material: Stone");  
                                                    break;
            
                                                    case "stucco":
                                                    MaterialExterior_text.setText("Exterior Material: Stucco");  
                                                    break;
            
                                                    case "vinylsd":
                                                    MaterialExterior_text.setText("Exterior Material: Vinyl Siding");  
                                                    break;
            
                                                    case "wdsdng":
                                                    MaterialExterior_text.setText("Exterior Material: Wood Siding");  
                                                    break;
            
                                                    case "wdshing":
                                                    MaterialExterior_text.setText("Exterior Material: Wood Shingles");  
                                                    break;
                                            
                                                default:
                                                MaterialExterior_text.setText("Exterior Material: No Information");
                                                    break;
                                            }
                                            
            
                                            // Setar Pool
                                            if (sequenciarespostas.get("Q8").toString().equals("na")) {
                                                Piscina_text.setText("Pool?: No");
                                            }else{
                                                Piscina_text.setText("Pool?: Yes");
                                            }
                                            //setar tamanho casa
                                            TamanhoCasa_text.setText("Home type-"+sequenciarespostas.get("Q9"));
                                            switch (sequenciarespostas.get("Q9").toString()) {
                                                case "20":
                                                TamanhoCasa_text.setText("Home type: 1-STORY 1946 & NEWER ALL STYLES");
                                                    break;
            
                                                    case "30":
                                                    TamanhoCasa_text.setText("Home type: 1-STORY 1945 & OLDER");
                                                    break;
            
                                                    case "40":
                                                    TamanhoCasa_text.setText("Home type: 1-STORY W/FINISHED ATTIC ALL AGES");
                                                    break;
            
                                                    case "45":
                                                    TamanhoCasa_text.setText("Home type: 1-1/2 STORY - UNFINISHED ALL AGES");
                                                    break;
            
                                                    case "50":
                                                    TamanhoCasa_text.setText("Home type: 1-1/2 STORY FINISHED ALL AGES");
                                                    break;
            
                                                    case "60":
                                                    TamanhoCasa_text.setText("Home type: 2-STORY 1946 & NEWER");
                                                    break;
            
                                                    case "70":
                                                    TamanhoCasa_text.setText("Home type: 2-STORY 1945 & OLDER");
                                                    break;
            
                                                    case "75":
                                                    TamanhoCasa_text.setText("Home type: 2-1/2 STORY ALL AGES");
                                                    break;
            
                                                    case "80":
                                                    TamanhoCasa_text.setText("Home type: SPLIT OR MULTI-LEVEL");
                                                    break;
            
                                                    case "85":
                                                    TamanhoCasa_text.setText("Home type: SPLIT FOYER");
                                                    break;
            
                                                    case "90":
                                                    TamanhoCasa_text.setText("Home type: DUPLEX - ALL STYLES AND AGES");
                                                    break;
            
                                                    case "120":
                                                    TamanhoCasa_text.setText("Home type: STORY PUD (Planned Unit Development)");
                                                    break;
            
                                                    case "150":
                                                    TamanhoCasa_text.setText("Home type: 1-1/2 STORY PUD - ALL AGES");
                                                    break;
            
                                                    case "160":
                                                    TamanhoCasa_text.setText("Home type: 2-STORY PUD - 1946 & NEWER");
                                                    break;
            
                                                    case "180":
                                                    TamanhoCasa_text.setText("Home type: PUD-MULTILEVEL-INCL SPLIT LEV/FOYER");
                                                    break;
            
                                                    case "190":
                                                    TamanhoCasa_text.setText("Home type: 2 FAMILY CONVERSION - ALL STYLES AND AGES");
                                                    break;
                                            
                                                default:
                                                TamanhoCasa_text.setText("Home type: No Information");
                                                    break;
                                            }
                                    
                                            //setar fogueira
                                            if (Integer.valueOf(sequenciarespostas.get("Q10").toString())>0) {
                                                Fogueira.setText("Fireplace?: Yes");
                                            }else{
                                                Fogueira.setText("Fireplace?: No");  
                                            }
            
                                            //setar qualidade material exterior
                                            switch (sequenciarespostas.get("Q11").toString()) {
                                                case "ex":
                                                QualidadeMaterialExterior.setText("Exterior Quality: Excellent");
                                                    break;
                                                case "gd":
                                                QualidadeMaterialExterior.setText("Exterior Quality: Good");
                                                break;
            
                                                case "ta":
                                                QualidadeMaterialExterior.setText("Exterior Quality: Typical/Average");  
                                                break;
            
                                                case "fa":
                                                QualidadeMaterialExterior.setText("Exterior Quality: Fair");
                                                break;
            
                                                case "po":
                                                QualidadeMaterialExterior.setText("Exterior Quality: Poor"); 
                                                break;
                                            
                                                default:
                                                QualidadeMaterialExterior.setText("Exterior Quality: No Information");
                                                break;
                                            }
            
                                            //setar condicao do material exterior
                                            switch (sequenciarespostas.get("Q12").toString()) {
                                                case "ex":
                                                CondicaoMaterialExterior.setText("Exterior Condition: Excellent");
                                                    break;
                                                case "gd":
                                                CondicaoMaterialExterior.setText("Exterior Condition: Good");
                                                break;
            
                                                case "ta":
                                                CondicaoMaterialExterior.setText("Exterior Condition: Typical/Average");  
                                                break;
            
                                                case "fa":
                                                CondicaoMaterialExterior.setText("Exterior Condition: Fair");
                                                break;
            
                                                case "po":
                                                CondicaoMaterialExterior.setText("Exterior Condition: Poor"); 
                                                break;
                                            
                                                default:
                                                CondicaoMaterialExterior.setText("Exterior Condition: No Information");
                                                break;
                                            }
                                            //setar cidade
                                            switch (sequenciarespostas.get("Q13").toString()) {
                                                case "blmngtn":
                                                    Cidade.setText("City: Bloomington Heights");
                                                    break;
            
                                                    case "blueste":
                                                    Cidade.setText("City: Bluestem");
                                                    break;
            
                                                    case "brdale":
                                                    Cidade.setText("City: Briardale");
                                                    break;
            
                                                    case "brkside":
                                                    Cidade.setText("City: Brookside");
                                                    break;
            
                                                    case "clearcr":
                                                    Cidade.setText("City: Clear Creek");
                                                    break;
            
                                                    case "collgcr":
                                                    Cidade.setText("City: College Creek");
                                                    break;
            
                                                    case "crawfor":
                                                    Cidade.setText("City: Crawford");
                                                    break;
            
                                                    case "edwards":
                                                    Cidade.setText("City: Edwards");
                                                    break;
            
                                                    case "gilbert":
                                                    Cidade.setText("City: Gilbert");
                                                    break;
            
                                                    case "idotrr":
                                                    Cidade.setText("City: Iowa DOT and Rail Road");
                                                    break;
            
                                                    case "meadowv":
                                                    Cidade.setText("City: Meadow Village");
                                                    break;
            
                                                    case "mitchel":
                                                    Cidade.setText("City: Mitchell");
                                                    break;
            
                                                    case "names":
                                                    Cidade.setText("City: North Ames");
                                                    break;
            
                                                    case "noridge":
                                                    Cidade.setText("City: Northridge");
                                                    break;
            
                                                    case "npkvill":
                                                    Cidade.setText("City: Northpark Villa");
                                                    break;
            
                                                    case "nridght":
                                                    Cidade.setText("City: Northridge Heights");
                                                    break;
            
                                                    case "nwames":
                                                    Cidade.setText("City: Northwest Ames");
                                                    break;
            
                                                    case "oldtown":
                                                    Cidade.setText("City: Old Town");
                                                    break;
            
                                                    case "swisu":
                                                    Cidade.setText("City: South & West of Iowa State University");
                                                    break;
            
                                                    case "sawyer":
                                                    Cidade.setText("City: Sawyer");
                                                    break;
            
                                                    case "sawyerw":
                                                    Cidade.setText("City: Sawyer West");
                                                    break;
            
                                                    case "somerst":
                                                    Cidade.setText("City: Somerset");
                                                    break;
            
                                                    case "stonebr":
                                                    Cidade.setText("City: Stone Brook");
                                                    break;
            
                                                    case "timber":
                                                    Cidade.setText("City: Timberland");
                                                    break;
            
                                                    case "veenker":
                                                    Cidade.setText("City: Veenker");
                                                    break;
                                            
                                                default:
                                                Cidade.setText("City: No Information");
                                                    break;
                                            }
            
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
                        Tipolocalidade_text.setBounds((int)(window_width*0.43), (int)(window_height*0.30),500,100);
                        TipoAlojamento_text.setBounds((int)(window_width*0.43), (int)(window_height*0.35),500,100);
                        MaterialTelhado_text.setBounds((int)(window_width*0.43), (int)(window_height*0.40),200,100);
                        MaterialExterior_text.setBounds((int)(window_width*0.43), (int)(window_height*0.45),200,100);
                        Piscina_text.setBounds((int)(window_width*0.43), (int)(window_height*0.50),200,100);
                        TamanhoCasa_text.setBounds((int)(window_width*0.43), (int)(window_height*0.55),500,100);
                        Fogueira.setBounds((int)(window_width*0.43), (int)(window_height*0.60),200,100);
                        QualidadeMaterialExterior.setBounds((int)(window_width*0.43), (int)(window_height*0.65),200,100);
                        CondicaoMaterialExterior.setBounds((int)(window_width*0.43), (int)(window_height*0.70),300,100);
                        Cidade.setBounds((int)(window_width*0.43), (int)(window_height*0.75),500,100);

                        //setar cords top5 normal
                        some_text.setBounds((int)(window_width*0.20), (int)(window_height*0.05),500,30);
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
                        some_text.setBounds((int)(window_width*0.20), (int)(window_height*0.05),500,30);
                        top5_text.setBounds((int)(window_width*0.40), (int)(window_height*0.15),100,15);
                        top1.setBounds((int)(window_width*0.40), (int)(window_height*0.25),70,10);
                        top2.setBounds((int)(window_width*0.40), (int)(window_height*0.35),70,10);
                        top3.setBounds((int)(window_width*0.40), (int)(window_height*0.45),70,10);
                        top4.setBounds((int)(window_width*0.40), (int)(window_height*0.55),70,10);
                        top5.setBounds((int)(window_width*0.40), (int)(window_height*0.65),70,10);
                        //Setar coords do title
                        car_text.setBounds((int)(window_width*0.50), (int)(window_height*0.05),200,100);
                        preco_text.setBounds((int)(window_width*0.50), (int)(window_height*0.10),200,100);
                        Qualidadegeral_text.setBounds((int)(window_width*0.50), (int)(window_height*0.15),200,100);
                        Condicaogeral_text.setBounds((int)(window_width*0.50), (int)(window_height*0.20),200,100);
                        Qualidadecozinha_text.setBounds((int)(window_width*0.50), (int)(window_height*0.25),200,100);
                        Tipolocalidade_text.setBounds((int)(window_width*0.50), (int)(window_height*0.30),500,100);
                        TipoAlojamento_text.setBounds((int)(window_width*0.50), (int)(window_height*0.35),500,100);
                        MaterialTelhado_text.setBounds((int)(window_width*0.50), (int)(window_height*0.40),500,100);
                        Piscina_text.setBounds((int)(window_width*0.50), (int)(window_height*0.45),200,100);
                        TamanhoCasa_text.setBounds((int)(window_width*0.50), (int)(window_height*0.50),800,100);
                        Fogueira.setBounds((int)(window_width*0.50), (int)(window_height*0.55),200,100);
                        QualidadeMaterialExterior.setBounds((int)(window_width*0.50), (int)(window_height*0.60),200,100);
                        CondicaoMaterialExterior.setBounds((int)(window_width*0.50), (int)(window_height*0.65),300,100);
                        Cidade.setBounds((int)(window_width*0.50), (int)(window_height*0.70),500,100);

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
