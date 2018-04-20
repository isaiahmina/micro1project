/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

/**
 *
 * @author Isaiah
 */
public class Memory {
    String[] cell;     //holds the commands, read from the file
    int cap;
    public Memory (int cap){
        this.cap=cap;
        cell=new String[cap];
    }   
    //reads the command at cell[i] and returns for processor to use;
    //returns the hexadecimal number representation(where 10=16;hexa to tenary)
    /**
     * reads what is in the cell of memory
     * @param i index of memory you want to read
     * @return a string of the content in memory of that specific cell
     */
    public String read(int i){ 
        return (cell[i]); //try to keep the filler zeros;will truncate it in runcCommand
    }
    public void write(int address, String data){
        cell[address] = (data);
    }
    public void dump(){ //print out memory values
        for(int i =0;i<cell.length;i++){
            System.out.println("Memory cell["+i+"] = "+cell[i]);
        }
    }
}
