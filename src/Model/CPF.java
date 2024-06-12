
package Model;

public class CPF {
    public static boolean Validar_cpf (String CPF){
       int num1; int num2; int num3; int num4; int num5; int num6; int num7; int num8; int num9; int num10;
       int num11; int soma1; int soma2; int restoSoma1 ; int restoSoma2; 
     
       if (CPF == null || CPF.length()!=11 ){
           return false; }
       
        CPF = CPF.replaceAll("\\D"," ");
        
        num1 = Character.getNumericValue(CPF.charAt(0));
        num2 = Character.getNumericValue(CPF.charAt(1));
        num3 = Character.getNumericValue(CPF.charAt(2));
        num4 = Character.getNumericValue(CPF.charAt(3));
        num5 = Character.getNumericValue(CPF.charAt(4));
        num6 = Character.getNumericValue(CPF.charAt(5));
        num7 = Character.getNumericValue(CPF.charAt(6));
        num8 = Character.getNumericValue(CPF.charAt(7));
        num9 = Character.getNumericValue(CPF.charAt(8));
        num10 = Character.getNumericValue(CPF.charAt(9));
        num11 = Character.getNumericValue(CPF.charAt(10));
        
        if (num1 == num2 && num2 == num3 && num3 == num4 && num4 == num5 && num5 == num6 && num6 == num7 && num7 == num8 &&
             num8 == num9 && num9 == num10 && num10 == num11) {
            return false;
        } 
            soma1 = (num1*10) + (num2 *9) + (num3 * 8) + (num4*7) + (num5*6) + (num6*5) + (num7*4) + (num8*3) + (num9*2);
            restoSoma1 = (soma1 * 10) % 11;
            if (restoSoma1 == 10 ){
                restoSoma1 = 0; 
            }
            soma2 = (num1*11) + (num2 *10) + (num3 * 9) + (num4*8) + (num5*7) + (num6*6) + (num7*5) + (num8*4) + (num9*3) + (num10*2);
            restoSoma2 = (soma2 *10) % 11;
            if(restoSoma2 == 10){
                restoSoma2 = 0;
            }
            if(restoSoma1 == num10 && restoSoma2 == num11){
                return true;
            } else {
                return false;
            }
                
    }
}
