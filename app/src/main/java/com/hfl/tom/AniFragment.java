package com.hfl.tom;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AniFragment extends Fragment {
    private ImageView imageView;
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ani, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mediaPlayer=MediaPlayer.create(view.getContext(),R.raw.mmm);
        imageView=(ImageView)view.findViewById(R.id.imageView1);
        final AnimationDrawable background= (AnimationDrawable) imageView.getBackground();
        background.setOneShot(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!background.isRunning()){
                    background.start();
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }else {
                    background.stop();
                    mediaPlayer.pause();
                }
            }
        });
    }

}
