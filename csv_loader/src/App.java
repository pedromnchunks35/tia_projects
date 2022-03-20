import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
/*    NOTAS IMPORTANTES

      Nas carateristicas ter em conta que foram trocados "." por "_" em strings com numeros (colocou-se um n atras tambem) - COLUNA 16/17
      Tem strings em que foram removidos espaços entre elas e em que foram removidos os "&"

*/



    /*CLEAR DATA FUNC*/
    public static String clear(String data){

   /*verificar se o campo esta vazio ou nao.. se estiver o valor passa a ser empty*/
   if(data.equals("")){

       /*RETORNAR STRING EMPTY*/
       return "empty";

   }else{

   /*VERIFICAR SE A STRING É UM NUMERO*/
   try {

      /*converter para float*/ 
      Float.parseFloat(data); 
      /*fazer return de data sem alteracoes*/
      return data;

   } catch (Exception nao_numero) {

    /*VERIFICAR SE O PRIMEIRO CHAR É UM NUMERO*/
    if(Character.isDigit(data.charAt(0))){
        
        /*verificar se o segundo caracter é um ponto. Se for , substituir por _*/
        if(Character.toString(data.charAt(1)).equals(".")){

            /*substituir*/
            return "n"+data.replace(".","_");

        }else{

            /*substituir*/
            return "n"+data;
        }
        
    } else {

    /*deu exception entao nao é um numero portanto vamos colocar lower case e remover espacos entre as str e remover os &*/
    return data.toLowerCase().replaceAll("\\s","").replace("&","");

    }


   }
   }




    }

    public static void main(String[] args) throws Exception {
        
        /*PATH DO CSV*/
        String path ="houses.csv";

        /*Linha que vai ser lida*/
        String line = "";

        /*Instanciar local do ficheiro*/
        File file_first = new File("../../project_A/src/bd.pl");

        /*VERIFICAR SE O FILE EXISTE.. SE NAO EXISTIR CRIA UM E ESCREVE SENAO NAO ESCREVE NADA*/
        if(file_first.createNewFile()){

        /*escritor que vai ser usado la em baixo para escrever*/
        FileWriter mywriter = new FileWriter("../../project_A/src/bd.pl");

        /*MSG DE COMEÇO*/
        System.out.println("**INICIALIZANDO A ESCRITA**");

        /*Buffer que vai ler o csv a exception esta em cima ja*/
        BufferedReader br = new BufferedReader(new FileReader(path));
        
        /*fazer uma leitura antes de iterar para esquecer a primeira linha*/
        br.readLine();

        /*iterar*/
        while ((line=br.readLine())!=null) {

            /*Armazenar num array de Strings em que cada uma corresponde a uma string separada por virgulas*/
            String[] values = line.split(",");
            /*
            VALUES 0 - id que o martins pos sem querer
            VALUES 1 - id já existente na tabela
            VALUES 2 - MSSubClass
            VALUES 3 - MSZoning
            VALUES 4 - LotFrontage
            VALUES 5 - LotArea
            VALUES 6 - Street
            VALUES 7 - Alley
            VALUES 8 - LotShape
            VALUES 9 - LandContour
            VALUES 10 - Utilities
            VALUES 11 - LotConfig
            VALUES 12 - LandSlope
            VALUES 13 - Neighborhood
            VALUES 14 - Condition1
            VALUES 15 - Condition2
            VALUES 16 - BldgType
            VALUES 17 - HouseStyle
            VALUES 18 - OverallQual
            VALUES 19 - OverallCond
            VALUES 20 - YearBuilt
            VALUES 21 - YearRemodAdd
            VALUES 22 - RoofStyle
            VALUES 23 - RoofMatl
            VALUES 24 - Exterior1st
            VALUES 25 - Exterior2nd
            VALUES 26 - MasVnrType
            VALUES 27 - MasVnrArea
            VALUES 28 - ExterQual
            VALUES 29 - ExterCond
            VALUES 30 - Foundation
            VALUES 31 - BsmtQual
            VALUES 32 - BsmtCond
            VALUES 33 - BsmtExposure
            VALUES 34 - BsmtFinType1
            VALUES 35 - BsmtFinSF1
            VALUES 36 - BsmtFinType2
            VALUES 37 - BsmtFinSF2
            VALUES 38 - BsmtUnfSF
            VALUES 39 - TotalBsmtSF
            VALUES 40 - Heating
            VALUES 41 - HeatingQC
            VALUES 42 - CentralAir
            VALUES 43 - Electrical
            VALUES 44 - 1stFlrSF
            VALUES 45 - 2ndFlrSF
            VALUES 46 - LowQualFinSF
            VALUES 47 - GrLivArea
            VALUES 48 - BsmtFullBath
            VALUES 49 - BsmtHalfBath
            VALUES 50 - FullBath
            VALUES 51 - HalfBath
            VALUES 52 - BedroomAbvGr
            VALUES 53 - KitchenAbvGr
            VALUES 54 - KitchenQual
            VALUES 55 - TotRmsAbvGrd
            VALUES 56 - Functional
            VALUES 57 - Fireplaces
            VALUES 58 - FireplaceQu
            VALUES 59 - GarageType
            VALUES 60 - GarageYrBlt
            VALUES 61 - GarageFinish
            VALUES 62 - GarageCars
            VALUES 63 - GarageArea
            VALUES 64 - GarageQual
            VALUES 65 - GarageCond
            VALUES 66 - PavedDrive
            VALUES 67 - WoodDeckSF
            VALUES 68 - OpenPorchSF
            VALUES 69 - EnclosedPorch
            VALUES 70 - 3SsnPorch
            VALUES 71 - ScreenPorch
            VALUES 72 - PoolArea
            VALUES 73 - PoolQC
            VALUES 74 - Fence
            VALUES 75 - MiscFeature
            VALUES 76 - MiscVal
            VALUES 77 - MoSold
            VALUES 78 - YrSold
            VALUES 79 - SaleType
            VALUES 80 - SaleCondition
            VALUES 81 - SalePrice            
            */
            
                /*nao criar nada porque ele já existe*/
                /*CONTINUAR A ESCREVER*/
                try {

                    /*escrever em si usando a funcao de cima clear que basicamente coloca os campos segundo a sintaxe prolog*/
                    mywriter.write("rentops("+clear(values[0])+","+clear(values[2])+","+clear(values[3])+","+clear(values[4])+","+clear(values[5])+","+clear(values[6])+","+clear(values[7])+","+clear(values[8])+","+clear(values[9])+","+clear(values[10])+","+clear(values[11])+","+clear(values[12])+","+clear(values[13])+","+clear(values[14])+","+clear(values[15])+","+clear(values[16])+","+clear(values[17])+","+clear(values[18])+","+clear(values[19])+","+clear(values[20])+","+clear(values[21])+","+clear(values[22])+","+clear(values[23])+","+clear(values[24])+","+clear(values[25])+","+clear(values[26])+","+clear(values[27])+","+clear(values[28])+","+clear(values[29])+","+clear(values[30])+","+clear(values[31])+","+clear(values[32])+","+clear(values[33])+","+clear(values[34])+","+clear(values[35])+","+clear(values[36])+","+clear(values[37])+","+clear(values[38])+","+clear(values[39])+","+clear(values[40])+","+clear(values[41])+","+clear(values[42])+","+clear(values[43])+","+clear(values[44])+","+clear(values[45])+","+clear(values[46])+","+clear(values[47])+","+clear(values[48])+","+clear(values[49])+","+clear(values[50])+","+clear(values[51])+","+clear(values[52])+","+clear(values[53])+","+clear(values[54])+","+clear(values[55])+","+clear(values[56])+","+clear(values[57])+","+clear(values[58])+","+clear(values[59])+","+clear(values[60])+","+clear(values[61])+","+clear(values[62])+","+clear(values[63])+","+clear(values[64])+","+clear(values[65])+","+clear(values[66])+","+clear(values[67])+","+clear(values[68])+","+clear(values[69])+","+clear(values[70])+","+clear(values[71])+","+clear(values[72])+","+clear(values[73])+","+clear(values[74])+","+clear(values[75])+","+clear(values[76])+","+clear(values[77])+","+clear(values[78])+","+clear(values[79])+","+clear(values[80])+","+clear(values[81])+").\n");

                } catch (Exception e) {

                    /*CASO DE ALGUM TIPO DE ERRO*/
                    System.out.println("**ALGO CORREU MAL COM A ESCRITA**");
                }
            
        }
        /*fechar escrita*/
        mywriter.close();

        /*fechar csv*/
        br.close();

        /*MENSAGEM DE SUCESSO*/
        System.out.println("**ESCRITA FEITA COM SUCESSO**");

        }else{
        /*MENSAGEM CASO O FICHEIRO JA EXISTA*/
        System.out.println("O file bd.pl ja existe..tem que o eliminar se pretende correr esta script novamente");
        }



    }
}
