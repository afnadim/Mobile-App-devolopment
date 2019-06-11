package com.example.nadim.countryfacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * CountryAdapter exposes a list of countries to the RecycleView
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> mCountryList;

    public CountryAdapter(){}

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView countryNameView;
        TextView countryCapitalView;
        TextView currencyView;
        TextView languageView;
        TextView populationView;
        TextView areaSizeView;
        TextView arearegionView;
        TextView timeZoneView;
        TextView subRegionView;
        TextView nativeNameView;

        public CountryViewHolder(View itemView) {
            super(itemView);
            countryNameView = (TextView) itemView.findViewById(R.id.tv_country_name);
            currencyView = (TextView) itemView.findViewById(R.id.tv_currency);
            languageView = (TextView) itemView.findViewById(R.id.tv_language);
            countryCapitalView = (TextView) itemView.findViewById(R.id.tv_capital );
            populationView = (TextView) itemView.findViewById(R.id.tv_population);
            areaSizeView = (TextView) itemView.findViewById(R.id.tv_area);
            arearegionView = (TextView) itemView.findViewById(R.id.tv_region);
            timeZoneView = (TextView) itemView.findViewById(R.id.tv_timeZone);
            subRegionView = (TextView) itemView.findViewById(R.id.tv_subRegion);
            nativeNameView = (TextView) itemView.findViewById(R.id.tv_nativeName);

        }
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.country_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        CountryViewHolder viewHolder = new CountryViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country currentCountry = mCountryList.get(position);
        String countryName = currentCountry.getName();
        String countryCapital = currentCountry.getCapital();
        String populationsize = currentCountry.getPopulation();
        String AreaSize=currentCountry.getareaSize();
        String RegionName=currentCountry.getregion();
        String SubRegionName=currentCountry.getSubregion();
        String TimeZone=currentCountry.getTimeZone();
        String languageName = currentCountry.getLanguage();
        String NativeName = currentCountry.getNativeName();

        String currencyCode = currentCountry.getCurrencyCode();
        String currencySymbol = currentCountry.getCurrencySymbol();
        String currencyInfo = currencyCode + " " + currencySymbol;




        holder.countryNameView.setText(countryName);
        holder.currencyView.setText(currencyInfo);
        holder.languageView.setText(languageName);
        holder.countryCapitalView.setText(countryCapital);
        holder.populationView.setText(populationsize);
        holder.areaSizeView.setText(AreaSize);
        holder.arearegionView.setText(RegionName);
        holder.subRegionView.setText(SubRegionName);
        holder.timeZoneView.setText( TimeZone );
        holder.nativeNameView.setText( NativeName );
    }

    @Override
    public int getItemCount() {
        if (mCountryList == null){
            return 0;
        }
        return mCountryList.size();
    }

    public void setCountryData (List<Country> countryData){
        mCountryList = countryData;
        notifyDataSetChanged();
    }

}
