package by.fertigi.itsm.report.listener;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.entity.Message;
import by.fertigi.itsm.report.mapper.TransactionMapper;
import by.fertigi.itsm.report.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@EnableRabbit
@Component
public class RabbitMqListener {
    private final ObjectMapper objectMapper;
    private final ReportService reportService;
    private final TransactionMapper mapper;

    @Autowired
    public RabbitMqListener(ObjectMapper objectMapper, ReportService reportService, TransactionMapper mapper) {
        this.objectMapper = objectMapper;
        this.reportService = reportService;
        this.mapper = mapper;
    }

    @RabbitListener(queues = "report", containerFactory="myRabbitListenerContainerFactory")
    public void processReport(String message) {
        System.out.println("Received from queue 1: " + message);
        try {
            Message objMessage = objectMapper.readValue(message, Message.class);
            System.out.println(objMessage);
            List<Transaction> transactions = mapper.getTransactions(objMessage.getStartDate(), objMessage.getEndDate());
            reportService.createReport(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
