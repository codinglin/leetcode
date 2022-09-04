package designPrinciples.demo1;

public class SougouInput {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
