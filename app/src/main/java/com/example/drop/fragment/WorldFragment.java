package com.example.drop.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.drop.R;
import com.example.drop.utils.SpaceItemDecoration;
import com.example.drop.classes.World;
import com.example.drop.classes.WorldAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;

import java.util.List;

public class WorldFragment extends Fragment implements ViewPager.OnPageChangeListener {

    public int time=3000;

    private ViewPager viewPager;

    private int[] imageResIds;

    private ArrayList<ImageView> imageViewList;

    private LinearLayout ll_point_container;

    private String[] contentDescs;

    private TextView tv_desc;

    private int previousSelectedPosition = 0;

    public boolean isRunning = true;

    private List<World> worldList = new ArrayList<>();

    private RollPagerView mRollViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.world_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRollViewPager = (RollPagerView) getActivity().findViewById(R.id.roll_view_pager);
        mRollViewPager.setPlayDelay(2000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));


        initWorldBottom();
        RecyclerView recyclerView_2 = (RecyclerView) getActivity().findViewById(R.id.recycler_bottom_view);
        StaggeredGridLayoutManager layoutManager_bottom = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView_2.setLayoutManager(layoutManager_bottom);
        recyclerView_2.addItemDecoration(new SpaceItemDecoration(10));
        WorldAdapter adapter_bottom = new WorldAdapter(worldList);
        recyclerView_2.setAdapter(adapter_bottom);

    }

    private void initWorldBottom() {
        for (int i = 0 ;i < 2; i++){
            World xiaochou = new World(
                    "小丑鱼",R.drawable.gonzhixiaochou);
            worldList.add(xiaochou);
            World guandao = new World(
                   "关刀鱼",R.drawable.heibaiguandao);
            worldList.add(guandao);
            World xiahu = new World(
                    "虾虎鱼",R.drawable.gonzhixiaochou);
            worldList.add(xiahu);
            World lanmo = new World(
                    "蓝魔鱼",R.drawable.huangweilanmo);
            worldList.add(lanmo);
            World landiao = new World(
                    "蓝吊鱼",R.drawable.landiao);
            worldList.add(landiao);
            World hongyin = new World(
                    "红鹰鱼",R.drawable.meiguohongying);
            worldList.add(hongyin);
            World renzidie = new World(
                    "人字蝶鱼",R.drawable.renzidie);
            worldList.add(renzidie);
            World meigui = new World(
                    "泗水玫瑰鱼",R.drawable.sishuimeigui);
            worldList.add(meigui);
            World paodan = new World(
                    "鸳鸯炮弹鱼",R.drawable.yuanyangpaodan);
            worldList.add(paodan);
    World yuemeidie = new World(
            "月眉蝶鱼",R.drawable.yuemeidie);
            worldList.add(yuemeidie);
                    World leida = new World(
                    "雷达鱼",R.drawable.zileida);
                    worldList.add(leida);
                    }
                    }


@Override
public void onStop() {
        super.onStop();
        }

@Override
public void onPause() {
        super.onPause();
        }





    /**
     * 初始化要显示的数据
     */
    private void initData() {
        // 图片资源id数组
        imageResIds = new int[]{R.drawable.rainforest_tank, R.drawable.sea_tank, R.drawable.gass_tank, R.drawable.amazon_tank, R.drawable.sea};

        // 文本描述
        contentDescs = new String[]{
                "美国旧金山水族馆一水獭打哈欠走红",
                "红树又回来啦！引万人注目",
                "海缸总是让人流连忘返",
                "那些绝美的造景总能让人眼前一亮",
                "河南多地现假“海洋馆” 只有几个鱼缸几条鱼"
        };

        // 初始化要展示的5个ImageView
        imageViewList = new ArrayList<ImageView>();
        ImageView imageView;
        View pointView;
        LinearLayout.LayoutParams layoutParams;
        for (int i = 0; i < imageResIds.length; i++) {
            // 初始化要显示的图片对象

            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageResIds[i]);
            imageViewList.add(imageView);

            // 加小白点, 指示器
            pointView = new View(getActivity());
            pointView.setBackgroundResource(R.drawable.selector_bg_point);
            layoutParams = new LinearLayout.LayoutParams(5, 5);
            if (i != 0)
                layoutParams.leftMargin = 10;

            // 设置默认所有都不可用
            pointView.setEnabled(false);
            ll_point_container.addView(pointView, layoutParams);
        }
    }

    private void initAdapter() {
        ll_point_container.getChildAt(0).setEnabled(true);
        tv_desc.setText(contentDescs[0]);
        previousSelectedPosition = 0;
        // 设置适配器
        viewPager.setAdapter(new MyAdapter());
        // 默认设置到中间的某个位置
        int pos = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageViewList.size());
        // 2147483647 / 2 = 1073741823 - (1073741823 % 5)
        viewPager.setCurrentItem(5000000); // 设置到某个位置
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
        // 3. 指定复用的判断逻辑, 固定写法
        @Override
        public boolean isViewFromObject(View view, Object object) {
//			System.out.println("isViewFromObject: "+(view == object));
            // 当划到新的条目, 又返回来, view是否可以被复用.
            // 返回判断规则
            return view == object;
        }

        // 1. 返回要显示的条目内容, 创建条目
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            System.out.println("instantiateItem初始化: " + position);
            // container: 容器: ViewPager
            // position: 当前要显示条目的位置 0 -> 4
//			newPosition = position % 5
            int newPosition = position % imageViewList.size();
            ImageView imageView = imageViewList.get(newPosition);
            // a. 把View对象添加到container中
            container.addView(imageView);
            // b. 把View对象返回给框架, 适配器
            return imageView; // 必须重写, 否则报异常

        }

        // 2. 销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // object 要销毁的对象
            System.out.println("destroyItem销毁: " + position);
            container.removeView((View) object);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        // 滚动时调用
    }

    @Override

    public void onPageSelected(int position) {
        // 新的条目被选中时调用
        System.out.println("onPageSelected: " + position);
        int newPosition = position % imageViewList.size();

        //设置文本
        tv_desc.setText(contentDescs[newPosition]);


        // 把之前的禁用, 把最新的启用, 更新指示器
        ll_point_container.getChildAt(previousSelectedPosition).setEnabled(false);
        ll_point_container.getChildAt(newPosition).setEnabled(true);

        // 记录之前的位置
        previousSelectedPosition = newPosition;



    }
    @Override
    public void onPageScrollStateChanged(int state) {
        // 滚动状态变化时调用
    }

    private class TestNormalAdapter extends StaticPagerAdapter {

        private int[] imgs = {

                R.drawable.rainforest_tank,

                R.drawable.gass_tank,

                R.drawable.sea_tank,

                R.drawable.amazon_tank,

        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;

        }

        @Override
        public int getCount() {
            return imgs.length;
        }

    }

}
