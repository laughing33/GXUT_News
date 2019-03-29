# `GXUT_News`
## requirements
Please pick one app from social apps like WeChat、TencentQQ, 
or video apps like Tik Tok or news apps like Tencent News or
e-commerce apps like taobao.com 、jd.com ,etc as an example to 
create your own app with the unique feature of your school.

# `some_code`
```java
public class StartNews extends AppCompatActivity  {
    private Button newsbtn,videosbtn,findbtn,mebtn;
    private EditText searchet;
    private Button searchbtn;
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startnews);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("科大新闻");
        setSupportActionBar(toolbar);
//        replaceFragment(R.id.center_layout,new NewsTitleFragment());//
        newsbtn=findViewById(R.id.navigation_news_btn);
        videosbtn=findViewById(R.id.navigation_videos_btn);
        findbtn=findViewById(R.id.navigation_find_btn);
        mebtn=findViewById(R.id.navigation_me_btn);

        searchet=findViewById(R.id.search_et);
        searchbtn=findViewById(R.id.search_btn);

        newsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"世界之窗",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(StartNews.this, MainActivity.class);
                startActivity(intent);

            }
        });
        videosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"视频新闻时代",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartNews.this, videoplayer.MainActivity.class));
            }
        });
        findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartNews.this, findmore.MainActivity.class);
                startActivity(intent);
                Toast.makeText(StartNews.this,"科大看点",Toast.LENGTH_SHORT).show();
            }
        });
        mebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StartNews.this,"官网在这里",Toast.LENGTH_SHORT).show();
//                replaceFragment(R.id.center_layout,new MeFragment());
                Intent intent =new Intent(StartNews.this,MeActivity.class);
                startActivity(intent);
//                finish();
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"正在搜索...",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void replaceFragment(Integer fragmentid,Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(fragmentid,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
            convertView = mLayoutInflater.inflate(R.layout.videoplayer_item_videoview, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mJCVideoPlayerStandard = (JCVideoPlayerStandard) convertView.findViewById(R.id.videoplayer);
        if (mPager == -1) {
            holder.mJCVideoPlayerStandard.setUp(
                    VideoConstant.mVideoUrls[0][position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                    VideoConstant.mVideoTitles[0][position]);
            Log.e("TAG", "setUp" + position);
            Picasso.with(convertView.getContext())
                    .load(VideoConstant.mVideoThumbs[0][position])
                    .into(holder.mJCVideoPlayerStandard.thumbImageView);
        } else {
            holder.mJCVideoPlayerStandard.setUp(
                    VideoConstant.mVideoUrls[mPager][position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                    VideoConstant.mVideoTitles[mPager][position]);
            Picasso.with(convertView.getContext())
                    .load(VideoConstant.mVideoThumbs[mPager][position])
                    .into(holder.mJCVideoPlayerStandard.thumbImageView);
        }
        return convertView;
    }

    class ViewHolder {
        JCVideoPlayerStandard mJCVideoPlayerStandard;
    }
```
# `preview`
![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/welcome.png)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/login.png)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/word.png)

![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/picture.png)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/video.png)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/more.png)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/contact.png)

![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/one.gif)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/two.gif)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/three.gif)

![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/four.gif)![welcome](https://github.com/javadoer/GXUT_News/blob/master/preview_images/five.gif)

