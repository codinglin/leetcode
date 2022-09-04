package designPattern.state.after;

public class Client {
    public static void main(String[] args) {
        // 创建环境角色对象
        Context context = new Context();

        // 设置当前电梯装填
        context.setLiftState(new StoppingState());

        context.open();
    }
}
