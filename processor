//this file holds the processor class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micro1project;

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
    public boolean step(){  //returns true if encounters halt command (0)
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
    private void runCommand(int command){
        /*
        Data Control
1. load a b // reg[a] = cell[reg[b]]
2. loadc a // reg[a] = cell[PC++]
3. store a b // cell[reg[a]] = reg[b]
Arithmetic
4. add a b // reg[a] = reg[a] + reg[b]
5. mul a b // reg[a] = reg[a] * reg[b]
6. sub a b // reg[a] = reg[a] - reg[b]
7. div a b // reg[a] = reg[a] / reg[b], error if reg[b] == 0
Logic
8. and a b // if (reg[a]!= 0&&reg[b]!=0) reg[a]=1 else reg[a]=0
9. or a b // if (reg[a]!=0||reg[b]!=0) reg[a]=1 else reg[a]=0
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
