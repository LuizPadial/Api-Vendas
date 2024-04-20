package com.vendas.domain.services;

import com.vendas.domain.model.Order;
import com.vendas.domain.model.Seller;
import com.vendas.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class BusinessService {

    private final OrderRepository orderRepository;

    public Map<String, Object> getSellersSalesReport(LocalDate startDate, LocalDate endDate) {
        List<Order> orders = orderRepository.findByDateBetween(startDate, endDate);
        Map<String, Object> sellersReport = new HashMap<>();

        for (Order order : orders) {
            Seller seller = order.getSeller();
            String sellerName = seller.getName();
            double orderAmount = order.getPrice();

            if (sellersReport.containsKey(sellerName)) {
                Map<String, Object> sellerData = (Map<String, Object>) sellersReport.get(sellerName);
                double totalSales = (double) sellerData.getOrDefault("totalSales", 0.0);
                int numberOfOrders = (int) sellerData.getOrDefault("numberOfOrders", 0);

                totalSales += orderAmount;
                numberOfOrders++;

                sellerData.put("totalSales", totalSales);
                sellerData.put("numberOfOrders", numberOfOrders);
            } else {
                Map<String, Object> sellerData = new HashMap<>();
                sellerData.put("totalSales", orderAmount);
                sellerData.put("numberOfOrders", 1);
                sellersReport.put(sellerName, sellerData);
            }
        }

        for (Map.Entry<String, Object> entry : sellersReport.entrySet()) {
            Map<String, Object> sellerData = (Map<String, Object>) entry.getValue();
            double totalSales = (double) sellerData.get("totalSales");
            double averageDailySales = totalSales / (endDate.toEpochDay() - startDate.toEpochDay() + 1);

            sellerData.put("averageDailySales", averageDailySales);
        }

        return sellersReport;
    }


}
