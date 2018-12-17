package strategypattern;

/**
 * 妙计一：找乔国老帮忙
 */
public class BackDoor implements IStrategy{
    @Override
    public void operate() {

        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力。");
    }
}
