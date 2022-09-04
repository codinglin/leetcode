package designPattern.memento.blackBox;

/**
 * 备忘录对象管理对象
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
