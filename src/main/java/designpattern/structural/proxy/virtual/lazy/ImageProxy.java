package designpattern.structural.proxy.virtual.lazy;


// proxy
public class ImageProxy implements ImageService {
    private ImageService proxyImage;
    private String path;

    public ImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void showImage() {
        // 고해상도 이미지 로딩하기
        proxyImage = new HighResolutionImage(path);
        proxyImage.showImage();
    }
}
