package designPrinciples.demo3;

/**
 * 硬盘接口
 */
public interface HardDisk {
    void save(String data);

    String get();
}
