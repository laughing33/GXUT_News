package cn.edu.gxust.gxut_news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

//    GetNews getNews=new GetNews();
//    List<News> newsFromJsonList=new ArrayList<>();
//    List<News> dataListFromJson=getNews.getTheNewsList();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitleRecyclerView = (RecyclerView) view.findViewById(R.id.news_title_recyler_view);
        Log.d("my", "newstitlefragment界面启动");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);

        return view;
    }

    /////////////////////////////////////////////////////////////////传入数据
String [] gxustData={
            "总结过去的一年，展望2019，你有什么想说的？",
            "时序更迭，华章日新。2018年已经过去，充满希望的2019年已经到来。\n" + "\n" + "科大学子们是如何看待逝去的2018年的呢？又对新的一年有怎样的展望呢？今天就随官小微一起来听听他们怎么说的吧！\n"+"@廖同学\n" +
                    "\n" +
                    "2018年我慢慢变得有责任担当，更加理解父母，懂得父母赚钱来之不易，帮助他们做了许多力所能及的事。\n" +
                    "\n" +
                    "去年我也变得更加爱浪了，摆脱了中学时代监管式的束缚，但能把握好度，在完成课程学习后才去玩。\n" +
                    "\n" +
                    "再者就是学会了坦然面对一切，敢于发表自己的看法，勇于担当责任，遇事沉着冷静。\n" +
                    "\n" +
                    "去年最大的遗憾是当初没有很努力，让自己输在了起跑线上，导致有些学科的学习跟不上。\n" +
                    "\n" +
                    "2019年我要好好学习，不挂科，不断提高自己各方面的能力，多参加去实践，世界那么大我还想开车去浪。\n",
            "自治区重点实验室2018年度考核会议在我校举行","2018年12月21日，自治区重点实验室2018年度考核会议顺利举行。考核专家组一行7人对以我校为依托单位的“广西汽车零部件与整车技术重点实验室”“广西糖资源绿色加工重点实验室”2个广西重点实验室进行了考核。此次年度考核，“广西汽车零部件与整车技术重点实验室”与“广西糖资源绿色加工重点实验室”的考核等级均为“优秀”。",
            "我校艺术学院教师在2018年广西文化创意产品设计大赛中喜获佳绩","近期，自治区文化厅、教育厅、科技厅、旅发委、国资委、新闻出版广电局、二轻联社桂文产函〔2018〕87号文，公布了2018年广西文化创意产品设计大赛评选结果，我校艺术学院教师获“产品设计奖”三等奖、优秀奖各1项。",
            "校啦啦操队在2018年广西啦啦操公开赛中再创佳绩","2018年12月30日—2019年1月1日，2018年广西啦啦操公开赛举行。我校啦啦操队参加此次比赛，并获得青年组季军、青年组最佳技巧啦啦操奖、青年组最佳啦啦操口号创编奖及青年组优秀教练员的佳绩。\n",
            "我校荣获2018年广西普通高校毕业生就业创业工作突出单位称号","12月19日，广西壮族自治区教育厅召开2019届全区普通高等学校毕业生就业创业工作会议。会上，自治区教育厅公布了2018年自治区高校毕业生就业创业工作突出单位名单，我校荣获2018年广西普通高校毕业生就业创业工作“突出单位”荣誉称号。"
    };
    private List<News> getNews() {


        List<News> newsList = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            News setNews = new News();
            setNews.setTitle(getString());
            setNews.setContent(getString());
            newsList.add(setNews);
        }
        return newsList;
    }
    private String getString (){
        int random=(int)(Math.random()*9);
        return gxustData[random];
    }
//    int random=(int)(Math.random()*10+1)
//    private String getRandomLengthContent(String content) {
//        Random random = new Random();
//        int length = random.nextInt(20) + 1;
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            builder.append(content);
//        }
//        return builder.toString();
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        } else
            isTwoPane = false;
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;

            public ViewHolder(View view) {
                super(view);
                newsTitleText = view.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList) {
            mNewsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());

        }

        public int getItemCount() {
            return mNewsList.size();
        }
    }


}
