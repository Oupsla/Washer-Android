package eu.delpi.washer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import eu.delpi.washer.Model.User;
import eu.delpi.washer.R;

/**
 * Created by nicolas on 26/11/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context mContext;
    private List<User> userList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvTotalCount;
        TextView tvMonthCount;
        TextView tvWeekCount;

        public ViewHolder(View view) {
            super(view);
            tvUsername = (TextView) view.findViewById(R.id.tv_history_username);
            tvTotalCount = (TextView) view.findViewById(R.id.tv_history_count_total);
            tvMonthCount = (TextView) view.findViewById(R.id.tv_history_count_month);
            tvWeekCount = (TextView) view.findViewById(R.id.tv_history_count_week);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HistoryAdapter(Context mContext, List<User> userList) {
        this.userList = userList;
        this.mContext = mContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_history, parent, false);

        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvUsername.setText(userList.get(position).getName());
        holder.tvWeekCount.setText("Week : " + userList.get(position).getTotalMonth());
        holder.tvMonthCount.setText("Month : " + userList.get(position).getTotalMonth());
        holder.tvTotalCount.setText("Total : " + userList.get(position).getTotalCount());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userList.size();
    }
}
