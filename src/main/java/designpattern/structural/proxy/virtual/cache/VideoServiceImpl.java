package designpattern.structural.proxy.virtual.cache;

import java.util.ArrayList;
import java.util.List;

public class VideoServiceImpl implements VideoService {

    @Override
    public List<?> listVideos() {
        // 유튜브에 API 요청을 보냅니다.
        System.out.println("유튜브에 API 요청을 보냅니다.");
        return new ArrayList<>();
    }
}
