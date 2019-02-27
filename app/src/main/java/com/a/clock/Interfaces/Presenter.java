package com.a.clock.Interfaces;

import java.util.ArrayList;

public interface Presenter {
    void bindView(View view);
    void unbindView();
    ArrayList<String> returnListForAdapter(ArrayList<String> namesList,ArrayList<String> timesList);
}
