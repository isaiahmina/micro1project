//this file holds the processor class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectCSCI;

/**
 *
 * @author Isaiah
 */
public class Processor /*extends memory?*/ {
    int[] reg;
    int PC;     //program counter
    int IR;     //next stetp to execute (PC+1)
    Memory memory;
    public Processor(){
        reg=new int[8];
        PC=0;
        IR=0;
    }
    public boolean step() throws Exception{  //returns true if encounters halt command (0)
         IR = memory.read(PC++);
         runCommand(IR);
//        if(command==0)return true;
        /*execute runCommand based on p (int will contain 
        3-digit hexadecimal pab, where p is the operation to run)*/
        return false;
    }
    public void dump(){//print out register values
        System.out.println("Register Dump:");
        for(int i=0;i<reg.length;i++){
            System.out.println("Register "+i+": "+reg[i]);
    }
        System.out.println("PC: "+PC);
        System.out.println("IP: "+IR);
    }
    public void setPC(int x){
        PC=x;
    }
    public void setMemory(Memory memory){
        this.memory = memory;
    }
    
    /****************************data control****************/
    private void load (int regA, int regB ){
        reg[regA] = memory.cell[reg[regB]];
    }
    
    private void loadc (int regA){
        reg[regA] = memory.cell[PC++];
    }
    
    private void store (int regA, int regB){
        memory.cell[reg[regA]] = reg[regB];
    }
    /**********************arithmetic***********************/
    /**
     * adds two registers together, and stores in regA
     * 
     * @param regA register index that wants to be added
     * @param regB  register index (value does not get deleted)
     */
    private void add (int regA, int regB){
        reg[regA] = reg[regA] + reg[regB];
    }
    /**
     * mutliplies two registers together and stores value in regA
     * @param regA register index that wants to be multiplied
     * @param regB register index that wants to be multiplied to
     */
    private void mul (int regA, int regB){
        reg[regA] = reg[regA] * reg[regB];
    }
    /**
     * subtracts the value of register a and register b, 
     * stores difference in register A
     * @param regA minuend 
     * @param regB  subtrahend
     */
    private void sub (int regA, int regB){
        reg[regA] = reg[regA] - reg[regB];
    }
    /**
     * Divides register A and register B, stores value in 
     * the index of registerA
     * @param regA the dividend (numerator)
     * @param regB the divisor (demoniator)
     * @throws Exception regB cannot be zero; cannot divide by a zero
     */
    private void div (int regA, int regB) throws Exception{
        if (regB ==0)
                throw new Exception("cannot divide by zero");
        reg[regA] = reg[regA] / reg[regB];
    }
    /****************************************logic**************************/
    /**
     * compares regA and regB whereas 1 is true, and 0 is false.
     * the boolean expression is and; regA and regB ;stores the 
     * outcome in the index of register at regA
     * @param regA the index of the register you want to compare 
     * @param regB the index of the register you want to compare
     */
    private void and (int regA, int regB){
        if (reg[regA] != 0 && reg[regB] !=0)
            reg[regA] = 1;
        else 
            reg[regA] = 0;
        
    }
    
    /**
     * preforms the boolean operation or. whereas 1 is true, and 0 is false.
     * stores the outcome in regA
     * @param regA index of the register you want to compare
     * @param regB index of the register you want to compare
     */
    private void or (int regA, int regB){
        if (reg[regA] !=0 || reg[regB] != 0)
            reg[regA] = 1;
        else 
            reg[regA] = 0;
    }
    
    /**
     * preforms the boolean operation not whereas 1 is ture, and 0 is false
     * preforms the boolean operation not on regB
     * stores the outcome in regA
     * @param regA the register you would like to store the outcome of not (regB)
     * @param regB the register you want to apply the boolean operation not
     */
    private void not (int regA, int regB){
        if (reg[regB] !=0)
            reg[regA] = 0;
        else 
            reg[regA] = 1;
    }
    
    /********************************bitwise************************/
    private void lshift (int regA, int regB){
        reg[regA] = reg[regB] << 1;
        
    }
    
    private void rshift (int regA, int regB){
        reg[regA] = reg[regB] >>1;
    }
   
    private void bwc (int regA, int regB){
        reg[regA] = reg[regA] & reg[regB];
    }
    
    private void bwd (int regA, int regB){
        reg[regA] = reg[regA] | reg[regB];
    }
    /**********************sequence control**************/
    
    
    public void sequenceIf (int regA, int regB){
    if (reg[regA] != 0)
        PC = reg[regB];
}
    public void halt(){
        System.out.println("program stopped.");
    }
    private void runCommand(int command) throws Exception{
      String hex =  Integer.toString(command);
      //takes hte last three numbers
      int commandNumber = Integer.parseInt(hex.substring(7, 8));
      int regA = Integer.parseInt(hex.substring(8, 9));
      int regB = Integer.parseInt(hex.substring(9, 10));
      
      //examines which command to run,
      //then executes the command.
        switch(commandNumber){
            case 1:
                load(regA, regB);
                break;
            case 2:
                loadc(regA);
                break;
            case 3:
                store(regA, regB);
                break;
            case 4:
                add(regA, regB);
                break;
            case 5:
                mul(regA, regB);
                break;
            case 6:
                sub(regA, regB);
                break;
            case 7:
                div(regA, regB);
                break;
            case 8:
                and (regA, regB);
                break;
            case 9:
                or (regA, regB);
                break;
            case 10:
                not (regA, regB);
                break;
            case 11:
                lshift(regA, regB);
                break;
            case 12:
                rshift(regA, regB);
                break;
            case 13:
                bwc(regA, regB);
                break;
            case 14:
                bwd(regA, regB);
                break;
            case 15:
                sequenceIf(regA, regB);
                break;
            case 
                
        }
        /*
        Data Control
10. not a b // if (reg[b]!=0) reg[a]=0 else reg[a]=1
Bitwise
11. lshift a b // reg[a] = reg[b] << 1
12. rshift a b // reg[a] = reg[b] >> 1
13. bwc a b // reg[a] = reg[a] & reg[b]
14. bwd a b // reg[a] = reg[a] | reg[b]
Sequence Control
15. if a b // if (reg[a] != 0) pc = reg[b]
0. halt // stop fetch-execute cycle
        */
        
        
    }
}
