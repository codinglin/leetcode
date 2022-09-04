package designPattern.state.before;

public class Client {
    public static void main(String[] args) {
        // 创建电梯对象
        Lift lift = new Lift();

        // 设置当前电梯的状态
        lift.setState(ILift.OPENING_STATE);

        // 开门
        lift.open();

        lift.close();

        lift.run();

        lift.stop();
    }
}
