package es.uniovi.miw.travelapi.util;

import es.uniovi.miw.travelapi.rest.countries.dto.CountryDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryCodes {
    private static final Map<String, String> codigosPaises = new HashMap<>();

    private CountryCodes(){}

    public static List<String> getAllCountryNames() {
        return new ArrayList<>(codigosPaises.keySet());
    }
    public static List<String> getAllCountryCodes() {
        return new ArrayList<>(codigosPaises.values());
    }

    public static CountryDto getByCountryCode(String code){
        Map.Entry<String, String> countryEntry = codigosPaises.entrySet().stream().filter(entry -> entry.getValue().equals(code)).findFirst().orElse(null);

        return countryEntry !=null? new CountryDto(countryEntry.getKey(),countryEntry.getValue()):null;
    }
    public static List<CountryDto> getPaises() {
        return codigosPaises.entrySet().stream().map(entry -> new CountryDto(entry.getKey(),entry.getValue())).collect(Collectors.toList());
    }

    static {
        codigosPaises.put("Afghanistan", "AF");
        codigosPaises.put("Albania", "AL");
        codigosPaises.put("Algeria", "DZ");
        codigosPaises.put("Andorra", "AD");
        codigosPaises.put("Angola", "AO");
        codigosPaises.put("Antigua and Barbuda", "AG");
        codigosPaises.put("Argentina", "AR");
        codigosPaises.put("Armenia", "AM");
        codigosPaises.put("Australia", "AU");
        codigosPaises.put("Austria", "AT");
        codigosPaises.put("Azerbaijan", "AZ");
        codigosPaises.put("Bahamas", "BS");
        codigosPaises.put("Bahrain", "BH");
        codigosPaises.put("Bangladesh", "BD");
        codigosPaises.put("Barbados", "BB");
        codigosPaises.put("Belarus", "BY");
        codigosPaises.put("Belgium", "BE");
        codigosPaises.put("Belize", "BZ");
        codigosPaises.put("Benin", "BJ");
        codigosPaises.put("Bhutan", "BT");
        codigosPaises.put("Bolivia", "BO");
        codigosPaises.put("Bosnia and Herzegovina", "BA");
        codigosPaises.put("Botswana", "BW");
        codigosPaises.put("Brazil", "BR");
        codigosPaises.put("Brunei Darussalam", "BN");
        codigosPaises.put("Bulgaria", "BG");
        codigosPaises.put("Burkina Faso", "BF");
        codigosPaises.put("Burundi", "BI");
        codigosPaises.put("Cabo Verde", "CV");
        codigosPaises.put("Cambodia", "KH");
        codigosPaises.put("Cameroon", "CM");
        codigosPaises.put("Canada", "CA");
        codigosPaises.put("Central African Republic", "CF");
        codigosPaises.put("Chad", "TD");
        codigosPaises.put("Chile", "CL");
        codigosPaises.put("China", "CN");
        codigosPaises.put("Colombia", "CO");
        codigosPaises.put("Comoros", "KM");
        codigosPaises.put("Congo", "CG");
        codigosPaises.put("Costa Rica", "CR");
        codigosPaises.put("Côte d'Ivoire", "CI");
        codigosPaises.put("Croatia", "HR");
        codigosPaises.put("Cuba", "CU");
        codigosPaises.put("Cyprus", "CY");
        codigosPaises.put("Czech Republic", "CZ");
        codigosPaises.put("Democratic Republic of the Congo", "CD");
        codigosPaises.put("Denmark", "DK");
        codigosPaises.put("Djibouti", "DJ");
        codigosPaises.put("Dominica", "DM");
        codigosPaises.put("Dominican Republic", "DO");
        codigosPaises.put("Ecuador", "EC");
        codigosPaises.put("Egypt", "EG");
        codigosPaises.put("El Salvador", "SV");
        codigosPaises.put("Equatorial Guinea", "GQ");
        codigosPaises.put("Eritrea", "ER");
        codigosPaises.put("Estonia", "EE");
        codigosPaises.put("Eswatini", "SZ");
        codigosPaises.put("Ethiopia", "ET");
        codigosPaises.put("Fiji", "FJ");
        codigosPaises.put("Finland", "FI");
        codigosPaises.put("France", "FR");
        codigosPaises.put("Gabon", "GA");
        codigosPaises.put("Gambia", "GM");
        codigosPaises.put("Georgia", "GE");
        codigosPaises.put("Germany", "DE");
        codigosPaises.put("Ghana", "GH");
        codigosPaises.put("Greece", "GR");
        codigosPaises.put("Grenada", "GD");
        codigosPaises.put("Guatemala", "GT");
        codigosPaises.put("Guinea", "GN");
        codigosPaises.put("Guinea-Bissau", "GW");
        codigosPaises.put("Guyana", "GY");
        codigosPaises.put("Haiti", "HT");
        codigosPaises.put("Honduras", "HN");
        codigosPaises.put("Hungary", "HU");
        codigosPaises.put("Iceland", "IS");
        codigosPaises.put("India", "IN");
        codigosPaises.put("Indonesia", "ID");
        codigosPaises.put("Iran", "IR");
        codigosPaises.put("Iraq", "IQ");
        codigosPaises.put("Ireland", "IE");
        codigosPaises.put("Israel", "IL");
        codigosPaises.put("Italy", "IT");
        codigosPaises.put("Jamaica", "JM");
        codigosPaises.put("Japan", "JP");
        codigosPaises.put("Jordan", "JO");
        codigosPaises.put("Kazakhstan", "KZ");
        codigosPaises.put("Kenya", "KE");
        codigosPaises.put("Kiribati", "KI");
        codigosPaises.put("Kuwait", "KW");
        codigosPaises.put("Kyrgyzstan", "KG");
        codigosPaises.put("Lao People's Democratic Republic", "LA");
        codigosPaises.put("Latvia", "LV");
        codigosPaises.put("Lebanon", "LB");
        codigosPaises.put("Lesotho", "LS");
        codigosPaises.put("Liberia", "LR");
        codigosPaises.put("Libya", "LY");
        codigosPaises.put("Liechtenstein", "LI");
        codigosPaises.put("Lithuania", "LT");
        codigosPaises.put("Luxembourg", "LU");
        codigosPaises.put("Madagascar", "MG");
        codigosPaises.put("Malawi", "MW");
        codigosPaises.put("Malaysia", "MY");
        codigosPaises.put("Maldives", "MV");
        codigosPaises.put("Mali", "ML");
        codigosPaises.put("Malta", "MT");
        codigosPaises.put("Marshall Islands", "MH");
        codigosPaises.put("Mauritania", "MR");
        codigosPaises.put("Mauritius", "MU");
        codigosPaises.put("Mexico", "MX");
        codigosPaises.put("Micronesia", "FM");
        codigosPaises.put("Moldova", "MD");
        codigosPaises.put("Monaco", "MC");
        codigosPaises.put("Mongolia", "MN");
        codigosPaises.put("Montenegro", "ME");
        codigosPaises.put("Morocco", "MA");
        codigosPaises.put("Mozambique", "MZ");
        codigosPaises.put("Myanmar", "MM");
        codigosPaises.put("Namibia", "NA");
        codigosPaises.put("Nauru", "NR");
        codigosPaises.put("Nepal", "NP");
        codigosPaises.put("Netherlands", "NL");
        codigosPaises.put("New Zealand", "NZ");
        codigosPaises.put("Nicaragua", "NI");
        codigosPaises.put("Niger", "NE");
        codigosPaises.put("Nigeria", "NG");
        codigosPaises.put("North Korea", "KP");
        codigosPaises.put("North Macedonia", "MK");
        codigosPaises.put("Norway", "NO");
        codigosPaises.put("Oman", "OM");
        codigosPaises.put("Pakistan", "PK");
        codigosPaises.put("Palau", "PW");
        codigosPaises.put("Panama", "PA");
        codigosPaises.put("Papua New Guinea", "PG");
        codigosPaises.put("Paraguay", "PY");
        codigosPaises.put("Peru", "PE");
        codigosPaises.put("Philippines", "PH");
        codigosPaises.put("Poland", "PL");
        codigosPaises.put("Portugal", "PT");
        codigosPaises.put("Qatar", "QA");
        codigosPaises.put("Republic of Korea", "KR");
        codigosPaises.put("Republic of Moldova", "MD");
        codigosPaises.put("Romania", "RO");
        codigosPaises.put("Russian Federation", "RU");
        codigosPaises.put("Rwanda", "RW");
        codigosPaises.put("Saint Kitts and Nevis", "KN");
        codigosPaises.put("Saint Lucia", "LC");
        codigosPaises.put("Saint Vincent and the Grenadines", "VC");
        codigosPaises.put("Samoa", "WS");
        codigosPaises.put("San Marino", "SM");
        codigosPaises.put("Sao Tome and Principe", "ST");
        codigosPaises.put("Saudi Arabia", "SA");
        codigosPaises.put("Senegal", "SN");
        codigosPaises.put("Serbia", "RS");
        codigosPaises.put("Seychelles", "SC");
        codigosPaises.put("Sierra Leone", "SL");
        codigosPaises.put("Singapore", "SG");
        codigosPaises.put("Slovakia", "SK");
        codigosPaises.put("Slovenia", "SI");
        codigosPaises.put("Solomon Islands", "SB");
        codigosPaises.put("Somalia", "SO");
        codigosPaises.put("South Africa", "ZA");
        codigosPaises.put("South Korea", "KR");
        codigosPaises.put("South Sudan", "SS");
        codigosPaises.put("Spain", "ES");
        codigosPaises.put("Sri Lanka", "LK");
        codigosPaises.put("Sudan", "SD");
        codigosPaises.put("Suriname", "SR");
        codigosPaises.put("Sweden", "SE");
        codigosPaises.put("Switzerland", "CH");
        codigosPaises.put("Syrian Arab Republic", "SY");
        codigosPaises.put("Tajikistan", "TJ");
        codigosPaises.put("Tanzania", "TZ");
        codigosPaises.put("Thailand", "TH");
        codigosPaises.put("Timor-Leste", "TL");
        codigosPaises.put("Togo", "TG");
        codigosPaises.put("Tonga", "TO");
        codigosPaises.put("Trinidad and Tobago", "TT");
        codigosPaises.put("Tunisia", "TN");
        codigosPaises.put("Turkey", "TR");
        codigosPaises.put("Turkmenistan", "TM");
        codigosPaises.put("Tuvalu", "TV");
        codigosPaises.put("Uganda", "UG");
        codigosPaises.put("Ukraine", "UA");
        codigosPaises.put("United Arab Emirates", "AE");
        codigosPaises.put("United Kingdom", "GB");
        codigosPaises.put("United States of America", "US");
        codigosPaises.put("Uruguay", "UY");
        codigosPaises.put("Uzbekistan", "UZ");
        codigosPaises.put("Vanuatu", "VU");
        codigosPaises.put("Vatican City", "VA");
        codigosPaises.put("Venezuela", "VE");
        codigosPaises.put("Vietnam", "VN");
        codigosPaises.put("Yemen", "YE");
        codigosPaises.put("Zambia", "ZM");
        codigosPaises.put("Zimbabwe", "ZW");

    }

}
