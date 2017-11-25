package id.my.note.layoutdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

/**
 * Created by hilmiat on 25/11/17.
 */

class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public Integer[] gambar = {
            R.drawable.andro1,
            R.drawable.andro2,
            R.drawable.andro2,
            R.drawable.andro1,
            R.drawable.andro2,
            R.drawable.andro1,
    };
    public ImageAdapter(GridActivity gridActivity) {
        mContext = gridActivity;
    }

    @Override
    public int getCount() {
        return gambar.length;
    }

    @Override
    public Object getItem(int i) {
        return gambar[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(gambar[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(
                new RelativeLayout.LayoutParams(160,160));
        return imageView;
    }
}
