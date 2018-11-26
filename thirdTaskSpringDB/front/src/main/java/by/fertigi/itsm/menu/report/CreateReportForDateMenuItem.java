package by.fertigi.itsm.menu.report;

import by.fertigi.itsm.entity.Message;
import by.fertigi.itsm.menu.IMenuItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
@ReportMenuItem
public class CreateReportForDateMenuItem implements IMenuItem {
    private AmqpTemplate amqpTemplate;

    @Autowired
    public CreateReportForDateMenuItem(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public String getTitle() {
        return "Create report for date";
    }

    @Override
    public int doAction() {
        System.out.println("Enter report start date: ");
        String startData = new Scanner(System.in).nextLine();
        System.out.println("Enter report end date: ");
        String endData = new Scanner(System.in).nextLine();
        String jsonReport = parseJson(startData, endData);
        Object queue = amqpTemplate.convertSendAndReceive("report", jsonReport);
        return 0;
    }

    private String parseJson(String startData, String endData){
        DateFormat formatter;
        Date startDate;
        Date endDate;
        Message message = null;
        String jsonReport = "";
        formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            startDate = formatter.parse(startData);
            endDate = formatter.parse(endData);
            message = new Message(startDate, endDate);
            jsonReport = new ObjectMapper().writeValueAsString(message);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonReport;
    }
}
