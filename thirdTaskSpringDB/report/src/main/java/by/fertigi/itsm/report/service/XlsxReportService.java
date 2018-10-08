package by.fertigi.itsm.report.service;

import by.fertigi.itsm.entity.Transaction;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class XlsxReportService implements ReportService {

    @Override
    public void createReport(List<Transaction> transactionList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("TransactionReport");

        createHeader(workbook, sheet);

        createBody(workbook, sheet, transactionList);

        saveReport(workbook);
    }

    private void createBody(Workbook workbook, Sheet sheet, List<Transaction> transactionList){
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        int i = 2;//line number of the beginning of the report
        int counter =  0;
        for (Transaction transaction : transactionList) {
            Row row = sheet.createRow(i);
            i++;

            Cell cell = row.createCell(0);
            cell.setCellValue(++counter);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            String patient = "Patient phone: " + transaction.getPatient().getPhone() + "\n" +
                    "Patient state: " + transaction.getPatient().getState().getName();
            cell.setCellValue(patient);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            String product = "Product name: " + transaction.getProduct().getName() + "\n" +
                    "Product state: " + transaction.getProduct().getState().getName();
            cell.setCellValue(product);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(getStrData(transaction.getDate()));
            cell.setCellStyle(style);
        }
    }

    private void createHeader(Workbook workbook, Sheet sheet){
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(1, 9000);
        sheet.setColumnWidth(2, 9000);
        sheet.setColumnWidth(3, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("№");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Patient");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Product");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Date");
        headerCell.setCellStyle(headerStyle);
    }

    private void saveReport(Workbook workbook){
        try {
            File file = new File("reports/" + "report-" + getStrDataNow() + ".xlsx");
            file.getParentFile().mkdirs(); // Will create parent directories if not exists
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file, false);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStrDataNow(){
        Date date = new Date();
        SimpleDateFormat frm = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
        String format = frm.format(date);
        return format;
    }


    private String getStrData(Date date) {
        SimpleDateFormat frm = new SimpleDateFormat("dd.MM.yyyy");
        String format = frm.format(date);
        return format;
    }
}
