package designPattern.bridge;

/**
 * 扩展抽象化角色 (Mac操作系统)
 */
public class Mac extends OperationSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
