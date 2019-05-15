package com.stupid.dalamsyah.lib.table;

import android.provider.BaseColumns;

public class DynamicTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DynamicTable() {}

    /* Inner class that defines the table contents */
    public static class Field implements BaseColumns {
        public static final String TABLE_NAME = "dynamic";
    }

}
