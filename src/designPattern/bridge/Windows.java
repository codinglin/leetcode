package designPattern.bridge;

/**
 * 扩展抽象化角色 (Windows操作系统)
 */
public class Windows extends OperationSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
