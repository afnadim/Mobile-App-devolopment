package com.example.nadim.countryfacts;

/**
 * Class to hold information about the country
 */

public class Country {
        // member variables to store country information
        private String mName;
        private String mCurrencyCode;
        private String mTimeZone;
        private String mCurrencySymbol;
        private String mLanguage;
        private String mcapital;
        private String mpopulation;
        private String mareaSize;
        private String mregion;
        private String msubRegion;
        private String mnativeName;

        // constructor to construct a country object with the information
        public Country(String countryName, String currencyCode, String currencySymbol, String language,
                       String capitalName, String populationSize, String areaSize,
                       String regionName, String timeZone, String subRegion, String nativeName){
            mName = countryName;
            mCurrencyCode = currencyCode;
            mCurrencySymbol = currencySymbol;
            mLanguage = language;
            mcapital=capitalName;
            mpopulation=populationSize;
            mareaSize=areaSize;
            mregion=regionName;
            mTimeZone=timeZone;
            msubRegion=subRegion;
            mnativeName= nativeName;


        }

        // getter methods
        public String getName() {
            return mName;
        }
        public String getCurrencyCode() {
            return mCurrencyCode;
        }
        public String getCurrencySymbol() {
            return mCurrencySymbol;
        }
        public String getTimeZone() {return mTimeZone;}
        public String getLanguage() {
            return mLanguage;
        }
        public String getCapital() {
        return mcapital;
       }
        public String getPopulation() {
        return mpopulation;
       }
        public String getareaSize() {
        return mareaSize;
    }
        public String getregion() {return mregion;}
        public String getSubregion() {return msubRegion;}
        public String getNativeName() {return mnativeName;}









}
