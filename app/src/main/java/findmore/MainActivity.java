package findmore;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.itheima.loopviewpager.LoopViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gxust.gxut_news.R;

public class MainActivity extends AppCompatActivity {
    private LoopViewPager loopViewPager;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_more);
        imageView=findViewById(R.id.find_more_img);
        loopViewPager = (LoopViewPager) findViewById(R.id.lvp_pager);
        loopViewPager.setImgData(imgListString());
        loopViewPager.setTitleData(titleListString());
        loopViewPager.start();
    }

    private List<String> imgListString() {
        List<String> imageData = new ArrayList<>();
        imageData.add("http://www.gxut.edu.cn/public/uploads/image/20181230230118_846.jpg");
        imageData.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1741030662,4063095902&fm=26&gp=0.jpg");
        imageData.add("http://img4.imgtn.bdimg.com/it/u=991354983,2053874953&fm=26&gp=0.jpg");
        imageData.add("http://img4.imgtn.bdimg.com/it/u=1442298986,853069214&fm=11&gp=0.jpg");
        imageData.add("http://img5.imgtn.bdimg.com/it/u=163952088,989566727&fm=11&gp=0.jpg");
        imageData.add("http://img0.imgtn.bdimg.com/it/u=4064379187,3789816027&fm=11&gp=0.jpg");

        return imageData;
    }

    private List<String> titleListString() {
        List<String> titleData = new ArrayList<>();
        titleData.add("喜迎元旦，happy new year!");
        titleData.add("创新的力量");
        titleData.add("中国制造");
        titleData.add("华为华为");
        titleData.add("5G时代");
        titleData.add("勿忘国耻");

        return titleData;
    }
}
