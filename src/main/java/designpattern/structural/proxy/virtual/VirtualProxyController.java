package designpattern.structural.proxy.virtual;

import designpattern.structural.proxy.virtual.cache.ProxyCachedVideo;
import designpattern.structural.proxy.virtual.cache.VideoService;
import designpattern.structural.proxy.virtual.cache.VideoServiceImpl;
import designpattern.structural.proxy.virtual.lazy.HighResolutionImage;
import designpattern.structural.proxy.virtual.lazy.ImageService;
import designpattern.structural.proxy.virtual.lazy.ImageProxy;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 가상 프록시 예제
 * */
@RestController
public class VirtualProxyController {

    // 가상 프록시 : Cached 예제
    public void getVideo(@RequestParam int id){
        VideoService videoServiceImpl = new VideoServiceImpl();
        VideoService videoService = new ProxyCachedVideo(videoServiceImpl);

        videoService.listVideos();
    }


    /* 가상 프록시 : 초기화 지연
    * 해당 이미지를 불러올 때 메모리에 적재 한다.
     */
    public void getImage(){

        ImageService imageService1 = new ImageProxy("./img/고해상도이미지_1");
        ImageService imageService2 = new ImageProxy("./img/고해상도이미지_2");
        ImageService imageService3 = new ImageProxy("./img/고해상도이미지_3");


        imageService2.showImage();
    }

    /* 가상 프록시-초기화 지연 사용하지 않은 경우
    * 모든 이미지를 메모리에 먼저 올려놓는다.
    * */
    public void noProxy(){
        // 프록시를 사용하지 않았을 경우
        ImageService highResolutionImage1 = new HighResolutionImage("./img/고해상도이미지_1");
        ImageService highResolutionImage2 = new HighResolutionImage("./img/고해상도이미지_2");
        ImageService highResolutionImage3 = new HighResolutionImage("./img/고해상도이미지_3");

        highResolutionImage2.showImage();
    }


}
