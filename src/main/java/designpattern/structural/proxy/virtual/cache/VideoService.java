package designpattern.structural.proxy.virtual.cache;

import java.util.List;


// 대상 객체와 프록시 객체를 묶는 인터페이스 (다형성)

public interface VideoService {
    List<?> listVideos();
}
