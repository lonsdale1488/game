package com.company.managers;

import com.company.models.Expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpensesManager {
    private List<Expenses> expenses = new ArrayList<>();
    private static ExpensesManager expensesManagerSinglton = new ExpensesManager();


    private ExpensesManager() {

    }

    public List<Expenses> getExpenses() {
        return expenses;
    }

    public static ExpensesManager getInstance()
    {
        return expensesManagerSinglton;
    }
}
