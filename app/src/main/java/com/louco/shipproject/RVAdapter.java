package com.louco.shipproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    static final int VOID_CART = 0;
    static final int SALE_CART = 1;
    static final int DISCONT_CART = 2;
    static final int NEW_CART = 3;
    static final int COMPLECT_CART = 4;

    private Context context;
    private int[] typeView;

    RVAdapter(Context con, int[] typeView) {
        this.context = con;
        this.typeView = typeView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_adapter_cart,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.BindDate(typeView[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private static final String BODY_FULL = "Футболка с коротким рукавом для мальчиков BARKITO";
        private static final String BODY_MINI = "Футболка с коротким рукавом для мальчи…";

        @BindView(R.id.tv_event)
        TextView tvEvent;

        @BindView(R.id.tv_body)
        TextView tvBody;

        @BindView(R.id.tv_cost)
        TextView tvCost;

        @BindView(R.id.tv_dop_ev)
        TextView tvDopEv;

        @BindView(R.id.tv_different)
        TextView tvDifferent;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void BindDate(int position){
            switch (position){
                case 0:
                    fillCard1();
                    break;
                case 1:
                    fillCard2();
                    break;
                case 2:
                    fillCard3();
                    break;
                case 3:
                    fillCard4();
                    break;
                case 4:
                    fillCard5();
                    break;
            }
        }

        private void fillCard1(){
            tvEvent.setBackgroundColor(Color.TRANSPARENT);
            tvEvent.setText("");
            tvCost.setText(DrawRouble("259 \u20BD"));
            tvBody.setText(BODY_FULL);
        }

        private void fillCard2(){
            tvEvent.setBackgroundResource(R.drawable.rouded_red);
            tvEvent.setText("-10%");
            tvBody.setText(BODY_MINI);
            tvCost.setText(DrawRouble("259 \u20BD"));
            tvCost.setTextColor(Color.RED);
            tvDopEv.setText(DrawRouble("400"));
            tvDopEv.setPaintFlags(tvDopEv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            tvDopEv.append(DrawRouble("\u20BD"));
            tvDifferent.setText(DrawRouble("(выгода 141 \u20BD)"));
        }

        private void fillCard3(){
            tvEvent.setBackgroundResource(R.drawable.ic_discount_card);
            tvBody.setText(BODY_MINI);
            tvCost.setText(DrawRouble("259 \u20BD"));
            tvCost.setTextColor(Color.RED);
            tvDopEv.setText(DrawRouble("без карты 300 \u20BD"));
            tvDifferent.setText(DrawRouble("(выгода 141 \u20BD)"));
        }

        private void fillCard4(){
            tvEvent.setBackgroundResource(R.drawable.rouded_green);
            tvEvent.setText("NEW");
            tvCost.setText(DrawRouble("259 \u20BD"));
            tvBody.setText(BODY_FULL);
        }

        private void fillCard5(){
            tvEvent.setBackgroundResource(R.drawable.rouded);
            tvEvent.setText("2+1");
            tvCost.setText(DrawRouble("259 \u20BD"));
            tvBody.setText(BODY_FULL);
        }
    }
    private CharSequence DrawRouble(String Text){
        return spanWithRoubleTypeface(Text, context);
    }

    static CharSequence spanWithRoubleTypeface(String priceHint, Context context) {
        final Typeface roubleSupportedTypeface =
                Typeface.createFromAsset(context.getAssets(), "fonts/rouble2.ttf");

        SpannableStringBuilder resultSpan = new SpannableStringBuilder(priceHint);
        for (int i = 0; i < resultSpan.length(); i++) {
            if (resultSpan.charAt(i) == '\u20BD') {
                TypefaceSpan2 roubleTypefaceSpan = new TypefaceSpan2(roubleSupportedTypeface);
                resultSpan.setSpan(roubleTypefaceSpan, i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return resultSpan;
    }
}
