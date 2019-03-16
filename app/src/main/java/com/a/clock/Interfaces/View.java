package com.a.clock.Interfaces;

import java.util.ArrayList;

public interface View {
    void setRecyclerView(ArrayList list1,ArrayList list2);

    void showDeleteDialog();

    void hideDeleteDialog();

    void refreshRecyclerViewAdapter();
}
