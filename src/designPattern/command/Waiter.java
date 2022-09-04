package designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员类 (属于请求者角色)
 */
public class Waiter {
    // 持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd){
        commands.add(cmd);
    }

    // 发起命令功能
    public void OrderUp(){
        System.out.println("服务员：大厨，新订单来啦");
        for (Command command : commands) {
            if(command!=null){
                command.execute();
            }
        }
    }
}
