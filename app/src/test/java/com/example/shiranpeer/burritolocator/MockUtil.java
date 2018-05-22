package com.example.shiranpeer.burritolocator;

import com.example.shiranpeer.burritolocator.model.PlacesResult;
import com.google.gson.Gson;

import io.reactivex.Observable;


public class MockUtil {
    private final static String RESPONSE = "{\n" +
            "       \"html_attributions\" : [],\n" +
            "       \"next_page_token\" : \"CrQCLgEAAN4REXj7kbcxDPOdcIcFAKqy6_xLWhxGRjLIxpUmd2d9C1Vk2ySEmahKs0XQ1MNKl_6_slfxp4EcDC1yZvFrCiWWBXlm-U8OtaqYtt0SMhHZ-aVkbRnAu78jYU2Y6B4yetIJ7WyCax0SoD9X4cQ9ero3qXKdiGYbLUSAVqj2_XWOSvyQGs9AVI5wKeM-o_h1QyzxXV2UdTJDIwLOep1Wy18vKOZ637RVYSoeJADwqlkncFpEvfSJFsoUvqtP4527GpSTzO3jZFglLiWXnARG4Z7rfOKaAXFlc2IMGMVxQERfiCxlhu_Pzt_zLQXiKDpXLOskX1-pHYXlgsY231eDdWwBSlsovAFq8eh7o0RH_n7RPCgwjnxFLiv-TKlnjbLUTDiLfoCYupo77lxwly3l-IQSECH9ad5PFaBgPyN62MXZ-0oaFJf-2jOeV_okP2t2TMPIcoRg-gnz\",\n" +
            "       \"results\" : [\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7415446,\n" +
            "                   \"lng\" : -74.0318668\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.74294117989271,\n" +
            "                      \"lng\" : -74.03050272010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                     \"lat\" : 40.74024152010727,\n" +
            "                      \"lng\" : -74.03320237989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"1821ea0d310cbc99d76b8761dd9116c806e44b02\",\n" +
            "             \"name\" : \"Hoboken Burrito\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3000,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/110074078184611616421/photos\\\"\\u003eMatthew Goczalk\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAA05-n-7BCflj_0oXt7vWUtzi4e5mQ2lB_IbGw88srWhrhLK2g5zzrdBYdypnWN1YxWoWEZel4Ie_FpLypyGX9-a-UHr1JTByYWTvx6jlp9lV13c9WFmDhHiry0VclNEfMEhDCLDlSknl7e8YDLck1svSTGhR-oB96_QppD675U76Pm3-i7tBbDw\",\n" +
            "                   \"width\" : 4000\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJh0GSxF9XwokRCBRRwDJvGZg\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 3.9,\n" +
            "             \"reference\" : \"CmRbAAAAlRze9SOk9uIQyTV7s5K7nnhq3ntJIPaLJse6cmZv9vcnkJhkCWmsahhntyLQ-zRax1LSAok1Xbivwn-P469w9NhZKUQRv4pw9ZVSlCRI9KmBTFHUllkETlFllLhRwRlhEhBBc1vuvb3lfiU-OqpZHGYQGhQXpviLBUArFC1tVkbcbWugLSYF0A\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"209 4th St, Hoboken\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.742341,\n" +
            "                   \"lng\" : -74.0053925\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.74352047989272,\n" +
            "                      \"lng\" : -74.00370997010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.74082082010727,\n" +
            "                      \"lng\" : -74.00640962989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"57f46f82ed3691d6cbb8a0ff4ac2f12ded1a0229\",\n" +
            "             \"name\" : \"El Donkey\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3818,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115331498877740549635/photos\\\"\\u003eJessy Yokole\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAvsZtV4KNgEVPZTCTZkiZKAk6KwfrbhfEzgGoV48PlNNsRx1IWxl8so-BP6WGNoZrxBTf57EMeCfNBEIwNr3wXfur_L0K4f7obxX7lXHduqw8lHTeW32_s6vp7YGKb-1wEhB5qrjllC75vOUX9IyGYRFbGhRMvhF6iBHRK5UgQICuH2oYyyPSkw\",\n" +
            "                   \"width\" : 2545\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJt1mGQb9ZwokRS2PgQB4hvts\",\n" +
            "             \"rating\" : 4.9,\n" +
            "             \"reference\" : \"CmRbAAAAifnQZc_TB6o8LRVmQVB6HNLNSIwQmHIzOWcZAAThVq0ugct3JgiOW4ceG9hIOVNpNND29ofge0nI7u0pLIy_zVXgRv0OVMJwN3YrHguu8aZOzU8c38xrCedqxCOo8cYcEhAveiovE-yfqYkRjLDYt9KtGhQUei3sh0kVoeb1J1po2DJ9RtBh3Q\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"75 9th Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7380178,\n" +
            "                   \"lng\" : -74.0021251\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.73942052989272,\n" +
            "                      \"lng\" : -74.00075797010726\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.73672087010728,\n" +
            "                      \"lng\" : -74.00345762989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"9ee909fa86619d37bde93e53d624bb6b44f99a8a\",\n" +
            "             \"name\" : \"Benny's Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3328,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115536672395068358630/photos\\\"\\u003eEdna Orellana\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAzD8CUUPyCS_ilAzNLFPb4HggJpOpVOkjyT0DgC77dTq10FVspeZOC58srcDhF2HW-OvIBBan-tw7dBahbtZcjdM5yNqNWP1KFHaSwsVu9PaPSPJMT7PVyGV4v3N0hxESEhDwiSdAOGib4Y3lZj1RSKM6GhQhzYN_dXaeL91M6Tv6FPB53Fl3cw\",\n" +
            "                   \"width\" : 1872\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJ6cQPIL5ZwokRjklIZSK5viM\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 4.3,\n" +
            "             \"reference\" : \"CmRbAAAAGSPrqxmwLNokrH0JD3paB_me5hDqZuZO19K1DsNYc7ghMbrE2nb9eOZQRP8aDiefq4knQ2oXbrfM2pypPhsPlaDTEaMX-yG8Y9yMhNO3Rua9KgdSUFqM8UeUtmhu6fEQEhDFXR1-SmhmL73dFB6adgX7GhRvgCZKbgnB2XwRaHJnyfm4uGpd_Q\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"113 Greenwich Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7741576,\n" +
            "                   \"lng\" : -74.0242013\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.77554702989272,\n" +
            "                      \"lng\" : -74.02294217010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.77284737010727,\n" +
            "                      \"lng\" : -74.02564182989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"c23af4a8ecc59bd172ac9079706be02dc6956f4d\",\n" +
            "             \"name\" : \"Burrito Joint\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 1511,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/118105019711903091121/photos\\\"\\u003emichael patterson\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAFdEBgebMm7gooCocg3xw42_fjf2yhhmUNa-JC-Grw3ROka7Cfa2EAAylddDehNgDzLKkkrclmDnk7TVzrkbnqdSr2VgBTs0TPr0SOwRPjLaaOSqaSDRxG-lfIzwKkQXZEhCkJ4UUIQyenC1s-vWy5b58GhRxsMPp2k6aHDk3zDXs40kdVwn8JA\",\n" +
            "                   \"width\" : 1967\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJE45vniZYwokRjMAEeyQd2MM\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 3.3,\n" +
            "             \"reference\" : \"CmRbAAAASI2Dzlxe1nUoV-gGfrazeeMmAsMPgKSzDvuMTaMIq2Z7TcvWI5DeHd5ivTfzWMOs2Pa34PlFeVcM4jHgI1FjthJVX4GWeHKoz6Re01wQCDAYPBthZd8b2pSZ5m_6Rm5nEhBhmgOYNMKr2HFpD1qMrPNLGhTFCvVzu60v0F1Ha9o1j9YQmZ_wlA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [\n" +
            "                \"meal_delivery\",\n" +
            "                \"meal_takeaway\",\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "             ],\n" +
            "             \"vicinity\" : \"6162, 3800 Palisade Ave, Union City\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.731971,\n" +
            "                   \"lng\" : -74.001513\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.73332082989272,\n" +
            "                      \"lng\" : -74.00016317010729\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.73062117010728,\n" +
            "                      \"lng\" : -74.00286282989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"2d6a1d062005ed5ea5eee4541826e04d1369e7a9\",\n" +
            "             \"name\" : \"Burrito Loco\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : true,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 1500,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/105095062978484786996/photos\\\"\\u003eBurrito Loco\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAm8R2u8xEQmExjzKF36k7qWRuS0b47R0foZAQg7mRi_sIi1yS6Eu0IUdvWWspgg3sCQAVXj44Og8pyE-qrzVsPeuWUziXNortxFBQ267mNfzmONc0MpTaDvc4yuCun_CBEhAQSYyPbkTmDgDFesFW5hU5GhS03Vg92U0P3Hc44xCprbTrmi-cZA\",\n" +
            "                   \"width\" : 1500\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJx-Dt6JNZwokRhs8twLKl1wM\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 3.9,\n" +
            "             \"reference\" : \"CmRbAAAAsPNC4tjpIt8OfmxI3BNUdc9dsY2C0TgruzcyE790SsJR2R_MD-ruECxXoL_KRWuIPQYwbmGp4fJwTYFcLaOu60v7KBW3-fZq-1bbs0du_iGP97ZoF_jFeGBrxIB5cSj6EhDvmlcXq0Ie3pCbuNfl1aJqGhQID4GjfYNU9aOklWXV16P-mM-0wA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"bar\", \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"166 W 4th St A, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7428572,\n" +
            "                   \"lng\" : -73.9931725\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.74428477989273,\n" +
            "                      \"lng\" : -73.99176567010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.74158512010729,\n" +
            "                      \"lng\" : -73.99446532989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"1daef4bda37ca3281c6b76f65dfea273a8653022\",\n" +
            "             \"name\" : \"Italian Pizza Great Burrito\",\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3024,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106235420784657520966/photos\\\"\\u003eRyan Fisk\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAA6OltYCksCnL14CdzTh8MC4ExI6i9dAH8Lt8LDmeJYUMXtHFMK_VhNl2-vBq-WzEWWf3yd1vjchJC3b5k-CD9KPIIBEEQlnMNsogWU41ml7XzaUNuoCySUyDPlu8COZVsEhDpLtcUHd6LQv-tIMbeq6fqGhQehmfi1ESEyW9u-EjmWQYxzjWdIw\",\n" +
            "                   \"width\" : 4032\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJ1_8TlaRZwokRyzYr0qN_66s\",\n" +
            "             \"rating\" : 4.1,\n" +
            "             \"reference\" : \"CmRbAAAAGWAQHPvjuK6iUCVCa_Srz5yfCFxY2Aumm4Ygbpo5NCGVNYx48YnH0zGBSw_VhdA0au1ailRlhjGvYmtjGywcavakc66csDXRyu1MzTmdN4M50fK3bNUQkx6z0cA3CzLpEhDXkKn4bcaSTL_AGCnBGURpGhTEAIsmjeM_EkyYy9oSIM2Di5g0lw\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"100 W 23rd St, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.778423,\n" +
            "                   \"lng\" : -74.016937\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.77972082989272,\n" +
            "                      \"lng\" : -74.01552742010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.77702117010728,\n" +
            "                      \"lng\" : -74.01822707989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"bb16afeb634182bcdff37232a43bfed04f072494\",\n" +
            "             \"name\" : \"Flaming Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 2988,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103533786290341394824/photos\\\"\\u003eSwaroop Shankar\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAATFChxtZVULnRt1Z5dg0I-7QhYMbZDYgZSY1MJN7dp9cQFhKZoL-JNefzU2rOiamYuz1teNv5omTlvog8VqR5-MDnL2q7gRutm2JKl2XippyTXLBuxL1fn5O-gsTIYwzXEhABVbl7XLogAtnWXpkMNv6rGhTSR77TgUBHhs3pwIkz8hIl7S-yUw\",\n" +
            "                   \"width\" : 5312\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJu7x9Pz1YwokR_Zz8uTo6gGQ\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4,\n" +
            "             \"reference\" : \"CmRbAAAANVbbkdZ0vTvgUWVhTSgkL-mrkAFZhocp0JErSktVzMENZOM05wvoJIEtW7xeuiLerhUED2sHuVYuvv-LYn9Tim5OtfeccDT1m05Y1ZrGQk6E92JkF3cGmvtvH8F5jzQEEhA_moTOjXVpdyHgrDpsFftzGhRXuFRbBg7iNmwrnVRzzoDgpEJkPw\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"4625 Park Ave, Union City\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7603167,\n" +
            "                   \"lng\" : -73.9909033\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.76162972989272,\n" +
            "                      \"lng\" : -73.98958032010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.75893007010727,\n" +
            "                      \"lng\" : -73.99227997989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"89038f220643e9d909ca28f2c2f9177889480a7e\",\n" +
            "             \"name\" : \"El Rancho Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3265,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109859902627551758855/photos\\\"\\u003eIskander Matsayev\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAY5yziBY7NzqLCOwkTW3M7JqN_NbNql0VxPgzINUfdZvYeuNiL_CMAjTFLSe9SBEkON7EaIkDkIV3KcUenyW4guMLTHpft9SO6UiivBaRAujimGG8xQXHhtcScF0JWIjaEhC0uJFWPQynG4A4bP7VIKiPGhTj4i1V4orQrCLNq5kYRjsee4gTgA\",\n" +
            "                   \"width\" : 4898\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJWXM2xFNYwokR3Spn7fwX7Og\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 4.4,\n" +
            "             \"reference\" : \"CmRbAAAAkdcgZFmc7jVJhftXJgajzZ5wLcOwfSeE6Kxu7O9D74RafnDzzUa7tJ7ayip9XD3bTyLXFLIfwBaqppBi5yPE-7EgwKVPLuqggCCd7dI7aianEDqPJ03r6M4OIRiYzWGCEhDc2h5hwLclPztvA6GTCutWGhTOhfK_XQhqgfOpR13NizzDAlX-KQ\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [\n" +
            "                \"meal_takeaway\",\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "             ],\n" +
            "             \"vicinity\" : \"1611, 359 W 45th St, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7173738,\n" +
            "                   \"lng\" : -74.0483478\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.71873777989273,\n" +
            "                      \"lng\" : -74.04704267010729\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.71603812010728,\n" +
            "                      \"lng\" : -74.04974232989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"3134671778ec175b18a91678ab1645c53152f16f\",\n" +
            "             \"name\" : \"Bubby's Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3024,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/101481702329173961903/photos\\\"\\u003eLaine Warwick\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAzpWBoAjmMP8s583ReRzw3Nk4aeeRmN8Y1l1ldKBxZKmRWWEfHr-e95q3JkKILGeeLKbILzER2DwapTnUZZ71gLum7xfAH9-qvVsBK2sC_sViOeKRdFLSsqB7vJMG-KsMEhDJFzE4cKZ7ISugklTeDre9GhQ9sOkJzSdijhNrXaE3oFGTZFjFeA\",\n" +
            "                   \"width\" : 4032\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJp4bqJ7dQwokRdve8tBKuX6M\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 3.7,\n" +
            "             \"reference\" : \"CmRbAAAAKRG0XVymwt3LUp3SXhxV6mBFlzDaDDbfgHLJgTbvu8qjBituHNn26pAuxmKZYUSSyvHHoeDN2NmekNzaGiduQHLh2ejjks4vYBaEC5hPRAOCIbMlur-Rfh4Jt7r8qzkbEhAJ-ThldFPVs99ndxOVAJYUGhSdBY43NSR-wg_gYEGKMNbf9TaAoA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"440 Jersey Ave, Jersey City\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7147234,\n" +
            "                   \"lng\" : -74.01563449999999\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.71600787989272,\n" +
            "                      \"lng\" : -74.01433707010726\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.71330822010728,\n" +
            "                      \"lng\" : -74.01703672989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"e54cf57264aefb1941d5f592afb0c9108f1da961\",\n" +
            "             \"name\" : \"El Vez and Burrito Bar\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3652,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/112576334783900279915/photos\\\"\\u003eEl Vez NY\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAfSejCkZtTxC-3hIfAHiyzOhZ-125ukAmb4pVpU8U-XWM3rBoeRU1B0G2TfbpzMTs5oOaQTAsOGDy7uq53kHj0o6KpxJFYwiDPU8fjFnaDSyTrHJ4A3r6RQNB07qyNYPoEhDTkA0hg2vQDHQwqQNQkCvlGhT3Zh7aH8g8H3Tcei37jsDJlRgTLA\",\n" +
            "                   \"width\" : 5028\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJUSnLnRtawokRvxs34iq8GpQ\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4.3,\n" +
            "             \"reference\" : \"CmRbAAAAxOrlyp22VqIzrGqj27H7Ik3dVpZq93j8bM7xBMLWcLKOHy76H0klsdYGaqzwiV8US3LMje2opz-A6wrdwDenRtVxQE22ffPxRpULQlSa1Ksw8sWXv_FaF4RM0hrZFAVwEhB9NoRhKA7ltwnSp3mJD0rWGhRchOFR6GiElhOBcfr_g8s2GaFFKw\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"259 Vesey St, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7683048,\n" +
            "                   \"lng\" : -73.985698\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.76961272989272,\n" +
            "                      \"lng\" : -73.98425167010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.76691307010728,\n" +
            "                      \"lng\" : -73.98695132989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"0f5baa1c3805fc183b74a19d299597eb9cf3a5d0\",\n" +
            "             \"name\" : \"Burrito Box\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3888,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/102257174320158708995/photos\\\"\\u003eBoris Medina\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAgf_OLadyhqe5agPPeuvhx4A3hC6K7PzOnpf01cgXeIgT7wX5c2DQfNa17w7PE1a5nxqS_enIJ5tJAqMOWLaLcvtyPoP71ujQEC1mROX2FeLbyG320oh8QOZxMYka_TS-EhCJnXgzTQKdZCIBtFPN0jqCGhQbC6G38W1zrHE9m_foJmHDZM-kTA\",\n" +
            "                   \"width\" : 11168\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJZ-1h-1hYwokRSIEBjADBg6A\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 4.5,\n" +
            "             \"reference\" : \"CmRbAAAANvU6y5IqJSk3xLlWyVgLgTZpdeCgZ96BIS9cY1wakQFEjJP5WxFw2CB1jmbmTegI52vxFqekTUyHAK7RJOoORFBXkM6vpMSNmHNuBDHMO572nmdhvzHeJAB1el4SPaZqEhAt2CHyvsUbwW3FWzJ7Ri2VGhRgpQo_Z3zEpc4JsOekB2VB6dgsFA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"885 9th Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.71578,\n" +
            "                   \"lng\" : -74.006957\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.71718827989272,\n" +
            "                      \"lng\" : -74.00573107010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.71448862010728,\n" +
            "                      \"lng\" : -74.00843072989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
            "             \"id\" : \"b5def9ef060fd7c27f7a10b515fc82174899b114\",\n" +
            "             \"name\" : \"Burrito Mariachi\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 2688,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/101372704320460432191/photos\\\"\\u003eJ.D. Achille\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAmsyDDvZ6ASzNeKlcjNtisA4DVfL5ccm9w3QquWqqLxLmtmH9Y_hahqiX_ilXnAEP_NGRroRnO68CsNsAgHD11E5w7xhcMCpYL748d9IWTgG9sgCM1XHtKGEOdnGWKeFmEhAoOjUC2SyarLx7OvUORAxOGhSdjXCVNteY3zUIlDwwHL04kNoXCg\",\n" +
            "                   \"width\" : 1520\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJaX8GZR9awokR_AtlRD-f7mU\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 3.3,\n" +
            "             \"reference\" : \"CmRbAAAAmv1duzrtTcqcP2UG0A9KpRykvRhvZh_znqSyX0GbwSRH-LjGAKsqMg4l__GQ-C6MAsTvjVfmVD3B6CZWWloBGLaIBys2wpuOG873K5hvBfgmhNBQJveQvSucIJ0kRfKEEhAwhktatpCaOrbPjw5oGTF-GhTYQsvNP-6FlDGEoeHlt6Rcfz9GBw\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [\n" +
            "                \"meal_delivery\",\n" +
            "                \"meal_takeaway\",\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "             ],\n" +
            "             \"vicinity\" : \"189 Church St, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.787402,\n" +
            "                   \"lng\" : -74.0125347\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.78872227989272,\n" +
            "                      \"lng\" : -74.01112102010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.78602262010728,\n" +
            "                      \"lng\" : -74.01382067989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"e3f1c71248245b754e5ea2cacb117db3bcdaa181\",\n" +
            "             \"name\" : \"El Burrito Loco\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 521,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109749038875349747046/photos\\\"\\u003emanuel aguirre\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAsFwcTOoVIKmc7sYs9iC0mlYg0eovNjpi45bOm6eVG_TTH9fZ20pzU1f4UCSuLD5GG71JfW13M58bSKDPnKCQUMgwnpAb898eB6WNmAGUQ3VnwS-IufONh5PwztpW1OZ1EhAO5cYDoQ1OU72hlFiglPSBGhT285L6FSh5744rQXgEaLN-zZUi_w\",\n" +
            "                   \"width\" : 750\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJBzr2iRFYwokRb26n5YJrFZw\",\n" +
            "             \"rating\" : 4.4,\n" +
            "             \"reference\" : \"CmRbAAAA3SjZke-9zENnMaC6cDRR58Rf1AlQSfWhoHJO3tgwBb-b8HhcPSa9UDUIgp3MdLRM7T_A4Q80KgTe3n5KV36ZB8WJv0VQBnksAcC6udtrBx7YaWTk7wlWtLW0Wp5Ws5ifEhCvUHfORZxueo-W0iXk-2D5GhS1TZZ0cUvAeVshrz6MG179wvfECw\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"2860, 6005 Hudson Ave, West New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7551387,\n" +
            "                   \"lng\" : -73.9681066\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.75652437989272,\n" +
            "                      \"lng\" : -73.96684292010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.75382472010728,\n" +
            "                      \"lng\" : -73.96954257989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"483796d9d3d0fce8de442d3980cdc2a77da500f6\",\n" +
            "             \"name\" : \"Blockheads Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 2322,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103645845165996345357/photos\\\"\\u003ePHOEBE SONG\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAydVoqFUzSmAzfqtb76uMRc7qR68iCWXVwnovEpeYTsR5u24jN6weZLIkEpVoAulRo7HTMJmNdWbjnB0jvTyaTOCpeBaAu_pSnylyzzzF8iBcW8gGJdOTclH8ZoUG2EyBEhDD3bwqfhrvLSHDFk65puO5GhRkkndVJEZW8esfyJoQtvjUazh_4g\",\n" +
            "                   \"width\" : 4128\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJRV6GVuJYwokR7kW0eagnDjY\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4.1,\n" +
            "             \"reference\" : \"CmRbAAAAEHyqAmVc6eq4MUVgTPS-Bj9QaSRdnPrQXyJzQEJ1U9qYxainFZ_C7X9PvIfK4B_uc5gi2pFhMVYutxQGquZC8oqMzyMOY3B2UCCaDPJR2aPtZqwARlOkQJ9hwXsDcBOaEhCzmW_6cmGcV7VuF_zCP1SQGhT_TpQsW2Vi_7oxxR85xoGIJG9Q2A\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"954 2nd Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7833439,\n" +
            "                   \"lng\" : -73.97796049999999\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.78473087989272,\n" +
            "                      \"lng\" : -73.97669867010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.78203122010728,\n" +
            "                      \"lng\" : -73.97939832989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"442363610a51a99807ee5dfa05d6c20970bf0f24\",\n" +
            "             \"name\" : \"The Great Burrito\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3088,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/108878126397640676453/photos\\\"\\u003eUğur Güney\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAA-J45TW4WdEnCyWF2Vel1ghppZqztsKanabPG2_RLTfsEfenEKZmwIoJUyDfiWelIuXdh2YGrm9gq0rVje9lrRuczP2YBU6B6chH0kZkX6q5Mas_9VvdILaFsqZ1lVawlEhA5AeTjS1rsPwVXD9xxz1v2GhQG6TTsA2GvB7zezT4mHoeWY8ptcQ\",\n" +
            "                   \"width\" : 4160\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJH6XFuohYwokR4WAtnrkS-MY\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4.2,\n" +
            "             \"reference\" : \"CmRbAAAA9qB20oGgLzRj5a3Yi5TzvwEvxkdusuMlDctO49XQA9qF7zhlVdhnRZb1kw1St94tvfiUuxv69hZUcjtv4f-6RzHcWuhzj5H4rfa9zjQQCwoeGaBGaCVHloqNLTjoGJboEhCtYNXN-4CtVxhbPw8e79l_GhSJchS9MhaOEQpV-meKrjJrdmDo3w\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"405 Amsterdam Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.790617,\n" +
            "                   \"lng\" : -73.972506\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.79172017989271,\n" +
            "                      \"lng\" : -73.97133732010728\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.78902052010727,\n" +
            "                      \"lng\" : -73.97403697989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"63911e757e7bb0c1ae394da57ef62e5c3b1ac33c\",\n" +
            "             \"name\" : \"Blockheads Burritos\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3024,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/107877051766907127092/photos\\\"\\u003eJuan Brito\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRZAAAAZ5YERDBy9HMObF9z86vruEEWEa15Rxn6yR9uiAJ5Kj8XBBY33vP2inhERP3qv8USx675nUJXk7Q-6efi37NoJo8S3fid830-wuStx_E9UsGpEFV46iyvBF0IXNNPrhg4EhBLSsnC4r-L17yeevf69wGPGhQ9huPSZWE1Id_UZcKAc5V5zQ0QPg\",\n" +
            "                   \"width\" : 4032\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJJ-XjsL5YwokRy3FWZ3EshR4\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4.1,\n" +
            "             \"reference\" : \"CmRbAAAAAKuixgNDvHWxMOfgu64pkyYA0Yw16-dvSKtpZ1Z8W5G3nBbT6a_yYLLBbeJbVevVR_qv8PchN0_pSatpOdErUxO6AuAerhbv8z2_VZBHzMwTN5UelJ9WAC9vSFVZsSMqEhCkhd36ZBLIV3WchbXVEj_9GhSXlYzTHI2WSCXzkB5lnTBedxMu-A\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"bar\", \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"175 W 90th St, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7748781,\n" +
            "                   \"lng\" : -73.9541476\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.77619427989272,\n" +
            "                      \"lng\" : -73.95271762010729\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.77349462010728,\n" +
            "                      \"lng\" : -73.95541727989273\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"26c298753afb489c742fa6f30b64d76af3b8bcb3\",\n" +
            "             \"name\" : \"Blockheads\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 1360,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/104111246635874032234/photos\\\"\\u003eZAGAT\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAeoLKajGwNYGZr0K85-l7Dsow92ndR0tfYunn4udjqQ1L-KWrsJx80ZhCOUt21eFuDxMqHxza6FoIayEwSnryqHKjBEX1k3h2TcC_nqISYusEr31fRPApMQm96wRGB1C2EhAMPx1Sx9D_15B88YL9mIrVGhQ6EDy-urHtuQ1EbRNfqL-cWSIjSg\",\n" +
            "                   \"width\" : 2048\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJJ-XjsL5YwokRxZBYbDz4ctM\",\n" +
            "             \"price_level\" : 2,\n" +
            "             \"rating\" : 4,\n" +
            "             \"reference\" : \"CmRbAAAAgf_BAydU3EUa84nk33D3Ewfxa4gL1ScqwC3Ih5bt-zCBx_a6CzAIxLqF0gSXcbuT6aVETWcB6BtVIZmcPZFgVa6UL2y-yk_HVLYhoenPMb2XEvQDN-ZyG6pWfxJgTdXxEhADKV4dlEAj1xtKTOh6x0JWGhQ2amDzeyv4Gig-_pG1vCQ3qgsE_g\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"1563 2nd Ave, New York\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.7140308,\n" +
            "                   \"lng\" : -73.9614412\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.71540347989271,\n" +
            "                      \"lng\" : -73.96015382010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.71270382010727,\n" +
            "                      \"lng\" : -73.96285347989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"db47d1c870176a975a18f794e0d57ac2e842f099\",\n" +
            "             \"name\" : \"Border Burrito\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : true,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3024,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/104824001270022389102/photos\\\"\\u003eNicole B Garcia\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAwGWPnIORuJfNz6Ll__VbzaJsKKQNPfVIgeb7jCUgGfprmHMTLeaW3IMcxqhvCZLDlhPheaxS_80F05ogr3EPTMkuWspRvGoecV5_YebvClgrjASI447uKytLnhcw5XqaEhACySuJGtqQqnDEhZ_PBOwlGhRPNp9aJJbwYH-A3ahF2rYo0UtZxA\",\n" +
            "                   \"width\" : 4032\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJo25ZQ2BZwokRWyR8XMWmado\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 4,\n" +
            "             \"reference\" : \"CmRbAAAAMI8Y9pWVeJczoOwJl1c0thgD9aLriGrHY0REIV-31W_gaKq55w78HAzU4c8a13kp3boN_D3680Ve0rxzLMPmKxw-MQ45VK6lm4GeQutxDqsrcAvZ32TOc33CQFhDIsnLEhAcecXE5YaS7u9vg7j-beg_GhQ13UCnsOMv6ys2AkqKI87rknFUvA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"287 Bedford Ave, Brooklyn\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.6852749,\n" +
            "                   \"lng\" : -73.99482519999999\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.68658422989272,\n" +
            "                      \"lng\" : -73.99332917010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.68388457010727,\n" +
            "                      \"lng\" : -73.99602882989271\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"0fdcf4c8b8c4b48687207f721488e6f345ef4621\",\n" +
            "             \"name\" : \"Buddy's Burrito & Taco Bar\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 3024,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/110378829880817413082/photos\\\"\\u003eCecilia Vargas\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAASEAQplP9U5ysL4TRI2tD3390ZmPuz2GMrsSssKuHMKS4a5blcu3PAZ01ApAM_yuIRTQLs7L-bWqMs2dEy6h-09lbBNZqaglmeWJ5mQvdwOpgqCovqmsqEgmZfSoCdC8gEhBoUR21J9q8cSXPKU8-ICbXGhSEcreSyhK56aFgtJmfWMUqVil6fA\",\n" +
            "                   \"width\" : 4032\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJd_T6flBawokRaPBsb0kadeI\",\n" +
            "             \"price_level\" : 1,\n" +
            "             \"rating\" : 4.2,\n" +
            "             \"reference\" : \"CmRbAAAAu1rzQMOAMFxxE4KdymC0jDH5SbOLCueDILqJD0HBfu8rFy7eOnG7Or_qtFBSVnGbk_fbsG_YhuUOdfC_H4mOGO0PzAB1pez670xHLVTus-cdAbpgLrlUjJ7c5dky64Q4EhCC_pSswK5xkSJKVJFUiCMvGhTLSeopO0KhKtJUR0_TVszAQxw9JA\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"260 Court St, Brooklyn\"\n" +
            "          },\n" +
            "          {\n" +
            "             \"geometry\" : {\n" +
            "                \"location\" : {\n" +
            "                   \"lat\" : 40.688024,\n" +
            "                   \"lng\" : -73.98685499999999\n" +
            "                },\n" +
            "                \"viewport\" : {\n" +
            "                   \"northeast\" : {\n" +
            "                      \"lat\" : 40.68938152989272,\n" +
            "                      \"lng\" : -73.98552502010727\n" +
            "                   },\n" +
            "                   \"southwest\" : {\n" +
            "                      \"lat\" : 40.68668187010728,\n" +
            "                      \"lng\" : -73.98822467989272\n" +
            "                   }\n" +
            "                }\n" +
            "             },\n" +
            "             \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "             \"id\" : \"76584c5a14010d163571b4377a0a47330ec8d4c2\",\n" +
            "             \"name\" : \"Fast and Fresh Burrito Deli\",\n" +
            "             \"opening_hours\" : {\n" +
            "                \"open_now\" : false,\n" +
            "                \"weekday_text\" : []\n" +
            "             },\n" +
            "             \"photos\" : [\n" +
            "                {\n" +
            "                   \"height\" : 1050,\n" +
            "                   \"html_attributions\" : [\n" +
            "                      \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/116309985350546379263/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
            "                   ],\n" +
            "                   \"photo_reference\" : \"CmRaAAAAtg_SGQH7d5yLaGye-43t2HgoiYYTLzPxOdsjBbI5ZQ0LJpB6D7ARwmevELNyoIHJV8xz33actrSiICyw3fQcAZqpNDtklI_0fPXtVSH_eCmuAJS6X4S9GC-54tej4UvfEhC9zALDnMyq00LmNteFELSWGhQD0eKRNCxSJ8ghiQwuUruz8Xkc8Q\",\n" +
            "                   \"width\" : 1400\n" +
            "                }\n" +
            "             ],\n" +
            "             \"place_id\" : \"ChIJ373ku01awokR5HR1TQhZnvE\",\n" +
            "             \"rating\" : 4.5,\n" +
            "             \"reference\" : \"CmRbAAAAbo9XWNiIuwPb-z8dQe-CLX1sabIJY4mtQCtvjTyqB1VXN8jwEAnb2AaivTbdZZn9OMAOKGZ0KUdpfY-9D7l6ml0txQyMVIyMeKXcRb-nBrHAWWAUYJQHpZpDarNeClGNEhAT8ZOqJFeHQdN5k7JjiCZOGhQrY8QwesHulYmZqjcHNf994lRFww\",\n" +
            "             \"scope\" : \"GOOGLE\",\n" +
            "             \"types\" : [ \"store\", \"restaurant\", \"food\", \"point_of_interest\", \"establishment\" ],\n" +
            "             \"vicinity\" : \"84 Hoyt St, Brooklyn\"\n" +
            "          }\n" +
            "       ],\n" +
            "       \"status\" : \"OK\"\n" +
            "    }";
    public static Observable<PlacesResult> getPlaces() {
        Gson gson = new Gson();
        return Observable.just(gson.fromJson(RESPONSE, PlacesResult.class));
    }
}
