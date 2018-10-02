package by.fertigi.itsm.service;

import by.fertigi.itsm.model.Transaction;

import java.util.List;

public interface ReportService {
    void createReport(List<Transaction> transactionList);
}
