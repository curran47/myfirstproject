package com.example.nanovacationke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
/**import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context mcontext;
    private List<slide_Constructor> mlist;

    public SlideAdapter(Context mcontext, List<slide_Constructor> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slidelayout= inflater.inflate(R.layout.slide_item,null);
        ImageView slideimg=slidelayout.findViewById(R.id.imageviewid);
        TextView slidetxt=slidelayout.findViewById(R.id.tv_slideitem_id);
        slideimg.setImageResource(mlist.get(position).getImage());
        slidetxt.setText(mlist.get(position).getTitle());
        container.addView(slidelayout);
        return slidelayout;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
**/