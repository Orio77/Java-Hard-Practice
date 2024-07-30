package algorithms.exercise10_bitManipulation.scenario1;
// AI Copied
public class DeviceRegister {
    private int[] bitPosition;
    private int[] masks;
    private int register;

    public int getRegister() {
        return register;
    }
    public void setRegister(int register) {
        this.register = register;
    }

    public DeviceRegister(int[] bitPosition, int[] masks) {
        this.bitPosition = bitPosition;
        this.masks = masks;
    }

    public int readRegisterField(int index) {
        return (register & masks[index]);
    }

    public void writeRegisterField(int index, int value) {
        register = (register & ~masks[index] | value << bitPosition[index]);
    }

    public void toggleRegisterField(int index) {
        register = register ^ masks[index];
    }
}


/*1. **Implement Bit Manipulation Techniques for Reading and Writing Device Registers:**
    
    - Define constants or macros for the bit positions or masks of the register fields.
    - Implement a function to read a register field. This could involve using bitwise AND to mask the bits of interest and then using shift operations to align the bits with the least significant bit.
    - Implement a function to write to a register field. This could involve using bitwise AND to clear the bits of interest, bitwise OR to set the new value, and shift operations to align the bits with the correct position.
    - Implement a function to toggle a register field. This could involve using bitwise XOR to flip the bits of interest. */