package com.pixel.app.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pixel.app.R;
import com.pixel.app.ui.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    //    private List<Data> options;
    private Context context;
    private Callback mCallback;

    public MenuAdapter(Context context, ArrayList<String> options) {
//        this.options = options;
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemEvents = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_application, viewGroup, false);
        return new AssignedTasksViewHolder(itemEvents);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return 0/*options.size()*/;
    }

//    public void addItems(List<Data> options) {
//        this.options.clear();
//        this.options.addAll(options);
//        notifyDataSetChanged();
//    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public interface Callback {
        void onItemClicked(/*Data application*/);
    }

    public class AssignedTasksViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_application_name)
        TextView applicationName;

        @BindView(R.id.tv_application_status)
        TextView applicationStatus;

        @BindView(R.id.tv_application_date)
        TextView applicationDate;

        @BindView(R.id.btn_continue)
        ImageView btnContinue;

//        Data application;

        public AssignedTasksViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        @Override
        protected void clear() {
            applicationStatus.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

//            application = options.get(position);
//            if (application != null) {
//                applicationName.setText(application.getAcademicProgrammeName());
//                applicationStatus.setText(application.getStatus());
//                String dateFromAPI = application.getCreatedAt();
//                if (!TextUtils.isEmpty(dateFromAPI)) {
//
//                    try {
//                        Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateFromAPI);
//                        String theDate = DateUtils.formatDateTime(itemView.getContext(), date.getTime(), DateUtils.FORMAT_ABBREV_ALL);
//                        applicationDate.setText(theDate);
//                    } catch (ParseException e) {
//                        AppLogger.e("------------> Date " + e.getMessage());
//                    }
//                }
//
//                btnContinue.setOnClickListener(v -> mCallback.onItemClicked(application));
//            }
        }
    }
}