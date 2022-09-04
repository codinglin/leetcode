package designPattern.state.after;

/**
 * 环境角色类
 */
public class Context {
    // 定义对应状态对象的常量
    public final static OpeningState OPENING_STATE = new OpeningState();
    public final static ClosingState CLOSING_STATE = new ClosingState();
    public final static RunningState RUNNING_STATE = new RunningState();
    public final static StoppingState STOPPING_STATE = new StoppingState();

    // 定义当前电梯状态变量
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    // 设置当前状态对象
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        // 设置当前状态中的Context对象
        this.liftState.setContext(this);
    }
    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
