package com.company.managers;

import com.company.models.Revenues;

import java.util.ArrayList;
import java.util.List;

public class RevenuesManager {
    private List<Revenues> revenues = new ArrayList<>();

    private static RevenuesManager revenuesManagersin = new RevenuesManager();

    private RevenuesManager() {

    }

    public static RevenuesManager getInstance()
    {
        return revenuesManagersin;
    }

    public List<Revenues> getRevenues() {
        return revenues;
    }
}
