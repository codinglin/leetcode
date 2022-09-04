package designPattern.responsibility;

public class Client {
    public static void main(String[] args) {
        // 创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明", 1, "身体不适");

        // 创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        // 提交请假申请
        groupLeader.submit(leave);
    }
}
