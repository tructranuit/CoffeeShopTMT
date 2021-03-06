package ivc.coffee.shop.tmtruc.com.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ivc.coffee.shop.tmtruc.com.R;
import ivc.coffee.shop.tmtruc.com.activity.MainActivity;
import ivc.coffee.shop.tmtruc.com.activity.MapsActivity;
import ivc.coffee.shop.tmtruc.com.adapter.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ViewPager viewPager;
    ArrayList<Integer> imageList;
    ViewPagerAdapter viewPagerAdapter;
    Timer timer;
    ViewFlipper viewFlipper;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        viewPager = (ViewPager) view.findViewById(R.id.viewpager_slide_image);

        imageList = new ArrayList<>();

        imageList.add(R.drawable.coffee_shop_img_1);
        imageList.add(R.drawable.coffee_shop_img_2);
        imageList.add(R.drawable.coffee_shop_img_3);
        imageList.add(R.drawable.coffee_shop_img_4);

        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflipper);
        for (int i = 0; i<imageList.size(); i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setAdjustViewBounds(true);
            Picasso.with(getContext()).load(imageList.get(i)).into(imageView);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right));
        viewFlipper.setAutoStart(true);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_google_map);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });




//        viewPagerAdapter = new ViewPagerAdapter(getContext(), imageList);
//        viewPager.setAdapter(viewPagerAdapter);
//
//        timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimerTask(), 5000, 5000);
        return view;
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (timer != null) {
//            timer.cancel();
//        }
//    }

//    public class MyTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//
//            getActivity().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if (viewPager.getCurrentItem() == viewPagerAdapter.getCount() - 1) {
//                        viewPager.setCurrentItem(0);
//                    } else {
//                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                    }
//                }
//            });
//
//        }
//    }
}
