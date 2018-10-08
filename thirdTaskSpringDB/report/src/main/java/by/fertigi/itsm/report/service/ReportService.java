package by.fertigi.itsm.report.service;

import by.fertigi.itsm.entity.Transaction;

import java.util.List;

public interface ReportService {
    void createReport(List<Transaction> transactionList);
}
