package designPattern.memento.whiteBox;

public class Client {
    public static void main(String[] args) {
        System.out.println("------大战BOSS前------");

        // 创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        // 将该游戏角色内部状态进行备份
        // 创建管理者对象
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        System.out.println("------大战BOSS后------");
        // 损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("------恢复之前的状态------");
        gameRole.recoverState(roleStateCaretaker.getRoleStateMemento());
        gameRole.stateDisplay();
    }
}
