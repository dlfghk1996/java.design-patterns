package designpattern.structural.proxy.virtual.cache;


import java.util.List;


public class ProxyCachedVideo implements VideoService {

    private final VideoService videoService;
    private List<?> listCache;

    public ProxyCachedVideo(VideoService videoServiceImpl) {
        this.videoService = videoServiceImpl;
    }

    @Override
    public List<?> listVideos() {
        // 메모리에 데이터가 유무 확인 후 RealSubject 호출
        if (listCache == null){
            listCache = videoService.listVideos();
        }
        return listCache;
    }
}
