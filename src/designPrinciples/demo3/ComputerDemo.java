package designPrinciples.demo3;

public class ComputerDemo {
    public static void main(String[] args) {
        HardDisk hardDisk = new XiJieHardDisk();
        Cpu cpu = new IntelCpu();
        Memory memory = new KingstonMemory();

        Computer c = new Computer();
        c.setCpu(cpu);
        c.setHardDisk(hardDisk);
        c.setMemory(memory);
        c.run();
    }
}
