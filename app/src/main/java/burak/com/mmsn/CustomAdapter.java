package burak.com.mmsn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter{
    private List<Response.EntriesBean> entries;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.EntriesBean> entries) {
        this.entries = entries;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item2, parent, false);

        Response.EntriesBean item = (Response.EntriesBean) getItem(position);

        ImageView thumbnail = (ImageView) rowView.findViewById(R.id.list_image);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView body = (TextView) rowView.findViewById(R.id.body);

        String imageUrl = MainActivity.url + item.getLink();
        Picasso.with(mContext).load(imageUrl).into(thumbnail);

        title.setText(item.getTitle());
        body.setText(item.getBody());

        return rowView;
    }
}

