package com.leodelmiro.hrpayroll.services;

import com.leodelmiro.hrpayroll.entities.Payment;
import com.leodelmiro.hrpayroll.entities.Worker;
import com.leodelmiro.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
