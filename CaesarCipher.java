
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author Will Luttmann 
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    
    
    public static String encrypt(int key, String plaintext){
        String ciphertext = "";
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] alpha = str.toCharArray();
        
        plaintext = plaintext.toLowerCase();
        
        for(int i=0; i < plaintext.length(); i++){
            char p = plaintext.charAt(i);
            char c;
            
            if(Character.isLetter(p)){
                int x = str.indexOf(p); //finds index of char in alphabet
                x = (key + x) % 26; //add key and mod 26 for ciphertext
                c = alpha[x]; //sets c to cipher letter
            }else{
                c = p;
            }
            
            ciphertext += c; //add char to string
            
        }
        
        return ciphertext;
    }
    
    public static String decrypt (int key, String ciphertext){
        String plaintext = "";
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] alpha = str.toCharArray();
        
        ciphertext = ciphertext.toLowerCase();
        
        for(int i=0; i < ciphertext.length(); i++){
            char c = ciphertext.charAt(i);
            char p;
            
            if (Character.isLetter(c)){
                int x = str.indexOf(c); //finds index of char in alphabet
                
                if(x-key >= 0){
                    x = (x - key) % 26; // index - key mod 26 for ciphertext
                } else {
                    x = (x-key) + 26; //i did it this way because java was saying
                                      // -9 mod 26 = -9 which is incorrect
                }
                
                p = alpha[x]; //sets p to plaintext letter
            }else{
                p = c;
            }
            
            plaintext += p; //add char to string
            
        }
        
        return plaintext;
    }
   
    
    public static void bruteForce(String ciphertext){
        String plaintext;
        
        for(int i=0; i < 26; i++){
            plaintext = decrypt(i,ciphertext);
            
            System.out.println("key: " + i + " decryption: " + plaintext);
        }
        System.out.println();
    }
    
    public static void bruteForce(String ciphertext, String keyword){
        String plaintext;
        
        for(int i=0; i < 26; i++){
            plaintext = decrypt(i,ciphertext);
            
            if (plaintext.contains(keyword)){
                System.out.println("key: " + i + " decryption: " + plaintext);
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args){
        
      String string1 = "Get me a vanilla ice cream, make it a double.";
      System.out.println(string1);
      string1 = encrypt(6, string1);
      System.out.println(string1);
      System.out.println();
      
      String string2 = "I don't much care for Leonard Cohen.";
      System.out.println(string2);
      string2 = encrypt(15, string2);
      System.out.println(string2);
      System.out.println();
      
      String string3 = "I like root beer floats.";
      System.out.println(string3);
      string3 = encrypt(16, string3);
      System.out.println(string3);
      System.out.println();
      
      String string4 = "NDUZS FTQ BUZQ OAZQE.";
      System.out.println(string4);
      string4 = decrypt(12, string4);
      System.out.println(string4);
      System.out.println();
      
      String string5 = "FDHVDU QHHGV WR ORVH ZHLJKW.";
      System.out.println(string5);
      string5 = decrypt(3, string5);
      System.out.println(string5);
      System.out.println();
      
      String string6 = "UFGIHXM ULY NUMNYS.";
      System.out.println(string6);
      string6 = decrypt(20, string6);
      System.out.println(string6);
      System.out.println();
     
      System.out.println("String = GRYY GURZ GB TB GB NZOEBFR PUNCRY., Keyword = 'chapel'");
      bruteForce("GRYY GURZ GB TB GB NZOEBFR PUNCRY.","chapel");
      
      System.out.println("String = WZIV KYV JYFK NYVE KYV TPDSRCJ TIRJY., Keyword = 'cymbal'");
      bruteForce("WZIV KYV JYFK NYVE KYV TPDSRCJ TIRJY.","cymbal");
      
      System.out.println("String = BAEEQ KLWOSJL OSK S ESF OZG CFWO LGG EMUZ., Keyword =  none");
      bruteForce("BAEEQ KLWOSJL OSK S ESF OZG CFWO LGG EMUZ.");
    }
}   

