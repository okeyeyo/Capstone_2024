package com.example.capstone_2024;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Food implements Parcelable { //음식 생성자

    private String id;
    private boolean isBookmarked;

    @SerializedName("RCP_NM")
    private String name;

    @SerializedName("RCP_PARTS_DTLS")
    private String ingredients;

    @SerializedName("MANUAL01")
    private String manual1;

    @SerializedName("MANUAL02")
    private String manual2;

    @SerializedName("MANUAL03")
    private String manual3;

    @SerializedName("MANUAL04")
    private String manual4;

    @SerializedName("MANUAL05")
    private String manual5;

    @SerializedName("MANUAL06")
    private String manual6;

    @SerializedName("MANUAL07")
    private String manual7;

    @SerializedName("MANUAL08")
    private String manual8;

    @SerializedName("MANUAL09")
    private String manual9;

    @SerializedName("MANUAL10")
    private String manual10;

    @SerializedName("MANUAL11")
    private String manual11;

    @SerializedName("MANUAL12")
    private String manual12;

    @SerializedName("MANUAL13")
    private String manual13;

    @SerializedName("MANUAL14")
    private String manual14;

    @SerializedName("MANUAL15")
    private String manual15;

    @SerializedName("MANUAL16")
    private String manual16;

    @SerializedName("MANUAL17")
    private String manual17;

    @SerializedName("MANUAL18")
    private String manual18;

    @SerializedName("MANUAL19")
    private String manual19;

    @SerializedName("MANUAL20")
    private String manual20;

    @SerializedName("MANUAL_IMG01")
    private String manual_img1;
    @SerializedName("MANUAL_IMG02")
    private String manual_img2;
    @SerializedName("MANUAL_IMG03")
    private String manual_img3;
    @SerializedName("MANUAL_IMG04")
    private String manual_img4;
    @SerializedName("MANUAL_IMG05")
    private String manual_img5;
    @SerializedName("MANUAL_IMG06")
    private String manual_img6;
    @SerializedName("MANUAL_IMG07")
    private String manual_img7;
    @SerializedName("MANUAL_IMG08")
    private String manual_img8;
    @SerializedName("MANUAL_IMG09")
    private String manual_img9;
    @SerializedName("MANUAL_IMG10")
    private String manual_img10;
    @SerializedName("MANUAL_IMG11")
    private String manual_img11;
    @SerializedName("MANUAL_IMG12")
    private String manual_img12;
    @SerializedName("MANUAL_IMG13")
    private String manual_img13;
    @SerializedName("MANUAL_IMG14")
    private String manual_img14;
    @SerializedName("MANUAL_IMG15")
    private String manual_img15;
    @SerializedName("MANUAL_IMG16")
    private String manual_img16;
    @SerializedName("MANUAL_IMG17")
    private String manual_img17;
    @SerializedName("MANUAL_IMG18")
    private String manual_img18;
    @SerializedName("MANUAL_IMG19")
    private String manual_img19;
    @SerializedName("MANUAL_IMG20")
    private String manual_img20;

    public Food(String id, String name, String ingredients, String manual1, String manual2) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.isBookmarked = false;
        this.manual1 = manual1;
        this.manual2 = manual2;
        // Initialize other manual attributes as needed
    }

    protected Food(Parcel in) {
        id = in.readString();
        name = in.readString();
        ingredients = in.readString();
        manual1 = in.readString();
        manual2 = in.readString();
        manual3 = in.readString();
        manual4 = in.readString();
        manual5 = in.readString();
        manual6 = in.readString();
        manual7 = in.readString();
        manual8 = in.readString();
        manual9 = in.readString();
        manual10 = in.readString();
        manual11 = in.readString();
        manual12 = in.readString();
        manual13 = in.readString();
        manual14 = in.readString();
        manual15 = in.readString();
        manual16 = in.readString();
        manual17 = in.readString();
        manual18 = in.readString();
        manual19 = in.readString();
        manual20 = in.readString();
        manual_img1 = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }
    public String getManual1() {
        return manual1;
    }
    public void setManual1(String manual1){
        this.manual1 = manual1;
    }
    public String getManual2() {
        return manual2;
    }
    public void setManual2(String manual2){
        this.manual2 = manual2;
    }
    public String getManual3() {
        return manual3;
    }
    public void setManual3(String manual3){
        this.manual3 = manual3;
    }
    public String getManual4() {
        return manual4;
    }
    public void setManual4(String manual4){
        this.manual4 = manual4;
    }
    public String getManual5() {
        return manual5;
    }
    public void setManual5(String manual5){
        this.manual5 = manual5;
    }
    public String getManual6() {
        return manual6;
    }
    public void setManual6(String manual7){
        this.manual6 = manual6;
    }
    public String getManual7() {
        return manual7;
    }
    public void setManual7(String manual7){
        this.manual7 = manual7;
    }
    public String getManual8() {
        return manual8;
    }
    public void setManual8(String manual8){
        this.manual8 = manual8;
    }
    public String getManual9() {
        return manual9;
    }
    public void setManual9(String manual9){
        this.manual9 = manual9;
    }
    public String getManual10() {
        return manual10;
    }
    public void setManual10(String manual10){
        this.manual10 = manual10;
    }
    public String getManual11() {
        return manual11;
    }
    public void setManual11(String manual11){
        this.manual11 = manual11;
    }
    public String getManual12() {
        return manual12;
    }
    public void setManual12(String manual12){
        this.manual12 = manual12;
    }
    public String getManual13() {
        return manual13;
    }
    public void setManual13(String manual13){
        this.manual13 = manual13;
    }
    public String getManual14() {
        return manual14;
    }
    public void setManual14(String manual14){
        this.manual14 = manual14;
    }
    public String getManual15() {
        return manual15;
    }
    public void setManual15(String manual15){
        this.manual15 = manual15;
    }
    public String getManual16() {
        return manual16;
    }
    public void setManual16(String manual16){
        this.manual16 = manual16;
    }
    public String getManual17() {
        return manual17;
    }
    public void setManual17(String manual17){
        this.manual17 = manual17;
    }
    public String getManual18() {
        return manual18;
    }
    public void setManual18(String manual18){
        this.manual18 = manual18;
    }
    public String getManual19() {
        return manual19;
    }
    public void setManual19(String manual19){
        this.manual19 = manual19;
    }
    public String getManual20() {
        return manual20;
    }
    public void setManual20(String manual20){
        this.manual20 = manual20;
    }
    public String getManual_img1(){return manual_img1;}
    public void setManual_img1(String manual_img1){ this.manual_img1 = manual_img1; }
    public String getManual_img2(){return manual_img2;}
    public void setManual_img2(String manual_img2){ this.manual_img2 = manual_img2; }
    public String getManual_img3(){return manual_img3;}
    public void setManual_img3(String manual_img3){ this.manual_img3 = manual_img3; }
    public String getManual_img4(){return manual_img4;}
    public void setManual_img4(String manual_img4){ this.manual_img4 = manual_img4; }
    public String getManual_img5(){return manual_img5;}
    public void setManual_img5(String manual_img5){ this.manual_img5 = manual_img5; }
    public String getManual_img6(){return manual_img6;}
    public void setManual_img6(String manual_img6){ this.manual_img6 = manual_img6; }
    public String getManual_img7(){return manual_img7;}
    public void setManual_img7(String manual_img7){ this.manual_img7 = manual_img7; }
    public String getManual_img8(){return manual_img8;}
    public void setManual_img8(String manual_img8){ this.manual_img8 = manual_img8; }
    public String getManual_img9(){return manual_img9;}
    public void setManual_img9(String manual_img9){ this.manual_img9 = manual_img9; }
    public String getManual_img10(){return manual_img10;}
    public void setManual_img10(String manual_img10){ this.manual_img10 = manual_img10; }
    public String getManual_img11(){return manual_img11;}
    public void setManual_img11(String manual_img11){ this.manual_img11 = manual_img11; }
    public String getManual_img12(){return manual_img12;}
    public void setManual_img12(String manual_img12){ this.manual_img2 = manual_img12; }
    public String getManual_img13(){return manual_img13;}
    public void setManual_img13(String manual_img13){ this.manual_img13 = manual_img13; }
    public String getManual_img14(){return manual_img14;}
    public void setManual_img14(String manual_img14){ this.manual_img14 = manual_img14; }
    public String getManual_img15(){return manual_img15;}
    public void setManual_img15(String manual_img15){ this.manual_img15 = manual_img15; }
    public String getManual_img16(){return manual_img16;}
    public void setManual_img16(String manual_img16){ this.manual_img16 = manual_img16; }
    public String getManual_img17(){return manual_img17;}
    public void setManual_img17(String manual_img17){ this.manual_img17 = manual_img17; }
    public String getManual_img18(){return manual_img18;}
    public void setManual_img18(String manual_img18){ this.manual_img18 = manual_img18; }
    public String getManual_img19(){return manual_img19;}
    public void setManual_img19(String manual_img19){ this.manual_img19 = manual_img19; }
    public String getManual_img20(){return manual_img20;}
    public void setManual_img20(String manual_img20){ this.manual_img20 = manual_img20; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(ingredients);
        dest.writeString(manual1);
        dest.writeString(manual2);
        dest.writeString(manual3);
        dest.writeString(manual4);
        dest.writeString(manual5);
        dest.writeString(manual6);
        dest.writeString(manual7);
        dest.writeString(manual8);
        dest.writeString(manual9);
        dest.writeString(manual10);
        dest.writeString(manual11);
        dest.writeString(manual12);
        dest.writeString(manual13);
        dest.writeString(manual14);
        dest.writeString(manual15);
        dest.writeString(manual16);
        dest.writeString(manual17);
        dest.writeString(manual18);
        dest.writeString(manual19);
        dest.writeString(manual20);

    }

    public void setBookmarked(boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }
    public boolean isBookmarked() {
        return isBookmarked;
    }

}

