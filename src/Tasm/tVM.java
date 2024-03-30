package Tasm;

import java.util.Stack;

typedef int32_t i32
public class tVM {
    private int[] memory;
    private int pc; // Program Counter
    private Stack<Integer> operandStack;

    public tVM(int memorySize) {
        memory = new int[memorySize];
        pc = 0;
        operandStack = new Stack<>();
    }

    public void loadProgram(int[] program) {
        System.arraycopy(program, 0, memory, 0, program.length);
    }

    public void run() {
        while (pc < memory.length) {
            int opcode = memory[pc];
            pc++;
            switch (opcode) {
                case 0: // HALT
                    return;
                case 1: // IADD
                    int a = operandStack.pop();
                    int b = operandStack.pop();
                    operandStack.push(a + b);
                    break;
                // More instructions can be added here
            }
        }
    }

    public static void main(String[] args) {
        SimpleVM vm = new SimpleVM(1024);
        int[] program = {1, 2, 3, 1, 4, 5, 0}; // Example program: IADD 2 3, IADD 4 5, HALT
        vm.loadProgram(program);
        vm.run();
        System.out.println("Result: " + vm.operandStack.peek()); // Should print 9
    }
}
