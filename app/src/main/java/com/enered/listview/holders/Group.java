package com.enered.listview.holders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 02.10.2016.
 */

public class Group {

    public String string;
    public final List<String> children = new ArrayList<String>();

    public Group(String string) {
        this.string = string;
    }

}
