/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missingnumbers;

/**
 *
 * @author mark harrington 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SequentialCheck {
    
  File m_file    ;
  
  
            int maxlen = 0;
            String[] textFile ; 
            int [] numbers  ;
            Scanner sc;  
            int idx = 1 ; 
           
          

    public SequentialCheck(){
        
        numbers = new int[496];
        textFile = new String[596] ;
        
        this.readNumbersfile("numbers.txt");
        
        
    }
    
    
    public int[] getNumbersArray()
    {
        
        return this.numbers ;
    }
            
    
    public int getArrayLength()
    {
        return  numbers.length ;
    }
    
    
    public void checkSequence(int array[])
    {
        
        int numb1 , numb2 ;
        int answer = 0 ; 
        
                do {
                    
                    numb1 = array[idx-1]; 
                    numb2 = array[idx] ;
                    answer = numb2 - numb1 ; 
                   // System.out.println("Numb2 @ idx - Numb1  @ idx " + "Numb2 " + (idx-1) + " Numb1 " + idx + " = " + answer);
                    
                    
                    if (answer != 1){
                        
                       System.out.println("Found numbers out of sequence  " +  " numb2 " + numb2 + " @ " + idx);
                         
                        
                    }
                     idx +=1 ;
                    
                    
                    
                    
                }while(idx < maxlen ) ; 
        
        
    }
         
    
    
    
    
     private void readNumbersfile(String f)
     {
         
         
         m_file = new File(f);
        
                   
                try {
                    sc = new Scanner(m_file);
                        while(sc.hasNextLine())
                            {
                                String line = sc.nextLine();
                                textFile = line.split(","); 
            
         
                            }
        
                maxlen = textFile.length ;
                
                
        
        for(int i = 0 ;i < maxlen ; i++)
        {
             numbers[i]= Integer.parseInt(textFile[i]) ;
             System.out.print(numbers[i]+ " ");
             System.out.println("");
        }
        
        } catch (FileNotFoundException ex) {
            
        
             Logger.getLogger(SequentialCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
     }
     
        
    public static void main(String[] args) {
        
             // TODO code application logic here
      
      SequentialCheck M = new SequentialCheck();
             
      M.checkSequence(M.getNumbersArray());
      
     
      
    }
    
}
