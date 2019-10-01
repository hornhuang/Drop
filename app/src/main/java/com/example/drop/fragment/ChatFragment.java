package com.example.drop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drop.R;
import com.example.drop.adapter.ChatAdapter;
import com.example.drop.classes.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private List<Chat> chatList_1 = new ArrayList<>();
    private List<Chat> chatList_2 = new ArrayList<>();
    private List<Chat> chatList_3 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initChat_1();
        RecyclerView recyclerView_1 = (RecyclerView) getActivity().findViewById(R.id.recycler_top_view_1);
        LinearLayoutManager layoutManager_top_1 = new LinearLayoutManager(getActivity());
        recyclerView_1.setLayoutManager(layoutManager_top_1);
        ChatAdapter adapter_top_1 = new ChatAdapter(chatList_1);
        recyclerView_1.setAdapter(adapter_top_1);

        initChat_2();
        RecyclerView recyclerView_2 = (RecyclerView) getActivity().findViewById(R.id.recycler_top_view_2);
        LinearLayoutManager layoutManager_top_2 = new LinearLayoutManager(getActivity());
        recyclerView_2.setLayoutManager(layoutManager_top_2);
        ChatAdapter adapter_top_2 = new ChatAdapter(chatList_2);
        recyclerView_2.setAdapter(adapter_top_2);

        initChat_3();
        RecyclerView recyclerView_3 = (RecyclerView) getActivity().findViewById(R.id.recycler_top_view_3);
        LinearLayoutManager layoutManager_top_3 = new LinearLayoutManager(getActivity());
        recyclerView_3.setLayoutManager(layoutManager_top_3);
        ChatAdapter adapter_top_3 = new ChatAdapter(chatList_3);
        recyclerView_3.setAdapter(adapter_top_3);

    }


    private void initChat_1() {
            Chat xiaochou = new Chat("\n安卓",R.drawable.android);
            chatList_1.add(xiaochou);
            Chat guandao = new Chat("\n图灵",R.drawable.tuling);
            chatList_1.add(guandao);
            Chat xiahu = new Chat("\n微软小冰",R.drawable.mincrosoftxiaobing);
            chatList_1.add(xiahu);
            Chat lanmo = new Chat("\nQQ小冰",R.drawable.qqxiaobin);
            chatList_1.add(lanmo);
            Chat landiao = new Chat("\nBabyQ",R.drawable.babyq);
            chatList_1.add(landiao);
            Chat xiaodu = new Chat("\n小度",R.drawable.baidurobot);
            chatList_1.add(xiaodu);

    }

        private void initChat_2() {
            Chat q = new Chat("荷兰猪",R.drawable.helanzhu);
            chatList_2.add(q);
            Chat a = new Chat("仓鼠",R.drawable.canshu);
            chatList_2.add(a);
            Chat z = new Chat("金丝熊",R.drawable.jinsixiong);
            chatList_2.add(z);
            Chat w= new Chat("小太阳",R.drawable.xiaotaiyanyinwu);
            chatList_2.add(w);

            }

        private void initChat_3() {
            Chat xiaochou = new Chat("僧帽",R.drawable.sengmaoshuimu);
            chatList_3.add(xiaochou);
            Chat xiahu = new Chat("箭毒蛙",R.drawable.jianduwa);
            chatList_3.add(xiahu);
            Chat q= new Chat("蓝环",R.drawable.lanhuanzhanyu);
            chatList_3.add(q);

        }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
