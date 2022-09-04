package designPattern.responsibility;

/**
 * 部门经理类 (具体的处理者)
 */
public class Manager extends Handler {

    public Manager(){
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" +
                leave.getNum() + "天" + leave.getContent());
        System.out.println("部门经理审批: 同意");
    }
}
