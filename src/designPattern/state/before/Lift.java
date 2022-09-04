package designPattern.state.before;

/**
 * 电梯类 (IList的子实现类)
 */
public class Lift implements ILift{

    // 声明一个记录当前电梯的状态
    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯打开了");
                // 设置当前电梯状态为开启状态
                setState(OPENING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("电梯打开了");
                // 设置当前电梯状态为开启状态
                setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
