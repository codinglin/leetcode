package designPattern.state.after;

/**
 * 电梯开启状态类
 */
public class OpeningState extends LiftState {
    // 当前状态要执行的方法
    @Override
    public void open() {
        System.out.println("电梯开启...");
    }

    @Override
    public void close() {
        // 修改状态
        super.context.setLiftState(Context.CLOSING_STATE);
        // 调用当前状态Context中的close方法
        super.context.close();
    }

    @Override
    public void run() {
        // 什么都不做
    }

    @Override
    public void stop() {
        // 什么都不做
    }
}
